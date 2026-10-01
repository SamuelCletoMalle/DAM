const titulo = document.getElementsById("titulo");
titulo.textContent="Nuevo Titulo";

const titulo = document.getElementById("parrafo");
            titulo.style.backgroundColor = "green";

const li = document.createElement("li");
        li.textContent = "Elemento 3"; 
        lista.appendChild(li);
 

const button =  document.getElementById("cambiarTexto").addEventListener("click", function(){
        button.textContent = "¡Texto Cambiado!";
})

cretateTextNode ("Algo"); 

//comprobar mejor js, creo que esta todo bien escrito.