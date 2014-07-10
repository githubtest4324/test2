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
		<form:form action="refreshAction" method="POST">
			<input type="submit" value="Refresh" />
		</form:form>
		<form:form action="addAction" method="POST">
			<input type="submit" value="Add user" />
		</form:form>
		<form:form action="deleteAction" method="POST">
			<input id='fsafl' type="hidden" name='ids'/>
			<input type="submit" value="Delete user" name='confirmation' onclick='document.getElementById("fsafl").value = getSelectedRecords("t1"); this.parentNode.submit();'/>
		</form:form>
	</t:row>
	
	<!-- 	VALIDATION -->
	<c:if test="${deleteUserValidation==true }">
		<div style='margin-left: auto; margin-right: auto'>
			<t:formBox>
				<span class='warning'>Are you sure you want to delete ${userNames }?</span>
				<t:row justify="<%=FlexJustify.CENTER %>">
					<form:form action="deleteAction" method="POST">
						<input type="hidden" name='ids' value='${userIds }'/>
						<input type="submit" value="Delete" name='delete' />
					</form:form>
					<form:form action="refreshAction" method="POST">
						<input type="submit" value="Cancel"/>
					</form:form>
				</t:row>
			</t:formBox>
		</div>
	</c:if>
	<span class="error">${error }</span>
		
	<!-- 	TABLE -->
	<t:formBox>
		<t:table entities="${users}" tableId="t1"></t:table>
	</t:formBox>
</t:column>

<t:debugServletAttributes showRequestAttributes="true" showRequestParameters="true" showSessionAttributes="true"></t:debugServletAttributes>

<!-- FOOTER -->
<%@include file="/WEB-INF/view/pageTemplate/footer.jsp" %>
