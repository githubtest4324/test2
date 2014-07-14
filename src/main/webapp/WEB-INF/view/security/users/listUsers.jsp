<%@page import="test2.utils.TagUtils.FlexDirection"%>
<%@page import="test2.utils.TagUtils.FlexJustify"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://test2.tags" prefix="t"%>
    
<!-- HEADER -->
<%@include file="/WEB-INF/view/pageTemplate/header.jsp" %>

<!-- CONTENT -->

<t:column>
	<form:form method="POST" commandName="criteria">
		<!-- CRITERIA -->
		<t:formBox>
			<t:formField label="Name"><form:input path="name" autofocus='autofocus'/></t:formField>
			<t:formField label="Username"><form:input path="username"/></t:formField>
		</t:formBox>

		<!-- 	ACTIONS -->
		<t:row justify="<%=FlexJustify.START %>">
			<input type="submit" name='refresh' value="Refresh" />
			<t:allowed roles="admin">				
				<input type="submit" name="goToAdd" value="Add user" />

				<input id='fi34'  name='editUserIds' type="hidden"/>
				<input type="submit" name='goToEdit' value="Edit" onclick='document.getElementById("fi34").value = getSelectedRecords("t1"); this.parentNode.submit();'/>

				<input id='fsafl'  name='confirmDeleteUserIds' type="hidden"/>
				<input type="submit" name='deleteConfirmation' value="Delete" onclick='document.getElementById("fsafl").value = getSelectedRecords("t1"); this.parentNode.submit();'/>
			</t:allowed>
		</t:row>
		
		<!-- ACTION WARNINGS/ERRORS -->
		<c:if test="${multipleSelectionForbidden==true}">
			<span style="display: block;" class='warning'><spring:message code="multipleSelectionForbidden"/></span>
		</c:if>
		<c:if test="${noSelectionForbidden==true}">
			<span style="display: block;" class='warning'><spring:message code="noSelectionForbidden"/></span>
		</c:if>
 	
		<!-- 	VALIDATE DELETION -->
		<c:if test="${deleteUserValidation==true }">
			<div style='margin-left: auto; margin-right: auto'>
				<t:formBox>
					<span class='warning'>Are you sure you want to delete ${userNames }?</span>
					<t:row justify="<%=FlexJustify.CENTER %>">
						<input type="hidden" name='deleteUserIds' value='${userIds }'/>
						<input type="submit" name='delete' value="Delete" autofocus="autofocus" />
						<input type="submit" name='refresh' value="Cancel"/>
					</t:row>
				</t:formBox>
			</div>
		</c:if>
		<span class="error">${error }</span>
		
		<!-- 	TABLE -->
		<t:formBox>
			<t:table entities="${users}" tableId="t1"></t:table>
		</t:formBox>
	</form:form>
</t:column>

<t:debugServletAttributes showRequestAttributes="true" showRequestParameters="true" showSessionAttributes="true"></t:debugServletAttributes>

<!-- FOOTER -->
<%@include file="/WEB-INF/view/pageTemplate/footer.jsp" %>
