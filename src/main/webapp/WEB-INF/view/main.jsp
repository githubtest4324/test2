<!DOCTYPE html>
<%@page import="test2.utils.TagUtils.FlexJustify"%>
<%@page import="test2.utils.TagUtils.FlexAlign"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<html ng-app="myApp">
<head>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<script>
	var contextPath = "${contextPath}";
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
<!-- Bootstrap plugin for hover support on dropdown menus. Link: https://github.com/CWSpear/bootstrap-hover-dropdown -->
<script src="${contextPath}/js/bootstrap-hover-dropdown.js"></script>
<!-- Angular bootstrap ui -->
<script src="${contextPath}/js/ui-bootstrap-tpls-0.11.0.min.js"></script>


<script src="${contextPath}/js/mainController.js"></script>
</head>

<body ng-controller="mainController">
	<nav class="navbar navbar-default" role="navigation">
		<div class="container-fluid">
			<!-- Toggle for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li class="active"><a href="#"><i class="fa fa-home"></i>Home</a></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown"><i
							class='fa fa-shield'></i>Security<span class="caret"></span></a>
						<ul class="dropdown-menu" role="menu">
							<li><a href="#security/listUsers">Users</a></li>
							<li><a href="#">Roles</a></li>
							<li class="divider"></li>
							<li><a href="#">Logout</a></li>
						</ul></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li>Username |</li>
					<li><spring:message code="version" /></li>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container-fluid -->
	</nav>

	<div id="main" class="container-fluid">
		<div ng-view></div>
	</div>

	<footer class="text-right">
		<p>Copyright @2014</p>
	</footer>
</body>
</html>