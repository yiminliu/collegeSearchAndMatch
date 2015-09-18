<%@ include file="/WEB-INF/includes/taglibs.jsp"%>
<%@ include file="/WEB-INF/includes/doctype.jsp"%>
<%@ include file="/WEB-INF/includes/styles.jsp"%>

<html xmlns="http://www.w3.org/1999/xhtml" lang="en">
  <head>
     <title>Create Item Success</title>
   </head>
<body>
  <%@ include file="/WEB-INF/views/general/header.jsp"%>
  <div class="home-container">
     <c:choose>
         <c:when test="${operation == 'Deleted'}">
           <h2>School: <span style="color:RED">${school.name} </span>Has Been ${operation} Successfully!</h2>
         </c:when>
         <c:otherwise>
            <h2>School: <span style="color:RED">${school.name} </span>Has Been ${operation} Successfully!</h2>
         </c:otherwise>
      </c:choose>
      <table style="border:1px; margin: 0 auto;">
        <tr>
          <c:if test="${operation != 'Deleted'}">
             <td><a id="viewSchool" href="<spring:url value="/school/getSchoolDetail/${school.name}" />" class="button_m"><span>View The School</span></a></td>
             <td><a id="modifySchool" href="<spring:url value="/dchool/updateSchool/${school.name}" />" class="button-m"><span>Edit The School</span></a></td>
             <td><a id="createSchool" href="<spring:url value="/school/createSchool" />" class="button_l"><span>Create A New School</span></a></td>
           </c:if>  
           <td><a id="schoolHome" href="<spring:url value="/school/home" />" class="button_m"><span>School Home</span></a></td>
        </tr>
     </table>
     <%@ include file="/WEB-INF/views/general/footer.jsp"%>
</div> <!-- Close container -->
</body>
</html>
