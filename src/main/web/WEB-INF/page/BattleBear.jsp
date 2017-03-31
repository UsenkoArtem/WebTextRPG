
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
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>

    <script type="text/javascript">
        <%@include file="/resource/js/battle.js"%>
    </script>
    <title>Battle</title>
</head>
<body >
<div align="center">
    <img src="<c:url value="/resource/image/sprites/Images/Enemies/WoodLand/bear.png"/>"
         height="350" width="350">
</div>
<hr>
<div style="position:  absolute; top:20% ; color: #4CAF50">
    <table style=" color: #4CAF50;" id="enemy">
        <tr>
            <td style="padding: 20px"> Health</td>
            <td style="padding: 20px" id="health"> ${Bear.health}</td>

        </tr>
        <tr>
            <td style="padding: 20px"> Attack</td>
            <td style="padding: 20px"> ${Bear.attack}</td>

        </tr>
        <tr>
            <td style="padding: 20px"> Defense</td>
            <td style="padding: 20px"> ${Bear.defense}</td>

        </tr>
    </table>
</div>
<div style="position: absolute; top: 60%">
    <table style=" color: #4CAF50;">
        <tr>
            <td style="padding: 20px"> Health</td>
            <td style="padding: 20px"> ${Player.health}</td>
            <td style="padding: 20px">
                <input type="button" value="Head attack" onclick="headAttack('${Bear.name}')"/>
            </td>
        </tr>
        <tr>
            <td style="padding: 20px"> Attack</td>
            <td style="padding: 20px"> ${Player.attack}</td>
            <td style="padding: 20px">
                <input type="button" value="Body attack"/>
            </td>
        </tr>
        <tr>
            <td style="padding: 20px"> Defense</td>
            <td style="padding: 20px"> ${Player.defense}</td>
            <td style="padding: 20px">
                <input type="button" value="Legs attack"/>
            </td>
        </tr>
    </table>
</div>
</body>
</html>
