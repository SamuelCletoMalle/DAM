const lista = document.getElementById("mi-lista");
const input = document.getElementById("mi-input");
const boton = document.getElementById("mi-boton");

boton.addEventListener("click", function() {
  const nuevoItem = document.createElement("li");
  nuevoItem.textContent = input.value;
  lista.appendChild(nuevoItem);
  input.value = "algo";
});