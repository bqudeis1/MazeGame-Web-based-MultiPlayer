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
<audio controls autoplay hidden="hidden" loop="loop">
    <source src="media/gameplay theme.ogg" type="audio/ogg">
    <source src="media/gameplay theme.mp3" type="audio/mpeg">
    Your browser does not support the audio element.
</audio>
<h1><%= "Hello World!" %>
</h1>
<br/>
<h5>Console</h5>
<div title="Console" class="console-text">
    <textarea class="textarea" id="console2" name="console2" rows="6" readonly  >
    </textarea>
    <textarea class="textarea" id="console" name="console" rows="6"  >
    Player-><%=player.toString()+".\n"+"Player->"%>
</textarea>
</div>
</body>
<script src="jquery-3.5.1.min.js"></script>
<script src="try.js"></script>
</html>