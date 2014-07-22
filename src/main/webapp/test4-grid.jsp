<!DOCTYPE html>
<%@page import="test2.utils.TagUtils.FlexJustify"%>
<%@page import="test2.utils.TagUtils.FlexAlign"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html ng-app="myApp">
<head>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<script>
	var contextPath = "${contextPath}"
</script>
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" />
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/font-awesome/4.0.0/css/font-awesome.css" />
<link rel="stylesheet" type="text/css" href="${contextPath}/css/ng-grid.css" />

<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.20/angular.min.js"></script>
<script src="//ajax.googleapis.com/ajax/libs/angularjs/1.2.20/angular-route.js"></script>
<script src="${contextPath}/js/ng-grid-2.0.11.min.js"></script>

<script src="${contextPath}/test4-grid.js"></script>

<%@include file="/WEB-INF/view/pageTemplate/headerNg.jsp"%>
<style type="text/css">
.gridStyle {
	border: 1px solid rgb(212, 212, 212);
	/*     width: 400px;  */
	height: 300px;
}
</style>
</head>

<body ng-controller="MyCtrl">
	<t:column style="background-color: red;">
		<div class="gridStyle" ng-grid="gridOptions"></div>
		<div style='background-color: blue; height: 100px;'></div>
	</t:column>
</body>
</html>