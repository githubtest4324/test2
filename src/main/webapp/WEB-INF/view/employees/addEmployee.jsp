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
    <form:form method="post" action="add" commandName="employee">
        <table>
        <tr>
            <td><form:label path="name"><spring:message code="label.firstname"/></form:label></td>
            <td><form:input path="name" /></td>
            <td><form:label path="age"><spring:message code="label.age"/></form:label></td>
            <td><form:input path="age" /></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="<spring:message code="label.add"/>"/>
            </td>
        </tr>
    </table>
    </form:form>

</head>
<body>

</body>
</html>