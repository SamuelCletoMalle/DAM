//ejecutar con node nomfich.js en la pestaña Terminal de VSC
const readline = require('readline');

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout
});

let  
 suma = 0;
let contador = 1;

function pedirNumero() {
  rl.question(`Ingrese el número ${contador}: `, (respuesta) => {
    const numero = parseInt(respuesta);
    suma += numero;
    contador++;

    if (contador <= 10) {
      pedirNumero(); // Llamada recursiva
    } else {
      console.log('La suma total es:', suma);
      rl.close();
    }
  });
}

pedirNumero();