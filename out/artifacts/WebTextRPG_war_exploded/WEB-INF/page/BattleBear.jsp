<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<style>
    body {
        background-image: url("/resource/image/wood.png");
        background-size: cover;
    }
</style>
    <title>Battle</title>
</head>
<body>
<div align="center">
    <img src="<c:url value="/resource/image/sprites/Images/Enemies/WoodLand/bear.png"/>"
         height="350" width="350">
</div>
<hr>
<div style="position:  absolute; top:30%">
    Health : 100;
</div>
<div style="position: absolute; top: 60%">
    <table style=" color: #4CAF50;"  >
        <tr >
            <td style="padding: 20px"> Health</td>
            <td style="padding: 20px"> Health</td>
        </tr>
        <tr >
            <td style="padding: 20px"> Attack</td>
            <td style="padding: 20px"> Attack</td>
        </tr>
        <tr >
            <td style="padding: 20px"> Defense</td>
            <td style="padding: 20px"> Defense</td>
        </tr>
    </table>
</div>
</body>
</html>
