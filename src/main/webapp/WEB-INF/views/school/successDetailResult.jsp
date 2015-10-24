<%@ include file="/WEB-INF/includes/taglibs.jsp"%>
<%@ include file="/WEB-INF/includes/doctype.jsp"%>
<%@ include file="/WEB-INF/includes/styles.jsp"%>

<html xmlns="http://www.w3.org/1999/xhtml" lang="en">

<head>
   <title>Result Page</title>
</head>

<body background="/WEB-INF/static/images/search_bg3.jpg">
  <div class="narrow_container">
      <div><%@ include file="/WEB-INF/views/general/header.jsp"%></div>
      <c:choose>
         <c:when test="${empty school}">
             <div class="page_title">No School Found</div>
         </c:when>
         <c:otherwise>
            <div class="page_title">${school.name}</div>
         </c:otherwise>
      </c:choose>
      <div>
        <c:if test="${!empty school}">
          <div class="section_title">School Summary</div>
          <table class="datatable" style="font-size: 80%; margin-left: 0px">
             <tr style="background-color: Ivory;">
              	<th>Type</th>
                <th>Setting</th>
                <th>Category</th>
				<th>Location</th>
				<th>Academic calendar</th> 
				<th>Phone</th>
				<th>Website</th>
			 </tr>
		     <tr>
            	<td>${school.type}</td>
                <td>${school.setting}</td>
                <td>${school.category}</td>
               	<td>${school.city}, ${school.state}</td>
				<td>${school.calendar}</td> 
				<td>${school.phone}</td>
				<td><a id="website" href="<spring:url value="http://www.${school.website}" />">${school.website}</a></td>
			   </tr>
		   </table>
		   <div class="section_title">Student and Class Info</div>
           <table class="datatable" style="font-size: 80%; margin-left: 0px">
             <tr style="background-color: Ivory;">
             	<th>Total Students</th>
             	<th>Student/Faculty Ratio</th>
              	<th>Average Freshman Retention Rate</th>
                <th>Graduation Rate(6 year)</th>
              	<th>Class size<25</th>
              	<th>Class size between 25 and 50</th>
              	<th>Class size>50</th>
              </tr>
		     <tr>
            	<td>${school.size}</td>
            	<td>${school.studentFacultyRatio}</td>
            	<c:choose>
				  <c:when test="${school.averageFreshmanRetentionRate >= 0}">
            	     <td>${school.averageFreshmanRetentionRate}</td>
                  </c:when>
                  <c:otherwise>
                    <td>N/A</td> 
                  </c:otherwise>
                </c:choose>
                <c:choose>
				  <c:when test="${school.sixYearGraduationRate >= 0}">
            	     <td>${school.sixYearGraduationRate}</td>
                  </c:when>
                  <c:otherwise>
                    <td>N/A</td> 
                  </c:otherwise>
                </c:choose>
       
            	<c:choose>
				  <c:when test="${school.percentageClassesFewerThan20Students >= 0}">
            	     <td>${school.percentageClassesFewerThan20Students}</td>
                  </c:when>
                  <c:otherwise>
                    <td>N/A</td> 
                  </c:otherwise>
                </c:choose>
                <c:choose>
				  <c:when test="${school.percentageClassesBetween25And50Students >= 0}">
            	     <td>${school.percentageClassesBetween25And50Students}</td>
                  </c:when>
                  <c:otherwise>
                    <td>N/A</td> 
                  </c:otherwise>
                </c:choose>
                <c:choose>
				  <c:when test="${school.percentageClassesMoreThan50Students >= 0}">
            	     <td>${school.percentageClassesMoreThan50Students}</td>
			      </c:when>
                  <c:otherwise>
                    <td>N/A</td> 
                  </c:otherwise>
                </c:choose>
		   </table>
           <div class="section_title">Admission Info</div>
           <table class="datatable" style="font-size: 80%; margin-left: 0px">
             <tr style="background-color: Ivory;">
              	<th>Overall Rank</th>
              	<th>Acceptance Rate<font size="1"></font></th>
              	<th>Selectivity</th>
              	<th>Reputation Score</th>
              	<th>Application Deadline<font size="1">(mm-dd)</font></th>
              	<th>Early Decision Deadline<font size="1">(mm-dd)</font></th>
              	<th>SAT/ACT Received Deadline<font size="1">(mm-dd)</font></th>
             	<th>Application Fee<font size="1"></font></th>
				<th>Top 10% of High School Class</th>
			</tr>
		    <tr>
            	 <c:choose>
                       <c:when test="${school.rankOverall > 0}">
					      <td>${school.rankOverall}</td>
					   </c:when> 
					   <c:when test="${school.rankOverall < 0}">
					      <td>Not Ranked</td>
					   </c:when>  
					   <c:otherwise>
					      <td>Not Reported</td>
					   </c:otherwise>
					</c:choose> 
            	<td>${school.acceptRate}%</td>
            	<td>${school.selectivity}</td>
            	<td>${school.reputationScore}</td>
            	<c:choose>
				  <c:when test="${school.applicationDeadline != null}">
            	     <td>${school.applicationDeadline}</td>
                  </c:when>
                  <c:otherwise>
                    <td>N/A</td> 
                  </c:otherwise>
                </c:choose>
                <c:choose> 
            	  <c:when test="${school.earlyDecisionDeadline != null}">
            	     <td>${school.earlyDecisionDeadline}</td>
                  </c:when>
                  <c:otherwise>
                    <td>N/A</td> 
                  </c:otherwise>
                </c:choose>
            	<c:choose> 
            	  <c:when test="${school.satActReceivedDeadline != null}">
            	     <td>${school.satActReceivedDeadline}</td>
                  </c:when>
                  <c:otherwise>
                    <td>N/A</td> 
                  </c:otherwise>
                </c:choose>
             	<td>$${school.applicationFee}</td>
				<td>${school.hsClassTop10Percentage}%</td>
	    	</tr>
		  </table>
		  <div class="section_title" style="font-size: 90%;">Admission Requirements</div>
           <table class="datatable" style="font-size: 80%; margin-left: 0px">
             <tr style="background-color: Ivory;">
              	<th>Minimum TOEFL Score</th>
              	<th>Minimum IELTS Score</th>
            	<th>SAT I Score<font size="1">(25th% - 75th%)</font></th>
				<th>ACT Score<font size="1">(25th% - 75th%)</font></th>
				<th>SAT/ACT Not Required</th>
				<th>SAT II Required</th>
			 </tr>
		     <tr>
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
				  <c:when test="${school.ielts < 0}">
                     <td>Not Required</td>
                  </c:when>
				  <c:when test="${school.ielts == 0}">
                     <td>N/A</td>
                  </c:when>
                  <c:otherwise>
                     <td>${school.ielts}</td> 
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
			   <c:choose>
			      <c:when test="${school.satActNotRequired != null}">
                    <td>${school.satActNotRequired}</td>
                  </c:when>
				  <c:otherwise>
                     <td>No</td> 
                  </c:otherwise>
               </c:choose>
				 <td>${school.numberOfRequiredSat2}</td>
			 </tr>
		  </table>
		  <div class="section_title">Cost and Financial Info</div>
          <table class="datatable" style="font-size: 80%; margin-left: 0px">
             <tr style="background-color: Ivory;">
              	<th>Tuition and Fees<font size="1"></font></th>
              	<c:if test="${school.instateTuitionFee != null && school.instateTuitionFee > 0}">
				   <th>In-state Tuition and Fees<font size="1"></font></th>
				</c:if>   
				<th>Room and Board<font size="1"></font></th>
				<th>Financial Aid for International Students</th>
			 </tr>
		     <tr>
            	<td>$${school.tuitionFee}</td>
            	<c:if test="${school.instateTuitionFee != null && school.instateTuitionFee > 0}">
				   <td>$${school.instateTuitionFee}</td>
				</c:if>   
				<td>$${school.roomBoard}</td>
				<td>${school.internationalFinancialAid}</td>
			 </tr>
		  </table>
		  <div class="section_title">Best Majors</div>
          <table class="datatable" style="font-size: 80%; margin-left: 0px">
             <tr style="background-color: Ivory;">
         	 </tr>
		  </table>		 		 
	   </c:if>
	 </div>
	 <table  class="center" style="margin: 0 auto; cellspacing: 30px; cellpadding: 30px; border-spacing: 50px;">
        <tr>
           <td><a id="schoolHome" href="<spring:url value="/school/home" />" class="button_m"><span style="cellspacing: 30px; cellpadding: 30px;">School Home</span></a></td>
           <sec:authorize access="isAuthenticated()">
              <td><a id="adminHome" href="<spring:url value="/admin/adminHome" />" class="button_m"><span style="cellspacing: 30px; cellpadding: 30px;">Admin Home</span></a></td>
              <td><a id="updateSchool" href="<spring:url value="/school/updateSchool/${school.name}" />" class="button_m"><span style="cellspacing: 30px; cellpadding: 30px;">Update School</span></a></td>
           </sec:authorize>
        </tr>
     </table>
     <%@ include file="/WEB-INF/views/general/footer.jsp"%>
   </div>
	
</body>
</html>
