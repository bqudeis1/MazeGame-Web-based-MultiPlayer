function viewPlayerCommands(){
    var myElement=document.getElementById("TurnLeftCommand");
    toggle(myElement);
	myElement=document.getElementById("TurnRightCommand");
	toggle(myElement);
	myElement=document.getElementById("ForwardCommand");
	toggle(myElement);
	myElement=document.getElementById("BackwardCommand");
	toggle(myElement);
	myElement=document.getElementById("PlayerStatusCommand");
	toggle(myElement);
	myElement=document.getElementById("LookCommand");
	hide(myElement);
	myElement=document.getElementById("OpenCommand");
	hide(myElement);
	myElement=document.getElementById("CloseCommand");
	hide(myElement);
	myElement=document.getElementById("CheckCommand");
	hide(myElement);
	myElement=document.getElementById("HelpCommand");
	hide(myElement);
	myElement=document.getElementById("SwitchLightCommand");
	hide(myElement);
	myElement=document.getElementById("UseFlashLightCommand");
	hide(myElement);
	myElement=document.getElementById("UseKeyCommand");
	hide(myElement);
	myElement=document.getElementById("SellCommand");
	hide(myElement);
	myElement=document.getElementById("BuyCommand");
	hide(myElement);
	myElement=document.getElementById("ListCommand");
	hide(myElement);
	myElement=document.getElementById("FinishTrade");
	hide(myElement);
}
function toggle(myElement){
	if (myElement.style.display === "none") {
        myElement.style.display = "block";
    } else {
        myElement.style.display = "none";
    }
}
function hide(myElement){
	myElement.style.display = "none";
}
function viewTradeCommands(){
    var myElement=document.getElementById("TurnLeftCommand");
    hide(myElement);
	myElement=document.getElementById("TurnRightCommand");
	hide(myElement);
	myElement=document.getElementById("ForwardCommand");
	hide(myElement);
	myElement=document.getElementById("BackwardCommand");
	hide(myElement);
	myElement=document.getElementById("PlayerStatusCommand");
	hide(myElement);
	myElement=document.getElementById("LookCommand");
	hide(myElement);
	myElement=document.getElementById("OpenCommand");
	hide(myElement);
	myElement=document.getElementById("CloseCommand");
	hide(myElement);
	myElement=document.getElementById("CheckCommand");
	hide(myElement);
	myElement=document.getElementById("HelpCommand");
	hide(myElement);
	myElement=document.getElementById("SwitchLightCommand");
	hide(myElement);
	myElement=document.getElementById("UseFlashLightCommand");
	hide(myElement);
	myElement=document.getElementById("UseKeyCommand");
	hide(myElement);
	myElement=document.getElementById("SellCommand");
	toggle(myElement);
	myElement=document.getElementById("BuyCommand");
	toggle(myElement);
	myElement=document.getElementById("ListCommand");
	toggle(myElement);
	myElement=document.getElementById("FinishTrade");
	toggle(myElement);
}
