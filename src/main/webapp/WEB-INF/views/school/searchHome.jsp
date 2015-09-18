<%@ include file="/WEB-INF/includes/taglibs.jsp"%>
<%@ include file="/WEB-INF/includes/doctype.jsp"%>
<%@ include file="/WEB-INF/includes/styles.jsp"%>

<html xmlns="http://www.w3.org/1999/xhtml" lang="en">

<head>
   <title>USA College Consulting Home Page</title>
</head>

<body background="http://localhost:8080/collegeSearch/static/images/search_bg3.jpg">
 <div class="container">
   <div><%@ include file="/WEB-INF/views/general/main_menu.jsp"%></div>
   <div><%@ include file="/WEB-INF/views/general/header.jsp"%></div>
   <div class="content">  
     <table class="center_element_text" style="border:1px; width: 100%">
        <tr>
           <td ><a id="searchSchool" href="<spring:url value="/school/showSearchSchoolForm" />" class="button-l" style="margin: auto; width: 60%"><span style="text-color: RED; text-weight: bold; font-style: italic">College Search Engine</span> -- Find Your Suitable Colleges</a></td>
        </tr>
     </table>
     <hr></hr>
     <!--<font color="#9999ff" size=5">Search Colleges with Your Own Criteria</font>-->
     <!--<div class="page_title">Get The Best College Lists</div>-->
     <table class="center_element" style="border-spacing: 80px, -90px">
	    <tr>
		   <td>
		      <ul>
			     <li><a href="http://localhost:8080/collegeSearch/school/getSchools?limit=100">Top 100 Colleges</a></li>
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
	 </table>
     <hr></hr>
     <div class="center_element_text" style="margin-bottom:0px;"><h3>Top Colleges for Popular Majors</h3></div>
     <table class="center_element" style="margin-top:0px;">
	    <tr>
         <td>
           <ul>
			<li><a href="http://localhost:8080/collegeSearch/school/getPrincetonReviewGreatSchoolMajors/Accounting">Accounting Majors</a></li>
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
  <hr></hr>
  <div class="center_element" style="width:80%">
     <table>
	  <tr>
         <td>
		    <ul>
		  	  <li><a href="http://localhost:8080/StrutsApp/search/Search.action?searchAction=Business">Colleges Do Not Require SAT1</a></li>
              <li><a href="http://localhost:8080/collegeSearch/school/searchSchools?internationalFinancialAid=yes">Colleges Provides Financial Aids for International Students</a></li>
              <li><a href="http://localhost:8080/StrutsApp/search/Search.action?searchAction=Business">Value Colleges(quality/price ratio and the scholarships or grants)</a></li>
            </ul>
         </td>
         <td>
		    <ul>
			  <li><a href="http://localhost:8080/StrutsApp/search/Search.action?searchAction=Engineering">Top Colleges in Engineering Programs</a></li>
  		    </ul>
	     </td>
	  </tr>
  </table>
   </div>
  </div> <!--content--> 
  <div>
    <%@ include file="/WEB-INF/views/general/footer.jsp"%>
  </div> <!-- footer --> 
 </div><!-- container --> 
  
</body>
</html>
