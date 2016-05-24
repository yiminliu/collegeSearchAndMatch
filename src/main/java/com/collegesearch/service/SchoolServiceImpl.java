package com.collegesearch.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.SimpleExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.collegesearch.domain.school.BestSchoolMajor.MajorRankComparator;
import com.collegesearch.domain.school.ASchoolForBStudent;
import com.collegesearch.domain.school.BestSchoolMajor;
//import com.collegesearch.domain.school.PrincetonReviewGreatSchoolInPopularMajor;
import com.collegesearch.domain.school.Major;
import com.collegesearch.domain.school.School;
import com.collegesearch.domain.school.SchoolRankInSpeciality;
import com.collegesearch.dao.school.ASchoolForBStudentDao;
import com.collegesearch.dao.school.SchoolDao;
//import com.collegesearch.domain.school.BestSchoolMajor;
import com.collegesearch.dao.school.BestSchoolMajorDao;
//import com.collegesearch.dao.school.PrincetonReviewGreatSchoolMajorDao;
import com.collegesearch.dao.school.MajorDao;
import com.collegesearch.dao.school.SchoolRankInSpecialityDao;
//import com.collegesearch.dao.school.UsNewsBestSchoolProgramDao;
import com.collegesearch.exception.DatabaseOperationException;
import com.collegesearch.util.logger.aspect.LogLevel;
import com.collegesearch.util.logger.aspect.Loggable;
import com.collegesearch.util.school.SchoolUtil;

@Service("schoolService")
@Transactional
public class SchoolServiceImpl implements SchoolService {

	@Autowired
	SessionFactory sessionFactory;
	
    @Autowired
	SchoolDao schoolDao;   
    
    //@Autowired
    //UsNewsBestSchoolProgramDao usNewsBestSchoolProgramDao;
    
    @Autowired 
    MajorDao majorDao;
    
    @Autowired
    BestSchoolMajorDao bestSchoolMajorDao;
  
 
    @Autowired 
    ASchoolForBStudentDao aSchoolForBStudentDao;
    
    @Autowired
    SchoolRankInSpecialityDao schoolRankInSpecialityDao;
 
    Float los= 1.0f;
    
    @Loggable(value = LogLevel.TRACE)
	@Override
	@Transactional(readOnly=true)
	public List<School> getAllSchools(){
    	SimpleExpression expresion = Restrictions.ne("category","Art Schools");
    	return schoolDao.findAll(expresion);
	}
    
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
    
    /*
    @Loggable(value = LogLevel.TRACE)
    @Override
	@Transactional(readOnly=true)
	public List<Applicant> getSchoolsByMajor(String major) {
       List<Applicant> sList1 = this.getPrincetonReviewGreatSchoolMajor(major);
       if(major.equalsIgnoreCase("Business") || major.equalsIgnoreCase("Engineering")) {
    	  List<Applicant> sList2 = this.getUsNewsBestSchoolPrograms(major);
    	  Set<Applicant> setOfBoth = new HashSet<Applicant>(sList1);
    	  setOfBoth.addAll(sList2);
    	  sList1.clear();
    	  sList1.addAll(setOfBoth);
       }
       return sList1;
	}
    */
    @Loggable(value = LogLevel.TRACE)
    @Override
	@Transactional(readOnly=true)
	public List<School> getSchoolsBySpeciality(String speciality) {
    	List<SchoolRankInSpeciality> specialityList = schoolRankInSpecialityDao.getSchoolRankInSpecialityBySpeciality(speciality);
    	List<School> schoolList = new ArrayList<School>(specialityList.size());
    	for(SchoolRankInSpeciality srl : specialityList){
    		schoolList.add(srl.getSchool());
    	}
    	return schoolList;
	}
    	
	@Loggable(value = LogLevel.TRACE)
	@Override
	public List<School> getSchools(final LinkedHashMap<String, List<String>> queryParams){
		List<School> schools = null;
		try{
		    schools = schoolDao.getSchools(queryParams);
		}
		catch(HibernateException hbe){
		   if(hbe.getCause() != null)
		      throw new DatabaseOperationException("Error occured during getSchools(), due to: " +  hbe.getMessage() + ". Root cause -- " + hbe.getCause().getMessage(), hbe);	
	  	   else
	          throw new DatabaseOperationException("Error occured during getSchools(), due to: " +  hbe.getMessage());
		}
		catch(RuntimeException e){
			if(e.getCause() != null)
		  	   throw new DatabaseOperationException("Error occured during getSchools(), due to: " +  e.getMessage() + ". Root cause: " + e.getCause().getMessage(), e);	
		  	else
		  	   throw new DatabaseOperationException("Error occured during getSchools(), due to: " +  e.getMessage(), e);	
		}
		return schools;
	}
	
	@Loggable(value = LogLevel.TRACE)
	@Override
	public List<School> searchEngine(final LinkedHashMap<String, List<String>> queryParams){
		List<School> schools = getSchools(queryParams);
	    if(SchoolUtil.getValue(queryParams, "totalCost") != null)
		   schools = evaluateTotalCost(schools, queryParams);
		return schools;
	}
    
	@Loggable(value = LogLevel.TRACE)
	@Override
	public List<School> matchEngineInternational(LinkedHashMap<String, List<String>> queryParams){
		//if student doesn't have toefl/ielts score, just get schools with conditional admission
		if(SchoolUtil.getValue(queryParams, "randomApplicant.toeflScore") == null && SchoolUtil.getValue(queryParams, "randomApplicant.ieltsScore") == null){
		   queryParams.clear();
		   queryParams.put("internationalStudentApplication.conditionalAdmissionOffered", Arrays.asList(new String[]{"Yes"})); 
		 }
		//step 1: retrieve schools
		List<School> schools = getSchools(queryParams);
		if(SchoolUtil.applicantDataExist(queryParams)){
		   //step 2 evaluate student testing scores
		   schools = evaluateInternationalStudentScoresAgainstSchoolRequirements(schools, queryParams);
		   //step 3 evaluate "totalCost"
		   if(SchoolUtil.getValue(queryParams, "totalCost") != null)
		      schools = evaluateTotalCost(schools, queryParams);
		}
		if(SchoolUtil.getValue(queryParams, "maxResults") != null) {
		   int maxResults = Integer.valueOf(SchoolUtil.getValue(queryParams, "maxResults"));
		   if(maxResults > 0 && maxResults < schools.size())
		   	  schools = schools.subList(0, maxResults); 
		   }   
		return schools;
	}
	
	@Loggable(value = LogLevel.TRACE)
	@Override
	public List<School> matchEngineUS(final LinkedHashMap<String, List<String>> queryParams){
		//step 1: retrieve schools
		List<School> schools = getSchools(queryParams);
		if(SchoolUtil.applicantDataExist(queryParams)){
		   //step 2 evaluate student testing scores
		   schools = evaluateStudentScoresAgainstSchoolRequirements(schools, queryParams);
		   //step 3 evaluate "totalCost"
		   if(SchoolUtil.getValue(queryParams, "totalCost") != null)
		      schools = evaluateTotalCost(schools, queryParams);
		}
		if(SchoolUtil.getValue(queryParams, "maxResults") != null) {
		   int maxResults = Integer.valueOf(SchoolUtil.getValue(queryParams, "maxResults"));
		   if(maxResults > 0 && maxResults < schools.size())
		   	  schools = schools.subList(0, maxResults); 
		   }   
		return schools;
	}
	
	@Loggable(value = LogLevel.TRACE)
	@Override
	@Transactional(readOnly=true)
	public List<BestSchoolMajor> getBestSchoolMajors(String majorName){
		List<BestSchoolMajor> list = null;
		Session session = getSession();
		try{
		    Major major = majorDao.getMajorByName(majorName, session);
		    if(major != null)
		       list = bestSchoolMajorDao.getBestSchoolMajorsByMajorId(major.getId(), session);
		    Collections.sort(list,  new MajorRankComparator());
		}
		catch(HibernateException hbe){
		    if(hbe.getCause() != null)
		       throw new DatabaseOperationException("Error occured during getBestSchoolsOfMajor(), due to: " +  hbe.getMessage() + ". Root cause -- " + hbe.getCause().getMessage(), hbe);	
	  	    else
	           throw new DatabaseOperationException("Error occured during getBestSchoolsOfMajor(), due to: " +  hbe.getMessage());
		}
		catch(RuntimeException e){
		   if(e.getCause() != null)
		  	  throw new DatabaseOperationException("Error occured during getBestSchoolsOfMajor(), due to: " +  e.getMessage() + ". Root cause: " + e.getCause().getMessage(), e);	
		   else
		      throw new DatabaseOperationException("Error occured during getBestSchoolsOfMajor(), due to: " +  e.getMessage(), e);	
		}
		return list;
	}
	/*
	@Loggable(value = LogLevel.TRACE)
	@Override
	@Transactional(readOnly=true)
	public List<Applicant> getUsNewsBestSchoolPrograms(String programName){
		List<BestSchoolMajor> pList = null;
		List<Applicant> sList = null;
		Integer id = 0;
		if (programName.equalsIgnoreCase("Business"))
			id = 1;
		else if (programName.equalsIgnoreCase("Engineering"))
			id = 2;
		try{
		    pList = usNewsBestSchoolProgramDao.getUsNewsBestSchoolProgramsByProgramId(id);
		    sList = new ArrayList<Applicant>(pList.size());
	  	    for(BestSchoolMajor p : pList){
	  	    	//Applicant school = getSchoolById(p.getId().getSchoolId());
				//school.setRankOverall(p.getRank());
				//sList.add(school);
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
	*/
	/*
	@Loggable(value = LogLevel.TRACE)
	@Transactional(readOnly=true)
	private List<Applicant> getSchoolsForUsNewsBestSchoolPrograms(List<BestSchoolMajor> pList){
		
		List<Applicant> sList = new ArrayList<Applicant>(pList.size());
	  	for(BestSchoolMajor p : pList){
	  	    try {
	  	       // Applicant school = getSchoolById(p.getId().getSchoolId());
	  	       // school.setRankOverall(p.getRank());
				//sList.add(school);
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
	*/	
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
	
	@Loggable(value = LogLevel.TRACE)
	@Override
	@Transactional
	public List<School> getAllASchoolsForBStudents(){
		List<ASchoolForBStudent> origList = aSchoolForBStudentDao.getAllASchoolForBStudent();
		List<School> schools = new ArrayList<School>(origList.size());
		for(ASchoolForBStudent aSchool : origList){
			schools.add(aSchool.getSchool());
		}
		return schools;
	}
	
	/*************** Internally used utility methods *****************/
	protected synchronized Session getSession(){
		Session session = sessionFactory.getCurrentSession();
		if (session == null)
		   session = sessionFactory.openSession();
	    return session;
    }
		
	private List<School> evaluateStudentScoresAgainstSchoolRequirements(final List<School> oriSchoolList, final LinkedHashMap<String, List<String>> queryParams){
		List<School> finalSchoolList = new ArrayList<School>(oriSchoolList.size());
				
		/******** retrieve testing scores from user input ********/
		String studentSat1Score = SchoolUtil.getValue(queryParams, "sat1Score");
		String studentActScore = SchoolUtil.getValue(queryParams, "actScore");
		String studentToeflScore = SchoolUtil.getValue(queryParams, "toeflScore");
		String studentIeltsScore = SchoolUtil.getValue(queryParams, "ieltsScore");
		String gpa = SchoolUtil.getValue(queryParams, "gpa");
		
		/******** Walk through each school *********/
		for(School school : oriSchoolList){
			/******** step 1: evaluate SAT/ACT ********/
			if(studentSat1Score != null || studentActScore != null)
			   if(!evaluateSatOrAct(school, studentSat1Score != null? Integer.valueOf(studentSat1Score):0, studentActScore != null? Integer.valueOf(studentActScore):0))
			      continue;	
		 
	        /******** step 2: evaluate TOEFL/IELTS *******/
		    if(studentToeflScore != null || studentIeltsScore != null)
		       if(!eveluateToeflOrIelts(school, studentToeflScore != null? Integer.valueOf(studentToeflScore):0, studentIeltsScore))
		          continue;   
		    
		    /******** step 3: evaluate GPA *******/
		    if(gpa != null)
			   if(!eveluateGpa(school, gpa != null ? Float.parseFloat(gpa):0))
				  continue;
			
			finalSchoolList.add(school);	
		}
		return finalSchoolList;
	}
	
	private List<School> evaluateInternationalStudentScoresAgainstSchoolRequirements(final List<School> oriSchoolList, final LinkedHashMap<String, List<String>> queryParams){
		List<School> finalSchoolList = new ArrayList<School>(oriSchoolList.size());
		
	   	/******** retrieve testing scores from user input ********/
		String applicantToeflScore = SchoolUtil.getValue(queryParams, "randomApplicant.toeflScore");
		String applicantIeltsScore = SchoolUtil.getValue(queryParams, "randomApplicant.ieltsScore");
		String applicantGpa = SchoolUtil.getValue(queryParams, "randomApplicant.gpaScore");
		String applicantSat1ReadingScore = SchoolUtil.getValue(queryParams, "randomApplicant.sat1ReadingScore");
		String applicantSat1MathScore = SchoolUtil.getValue(queryParams, "randomApplicant.sat1MathScore");
		String applicantActReadingScore = SchoolUtil.getValue(queryParams, "randomApplicant.actReadingScore");
		String applicantActMathScore = SchoolUtil.getValue(queryParams, "randomApplicant.actMathScore");
		List<String> applicantSatSubjects = SchoolUtil.getListOfValues(queryParams, "randomApplicant.satSubjects");
		
		Integer applicantSat1Score = (applicantSat1ReadingScore != null? Integer.valueOf(applicantSat1ReadingScore) : 0) +
			                 (applicantSat1MathScore != null? Integer.valueOf(applicantSat1MathScore) : 0);
		Integer applicantActScore = (applicantActReadingScore != null? Integer.valueOf(applicantActReadingScore) : 0) +
					        (applicantActMathScore != null? Integer.valueOf(applicantActMathScore) : 0);
		Integer applicantNumberOfSatSubjects = applicantSatSubjects != null? applicantSatSubjects.size() : 0; 
		
		/******** Walk through each school *********/
		for(School school : oriSchoolList){
			/******** step 1: evaluate SAT/ACT ********/
			//if student doesn't have toefl/ielts score, just get shcools with conditional admissions, no need to evaluate sat/act
			if((applicantSat1Score != 0 || applicantActScore != null) && (applicantToeflScore != null || applicantIeltsScore != null))
			   if(!evaluateSatOrAct(school, applicantSat1Score, applicantActScore))
			      continue;	
		 
			/******** step 1: evaluate SAT2 ********/
			//if student doesn't have toefl/ielts score, just get shcools with conditional admissions, no need to evaluate sat/act
			if(!evaluateSat2(school, applicantNumberOfSatSubjects))
			      continue;	
		 
	        /******** step 2: evaluate TOEFL/IELTS *******/
		    if(applicantToeflScore != null || applicantIeltsScore != null)
		       if(!eveluateToeflOrIelts(school, applicantToeflScore != null? Integer.valueOf(applicantToeflScore):0, applicantIeltsScore))
		          continue;   
		    
		    /******** step 3: evaluate GPA *******/
		    if(applicantGpa != null)
			   if(!eveluateGpa(school, (applicantGpa == null) ? 0f : Float.parseFloat(applicantGpa)))
				  continue;
			
			finalSchoolList.add(school);	
		}
		return finalSchoolList;
	}
	
	/*
	 private List<School> evaluateInternationalStudentScoresAgainstSchoolRequirements(final List<School> oriSchoolList, final LinkedHashMap<String, List<String>> queryParams){
		List<School> finalSchoolList = new ArrayList<School>(oriSchoolList.size());
		
		Integer applicantSat1Score = null;//SchoolUtil.getValue(queryParams, "sat1Score");
		String applicantSat1ReadingScore = SchoolUtil.getValue(queryParams, "randomApplicant.sat1ReadingScore");
		String applicantSat1MathScore = SchoolUtil.getValue(queryParams, "randomApplicant.sat1MathScore");
		String applicantActScore = SchoolUtil.getValue(queryParams, "actScore");
		String applicanteflScore = SchoolUtil.getValue(queryParams, "toeflScore");
		String applicantIeltsScore = SchoolUtil.getValue(queryParams, "ieltsScore");
		String gpa = SchoolUtil.getValue(queryParams, "gpaScore");
				
		applicantSat1Score = applicantSat1ReadingScore != null? Integer.valueOf(applicantSat1ReadingScore) : 0 +
			                 applicantSat1MathScore != null? Integer.valueOf(applicantSat1MathScore) : 0;
			for(School school : oriSchoolList){
			//if student doesn't have toefl/ielts score, just get shcools with conditional admissions, no need to evaluate sat/act
			if((applicantSat1Score != null || studentActScore != null) && (studentToeflScore != null || studentIeltsScore != null))
			   if(!evaluateSatOrAct(school, studentSat1Score != null? Integer.valueOf(studentSat1Score):0, studentActScore != null? Integer.valueOf(studentActScore):0))
			      continue;	
		 
	        if(studentToeflScore != null || studentIeltsScore != null)
		       if(!eveluateToeflOrIelts(school, studentToeflScore != null? Integer.valueOf(studentToeflScore):0, studentIeltsScore))
		          continue;   
		    
		    if(gpa != null)
			   if(!eveluateGpa(school, (gpa == null) ? 0f : Float.parseFloat(gpa)))
				  continue;
			
			finalSchoolList.add(school);	
		}
		return finalSchoolList;
	}
	*/
	
	private boolean evaluateSatOrAct(School school, int applicantSat1Score, int applicantActScore){
	   int score = 0; 	
	   ///// direct compare /////
	   //case 1: student sat1 != null && school sat1 != null
	   if(applicantSat1Score != 0 && school.getSat1Percentile25() != null && school.getSat1Percentile25() != 0){
	     if(SchoolUtil.isTestScoreSatisfied(applicantSat1Score, school.getSat1Percentile25(), school.getSat1Percentile75(), school.getAcceptRate()))
		     return true;
	   }   
	   //case 2: student act != null && school act != null
	   else if(applicantActScore != 0 && school.getActPercentile25() != null && school.getActPercentile25() != 0){
		   if(SchoolUtil.isTestScoreSatisfied(applicantActScore, school.getActPercentile25(), school.getActPercentile75(), school.getAcceptRate()))
		      return true;
	   }
	   ///// indirect compare /////
	   //case 3: student sat1 != null && student act == null && school sat1 == null && school act != null
	   else if((applicantSat1Score != 0 && applicantActScore == 0) && 
		  (school.getSat1Percentile25() == null || school.getSat1Percentile25() == 0) &&
		  (school.getActPercentile25() != null && school.getActPercentile25() != 0)){
		   score = SchoolUtil.convertSatToAct(applicantSat1Score);
		   if(SchoolUtil.isTestScoreSatisfied(score, school.getActPercentile25(), school.getActPercentile75(), school.getAcceptRate()))
			  return true;
	   }   
	   //case 4: student sat1 == null && student act != null && school sat1 != null && school act == null
	   else if((applicantSat1Score == 0 && applicantActScore != 0) && 
	      (school.getSat1Percentile25() != null && school.getSat1Percentile25() != 0) &&
	      (school.getActPercentile25() == null || school.getActPercentile25() == 0)){
		   score = SchoolUtil.convertSatToAct(applicantActScore);
		   if(SchoolUtil.isTestScoreSatisfied(score, school.getSat1Percentile25(), school.getSat1Percentile75(), school.getAcceptRate()))
		      return true;
	   } 
	   //case 5: student has neither sat nor act
	   else if(school.getInternationalStudentApplication() != null && 
			   "Yes".equalsIgnoreCase(school.getInternationalStudentApplication().getToeflAcceptedInsteadOfSatOrAct())){
		   return true;
	   }
	   return false;
    }
	
	private List<School> evaluateSatOrAct(List<School> oriSchoolList, String sat1Score, String actScore){
		int score = 0;
		Float acceptRate = null;
		List<School> adjustedSchoolList = new ArrayList<School>(oriSchoolList.size());
		//check SAT1 score first
		if(sat1Score != null && sat1Score.length() > 0 && !sat1Score.equals("0")){
		   score = Integer.valueOf(sat1Score);
		   //adjustedSchoolList = new ArrayList<Applicant>(oriSchoolList.size());
		   for(School school : oriSchoolList){
			   if(SchoolUtil.isTestScoreSatisfied(score, school.getSat1Percentile25(), school.getSat1Percentile75(), school.getAcceptRate()))
				  adjustedSchoolList.add(school);
		   } 
		} 
		//if SAT1 score is not present, check ACT score
		else if(actScore != null && actScore.length() > 0 && !actScore.equals("0")){
			 score = Integer.valueOf(actScore);
			 //adjustedSchoolList = new ArrayList<Applicant>(oriSchoolList.size());
			 for(School school : oriSchoolList){
				 acceptRate = school.getAcceptRate();
				 if(acceptRate == null)
					 acceptRate = 100f; 
				 if(school.getActPercentile25() != null && school.getActPercentile25() != 0){
			        if(SchoolUtil.isTestScoreSatisfied(score, school.getActPercentile25(), school.getActPercentile75(), acceptRate))
			           adjustedSchoolList.add(school);
				 }
				 else if(school.getSat1Percentile25() != null && school.getSat1Percentile75() != null){
					int satScore = SchoolUtil.convertActToSat(score);
				    if(SchoolUtil.isTestScoreSatisfied(satScore, school.getSat1Percentile25(), school.getSat1Percentile75(), acceptRate))
				       adjustedSchoolList.add(school);
				 }					 
			 }
		}		
		if(adjustedSchoolList != null)
		   return adjustedSchoolList;
		else
		   return oriSchoolList;
	}
	
	/******** step 1: evaluate SAT2 ********/
	private boolean evaluateSat2(School school, int applicantNumberOfSatSubjects){
	   //case 1: compare the number of sat subjects
	   if(applicantNumberOfSatSubjects >= school.getNumberOfRequiredSat2())
	      return true;  
	   else
		  return false; 
	}
	
	//use cases: 
	//1. student' Toefl <==> school average Toefl;  
	//2. student' Toefl <==> school minimum Toefl
	//3. student' Ielts <==> school average Ieltsl; 
	//4. student' Ielts <==> school minimum Ielts
	//5. student' Ielts <==> school average Toefl;  
	//6. student' Ielts <==> school minimum Toefl
	private boolean eveluateToeflOrIelts(School school, int studentToeflScore, String studentIeltsScore){
		int score = 0;
		float studentIeltsScoreFloat = 0f;
		
		int minToefl = 0;
		int avgToefl = 0;
		float minIelts = 0f;
		float avgIelts = 0f;
		
		if(school.getInternationalStudentApplication().getMinimumToeflScore() != null)
		   minToefl = school.getInternationalStudentApplication().getMinimumToeflScore();
		if(school.getInternationalStudentApplication().getAverageToeflScore() != null)
		   avgToefl = school.getInternationalStudentApplication().getAverageToeflScore();
		if(school.getInternationalStudentApplication().getMinimumIeltsScore() != null)
		   minIelts = school.getInternationalStudentApplication().getMinimumIeltsScore();
		if(school.getInternationalStudentApplication().getAverageIeltsScore() != null)
		   avgIelts = school.getInternationalStudentApplication().getAverageIeltsScore(); 
				
		if(studentIeltsScore != null)
		   studentIeltsScoreFloat = Float.valueOf(studentIeltsScore);
		
		//Direct evaluation
		//case 1: both student's Toefl score and school's toefl requirements present
		if(studentToeflScore > 0 && (avgToefl > 0 || minToefl > 0)){ 
		   //school's average Toefl requirements present
		   if(avgToefl > 0 && studentToeflScore > avgToefl){
		      school.setLikelihoodOfSuccess(((studentToeflScore-avgToefl)*1.0f/avgToefl)*1.1f);
		      return true;
		   }
		   //only school's minimum Toefl requirement presents   
		   else if(minToefl > 0 && studentToeflScore > minToefl){
		      school.setLikelihoodOfSuccess(((studentToeflScore-minToefl)*1.0f/minToefl)*1.0f);
		      return true;
		   }
		}  
	    //case 2: both student's Ielts score presents and school's Ielts requirements present
		else if(studentIeltsScoreFloat > 0 && (avgIelts > 0 || minIelts > 0)){
		     //school's average Ielts requirement presents 
		     if(avgIelts > 0 && studentIeltsScoreFloat >= avgIelts){
			    school.setLikelihoodOfSuccess(((studentIeltsScoreFloat-avgIelts)/avgIelts)*1.1f);
		        return true;
			 }
			 //school's minimum Ielts requirement presents
			 else if(minIelts > 0 && studentIeltsScoreFloat >= minIelts){
			    school.setLikelihoodOfSuccess(((studentIeltsScoreFloat-minIelts)/minIelts)*1.0f);
			    return true;
			 }	
		}     
		//Indirect evaluation    
		//case 3: student's Toefl score presents and school's toefl requirements not present but school's Ielts requirements present
		//therefore, need to convert student's toefl to Ielts
		else if(studentToeflScore > 0 && (minIelts > 0 || avgIelts > 0)){
			studentIeltsScoreFloat = SchoolUtil.convertToeflToIelts(studentToeflScore);	
			//school's average Ielts requirement presents
			if(avgIelts > 0 && studentIeltsScoreFloat >= avgIelts){
			   school.setLikelihoodOfSuccess(((studentIeltsScoreFloat-avgIelts)/avgIelts)*1.1f);
			   return true;
			}
			//school's minimum Ielts requirement presents   
			else if(minIelts > 0 && studentIeltsScoreFloat >= minIelts){
			   school.setLikelihoodOfSuccess(((studentIeltsScoreFloat-minIelts)/minIelts)*1.0f);
			   return true;
			}
		}
		//case 4:Ielts score presents and school's Ielts not requirements present, but school's toefl requirements present     
		else if(studentIeltsScoreFloat > 0 && (minToefl > 0 || avgToefl > 0)){
			score = SchoolUtil.convertIeltsToToefl(studentIeltsScore);
			//school's average Toefl requirement presents
			if(avgToefl > 0 && score >= avgToefl){
			   school.setLikelihoodOfSuccess(((score-avgToefl)/avgToefl)*1.1f);
			   return true;
			}
			//school's minimal Toefl requirement presents   
			else if(minToefl > 0 && score >= minToefl){
			   school.setLikelihoodOfSuccess(((score-minToefl)/minToefl)*1.0f);
			   return true;
			}
		}			  
		return false;
	}
	
	//use cases: 
	//1. student' Toefl <==> school average Toefl;  2. student' Toefl <==> school minimum Toefl
	//3. student' Ielts <==> school average Ieltsl; 4. student' Ielts <==> school minimum Ielts
	//5. student' Ielts <==> school average Toefl;  6. student' Ielts <==> school minimum Toefl
	private List<School> eveluateToeflAndIeltsScores(List<School> oriSchoolList, String studentToeflScore, String studentIeltsScore){
		int score = 0;
		Integer minToefl = null;
		Integer avgToefl = null;
		Integer minIelts = null;
		Integer avgIelts = null;
		List<School> adjustedSchoolList = null;
		//if students's Toefl or Ielts scores present, go ahead
		if((studentToeflScore != null && studentToeflScore.length() > 0 && !studentToeflScore.equals("0")) ||
			studentIeltsScore != null && studentIeltsScore.length() > 0 && !studentIeltsScore.equals("0")){
		    adjustedSchoolList = new ArrayList<School>(oriSchoolList.size());
		    for(School school : oriSchoolList){
			    minToefl = school.getInternationalStudentApplication().getMinimumToeflScore();
			    avgToefl = school.getInternationalStudentApplication().getAverageToeflScore();
			    minIelts = 0;//school.getInternationalStudentApplication().getMinimumIeltsScore();
			    avgIelts = 0;//school.getInternationalStudentApplication().getAverageIeltsScore(); 
		
			    //student's Toefl score presents		   
			    if(studentToeflScore != null && studentToeflScore.length() > 0 && !studentToeflScore.equals("0")){ 
			       score = Integer.parseInt(studentToeflScore);  
			       //school's average Toefl requirements present
			       if(avgToefl != null && avgToefl > 0 && score > avgToefl){
			          school.setLikelihoodOfSuccess(((score-avgToefl)*1.0f/avgToefl)*1.1f);
				      adjustedSchoolList.add(school);
			       }
			       //only school's minimum Toefl requirement presents   
			       else if(minToefl != null && minToefl > 0 && score > minToefl){
				      school.setLikelihoodOfSuccess(((score-minToefl)*1.0f/minToefl)*1.0f);
				      adjustedSchoolList.add(school);
			       }
			   }  
		
			   //student's Toefl score not present but Ielts score presents
			   else if(studentIeltsScore != null && studentIeltsScore.length() > 0 && !studentIeltsScore.equals("0")){
				     score = Integer.parseInt(studentIeltsScore);  
				     //case 1. school's average Ielts requirement presents 
				     if(avgIelts != null && avgIelts > 0 && score >= avgIelts){
					    school.setLikelihoodOfSuccess(((score-avgIelts)/avgIelts)*1.1f);
					    adjustedSchoolList.add(school);
				     }
				     //case 2. school's minimum Ielts requirement presents
				     else if(minIelts != null && minIelts > 0 && score >= minIelts){
					    school.setLikelihoodOfSuccess(((score-minIelts)/minIelts)*1.0f);
					    adjustedSchoolList.add(school);
				     }		
				     //case 3. school's Ielts requirement not presents, nut average Toefl requirement presents
				     else if(avgToefl != null && avgToefl > 0 && score >= avgToefl){
				    	 score = SchoolUtil.convertIeltsToToefl(studentIeltsScore);
				         school.setLikelihoodOfSuccess(((score-avgToefl)/avgToefl)*1.1f);
					     adjustedSchoolList.add(school);
				      }
				      //case 4. school's Ielts requirement not presents, nut minimal Toefl requirement presents   
				      else if(minToefl != null && minToefl > 0 && score >= minToefl){
					     school.setLikelihoodOfSuccess(((score-minToefl)/minToefl)*1.0f);
					     adjustedSchoolList.add(school);
				      }
			   }			  
		    } 
		}
		return adjustedSchoolList;
	}
	
	private boolean eveluateGpa(School school, float studentGpa){
	   if(school.getAverageGpa() != null && school.getAverageGpa() <= studentGpa){
		   los += ((studentGpa-school.getAverageGpa())/school.getAverageGpa())*100.0f;
		   return true;
	   }	  
	   else
		  return false;
	}
	
	private List<School> evaluateTotalCost(final List<School> oriSchoolList, final LinkedHashMap<String, List<String>> queryParams){
		   int totalCostInt = -1;	
		   String totalCost = SchoolUtil.getValue(queryParams, "totalCost");
		   if(totalCost != null && !totalCost.equals("0")) {
		      totalCostInt = Integer.valueOf(totalCost.substring(1));
	   		  ArrayList<School> finalSchoolList = new ArrayList<School>();
			  for(School school : oriSchoolList){
			 	  if(school.getTuitionFee() != null && school.getRoomBoard() != null && (school.getTuitionFee() + school.getRoomBoard()) < totalCostInt)
			 		 finalSchoolList.add(school);
			   }
			   return finalSchoolList;
		   }  
		   else
			   return oriSchoolList;
	}
	
	private List<School> evaluateTotalCost(List<School> oriSchoolList, int totalCost){
		ArrayList<School> finalSchoolList = new ArrayList<School>();
		for(School school : oriSchoolList){
			if(school.getTuitionFee() != null && school.getRoomBoard() != null && 
			  (school.getTuitionFee() + school.getRoomBoard()) < totalCost)
				finalSchoolList.add(school);
		}
		return finalSchoolList;
	}

}
