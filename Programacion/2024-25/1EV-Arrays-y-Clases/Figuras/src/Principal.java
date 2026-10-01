
public class Principal {

  public static void main(String[] args) {
	Punto p1= new Punto(7,14);
	Punto p2=new Punto(1,2);
	
	double d=p1.calcularDistancia(p2);
	System.out.println("La distancia es:"+d);
	
	Punto p3= new Punto(5,6);
	d=p3.calcularDistancia(p1);
	System.out.println("La distancia es:"+d);
	
	p3.mostrarCoordenadas();
	p3.aumentarX(3);
	p3.mostrarCoordenadas();
	double distanciaOrigen=p3.distanciaAlOrigenv2();
	System.out.println("distancia p3 al origen:"+distanciaOrigen);
	
	double distCorta = p1.calcularDistanciaAlOrigenDelMasCercano(p2);
	System.out.println("De los 2 ptos, el más cercano tiene una distancia de:"+distCorta);
	
	Punto ptoMasCercano= p1.darElPuntoMasCercano(p2);
	System.out.print("Entre p1 y p2 el más cercano es el de coordenadas:");
	ptoMasCercano.mostrarCoordenadas();
	
	Punto pa= new Punto(1,3);
	Punto pb= new Punto(3,3);
	Punto pc= new Punto(6,1);
	Triangulo t1= new Triangulo(p1,p2,p3);

	
	
  }  
}
