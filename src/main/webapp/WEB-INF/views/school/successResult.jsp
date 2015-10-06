<%@ include file="/WEB-INF/includes/taglibs.jsp"%>
<%@ include file="/WEB-INF/includes/doctype.jsp"%>
<%@ include file="/WEB-INF/includes/styles.jsp"%>

<html xmlns="http://www.w3.org/1999/xhtml" lang="en">

<head>
   <title>Result Page</title>
</head>

<body background="/WEB-INF/static/images/search_bg3.jpg">
  <div class="wide_container">
     <c:choose>
        <c:when test="${empty schoolList}">
           <div class="page_title">No School Found</div>
        </c:when>
        <c:otherwise>
           <div class="page_title">Search Result(${fn:length(schoolList)} schools)</div>
        </c:otherwise>
     </c:choose>
     <div class="wide_content">  
        <c:if test="${!empty schoolList}">
           <table class="datatable" style="font-size: 80%">
             <tr style="background-color: Ivory;">
              	<th>School</th>
              	<c:if test="${operation ne 'getPrincetonReviewGreatSchoolMajors'}">
				   <th>Rank</th>
				   <!--<th>Last Year Rank</th>-->
				</c:if>   
				<!--<th>Size(Students)</th>
                <th>Type</th>-->
				<th>Tuition+Fees<font size="1"></font></th>
				<th>Room+Board<font size="1"></font></th>
				<th>Appl. Fee<font size="1"></font></th>
				<th>Appl. Deadline<font size="1">(mm-dd)</font></th>
				<th>Min. TOEFL Score</th>
				<th>SAT I<font size="1">(25th - 75th%)</font></th>
				<th>ACT<font size="1">(25th% - 75th%)</font></th>
				<th>SAT II Required</th>
				<!--<th>Selectivity</th>-->
				<th>Accept. Rate<font size="1"></font></th>
				<th>Location</th>
				<th>Financial Aid for Intl. Students</th>
				<!--<th>Website</th>-->
			</tr>
			<c:forEach var="school" items="${schoolList}" varStatus="loopStatus">  
                <tr class="${loopStatus.index % 2 == 0 ? 'even' : 'odd'}">
                    <td style="color : red"><a id="schoolDetail" href="<spring:url value="/school/getSchoolDetail/${school.name}" />">${school.name}</a></td>
					<!--<td><a href="http://www."${school.website}></a></td>-->
					<!--<td>${school.name}</td>-->
					<c:if test="${operation ne 'getPrincetonReviewGreatSchoolMajors'}">
					   <td>${school.rankOverall}</td>
		    		</c:if>
            		<!--<td>${school.size}</td>
                    <td>${school.type}</td>-->
					<td>$${school.tuitionFee}</td>
					<td>$${school.roomBoard}</td>
					<td>$${school.applicationFee}</td>
					<td>${school.applicationDeadline}</td>
					<c:choose>
					  <c:when test="${school.toefl < 0}">
                        <td>Not Required</td>
                      </c:when>
					  <c:when test="${school.toefl == 0}">
                        <td>N/A</td>
                      </c:when>
                      <c:otherwise>
                        <td>${school.toefl}</td> 
                      </c:otherwise>
                    </c:choose>
					<c:choose>
					  <c:when test="${school.sat1Percentile25 <= 0}">
                        <td>N/A</td>
                      </c:when>
                      <c:otherwise>
					    <td>${school.sat1Percentile25} - ${school.sat1Percentile75}</td>
					  </c:otherwise>
					 </c:choose>  
					 <c:choose>
					   <c:when test="${school.actPercentile25 <= 0}">
                         <td>N/A</td>
                       </c:when>
                       <c:otherwise>
					     <td>${school.actPercentile25} - ${school.actPercentile75}</td>
					   </c:otherwise>
				    </c:choose>    
					<td>${school.numberOfRequiredSat2}</td>
					<!--<td>${school.selectivity}</td>-->
					<td>${school.acceptRate}%</td>
					<td>${school.city}, ${school.state}</td>
					<td>${school.internationalFinancialAid}</td>
					<!--<td><a id="website" href="<spring:url value="/collegeSearch/school/getSchool/${school.website}" />">${school.website}</a></td>-->
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
