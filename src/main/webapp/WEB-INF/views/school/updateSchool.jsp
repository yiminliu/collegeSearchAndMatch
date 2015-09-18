<%@ include file="/WEB-INF/includes/taglibs.jsp"%>
<%@ include file="/WEB-INF/includes/doctype.jsp"%>
<%@ include file="/WEB-INF/includes/styles.jsp"%>

<html xmlns="http://www.w3.org/1999/xhtml" lang="en">

<head>
   <title>Update School Page</title>
</head>

<body background="/WEB-INF/static/images/search_bg3.jpg">
  <div class="narrow_container">
     <div><%@ include file="/WEB-INF/views/general/header.jsp"%></div>
     <spring:url var="action" value="/school/updateSchool" />
     <c:choose>
       <c:when test="${empty school}">
          <div class="page_title">No School Found</div>
       </c:when>
       <c:otherwise>
          <div class="page_title">${school.name}</div>
       </c:otherwise>
     </c:choose>
     <div class="content">  
        <form:form method="POST" action="${action}" modelAttribute="school">
          <div class="section_title">Basic Info</div>
           <table class="datatable" style="font-size: 80%; margin-left: 0px">
               <tr style="background-color: Ivory;">
                  <th>Total Students</th>
              	  <th>Student/Faculty Ratio</th>
                  <th>Type</th>
                  <th>Setting</th>
                  <th>Category</th>
				  <th>State</th>
				  <th>City</th>
				  <th>Academic calendar</th> 
				  <th>Phone</th>
				  <th>Website</th>
			   </tr>
		       <tr>
		           <td><form:input path="size" size="8"></form:input></td>
            	   <td><form:input path="studentFacultyRatio" size="5"></form:input></td>
            	   <td>
            	        <form:select id="type" path="type" cssClass="span-8" cssErrorClass="span-8 validationFailed" cssStyle="width:70px;">
                          <form:option value="${type}" selected="selected">${type}</form:option>
                            <c:forEach var="type" items="${schoolTypeList}" varStatus="status">
                              <form:option value="${type}">${type}</form:option>
                            </c:forEach>
                        </form:select>
                    </td>
                    <td>
                        <form:select id="setting" path="setting" cssClass="span-8" cssErrorClass="span-8 validationFailed" cssStyle="width:70px;">
                       <form:option value="${setting}" selected="selected">${setting}</form:option>
                          <c:forEach var="setting" items="${schoolSettingList}" varStatus="status">
                             <form:option value="${setting}">${setting}</form:option>
                          </c:forEach>
                    </form:select>
                    </td>
                    <td>
                        <form:select id="category" path="category" cssClass="span-8" cssErrorClass="span-8 validationFailed" cssStyle="width:130px;">
                       <form:option value="${category}" selected="selected">${category}</form:option>
                          <c:forEach var="category" items="${schoolCategoryList}" varStatus="status">
                             <form:option value="${category}">${category}</form:option>
                          </c:forEach>
                    </form:select>
                    </td>
               	    <td>
               	        <form:select id="state" path="state" cssClass="span-8" cssErrorClass="span-8 validationFailed" cssStyle="width:110px;">
                       <form:option value="${state}" selected="selected">${state.description}</form:option>
                          <c:forEach var="state" items="${stateList}" varStatus="status">
                             <form:option value="${state}">${state.description}</form:option>
                          </c:forEach>
                    </form:select>
               	    </td>
               	    <td><form:input path="city" size="10"></form:input></td>
					<td>
					    <form:select id="calendar" path="calendar" cssClass="span-8" cssErrorClass="span-8 validationFailed" cssStyle="width:80px;">
                          <form:option value="${calendar}" selected="selected">${calendar}</form:option>
                            <c:forEach var="calendar" items="${calendarList}" varStatus="status">
                              <form:option value="${calendar}">${calendar}</form:option>
                            </c:forEach>
                       </form:select>    
					</td> 
					<td><form:input path="phone" size="8"></form:input></td>
					<td><form:input path="website" size="10"></form:input></td>
			   </tr>
		   </table>
		  
           <div class="section_title">Admission Info</div>
           <table class="datatable" style="font-size: 80%; margin-left: 0px">
             <tr style="background-color: Ivory;">
              	<th>Overall Rank</th>
              	<th>Reputation Score</th>
              	<th>Application Deadline<font size="1">(mm-dd)</font></th>
				<th>Application Fee($)<font size="1"></font></th>
				<th>Selectivity</th>
				<th>Acceptance Rate<font size="1"></font></th>
				<th>Top 10% of High School Class(%)</th>
			</tr>
		       <tr>
            		<td><form:input path="rankOverall" size="8"></form:input></td>
            		<td><form:input path="reputationScore" size="8"></form:input></td>
            		<td><form:input path="applicationDeadline" size="8"></form:input></td>
            		<td><form:input path="applicationFee" size="8"></form:input></td>
            		<td>
            	 	    <form:select id="selectivity" path="selectivity" cssClass="span-8" cssErrorClass="span-8 validationFailed" cssStyle="width:80px;">
                          <form:option value="${selectivity}" selected="selected">${selectivity}</form:option>
                            <c:forEach var="selectivity" items="${selectivityList}" varStatus="status">
                              <form:option value="${selectivity}">${selectivity}</form:option>
                            </c:forEach>
                       </form:select>    
					</td> 
					<td><form:input path="acceptRate" size="8"></form:input></td>
					<td><form:input path="hsClassTop10Percentage" size="8"></form:input></td>
							
	    	    </tr>
		  </table>
		  <div class="section_title">Requirements</div>
           <table class="datatable" style="font-size: 80%; margin-left: 0px">
             <tr style="background-color: Ivory;">
              	<th>Minimum TOEFL Score</th>
              	<th>Minimum IELTS Score</th>
            	<th>25 Percentile SAT I Score<font size="1">(25th% - 75th%)</font></th>
            	<th>75 Percentile SAT I Score<font size="1">(25th% - 75th%)</font></th>
				<th>25 Percentile ACT Score<font size="1">(25th% - 75th%)</font></th>
				<th>75 Percentile ACT Score<font size="1">(25th% - 75th%)</font></th>
				<th>SAT II Required</th>
			 </tr>
		     <tr>
                 <td><form:input path="toefl" size="8"></form:input></td>
                 <td><form:input path="ielts" size="8"></form:input></td>
                 <td><form:input path="sat1Percentile25" size="8"></form:input></td>
                 <td><form:input path="sat1Percentile75" size="8"></form:input></td>
                 <td><form:input path="actPercentile25" size="8"></form:input></td>
                 <td><form:input path="actPercentile75" size="8"></form:input></td>
                 <td><form:input path="numberOfRequiredSat2" size="8"></form:input></td>
			    </tr>
		  </table>
		  <div class="section_title">Financial Info</div>
          <table class="datatable" style="font-size: 80%; margin-left: 0px">
             <tr style="background-color: Ivory;">
              	<th>Tuition and Fees($)<font size="1"></font></th>
				<th>Room and Board($)<font size="1"></font></th>
				<th>Financial Aid for International Students</th>
			 </tr>
		     <tr>
		            <td><form:input path="tuitionFee" size="8"></form:input></td>
                    <td><form:input path="roomBoard" size="8"></form:input></td>
                    <td><label for="internationalFinancialAid"></label>
                         <form:radiobutton path="internationalFinancialAid" value="No" />No
                         <form:radiobutton path="internationalFinancialAid" value="Yes" />Yes
                    </td>    
               </tr>
		  </table>
          <input type="submit" value="Submit"/>
	   </form:form>
	 </div>
	 <table  class="center" style="margin: 0 auto; cellspacing: 30px; cellpadding: 30px; border-spacing: 50px;">
        <tr>
           <td><a id="achoolHome" href="<spring:url value="/school/home" />" class="button_m"><span style="cellspacing: 30px; cellpadding: 30px;">School Home</span></a></td>
        </tr>
     </table>
     <%@ include file="/WEB-INF/views/general/footer.jsp"%>
   </div>
	
</body>
</html>
