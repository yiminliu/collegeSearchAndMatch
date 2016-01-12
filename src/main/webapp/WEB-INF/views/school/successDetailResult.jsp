<%@ include file="/WEB-INF/includes/taglibs.jsp"%>
<%@ include file="/WEB-INF/includes/doctype.jsp"%>
<%@ include file="/WEB-INF/includes/styles.jsp"%>

<html xmlns="http://www.w3.org/1999/xhtml" lang="en">

<head>
   <title>Result Page</title>
</head>

<body background="/WEB-INF/static/images/search_bg3.jpg">
  <div class="narrow_container">
      <c:choose>
         <c:when test="${empty school}">
             <div class="page_title">No School Found</div>
         </c:when>
         <c:otherwise>
            <div class="page_title" id="banner" style="width:90%; margin-top:50px;margin-bottom:50px;">
                 School Detail Information For   ${school.name}
            </div>
         </c:otherwise>
      </c:choose>
      <div>
        <c:if test="${!empty school}">
          <div class="section_title">Summary</div>
          <table class="datatable" style="font-size: 80%; margin-left: 0px">
             <tr style="background-color: Ivory;">
                <th>Category</th>
                <th>Rank</th>
                <c:choose>
                   <c:when test="${school.instateTuitionFee != null && school.instateTuitionFee > 0}">
                      <th>Tuition and Fees 
                        <font size="1"> (in-state/out-state)</font>
                      </th>
                   </c:when>  
				   <c:otherwise>   
				      <th>Tuition and Fees</th>
				   </c:otherwise>
				</c:choose>   
              	<th>Room and Board<font size="1"></font></th>
               	<th>Selectivity</th>
           	  	<th>Accept Rate<font size="1"></font></th>
               	<!--<th>Reputation Score</th>-->
               	<th>Type</th>
                <th>Setting</th>
                <th>Location</th>
				<th>Academic calendar</th> 
				<th>Phone</th>
				<th>Website</th>
			 </tr>
		     <tr>
		        <td>${school.category}</td>
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
				<c:choose>
                   <c:when test="${school.instateTuitionFee != null && school.instateTuitionFee > 0}">
                      <td>$${school.instateTuitionFee} / $${school.tuitionFee}</td>
                   </c:when>  
				   <c:otherwise>   
				      <td>$${school.tuitionFee}</td>
				   </c:otherwise>
				</c:choose>   
				<td>$${school.roomBoard}</td>
				<c:choose>
				  <c:when test="${school.selectivity != null}">
				    <td>${school.selectivity}</td>
				  </c:when>
                  <c:otherwise>
                    <td>N/A</td> 
                  </c:otherwise>
                </c:choose>  
               	<c:choose>
				  <c:when test="${school.acceptRate != null}">
				    <td>${school.acceptRate}%</td>
				  </c:when>
                  <c:otherwise>
                     <td>N/A</td> 
                  </c:otherwise>
                </c:choose>  
            	<!--<td>${school.reputationScore}</td>-->
               	<td>${school.type}</td>
                <td>${school.setting}</td>
               	<td>${school.city}, ${school.state}</td>
				<td>${school.calendar}</td> 
				<td>${school.phone}</td>
				<td><a id="website" href="<spring:url value="http://www.${school.internationalStudentApplication.website}" />">${school.internationalStudentApplication.website}</a></td>
			   </tr>
		   </table>
		   <div class="section_title">Student/Class Info</div>
           <table class="datatable" style="font-size: 80%; margin-left: 0px">
             <tr style="background-color: Ivory;">
             	<th>Total Students</th>
             	<th>Student/Faculty Ratio</th>
           		<th>Top 10% of HS Class</th>
		       	<th>Ave. Freshman Retention Rate</th>
                <th>Graduat. Rate(6 yr)</th>
              	<th>Class size<25</th>
              	<th>Class size 25-50</th>
              	<th>Class size>50</th>
             </tr>
		     <tr>
            	<td>${school.size}</td>
            	<c:choose>
            	   <c:when test="${school.studentFacultyRatio != null}">
       			      <td>${school.studentFacultyRatio}</td>
       			   </c:when>
       			   <c:otherwise>
       			      <td>N/A</td>
       			   </c:otherwise>
       			</c:choose>  
              	<c:choose>
            	   <c:when test="${school.hsClassTop10Percentage >= 0}">
       			      <td>${school.hsClassTop10Percentage}%</td>
       			   </c:when>
       			   <c:otherwise>
       			      <td>N/A</td>
       			   </c:otherwise>
       			</c:choose>          
	           	<c:choose>
				  <c:when test="${school.averageFreshmanRetentionRate >= 0}">
            	     <td>${school.averageFreshmanRetentionRate}%</td>
                  </c:when>
                  <c:otherwise>
                    <td>N/A</td> 
                  </c:otherwise>
                </c:choose>
                <c:choose>
				  <c:when test="${school.sixYearGraduationRate >= 0}">
            	     <td>${school.sixYearGraduationRate}%</td>
                  </c:when>
                  <c:otherwise>
                    <td>N/A</td> 
                  </c:otherwise>
                </c:choose>
            	<c:choose>
				  <c:when test="${school.percentageClassesFewerThan20Students >= 0}">
            	     <td>${school.percentageClassesFewerThan20Students}$</td>
                  </c:when>
                  <c:otherwise>
                    <td>N/A</td> 
                  </c:otherwise>
                </c:choose>
                <c:choose>
				  <c:when test="${school.percentageClassesBetween25And50Students >= 0}">
            	     <td>${school.percentageClassesBetween25And50Students}%</td>
                  </c:when>
                  <c:otherwise>
                    <td>N/A</td> 
                  </c:otherwise>
                </c:choose>
                <c:choose>
				  <c:when test="${school.percentageClassesMoreThan50Students >= 0}">
            	     <td>${school.percentageClassesMoreThan50Students}%</td>
			      </c:when>
                  <c:otherwise>
                    <td>N/A</td> 
                  </c:otherwise>
                </c:choose>
             </tr>   
		   </table>
           <div class="section_title">Application Info</div>
           <table class="datatable" style="font-size: 80%; margin-left: 0px">
             <tr style="background-color: Ivory;">
                <th>SAT Score<font size="1">(25-75th%)</font></th>
				<th>ACT Score<font size="1">(25-75th%)</font></th>
				<th>SAT/ACT Not Required</th>
				<th>SAT II Required</th>
              	<th>Application Deadline</th>
              	<th>Early Decision Deadline</th>
              	<th>SAT/ACT Received Deadline</th>
             	<th>Application Fee</th>
			</tr>
		    <tr>
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
		   	</tr>
		  </table>
		  <!--<div class="section_title" style="font-size: 90%;">Admission Requirements</div>
           <table class="datatable" style="font-size: 80%; margin-left: 0px">
             <tr style="background-color: Ivory;">
             	<th>SAT I Score<font size="1">(25th% - 75th%)</font></th>
				<th>ACT Score<font size="1">(25th% - 75th%)</font></th>
				<th>SAT/ACT Not Required</th>
				<th>SAT II Required</th>
			 </tr>
		     <tr>
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
		  -->
		  <div class="section_title" style="font-size: 90%;">International Student Application</div>
           <table class="datatable" style="font-size: 80%; margin-left: 0px">
             <tr style="background-color: Ivory;">
              	<th>TOEFL Score (min/ave)</th>
              	<th>IELTS Score (min/ave)</th>
            	<th>Separate Application Form Required</th>
            	<th>TOEFL Accepted Instead of SAT/ACT</th>
				<th>Conditional Admission Offered</th>
				<th>Application Deadline(Fall/Spring)</th>
			 </tr>
		     <tr>
                <c:choose>
				  <c:when test="${school.internationalStudentApplication.minimumToeflScore < 0}">
                     <td>Not Required</td>
                  </c:when>
				  <c:when test="${school.internationalStudentApplication.minimumToeflScore == null && school.internationalStudentApplication.averageToeflScore == null}">
                     <td>N/A</td>
                  </c:when>
                  <c:otherwise>
                    <td>${school.internationalStudentApplication.minimumToeflScore}/${school.internationalStudentApplication.averageToeflScore}</td> 
                  </c:otherwise>
                </c:choose>
                <c:choose>
				  <c:when test="${school.internationalStudentApplication.minimumIeltsScore < 0}">
                     <td>Not Required</td>
                  </c:when>
				  <c:when test="${school.internationalStudentApplication.minimumIeltsScore == null}">
                     <td>N/A</td>
                  </c:when>
                  <c:otherwise>
                     <td>${school.internationalStudentApplication.minimumIeltsScore}/${school.internationalStudentApplication.averageIeltsScore}</td> 
                  </c:otherwise>
               </c:choose>
               <c:choose>
               	  <c:when test="${school.internationalStudentApplication.separateApplicationFormRrequired}">
                     <td>N/A</td>
                  </c:when>
                  <c:otherwise>
				    <td>${school.internationalStudentApplication.separateApplicationFormRrequired}</td>
				  </c:otherwise>
			   </c:choose>   
			   <c:choose>
               	  <c:when test="${school.internationalStudentApplication.toeflAcceptedInsteadOfSatOrAct == null}">
                     <td>N/A</td>
                  </c:when>
                  <c:otherwise>
				    <td>${school.internationalStudentApplication.toeflAcceptedInsteadOfSatOrAct}</td>
				  </c:otherwise>
			   </c:choose> 
			  <c:choose>
               	  <c:when test="${school.internationalStudentApplication.conditionalAdmissionOffered == null}">
                     <td>N/A</td>
                  </c:when>
                  <c:otherwise>
				    <td>${school.internationalStudentApplication.conditionalAdmissionOffered}</td>
				  </c:otherwise>
			   </c:choose> 
			   <td>${school.internationalStudentApplication.applicationDeadlineFall}/${school.internationalStudentApplication.applicationDeadlineSpring}</td>
			 </tr>
		  </table>
		   <div class="section_title" style="font-size: 90%;">International Student Application</div>
           <table class="datatable" style="font-size: 80%; margin-left: 0px">
             <c:set var="applying" value="${school.internationalStudentApplication.internationalStudentsApplying}" scope="session" />
             <c:set var="accepted" value="${school.internationalStudentApplication.internationalStudentsAccepted}" scope="session"/>
             <c:set var="enrolled" value="${school.internationalStudentApplication.internationalFreshmenEnrolled}" scope="session"/>
             <c:set var="acceptRatio" value="${accepted/applying*100}" />
             <c:set var="freshmanRetantionRatio" value="${enrolled/accepted*100}" />
             <tr style="background-color: Ivory;">
                <th>Financial Aid for International Students</th>
              	<th>International Students Applied/Accepted/Enrolled</th>
              	<c:choose>
              	   <c:when test="${applying != null && applying != 0}">
              	     <th>Int'l Student Accept Rate</th>
				   </c:when>
				</c:choose> 
				<c:choose>
              	   <c:when test="${accepted != null && accepted != 0}">
              	      <th>Int'l Student Freshman Retantion Rate</th>
				   </c:when>
				</c:choose>       
				<th>International Admission Contact</th>
				<c:choose>
				  <c:when test="${school.internationalStudentApplication.note != null}">
				     <th>Note</th>
				  </c:when>
				</c:choose>     
			 </tr>
		     <tr>
		       <td>${school.internationalStudentApplication.financialAid}</td>
               <td>${applying}/${accepted}/${enrolled}</td>
			   <c:choose>
				  <c:when test="${school.internationalStudentApplication.internationalStudentAcceptRate != null}">
				     <td>${school.internationalStudentApplication.internationalStudentAcceptRate}%</td>
				  </c:when>
			   </c:choose>
			   <c:choose>
				  <c:when test="${school.internationalStudentApplication.internationalStudentRetentionRate != null}">
				     <td>${school.internationalStudentApplication.internationalStudentRetentionRate}%</td>
				  </c:when>
			   </c:choose>
			   <td>${school.internationalStudentApplication.contact}</td>	
			   <c:choose>
				  <c:when test="${school.internationalStudentApplication.note != null}">
				     <th>${school.internationalStudentApplication.note}</th>
				  </c:when>
				</c:choose>  
			 </tr>
		  </table>
		 <!-- <div class="section_title">Cost and Financial Info</div>
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
				<td>${school.internationalStudentApplication.financialAid}</td>
			 </tr>
		  </table>-->
		  <div class="section_title">Best Majors</div>
          <table class="datatable" style="font-size: 80%; margin-left: 0px">
             <tr style="background-color: Ivory;">
               <td>
                 <c:forEach var="major" items="${school.bestMajors}" varStatus="loopStatus">
                    <c:choose>
               	     <c:when test="${loopStatus.index == fn:length(school.bestMajors)-1}">
               	        <a id="major" href="<spring:url value="/school/getPrincetonReviewGreatSchoolMajors/${major.name}" />">${major.name}</a>
                       </c:when>
                       <c:otherwise>
				  <a id="major" href="<spring:url value="/school/getPrincetonReviewGreatSchoolMajors/${major.name}" />">${major.name}</a>,
			     </c:otherwise>
			  </c:choose>                    
                </c:forEach>  
               </td>     
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
     <!--<%@ include file="/WEB-INF/views/general/footer.jsp"%>-->
   </div>
	
</body>
</html>
