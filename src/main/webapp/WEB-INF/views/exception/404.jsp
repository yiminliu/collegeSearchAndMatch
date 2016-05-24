<%@ include file="/WEB-INF/includes/taglibs.jsp"%>
<%@ include file="/WEB-INF/includes/doctype.jsp"%>
<%@ include file="/WEB-INF/includes/styles.jsp"%>

<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
     <title>College Consulting System -- Page Not Found</title>
  </head>
  <body>
    <div class="container"> 
       <div> <h2>HTTP Status 404 -- Page Not Found</h2></div>
       <div class="content"> 
         <h3 style="margin-bottom: 10px; padding-bottom: 0px; border-bottom: 1px #ccc dotted;">There was a problem</h3>
         <p>The page that you requested could not be found. Please check the link or URL and try again.</p>
       </div>
        <table  class="center" style="margin: 0 auto; cellspacing: 30px; cellpadding: 30px; border-spacing: 50px;">
          <tr>
             <td><a id="schoolHome" href="<spring:url value="/school/home" />" class="button_l"><span style="cellspacing: 30px; cellpadding: 30px;">School Home</span></a></td>
          </tr>
        </table>
    </div><!-- container --> 
    <%@ include file="/WEB-INF/views/general/footer.jsp"%>     
 </body>
</html>