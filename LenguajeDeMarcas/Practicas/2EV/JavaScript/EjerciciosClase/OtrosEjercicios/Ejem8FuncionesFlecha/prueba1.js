
n1=Number(prompt ("Número 1", "0"));
n2=Number(prompt ("Número 2", "0")); 
let sum = (a, b) => a + b;
alert("La suma de " + n1 + " y " + n2 + " es " + sum(n1,n2) );
let calcDoble = n1 => n1 * 2;   //solo con  1 param no hay ()
alert("El doble de " + n1 + " es " + calcDoble(n1) );
let saluda = () => alert("¡Hola!"); 