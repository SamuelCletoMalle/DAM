document.write("<i>AAAxAsAx</i> en cursiva.<br>");
document.body.style.background = "blue";
// getElementById devuelve un elemento
let parrafo = document.getElementById('idtexto2');
parrafo.innerHTML = "Texto cambiado en el js para idtexto2";
parrafo.style.fontSize = "30px";
parrafo.style.color = "red";
// getElementByClassName devuelve un array
let zonaTexto=document.getElementsByClassName('clasetexto');
zonaTexto[0].style.color = "green";
zonaTexto[0].innerHTML = "Texto cambiado en el js para clasetexto";

//zonaTexto[1]  no existe porque, el script está colocado, en el html, 
// antes de que se defina 
document.write("<b>en negrita</b>");