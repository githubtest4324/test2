<%@page import="java.io.IOException"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<!-- Shortcut variables -->
<c:set var="root" value="${pageContext.request.contextPath}"/>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" type="text/css" href="${root}/css/reset.css" />
	<link rel="stylesheet" type="text/css" href="${root}/css/box.css" />
	<link rel="stylesheet" type="text/css" href="${root}/css/menu.css" />
	<link rel="stylesheet" type="text/css" href="${root}/css/body.css" />
	<link rel="stylesheet" type="text/css" href="${root}/css/form.css" />
	<link rel="stylesheet" type="text/css" href="${root}/css/flex.css" />
	<link rel="stylesheet" type="text/css" href="${root}/css/smartTable.css" />
	<link rel="stylesheet" type="text/css" href="${root}/css/tabs.css" />
	<script language="javascript" type="text/javascript" src="${root}/js/smartTable.js" ></script>
	<title>${title}</title>
</head>
