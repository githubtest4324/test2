<%@page import="test2.utils.TagUtils.FlexJustify"%>
<%@page import="test2.utils.TagUtils.FlexAlign"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://test2.tags" prefix="t"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- HEADER -->
<%@include file="/WEB-INF/view/pageTemplate/header.jsp"%>

<!-- CONTENT-->

<t:smartTabs>
	<t:smartTab title="Tab1">
	Tab1 content
	</t:smartTab>
	<t:smartTab title="Tab2">
	Tab2 content
	</t:smartTab>
	<t:smartTab title="Tab2">
	Tab3 content
	</t:smartTab>
</t:smartTabs>

<!-- AICI AM RAMAS: * am bele tab-uri sunt selectate; * sa pot avea tab in tab  -->
<!-- FOOTER -->
<%@include file="/WEB-INF/view/pageTemplate/footer.jsp"%>
