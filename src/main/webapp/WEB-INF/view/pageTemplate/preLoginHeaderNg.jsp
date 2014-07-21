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
	<link rel="stylesheet" type="text/css" href="${root}/css/reset.css" />
	<link rel="stylesheet" type="text/css" href="${root}/css/box.css" />
	<link rel="stylesheet" type="text/css" href="${root}/css/menu.css" />
	<link rel="stylesheet" type="text/css" href="${root}/css/body.css" />
	<link rel="stylesheet" type="text/css" href="${root}/css/form.css" />
	<link rel="stylesheet" type="text/css" href="${root}/css/flex.css" />
	<link rel="stylesheet" type="text/css" href="${root}/css/smartTable.css" />
	<link rel="stylesheet" type="text/css" href="${root}/css/smartTabs.css" />
	<link rel="stylesheet" type="text/css" href="${root}/css/ng-grid.css" />

	<script type="text/javascript" src="${root}/js/angular.min.js" ></script>
	<script type="text/javascript" src="${root}/js/jquery-1.11.1.js" ></script>
	<script type="text/javascript" src="${root}/js/ng-grid-2.0.11.min.js" ></script>
	<script type="text/javascript" src="${root}/js/smartTable.js" ></script>
	<script type="text/javascript" src="${root}/test.js" ></script>

	<title>${title}</title>
