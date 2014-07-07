<%@page import="test2.utils.TagUtils.FlexDirection"%>
<%@page import="test2.utils.TagUtils.FlexJustify"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://test2.tags" prefix="t"%>
    
<!-- HEADER -->
<%@include file="/WEB-INF/view/pageTemplate/header.jsp" %>

<!-- CONTENT -->

<t:column>
	<!-- CRITERIA -->
	<t:formBox>
		<form:form action="list" method="POST" commandName="criteria">
			<t:formField label="Name"><form:input path="name"/></t:formField>
			<t:formField label="Username"><form:input path="username"/></t:formField>
		</form:form>
	</t:formBox>
	<t:row justify="<%=FlexJustify.START %>">
		<form:form action="addAction" method="POST">
			<input type="submit" value="Add user" />
		</form:form>
	</t:row>
	
	<!-- 	CONTENT -->
	<t:formBox>
		<t:table entities="${users}"></t:table>
	</t:formBox>
</t:column>




<!-- FOOTER -->
<%@include file="/WEB-INF/view/pageTemplate/footer.jsp" %>
