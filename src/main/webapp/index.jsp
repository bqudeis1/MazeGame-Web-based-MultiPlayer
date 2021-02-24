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
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
    <link rel="stylesheet" href="index.css">
    <title>Title</title>
</head>

<body>
<div class="container">
    <audio controls autoplay hidden="hidden">
        <source src="media/gameTheme.ogg" type="audio/ogg">
        <source src="media/gameTheme.mp3" type="audio/mpeg">
        Your browser does not support the audio element.
    </audio>
    <h1 class="pageHeader">Root page</h1>
    <%--align="center"--%>
    <div class="row">
        <div class="col-sm" style="margin: 200px 0 0 25%; max-width: 50%">


            <form method="post" action="register">


                <input class="" type="text" placeholder="Enter your name here" name="name" id="name" style="position: sticky" value="foo">

                <br>
                <input type="radio" onclick="hide();" id="CreateGame" name="joinGameRequest" value="createGame">
                <label for="CreateGame" class="form-check-label">Create Game</label>
                <br>
                <input type="radio" onclick="hide();" id="FindGame" name="joinGameRequest" value="findGame" checked>
                <label for="FindGame" class="form-check-label">Find Game</label>
                <br>
                <input type="radio" id="EnterCode" name="joinGameRequest" value="enterCode" onchange="myFunction()">
                <label for="EnterCode" class="form-check-label">Enter Code</label>
                <br>
                <div id="GameCode" style="display: none">
                    <input type="text" name="gameCode"> <br>
                </div>
                <button type="submit" value="Join game" onclick="validateForm()">Join game</button>
            </form>
        </div>
    </div>
</div>


</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0"
        crossorigin="anonymous"></script>

<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.6.0/dist/umd/popper.min.js"
        integrity="sha384-KsvD1yqQ1/1+IA7gi3P0tyJcT3vR+NdBTt13hSJ2lnve8agRGXTTyNaBYmCR/Nwi"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.min.js"
        integrity="sha384-nsg8ua9HAw1y0W1btsyWgBklPnCUAFLuTMS2G72MMONqmOymq585AcH49TLBQObG"
        crossorigin="anonymous"></script>

<script src="index.js"></script>
</html>
