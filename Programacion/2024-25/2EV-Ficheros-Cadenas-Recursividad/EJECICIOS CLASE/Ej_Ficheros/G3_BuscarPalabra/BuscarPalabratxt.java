import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BuscarPalabratxt {

	// Método para buscar una palabra en un archivo
	public int buscarPalabra(String palabraBuscada, File fichero) throws Exception {
		int cont = 0; // Contador de ocurrencias de la palabra
		if (fichero.exists()) { // Verificar si el archivo existe
			try (BufferedReader testo = new BufferedReader(new FileReader(fichero))) { // Abrir el archivo para lectura
				String linea; // Variable para almacenar cada línea leída
				Pattern patronPalabra = Pattern.compile(palabraBuscada); // Compilar el patrón de la palabra buscada
				while ((linea = testo.readLine()) != null) { // Leer línea por línea
					// Dividir la línea en palabras usando espacios en blanco y puntuación
					String[] palabras = linea.split("\\W+"); // \\W+ es una expresión regular que divide por cualquier carácter no alfanumérico
					for (int i = 0; i < palabras.length; i++) { // Iterar sobre cada palabra
						String palabra = palabras[i]; // Obtener la palabra actual
						Matcher coincidencia = patronPalabra.matcher(palabra); // Crear un matcher para la palabra
						if (coincidencia.matches()) { // Verificar si la palabra coincide con el patrón
							cont++; // Incrementar el contador si hay coincidencia
						}
					}
				}
			} catch (IOException e) {
				System.out.println("Error al leer el fichero"); // Manejo de errores de lectura
			}
		} else {
			throw new Exception("El fichero no existe o no es un fichero válido."); // Lanzar excepción si el archivo no existe
		}
		return cont; // Retornar el número de ocurrencias encontradas
	}

	public static void main(String[] args) {
		try {
			BuscarPalabratxt p = new BuscarPalabratxt(); // Crear una instancia de BuscarPalabratxt
			Scanner scanner = new Scanner(System.in); // Crear un escáner para leer la entrada del usuario
			System.out.print("Ingrese la palabra a buscar: "); // Solicitar la palabra a buscar
			String palabraBuscada = scanner.nextLine(); // Leer la palabra buscada
			System.out.print("Ingrese el nombre del fichero: "); // Solicitar el nombre del archivo
			String archivo = scanner.nextLine(); // Leer el nombre del archivo
			System.out.print("Ingrese el nombre del directorio donde se encuentra: "); // Solicitar el directorio
			String dir = scanner.nextLine(); // Leer el directorio
			File fichero = new File(dir, archivo); // Crear un objeto File con el directorio y el nombre del archivo
			int numeroPalabra = p.buscarPalabra(palabraBuscada, fichero); // Llamar al método buscarPalabra
			System.out.println("La palabra \"" + palabraBuscada + "\" aparece " + numeroPalabra + " veces en el fichero."); // Mostrar el resultado
		} catch (Exception e) {
			System.out.println(e.getMessage()); // Manejo de excepciones
		}
	}
}