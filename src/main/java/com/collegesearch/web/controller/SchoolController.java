package com.collegesearch.web.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.collegesearch.domain.school.School;
import com.collegesearch.domain.school.BestSchoolMajor;
import com.collegesearch.domain.school.School.RankComparator;
import com.collegesearch.domain.school.School.RankByCategoryComparator;
import com.collegesearch.domain.school.School.AcceptanceRateComparator;
import com.collegesearch.domain.school.School.SpecialityRankComparator;
import com.collegesearch.domain.school.School.TotalCostComparator;
import com.collegesearch.domain.school.School.ToeflComparator;
import com.collegesearch.domain.school.School.SatComparator;
import com.collegesearch.domain.school.School.GpaComparator;
import com.collegesearch.domain.school.enums.States;
import com.collegesearch.domain.school.enums.PopularMajors;
import com.collegesearch.domain.school.enums.SchoolCategories;
import com.collegesearch.exception.DataNotFoundException;
import com.collegesearch.exception.DatabaseOperationException;
import com.collegesearch.exception.InputParamException;
import com.collegesearch.service.SchoolService;
import com.collegesearch.util.school.SchoolUtil;

/**
* This MVC controller class takes all school search-related requests and dispatches the requests to corresponding services to fulfill database CRUD operations on schools.
* This class handles all requests rooted with "/school".
*
*/

@Controller
@Scope("session")
@RequestMapping("/school")
@SessionAttributes({"school", "school"})

public class SchoolController {

	@Autowired
	private SchoolService schoolService;
	       
	//@Autowired
	//@Qualifier("schoolValidator")
	//private SchoolValidator validator;
	   
	//--------------------------- Search Applicant --------------------------// 
	/**
	   * This method is used to show the form to search Schools
	   * @return all schools
	   *
	   */
	   @RequestMapping(value = "/showSearchSchoolForm", method = RequestMethod.GET)
	   public String showSearchSchoolForm(Model model) {
	       model.addAttribute("school", new School());	
	       return "school/searchSchools";
	   }
		   
	 /**
	   * This method is used to show the form to search Schools
	   * @return all schools
	   */
	   @RequestMapping(value = "/showSearchSchoolByNameForm", method = RequestMethod.GET)
	   public String showSearchSchoolByNameForm(Model model) {
	       model.addAttribute("school", new School());	
	       return "school/searchSchoolByNameForm";
	   }	   
		 
	/**
	  * This method is used to show the form to search Schools
	  * @return all schools
	  */
	  @RequestMapping(value = "/showSearchEngineForm", method = RequestMethod.GET)
	  public String showSearchEngineForm(Model model) {
	     model.addAttribute("school", new School());	
	     return "school/searchEngine";
	  }	
			   
	/**
	  * This method is used to show the form to search Schools
	  * @return satisfied schools
	  */
	  @RequestMapping(value = "/showMatchEngineForm", method = RequestMethod.GET)
	  public String showMatchEngineForm(Model model) {
	     model.addAttribute("school", new School());	
	     return "school/matchEngine";
	  }
		  
	/**
	  * This method is used to show the form to search Schools
	  * @return satisfied schools
	  */
	  @RequestMapping(value = "/showNoSATMatchEngineForm", method = RequestMethod.GET)
	  public String showNoSATMatchEngineForm(Model model) {
	     model.addAttribute("school", new School());	
	     return "school/matchEngineNoSAT";
	  }	  
	  
	/**
	  * This method is used to process the Applicant search based on input search criteria
	  *
	  * @return String the Applicant search resulting page which shows all Schools match the search criteria
	  */
	  @RequestMapping(value="/getSchools", method = RequestMethod.GET)
	  public String getSchools(@RequestParam("limit") int limit, Model model, SessionStatus status) {
	      List<School> schools = null;
		  try{
		     schools = schoolService.getAllSchools();
		  }
		  catch(Exception e){
		     status.setComplete(); //finished the "Applicant" SessionAttribute
	    	 throw e;
		  }
		  if(limit > 0 && limit < schools.size())
		  	 schools = schools.subList(0, limit); 
		  Collections.sort(schools,  new RankComparator());
		  model.addAttribute("schoolList", schools);
		  model.addAttribute("operation", "listSchools");
		  status.setComplete(); //finish the "Applicant" SessionAttribute
		  return "school/successResult";
	 }
	  
	 /**
	   * This method is used to process the Applicant search based on input search criteria
	   *
	   * @return String the Applicant search resulting page which shows all Schools match the search criteria
  	   */
	    @RequestMapping(value="/listSchoolsByFeature", method = RequestMethod.GET)
		public String listSchoolsByFeature(@RequestParam("feature") final String feature,  @RequestParam(value = "size", required=false) Integer numberOfSchools, Model model, SessionStatus status) {
		   List<School> schools = null;
		   
		   if(feature != null) {
			  LinkedHashMap<String, List<String>> params = new LinkedHashMap<String, List<String>>();
		      switch(feature){
		             /*case ("lowAcceptanceRate"):
		               params.put("acceptRate", Arrays.asList(new String[]{"<25"}));
		   		       params.put("category", Arrays.asList(new String[]{"National University", "National Liberal Arts College",
	    			            "Regional University-North", "Regional University-South", 
	    			            "Regional University-Midwest", "Regional University-West", 
	    			            "Regional College-North", "Regional College-South",
	    	 		            "Regional College-Midwest", "Regional College-West"}));
		   		       */
		           case ("lowAcceptanceRate"):
	                   params.put("acceptRate", Arrays.asList(new String[]{"<25"}));
		               params.put("category", Arrays.asList(new String[]{"NU", "NLAC",
   			           "RU_N", "RU_S", "RU_MW", "RU_W", 
   			           "RC_N", "RC_S", "RC_MW", "RC_W"}));
				       schools = schoolService.getSchools(params);
			     	   Collections.sort(schools, new AcceptanceRateComparator());
			     	   model.addAttribute("title", "100  Colleges With Highest Acceptance Rate");
			           break;  
			       case ("highAcceptanceRate"):
			    	   params.put("acceptRate", Arrays.asList(new String[]{">80"}));
					   params.put("category", Arrays.asList(new String[]{"NU", "NLAC",
	    			            "RU_N", "RU_S", "RU_MW", "RU_W", 
	    			            "RC_N", "RC_S", "RC_MW", "RC_W"}));
					   schools = schoolService.getSchools(params);
					   model.addAttribute("title", "100 Colleges With Highest Acceptance Rate");
			           Collections.sort(schools, Collections.reverseOrder(new AcceptanceRateComparator()));
				       break;
			       case ("100PercentAcceptanceRate"):
			    	   params.put("acceptRate", Arrays.asList(new String[]{">99.5"}));
					   schools = schoolService.getSchools(params);
					   model.addAttribute("title", "Colleges With Automatic Acceptance");
			           Collections.sort(schools, Collections.reverseOrder(new AcceptanceRateComparator()));
				       break;    
			       case ("lowCost"):
			           List<School> orgSchools = schoolService.getAllSchools();
			           schools = new ArrayList<School>(orgSchools.size());
			           for(School school : orgSchools){
			        	   if(school.getTuitionFee() != null && school.getRoomBoard() != null){
			        		  school.setTotalCost(school.getTuitionFee() + school.getRoomBoard());   
			        	   	  schools.add(school);
			        	   }	 
			        	   Collections.sort(schools, new TotalCostComparator()); 
			        	   model.addAttribute("title", "100 Colleges With Lowest Cost");
			           }
				       break;    
			       case ("lowToefl"):
			           params.put("internationalStudentApplication.minimumToeflScore", Arrays.asList(new String[]{"80"}));
			           schools = schoolService.getSchools(params);
			           Collections.sort(schools, new ToeflComparator()); 
			           model.addAttribute("title", "100 Colleges With Lowest TOEFL Score Requirement");
			           break;    
			       case ("lowSat"):
			    	   schools = schoolService.getAllSchools();
		               for(School school : schools){
		            	   school.assignAverageSAT();
		               }
				       Collections.sort(schools,  new SatComparator());
				       model.addAttribute("title", "100 Colleges With Lowest SAT/ACT Score Requirement");
			    	   break;
			       case ("lowGpa"):
			    	   params.put("averageGpa", Arrays.asList(new String[]{"< 3.5"}));
		               schools = schoolService.getSchools(params);
				       Collections.sort(schools,  new GpaComparator());
				       model.addAttribute("title", "100 Colleges With Lowest GPA Requirement");
			    	   break;	   
			       case ("ASchoolsForBStudents"):
			    	   schools = schoolService.getAllASchoolsForBStudents();
		               Collections.sort(schools,  new RankComparator());
				       model.addAttribute("title", "A-Plus Schools For B-Students");
			    	   break;	   
			  }
		  }
		  else {
			  try{
				  schools = schoolService.getAllSchools();
			   }
			   catch(DataNotFoundException e){
				  status.setComplete(); //finished the "Applicant" SessionAttribute
			      throw e;
			   }
			   catch(Exception e){
				  status.setComplete(); //finished the "Applicant" SessionAttribute
			   	  throw e;
			   }	   
		  }
		  if(numberOfSchools != null && numberOfSchools > 0 && numberOfSchools < schools.size())
		  	 schools = schools.subList(0, numberOfSchools); 
		     model.addAttribute("schoolList", schools);
			 model.addAttribute("operation", "listSchools");
			 status.setComplete(); //finish the "Applicant" SessionAttribute
			 return "school/successFeatureResult";
		 }
	    
		    
	/**
	  * This method is to show Applicant detail information for the given Applicant code within query string
	  *
	  * @return String the name of the Applicant detail page
	  */
	  @RequestMapping(value="getSchoolDetail/{id}", method = RequestMethod.GET)
	  public String getSchoolDetail(@PathVariable("id") Integer id, Model model){
	     School school = null;
		 try{
		    school = schoolService.getSchoolById(id);
		 }
		 catch(Exception e){
		   throw e;
		 }
		 model.addAttribute("school", school);
		 return "school/successDetailResult";
	  }
	   
	  
	/**
	  * This method is to show Applicant detail information for the given Applicant code within query string
	  * @return String the name of the Applicant detail page
	  */
	  @RequestMapping(value="searchSchoolsByMatchNamePattern", method = RequestMethod.GET)
	  public String searchSchoolsByMatchNamePattern(@RequestParam("name") String name, Model model, SessionStatus status){
	     List<School> schoolList = null;
		 try{
		    schoolList = schoolService.getSchoolsByMatchNamePattern(name);
		 }
		 catch(Exception e){
		   throw e;
		 }
		 model.addAttribute("schoolList", schoolList);
		 status.setComplete();
	  	 return "school/successResult";
	  }
			   
	  /**
		* This method is used to process the Applicant search based on input search criteria
		*
		* @return String the Applicant search resulting page which shows all Schools match the search criteria
		*/
	
		@RequestMapping(value="/getBestSchoolMajors/{major}", method = RequestMethod.GET)
		public String getBestSchoolsByMajor(@PathVariable("major") String major, Model model, SessionStatus status) {
	       List<BestSchoolMajor> bestSchoolMajorList = null;
		   try{
		       bestSchoolMajorList = schoolService.getBestSchoolMajors(major);
		   }
		   catch(Exception e){
			   status.setComplete(); //finished the "Applicant" SessionAttribute
			   throw e;
		   }
		   model.addAttribute("bestSchoolMajorList", bestSchoolMajorList);
		   model.addAttribute("operation", "getBestSchoolMajors");
		   model.addAttribute("title", major);
		   status.setComplete(); //finish the "Applicant" SessionAttribute
		   return "school/successMajorResult";
	    }
	   			   
	/**
	  * This method is to show Applicant detail information for the given Applicant code within query string
	  * @return String the name of the Applicant detail page
	  */
	  @RequestMapping(value="getSchoolsBySpeciality/{speciality}", method = RequestMethod.GET)
	  public String getSchoolsBySpeciality(@PathVariable("speciality") String speciality, Model model){
	     List<School> schools = null;
		 try{
		    schools = schoolService.getSchoolsBySpeciality(speciality);
		 }
		 catch(Exception e){
		    throw e;
		 }
		 Collections.sort(schools, new SpecialityRankComparator());
		 model.addAttribute("schoolList", schools);
		 model.addAttribute("operation", "getSchoolsBySpeciality");
		 if("Engineering_Doctorate".equalsIgnoreCase(speciality))
		     model.addAttribute("title", "Engineering Programs (Doctorate Degree Offered)");
		 else if("Engineering_No_Doctorate".equalsIgnoreCase(speciality))
		     model.addAttribute("title", "Engineering Programs (No_Doctorate Degree Offered)");
		 else
			 model.addAttribute("title", speciality);
		 return "school/successResult";
	  }
	  
	  
	  /**
		* This method is to show Applicant detail information for the given Applicant code within query string
		* @return String the name of the Applicant detail page
		*/
	/*	@RequestMapping(value="getGreatSchoolsByMajor/{major}", method = RequestMethod.GET)
		public String getBestSchoolsByMajor(@PathVariable("major") String major, Model model){
		     List<Applicant> schools = null;
			 try{
			    schools = schoolService.getSchoolsByMajor(major);
			 }
			 catch(Exception e){
			    throw e;
			 }
			 //if(schools == null)
			 //   throw new DataNotFoundException(major);
			 model.addAttribute("schoolList", schools);
			 model.addAttribute("operation", "getPrincetonReviewGreatSchoolMajors");
			 model.addAttribute("title", major);
			 return "school/successResult";
		  }
			    
	*/	    
	    
	 
	/**
	  * This method is used to process the Applicant search based on input search criteria
	  * @return String the Applicant search resulting page which shows all Schools match the search criteria
	  */
	  @RequestMapping(value="/searchSchools", method = RequestMethod.GET)
	  //public String getSchools(@RequestParam LinkedHashMap<String, List<String>> allRequestParams, @ModelAttribute("school") Applicant school, Model model, BindingResult result, SessionStatus status) {
	  public String searchSchools(@RequestParam LinkedHashMap<String, List<String>> allRequestParams, Model model, SessionStatus status) {
	     List<School> schools = null;
		 try{
		    schools = schoolService.getSchools(allRequestParams);
		 }
		 catch(DataNotFoundException e){
		   status.setComplete(); //finished the "Applicant" SessionAttribute
	       throw e;
		 }
		 catch(Exception e){
		   status.setComplete(); //finished the "Applicant" SessionAttribute
	       throw e;
		 }
		 Collections.sort(schools,  new RankComparator());
		 model.addAttribute("schoolList",  schools);
		 model.addAttribute("operation", "listSchools");
		 status.setComplete(); //finish the "Applicant" SessionAttribute
		 if(SchoolUtil.getValue(allRequestParams, "category") != null)
			model.addAttribute("category", SchoolUtil.getValue(allRequestParams, "category"));
		 else if(SchoolUtil.getValue(allRequestParams, "internationalStudentApplication.conditionalAdmissionOffered") != null){   
			model.addAttribute("title", "Colleges with Conditional Admissions");
			model.addAttribute("operation", "listSpecialSchools");
		 }		
		 else if(SchoolUtil.getValue(allRequestParams, "internationalStudentApplication.toeflAcceptedInsteadOfSatOrAct") != null){  
			model.addAttribute("title", "Colleges Accepting TOEFL/IELTS Instead of SAT/ACT");
			model.addAttribute("operation", "listSpecialSchools");
		 } 	
		 return "school/successListResult";
		}
	  
	  /**
		 * This method is used to process the Applicant search based on input search criteria
		 * @return String the Applicant search resulting page which shows all Schools match the search criteria
		 */
		 @RequestMapping(value="/searchEngine", method = RequestMethod.GET)
		 //public String getSchools(@RequestParam LinkedHashMap<String, List<String>> allRequestParams, @ModelAttribute("school") Applicant school, Model model, BindingResult result, SessionStatus status) {
		 public String searchEngine(@RequestParam LinkedHashMap<String, List<String>> allRequestParams, Model model, SessionStatus status) {
		    List<School> schools = null;
		    try{
			    schools = schoolService.searchEngine(allRequestParams);
			}
			catch(Exception e){
			   status.setComplete(); //finished the "Applicant" SessionAttribute
		       throw e;
			}
			Collections.sort(schools,  new RankComparator());
			model.addAttribute("schoolList",  schools);
			model.addAttribute("operation", "searchSchools");
			status.setComplete(); //finish the "Applicant" SessionAttribute
		    return "school/successResult";
		 }
		  
	   
	  /**
		 * This method is used to process the Applicant search based on input search criteria
		 * @return String the Applicant search resulting page which shows all Schools match the search criteria
		 */
		 @RequestMapping(value="/matchEngine", method = RequestMethod.GET)
		 //public String getSchools(@RequestParam LinkedHashMap<String, List<String>> allRequestParams, @ModelAttribute("school") Applicant school, Model model, BindingResult result, SessionStatus status) {
		 public String matchEngine(@RequestParam LinkedHashMap<String, List<String>> allRequestParams, Model model, SessionStatus status) {
		    List<School> schools = null;
		    try{
			    schools = schoolService.matchEngineInternational(allRequestParams);
			}
			catch(Exception e){
			   status.setComplete(); //finished the "Applicant" SessionAttribute
		       throw e;
			}
			Collections.sort(schools,  new RankByCategoryComparator());
			model.addAttribute("schoolList",  schools);
			model.addAttribute("operation", "matchEngine");
			status.setComplete(); //finish the "Applicant" SessionAttribute
 		    return "school/successMatchResult";
		 }
		   	  
	  
	    //--------------------------- Create Applicant --------------------------// 
	   
	 /**
	   * This method is used to show the form to create an Applicant
	   *
	   * @return String the name of first page of Applicant creation
	   */
	   //@PreAuthorize("hasAnyRole('ROLE_SUPERUSER', 'ROLE_ADMIN', 'ROLE_MANAGER', 'ROLE_PURCHASER')")
	   @RequestMapping(value = "/createSchool", method = RequestMethod.GET)
	   public String createSchool(Model model) {
	      model.addAttribute("school", new School());
	      return "school/createSchool";
	   }
	   
	   //handle general Info
	   //@PreAuthorize("hasAnyRole('ROLE_SUPERUSER', 'ROLE_ADMIN', 'ROLE_MANAGER', 'ROLE_PURCHASER')")
	   @RequestMapping(value = "/createSchool", method = RequestMethod.POST)
	   public String createSchool(@ModelAttribute("school") School school, Model model, BindingResult bindingResult, SessionStatus status) {
		  if(school.getName() != null){
			 school.setName(school.getName().toUpperCase()); 
		     //validator.validateGeneralInfo(school, DBOperation.CREATE, bindingResult);
		     if (bindingResult.hasErrors()) 
	             return "school/createSchool";
		  }
		  schoolService.createSchool(school);
		  model.addAttribute("school", school);
		  status.setComplete(); //finished the "school" SessionAttribute
	   	  return "school/updateSchoolSuccesess";
	   }
	      
	   //--------------------------- Update Applicant --------------------------//  
	      
	  /**
	    * This method is used to show the form to update a school
	    *
	    * @return String
	    */
	    //@PreAuthorize("hasAnyRole('ROLE_SUPERUSER', 'ROLE_ADMIN', 'ROLE_MANAGER', 'ROLE_PURCHASER')")
	    @RequestMapping(value = "/updateSchoolForm", method = RequestMethod.GET)
	    public String showUpdateSchoolForm(Model model){
	       model.addAttribute("school", new School());
	       return "school/updateSchoolForm";
	    }
	    
	  /**
	    * This method is used to show the form to update a school
	    *
	    * @return String
	    */
	    //@PreAuthorize("hasAnyRole('ROLE_SUPERUSER', 'ROLE_ADMIN', 'ROLE_MANAGER', 'ROLE_PURCHASER')")
	    @RequestMapping(value = "/updateSchool/{schoolName}", method = RequestMethod.GET)
	    public String updateSchool(@PathVariable("schoolName") String schoolName, Model model){
	       School school = null;
	       try{
	    	   school = schoolService.getSchoolByName(schoolName);
	       }
	       catch (Exception te) {
	          throw te;
	       }
	       model.addAttribute("school", school);
	       return "school/updateSchool";
	    }
	    
	   /**
	     * This method is used to show the form to update a school
		 *
		 * @return String
		 */
		//@PreAuthorize("hasAnyRole('ROLE_SUPERUSER', 'ROLE_ADMIN', 'ROLE_MANAGER', 'ROLE_PURCHASER')")
		@RequestMapping(value = "/updateSchool", method = RequestMethod.GET)
		public String updateSchool(@ModelAttribute("school") School aSchool, Model model){
		   List<School> schoolList = null;
		   try{
		  	   schoolList = schoolService.getSchoolsByMatchNamePattern(aSchool.getName());
		   }
		   catch (Exception te) {
		       throw te;
		   }
		   if(schoolList == null || schoolList.size() == 0){
		      model.addAttribute("school", new School());
		      model.addAttribute("schoolName", aSchool.getName());
		      model.addAttribute("submitted", "yes");
			  return "school/updateSchoolForm";
		   }    
		   else if(schoolList != null && schoolList.size()>1){
		   	   System.out.println(schoolList.size());
		   	   model.addAttribute("schoolList", schoolList);
			   return "school/chooseSchoolToUpdateForm"; 
		   }
		   else{
		   	   System.out.println(schoolList.get(0));
		       model.addAttribute("school", schoolList.get(0));
		       return "school/updateSchool";
		   }    
		 }
		    
	    /**
	      * This method is used to show the form to update a school
		  *
		  * @return String
		  */
		  //@PreAuthorize("hasAnyRole('ROLE_SUPERUSER', 'ROLE_ADMIN', 'ROLE_MANAGER', 'ROLE_PURCHASER')")
		  @RequestMapping(value = "/chooseSchoolToUpdate", method = RequestMethod.GET)
		  public String chooseSchoolToUpdate(@ModelAttribute("school") School aSchool, Model model){
		     List<School> schoolList = null;
		     try{
		   	    schoolList = schoolService.getSchoolsByMatchNamePattern(aSchool.getName());
			 }
			 catch (Exception te) {
			     throw te;
			 }
			 if(schoolList != null && schoolList.size()>1){
			    model.addAttribute("schoolList", schoolList);
			    return "school/chooseSchoolToUpdateSchool"; 
			 }
			 else{
			     model.addAttribute("school", schoolList.get(0));
			     return "school/updateSchool";
			 }    
		  }    
		    
	    
	    /**
	     * This method is used to process the ticket form to create a ticket
	     *
	     * @return String the name of the update Applicant page
	     */
	     //@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_MANAGER')")
	     @RequestMapping(value = "/updateSchool", method = RequestMethod.POST)
	     public String updateSchool(@ModelAttribute("school") School school, Model model, BindingResult bindingResult) {
	         //validator.validateSchoolCode(SchoolCode, DBOperation.UPDATE, bindingResult);
	         //if (bindingResult.hasErrors()) {
	         //    return "school/updateSchool";
	         //}
	    	 School retrievedSchool = null;
	    	 try {
	     		retrievedSchool = schoolService.updateSchool(school);
	         }
	      	 catch (Exception te) {
	             throw te;
	         }
	    	 model.addAttribute("school", retrievedSchool);
	     	 model.addAttribute("operation", "update");
	         return "school/updateSchoolSuccess";
	     }  
	     
	       //------------------------- Delete an Applicant ------------------------//  
	       
	     @RequestMapping(value="deleteSchool", method = RequestMethod.GET)
	     public String deleteSchool(Model model){
	  	   model.addAttribute("Applicant", new School());
	  	   return "school/deleteSchool";
	     }
	     
	     @RequestMapping(value="deleteSchool", method = RequestMethod.POST)
	     public String deleteSchool(@ModelAttribute("school") School school, Model model, BindingResult bindingResult) {
	        //validator.validateSchoolCode(Applicant.getSchoolcode(), DBOperation.DELETE, bindingResult);
	        if (bindingResult.hasErrors()) {
	            return "school/deleteSchool";
	        }
	  	    try{
	  		   schoolService.deleteSchool(school);
	  	   }
	  	   catch(Exception e){
	  		   e.printStackTrace();
	  	   }
	  	   model.addAttribute("school", school);
	  	   model.addAttribute("operation", "Deleted");
	 	   return "school/updateSchoolSuccess";
	     }
	     
	       
	     //------------------- Model Attributes Initiation ------------------//
	     @ModelAttribute("allSchoolList")
	     public void listOfAllSchools(Model model) {
	       	 model.addAttribute("allSchoolList", schoolService.getAllSchools());
	     }
	     
	     @ModelAttribute("limitList")
	     public void listOfLimitOfSchools(Model model) {
	       	 model.addAttribute("limitList", Arrays.asList("50", "100", "150", "200"));
	     }
	     
	     @ModelAttribute("schoolTypeList")
	     public void listOfSchoolTypes(Model model) {
	    	 model.addAttribute("schoolTypeList", Arrays.asList("Public", "Private", "Private_Men", "Private_Women", "Proprietary"));
	     }
	     /*
	     @ModelAttribute("schoolCategoryList")
	     public void listOfSchoolCategorys(Model model) {
	    	 model.addAttribute("schoolCategoryList", Arrays.asList(
	    			            "National University", "National Liberal Arts College",
	    			            "Regional University-North", "Regional University-South", 
	    			            "Regional University-Midwest", "Regional University-West", 
	    			            "Regional College-North", "Regional College-South",
	    	 		            "Regional College-Midwest", "Regional College-West"));
	     }
	     */
	     @ModelAttribute("schoolCategoryList")
	     public void listOfSchoolCategories(Model model) {
	    	 model.addAttribute("schoolCategoryList", SchoolCategories.values());
	    			           // "NU", "NLAC",
	    			           // "RU-N", "RU-S", "RU-MW", "RU-W", 
	    			           // "RC-N", "RC-S", "RC-MW", "RC-W",
	    			           // "Art Schools", "Business Schools", "Engineering Schools"));
	     }
	     
	     @ModelAttribute("shortSchoolCategoryList")
	     public void listOfShortSchoolCategoris(Model model) {
	    	 //model.addAttribute("schoolCategoryLiest", Arrays.asList("NU", "NLAC"));
	    	 Arrays.asList(SchoolCategories.values());
	     }
	     
	     @ModelAttribute("schoolSettingList")
	     public void listOfSchoolSettings(Model model) {
	    	 model.addAttribute("schoolSettingList", Arrays.asList("Urban", "Suburban", "Rural", "City"));
	     }
	     
	     @ModelAttribute("selectivityList")
	     public void listOfSelectivity(Model model) {
	     	 model.addAttribute("selectivityList", Arrays.asList("Most selective", "More selective", "Selective", "Less Selective", "Least Selective"));
	     }
	     
	     @ModelAttribute("majorList")
	     public void listOfPopularMajors(Model model) {
	    	 //model.addAttribute("countryList", Arrays.asList(OriginCountry.values()));
	    	 model.addAttribute("majorList", Arrays.asList(PopularMajors.values()));
	     }
	     
	     @ModelAttribute("schoolRankList")
	     public void listOfRankRanges(Model model) {
	     	 model.addAttribute("schoolRankList", Arrays.asList("Top 10", "Top 25","Top 50","Top 75","Top 100","Top 150"));
	     }
	     
	     @ModelAttribute("acceptanceRateList")
	     public void listOfacceptanceRate(Model model) {
	     	 model.addAttribute("acceptanceRateList", Arrays.asList("<25%", "between 25% and 50%", "between 50% and 75%", ">75%"));
	     }
	     
	     @ModelAttribute("tuitionRangeList")
	     public void listOfTuitionRanges(Model model) {
	     	 model.addAttribute("tuitionRangeList", Arrays.asList("<5000", "<7500", "<10000", "<15000","<20000","<25000","<30000","<35000","<40000", "<45000","<50000"));
	     }
	     
	     @ModelAttribute("totalCostRangeList")
	     public void listOfTotalCostRanges(Model model) {
	     	 model.addAttribute("totalCostRangeList", Arrays.asList("<15000","<20000","<25000","<30000","<35000","<40000", "<45000","<50000", "<55000","<60000", "<65000"));
	     }
	     
	     @ModelAttribute("schoolSizeList")
	     public void listOfSchoolSize(Model model) {
	     	 model.addAttribute("schoolSizeList", Arrays.asList("Small(<2000)", "Midium(between 2000 and 15000)","Large(>15000)"));
	     }
	      
	     @ModelAttribute("recommandationLetters")
	     public void listOfRecommandationLetters(Model model) {
	    	 model.addAttribute("recommandationLetterList", Arrays.asList("Not Required","Required"));
	     }
	     
	     @ModelAttribute("internationalFinancialAids")
	     public void listOfInternationalFinancialAidOptions(Model model) {
	     	 model.addAttribute("internationalFinancialAidList", Arrays.asList("Only offer financial aid for international students"));
	     }
		 
	     @ModelAttribute("stateList")
	     public void listOfStates(Model model) {
	     	 model.addAttribute("stateList", Arrays.asList(States.values()));
	     }
	     
	     @ModelAttribute("actScoreList")
	     public void listOfActScore(Model model) {
	     	 model.addAttribute("actScoreList", Arrays.asList("36","35","34","33","32","31","30","29","28","27","26","25","24","23","22","21","20","19","18","17","16","15","14","13","12","11","10","9","8","7","6","5","4","3","2","1"));
	     }
	     
	     @ModelAttribute("ieltsScoreList")
	     public void listOfIeltsScore(Model model) {
	     	 model.addAttribute("ieltsScoreList", Arrays.asList("9","8.5","8","7.5","7","6.5","6","5.5","4","3","2","1","0"));
	     }
	     
	     @ModelAttribute("calendarList")
	     public void listOfCalendar(Model model) {
	     	 model.addAttribute("calendarList", Arrays.asList("Semester","Quater"));
	     }
	     
	     @ModelAttribute("satSubjectList")
	     public void listOfSatSubjects(Model model) {
	     	 model.addAttribute("satSubjectList", Arrays.asList("Math Level1","Math Lavel2","Biology","Physics","Chemistry","Literature",
	     			                                            "US History","World History","Chinese"));
	     }
	     
	     //----------------------- Exception Handlers ------------------------//
	     
	     @ExceptionHandler(DataNotFoundException.class)
	     public ModelAndView handleDataNotFoundException(DataNotFoundException ex) {
	   
	  		ModelAndView model = new ModelAndView("/exception/exception");
	  		model.addObject("errorCode", ex.getErrorCode());
	 		model.addObject("errorType", ex.getErrorType());
	 		model.addObject("errorMessage", ex.getErrorMessage());
	 		model.addObject("rootErrorMessage", ex.getRootErrorMessage());
	 		model.addObject("error", ex);
	 		model.addObject("rootError", ex.getRootError());
	   
	  		return model;
	   	 }
	     
	     @ExceptionHandler(InputParamException.class)
	     public ModelAndView handleInputParamException(InputParamException ex) {
	   
	  		ModelAndView model = new ModelAndView("/exception/exception");
	  		model.addObject("errorCode", ex.getErrorCode());
	 		model.addObject("errorType", ex.getErrorType());
	 		model.addObject("errorMessage", ex.getErrorMessage());
	 		model.addObject("rootErrorMessage", ex.getRootErrorMessage());
	 		model.addObject("error", ex);
	 		model.addObject("rootError", ex.getRootError());
	   
	  		return model;
	   	}
	     
	    @ExceptionHandler(DatabaseOperationException.class)
	 	public ModelAndView handleDataOperationException(DatabaseOperationException ex) {
	  
	 		ModelAndView model = new ModelAndView("/exception/exception");
	 		model.addObject("errorCode", ex.getErrorCode());
	 		model.addObject("errorType", ex.getErrorType());
	 		model.addObject("errorMessage", ex.getErrorMessage());
	 		model.addObject("rootErrorMessage", ex.getRootErrorMessage());
	 		model.addObject("error", ex);
	 		model.addObject("rootError", ex.getRootError());
	  
	 		return model;
	  	}
	   /* 
	    @ExceptionHandler(DatabaseSchemaException.class)
	 	public ModelAndView handleDatabaseSchemaException(DatabaseSchemaException ex) {
	  
	 		ModelAndView model = new ModelAndView("/exception/exception");
	 		model.addObject("errorCode", ex.getErrorCode());
	 		model.addObject("errorType", ex.getErrorType());
	 		model.addObject("errorMessage", ex.getErrorMessage());
	 		model.addObject("rootErrorMessage", ex.getRootErrorMessage());
	 		model.addObject("error", ex);
	 		model.addObject("rootError", ex.getRootError());
	  
	 		return model;
	  	}
	    */
	  
	}
