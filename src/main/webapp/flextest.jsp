<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://test2.tags" prefix="t"%>

<!-- HEADER -->
<%@include file="/WEB-INF/view/pageTemplate/header.jsp" %>

<!-- CONTENT -->
<t:column style="width: 80%;background-color: green; border: 1px; border-style: solid; margin-left: auto; margin-right: auto;align-items:stretch;">
	<t:row style="background-color: blue; border: 1px; border-style: solid;">
		<t:row style="background-color: blue; border: 1px; border-style: solid;">
			<t:column style='background-color: red; border: 1px; border-style: solid;'>
				<form class='column'>
					<fieldset class='column'>
						<t:row>Label 1<input type="checkbox"></t:row>
						<t:row>Label 2<input type="checkbox" disabled='disabled'></t:row>
						<t:row>Label 3<input type="checkbox"></t:row>
					</fieldset>
					<fieldset>
						<t:row>Label 1<input type="radio" name="radio"></t:row>
						<t:row>Label 2<input type="radio" name="radio" disabled></t:row>
						<t:row>Label 3<input type="radio" name="radio"></t:row>
					</fieldset>
					<fieldset>
					  <t:row>Label 1<input type="range" value="0"></t:row>
					</fieldset>
					<t:row>Label 1<input placeholder='First Name (required)' type='text'></t:row>
					<t:row>Label 2<input placeholder='First Name (required)' type='text' disabled></t:row>
				</form>
			</t:column>
			<t:column style='background-color: red; border: 1px; border-style: solid;'>
				<form class='column'>
					<fieldset class='column'>
						<input type="checkbox">
						<input type="checkbox" disabled>
						<input type="checkbox">
					</fieldset>
					<fieldset>
						<input type="radio" name="radio">
						<input type="radio" name="radio" disabled>
						<input type="radio" name="radio">
					</fieldset>
					<fieldset>
					  <input type="range" value="0">
					</fieldset>
					<input placeholder='First Name (required)' type='text'>
					<input placeholder='First Name (required)' type='text' disabled>
				</form>
			</t:column>
		</t:row>
	</t:row>
</t:column>
		
<!-- FOOTER -->
<%@include file="/WEB-INF/view/pageTemplate/footer.jsp" %>
