<!DOCTYPE html>
<%@page import="test2.utils.TagUtils.FlexJustify"%>
<%@page import="test2.utils.TagUtils.FlexAlign"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html ng-app="myApp">
<head>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
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
<script src="${contextPath}/js/ng-grid-2.0.11.min.js" ></script>


<script src="${contextPath}/js/mainController.js"></script>
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
	root path: ${contextPath}

	<div id="main">
		<div ng-view></div>
	</div>

	<footer class="text-right">
		<p>Copyright @2014</p>
	</footer>
</body>
</html>