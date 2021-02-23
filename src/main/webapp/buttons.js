function viewNavigationCommands(){
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


	var myElement=document.getElementById("SellCommand");
	toggle(myElement);
	myElement=document.getElementById("BuyCommand");
	toggle(myElement);
	myElement=document.getElementById("ListCommand");
	toggle(myElement);
	myElement=document.getElementById("FinishTrade");
	toggle(myElement);
}
function chBox(){
	viewTradeCommands();
	var chBox=document.getElementById("chBox");
	chBox.checked="checked";

}