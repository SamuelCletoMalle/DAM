import java.io.IOException;

/**
 * Clase que gestiona la definición y verificación de una clave.
 *
 * @author José Manuel Pérez Lobato
 */
public class Clave {
	String clave; // Variable para almacenar la clave

	// Método para definir la clave
	void definirClave() throws IOException {
		Teclado t = new Teclado(); // Instancia de la clase Teclado para leer entradas del usuario
		int cDigitos = 0, cMay = 0; // Contadores para dígitos y mayúsculas
		boolean correcta = false; // Variable para verificar si la clave es correcta

		do {
			// Solicitar al usuario que ingrese la clave
			do {
				System.out.println("Dar Clave (10 caracteres incluyendo al menos un dígito y una mayúscula)");
				clave = t.leerString(); // Leer la clave ingresada
			} while (clave.length() != 10); // Repetir si la longitud de la clave no es 10

			// Contar dígitos y mayúsculas en la clave
			for (int i = 0; i < clave.length(); i++) {
				if (clave.charAt(i) >= '0' && clave.charAt(i) <= '9') // Verificar si es un dígito
					cDigitos++;
				if (clave.charAt(i) >= 'A' && clave.charAt(i) <= 'Z') // Verificar si es una mayúscula
					cMay++;
			}

			// Verificar si la clave contiene al menos un dígito y una mayúscula
			if (cDigitos >= 1 && cMay >= 1)
				correcta = true; // La clave es correcta
			cDigitos = 0; // Reiniciar contadores
			cMay = 0;
		} while (!correcta); // Repetir hasta que la clave sea correcta
	}

	// Método para pedir la clave al usuario
	boolean pedirClave() throws IOException {
		Teclado t = new Teclado(); // Instancia de la clase Teclado para leer entradas del usuario
		char patron[] = {'*', '*', '*', '*', '*', '*', '*', '*', '*', '*'}; // Patrón de la clave
		String respuesta; // Variable para almacenar la respuesta del usuario
		int c = 4, intentos = 3, pos; // Contador de caracteres a adivinar, intentos restantes y posición aleatoria
		boolean correcta = true; // Variable para verificar si la respuesta es correcta

		// Seleccionar aleatoriamente 4 posiciones en el patrón para ser adivinadas
		while (c > 0) {
			pos = (int) (Math.random() * 10); // Generar una posición aleatoria
			if (patron[pos] == '*') { // Si la posición está disponible
				patron[pos] = '-'; // Marcar la posición como adivinada
				c--; // Decrementar el contador
			}
		}

		// Mostrar al usuario las posiciones que debe adivinar
		System.out.println("Introduzca los 4 caracteres de la clave de las posiciones con - :" + new String(patron));
		do {
			correcta = true; // Reiniciar la variable de corrección
			c = 0; // Reiniciar el contador de caracteres correctos
			System.out.println("Tienes " + intentos + " intentos"); // Mostrar intentos restantes
			respuesta = t.leerString(); // Leer la respuesta del usuario

			// Verificar si la respuesta tiene 4 caracteres
			if (respuesta.length() == 4)
				for (int i = 0; correcta && i < patron.length; i++)
					if (patron[i] == '-') // Si la posición es adivinada
						if (respuesta.charAt(c) == clave.charAt(i)) // Verificar si el carácter es correcto
							c++; // Incrementar el contador de caracteres correctos
						else
							correcta = false; // La respuesta es incorrecta
			intentos--; // Decrementar los intentos restantes
		} while (!correcta && intentos > 0); // Repetir hasta que la respuesta sea correcta o se acaben los intentos

		// Retornar si la respuesta es correcta
		return correcta;
	}

	// Método principal para ejecutar la clase
	public static void main(String arg[]) throws IOException {
		Clave c = new Clave(); // Crear una instancia de Clave
		c.definirClave(); // Definir la clave
		System.out.println("Clave Correcta:" + c.clave); // Mostrar la clave correcta
		System.out.println(c.pedirClave()); // Pedir la clave y mostrar si es correcta
	}
}