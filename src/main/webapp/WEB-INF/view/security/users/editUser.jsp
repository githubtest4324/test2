<%@page import="test2.utils.TagUtils.FlexJustify"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://test2.tags" prefix="t"%>

<!-- HEADER -->
<%@include file="/WEB-INF/view/pageTemplate/header.jsp"%>

<!-- CONTENT -->
<form:form method="POST" commandName="userEdit">
	<t:tabs>
		<t:tab title="User">
			<t:formBox>
				<t:formSection>
					<form:hidden path="id" />
					<t:formField label="Name">
						<form:input path="name" autofocus='autofocus' />
						<form:errors path="name" cssClass="error"></form:errors>
					</t:formField>
					<t:formField label="Username">
						<form:input path="username" />
						<form:errors path="username" cssClass="error"></form:errors>
					</t:formField>
				</t:formSection>
				<input type="submit" value="Update" name="update" />
				<input type="submit" value="Cancel" name="cancelEdit" />
			</t:formBox>
		</t:tab>
		<t:tab title="Roles">
		</t:tab>
		<t:tab title="Trace info">
			<t:formBox>
				<t:row>
					<t:formSection>
						<t:formField label="Creation date">${ userEdit.traceable.creationDate }</t:formField>
						<t:formField label="Last update date">${ userEdit.traceable.lastUpdateDate }</t:formField>
					</t:formSection>
					<t:formSection>
						<t:formField label="Created by">${ userEdit.traceable.createdBy }</t:formField>
						<t:formField label="Last updated by">${ userEdit.traceable.lastUpdatedBy }</t:formField>
					</t:formSection>
				</t:row>
			</t:formBox>
		</t:tab>
	</t:tabs>
</form:form>


<t:debugServletAttributes showRequestAttributes="true" showRequestParameters="true" showRequestHeaders="true"
	showSessionAttributes="true"></t:debugServletAttributes>

<!-- FOOTER -->
<%@include file="/WEB-INF/view/pageTemplate/footer.jsp"%>
