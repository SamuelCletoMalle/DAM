import java.io.IOException;

public class UsoMath {

	public static void main(String[] args) throws IOException {
		Teclado t= new Teclado();
		
		double  raizCuadrada= Math.sqrt(81);
		System.out.println("El cuadrado de 81 es:"+ raizCuadrada);
		
		System.out.println("Dar un número");
		int num=t.leerInt();
		raizCuadrada= Math.sqrt(num);
		System.out.println("El cuadrado de "+num+" es:"+ raizCuadrada);

	}

}
