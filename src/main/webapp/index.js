function myFunction() {
    let x = document.getElementById("GameCode");
    view(x);

}

function validateForm() {
    var x = document.getElementById("name")
    alert(x)
    if (x === "") {
        alert("Name must be filled out");
        return false;
    }
}
function view(myElement){

    myElement.style.display = "block";

}
function hide(){
    let myElement=document.getElementById("GameCode");
    myElement.style.display = "none";
}