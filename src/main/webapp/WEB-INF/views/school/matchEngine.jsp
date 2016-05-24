<%@ include file="/WEB-INF/includes/taglibs.jsp"%>
<%@ include file="/WEB-INF/includes/doctype.jsp"%>
<%@ include file="/WEB-INF/includes/styles.jsp"%>

<html xmlns="http://www.w3.org/1999/xhtml" lang="en">

<head>
   <title>Search Engine</title>
</head>

<body background="http://localhost:8080/collegeSearch/static/images/search_bg3.jpg">
  <div class="container">
     <%@ include file="/WEB-INF/views/general/header.jsp"%>
     <spring:url var="action" value="/school/matchEngine" />
     <table class="center_element_text" style="width:70%; margin-top:5px; margin-bottom:8px; padding:0px;">
       <tr>
          <td style="background-color:LightGreen;"><h3>Match you and your suitable colleges</h3></td>
       </tr>   
     </table>
     <div class="content" style="width:70%; margin-top:15px; border-style: solid; border-width:10px; ">  
        <form:form method="GET" action="${action}" modelAttribute="school">
           <table style="font-size: 95% margin-top:-8px text-align:left cellpadding: 0px 10px;"> 
             <h3><caption><span style="background-color:silver;">Enter Your Scores</span></caption></h3>
             <tr>
                <td><label>GPA:</label> <form:input path="randomApplicant.gpaScore" /></td>
                <td><label>TOEFL Score:</label><form:input path="randomApplicant.toeflScore" /></td>
                <td><span style="color:BLUE; text-align:center">   Or  </span></td>
                <td><label>IELTS Score:</label>
                    <form:select id="ieltsScore" path="randomApplicant.ieltsScore" cssClass="span-8" cssErrorClass="span-8 validationFailed" cssStyle="width:120px;">
                       <form:option value="" selected="selected">Select One</form:option>
                          <c:forEach var="ieltsScore" items="${ieltsScoreList}" varStatus="status">
                             <form:option value="${ieltsScore}">${ieltsScore}</form:option>
                          </c:forEach>
                    </form:select>
                </td> 
             </tr>
             <tr><span class="label_same_row" style="cellspacing:90px; cellpadding:5px">
                <td><label>SAT I Reading Score:</label><form:input path="randomApplicant.sat1ReadingScore" cssClass="span-8" cssErrorClass="span-8 validationFailed" cssStyle="width:140px;" /></td>
                <td><label>Math Score:</label><form:input path="randomApplicant.sat1MathScore" cssClass="span-8" cssErrorClass="span-8 validationFailed" cssStyle="width:90px;" /></td>
                <td><label>Essay Score:</label><form:input path="randomApplicant.sat1EssayScore" cssClass="span-8" cssErrorClass="span-8 validationFailed" cssStyle="width:90px;" /></td>
                <td><span style="text-color:BLUE">   Or  </td>
                <td><label>ACT Reading Score:</label>
                    <form:select id="actScore" path="randomApplicant.actScore" cssClass="span-8" cssErrorClass="span-8 validationFailed" cssStyle="width:140px;">
                       <form:option value="" selected="selected">Select One</form:option>
                          <c:forEach var="actScore" items="${actScoreList}" varStatus="status">
                             <form:option value="${actScore}">${actScore}</form:option>
                          </c:forEach>
                    </form:select>
                </td>
                <td><label>Math Score:</label>
                    <form:select id="actScore" path="randomApplicant.actScore" cssClass="span-8" cssErrorClass="span-8 validationFailed" cssStyle="width:90px;">
                       <form:option value="" selected="selected">Select One</form:option>
                          <c:forEach var="actScore" items="${actScoreList}" varStatus="status">
                             <form:option value="${actScore}">${actScore}</form:option>
                          </c:forEach>
                    </form:select>
                </td> 
                <td><label>Writing Score:</label>
                    <form:select id="actScore" path="randomApplicant.actScore" cssClass="span-8" cssErrorClass="span-8 validationFailed" cssStyle="width:90px;">
                       <form:option value="" selected="selected">Select One</form:option>
                          <c:forEach var="actScore" items="${actScoreList}" varStatus="status">
                             <form:option value="${actScore}">${actScore}</form:option>
                          </c:forEach>
                    </form:select>
                </td> 
               </span> 
             </tr> 
             <tr>  
                <td>
                   <label>SAT II:</label>
                      <form:checkboxes items="${satSubjectList}" path="randomApplicant.satSubjects" />
                </td> 
             </tr>
           </table>
          <hr></hr>
          <br></br>
         <table style="width:100%; text-align:center;">   
             <h3><caption><span style="background-color:silver;">Select Your Preferences</span></caption></h3>
             <tr>
                <td><label class="label_same_row">Total Cost (Tuition & Fees + Room & Board)($):</label>
                    <form:select id="totalCost" class="input-container" path="totalCost" cssClass="span-8" cssErrorClass="span-8 validationFailed" cssStyle="width:150px;">
                       <form:option value="" selected="selected">No Preference</form:option>
                          <c:forEach var="totalCost" items="${totalCostRangeList}" varStatus="status">
                             <form:option value="${totalCost}">${totalCost}</form:option>
                          </c:forEach>
                    </form:select>
                </td>
             </tr>
             <tr>
                <td><label class="label_same_row">Category:</label>
                    <form:select id="category" path="category" cssClass="span-8" cssErrorClass="span-8 validationFailed" cssStyle="width:150px;">
                       <form:option value="" selected="selected">No Preference</form:option>
                          <c:forEach var="category" items="${schoolCategoryList}" varStatus="status">
                             <form:option value="${category}">${category.description}</form:option>
                          </c:forEach>
                    </form:select>
                </td> 
            </tr>
            <tr>
                <td><label class="label_same_row">Overal Rank:</label>
                    <form:select id="rankOverall" path="rankOverall" cssClass="span-8" cssErrorClass="span-8 validationFailed" cssStyle="width:150px;">
                       <form:option value="" selected="selected">No Preference</form:option>
                          <c:forEach var="rankOverall" items="${schoolRankList}" varStatus="status">
                             <form:option value="${rankOverall}">${rankOverall}</form:option>
                          </c:forEach>
                    </form:select>
                </td> 
            </tr>
            <tr>
               <td><label class="label_same_row">Acceptance Rate(%):</label>
                    <form:select id="acceptRate" path="acceptRate" cssClass="span-8" cssErrorClass="span-8 validationFailed" cssStyle="width:150px;">
                       <form:option value="" selected="selected">No Preference</form:option>
                          <c:forEach var="acceptRate" items="${acceptanceRateList}" varStatus="status">
                             <form:option value="${acceptRate}">${acceptRate}</form:option>
                          </c:forEach>
                    </form:select>
                </td>
             </tr>
             <tr>
                <td><label class="label_same_row">SAT/ACT Not Required:</label>
                    <form:radiobutton path="satActNotRequired" value="Yes" />Yes
                </td>
             </tr>
             <tr>
                <td><label class="label_same_row">TOEFL Is Accepted Instead of SAT/ACT:</label>
                    <form:radiobutton id="satActNotRequired" path="internationalStudentApplication.toeflAcceptedInsteadOfSatOrAct" value="Yes" />Yes
                </td> 
             </tr>	
             <tr>
                <td><label class="label_same_row">Conditional Admission Is Offered:</label>
                    <form:radiobutton id="satActNotRequired" path="internationalStudentApplication.conditionalAdmissionOffered" value="Yes" />Yes
                </td> 
             </tr>	
             <tr>
                <td><label class="label_same_row">Type:</label>
                    <form:select id="type" path="type" cssClass="span-8" cssErrorClass="span-8 validationFailed" cssStyle="width:150px;">
                       <form:option value="" selected="selected">No Preference</form:option>
                          <c:forEach var="type" items="${schoolTypeList}" varStatus="status">
                             <form:option value="${type}">${type}</form:option>
                          </c:forEach>
                    </form:select>
                </td> 
            </tr>
            <!--<tr>      
                <td><label class="label_same_row">Type:</label>
                    <c:forEach var="type" items="${schoolTypeList}" varStatus="status">
                       <form:radiobutton path="type" value="${type}" />${type}
                    </c:forEach>
                </td> 
            </tr>-->
            <tr>
                <td><label class="label_same_row">Size:</label>
                    <form:select id="size" path="size" cssClass="span-8" cssErrorClass="span-8 validationFailed" cssStyle="width:150px;">
                       <form:option value="" selected="selected">No Preference</form:option>
                          <c:forEach var="size" items="${schoolSizeList}" varStatus="status">
                             <form:option value="${size}">${size}</form:option>
                          </c:forEach>
                    </form:select>
                </td> 
            </tr>
            <tr>
                <td><label class="label_same_row">State:</label>
                    <form:select id="state" path="state" cssClass="span-8" cssErrorClass="span-8 validationFailed" cssStyle="width:150px;">
                       <form:option value="" selected="selected">No Preference</form:option>
                          <c:forEach var="state" items="${stateList}" varStatus="status">
                             <form:option value="${state}">${state.description}</form:option>
                          </c:forEach>
                    </form:select>
                </td> 
            </tr>
            <!--<tr>
                <td><label class="label_same_row">School Setting:</label>
                    <c:forEach var="setting" items="${schoolSettingList}" varStatus="status">
                       <form:radiobutton id="setting" path="setting" cssClass="span-8" cssErrorClass="span-8 validationFailed" cssStyle="width:150px;" />
                    </c:forEach>
                </td> 
            </tr>-->
            <tr>
                <td><label class="label_same_row">Setting:</label>
                    <form:select id="setting" path="setting" cssClass="span-8" cssErrorClass="span-8 validationFailed" cssStyle="width:150px;">
                       <form:option value="" selected="selected">No Preference</form:option>
                          <c:forEach var="setting" items="${schoolSettingList}" varStatus="status">
                             <form:option value="${setting}">${setting}</form:option>
                          </c:forEach>
                    </form:select>
                </td> 
            </tr>
            <!--<tr>
                <td><label for="internationalFinancialAid">Financial Aid for International Students:</label>
                    <form:select id="internationalFinancialAid" path="internationalStudentApplication.financialAid" cssClass="span-8" cssErrorClass="span-8 validationFailed" cssStyle="width:150px;">
                       <form:option value="" selected="selected">No Preference</form:option>
                          <c:forEach var="internationalFinancialAid" items="${internationalFinancialAidList}" varStatus="status">
                             <form:option value="Yes">${internationalFinancialAid}</form:option>
                          </c:forEach> 
                    </form:select>
                </td> 
            </tr>-->	
         </table> 
         <table class="center_element" style="margin-top:15px;">
           <tr></tr>
           <tr>
              <td><input type="submit" value="Submit"></input></td>
           </tr>
         </table>          
      </form:form>
    </div>  
    <div>
      <table class="center" style="margin: auto; margin-top: -30px; margin-bottom:20px; cellspacing: 30px; cellpadding: 30px; border-spacing: 30px;">
        <tr>
            <td><a id="schoolHome" href="<spring:url value="/school/home" />" class="button_m"><span class="center" style="cellspacing: 30px; cellpadding: 30px;">School Home</span></a></td>
        </tr>
      </table>
    </div> 
     <%@ include file="/WEB-INF/views/general/footer.jsp"%>
  </div>
    
 </body>
</html>
