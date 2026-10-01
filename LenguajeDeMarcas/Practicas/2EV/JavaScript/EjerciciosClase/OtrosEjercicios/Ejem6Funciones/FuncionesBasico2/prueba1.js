
let msgSaludo='Hola '; //variable global
saludar("Juan");  //el 2º param es undefined.
function saludar(persona1, persona2){
  alert(msgSaludo+ persona1+ " y "+ persona2);
}

saludar("Ana", "Luis");

function despedirse(persona1, persona2="y demás"){
  let msgSaludo='Adiós '; //variable local
  alert(msgSaludo+ persona1+ " y "+ persona2);
}
despedirse("Ana");
despedirse("uno", "dos");
function suma(a,b){
  return a+b;
}
let resultado=suma(2,3);
alert("La suma es: "+resultado);