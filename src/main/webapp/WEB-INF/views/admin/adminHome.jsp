<%@ include file="/WEB-INF/includes/taglibs.jsp"%>
<%@ include file="/WEB-INF/includes/doctype.jsp"%>
<%@ include file="/WEB-INF/includes/styles.jsp"%>

<html xmlns="http://www.w3.org/1999/xhtml" lang="en">
<head>
<title>School Management Admin Page</title>
 </head>
<body background="http://localhost:8080/collegeSearch/static/images/search_bg3.jpg">
  <%@ include file="/WEB-INF/views/general/header.jsp"%>
  <div class="container" style="margin-top:50px;">
      <div class="page_title">School Management System</div>
         <div class="content" style="margin-left:auto; margin-right:auto; align:center;">
          <table class="center_element">
            <tr><td>
            <ul>
               <li><a id="searchSchool" href="<spring:url value="/school/showSearchSchoolByNameForm"/>">Search School</a></li>
               <li><a id="createSchool" href="<spring:url value="/school/createSchool"/>">Create A School</a></li>
               <li><a id="updateSchool" href="<spring:url value="/school/updateSchoolForm"/>">Update A School</a></li>  
            </ul>
            </td>
            </tr>
            </table>
         </div>   
        <%@ include file="/WEB-INF/views/general/footer.jsp"%>
   </div> 
</body>
</html>