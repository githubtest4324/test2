<%@page import="test2.utils.TagUtils.FlexJustify"%>
<%@page import="test2.utils.TagUtils.FlexAlign"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://test2.tags" prefix="t"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<body ng-controller="MyCtrl">

	<!-- HEADER -->
	<%@include file="/WEB-INF/view/pageTemplate/headerNg.jsp"%>

<style type="text/css">
	.gridStyle {
		border: 1px solid rgb(212, 212, 212);
		/*     width: 400px;  */
 		height: 300px;
	}
</style>




	<!-- CONTENT-->
	<t:column style="background-color: red;">
		<div class="gridStyle" ng-grid="gridOptions"></div>
		<div style='background-color: blue; height: 100px;'></div>
	</t:column>

	<!-- FOOTER -->
</body>
<%@include file="/WEB-INF/view/pageTemplate/footerNg.jsp"%>
