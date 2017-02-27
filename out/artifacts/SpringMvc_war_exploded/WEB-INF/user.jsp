<%@ page import="com.art.model.User" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add User</title>
</head>
<body>
<h2>Registration Form</h2>
<form:form method="POST" path="user" commandName="user" modelAttribute="user"   action="/new_user">
    <table>
        <tr>
            <td><label for="login"> Login: </label> </td>
            <td><form:input path="login" id="login"/></td>
            <td> <form:errors  path="login" cssClass="error"/> </td>
        </tr>

        <tr>
            <td><label for="password">Password: </label> </td>
            <td><form:input path="password" id="password"/></td>
            <td> <form:errors  path="password" cssClass="error"/> </td>
        </tr>

    </table>
    <form:button typt="sumbit" >Okey</form:button>
</form:form>

</body>
</html>
