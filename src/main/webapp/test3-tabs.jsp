<%@page import="test2.utils.TagUtils.FlexJustify"%>
<%@page import="test2.utils.TagUtils.FlexAlign"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://test2.tags" prefix="t"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- HEADER -->
<%@include file="/WEB-INF/view/pageTemplate/header.jsp"%>

<!-- CONTENT-->

<t:tabs>
	<t:tab title="Tab1">
	Tab1 content
	</t:tab>
	<t:tab title="Tab2">
	Tab2 content
		<t:tabs>
			<t:tab title="Tab4">
			Tab4 content
			</t:tab>
			<t:tab title="Tab5">
			Tab5 content
			</t:tab>
		</t:tabs>
	</t:tab>
	<t:tab title="Tab3">
	Tab3 content
	</t:tab>
</t:tabs>

<!-- AICI AM RAMAS: * am bele tab-uri sunt selectate; * sa pot avea tab in tab  -->
<!-- FOOTER -->
<%@include file="/WEB-INF/view/pageTemplate/footer.jsp"%>
