<%@ include file="/WEB-INF/includes/taglibs.jsp"%>
<%@ include file="/WEB-INF/includes/doctype.jsp"%>
<%@ include file="/WEB-INF/includes/styles.jsp"%>

<html xmlns="http://www.w3.org/1999/xhtml" lang="en">

<head>
   <title>Main Page</title>
</head>

<body background="http://localhost:8080/collegeSearch/static/images/search_bg3.jpg">
  <div class="container">
     <div><%@ include file="/WEB-INF/views/general/header.jsp"%></div>
     <h4 style="color: black;">Enter School Information</h4>   
     <spring:url var="action" value="/school/createSchool" />
     
     <div style="float:left;  margin-left:20px; width:100%; text-align:center; border-style: solid; border-width:1px;background-color:Coral">
       <form:form method="POST" action="${action}" modelAttribute="school">
         <table style="width:100%; margin-bottom:-7px; text-align:center;">            
             <caption>Enter School Information</caption>
             <tr>
                <td><label>Name:</label><form:input path="name"></form:input></td>
                <td><label for="state">State:</label>
                    <form:select id="state" path="state" cssClass="span-8" cssErrorClass="span-8 validationFailed" cssStyle="width:120px;">
                       <form:option value="" selected="selected">No Preference</form:option>
                          <c:forEach var="state" items="${stateList}" varStatus="status">
                             <form:option value="${state}">${state.description}</form:option>
                          </c:forEach>
                    </form:select>
                 </td> 
                 <td><label>City:</label><form:input path="city"></form:input></td>
                 <td><label>Admin Office Phone:</label><form:input path="phone"></form:input></td>
            </tr>
            <tr>
                <td><label>Minimum GPA:</label><form:input path=""></form:input></td>
                <td><label>Minimum TOEFL Score:</label><form:input path="toefl"></form:input></td>
                <td><label>Minimum IELTS Score:</label><form:input path="ielts"></form:input></td>
            </tr>
            <tr>   
                <td><label for="sat1Percentile25">25% SAT 1 Score:</label>
                    <form:select id="sat1Percentile25" path="sat1Percentile25" cssClass="span-8" cssErrorClass="span-8 validationFailed" cssStyle="width:120px;">
                       <form:option value="" selected="selected">Select One</form:option>
                          <c:forEach var="sat1Percentile25" items="${actScoreList}" varStatus="status">
                             <form:option value="${sat1Percentile25}">${sat1Percentile25}</form:option>
                          </c:forEach>
                    </form:select>
                </td> 
                <td><label for="sa1tPercentile75">75% SAT 1 Score:</label>
                    <form:select id="sa1Percentile75" path="sat1Percentile75" cssClass="span-8" cssErrorClass="span-8 validationFailed" cssStyle="width:120px;">
                       <form:option value="" selected="selected">Select One</form:option>
                          <c:forEach var="sat1Percentile75" items="${sat1ScoreList}" varStatus="status">
                             <form:option value="${sat1Percentile75}">${sat1Percentile75}</form:option>
                          </c:forEach>
                    </form:select>
                </td> 
                <td><label for="actPercentile25">25% ACT Score:</label>
                    <form:select id="actPercentile25" path="actPercentile25" cssClass="span-8" cssErrorClass="span-8 validationFailed" cssStyle="width:120px;">
                       <form:option value="" selected="selected">Select One</form:option>
                          <c:forEach var="actPercentile25" items="${actScoreList}" varStatus="status">
                             <form:option value="${actPercentile25}">${actPercentile25}</form:option>
                          </c:forEach>
                    </form:select>
                </td> 
                <td><label for="actPercentile75">75% ACT Score:</label>
                    <form:select id="actPercentile75" path="actPercentile75" cssClass="span-8" cssErrorClass="span-8 validationFailed" cssStyle="width:120px;">
                       <form:option value="" selected="selected">Select One</form:option>
                          <c:forEach var="actPercentile75" items="${actScoreList}" varStatus="status">
                             <form:option value="${actPercentile75}">${actPercentile75}</form:option>
                          </c:forEach>
                    </form:select>
                </td> 
             </tr> 
          </table>
          <hr></hr>
          <table style="width:100%; margin-top:-8px;text-align:center; cellpadding: 0px; cellpadding: 0px 10px;"> 
             
             <tr>
                <td><label>Tuition and Fees($):</label><form:input path="tuitionFee"></form:input></td>
                <td><label>Room And Board($):</label><form:input path="roomBoard"></form:input></td>
                <td><label>Application Deadline:</label><form:input path="applicationDeadline"></form:input></td>
                <td><label>Application Fee($):</label><form:input path="applicationFee"></form:input></td>
             </tr>   
             <tr>
                <td><label for="type">School Type:</label>
                    <form:select id="type" path="type" cssClass="span-8" cssErrorClass="span-8 validationFailed" cssStyle="width:120px;">
                       <form:option value="" selected="selected">Select One</form:option>
                          <c:forEach var="type" items="${schoolTypeList}" varStatus="status">
                             <form:option value="${type}">${type}</form:option>
                          </c:forEach>
                    </form:select>
                </td> 
                <td><label for="category">School Category:</label>
                    <form:select id="category" path="category" cssClass="span-8" cssErrorClass="span-8 validationFailed" cssStyle="width:120px;">
                       <form:option value="" selected="selected">Select One</form:option>
                          <c:forEach var="category" items="${schoolCategoryList}" varStatus="status">
                             <form:option value="${category}">${category}</form:option>
                          </c:forEach>
                    </form:select>
                </td> 
                <td><label for="setting">School Setting:</label>
                    <form:select id="setting" path="setting" cssClass="span-8" cssErrorClass="span-8 validationFailed" cssStyle="width:120px;">
                       <form:option value="" selected="selected">Select One</form:option>
                          <c:forEach var="setting" items="${schoolSettingList}" varStatus="status">
                             <form:option value="${setting}">${setting}</form:option>
                          </c:forEach>
                    </form:select>
                </td> 
                <td><label>Total Student numbers:</label><form:input path="size"></form:input></td>
              </tr>
              <tr>
                 <td><label>Overall Rank:</label><form:input path="rankOverall"></form:input></td>
                 <td><label for="reputationScore">Reputation Score:</label>
                    <form:select id="reputationScore" path="reputationScore" cssClass="span-8" cssErrorClass="span-8 validationFailed" cssStyle="width:120px;">
                       <form:option value="" selected="selected">Select One</form:option>
                          <c:forEach var="reputationScore" items="${reputationScoreList}" varStatus="status">
                             <form:option value="${reputationScore}">${reputationScore}</form:option>
                          </c:forEach>
                    </form:select>
                </td> 
                <td><label>Accept Rate:</label><form:input path="acceptRate"></form:input></td>
                <td><label for="selectivity">Selectivity:</label>
                    <form:select id="selectivity" path="selectivity" cssClass="span-8" cssErrorClass="span-8 validationFailed" cssStyle="width:120px;">
                       <form:option value="" selected="selected">Select One</form:option>
                          <c:forEach var="selectivity" items="${selectivityList}" varStatus="status">
                             <form:option value="${selectivity}">${selectivity}</form:option>
                          </c:forEach>
                    </form:select>
                </td> 
             </tr> 
             <tr>
                <td><label>Student Faculty Ratio:</label><form:input path="studentFacultyRatio"></form:input></td>
                <td><label>Percentage of Top 10% of High School Class:</label><form:input path="studentFacultyRatio"></form:input></td>
                <td><label for="calendar">Academic Calendar:</label>
                    <form:select id="calendar" path="calendar" cssClass="span-8" cssErrorClass="span-8 validationFailed" cssStyle="width:120px;">
                       <form:option value="" selected="selected">Select One</form:option>
                          <c:forEach var="calendar" items="${calendarList}" varStatus="status">
                             <form:option value="${calendar}">${calendar}</form:option>
                          </c:forEach>
                    </form:select>
                </td> 
              </tr>
              <tr>
                 <td><label for="internationalFinancialAid">Financial Aid for International Students:</label>
                     <form:radiobutton path="internationalFinancialAid" value="No" />No
                     <form:radiobutton path="internationalFinancialAid" value="Yes" />Yes
                 </td>
                 <td><label>Website:</label><form:input path="website"></form:input></td>
              </tr>	
           </table>
               <input type="submit" value="Submit"/>
      </form:form>
   </div>   
  </div>
  <div>
      <table class="center" style="margin: auto; cellspacing: 30px; cellpadding: 30px; border-spacing: 50px;">
        <tr>
            <td><a id="schoolHome" href="<spring:url value="/school/home" />" class="button-m"><span class="center" style="cellspacing: 30px; cellpadding: 30px;">School Home</span></a></td>
        </tr>
     </table>
  </div>    
     <%@ include file="/WEB-INF/views/general/footer.jsp"%>
  
  
   
</body>
</html>
