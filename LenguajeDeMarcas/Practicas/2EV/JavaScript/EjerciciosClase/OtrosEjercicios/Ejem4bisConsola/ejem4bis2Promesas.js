//ejecutar con node nomfich.js en la pestaña Terminal de Visual Studio Code
//Uso de promesas para que la lectura de teclado espere.
const readline = require('readline');
const util = require('util');
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout
});
const question = util.promisify(rl.question).bind(rl);  

//Ahora puesdes usar la función question como si fuera una promesa y esperar a que el usuario introduzca un valor.
async function sumarNumeros() {
  let suma = 0;
  for (let i = 1; i <= 10; i++) {
    const respuesta = await question(`Ingrese el número ${i}: `);
    const numero = parseInt(respuesta);
    suma += numero;
  }
  console.log('La suma total es:', suma);
  rl.close();
}

sumarNumeros();