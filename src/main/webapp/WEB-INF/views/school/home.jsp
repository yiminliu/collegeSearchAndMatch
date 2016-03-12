<%@ include file="/WEB-INF/includes/taglibs.jsp"%>
<%@ include file="/WEB-INF/includes/doctype.jsp"%>
<%@ include file="/WEB-INF/includes/styles.jsp"%>

<html xmlns="http://www.w3.org/1999/xhtml" lang="en">

<head>
   <title>USA College Consulting Home Page</title>
</head>

<body background="http://localhost:8080/collegeSearch/static/images/search_bg2.jpg">
  <%@ include file="/WEB-INF/views/general/header.jsp"%>
  <div class="container">
    <div class="content">  
      <table class="section_title_center">
        <tr><td>Choose Colleges -- College Search & Match Engines</td></tr>
      </table>     
      <table class="center_element_text" style="border:1px; width: 100%">
        <tr>
           <td>
             <ul style="list-style-type:none">
                <!--<li><a id="searchSchool" href="<spring:url value="/school/showSearchEngineForm" />" class="button_l" style="margin: auto; width: 60%"><span style="text-color: RED; text-weight: bold; font-style: italic">College Search Engine</span> -- Find Colleges by Your Preferences</a></li>
                <li><a id="matchSchool" href="<spring:url value="/school/showMatchEngineForm" />" class="button_l" style="margin: auto; width: 60%;"><span style="text-color: RED; text-weight: bold; font-style: italic">College Match Engine</span> -- Find Colleges by Your Preferences and Qualifications<span style="color:red">  *JUST FOR YOU*</span></a></li>-->
                <li><a id="searchSchool" href="<spring:url value="/school/showSearchEngineForm" />" class="button_l" style="margin: auto; width: 60%">Find Colleges by Your Preferences</a></li>
                <li><a id="matchSchool" href="<spring:url value="/school/showMatchEngineForm" />" class="button_l" style="margin: auto; width: 60%;">Find Colleges by Your Preferences and Qualifications<span style="color:red"><br>*JUST FOR YOU*</span></a></li>
             </ul>
           </td>
        </tr>
      </table>
      <table class="section_title_center">
        <tr><td>Application Made Easy for International Students</td></tr>
      </table>     
      <table class="center_element_text" style="border:1px; width: 100%">
        <tr>
           <td>
             <ul style="list-style-type:none">
                <li><a id="searchSchool" href="<spring:url value="/school/searchSchools?internationalStudentApplication.conditionalAdmissionOffered=Yes" />" class="button_l" style="margin: auto; width: 60%">Colleges With Conditional Admissions</a></li>
                <li><a id="searchSchool" href="<spring:url value="/school/searchSchools?internationalStudentApplication.toeflAcceptedInsteadOfSatOrAct=Yes" />" class="button_l" style="margin: auto; width: 60%">Colleges Accepting TOEFL Instead of SAT/ACT</a></li>
             </ul>
           </td>
        </tr>
      </table>
      <!--<table class="section_title_center">
        <tr><td>Application Made Easier</td></tr>
      </table>     
      <table class="center_element_text" style="border:1px; width: 100%">
        <tr>
           <td>
             <ul style="list-style-type:none">
                <li><a id="searchSchool" href="<spring:url value="/school/searchSchools?satActNotRequired=Yes" />" class="button_l" style="margin: auto; width: 60%">Colleges Not Requiring SAT/ACT</a></li>
             </ul>
           </td>
        </tr>
      </table>-->
      <table class="section_title_center">
        <tr><td>Get A College's Information</td></tr>
      </table>  
      <form:form method="GET" action="searchSchoolsByMatchNamePattern" modelAttribute="school">
         <table class="table_center" style="margin-top:15px; margin-bottom:15px">
            <tr>
               <!--<td><form:label path="name">Get College Information:</form:label></td>-->
               <td><form:input path="name" placeholder="College Name"/></td>
               <td><input name="submit" type="submit" value="Go" /></td>
            </tr>
         </table>
      </form:form> 
      <table class="section_title_center">
        <tr><td>Rankings By Categories</td></tr>
      </table>  
      <!--<table class="center_element" style="border-spacing: 80px, -90px">-->
       <spring:url var="action" value="/school/searchSchools" />
       <table class="center_element_text" style="width:70%; margin-top: 15px; margin-bottom: 15px;">
         <tr>
           <td>
             <form:form method="GET" action="${action}" modelAttribute="school">
               <table>            
                 <tr>
                   <td><input name="submit" type="submit" value="National Universities" class="submit_button"/>
                     <form:hidden path="category" value="National University"/>
                   </td> 
                </tr>
              </table>
            </form:form>
          </td>
          <td>    
            <form:form method="GET" action="${action}" modelAttribute="school">
               <table>            
                 <tr>
                   <td><input name="submit" type="submit" value="National Liberal Art Colleges" class="submit_button" />
                     <form:hidden path="category" value="National Liberal Arts College"/>
                   </td> 
                 </tr>
              </table>
            </form:form>
         </td>
        </tr>  
	    <tr>
          <td>
             <form:form method="GET" action="${action}" modelAttribute="school">
               <table>            
                 <tr>
                   <td><input name="submit" type="submit" value="Regional Universities-North" class="submit_button"/>
                     <form:hidden path="category" value="Regional University-North"/>
                 </td> 
                </tr>
              </table>
            </form:form>
          </td>
          <td>    
            <form:form method="GET" action="${action}" modelAttribute="school">
               <table>            
                 <tr>
                   <td><input name="submit" type="submit" value="Regional Universities-West" class="submit_button"/>
                     <form:hidden path="category" value="Regional University-West"/>
                   </td> 
                 </tr>
              </table>
            </form:form>
         </td>
        </tr>
        <tr>
          <td>
             <form:form method="GET" action="${action}" modelAttribute="school">
               <table>            
                 <tr>
                   <td><input name="submit" type="submit" value="Regional Universities-Midwest" class="submit_button"/>
                     <form:hidden path="category" value="Regional University-Midwest"/>
                   </td> 
                </tr>
              </table>
            </form:form>
          </td>
          <td>    
            <form:form method="GET" action="${action}" modelAttribute="school">
               <table>            
                 <tr>
                   <td><input name="submit" type="submit" value="Regional Universities-South" class="submit_button"/>
                     <form:hidden path="category" value="Regional University-South"/>
                   </td> 
                 </tr>
              </table>
            </form:form>
         </td>
        </tr>
        <tr>
          <td>
             <form:form method="GET" action="${action}" modelAttribute="school">
               <table>            
                 <tr>
                   <td><input name="submit" type="submit" value="Regional Colleges-North" class="submit_button"/>
                     <form:hidden path="category" value="Regional College-North"/>
                   </td> 
                </tr>
              </table>
            </form:form>
          </td>
          <td>    
            <form:form method="GET" action="${action}" modelAttribute="school">
               <table>            
                 <tr>
                   <td><input name="submit" type="submit" value="Regional Colleges-West" class="submit_button"/>
                     <form:hidden path="category" value="Regional College-West"/>
                   </td> 
                 </tr>
              </table>
            </form:form>
         </td>
        </tr>
        <tr>
          <td>
             <form:form method="GET" action="${action}" modelAttribute="school">
               <table>            
                 <tr>
                   <td><input name="submit" type="submit" value="Regional Colleges-Midwest" class="submit_button"/>
                     <form:hidden path="category" value="Regional College-Midwest"/>
                   </td> 
                </tr>
              </table>
            </form:form>
          </td>
          <td>    
            <form:form method="GET" action="${action}" modelAttribute="school">
               <table>            
                 <tr>
                   <td><input name="submit" type="submit" value="Regional Colleges-South" class="submit_button"/>
                     <form:hidden path="category" value="Regional College-South"/>
                   </td> 
                 </tr>
              </table>
            </form:form>
         </td>
        </tr>
      </table> 
      <table class="section_title_center">
        <tr><td>Rankings By Specialities</td></tr>
      </table>
      <table>
         <tr>
          <td>
            <ul>
		  <li><a href="<spring:url value="/school/getSchoolsInSpeciality/Engineering_Doctorate" />">Engineering Programs (Doctorate Degree Offered)</a></li>
	        <li><a href="<spring:url value="/school/getSchoolsInSpeciality/Engineering_No_Doctorate" />">Engineering Programs (No_Doctorate Degree Offered)</a></li>
	      </ul>
          </td>
          <td>
            <ul>
		  <li><a href="<spring:url value="/school/getSchoolsInSpeciality/Business" />">Business Programs</a></li>
		  <li><a href="http://localhost:8080/collegeSearch/school/searchSchools?category=Art Schools">Art Schools</a></li>
	       </ul>
          </td>
       </tr>
      </table> 
      <table class="section_title_center">
        <tr><td>Rankings By Majors</td></tr>
      </table> 
      <table class="center_element" style="margin-top:0px;">
        <tr><td><span class="section_title_center">Business Programs</span></td></tr>
	  <tr>
	    <td>
	      <ul>
		  <li><a href="<spring:url value="/school/getBestSchoolMajors/Accounting" />">Accounting</a></li>
		  <li><a href="<spring:url value="/school/getBestSchoolMajors/Finance"/>">Finance</a></li>
	 	  <li><a href="<spring:url value="/school/getBestSchoolMajors/Entrepreneurship"/>">Entrepreneurship</a></li>
	 	  <li><a href="<spring:url value="/school/getBestSchoolMajors/Insurance"/>">Insurance</a></li>
	 	  <li><a href="<spring:url value="/school/getBestSchoolMajors/International Business"/>">International Business</a></li>
	 	  <li><a href="<spring:url value="/school/getBestSchoolMajors/Management"/>">Management</a></li>
	      </ul>
         </td>
         <td>
	      <ul>
 	        <li><a href="http://localhost:8080/collegeSearch/school/getBestSchoolMajors/Marketing and Sales">Marketing and Sales</a></li>
	    	  <li><a href="<spring:url value="/school/getBestSchoolMajors/Management Information Systems"/>">Management Information Systems</a></li>
	        <li><a href="<spring:url value="/school/getBestSchoolMajors/Production and Operations Management"/>">Production/Operations Management</a></li>
	 	  <li><a href="<spring:url value="/school/getBestSchoolMajors/Quantitative Analysis"/>">Quantitative Analysis</a></li>
	        <li><a href="<spring:url value="/school/getBestSchoolMajors/Real Estate"/>">Real Estate</a></li>
	        <li><a href="<spring:url value="/school/getBestSchoolMajors/Supply Chain Management and Logistics"/>">Supply Chain Management and Logistics</a></li>
	      </ul>
	   </td>
	 </tr>
	 <tr><td><span class="section_title_center">Engineering Programs</span></td></tr>
	 <tr>
	   <td>
	      <ul>
	         <li><a href="<spring:url value="/school/getBestSchoolMajors/Aerospace-Aeronautical-Astronautical_Doctorate"/>">Aerospace/Aeronautical/Astronautical_Doctorate</a></li>
	         <li><a href="<spring:url value="/school/getBestSchoolMajors/Aerospace-Aeronautical-Astronautical_No_Doctorate"/>">Aerospace/Aeronautical/Astronautical_No_Doctorate</a></li>
	         <li><a href="<spring:url value="/school/getBestSchoolMajors/Biological and Agricultural_Doctorate"/>">Biological/Agricultural_Doctorate</a></li>
	         <li><a href="<spring:url value="/school/getBestSchoolMajors/Biomedical_Doctorate"/>">Biomedical_Doctorate</a></li>
	         <li><a href="<spring:url value="/school/getBestSchoolMajors/Biomedical_No_Doctorate"/>">Biomedical_No_Doctorate</a></li>
	         <li><a href="<spring:url value="/school/getBestSchoolMajors/Chemical_Doctorate"/>">Chemical_Doctorate</a></li>
	         <li><a href="<spring:url value="/school/getBestSchoolMajors/Computer Science and Computer Engineering-D"/>">Computer Science/Computer Engineering Majors-D</a></li>
		   <li><a href="<spring:url value="/school/getBestSchoolMajors/Computer Science and Computer Engineering-ND"/>">Computer Science/Computer Engineering Majors-ND</a></li>
	         <li><a href="<spring:url value="/school/getBestSchoolMajors/Engineering"/>">Engineering</a></li>
	 
		</ul>
        </td>
        <td>
	     <ul>
	        <li><a href="<spring:url value="/school/getBestSchoolMajors/Civil_Doctorate"/>">Civil_Doctorate</a></li>
	        <li><a href="<spring:url value="/school/getBestSchoolMajors/Civil_No_Doctorate"/>">Civil_No_Doctorate</a></li>
	        <li><a href="<spring:url value="/school/getBestSchoolMajors/Electrical-Electronic-Communications_Doctorate"/>">Electrical/Electronic/Communications_Doctorate</a></li>
	        <li><a href="<spring:url value="/school/getBestSchoolMajors/Electrical-Electronic-Communications_No_Doctorate"/>">Electrical/Electronic/Communications_No_Doctorate</a></li>
	        <li><a href="<spring:url value="/school/getBestSchoolMajors/Environmental and Environmental Health_Doctorate"/>">Environmental/Environmental Health_Doctorate</a></li>
	        <li><a href="<spring:url value="/school/getBestSchoolMajors/Industrial and Manufacturing_Doctorate"/>">Industrial/Manufacturing_Doctorate</a></li>
	        <li><a href="http://localhost:8080/collegeSearch/school/getBestSchoolMajors/Mechanical Engineering-D">Mechanical Engineering-D</a></li>
	  	  <li><a href="http://localhost:8080/collegeSearch/school/getBestSchoolMajors/Mechanical Engineering-ND">Mechanical Engineering-ND</a></li>
	        <li><a href="<spring:url value="/school/getBestSchoolMajors/Engineering"/>">Engineering</a></li>
	 
	     </ul>
	  </td>
	 </tr>
	 <tr><td><span class="section_title_center">Humanities Programs</span></td></tr>
       <tr>
         <td>
           <ul>
              <li><a href="<spring:url value="/school/getBestSchoolMajors/Communications"/>">Communications</a></li>
		  <li><a href="<spring:url value="/school/getBestSchoolMajors/Criminology"/>">Criminology</a></li>
	   	  <li><a href="<spring:url value="/school/getBestSchoolMajors/English Literature and Language"/>">English Literature and Language</a></li>
	        <li><a href="<spring:url value="/school/getBestSchoolMajors/Education"/>">Education</a></li>	
	        <li><a href="http://localhost:8080/collegeSearch/school/getBestSchoolMajors/History">History</a></li>
	     </ul>
        </td>
        <td>
	     <ul>
	        <li><a href="http://localhost:8080/collegeSearch/school/getBestSchoolMajors/Journalism">Journalism</a></li>
	        <li><a href="http://localhost:8080/collegeSearch/school/getBestSchoolMajors/Mathematics">Mathematics</a></li>
	  	  <li><a href="http://localhost:8080/collegeSearch/school/getBestSchoolMajors/Nursing">Nursing</a></li>
	  	  <li><a href="http://localhost:8080/collegeSearch/school/getBestSchoolMajors/Political Science and Government">Political Science/Government</a></li>
		  <li><a href="http://localhost:8080/collegeSearch/school/getBestSchoolMajors/Psychology">Psychology</a></li>
 	    </ul>
	  </td>
	 </tr>
	 <tr><td><span class="section_title_center">Science Programs</span></td></tr>
       <tr>
         <td>
           <ul>
           	  <li><a href="<spring:url value="/school/getBestSchoolMajors/Agriculture"/>">Agriculture</a></li>
		  <li><a href="<spring:url value="/school/getBestSchoolMajors/Biology"/>">Biology</a></li>
	     </ul>
        </td>
        <td>
	     <ul>
	        <li><a href="http://localhost:8080/collegeSearch/school/getBestSchoolMajors/Environmental Studies">Environmental Studies</a></li>
	        <li><a href="http://localhost:8080/collegeSearch/school/getBestSchoolMajors/Health Services">Health Services</a></li>
	     </ul>
	  </td>
	 </tr>
      </table>
      <table class="section_title_center">
         <tr><td>Colleges with Special Features</td></tr>
      </table> 
      <table class="center_element" style="margin-top:0px;">
	   <tr>
            <td>
               <ul>
                  <li><a href="<spring:url value="/school/listSchoolsByFeature?feature=highAcceptanceRate&size=100" />">100 Colleges with Highest Acceptance rate</a></li>
                  <li><a href="<spring:url value="/school/listSchoolsByFeature?feature=lowSat&size=100" />">100 Colleges with Lowest SAT/ACT</a></li>
		      <li><a href="<spring:url value="/school/listSchoolsByFeature?feature=ASchoolsForBStudents&size=100"/>">A-Plus Colleges for B-Students</a></li>
		      <li><a href="http://localhost:8080/collegeSearch/school/searchSchools?acceptRate>95">High Acceptance Rate and Low Cost in top 50 National Colleges</a></li>
               </ul>
            </td>
            <td>
		   <ul>
		      <li><a href="<spring:url value="/school/listSchoolsByFeature?feature=lowCost&size=100" />">100 Colleges with Lowest Cost</a></li>
		      <li><a href="<spring:url value="/school/listSchoolsByFeature?feature=lowToefl&size=100" />">100 Colleges with Lowest TOEFL/IELTS Scores</a></li>
		      <li><a href="<spring:url value="/school/searchSchools?applicationFee=0" />">Colleges With No Application Fee</a></li>
	 	      <li><a href="<spring:url value="/school/searchSchools?acceptRate<25%" />">100 Colleges with Lowest Acceptance Rate</a></li>
	   	   </ul>
	      </td>
	   </tr>
      </table>
      <!-- 
      <hr></hr>
      <form:form method="GET" action="searchSchoolsByMatchNamePattern" modelAttribute="school">
         <table class="table_center" style="margin-top:-2px">
            <tr>
               <td><form:label path="name">Get College Information:</form:label></td>
               <td><form:input path="name" placeholder="College Name"/></td>
               <td><input name="submit" type="submit" value="Go" /></td>
            </tr>
         </table>
   </form:form>-->
   </div> <!--content--> 
   <div>
    <%@ include file="/WEB-INF/views/general/footer.jsp"%>
   </div> <!-- footer --> 
 </div><!-- container -->   

</body>
</html>
