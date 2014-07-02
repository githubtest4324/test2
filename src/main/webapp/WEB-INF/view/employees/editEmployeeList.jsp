<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spring 3 hibernate integration example</title>

	<h2>Employee Management Screen : Spring 3 hibernate integration example on www.howtodoinjava.com</h2>

	<!-- 	Actions -->
    <form:form method="post" action="refresh" style="display:inline">
		<input type="submit" value="Refresh"/>
    </form:form>
    <form:form method="post" action="add2" style="display:inline">
		<input type="submit" value="Create"/>
    </form:form>
    <form:form method="post" action="add2" style="display:inline">
		<input type="submit" value="Remove"/>
    </form:form>

	<!-- 	Employee list -->
    <c:if  test="${!empty employeeList}">
    <table class="data">
    <tr>
        <th>Name</th>
        <th>Age</th>
    </tr>
    <c:forEach items="${employeeList}" var="emp">
        <tr>
            <td>${emp.name} </td>
            <td>${emp.age}</td>
    </c:forEach>
    </table>
    </c:if>

</head>
<body>

</body>
</html>