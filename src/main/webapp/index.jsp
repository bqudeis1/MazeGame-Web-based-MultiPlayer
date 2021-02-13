<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<%@page import="player.Player" %>
<%
    Player player=(Player) request.getAttribute("player");
%>
<html>
<head>
    <link rel="stylesheet" href="style.css">
    <title>JSP - Hello World</title>
    <link rel="shortcut icon" href="#">
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<h5>Console</h5>
<div class="console-div" title="Console">
    <textarea id="console" name="console" rows="4" cols="182">
Player-><%=player.toString()+".\n"+"Player->"%>
</textarea>
</div>
<input type="button" value="Show Server Time"
       onclick='ajaxAsyncRequest("/WNA_MazeGame_Online_war_exploded/hello-servlet")'/>

<a href="hello-servlet">Hello Servlet</a>
</body>
<script src="javaS.js"></script>
<script src="jquery-3.5.1.min.js"></script>
<script src="requester.js"></script>
</html>