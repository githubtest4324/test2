<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://test2.tags" prefix="t"%>

<!-- HEADER -->
<%@include file="/WEB-INF/view/pageTemplate/header.jsp" %>

<!-- CONTENT -->
User: ${principal.name}
<t:allowed roles="admin">
	aaa
</t:allowed>
<t:allowed roles="admin2">
	bbb
</t:allowed>

<!-- FOOTER -->
<%@include file="/WEB-INF/view/pageTemplate/footer.jsp" %>


