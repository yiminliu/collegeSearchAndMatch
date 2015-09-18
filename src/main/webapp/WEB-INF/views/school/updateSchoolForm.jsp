<%@ include file="/WEB-INF/includes/taglibs.jsp"%>
<%@ include file="/WEB-INF/includes/doctype.jsp"%>
<%@ include file="/WEB-INF/includes/styles.jsp"%>

<html xmlns="http://www.w3.org/1999/xhtml" lang="en">
<head>
<title>Item Management System -- Update Item</title>
</head>
<body>
  <%@ include file="/WEB-INF/views/general/header.jsp"%>
   <div class="home_container">
   <div class="page_title">Update A School</div>
   
   <c:if test="${empty school.name && empty schoolList && submitted eq 'yes'}">
   <c:out value="${school.name}" />
    <c:out value="${schoolList}" />
     <c:out value="${submitted}" />
 
     <div class="page_title">No School Found for the School Name : "${schoolName}"</div>
   </c:if>  
   <form:form method="GET" action="updateSchool" modelAttribute="school">
     <table class="table_center">
        <tr>
           <td><form:label path="name">Enter School Name:</form:label></td>
           <td><form:input name="name" path="name" /></td>
        </tr>
        <tr>
           <td><form:errors path="name" cssClass="error" /></td>               
        </tr>
     </table>
     <table class="center_element" style="marging-top:80px">    
        <tr>
           <td>
               <input name="submit" type="submit" value="Submit"/>
           </td>
        </tr>
     </table>  
   </form:form>
   <%@ include file="/WEB-INF/views/general/footer.jsp"%>
</div><!-- container -->
</body>
</html>
