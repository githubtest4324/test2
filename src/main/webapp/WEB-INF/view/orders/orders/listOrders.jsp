<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!-- HEADER -->
<%@include file="/WEB-INF/view/pageTemplate/header.jsp" %>

<!-- CONTENT -->
<!-- 	Actions -->
   <form:form method="post" action="refresh" style="display:inline">
	<input type="submit" value="Refresh"/>
   </form:form>
   <form:form method="post" action="create" style="display:inline">
	<input type="submit" value="Create"/>
   </form:form>
   <form:form method="post" action="add2" style="display:inline">
	<input type="submit" value="Remove"/>
   </form:form>

<!-- 	Order list -->
   <c:if  test="${!empty ordList}">
   <table class="data">
   <tr>
       <th>Reference No</th>
   </tr>
   <c:forEach items="${ordList}" var="ord">
   	<tr>
           <td>${ord.referenceNo} </td>
   	</tr>
   </c:forEach>
   </table>
   </c:if>

<!-- FOOTER -->
<%@include file="/WEB-INF/view/pageTemplate/footer.jsp" %>
