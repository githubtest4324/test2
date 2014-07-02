<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!-- HEADER -->
<%@include file="/WEB-INF/view/pageTemplate/header.jsp" %>


<!-- CONTENT -->
<form:form method="post" action="create" commandName="order">
	<table>
		<tr>
			<td><spring:message code="referenceNo" /></td>
			<td><form:input path="referenceNo" />
		</tr>
	</table>
	<input type="submit" value="Create employee"/>
</form:form>

<!-- FOOTER -->
<%@include file="/WEB-INF/view/pageTemplate/footer.jsp" %>
