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
        <c:when test="${empty bestSchoolMajorList}">
           <div class="page_title">No School Found</div>
        </c:when>
        <c:when test="${not empty title && operation eq 'getBestSchoolsOfMajor'}">
           <div class="page_title_wide">Top Colleges in ${title} Program (${fn:length(bestSchoolMajorList)} found)</div>
        </c:when>
        <c:when test="${not empty title && operation eq 'listSchools'}">
           <div class="page_title_wide">${title}</div>
        </c:when>
        <c:when test="${not empty title}">
           <div class="page_title_wide">Great Colleges in ${title} Majors (${fn:length(bestSchoolMajorList)} found)</div>
        </c:when>
        <c:otherwise>          
           <div class="page_title">Search Result(${fn:length(bestSchoolMajorList)} found)</div>
        </c:otherwise>
     </c:choose>
     <div class="wide_content">  
        <c:if test="${!empty bestSchoolMajorList}">
           <table class="datatable" style="font-size: 80%">
             <tr style="background-color: Ivory;">
                <th>School</th>
                <c:if test="${operation=='searchSchools'}">
			 <th>Category</th>
		    </c:if>   
                <th>Rank</th>
		       <!--<th>Last Year Rank</th>-->
		    <!--<th>Size(Students)</th>
                <th>Type</th>-->
		    <!--<th>Tuition+Fees<font size="1"></font></th>
		    <th>Room+Board<font size="1"></font></th>-->
		    <th>Total Cost<font size="1"></font>
	   	    <th>Accept Rate<font size="1"></font></th>
	   	    <th>SAT1/ACT<font size="1"> (25th-75th%)</font></th>
	 	    <!--<th>SAT II Required</th>-->
	  	    <th>Ave. GPA</th>
		    <th>TOEFL Score (Min/Avg)</th>	
		    <th>SAT/ACT Not Required</th>
		    <th>TOEFL Accepted Instead of SAT/ACT</th>			
		    <!--<th>Selectivity</th>-->
		    <th>Appl. Deadline</th>
		    <th>Appl. Fee</th>
		    <th>Location</th>
		    <!--<th>Financial Aid for Intl. Students</th>-->
		    <!--<th>Website</th>-->
		 </tr>
		 <c:forEach var="major" items="${bestSchoolMajorList}" varStatus="loopStatus">  
                <tr class="${loopStatus.index % 2 == 0 ? 'even' : 'odd'}">
                    <td style="color : red"><a id="schoolDetail" href="<spring:url value="/school/getSchoolDetail/${major.school.id}" />">${major.school.name}</a></td>
		 	  <!--<td><a href="http://www."${major.school.website}></a></td>-->
			  <!--<td>${major.school.name}</td>-->
			  <c:if test="${operation eq 'searchSchools'}">
			     <td>${major.school.category}</td>
			  </c:if>    
			  <c:if test="${operation ne 'getPrincetonReviewGreatSchoolMajors'}">
			   <c:choose>
			     <c:when test="${operation eq 'getSchoolsInSpeciality'}">
				  <td>${major.school.schoolRankInSpeciality.rank}</td>
			     </c:when>
			      <c:when test="${operation eq 'getBestSchoolMajors'}">
			         <c:choose>
                             <c:when test="${major.rank != null}">
				        <td>${major.rank}</td>
			           </c:when> 
			           <c:otherwise>
			              <td>NR</td>
			           </c:otherwise>
			        </c:choose> 
			     </c:when>
			     <c:otherwise>
			        <c:choose>
                             <c:when test="${major.school.rankOverall > 0}">
				        <td>${majorschool.rankOverall}</td>
			           </c:when> 
			           <c:when test="${major.school.rankOverall < 0}">
			              <td>Not Ranked</td>
			           </c:when>  
			           <c:otherwise>
			              <td>Not Reported</td>
			           </c:otherwise>
			        </c:choose> 
			     </c:otherwise>
			   </c:choose>
		    	  </c:if>
		    	  <!--<td>${major.school.size}</td>
                    <td>${major.school.type}</td>-->
                    <!--<c:choose>
                       <c:when test="${major.school.tuitionFee >= 0}">
					      <td>$${major.school.tuitionFee}</td>
					   </c:when> 
					   <c:otherwise>
					      <td>N/A</td>
					   </c:otherwise>
					</c:choose>    
					<c:choose>
                       <c:when test="${major.school.roomBoard >= 0}">
					      <td>$${major.school.roomBoard}</td>
					   </c:when> 
					   <c:otherwise>
					      <td>N/A</td>
					   </c:otherwise>
					</c:choose>-->
					<c:choose>
                       <c:when test="${major.school.tuitionFee != null && major.school.roomBoard !=null}">
					      <td>$${major.school.tuitionFee + major.school.roomBoard}</td>
					   </c:when> 
				       <c:when test="${major.school.tuitionFee != null && major.school.roomBoard ==null}">
					      <td>$${major.school.tuitionFee} + null</td>
					   </c:when>
					   <c:when test="${major.school.tuitionFee == null && major.school.roomBoard !=null}">
					      <td>null + $${major.school.roomBoard}</td>
					   </c:when>
					   <c:otherwise>
					      <td>N/A</td>
					   </c:otherwise>
					</c:choose>
					<c:choose>
                       <c:when test="${major.school.acceptRate >= 0}">  
					      <td>${major.school.acceptRate}%</td>
					   </c:when> 
					   <c:otherwise>
					      <td>N/A</td>
					   </c:otherwise>
					</c:choose>
					<c:choose>
					   <c:when test="${major.school.sat1Percentile25 > 0 && school.satActNotRequired == 'Yes' && school.internationalStudentApplication.toeflAcceptedInsteadOfSatOrAct == 'Yes'}">
					     <td>${major.school.sat1Percentile25}-${major.school.sat1Percentile75}(*-)</td>
					   </c:when>   
					   <c:when test="${major.school.sat1Percentile25 > 0 && school.satActNotRequired == 'Yes' && school.internationalStudentApplication.toeflAcceptedInsteadOfSatOrAct != 'Yes'}">
					     <td>${major.school.sat1Percentile25}-${major.school.sat1Percentile75}(*) </td>
					   </c:when>
					   <c:when test="${major.school.sat1Percentile25 > 0 && school.satActNotRequired != 'Yes' && school.internationalStudentApplication.toeflAcceptedInsteadOfSatOrAct == 'Yes'}">
					     <td>${major.school.sat1Percentile25}-${major.school.sat1Percentile75}(-) </td>
					   </c:when>
					   <c:when test="${major.school.sat1Percentile25 > 0}">
					      <td>${major.school.sat1Percentile25}-${major.school.sat1Percentile75}</td>
					   </c:when>
					   <c:when test="${major.school.actPercentile25 > 0 && school.satActNotRequired == 'Yes' && school.internationalStudentApplication.toeflAcceptedInsteadOfSatOrAct == 'Yes'}">
					     <td>${major.school.actPercentile25}-${major.school.actPercentile75}(*-)</td>
					   </c:when>   
					   <c:when test="${major.school.actPercentile25 > 0 && school.satActNotRequired == 'Yes' && school.internationalStudentApplication.toeflAcceptedInsteadOfSatOrAct != 'Yes'}">
					     <td>${major.school.actPercentile25}-${major.school.actPercentile75}(*) </td>
					   </c:when>
					   <c:when test="${major.school.actPercentile25 > 0 && school.satActNotRequired != 'Yes' && school.internationalStudentApplication.toeflAcceptedInsteadOfSatOrAct == 'Yes'}">
					     <td>${major.school.actPercentile25}-${major.school.actPercentile75}(-) </td>
					   </c:when>
					   <c:when test="${major.school.actPercentile25 > 0}">
                         <td>${major.school.actPercentile25}-${major.school.actPercentile75}</td>
                       </c:when>
                      <c:otherwise>
				 <td>N/A</td>
			    </c:otherwise>
			 </c:choose>  
			 <c:choose>
                      <c:when test="${major.school.averageGpa > 0}">
				 <td>${major.school.averageGpa}</td>
			    </c:when> 
			    <c:otherwise>
			       <td>N/A</td>
			    </c:otherwise>
			 </c:choose>  
			 <!--<td>${major.school.numberOfRequiredSat2}</td>-->
			 <c:choose>
			    <c:when test="${major.school.internationalStudentApplication.minimumToeflScore < 0}">
                         <td>Not Required</td>
                      </c:when>
			    <c:when test="${major.school.internationalStudentApplication.minimumToeflScore == null && school.internationalStudentApplication.averageToeflScore == null}">
                        <td>N/A</td>
                      </c:when>
                      <c:otherwise>
                        <c:choose>
			        <c:when test="${major.school.internationalStudentApplication.averageToeflScore == null}">
                            <td>${major.school.internationalStudentApplication.minimumToeflScore}</td> 
                          </c:when>
                          <c:otherwise>
                            <td>${major.school.internationalStudentApplication.minimumToeflScore}/${major.school.internationalStudentApplication.averageToeflScore}</td> 
                          </c:otherwise>
                        </c:choose>
                      </c:otherwise>
                   </c:choose>
                   <td>${major.school.satActNotRequired}</td>
                   <c:choose>
			   <c:when test="${major.school.internationalStudentApplication.toeflAcceptedInsteadOfSatOrAct eq 'Yes'}">
			      <td>${major.school.internationalStudentApplication.toeflAcceptedInsteadOfSatOrAct}</td>
			   </c:when>
                     <c:otherwise>
                        <td></td> 
                     </c:otherwise>
                  </c:choose>                    
			<!--<td>${major.school.selectivity}</td>-->
			<c:choose>
			   <c:when test="${major.school.applicationDeadline != null}">
			      <td>${major.school.applicationDeadline}</td>
			   </c:when>
                     <c:otherwise>
                        <td>N/A</td> 
                     </c:otherwise>
                  </c:choose>  
                  <c:choose>
			   <c:when test="${major.school.applicationFee != null}">
			     <td>$${major.school.applicationFee}</td>
			   </c:when>
                     <c:otherwise>
                        <td>N/A</td> 
                     </c:otherwise>
                  </c:choose>     
			<td>${major.school.city}, ${major.school.state}</td>
			<!--<td>${major.school.internationalStudentApplication.financialAid}</td>-->
			<!--<td><a id="website" href="<spring:url value="/collegeSearch/school/getSchool/${major.school.website}" />">${major.school.website}</a></td>-->
		   </tr>
		 </c:forEach>
	   </table>
	   <c:out value="Legends: *: SAT/ACT Not Required   -: TOEFL Is Accepted Instead Of SAT/ACT"/>
	</c:if>
	<div>
	 <table  class="center" style="margin: 0 auto; cellspacing: 30px; cellpadding: 30px; border-spacing: 50px;">
          <tr>
             <td><a id="schoolHome" href="<spring:url value="/school/home" />" class="button_m"><span style="cellspacing: 30px; cellpadding: 30px;">School Home</span></a></td>
             <c:if test="${operation eq 'searchSchools'}">
	          <td ><a id="searchSchool" href="<spring:url value="/school/showSearchEngineForm" />" class="button_m"><span style="cellspacing: 30px; cellpadding: 30px;">Search Again</span></a></td>
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
