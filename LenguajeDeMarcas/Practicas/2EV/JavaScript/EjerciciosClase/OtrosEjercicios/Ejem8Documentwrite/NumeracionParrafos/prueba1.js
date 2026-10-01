let todosParrafos="";
document.write("<p><i>párrafo 3</i> en cursiva.</p>");
document.write("<p><i>párrafo 4</i> </p>");
let todo=document.getElementsByTagName('p');
for (let i = 0; i < todo.length; i++) {
    todosParrafos+=todo[i].innerHTML+";";
}
document.write("<p>párrafo 5 </p>");
document.write("Todos los párrafos#"+todosParrafos+"#\n");  //cuidado, no es un párrafo porque no tiene etiqueta <p>   El \n no salta de línea en HTML
let miTxt4 = document.getElementsByTagName('p')[4];
miTxt4.style.color = "red";
miTxt5 = document.getElementsByTagName('p')[5];  
miTxt5.style.color = "green";

let todo2=document.getElementsByTagName('p');
todosParrafos="";
for (let i = 0; i < todo2.length; i++) {
    todosParrafos+=todo2[i].innerHTML+";";
}
document.write("Todos los párrafos v2#"+todosParrafos+"#");
