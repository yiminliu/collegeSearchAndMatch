<%@ include file="/WEB-INF/includes/taglibs.jsp"%>
<%@ include file="/WEB-INF/includes/doctype.jsp"%>
<%@ include file="/WEB-INF/includes/styles.jsp"%>
 
<html xmlns="http://www.w3.org/1999/xhtml" lang="en">

<head>
   <title>Result Page</title>
</head>
 
<body background="/WEB-INF/static/images/search_bg3.jpg">
   <%@ include file="/WEB-INF/views/general/header.jsp"%>
   <div class="container">
      <c:choose>
         <c:when test="${empty school}">
             <div class="page_title">No School Found</div>
         </c:when>
         <c:otherwise>
            <div class="page_title_no_top">Detail Information for ${school.name}</div>
         </c:otherwise>
      </c:choose>
      <div>
        <c:if test="${!empty schoo}">
           <table class="sub_datatable" style="font-size: 80%">
             <tr><td>Requirements</td></tr>
             <tr style="background-color: Ivory;">
              	<th>College</th>
				<th>Rank</th>
				<th>Size(Students)</th>
                <th>Type</th>
				<th>Tuition+Fees<font size="1">($)</font></th>
				<th>Room/Board<font size="1">($)</font></th>
				<th>Appl. Fee<font size="1">($)</font></th>
				<th>Appl. Deadline<font size="1">(mm-dd)</font></th>
				<th>Minmum TOEFL Score</th>
				<th>SAT I<font size="1">(25th - 75th%)</font></th>
				<th>SAT II</th>
				<th>Selectivity</th>
				<th>Acceptance Rate<font size="1">(%)</font></th>
				<th>Location</th>
				<th>Finacial Aid for Int. Students</th>
				<th>Website</th>
			</tr>
			<c:forEach var="school" items="${schoolList}" varStatus="loopStatus">  
                <tr class="${loopStatus.index % 2 == 0 ? 'even' : 'odd'}">
                    <td style="color : red"><a id="schoolDetail" href="<spring:url value="/school/getSchoolDetail/${school.name}" />">${school.name}</a></td>
					<!--<td><a href="http://www."${school.website}></a></td>-->
					<!--<td>${school.name}</td>-->
					<td>${school.rankOverall}</td>
            		<td>${school.size}</td>
                    <td>${school.type}</td>
					<td>${school.tuitionFee}</td>
					<td>${school.roomBoard}</td>
					<td>${school.applicationFee}</td>
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
					<td>${school.sat125Percent} - ${school.sat175Percent}</td>
					<td>${school.sat2}</td>
					<td>${school.selectivity}</td>
					<td>${school.acceptRate}</td>
					<td>${school.city}, ${school.state}</td>
					<td>${school.intFinacialAid}</td>
					<td><a id="website" href="<spring:url value="/collegeSearch/school/getSchool/${school.website}" />">${school.website}</a></td>
			    </tr>
		   </c:forEach>
	     </table>
	   </c:if>
	 </div>
	 <table  class="center" style="margin: 0 auto; cellspacing: 30px; cellpadding: 30px; border-spacing: 50px;">
        <tr>
           <!-- <td><a id="imsSearch" href="<spring:url value="/school/getItem" />" class="button-m"><span style="cellspacing: 30px; cellpadding: 30px;">School Search Page</span></a></td>-->
           <td><a id="imsHome" href="<spring:url value="/school/home" />" class="button-m"><span style="cellspacing: 30px; cellpadding: 30px;">School Home</span></a></td>
        </tr>
     </table>
     <%@ include file="/WEB-INF/views/general/footer.jsp"%>
   </div>
	
</body>
</html>
