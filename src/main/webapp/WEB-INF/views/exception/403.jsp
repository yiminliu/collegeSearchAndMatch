<%@ include file="/WEB-INF/includes/taglibs.jsp"%>
<%@ include file="/WEB-INF/includes/doctype.jsp"%>

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
  <head>
     <title>College Consulting System - Access Denied</title>
  </head>
  <body>
    <%@ include file="/WEB-INF/views/general/header.jsp"%>
    <div> <h2>HTTP Status 403 -- Access Is Denied</h2></div>
    <div class="container">
            <h3 style="margin-bottom: 10px; padding-bottom: 0px; border-bottom: 1px #ccc dotted;">There was a problem</h3>
            <p>Your request to the page is denied.</p>
    </div>
    <table>
             <tr>
               <td><a id="schoolHome" href="<spring:url value="/school/home" />" class="button_m"><span>School Home</span></a></td>
             </tr>
    <%@ include file="/WEB-INF/views/general/footer.jsp"%>         
    </table>
</body>
</html>