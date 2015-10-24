package com.collegesearch.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.collegesearch.domain.school.PrincetonReviewGreatSchoolMajor;
import com.collegesearch.domain.school.PrincetonReviewPopularMajor;
import com.collegesearch.domain.school.School;
import com.collegesearch.domain.school.UsNewsBestSchoolProgram;
import com.collegesearch.dao.school.PrincetonReviewGreatSchoolMajorDao;
import com.collegesearch.dao.school.PrincetonReviewPopularMajorDao;
import com.collegesearch.dao.school.SchoolDao;
import com.collegesearch.dao.school.UsNewsBestSchoolProgramDao;
import com.collegesearch.exception.DataNotFoundException;
import com.collegesearch.exception.DatabaseOperationException;
import com.collegesearch.util.logger.aspect.LogLevel;
import com.collegesearch.util.logger.aspect.Loggable;
import com.collegesearch.util.school.SchoolUtil;

@Service("SchoolService")
@Transactional
public class SchoolServiceImpl implements SchoolService {

	@Autowired
	SessionFactory sessionFactory;
	
    @Autowired
	SchoolDao schoolDao;   
    
    @Autowired
    UsNewsBestSchoolProgramDao usNewsBestSchoolProgramDao;
    
    @Autowired 
    PrincetonReviewPopularMajorDao princetonReviewPopularMajorDao;
 
    @Autowired 
    PrincetonReviewGreatSchoolMajorDao princetonReviewGreatSchoolMajorDao;
 
    @Loggable(value = LogLevel.TRACE)
    @Override
	@Transactional(readOnly=true)
	public School getSchoolById(Integer id) {
    	return schoolDao.findById(id);
	}
    
    @Loggable(value = LogLevel.TRACE)
    @Override
	//@Transactional(readOnly=true)
	public School getSchoolById(Integer id, Session session) {
    	return schoolDao.findById(id, session);
	}
    
    @Loggable(value = LogLevel.TRACE)
    @Override
	@Transactional(readOnly=true)
	public School getSchoolByName(String name) {
    	return schoolDao.getSchoolByName(name);
	}
    
    @Loggable(value = LogLevel.TRACE)
    @Override
	@Transactional(readOnly=true)
    public List<School> getSchoolsByMatchNamePattern(String name){
    	return schoolDao.getSchoolsByMatchNamePattern(name);
    }
    
    @Loggable(value = LogLevel.TRACE)
    @Override
	@Transactional(readOnly=true)
	public List<School> getSchoolsByMajor(String major) {
    	List<School> sList1 = this.getPrincetonReviewGreatSchoolMajor(major);
    	if(major.equalsIgnoreCase("Business") || major.equalsIgnoreCase("Engineering")) {
    		List<School> sList2 = this.getUsNewsBestSchoolPrograms(major);
    	    Set<School> setboth = new HashSet<School>(sList1);
    	    setboth.addAll(sList2);
    	    sList1.clear();
    	    sList1.addAll(setboth);
    	}
    	return sList1;
	}
    
    @Loggable(value = LogLevel.TRACE)
	@Override
	@Transactional(readOnly=true)
	public List<School> getAllSchools(){
		return schoolDao.findAll();
	}
    
   // @Loggable(value = LogLevel.TRACE)
	//@Override
	//@Transactional(readOnly=true)
    //public List<School> getSchoolsByDescription(String description){
    //	return (List<School>)SchoolDao.getSchoolsByDiscriptionPatternMatch(description);
    //}
	
	@Loggable(value = LogLevel.TRACE)
	@Override
	public List<School> getSchools(final LinkedHashMap<String, List<String>> queryParams){
		List<School> schools = null;
		try{
		    schools = schoolDao.getSchools(queryParams);
		}
		catch(HibernateException hbe){
		   if(hbe.getCause() != null)
		      throw new DatabaseOperationException("Error occured during getItems(), due to: " +  hbe.getMessage() + ". Root cause -- " + hbe.getCause().getMessage(), hbe);	
	  	   else
	          throw new DatabaseOperationException("Error occured during getItems(), due to: " +  hbe.getMessage());
		}
		catch(RuntimeException e){
			if(e.getCause() != null)
		  	   throw new DatabaseOperationException("Error occured during getItems(), due to: " +  e.getMessage() + ". Root cause: " + e.getCause().getMessage(), e);	
		  	else
		  	   throw new DatabaseOperationException("Error occured during getItems(), due to: " +  e.getMessage(), e);	
		}
		if(SchoolUtil.getValue(queryParams, "maxResults") != null) {
		   int maxResults = Integer.valueOf(SchoolUtil.getValue(queryParams, "maxResults"));
		   if(maxResults > 0 && maxResults < schools.size())
			  	 schools = schools.subList(0, maxResults); 
		}   
		if(SchoolUtil.getValue(queryParams, "totalCost") != null) {
		   String totalCost = SchoolUtil.getValue(queryParams, "totalCost");
		   int totalCostInt = -1;
		   if(totalCost != null && totalCost.length()>0)
		      totalCostInt = Integer.valueOf(totalCost.substring(1));
		   schools = filterByTotalCost(schools, totalCostInt);
		}   
		
		if(SchoolUtil.applicantDataExist(queryParams))
		   return doMatch( schools, queryParams);	
	
		return schools;
	}
	
	private List<School> doMatch(List<School> oriSchoolList, final LinkedHashMap<String, List<String>> queryParams){
		List<School> finalSchoolList = null;
		String sat1Score = SchoolUtil.getValue(queryParams, "sat1Score");
		String actScore = SchoolUtil.getValue(queryParams, "actScore");
		if(sat1Score != null || actScore != null)
			finalSchoolList = matchSatOrAct(oriSchoolList, sat1Score, actScore);	
		else
			finalSchoolList = oriSchoolList;
		
		//String toeflScore = SchoolUtil.getValue(queryParams, "toefl");
		//if(toeflScore != null && toeflScore.length() > 0 && !toeflScore.equals("0"))
		//	finalSchoolList = matchSatOrAct(oriSchoolList, sat1Score, actScore);	
		/*String ieltsScore = SchoolUtil.getValue(queryParams, "ieltsScore");
		if(toeflScore != null || ieltsScore != null)
			finalSchools = matchToeflOrIelts(finalSchools, toeflScore, ieltsScore);
		
		String gpa = SchoolUtil.getValue(queryParams, "gpa");
		if(gpa != null)
			finalSchools = matchGPA(finalSchools, gpa);
		*/	
		return finalSchoolList;
	}
	
	private List<School> matchSatOrAct(List<School> oriSchoolList, String sat1Score, String actScore){
		int score = 0;
		List<School> adjustedSchoolList = null;
		//check SAT1 score first
		if(sat1Score != null && sat1Score.length() > 0 && !sat1Score.equals("0")){
		   score = Integer.parseInt(sat1Score);
		   adjustedSchoolList = new ArrayList<School>(oriSchoolList.size());
		   for(School school : oriSchoolList){
			   if(SchoolUtil.isTestScoreSatisfied(score, school.getSat1Percentile25(), school.getSat1Percentile75(), school.getAcceptRate()))
				   adjustedSchoolList.add(school);
		   } 
		} 
		//if SAT1 score is not present, check ACT score
		else if(actScore != null && actScore.length() > 0 && !actScore.equals("0")){
			 score = Integer.parseInt(actScore);
			 adjustedSchoolList = new ArrayList<School>(oriSchoolList.size());
			 for(School school : oriSchoolList){
				 if(school.getActPercentile25() != null && school.getActPercentile25() != 0){
			        if(SchoolUtil.isTestScoreSatisfied(score, school.getActPercentile25(), school.getActPercentile75(), school.getAcceptRate()))
			        	adjustedSchoolList.add(school);
				 }
				 else {
					int satScore = SchoolUtil.convertActToSat(score);
				    if(SchoolUtil.isTestScoreSatisfied(satScore, school.getSat1Percentile25(), school.getSat1Percentile75(), school.getAcceptRate()))
				    	adjustedSchoolList.add(school);
				 }
					 
			 }
		}		
		if(adjustedSchoolList != null)
		   return adjustedSchoolList;
		else
		   return oriSchoolList;
	}
	
	private List<School> filterByTotalCost(List<School> oriSchoolList, int totalCost){
		ArrayList<School> finalSchoolList = new ArrayList<School>();
		for(School school : oriSchoolList){
			if(school.getTuitionFee() != null && school.getRoomBoard() != null && 
			  (school.getTuitionFee() + school.getRoomBoard()) < totalCost)
				finalSchoolList.add(school);
		}
		return finalSchoolList;
	}
	
	@Loggable(value = LogLevel.TRACE)
	@Override
	@Transactional(readOnly=true)
	public List<School> getPrincetonReviewGreatSchoolMajor(String majorName){
		List<PrincetonReviewGreatSchoolMajor> pList = null;
		List<School> sList = null;
		Session session = getSession();
		try{
		    PrincetonReviewPopularMajor major = princetonReviewPopularMajorDao.getPrincetonReviewPopularMajorByName(majorName, session);
		    if(major != null){
		       pList = princetonReviewGreatSchoolMajorDao.getPrincetonReviewGreatSchoolMajorsByMajorId(major.getId(), session);
		       sList = new ArrayList<School>(pList.size());
	  	       for(PrincetonReviewGreatSchoolMajor m : pList){
	  	   	       School school = getSchoolById(m.getId().getSchoolId(), session);
			       sList.add(school);
	  	       }    
	 	    }  
		}
		catch(HibernateException hbe){
		    if(hbe.getCause() != null)
		       throw new DatabaseOperationException("Error occured during getItems(), due to: " +  hbe.getMessage() + ". Root cause -- " + hbe.getCause().getMessage(), hbe);	
	  	    else
	           throw new DatabaseOperationException("Error occured during getItems(), due to: " +  hbe.getMessage());
		}
		catch(RuntimeException e){
		   if(e.getCause() != null)
		  	  throw new DatabaseOperationException("Error occured during getItems(), due to: " +  e.getMessage() + ". Root cause: " + e.getCause().getMessage(), e);	
		   else
		      throw new DatabaseOperationException("Error occured during getItems(), due to: " +  e.getMessage(), e);	
		}
		return sList;
	}
	
	@Loggable(value = LogLevel.TRACE)
	@Override
	@Transactional(readOnly=true)
	public List<School> getUsNewsBestSchoolPrograms(String programName){
		List<UsNewsBestSchoolProgram> pList = null;
		List<School> sList = null;
		Session session;
		Integer id = 0;
		if (programName.equalsIgnoreCase("Business"))
			id = 1;
		else if (programName.equalsIgnoreCase("Engineering"))
			id = 2;
		try{
		    pList = usNewsBestSchoolProgramDao.getUsNewsBestSchoolProgramsByProgramId(id);
		    sList = new ArrayList<School>(pList.size());
	  	    for(UsNewsBestSchoolProgram p : pList){
	  	    	School school = getSchoolById(p.getId().getSchoolId());
				school.setRankOverall(p.getRank());
				sList.add(school);
	 	    }  
	 	}
		catch(HibernateException hbe){
		   if(hbe.getCause() != null)
		      throw new DatabaseOperationException("Error occured during getItems(), due to: " +  hbe.getMessage() + ". Root cause -- " + hbe.getCause().getMessage(), hbe);	
	  	   else
	          throw new DatabaseOperationException("Error occured during getItems(), due to: " +  hbe.getMessage());
		}
		catch(RuntimeException e){
			if(e.getCause() != null)
		  	   throw new DatabaseOperationException("Error occured during getItems(), due to: " +  e.getMessage() + ". Root cause: " + e.getCause().getMessage(), e);	
		  	else
		  	   throw new DatabaseOperationException("Error occured during getItems(), due to: " +  e.getMessage(), e);	
		}
		sList = getSchoolsForUsNewsBestSchoolPrograms(pList);
		return sList;
	}
	
	@Loggable(value = LogLevel.TRACE)
	@Transactional(readOnly=true)
	private List<School> getSchoolsForUsNewsBestSchoolPrograms(List<UsNewsBestSchoolProgram> pList){
		
		List<School> sList = new ArrayList<School>(pList.size());
	  	for(UsNewsBestSchoolProgram p : pList){
	  	    try {
	  	        School school = getSchoolById(p.getId().getSchoolId());
	  	        school.setRankOverall(p.getRank());
				sList.add(school);
		    }
			catch(HibernateException hbe){
			   if(hbe.getCause() != null)
			      throw new DatabaseOperationException("Error occured during getItems(), due to: " +  hbe.getMessage() + ". Root cause -- " + hbe.getCause().getMessage(), hbe);	
		  	   else
		          throw new DatabaseOperationException("Error occured during getItems(), due to: " +  hbe.getMessage());
			}
			catch(RuntimeException e){
				if(e.getCause() != null)
			  	   throw new DatabaseOperationException("Error occured during getItems(), due to: " +  e.getMessage() + ". Root cause: " + e.getCause().getMessage(), e);	
			  	else
			  	   throw new DatabaseOperationException("Error occured during getItems(), due to: " +  e.getMessage(), e);	
			}
	    }   
	    return sList;
	}
		
	@Loggable(value = LogLevel.TRACE)
	@Override
	@Transactional
	public Integer createSchool(School School){
		return schoolDao.createSchool(School); 
	}
	
	@Loggable(value = LogLevel.TRACE)
	@Override
	@Transactional
	public School updateSchool(School school){
		School retrievedSchool = null;
		try{
		   //retrievedSchool = schoolDao.getSchoolByName(getSession(), school.getName());
		   //if(retrievedSchool == null)
			//  throw new DataNotFoundException("No school found with name: " + school.getName()); 
			schoolDao.updateSchool(getSession(), school); 
			return school;
		}
		catch(Exception e){
			throw e;
			
		}
	
	}	
	
	@Loggable(value = LogLevel.TRACE)
	@Override
	@Transactional
	public void deleteSchool(School school){
		schoolDao.deleteSchool(school); 
	}	
	
	protected synchronized Session getSession(){
		Session session = sessionFactory.getCurrentSession();
		if (session == null)
		   session = sessionFactory.openSession();
	    return session;
    }
	
	/*
	private List<School> filterResultByTestScore(final LinkedHashMap<String, List<String>> queryParams, List<School> schools, String nameOfTest) {
		List<School> schoolsAdjustedByTestScore = null;
		int sat1Score = 0;
		String data = SchoolUtil.getValue(queryParams, nameOfTest);
		if(data != null && data.length() > 0)
		   sat1Score = Integer.parseInt(data);
		if(sat1Score > 0) {
		   schoolsAdjustedByTestScore = new ArrayList<School>(schools.size());
		   for(School school : schools){
			   if(SchoolUtil.isTestScoreSatisfied(sat1Score, school.getSat1Percentile25(), school.getSat1Percentile75(), school.getAcceptRate(), 1))
			      schoolsAdjustedByTestScore.add(school);
		   } 
		}
		return  schoolsAdjustedByTestScore;
	}
	
	private List<School> filterResultByToefl(final LinkedHashMap<String, List<String>> queryParams, List<School> schools) {
		List<School> schoolsAdjusted = null;
		int toeflScore = 0;
		String data = SchoolUtil.getValue(queryParams, "toefl");
		if(data != null && data.length() > 0)
			toeflScore = Integer.parseInt(data);
		if(toeflScore > 0) {
		   schoolsAdjusted = new ArrayList<School>(schools.size());
		   for(School school : schools){
			   if(school.getToefl() > 0)
			      schoolsAdjusted.add(school);
		   } 
		}
		return  schoolsAdjusted;
	}
	*/
}
