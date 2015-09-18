package com.collegesearch.web.controller;

//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.collegesearch.domain.school.School;


/**
* This MVC controller class takes all ims-related requests and dispatches the requests to corresponding services to fulfill database CRUD operations on ims.
* This class handles all requests rooted with "/ims".
*
*/

@Controller

public class HomeController {

	     
	   //--------------------------- Home Page --------------------------// 
	   
	  /**
        * This method is used to show the form to search Schools
	    *
	    * @return Main School home page
	    *
	    */
	    @RequestMapping(value = "school/home", method = RequestMethod.GET)
	    public String showHome(Model model) {
	       model.addAttribute("school", new School());	
	       return "school/home";
	    }	 
	 
	   /**
	     * This method is used to show the form to search Schools
		 *
		 * @return Admin Home Page
		 *
		 */
		 @RequestMapping(value = "/admin/adminHome", method = RequestMethod.GET)
		 public String showAdminHome(Model model) {
		    model.addAttribute("school", new School());	
		    return "admin/adminHome";
		 }	
	   
	   /**
	    * This method is used to show Login page
	    *
	    * @return String the school home page
	    */
	   @RequestMapping(value = {"/login" }, method = RequestMethod.GET)
	   public String showLoginPage() {
		  System.out.println("login called"); 
	      return "login";
	   }
	   
	   /**
	    * This method is used to show ims main page
	    *
	    * @return String the school home page
	    */
	   @RequestMapping(value = {"/general/about_us" }, method = RequestMethod.GET)
	   public String showAboutUsPage() {
	      return "general/about_us";
	   }
	   
	   /**
	    * This method is used to show ims main page
	    *
	    * @return String the school home page
	    */
	   @RequestMapping(value = {"general/contact" }, method = RequestMethod.GET)
	   public String showContactPage() {
	      return "general/contact";
	   }
	   
	   /**
	    * This method is used to show ims main page
	    *
	    * @return String the school home page
	    */
	   @RequestMapping(value = {"general/services" }, method = RequestMethod.GET)
	   public String showServicesPage() {
	      return "general/services";
	   }
	   
	   /**
	    * This method is used to show ims main page
	    *
	    * @return String the school home page
	    */
	   @RequestMapping(value = {"general/why_us" }, method = RequestMethod.GET)
	   public String showWhyUsPage() {
	      return "general/why_us";
	   }
	   
	}
