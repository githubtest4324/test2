<!DOCTYPE html>
<%@page import="test2.utils.TagUtils.FlexJustify"%>
<%@page import="test2.utils.TagUtils.FlexAlign"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html ng-app="myApp">
<head>
<%-- <%@include file="/WEB-INF/view/pageTemplate/headerNg.jsp"%> --%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<script>
	var rootPath = "${pageContext.request.contextPath}"
</script>

<!-- SCROLLS -->
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" />
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/font-awesome/4.0.0/css/font-awesome.css" />

<!-- SPELLS -->
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.10/angular.min.js"></script>
<script src="//ajax.googleapis.com/ajax/libs/angularjs/1.2.10/angular-route.js"></script>


<script src="${rootPath}/js/mainController.js"></script>
</head>

<body ng-controller="mainController">
	<nav class="navbar navbar-default">
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand" href="/">Angular Routing Example</a>
			</div>

			<ul class="nav navbar-nav navbar-right">
				<li><a href="#"><i class="fa fa-home"></i> Home</a></li>
				<li><a href="#about"><i class="fa fa-shield"></i>Security</a></li>
			</ul>
		</div>
	</nav>
	root path: ${rootPath }

	<div id="main">
		<div ng-view></div>
	</div>

	<footer class="text-right">
		<p>Copyright @2014</p>
	</footer>
</body>
</html>