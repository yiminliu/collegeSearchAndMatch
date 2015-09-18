<%@ include file="/WEB-INF/includes/taglibs.jsp"%>
<%@ include file="/WEB-INF/includes/doctype.jsp"%>
<%@ include file="/WEB-INF/includes/styles.jsp"%>

<div id="keyword_search">
   <table>
 	 <tr>
 	    <form:form method="GET" action="searchSchoolsByMatchNamePattern" modelAttribute="school">
         <table>
            <tr>
               <td>
                  <form:label path="name">
                     <img src="http://localhost:8080/collegeSearch/static/images/search.gif" width="60" height="28" />
                  </form:label>
               </td>
               <td><form:input path="name" placeholder="Search By Keyword"/></td>
               <td><input name="submit" type="submit" value="Go" /></td>
            </tr>
         </table>
   </form:form>
	     </tr>
   </table>
</div>
