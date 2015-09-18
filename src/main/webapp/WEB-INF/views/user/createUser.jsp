<%@ include file="/WEB-INF/includes/taglibs.jsp"%>
<%@ include file="/WEB-INF/includes/doctype.jsp"%>
<%@ include file="/WEB-INF/includes/styles.jsp"%>

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
<title>College Search -- Create An User</title>
</head>
<body>
<%@ include file="/WEB-INF/views/general/header.jsp"%>
<div class="container">
<spring:url var="action" value="/user/createUser" />
<form:form method="POST" action="${action}" modelAttribute="user">
  <div style="color:Green"> <h3>Enter User Information</h3></div>
   <table class="category">
      <tr>
         <td><label>User Name<span style="color:red;">*</span>: </label>  <form:input path="userName" style="text-transform:uppercase;"></form:input><small>(maximum 18 characters)</small></td>
      </tr>
      <tr>
         <td><form:errors path="userName" cssClass="error" /></td>               
      </tr>
      <tr>   
         <td><label>email<span style="color:red;">*</span>: </label>  <form:input path="email"></form:input><small>(maximum 8 characters)</small></td>
      </tr>
      <tr>
         <td><form:errors path="email" cssClass="error" /></td>               
      </tr>
      <tr>  
         <td><label>Password<span style="color:red;">*</span>: </label>  <form:input path="password"></form:input><small>(maximum 40 characters)</small></td>
      </tr>
      <tr>
         <td><form:errors path="password" cssClass="error" /></td>               
      </tr>
      <tr> 
        <td calss="narrow"><label for="enabled">Status: </label>
              <c:forEach var="itemStatus" items="${statusList}" varStatus="status">
                 <form:radiobutton path="newFeature.status" value="${itemStatus}" />${itemStatus}
              </c:forEach>
        </td>
      </tr>
    </table>
    <table> 
      <tr > 
        <td>
            <input type="submit" value="Next >"/>
        </td>
      </tr>
   </table> 
</form:form>
<%@ include file="/WEB-INF/views/general//footer.jsp"%>
</div><!-- container -->
</body>
</html>
