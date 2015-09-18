<%@ include file="/WEB-INF/includes/taglibs.jsp"%>
<%@ include file="/WEB-INF/includes/doctype.jsp"%>
<%@ include file="/WEB-INF/includes/styles.jsp"%>

<!--<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">-->
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
   <title>Success Page</title>
 
</head>

<body>
Success Page 1
 <c:out value="${fn:length(schoolList)}"/>
 
   <div class="container">
      <c:choose>
         <c:when test="${empty schoolList}">
             <div class="page_title">No School Found</div>
         </c:when>
         <c:otherwise>
            <div class="page_title_no_top">Search Result(${fn:length(schoolList)} schools)</div>
         </c:otherwise>
      </c:choose>
      <div>
        <c:if test="${!empty schoolList}">
          <table class="datatable">
            <tr style="background-color: Ivory;">
              	<TH scope="col">College</TH>
				<TH scope="col">Rank</TH>
				<TH scope="col">Size(Students)</TH>
                <TH scope="col">Type</TH>
				<TH scope="col">Tuition+Fees<font size="1">($)</font></TH>
				<TH scope="col">Room/Board<font size="1">($)</font></TH>
				<TH scope="col">Appl. Fee<font size="1">($)</font></TH>
				<TH scope="col">Appl. Deadline<font size="1">(mm-dd)</font></TH>
				<TH scope="col">TOEFL</TH>
				<TH scope="col">SAT I<font size="1">(25th - 75th%)</font></TH>
				<TH scope="col">SAT II</TH>
				<!--<c:if test="searchAction==null">
					<TH scope="col">Major(<s:property value="major" />) Rank</TH>
				</c:if>-->
				<TH scope="col">Selectivity Rank</TH>
				<TH scope="col">Acceptance Rate<font size="1">(%)</font></TH>
				<TH scope="col">Location</TH>
				<TH scope="col">Finacial Aid for Int. Students</TH>
				<TH scope="col">More</TH>
			</tr>
			<c:forEach var="school" items="${schoolList}" varStatus="loopStatus">  
                <tr class="${loopStatus.index % 2 == 0 ? 'even' : 'odd'}">
                    <td style="color : red"><a id="schoolDetail" href="<spring:url value="/school/getSchoolDetail/${school.name}" />">${school.name}</a></td>
					<!--<td><a href="http://www."${school.website}></a></td>-->
					<td>${school.rank}</td>
            		<td>${school.size}</td>
                    <td>${school.type}</td>
					<td>${school.tuitionFee}</td>
					<td>${school.roomBoard} /></td>
					<td>${school.appFee}</td>
					<td>${school.appDeadLine}</td>
					<td>${school.toefl}</td>
					<td>${school.sat1Min} - ${school.sat1Up}</td>
					<td>${school.sat2}</td>
					<!--<c:if test="searchAction==null">
						<td>${school.majorRank}</td>
					</c:if>-->
					<td>${school.selectivityRank}</td>
					<td>${school.acceptRate}</td>
					<td>${school.city}, ${school.state}</td>
					<td>${school.aid}</td>
					<td>${school.more}</td>
			    </tr>
		   </c:forEach>
	     </table>
	   </c:if>
	 </div>
	</div>
	<!--<table align="center" cellspacing="8" cellpadding="2">
		<tr align="center">
			<td>
			<form><s:if test="searchAction!=null">
				<input type="button" value="Another search"
					onClick="window.location='/CollegeService/topCollegeList.jsp'" />
			</s:if> <s:else>
				<input type="button" value="Another search"
					onClick="window.location='/CollegeService/fineSearch.jsp'" />
			</s:else></form>
			</td>
			<td>
			<form><input type="button" value="Return to the main page"
				onClick="window.location='/CollegeService/searchLanding.jsp'" /></form>
			</td>
		</tr>
	</table>-->
</body>
</html>
