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
	<link rel="stylesheet" type="text/css" href="${root}/css/old/reset.css" />
	<link rel="stylesheet" type="text/css" href="${root}/css/old/box.css" />
	<link rel="stylesheet" type="text/css" href="${root}/css/old/menu.css" />
	<link rel="stylesheet" type="text/css" href="${root}/css/old/body.css" />
	<link rel="stylesheet" type="text/css" href="${root}/css/old/form.css" />
	<link rel="stylesheet" type="text/css" href="${root}/css/old/flex.css" />
	<link rel="stylesheet" type="text/css" href="${root}/css/old/smartTable.css" />
	<link rel="stylesheet" type="text/css" href="${root}/css/old/smartTabs.css" />

 	<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
	<script language="javascript" type="text/javascript" src="${root}/js/old/smartTable.js" ></script>
	<title>${title}</title>
</head>
<script>var rootPath = "${pageContext.request.contextPath}"</script>
