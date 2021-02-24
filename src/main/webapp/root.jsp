<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<%@page import="player.Player" %>
<%
    Player player=(Player) request.getAttribute("player");
%>
<html>
<head>
    <link rel="stylesheet" href="rootStyle.css">
    <link rel="stylesheet" href="checkBoxstyle.css">
    <title>Maze Game Online</title>
</head>
<body id="particles-js">
<script type="text/javascript"></script>
<audio controls autoplay hidden="hidden" loop="loop">
    <source src="media/gameplay theme.ogg" type="audio/ogg">
    <source src="media/gameplay theme.mp3" type="audio/mpeg">
    Your browser does not support the audio element.
</audio>
<h1><%= "World Navigation Game!" %>
</h1>
<br/>
<div>
    <form class="">
        <input type="button" class="headButton BN" onclick="viewNavigationCommands();" value="Navigation commands" id="Navigation commands">
        <input type="button" class="nav" title="TurnLeftCommand" value="turnLeft" id="TurnLeftCommand" hidden >
        <input type="button" class="nav" value="turnRight" id="TurnRightCommand" hidden >
        <input type="button" class="nav" value="forward" id="ForwardCommand" hidden >
        <input type="button" class="nav" value="backward" id="BackwardCommand" hidden >
        <input type="button" class="nav" value="playerStatus" id="PlayerStatusCommand" hidden >
    </form>
    <form class="tradeForm" id="chBox">
	<span class="switch" >
	<span class="switch-border1">
		<span class="switch-border2">
			<input id="switch1" type="checkbox" checked onclick="viewTradeCommands();" />
			<label for="switch1"></label>
			<span class="switch-top"></span>
			<span class="switch-shadow"></span>
			<span class="switch-handle"></span>
			<span class="switch-handle-left"></span>
			<span class="switch-handle-right"></span>
			<span class="switch-handle-top"></span>
			<span class="switch-handle-bottom"></span>
			<span class="switch-handle-base"></span>
			<span class="switch-led switch-led-green">
				<span class="switch-led-border">
					<span class="switch-led-light">
						<span class="switch-led-glow"></span>
					</span>
				</span>
			</span>
			<span class="switch-led switch-led-red">
				<span class="switch-led-border">
					<span class="switch-led-light">
						<span class="switch-led-glow"></span>
					</span>
				</span>
			</span>
		</span>
	</span>
</span>
        <input type="button" class="trading" title="SellCommand" value="sell" id="SellCommand" hidden >
        <input type="button" class="trading" title="BuyCommand" value="buy" id="BuyCommand" hidden >
        <input type="button" class="trading" title="ListCommand" value="list" id="ListCommand" hidden >
        <input type="button" class="trading" onclick="viewTradeCommands();" title="FinishTrade" value="FinishTrade" id="FinishTrade" hidden >
    </form>
    <form class="formPlayerPos">
        <input type="label" class="headButton playerCommands"  value="player commands" id="player commands" disabled="disabled">
        <br/>
        <input type="button" class="BP" title="LookCommand" value="look" id="LookCommand" hidden >
        <input type="button" class="BP" title="OpenCommand" value="open" id="OpenCommand" hidden >
        <input type="button" class="BP" title="CloseCommand" value="close" id="CloseCommand" hidden >
        <input type="button" class="BP" title="CheckCommand" value="check" id="CheckCommand" hidden >
        <input type="button" class="BP" title="HelpCommand" value="help" id="HelpCommand" hidden >
        <input type="button" class="BP" title="SwitchLightCommand" value="switchLight" id="SwitchLightCommand" hidden >
        <input type="button" class="BP" title="UseFlashLightCommand" value="useFlashLight" id="UseFlashLightCommand" hidden >
        <input type="button" class="BP" title="UseKeyCommand" value="useKey" id="UseKeyCommand" hidden >
    </form>
</div>
<div title="Console" class="console-text">
    <textarea class="textarea" id="console" name="console"  placeholder="console output"  >
    Player-><%=player.toString()+".\n"+"Player->"%>
</textarea>
</div>
<!-- try making textarea a console -->

<!-- end of the console test -->

</body>
<script src="jquery-3.5.1.min.js"></script>
<script type="text/javascript" src="buttons.js"></script>
<script src="try.js"></script>
</html>