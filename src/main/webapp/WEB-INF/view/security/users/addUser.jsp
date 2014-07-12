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
		<form:form method="POST" commandName="user" autocomplete="off">
			<t:formSection>
				<t:formField label="Name">
					<form:input path="name" autofocus='autofocus'/>
					<form:errors path="name" cssClass="error" ></form:errors>
				</t:formField>
				<t:formField label="Username">
					<form:input path="username"/>
					<form:errors path="username" cssClass="error" ></form:errors>
				</t:formField>
				<t:formField label="Password">
					<form:password path="password"/>
					<form:errors path="password" cssClass="error" ></form:errors>
				</t:formField>
				<t:formField label="Retype password"><form:password path="computed.retypePassword" autocomplete="off"/></t:formField>
			</t:formSection>
			<input type="submit" value="Add" name="add"/>
			<input type="submit" value="Cancel" name="cancelAdd"/>
		</form:form>
	</t:formBox>
</t:column>


<t:debugServletAttributes showRequestAttributes="true" showRequestParameters="true" showRequestHeaders="true"></t:debugServletAttributes>

<!-- FOOTER -->
<%@include file="/WEB-INF/view/pageTemplate/footer.jsp" %>
