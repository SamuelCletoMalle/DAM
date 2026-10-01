function pregunta(pregunta, afirmativa, negativa) {
  if (confirm(pregunta)) afirmativa()
  else negativa();
}

function siMayorEdad() {
  alert( "Mayor de edad." );
}

function noMayorEdad() {
  alert( "Menor de edad." );
}
function saludar() {
  alert( "Hola" );
}

// uso: las funciones son pasadas como argumentos de pregunta
pregunta("¿Eres mayor de edad?", siMayorEdad, noMayorEdad);
pregunta("¿Eres mayor de edad?", noMayorEdad, saludar);