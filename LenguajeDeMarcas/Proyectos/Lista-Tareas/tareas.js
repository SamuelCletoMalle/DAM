const formulario = document.getElementById("formulario");
const lista = document.getElementById("lista");
const contador = document.getElementById("contador");
let tareas = JSON.parse(localStorage.getItem("tareas") || "[]");

function guardar() {
    localStorage.setItem("tareas", JSON.stringify(tareas));
}

function pintar() {
    lista.innerHTML = "";
    tareas.forEach((t, i) => {
        const li = document.createElement("li");
        li.className = t.prioridad + (t.hecha ? " hecha" : "");

        const check = document.createElement("input");
        check.type = "checkbox";
        check.checked = t.hecha;
        check.addEventListener("change", () => {
            t.hecha = check.checked;
            guardar();
            pintar();
        });

        const texto = document.createElement("span");
        texto.textContent = t.texto;

        const borrar = document.createElement("button");
        borrar.textContent = "✕";
        borrar.addEventListener("click", () => {
            tareas.splice(i, 1);
            guardar();
            pintar();
        });

        li.append(check, texto, borrar);
        lista.appendChild(li);
    });
    const pendientes = tareas.filter(t => !t.hecha).length;
    contador.textContent = pendientes + " tarea(s) pendiente(s) de " + tareas.length;
}

formulario.addEventListener("submit", e => {
    e.preventDefault();
    const texto = document.getElementById("texto");
    tareas.push({
        texto: texto.value.trim(),
        prioridad: document.getElementById("prioridad").value,
        hecha: false
    });
    texto.value = "";
    guardar();
    pintar();
});

pintar();
