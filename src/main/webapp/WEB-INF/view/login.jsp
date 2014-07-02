<%@page import="test2.utils.TagUtils.FlexJustify"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://test2.tags" prefix="t"%>
    
<!-- HEADER -->
<%@include file="/WEB-INF/view/pageTemplate/preLoginHeader.jsp" %>
<!-- CONTENT -->

<t:row justify="<%=FlexJustify.CENTER%>" style="margin-left: 30px; margin-right: 30px">
	<t:formBox title="Login">
		<form:form method="post" action="performLogin" commandName="user">
			<t:formSection>
				<t:formField label="User">
					<form:input path="username"/>
				</t:formField>
				<t:formField label="Password">
					<form:password path="password"/>
				</t:formField>
			</t:formSection>
			<input type="submit" value="Login"/>
		</form:form>
	</t:formBox>
</t:row>
Outcome <c:if test="${!empty outcome}">${outcome}</c:if>




<!-- FOOTER -->
<%@include file="/WEB-INF/view/pageTemplate/footer.jsp" %>
