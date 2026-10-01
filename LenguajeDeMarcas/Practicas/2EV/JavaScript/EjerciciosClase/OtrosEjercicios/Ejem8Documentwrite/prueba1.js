document.write("<p><i>AAAxAA</i> en cursiva.</p>");
document.body.style.background = "blue";
let miTxt = document.getElementsByClassName('texto')[0];
document.write("texto:"+miTxt.innerHTML);
miTxt.style.color = "red";
miTxt.style.background = "black";
miTxt.style.fontSize = "30px";
miTxt.innerHTML = "Texto Modificado en js";
