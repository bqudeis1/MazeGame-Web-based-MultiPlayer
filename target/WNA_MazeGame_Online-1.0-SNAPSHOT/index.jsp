<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
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
<div class="console-div">

    <textarea id="console" name="console" rows="4" cols="50">
Player->
</textarea>
</div>
<input type="button" value="Show Server Time"
       onclick='ajaxAsyncRequest("/WNA_MazeGame_Online_war_exploded/hello-servlet")'/>

<a href="hello-servlet">Hello Servlet</a>
</body>
<script src="javaS.js"></script>
</html>