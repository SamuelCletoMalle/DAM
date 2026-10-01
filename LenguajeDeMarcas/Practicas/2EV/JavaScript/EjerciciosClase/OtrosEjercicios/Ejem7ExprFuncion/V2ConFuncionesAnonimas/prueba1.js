function pregunta(pregunta, afirmativa, negativa) {
  if (confirm(pregunta)) afirmativa()
  else negativa();
}

// uso: las funciones son pasadas como argumentos de pregunta
pregunta("¿Eres mayor de edad?", 
  function siMayorEdad() { alert( "Mayor de edad." );  }, 
  function noMayorEdad() { alert( "Menor de edad." ); }
);