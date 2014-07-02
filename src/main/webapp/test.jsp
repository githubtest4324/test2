<%@page import="test2.utils.TagUtils.FlexJustify"%>
<%@page import="test2.utils.TagUtils.FlexAlign"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://test2.tags" prefix="t"%>

<!-- HEADER -->
<%@include file="/WEB-INF/view/pageTemplate/header.jsp"%>

<!-- CONTENT-->

<t:row justify="<%=FlexJustify.CENTER%>" style="margin-left: 30px; margin-right: 30px">
	<t:formBox title="Title1">
		<form class='column'>
			<t:row>
				<t:formSection>
					<fieldset>
						<t:formField label="Label 1"><input type="checkbox"></t:formField>
						<t:formField label="Label 2"><input type="checkbox" disabled='disabled'></t:formField>
						<t:formField label="Label 1"><input type="checkbox"></t:formField>
					</fieldset>
					<hr/>
					<fieldset>
						<t:formField label="Label 1"><input type="radio" name="radio"></t:formField>
						<t:formField label="Label 2"><input type="radio" name="radio" disabled></t:formField>
						<t:formField label="Label 1"><input type="radio" name="radio"></t:formField>
					</fieldset>
					<hr/>
					<fieldset>
						<t:formField label="Label 1"><input type="range" value="0"></t:formField>
					</fieldset>
					<t:formField label="Label 1"><input placeholder='First Name (required)'	type='text'></t:formField>
					<t:formField label="Label 1"><input placeholder='First Name (required)' type='text' disabled></t:formField>
				</t:formSection>
				<t:formSection title="Section1">
					<fieldset>
						<t:formField label="Label 1"><input type="checkbox"></t:formField>
						<t:formField label="Label 2"><input type="checkbox" disabled='disabled'></t:formField>
						<t:formField label="Label 1"><input type="checkbox"></t:formField>
					</fieldset>
					<hr/>
					<fieldset>
						<t:formField label="Label 1"><input type="radio" name="radio"></t:formField>
						<t:formField label="Label 2"><input type="radio" name="radio" disabled></t:formField>
						<t:formField label="Label 1"><input type="radio" name="radio"></t:formField>
					</fieldset>
					<hr/>
					<fieldset>
						<t:formField label="Label 1"><input type="range" value="0"></t:formField>
					</fieldset>
					<t:formField label="Label 1"><input placeholder='First Name (required)'	type='text'></t:formField>
					<t:formField label="Label 1"><input placeholder='First Name (required)' type='text' disabled></t:formField>
				</t:formSection>
			</t:row>
		</form>
	</t:formBox>
	<t:formBox title="Title2">
		<form class='column'>
			<t:formSection>
				<fieldset>
					<t:formField label="Label 1"><input type="checkbox"></t:formField>
					<t:formField label="Label 2"><input type="checkbox" disabled='disabled'></t:formField>
					<t:formField label="Label 1"><input type="checkbox"></t:formField>
				</fieldset>
				<hr/>
				<fieldset>
					<t:formField label="Label 1"><input type="radio" name="radio"></t:formField>
					<t:formField label="Label 2"><input type="radio" name="radio" disabled></t:formField>
					<t:formField label="Label 1"><input type="radio" name="radio"></t:formField>
				</fieldset>
				<hr/>
				<fieldset>
					<t:formField label="Label 1"><input type="range" value="0"></t:formField>
				</fieldset>
				<t:formField label="Label 1"><input placeholder='First Name (required)'	type='text'></t:formField>
				<t:formField label="Label 1"><input placeholder='First Name (required)' type='text' disabled></t:formField>
			</t:formSection>
		</form>
	</t:formBox>
</t:row>




<!-- FOOTER -->
<%@include file="/WEB-INF/view/pageTemplate/footer.jsp"%>
