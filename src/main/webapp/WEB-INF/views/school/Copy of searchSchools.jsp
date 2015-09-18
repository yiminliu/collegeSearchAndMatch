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
     <p>There are more than 3300 colleges in US to choose from, how to choose?  which ones are good fit for you? Here is the solution.
     </p>   
     <h3 style="margin-bottom: 10px; padding-bottom: 0px; color: GREEN">Fill in Your Criteria to Search Colleges</h3>
     <spring:url var="action" value="/school/searchSchools" />
     <div style="float : left; width:45%">
     <form:form method="GET" action="${action}" modelAttribute="school">
         <div><h4>Your Facts</h4></div>
         <table>
             <tr>
                <td><label>TOEFL Score:</label><form:input path="toefl"></form:input></td>
                <td>Or</td>
                <!-- <td><label>IELTS Score:</label><form:input path="toefl"></form:input></td>-->
             </tr>
             <tr>
                <td><label>SAT I Score:</label><form:input path="sat1Score"></form:input></td>
                 <td>Or</td>
                <td><label>ACT Score:</label><form:input path="actScore"></form:input></td>
             </tr>
              <!--<tr>
                <td><label>GPA:</label><form:input path=""></form:input></td>
               </tr>-->
         </table>
         <hr></hr>
         <div><h4>School Expectations</h4></div>
         <table>    
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
                             <form:option value="${internationalFinancialAid}">${internationalFinancialAid}</form:option>
                          </c:forEach>
                    </form:select>
                </td> 
            </tr>	
            <!-- <tr>
                <td><label for="p">Major:</label>
                    <form:select id="state" path="state" cssClass="span-8" cssErrorClass="span-8 validationFailed" cssStyle="width:150px;">
                       <form:option value="" selected="selected">No Preference</form:option>
                          <c:forEach var="state" items="${stateList}" varStatus="status">
                             <form:option value="${state}">${state.description}</form:option>
                          </c:forEach>
                    </form:select>
                </td> 
            </tr>-->	
          </table>
          <table>	 
		<tr><td><input type="submit" value="Submit"/></td></tr>
	</table>
     </form:form>
     </div>
          <div style="float : right; width:45%">
     <form:form method="GET" action="${action}" modelAttribute="school">
         <div><h4>Your Facts</h4></div>
         <table>
             <tr>
                <td><label>TOEFL Score:</label><form:input path="toefl"></form:input></td>
                <td>Or</td>
                <!-- <td><label>IELTS Score:</label><form:input path="toefl"></form:input></td>-->
             </tr>
             <tr>
                <td><label>SAT I Score:</label><form:input path="sat1Score"></form:input></td>
                 <td>Or</td>
                <td><label>ACT Score:</label><form:input path="actScore"></form:input></td>
             </tr>
              <!--<tr>
                <td><label>GPA:</label><form:input path=""></form:input></td>
               </tr>-->
         </table>
         <hr></hr>
         <div><h4>School Expectations</h4></div>
         <table>    
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
                             <form:option value="${internationalFinancialAid}">${internationalFinancialAid}</form:option>
                          </c:forEach>
                    </form:select>
                </td> 
            </tr>	
            <!-- <tr>
                <td><label for="p">Major:</label>
                    <form:select id="state" path="state" cssClass="span-8" cssErrorClass="span-8 validationFailed" cssStyle="width:150px;">
                       <form:option value="" selected="selected">No Preference</form:option>
                          <c:forEach var="state" items="${stateList}" varStatus="status">
                             <form:option value="${state}">${state.description}</form:option>
                          </c:forEach>
                    </form:select>
                </td> 
            </tr>-->	
          </table>
          <table>	 
		<tr><td><input type="submit" value="Submit"/></td></tr>
	</table>
     </form:form>
   </div>   
   </div>     
   
</body>
</html>
