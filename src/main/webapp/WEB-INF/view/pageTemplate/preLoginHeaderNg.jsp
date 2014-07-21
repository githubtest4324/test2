<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@page import="java.io.IOException"%>
<%@page import="test2.utils.TagUtils.FlexJustify"%>
<%@page import="test2.utils.TagUtils.FlexAlign"%>

<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%-- <%@taglib uri="http://test2.tags" prefix="t"%> --%>


	<!-- Shortcut variables -->
	<c:set var="root" value="${pageContext.request.contextPath}"/>
	<script>var rootPath = "${pageContext.request.contextPath}"</script>

	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

	<link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" />
	<link rel="stylesheet" href="http://netdna.bootstrapcdn.com/font-awesome/4.0.0/css/font-awesome.css" />
	<link rel="stylesheet" type="text/css" href="${root}/css/menu.css" />
	<link rel="stylesheet" type="text/css" href="${root}/css/ng-grid.css" />

	<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.20/angular.min.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.20/angular-route.js"></script>
	<script src="http://netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js" ></script>
	<script src="${root}/js/ng-grid-2.0.11.min.js" ></script>
	<script src="${root}/test.js" ></script>

	<title>${title}</title>
