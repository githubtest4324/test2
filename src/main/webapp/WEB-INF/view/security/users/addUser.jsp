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
		<form:form action="add" method="POST" commandName="user">
			<t:formSection>
				<t:formField label="Name"><form:input path="name"/></t:formField>
				<t:formField label="Username"><form:input path="username"/></t:formField>
				<t:formField label="Password">
					<form:password path="password"/>
					<c:if test="${!empty wrongPassword }">
						<span style='color: red;'>Wrong password</span>
					</c:if>
				</t:formField>
				<t:formField label="Retype password"><form:password path="computed.retypePassword"/></t:formField>
			</t:formSection>
			<input type="submit" value="Add"/>
		</form:form>
	</t:formBox>
</t:column>




<!-- FOOTER -->
<%@include file="/WEB-INF/view/pageTemplate/footer.jsp" %>
