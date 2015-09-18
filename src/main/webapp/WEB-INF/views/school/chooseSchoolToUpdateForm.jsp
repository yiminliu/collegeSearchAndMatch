<%@ include file="/WEB-INF/includes/taglibs.jsp"%>
<%@ include file="/WEB-INF/includes/doctype.jsp"%>
<%@ include file="/WEB-INF/includes/styles.jsp"%>

<html xmlns="http://www.w3.org/1999/xhtml" lang="en">

<head>
   <title>Result Page</title>
</head>

<body background="/WEB-INF/static/images/search_bg3.jpg">
  <div class="container">
     <c:choose>
        <c:when test="${empty schoolList}">
           <div class="page_title">No School Found</div>
        </c:when>
        <c:otherwise>
           <div class="page_title" style="width: 85%">Please Choose the School Name from the Following to Update</div>
        </c:otherwise>
     </c:choose>
     <div class="content">  
        <c:if test="${!empty schoolList}">
           <table class="datatable" style="font-size: 100%">
             <tr style="background-color: Ivory;">
              	<th>School</th>
             	<th>Location</th>
		 	 </tr>
			 <c:forEach var="school" items="${schoolList}" varStatus="loopStatus">  
                <tr class="${loopStatus.index % 2 == 0 ? 'even' : 'odd'}">
                    <td style="color : red"><a id="schoolDetail" href="<spring:url value="/school/getSchoolDetail/${school.name}" />">${school.name}</a></td>
					<!--<td><a href="http://www."${school.website}></a></td>-->
					<!--<td>${school.name}</td>-->
					<td>${school.city}, ${school.state}</td>
			    </tr>
		   </c:forEach>
	      </table>
	    </c:if>
	    <div>
	      <table  class="center" style="margin: 0 auto; cellspacing: 30px; cellpadding: 30px; border-spacing: 50px;">
             <tr>
                <td><a id="schoolHome" href="<spring:url value="/school/home" />" class="button_m"><span style="cellspacing: 30px; cellpadding: 30px;">School Home</span></a></td>
                <c:if test="${operation eq 'searchSchools'}">
		           <td ><a id="searchSchool" href="<spring:url value="/school/showSearchSchoolForm" />" class="button_m"><span style="cellspacing: 30px; cellpadding: 30px;">Search Again</span></a></td>
       	        </c:if>
             </tr>
         </table>
       </div>
     </div> <!--content-->
     <!--<div>
       <%@ include file="/WEB-INF/views/general/footer.jsp"%>
     </div>--> 
 </div><!-- container -->   	
</body>
</html>
