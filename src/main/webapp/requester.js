$(function () {
    $("#console").on('keypress',function (e) {
        const playerWord="Player->";
        const code = (e.keyCode ? e.keyCode : e.which);
        if (code === 13) {
            const textAreaContent = $('#console').val();
            const messageToServer=textAreaContent.substr(textAreaContent.lastIndexOf(playerWord)+playerWord.length).trim();
            $.post("/WNA_MazeGame_Online_war_exploded/CommandExecutorServlet",
                {
                    command: messageToServer,
                },
                function(data, status){
                    $('#console').val(textAreaContent+data+"\n");
                    alert("Data: " + data + "\nStatus: " + status);
                });

            alert('You pressed enter!');
            return true;
        }
    });
});

$(document).ready(alert('You pressed enter!'));