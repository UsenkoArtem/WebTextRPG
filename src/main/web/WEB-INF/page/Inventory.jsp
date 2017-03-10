<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        body{
            font-family: san-sarif,Arial;
            font-size: large;
        }
    </style>
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
    <link href="<c:url value="/resource/css/inventory.css"/>" rel="stylesheet">
    <script type="text/javascript">
        <%@include file="/resource/js/jquery-1.6.3.min.js"%>
    </script>
    <script type="text/javascript">
        <%@include file="/resource/js/Stats.js"%>
    </script>
    <title> Inventory </title>
    <div class="menu-wrap">
        <nav class="menu">
            <ul class="clearfix">
                <li><a href="/">Home </a></li>
                <li class="current-item"><a href="#">Inventory</a></li>
                <li ><a href="/exit">Exit</a></li>
            </ul>
        </nav>
    </div>
</head>
<br>
<body>
<div class="character">
    <div id="Name" style="position: absolute; top:15.5%; left:13%;" >
        ${Player.name}
    </div>
    <div id="Class" style="position: absolute; top:21.5%; left:13%;" >
        ${type}
    </div>
    <div id="Attack" style="position: absolute; top:30%; left:13%;" >
        ${Player.attack}
    </div>
    <div id="Defense" style="position: absolute; top:36%; left:14%;" >
        ${Player.defense}
    </div>
    <div id="Health" style="position: absolute; top:45%; left:13%;" >
        ${Player.health}
    </div>
    <div id="Mana" style="position: absolute; top:51%; left:13%;" >
        ${Player.mana}
    </div>
    <div id="Strength" style="position: absolute; top:68%; left:32%;" >
        ${Player.strength}
    </div>
    <div id="Agility" style="position: absolute; top:75.5%; left:32%;" >
        ${Player.agility}
    </div>
    <div id="Intelligence" style="position: absolute; top:83.5%; left:32%;" >
        ${Player.intelligence}
    </div>
    <div id="Vitality" style="position: absolute; top:92%; left:32%;" >
        ${Player.vitality}
    </div>
    <div id="Point" style="position: absolute; top:68.5%; left:50%;" >
        ${Player.point}
    </div>
    <div id="Arrow" style="position: absolute; top:68%; left:36%;" >
        <input type="button" id="arrowStrength" value="plus">
    </div>

    <div id="Arrow1" style="position: absolute; top:75.5%; left:36%;" >
        <input type="button" id="arrowAgility" value="plus">
    </div>

    <div id="Arrow2" style="position: absolute; top:83.5%; left:36%;" >
        <input type="button" id="arrowIntelligence" value="plus">
    </div>

    <div id="Arrow3" style="position: absolute; top:92%; left:36%;" >
        <input type="button" id="arrowVitality" value="plus">
    </div>




</div>

</body>
</html>
