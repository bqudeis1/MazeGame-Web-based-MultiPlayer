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



<h1>Root page</h1>
<embed method="post" action="newGameCreatorServlet">
    <label>First name:</label><br>
    <input type="text" name="fName" ><br>
    <input type="submit" value="Join game">
    <input type="checkbox" name="newGame"  checked="checked">
    <label>create new game</label>
<audio controls autoplay hidden="hidden">
    <source src="media/gameTheme.ogg" type="audio/ogg" >
    <source src="media/gameTheme.mp3" type="audio/mpeg" >
    Your browser does not support the audio element.
</audio>
</form>
</body>
</html>
