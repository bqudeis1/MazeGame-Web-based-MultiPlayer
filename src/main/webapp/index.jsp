<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<%@page import="player.Player" %>
<%
    Player player=(Player) request.getAttribute("player");
%>
<html>
<head>
    <link rel="stylesheet" href="IndexStyles.css">
    <title>JSP - Hello World</title>
    <link rel="shortcut icon" href="#">
</head>
<body id="particles-js">
<script type="text/javascript" src="console.js"></script>
<audio controls autoplay hidden="hidden" loop="loop">
    <source src="media/gameplay theme.ogg" type="audio/ogg">
    <source src="media/gameplay theme.mp3" type="audio/mpeg">
    Your browser does not support the audio element.
</audio>
<h1><%= "Hello World!" %>
</h1>
<br/>
<div>
    <form>

        <input type="button" onclick="viewPlayerCommands();" value="Navigation commands" id="Navigation commands">
        <input type="button" onclick="viewTradeCommands();" value="trade commands" id="Trade">
        <br>
        <input type="button" title="TurnLeftCommand" value="turn left" id="TurnLeftCommand" hidden >
        <input type="button" title="TurnRightCommand" value="turn right" id="TurnRightCommand" hidden >
        <input type="button" title="ForwardCommand" value="move forward" id="ForwardCommand" hidden >
        <input type="button" title="BackwardCommand" value="move backward" id="BackwardCommand" hidden >
        <input type="button" title="PlayerStatusCommand" value="player status" id="PlayerStatusCommand" hidden >
        <input type="button" title="LookCommand" value="look" id="LookCommand" hidden >
        <input type="button" title="OpenCommand" value="open" id="OpenCommand" hidden >
        <input type="button" title="CloseCommand" value="close" id="CloseCommand" hidden >
        <input type="button" title="CheckCommand" value="check" id="CheckCommand" hidden >
        <input type="button" title="HelpCommand" value="help" id="HelpCommand" hidden >
        <input type="button" title="SwitchLightCommand" value="switchLight" id="SwitchLightCommand" hidden >
        <input type="button" title="UseFlashLightCommand" value="use flash Light" id="UseFlashLightCommand" hidden >
        <input type="button" title="UseKeyCommand" value="use key" id="UseKeyCommand" hidden >
        <input type="button" title="SellCommand" value="sell items" id="SellCommand" hidden >
        <input type="button" title="BuyCommand" value="buy items" id="BuyCommand" hidden >
        <input type="button" title="ListCommand" value="list seller items" id="ListCommand" hidden >
        <input type="button" onclick="viewTradeCommands();" title="FinishTrade" value="quit trade" id="FinishTrade" hidden >
    </form>
</div>
<h5>Console</h5>
<div title="Console" class="console-text">
    <textarea class="textarea" id="console" name="console" rows="6"  >
    Player-><%=player.toString()+".\n"+"Player->"%>
</textarea>
</div>
<!-- try making textarea a console -->

<!-- end of the console test -->
<input type="button" value="Show Server Time"
       onclick='ajaxAsyncRequest("/WNA_MazeGame_Online_war_exploded/hello-servlet")'/>

<a href="hello-servlet">Hello Servlet</a>
</body>
<script src="javaS.js"></script>
<script src="jquery-3.5.1.min.js"></script>
<script src="requester.js"></script>
<script type="text/javascript" src="buttons.js"></script>
<script src="try.js"></script>
</html>