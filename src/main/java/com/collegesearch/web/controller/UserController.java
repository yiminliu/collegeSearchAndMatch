package com.collegesearch.web.controller;

//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import com.collegesearch.domain.school.School;
import com.collegesearch.domain.user.User;
import com.collegesearch.service.user.UserService;


/**
* This MVC controller class takes all ims-related requests and dispatches the requests to corresponding services to fulfill database CRUD operations on ims.
* This class handles all requests rooted with "/ims".
*
*/

@Controller

@RequestMapping(value = "/user")
public class UserController {

	    @Autowired
	    UserService userService;
	    
	   //--------------------------- Create User --------------------------// 
	   
	   /**
	   * This method is used to show the form to create an School
	   *
	   * @return String the name of first page of School creation
	   */
	   //@PreAuthorize("hasAnyRole('ROLE_SUPERUSER', 'ROLE_ADMIN', 'ROLE_MANAGER', 'ROLE_PURCHASER')")
	   @RequestMapping(value = "/createUser", method = RequestMethod.GET)
	   public String createUser(Model model) {
	      model.addAttribute("user", new User());
	      return "user/createUser";
	   }
	   
	   //handle general Info
	   //@PreAuthorize("hasAnyRole('ROLE_SUPERUSER', 'ROLE_ADMIN', 'ROLE_MANAGER', 'ROLE_PURCHASER')")
	   @RequestMapping(value = "/createUser", method = RequestMethod.POST)
	   public String createUser(@ModelAttribute("user") User user, Model model, BindingResult bindingResult, SessionStatus status) {
		 // if(school.getName() != null){
			// school.setName(school.getName().toUpperCase()); 
		     //validator.validateGeneralInfo(school, DBOperation.CREATE, bindingResult);
		     //if (bindingResult.hasErrors()) 
	          //   return "user/createUser";
		  //}
		  userService.createUser(user);
		  model.addAttribute("user", user);
		  status.setComplete(); //finished the "school" SessionAttribute
	   	  return "school/createUserSuccesess";
	   }
	}
