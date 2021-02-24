function sender(e) {

    const playerWord = "Player->";
    debugger;
    const code = (e.keyCode ? e.keyCode : e.which);
    if (code === 13) {


        const messageToServer = textAreaContent.substr(textAreaContent.lastIndexOf(playerWord) + playerWord.length).trim();
        $.post("/WNA_MazeGame_Online_war_exploded/CommandExecutorServlet",
            {
                command: messageToServer,
            },
            function (data, status) {
                $('#console').val($('#console').val() + "\n" + data + "\n");
                alert("Dataa: " + data + "\nStatus: " + status);
            });
        return true;
    }


}

function sender_click(val) {
    {
        messageToServer = val
        $.post("/WNA_MazeGame_Online_war_exploded/CommandExecutorServlet",
            {
                command: messageToServer,
            },
            function (data, status) {
                $('#console').val($('#console').val() + "\n" + data + "\n");
                alert("Dataa: " + data + "\nStatus: " + status);
            });
        return true;
    }


}

$("#console").on('keypress', function (e) {
    sender(e)
})
$("#LookCommand, #OpenCommand, #CloseCommand, #CheckCommand, #HelpCommand, #SwitchLightCommand, #UseFlashLightCommand, #UseKeyCommand ,#TurnLeftCommand, #ForwardCommand ,#BackwardCommand,#PlayerStatusCommand, #ListCommand,#FinishTrade").on('click', function (e) {
    sender_click($(this).val())
})

let timeInterval = 300;
var gameStart = setInterval(gameStart, timeInterval);
var gameFinished;


function gameStart() {
    $.ajax({
        url: "/WNA_MazeGame_Online_war_exploded/Servleto",
        contentType: "application/json; charset=utf-8",
        type: "GET",
        dataType: "json", //Specify response type from server
        success: function (result) {
            if (result.waitingTime === 0) {
                $('#console').val("\n Your game start now..." + "\n");
                clearInterval(gameStart);
                gameFinished = setInterval(gameFinished, 3000);
            } else {
                $('#console').val("\nYour game will start after " + result.waitingTime + "s\n");
            }
        },
    });
}


function gameFinished() {
    $.ajax({
        url: "/WNA_MazeGame_Online_war_exploded/Servleto",//remember to edit this when u deploy on ASW
        contentType: "application/json; charset=utf-8",
        type: "GET",
        dataType: "json", //Specify response type from server
        success: function (result) {

            if (result.isGameFinished === true) {
                $('#console').val("\n Game Over .");
                clearInterval(gameFinished);
            }
        },
    });
}

//
// $("#LookCommand").click((e)=>{
//     alert($(this).val())
//
//
// })

