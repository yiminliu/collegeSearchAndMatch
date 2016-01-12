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
        <tr><td>Chose Your Colleges Based on Your Preferences and Qualifications</td></tr>
      </table>     
      <table class="center_element_text" style="border:1px; width: 100%">
        <tr>
           <td>
             <ul style="list-style-type:none">
                <li><a id="searchSchool" href="<spring:url value="/school/showSearchEngineForm" />" class="button_l" style="margin: auto; width: 60%"><span style="text-color: RED; text-weight: bold; font-style: italic">College Search Engine</span> -- Find Your Suitable Colleges</a></li>
                <li><a id="matchSchool" href="<spring:url value="/school/showMatchEngineForm" />" class="button_l" style="margin: auto; width: 60%;"><span style="text-color: RED; text-weight: bold; font-style: italic">College Match Engine</span> -- Match You and the Suitable Colleges <span style="color:red">  *JUST FOR YOU*</span></a></li>
             </ul>
           </td>
        </tr>
      </table>
      <table class="section_title_center">
        <tr><td>Application Made Easier for International Students</td></tr>
      </table>     
      <table class="center_element_text" style="border:1px; width: 100%">
        <tr>
           <td>
             <ul style="list-style-type:none">
                <li><a id="matchSchool" href="<spring:url value="/school/searchSchools?internationalStudentApplication.toeflAcceptedInsteadOfSatOrAct=Yes" />" class="button_l" style="margin: auto; width: 60%;">Colleges Accept TOEFL/IELTS Instead of SAT/ACT</a></li>
                <li><a id="searchSchool" href="<spring:url value="/school/searchSchools?internationalStudentApplication.conditionalAdmissionOffered=Yes" />" class="button_l" style="margin: auto; width: 60%">Colleges With Conditional Admission</a></li>
             </ul>
           </td>
        </tr>
      </table>
      <table class="section_title_center">
        <tr><td>Application Made Easier</td></tr>
      </table>     
      <table class="center_element_text" style="border:1px; width: 100%">
        <tr>
           <td>
             <ul style="list-style-type:none">
                <li><a id="searchSchool" href="<spring:url value="/school/searchSchools?satActNotRequired=Yes" />" class="button_l" style="margin: auto; width: 60%">Colleges Do Not Require SAT1/ACT</a></li>
             </ul>
           </td>
        </tr>
      </table>
      <table class="section_title_center">
        <tr><td>Top Colleges in Different Categories</td></tr>
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
                     <form:select id="nationalLimit" path="maxResults" cssClass="span-8" cssErrorClass="span-8 validationFailed" cssStyle="width:50px;">
                       <form:option value="50" selected="selected">50</form:option>
                       <form:option value="100">100</form:option>
                       <form:option value="150">150</form:option>
                       <form:option value="200">200</form:option>
                       <form:option value="1000" >All</form:option>
                     </form:select>
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
                     <form:select id="liberalArtLimit" path="maxResults" cssClass="span-8" cssErrorClass="span-8 validationFailed" cssStyle="width:50px;">
                       <form:option value="50" selected="selected">50</form:option>
                       <form:option value="100">100</form:option>
                       <form:option value="150">150</form:option>
                       <form:option value="200">200</form:option>
                       <form:option value="1000" >All</form:option>
                     </form:select>
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
                   <td><input name="submit" type="submit" value="Reginal Universities-North" class="submit_button"/>
                     <form:hidden path="category" value="Regional University-North"/>
                     <form:select id="reginalLimit" path="maxResults" cssClass="span-8" cssErrorClass="span-8 validationFailed" cssStyle="width:50px;">
                       <form:option value="50" selected="selected">50</form:option>
                       <form:option value="100">100</form:option>
                       <form:option value="150">150</form:option>
                       <form:option value="200">200</form:option>
                       <form:option value="1000" >All</form:option>
                     </form:select>
                   </td> 
                </tr>
              </table>
            </form:form>
          </td>
          <td>    
            <form:form method="GET" action="${action}" modelAttribute="school">
               <table>            
                 <tr>
                   <td><input name="submit" type="submit" value="Reginal Universities-West" class="submit_button"/>
                     <form:hidden path="category" value="Regional University-West"/>
                     <form:select id="reginalLimit" path="maxResults" cssClass="span-8" cssErrorClass="span-8 validationFailed" cssStyle="width:50px;">
                       <form:option value="50" selected="selected">50</form:option>
                       <form:option value="100">100</form:option>
                       <form:option value="150">150</form:option>
                       <form:option value="200">200</form:option>
                       <form:option value="1000" >All</form:option>
                     </form:select>
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
                     <form:select id="reginalLimit" path="maxResults" cssClass="span-8" cssErrorClass="span-8 validationFailed" cssStyle="width:50px;">
                       <form:option value="50" selected="selected">50</form:option>
                       <form:option value="100">100</form:option>
                       <form:option value="150">150</form:option>
                       <form:option value="200">200</form:option>
                       <form:option value="1000" >All</form:option>
                     </form:select>
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
                     <form:select id="reginalLimit" path="maxResults" cssClass="span-8" cssErrorClass="span-8 validationFailed" cssStyle="width:50px;">
                       <form:option value="50" selected="selected">50</form:option>
                       <form:option value="100">100</form:option>
                       <form:option value="150">150</form:option>
                       <form:option value="200">200</form:option>
                       <form:option value="1000" >All</form:option>
                     </form:select>
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
                   <td><input name="submit" type="submit" value="Reginal Colleges-North" class="submit_button"/>
                     <form:hidden path="category" value="Regional College-North"/>
                     <form:select id="reginalLimit" path="maxResults" cssClass="span-8" cssErrorClass="span-8 validationFailed" cssStyle="width:50px;">
                       <form:option value="50" selected="selected">50</form:option>
                       <form:option value="100">100</form:option>
                       <form:option value="150">150</form:option>
                       <form:option value="200">200</form:option>
                       <form:option value="1000" >All</form:option>
                     </form:select>
                   </td> 
                </tr>
              </table>
            </form:form>
          </td>
          <td>    
            <form:form method="GET" action="${action}" modelAttribute="school">
               <table>            
                 <tr>
                   <td><input name="submit" type="submit" value="Reginal Colleges-West" class="submit_button"/>
                     <form:hidden path="category" value="Regional College-West"/>
                     <form:select id="reginalLimit" path="maxResults" cssClass="span-8" cssErrorClass="span-8 validationFailed" cssStyle="width:50px;">
                       <form:option value="50" selected="selected">50</form:option>
                       <form:option value="100">100</form:option>
                       <form:option value="150">150</form:option>
                       <form:option value="200">200</form:option>
                       <form:option value="1000" >All</form:option>
                     </form:select>
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
                     <form:select id="reginalLimit" path="maxResults" cssClass="span-8" cssErrorClass="span-8 validationFailed" cssStyle="width:50px;">
                       <form:option value="50" selected="selected">50</form:option>
                       <form:option value="100">100</form:option>
                       <form:option value="150">150</form:option>
                       <form:option value="200">200</form:option>
                       <form:option value="1000" >All</form:option>
                     </form:select>
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
                     <form:select id="reginalLimit" path="maxResults" cssClass="span-8" cssErrorClass="span-8 validationFailed" cssStyle="width:50px;">
                       <form:option value="50" selected="selected">50</form:option>
                       <form:option value="100">100</form:option>
                       <form:option value="150">150</form:option>
                       <form:option value="200">200</form:option>
                       <form:option value="1000" >All</form:option>
                     </form:select>
                   </td> 
                 </tr>
              </table>
            </form:form>
         </td>
        </tr>
      </table> 
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
	  <!-- <table>
	     <tr>
	        <td>
	          <ul>                        
		         <li><a href="http://localhost:8080/collegeSearch/school/getUsNewsBestSchoolPrograms/Business">Best Business Programs</a></li>
		     
		      </ul>
		   </td>
	  	   <td>
		      <ul>
			     <li><a href="http://localhost:8080/collegeSearch/school/getSchools?category=Liberal Arts">Top Liberal Arts Colleges</a></li>
		         <li><a href="http://localhost:8080/collegeSearch/school/getUsNewsBestSchoolPrograms/Engineering">Best Engineering Programs</a></li>
		      
		      </ul>
		   </td>
	   </tr>
	  </table>-->
      <table class="section_title_center">
        <tr><td>Top Colleges for Popular Majors</td></tr>
      </table> 
      <table class="center_element" style="margin-top:0px;">
	    <tr>
         <td>
           <ul>
			<li><a href="http://localhost:8080/collegeSearch/school/getPrincetonReviewGreatSchoolMajors/Accounting">Accounting Majors</a></li>
			<li><a href="http://localhost:8080/collegeSearch/school/getPrincetonReviewGreatSchoolMajors/Agriculture">Agriculture Majors</a></li>
			<li><a href="http://localhost:8080/collegeSearch/school/getPrincetonReviewGreatSchoolMajors/Biology">Biology Majors</a></li>
			<li><a href="http://localhost:8080/collegeSearch/school/getPrincetonReviewGreatSchoolMajors/Business_Finance">Business/Finance Majors</a></li>
			<li><a href="http://localhost:8080/collegeSearch/school/getPrincetonReviewGreatSchoolMajors/Communications">Communications Majors</a></li>
			<li><a href="http://localhost:8080/collegeSearch/school/getPrincetonReviewGreatSchoolMajors/Computer Science and Computer Engineering">Computer Science/Computer Engineering Majors</a></li>
			<li><a href="http://localhost:8080/collegeSearch/school/getPrincetonReviewGreatSchoolMajors/Criminology">Criminology Majors</a></li>
			<li><a href="http://localhost:8080/collegeSearch/school/getPrincetonReviewGreatSchoolMajors/Education">Education Majors</a></li>
		    <li><a href="http://localhost:8080/collegeSearch/school/getPrincetonReviewGreatSchoolMajors/English Literature and Language">English Literature and Language Majors</a></li>
			<li><a href="http://localhost:8080/collegeSearch/school/getPrincetonReviewGreatSchoolMajors/Engineering">Engineering Majors</a></li>
	      </ul>
       </td>
       <td>
		  <ul>
		    <li><a href="http://localhost:8080/collegeSearch/school/getPrincetonReviewGreatSchoolMajors/Environmental Studies">Environmental Studies Majors</a></li>
			<li><a href="http://localhost:8080/collegeSearch/school/getPrincetonReviewGreatSchoolMajors/Health Services">Health Services Majors</a></li>
			<li><a href="http://localhost:8080/collegeSearch/school/getPrincetonReviewGreatSchoolMajors/History">History Majors</a></li>
			<li><a href="http://localhost:8080/collegeSearch/school/getPrincetonReviewGreatSchoolMajors/Journalism">Journalism Majors</a></li>
			<li><a href="http://localhost:8080/collegeSearch/school/getPrincetonReviewGreatSchoolMajors/Marketing and Sales">Marketing and Sales Majors</a></li>
			<li><a href="http://localhost:8080/collegeSearch/school/getPrincetonReviewGreatSchoolMajors/Mathematics">Mathematics Majors</a></li>
			<li><a href="http://localhost:8080/collegeSearch/school/getPrincetonReviewGreatSchoolMajors/Mechanical Engineering">Mechanical Engineering Majors</a></li>
			<li><a href="http://localhost:8080/collegeSearch/school/getPrincetonReviewGreatSchoolMajors/Nursing">Nursing Majors</a></li>
		    <li><a href="http://localhost:8080/collegeSearch/school/getPrincetonReviewGreatSchoolMajors/Political Science and Government">Political Science/Government Majors</a></li>
			<li><a href="http://localhost:8080/collegeSearch/school/getPrincetonReviewGreatSchoolMajors/Psychology">Psychology Majors</a></li>
		  </ul>
	    </td>
	   </tr>
      </table>
      <table class="section_title_center">
        <tr><td>Colleges with Special Features</td></tr>
      </table> 
      <table class="center_element" style="width:80%">
	    <tr>
          <td>
		    <ul>
		  	  <li><a href="http://localhost:8080/collegeSearch/school/searchSchools?satActNotRequired=Yes">Colleges Do Not Require SAT or ACT</a></li>
              <!--<li><a href="http://localhost:8080/collegeSearch/school/searchSchools?school.internationalStudentApplication.financialAid=yes">Colleges Provides Financial Aids for International Students</a></li>-->
              <li><a href="http://localhost:8080/StrutsApp/search/Search.action?searchAction=Business">Value Colleges(quality/price ratio and the scholarships or grants)</a></li>
            </ul>
          </td>
          <td>
		    <ul>
			  <li><a href="http://localhost:8080/collegeSearch/school/searchSchools?toeflAcceptedInsteadOfSatOrAct=Yes">Colleges Accepts TOEFL Instead of SAT or ACT</a></li>
  		    </ul>
	      </td>
	    </tr>
      </table>
       <table class="section_title_center">
        <tr><td>Optimized College Lists</td></tr>
      </table> 
      <table class="center_element" style="margin-top:0px;">
	    <tr>
         <td>
           <ul>
			<li><a href="http://localhost:8080/collegeSearch/school/getPrincetonReviewGreatSchoolMajors/Accounting">Colleges With High Acceptance Rate in Top 50 National Colleges</a></li>
			<li><a href="http://localhost:8080/collegeSearch/school/getPrincetonReviewGreatSchoolMajors/Accounting">Colleges With High Acceptance Rate and Low Cost in top 50 National Colleges</a></li>
			
			<li><a href="http://localhost:8080/collegeSearch/school/getPrincetonReviewGreatSchoolMajors/ Agriculture">Agriculture Majors</a></li>
			<li><a href="http://localhost:8080/collegeSearch/school/getPrincetonReviewGreatSchoolMajors/Biology">Biology Majors</a></li>
			<li><a href="http://localhost:8080/collegeSearch/school/getPrincetonReviewGreatSchoolMajors/Business_Finance">Business/Finance Majors</a></li>
			<li><a href="http://localhost:8080/collegeSearch/school/getPrincetonReviewGreatSchoolMajors/Communications">Communications Majors</a></li>
			<li><a href="http://localhost:8080/collegeSearch/school/getPrincetonReviewGreatSchoolMajors/Computer Science and Computer Engineering">Computer Science/Computer Engineering Majors</a></li>
			<li><a href="http://localhost:8080/collegeSearch/school/getPrincetonReviewGreatSchoolMajors/Criminology">Criminology Majors</a></li>
			<li><a href="http://localhost:8080/collegeSearch/school/getPrincetonReviewGreatSchoolMajors/Education">Education Majors</a></li>
		    <li><a href="http://localhost:8080/collegeSearch/school/getPrincetonReviewGreatSchoolMajors/English Literature and Language">English Literature and Language Majors</a></li>
			<li><a href="http://localhost:8080/collegeSearch/school/getPrincetonReviewGreatSchoolMajors/Engineering">Engineering Majors</a></li>
	      </ul>
       </td>
       <td>
		  <ul>
		    <li><a href="http://localhost:8080/collegeSearch/school/getPrincetonReviewGreatSchoolMajors/Environmental Studies">Environmental Studies Majors</a></li>
			<li><a href="http://localhost:8080/collegeSearch/school/getPrincetonReviewGreatSchoolMajors/Health Services">Health Services Majors</a></li>
			<li><a href="http://localhost:8080/collegeSearch/school/getPrincetonReviewGreatSchoolMajors/History">History Majors</a></li>
			<li><a href="http://localhost:8080/collegeSearch/school/getPrincetonReviewGreatSchoolMajors/Journalism">Journalism Majors</a></li>
			<li><a href="http://localhost:8080/collegeSearch/school/getPrincetonReviewGreatSchoolMajors/Marketing and Sales">Marketing and Sales Majors</a></li>
			<li><a href="http://localhost:8080/collegeSearch/school/getPrincetonReviewGreatSchoolMajors/Mathematics">Mathematics Majors</a></li>
			<li><a href="http://localhost:8080/collegeSearch/school/getPrincetonReviewGreatSchoolMajors/Mechanical Engineering">Mechanical Engineering Majors</a></li>
			<li><a href="http://localhost:8080/collegeSearch/school/getPrincetonReviewGreatSchoolMajors/Nursing">Nursing Majors</a></li>
		    <li><a href="http://localhost:8080/collegeSearch/school/getPrincetonReviewGreatSchoolMajors/Political Science and Government">Political Science/Government Majors</a></li>
			<li><a href="http://localhost:8080/collegeSearch/school/getPrincetonReviewGreatSchoolMajors/Psychology">Psychology Majors</a></li>
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
