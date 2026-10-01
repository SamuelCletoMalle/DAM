const pantalla = document.getElementById("pantalla");
let actual = "0";
let anterior = null;
let operador = null;
let nuevoNumero = true;

function mostrar() {
    pantalla.textContent = actual;
}

function calcular(a, b, op) {
    switch (op) {
        case "+": return a + b;
        case "-": return a - b;
        case "*": return a * b;
        case "/": return b === 0 ? "Error" : a / b;
        case "%": return a % b;
    }
}

function pulsarNumero(n) {
    if (nuevoNumero) {
        actual = n === "." ? "0." : n;
        nuevoNumero = false;
    } else if (n !== "." || !actual.includes(".")) {
        actual += n;
    }
    mostrar();
}

function pulsarOperador(op) {
    if (operador && !nuevoNumero) {
        resolver();
    }
    anterior = parseFloat(actual);
    operador = op;
    nuevoNumero = true;
}

function resolver() {
    if (operador === null) return;
    const resultado = calcular(anterior, parseFloat(actual), operador);
    actual = resultado === "Error" ? resultado : String(Math.round(resultado * 1e9) / 1e9);
    operador = null;
    nuevoNumero = true;
    mostrar();
}

function limpiar() {
    actual = "0";
    anterior = null;
    operador = null;
    nuevoNumero = true;
    mostrar();
}

document.querySelectorAll("button").forEach(boton => {
    boton.addEventListener("click", () => {
        if (boton.dataset.num !== undefined) pulsarNumero(boton.dataset.num);
        else if (boton.dataset.op) pulsarOperador(boton.dataset.op);
        else if (boton.dataset.accion === "igual") resolver();
        else if (boton.dataset.accion === "limpiar") limpiar();
        else if (boton.dataset.accion === "borrar") {
            actual = actual.length > 1 ? actual.slice(0, -1) : "0";
            mostrar();
        }
    });
});
