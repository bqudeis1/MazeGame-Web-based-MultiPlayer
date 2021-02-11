<%--
  Created by IntelliJ IDEA.
  User: Eng.Bahaa
  Date: 2/8/2021
  Time: 7:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        body {
            background-image: url('media/Halloween Background 01.png');
            height: 95%;
            background-repeat: no-repeat;
            background-attachment: fixed;
            background-size: cover;
        }
    </style>
</head>

<body>
<audio controls autoplay hidden="hidden">
    <source src="media/gameTheme.ogg" type="audio/ogg">
    <source src="media/gameTheme.mp3" type="audio/mpeg">
    Your browser does not support the audio element.
</audio>
<h1>Root page</h1>

<form method="post" action="newGameCreatorServlet">

    <label>First name:</label><br>
    <input type="text" name="name"><br>
    <br>
    <input type="radio" id="CreateGame" name="joinGameRequest" value="createGame">
    <label for="CreateGame">Create Game</label>

    <input type="radio" id="FindGame" name="joinGameRequest" value="findGame" checked>
    <label for="FindGame">Find Game</label>

    <input type="radio" id="EnterCode" name="joinGameRequest" value="enterCode" onchange="myFunction()">
    <label for="EnterCode">Enter Code</label>
    <br>
    <div id="GameCode" style="display: none">
        <input type="text" name="gameCode"> <br>
    </div>


    <input type="submit" value="Join game">
</form>
</body>
<script src="rootScript.js"></script>
</html>
