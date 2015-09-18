<%@ include file="/WEB-INF/includes/taglibs.jsp"%>
<%@ include file="/WEB-INF/includes/doctype.jsp"%>
<%@ include file="/WEB-INF/includes/styles.jsp"%>

<div>
  <sec:authentication var="user" property="principal" />
  <sec:authorize access="isAuthenticated()"> 
    <table style="float: right; margin-right: 20px">
      <tr>
        <td>Logged in user:  <span style="color: BLUE;"> ${user.username}</span></td>
        <td><a href="<spring:url value='/j_spring_security_logout' />">  <span style="font-style: italic;">(Logout)</span></a></td>
      </tr>
    </table>
  </sec:authorize>  
  <sec:authorize access="hasRole('ROLE_ANONYMOUS')"> 
    <table style="float: right; border-spacing: 20px, 0px; margin-right: 20px">
      <tr>
         <!--<td>Anonymous user</td>-->
         <td><a href="<spring:url value='/login' />"><span style="font-style: italic;">Sign In</span></a>  | </td>
         <td><a href="<spring:url value='/login.jsp' />"><span style="font-style: italic;">Sign Up</span></a></td>
      </tr>
    </table>
  </sec:authorize>  
</div>