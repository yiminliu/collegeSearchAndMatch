<%@ include file="/WEB-INF/includes/taglibs.jsp"%>
<%@ include file="/WEB-INF/includes/doctype.jsp"%>
<%@ include file="/WEB-INF/includes/styles.jsp"%>
<%@ include file="/WEB-INF/views/general/header.jsp"%>
 

<html xmlns="http://www.w3.org/1999/xhtml" lang="en">

<head>
   <title>Main Page</title>
</head>

<body background="http://localhost:8080/collegeSearch/static/images/search_bg3.jpg">
  <div class="container">
      <table style="border:1px; text-align: center; margin: auto; width: 80%">
           <tr class="center_element" style="width:80%">
              <td ><a id="searchSchool" href="<spring:url value="/school/searchSchools" />" class="button-l" style="margin: auto"><span>College Search Engine to Find Your Suitable Colleges</span></a></td>
           </tr>
         </table>
     <hr></hr>
     <!--<font color="#9999ff" size=5">Search Colleges with Your Own Criteria</font>-->
     <!--<div class="page_title">Get The Best College Lists</div>-->
     <table class="center" style="border-spacing: 100px, 0px">
	   <tr aline="center">
		<td>
		<ul>
			<li><a href="http://localhost:8080/collegeSearch/school/getSchools?limit=100">Top 100 Colleges (Overal Ranking)</a></li>
		</ul>
		</td>
		<td>
		<ul>
			<li><a href="http://localhost:8080/collegeSearch/school/getSchools?category=Liberal Arts">Top Liberal Arts Colleges</a></li>
		</ul>
		</td>
	   </tr>
	 </table>
     <hr></hr>
     <table align="center">
	   <tr aline="center">
         <td>
		  <ul>
			<li><a href="http://localhost:8080/StrutsApp/search/Search.action?searchAction=Business">Top Business Colleges</a></li>
			<li><a href="http://localhost:8080/StrutsApp/search/Search.action?searchAction=Business">Top Accounting</a></li> 
            <li><a href="http://localhost:8080/StrutsApp/search/Search.action?searchAction=Business">Top Entrepreneurship</a></li>
			<li><a href="http://localhost:8080/StrutsApp/search/Search.action?searchAction=Business">Top Finance</a></li>
			<li><a href="http://localhost:8080/StrutsApp/search/Search.action?searchAction=Business">Top Insurance</a></li>
			<li><a href="http://localhost:8080/StrutsApp/search/Search.action?searchAction=Business">Top International Business</a></li>
			<li><a href="http://localhost:8080/StrutsApp/search/Search.action?searchAction=Business">Top Management</a></li>
			<li><a href="http://localhost:8080/StrutsApp/search/Search.action?searchAction=Business">Top Management Information Systems</a></li>
			<li><a href="http://localhost:8080/StrutsApp/search/Search.action?searchAction=Business">Top Marketing</a></li>
			<li><a href="http://localhost:8080/StrutsApp/search/Search.action?searchAction=Business">Top Production/Operations Management</a></li>
			<li><a href="http://localhost:8080/StrutsApp/search/Search.action?searchAction=Business">Top Quantitative Analysis</a></li>
			<li><a href="http://localhost:8080/StrutsApp/search/Search.action?searchAction=Business">Top Real Estate</a></li>
			<li><a href="http://localhost:8080/StrutsApp/search/Search.action?searchAction=Business">Top Supply Chain Management/Logistics</a></li>
          </ul>
       </td>
       <td>
		  <ul>
			<li><a href="http://localhost:8080/StrutsApp/search/Search.action?searchAction=Engineering">Top Colleges in Engineering Programs</a></li>
			<li><a href="http://localhost:8080/StrutsApp/search/Search.action?searchAction=Business">Top Aerospace/Aeronautical/Astronautical</a></li>
			<li><a href="http://localhost:8080/StrutsApp/search/Search.action?searchAction=Business">Top Agricultural</a></li>
			<li><a href="http://localhost:8080/StrutsApp/search/Search.action?searchAction=Business">Top Biomedical/Biomedical Engineering</a></li>
			<li><a href="http://localhost:8080/StrutsApp/search/Search.action?searchAction=Business">Top Chemical</a></li>
			<li><a href="http://localhost:8080/StrutsApp/search/Search.action?searchAction=Business">Top Civil</a></li>
			<li><a href="http://localhost:8080/StrutsApp/search/Search.action?searchAction=Business">Top Computer Engineering</a></li>
			<li><a href="http://localhost:8080/StrutsApp/search/Search.action?searchAction=Business">Top Electrical/Electronic/Communications</a></li>
			<li><a href="http://localhost:8080/StrutsApp/search/Search.action?searchAction=Business">Top Engineering Science/Engineering Physics</a></li>
			<li><a href="http://localhost:8080/StrutsApp/search/Search.action?searchAction=Business">Top Environmental / Environmental Health</a></li>
			<li><a href="http://localhost:8080/StrutsApp/search/Search.action?searchAction=Business">Top Industrial/Manufacturing</a></li>
			<li><a href="http://localhost:8080/StrutsApp/search/Search.action?searchAction=Business">Top Materials</a></li>
			<li><a href="http://localhost:8080/StrutsApp/search/Search.action?searchAction=Business">Top Mechanical</a></li>
  		 </ul>
	   </td>
	</tr>
  </table>
  <hr></hr>
   <!-- <table align="center">
	  <tr aline="center">
         <td>
		    <ul>
		  	  <li><a href="http://localhost:8080/StrutsApp/search/Search.action?searchAction=Business">Colleges Do Not Need SAT1</a></li>
              <li><a href="http://localhost:8080/StrutsApp/search/Search.action?searchAction=Business">Colleges Provides Fincial Aids for International Students</a></li>
            </ul>
         </td>
         <td>
		    <ul>
			  <li><a href="http://localhost:8080/StrutsApp/search/Search.action?searchAction=Engineering">Top Colleges in Engineering Programs</a></li>
  		    </ul>
	     </td>
	  </tr>
  </table>-->
  </div><!-- container -->  
  <!-- <%@ include file="/WEB-INF/includes/footer.jsp"%>-->
     
</body>
</html>
