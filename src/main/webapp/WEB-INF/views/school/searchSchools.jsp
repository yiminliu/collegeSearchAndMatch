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
     <h4 style="color: black;">There are more than 3300 colleges in US to choose from. How to choose?  
     Which ones are good fit for you? Here are the solutions. If you have your GPA and test scores available, you can use School Match Maker to 
     enter your scores and your preferences for colleges, then we will match your scores and preferences with colleges and come up with a list of 
     colleges which fit you. With College Picker, you can put your preferences for your ideal colleges, and we will match your preferences with colleges and come up with a list of 
     colleges which fit you.
     </h4>   
     <spring:url var="action" value="/school/searchSchools" />
     <table style="width:90%; border-collapse: separate; margin-left:5%; margin-bottom:8px; align:center; text-align:center; padding:0px; border-spacing: 100px 0px;">
       <tr>
          <td style="background-color:LightGreen;"><h4>College Picker</h4></td>
          <td> </td>
          <td style="background-color:Coral;"><h4>College Match Maker</h4></td>
       </tr>   
     </table>
      
     <div style="float:left; margin-left:80px; height:100%; width:36%; text-align:center; border-style:solid; border-width:1px; padding:0px; border-spacing: 0px;">
       <form:form method="GET" action="${action}" modelAttribute="school">
         <table style="width:100%; text-align:center;background-color:LightGreen">   
             <caption>Pick colleges by specifying the criteria</caption> 
             <tr>
                <td><label for="rankOverall">School Rank:</label>
                    <form:select id="rankOverall" path="rankOverall" cssClass="span-8" cssErrorClass="span-8 validationFailed" cssStyle="width:150px;">
                       <form:option value="" selected="selected">No Preference</form:option>
                          <c:forEach var="rankOverall" items="${schoolRankList}" varStatus="status">
                             <form:option value="${rankOverall}">${rankOverall}</form:option>
                          </c:forEach>
                    </form:select>
                </td> 
             </tr>
             <tr>
                <td><label for="tuitionFee">Tuition and Fees($):</label>
                    <form:select id="tuitionFee" path="tuitionFee" cssClass="span-8" cssErrorClass="span-8 validationFailed" cssStyle="width:150px;">
                       <form:option value="" selected="selected">No Preference</form:option>
                          <c:forEach var="tuitionFee" items="${tuitionRangeList}" varStatus="status">
                             <form:option value="${tuitionFee}">${tuitionFee}</form:option>
                          </c:forEach>
                    </form:select>
                </td>
             </tr>
             <tr>
                <td><label for="roomBoard">Room And Board($):</label>
                    <form:select id="roomBoard" path="roomBoard" cssClass="span-8" cssErrorClass="span-8 validationFailed" cssStyle="width:150px;">
                       <form:option value="" selected="selected">No Preference</form:option>
                          <c:forEach var="roomBoard" items="${tuitionRangeList}" varStatus="status">
                             <form:option value="${roomBoard}">${roomBoard}</form:option>
                          </c:forEach>
                    </form:select>
                </td>
             </tr>
             <tr>
                <td><label for="type">School Type:</label>
                    <form:select id="type" path="type" cssClass="span-8" cssErrorClass="span-8 validationFailed" cssStyle="width:150px;">
                       <form:option value="" selected="selected">No Preference</form:option>
                          <c:forEach var="type" items="${schoolTypeList}" varStatus="status">
                             <form:option value="${type}">${type}</form:option>
                          </c:forEach>
                    </form:select>
                </td> 
             </tr>
             <tr>
                <td><label for="category">School Category:</label>
                    <form:select id="category" path="category" cssClass="span-8" cssErrorClass="span-8 validationFailed" cssStyle="width:150px;">
                       <form:option value="" selected="selected">No Preference</form:option>
                          <c:forEach var="category" items="${schoolCategoryList}" varStatus="status">
                             <form:option value="${category}">${category}</form:option>
                          </c:forEach>
                    </form:select>
                </td> 
            </tr>
            <tr>
                <td><label for="setting">School Setting:</label>
                    <form:select id="setting" path="setting" cssClass="span-8" cssErrorClass="span-8 validationFailed" cssStyle="width:150px;">
                       <form:option value="" selected="selected">No Preference</form:option>
                          <c:forEach var="setting" items="${schoolSettingList}" varStatus="status">
                             <form:option value="${setting}">${setting}</form:option>
                          </c:forEach>
                    </form:select>
                </td> 
            </tr>
            <tr>
                <td><label for="size">School Size:</label>
                    <form:select id="size" path="size" cssClass="span-8" cssErrorClass="span-8 validationFailed" cssStyle="width:150px;">
                       <form:option value="" selected="selected">No Preference</form:option>
                          <c:forEach var="size" items="${schoolSizeList}" varStatus="status">
                             <form:option value="${size}">${size}</form:option>
                          </c:forEach>
                    </form:select>
                </td> 
            </tr>
            <tr>
                <td><label for="state">State:</label>
                    <form:select id="state" path="state" cssClass="span-8" cssErrorClass="span-8 validationFailed" cssStyle="width:150px;">
                       <form:option value="" selected="selected">No Preference</form:option>
                          <c:forEach var="state" items="${stateList}" varStatus="status">
                             <form:option value="${state}">${state.description}</form:option>
                          </c:forEach>
                    </form:select>
                </td> 
            </tr>
            <tr>
                <td><label for="internationalFinancialAid">Financial Aid for International Students:</label>
                    <form:select id="internationalFinancialAid" path="internationalFinancialAid" cssClass="span-8" cssErrorClass="span-8 validationFailed" cssStyle="width:150px;">
                       <form:option value="" selected="selected">No Preference</form:option>
                          <c:forEach var="internationalFinancialAid" items="${internationalFinancialAidList}" varStatus="status">
                             <form:option value="Yes">${internationalFinancialAid}</form:option>
                          </c:forEach> 
                    </form:select>
                </td> 
            </tr>	
            <tr><td><input type="submit" value="Submit"/></td></tr>
         </table>
      </form:form>
    </div>  
    <div style="float:left;  margin-left:20px; width:48%; text-align:center; border-style: solid; border-width:1px;background-color:Coral">
       <form:form method="GET" action="${action}" modelAttribute="school">
         <table style="width:100%; margin-bottom:-7px; text-align:center;">            
             <caption>Match you and your suitable colleges</caption>
             <tr>
                <td><label>GPA:</label><form:input path=""></form:input></td>
             </tr>
             <tr>
                <td><label>SAT I Score:</label><form:input path="sat1Score"></form:input></td>
                <td>   Or   </td>
                <td><label for="actScore">ACT Score:</label>
                    <form:select id="actScore" path="actScore" cssClass="span-8" cssErrorClass="span-8 validationFailed" cssStyle="width:120px;">
                       <form:option value="" selected="selected">Select One</form:option>
                          <c:forEach var="actScore" items="${actScoreList}" varStatus="status">
                             <form:option value="${actScore}">${actScore}</form:option>
                          </c:forEach>
                    </form:select>
                </td> 
             </tr> 
             <tr>
                <td><label>TOEFL Score:</label><form:input path="toefl"></form:input></td>
                <td>Or</td>
                <td><label>IELTS Score:</label><form:input path="ielts"></form:input></td>
             </tr>
          </table>
          <hr></hr>
          <table style="width:100%; margin-top:-8px;text-align:center; cellpadding: 0px; cellpadding: 0px 10px;"> 
             <tr>
                <td><label for="rankOverall">School Rank:</label>
                    <form:select id="rankOverall" path="rankOverall" cssClass="span-8" cssErrorClass="span-8 validationFailed" cssStyle="width:120px;">
                       <form:option value="" selected="selected">No Preference</form:option>
                          <c:forEach var="rankOverall" items="${schoolRankList}" varStatus="status">
                             <form:option value="${rankOverall}">${rankOverall}</form:option>
                          </c:forEach>
                    </form:select>
                </td> 
                <td><label for="state">State:</label>
                    <form:select id="state" path="state" cssClass="span-8" cssErrorClass="span-8 validationFailed" cssStyle="width:120px;">
                       <form:option value="" selected="selected">No Preference</form:option>
                          <c:forEach var="state" items="${stateList}" varStatus="status">
                             <form:option value="${state}">${state.description}</form:option>
                          </c:forEach>
                    </form:select>
                 </td> 
             </tr>
             <tr>
                <td><label for="tuitionFee">Tuition and Fees($):</label>
                    <form:select id="tuitionFee" path="tuitionFee" cssClass="span-8" cssErrorClass="span-8 validationFailed" cssStyle="width:120px;">
                       <form:option value="" selected="selected">No Preference</form:option>
                          <c:forEach var="tuitionFee" items="${tuitionRangeList}" varStatus="status">
                             <form:option value="${tuitionFee}">${tuitionFee}</form:option>
                          </c:forEach>
                    </form:select>
                </td>
                <td><label for="roomBoard">Room And Board($):</label>
                    <form:select id="roomBoard" path="roomBoard" cssClass="span-8" cssErrorClass="span-8 validationFailed" cssStyle="width:120px;">
                       <form:option value="" selected="selected">No Preference</form:option>
                          <c:forEach var="roomBoard" items="${tuitionRangeList}" varStatus="status">
                             <form:option value="${roomBoard}">${roomBoard}</form:option>
                          </c:forEach>
                    </form:select>
                </td>
             </tr>
             <tr>
                <td><label for="type">School Type:</label>
                    <form:select id="type" path="type" cssClass="span-8" cssErrorClass="span-8 validationFailed" cssStyle="width:120px;">
                       <form:option value="" selected="selected">No Preference</form:option>
                          <c:forEach var="type" items="${schoolTypeList}" varStatus="status">
                             <form:option value="${type}">${type}</form:option>
                          </c:forEach>
                    </form:select>
                </td> 
                <td><label for="category">School Category:</label>
                    <form:select id="category" path="category" cssClass="span-8" cssErrorClass="span-8 validationFailed" cssStyle="width:120px;">
                       <form:option value="" selected="selected">No Preference</form:option>
                          <c:forEach var="category" items="${schoolCategoryList}" varStatus="status">
                             <form:option value="${category}">${category}</form:option>
                          </c:forEach>
                    </form:select>
                </td> 
             </tr>
             <tr>   
                <td><label for="setting">School Setting:</label>
                    <form:select id="setting" path="setting" cssClass="span-8" cssErrorClass="span-8 validationFailed" cssStyle="width:120px;">
                       <form:option value="" selected="selected">No Preference</form:option>
                          <c:forEach var="setting" items="${schoolSettingList}" varStatus="status">
                             <form:option value="${setting}">${setting}</form:option>
                          </c:forEach>
                    </form:select>
                </td> 
                <td><label for="size">School Size:</label>
                    <form:select id="size" path="size" cssClass="span-8" cssErrorClass="span-8 validationFailed" cssStyle="width:120px;">
                       <form:option value="" selected="selected">No Preference</form:option>
                          <c:forEach var="size" items="${schoolSizeList}" varStatus="status">
                             <form:option value="${size}">${size}</form:option>
                          </c:forEach>
                    </form:select>
                 </td> 
              </tr>
              <tr>
                 <td><label for="internationalFinancialAid">Financial Aid for International Students:</label>
                     <form:select id="internationalFinancialAid" path="internationalFinancialAid" cssClass="span-8" cssErrorClass="span-8 validationFailed" cssStyle="width:150px;">
                       <form:option value="" selected="selected">No Preference</form:option>
                          <c:forEach var="internationalFinancialAid" items="${internationalFinancialAidList}" varStatus="status">
                             <form:option value="Yes">${internationalFinancialAid}</form:option>
                          </c:forEach>
                    </form:select>
                 </td> 
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
