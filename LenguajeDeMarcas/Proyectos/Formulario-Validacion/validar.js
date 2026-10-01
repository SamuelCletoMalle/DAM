const LETRAS_DNI = "TRWAGMYFPDXBNJZSQVHLCKE";

function dniValido(dni) {
    if (!/^[0-9]{8}[A-Za-z]$/.test(dni)) return false;
    const numero = parseInt(dni.slice(0, 8), 10);
    return LETRAS_DNI[numero % 23] === dni[8].toUpperCase();
}

const reglas = {
    usuario: v => /^[a-zA-Z0-9_]{4,15}$/.test(v) ? "" : "Entre 4 y 15 caracteres: letras, números o _",
    email: v => /^[^@ ]+@[^@ ]+\.[a-z]{2,}$/i.test(v) ? "" : "El correo no tiene un formato válido",
    dni: v => dniValido(v) ? "" : "El DNI no es válido (comprueba la letra)",
    clave: v => /^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9]).{8,}$/.test(v) ? "" : "Mínimo 8 caracteres con mayúscula, minúscula y número"
};

function validar(campo) {
    const mensaje = reglas[campo](document.getElementById(campo).value.trim());
    document.getElementById("e-" + campo).textContent = mensaje;
    return mensaje === "";
}

Object.keys(reglas).forEach(campo => {
    document.getElementById(campo).addEventListener("blur", () => validar(campo));
});

document.getElementById("registro").addEventListener("submit", e => {
    e.preventDefault();
    const todoBien = Object.keys(reglas).map(validar).every(ok => ok);
    document.getElementById("ok").textContent = todoBien ? "¡Registro correcto!" : "";
});
