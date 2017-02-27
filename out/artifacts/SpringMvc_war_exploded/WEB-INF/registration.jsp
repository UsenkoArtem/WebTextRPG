<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update</title>
    <style>
        td select,
        td input {
            width: 150px;
        }
        label {
            display: block;
        }
        .error input,
        .error textarea {
            border: 1px solid red;
        }
        .error {
            color: red;
        }
    </style>
</head>
<body>
<h2>Update Form</h2>
<form:form method="POST" path="userDetails" commandName="userDetails" modelAttribute="userDetails" action="/userDetails">
    <table>
        <tr>
            <td><label for="firstName">Name: </label> </td>
            <td><form:input path="firstName" id="firstName"/></td>
           <td> <form:errors  path="firstName" cssClass="error"/> </td>
        </tr>

        <tr>
            <td><label for="secondName">Surname: </label> </td>
            <td><form:input path="secondName" id="secondName"/></td>
            <td> <form:errors  path="secondName" cssClass="error"/> </td>
        </tr>

        <tr>
            <td><label for="age">Age: </label> </td>
            <td><form:input path="age" id="age"/></td>
            <td> <form:errors  path="age" cssClass="error"/> </td>
        </tr>
    </table>
    <form:button typt="sumbit" >Okey</form:button>
</form:form>
<br/>
<br/>
Go back to <a href="/">List of All Employees</a>
</body>
</html>