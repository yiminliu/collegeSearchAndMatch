<%@ include file="/WEB-INF/includes/taglibs.jsp"%>
<%@ include file="/WEB-INF/includes/doctype.jsp"%>
<%@ include file="/WEB-INF/includes/styles.jsp"%>

<html xmlns="http://www.w3.org/1999/xhtml" lang="en">

<head>
   <title>Search Engine</title>
</head>

<body background="http://localhost:8080/collegeSearch/static/images/search_bg3.jpg">
  <div class="container">
     <div><%@ include file="/WEB-INF/views/general/header.jsp"%></div>
     <spring:url var="action" value="/school/searchSchools" />
     <table class="center_element_text" style="width:70%; margin-top:5px; margin-bottom:8px; padding:0px; border-spacing: 30px 0px;">
       <tr>
          <td style="background-color:LightGreen;"><h4>Match you and your suitable colleges</h4></td>
       </tr>   
     </table>
     <div class="content" style="width:70%; margin-top:15px; border-style: solid; border-width:2px; ">  
        <form:form method="GET" action="${action}" modelAttribute="school">
           <form:hidden path="satActNotRequired" value="Yes"/>
            
           <table style="width:100%; margin-bottom:-7px; text-align:center;">            
             <caption>Enter Your Scores</caption>
             <tr>
                <td><label>GPA:</label><form:input path=""></form:input></td>
             </tr>
             <tr>
                <td><label>TOEFL Score:</label><form:input path="toefl"></form:input></td>
                <td>Or</td>
                <td><label>IELTS Score:</label><form:input path="ielts"></form:input></td>
             </tr>
          </table>
          <hr></hr>
          <table style="width:100%; margin-top:-8px;text-align:center; cellpadding: 0px; cellpadding: 0px 10px;"> 
             <caption>Enter Your Preferences</caption>
             <tr>
                <td><label for="totalCost">Total Cost (Tuition and Fees + Room and Board)($):</label>
                    <form:select id="totalCost" path="totalCost" cssClass="span-8" cssErrorClass="span-8 validationFailed" cssStyle="width:150px;">
                       <form:option value="" selected="selected">No Preference</form:option>
                          <c:forEach var="totalCost" items="${totalCostRangeList}" varStatus="status">
                             <form:option value="${totalCost}">${totalCost}</form:option>
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
         </table>
         <table class="center_element" style="margin-top:15px;">
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
