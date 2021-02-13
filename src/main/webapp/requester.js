

$(function () {
    $("#console").on('keypress',function (e) {
        const playerWord="Player->";
        const code = (e.keyCode ? e.keyCode : e.which);
        if (code === 13) {
            const textAreaContent = $('#console').val();
            const messageToServer=textAreaContent.substr(textAreaContent.lastIndexOf(playerWord)+playerWord.length).trim().toLowerCase();
            $.post("/WNA_MazeGame_Online_war_exploded/CommandExecutorServlet",
                {
                    command: messageToServer,
                },
                function(data, status){
                    $('#console').val(textAreaContent+data);
                    alert("Data: " + data + "\nStatus: " + status);
                });

            alert('You pressed enter!');
            return true;
        }
    });
});

$("button").click(function(){

});

function printDiv()
{

    var divToPrint=document.getElementById('DivIdToPrint');

    var newWin=window.open('','Print-Window');

    newWin.document.open();

    newWin.document.write('<html><body onload="window.print()">'+divToPrint.innerHTML+'</body></html>');

    newWin.document.close();

    setTimeout(function(){newWin.close();},10);

}