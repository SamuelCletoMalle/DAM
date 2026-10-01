
public class Punto {
  private int x, y ;

  public Punto(int x, int y) {
	this.x = x;
	this.y = y;
  }
  Punto(){}
  double calcularDistancia(Punto pto) {
    	double distancia=0;
    	int dy = this.y-pto.y;
    	int dx = this.x-pto.x;	
    	dy=dy*dy;
    	dx=dx*dx;
    	distancia=Math.sqrt(dx+dy);
    	return distancia;
    }

  void mostrarCoordenadas (){
	System.out.println("X:"+x+" Y:"+y);  
  }
public int getX() {
	return x;
}
public void setX(int x) {
	this.x = x;
}
public int getY() {
	return y;
}
public void setY(int y) {
	this.y = y;
}
void aumentarX(int valor) {
  x=x+valor;
}

public double distanciaAlOrigenv1() { //Más rápida, menos mantenible
  return Math.sqrt(this.x * x + y * y);
}
public double distanciaAlOrigenv2() { //Mejor para el mantenimiento.
	  double d=0;
	  Punto origen=new Punto(0,0);
	  d=origen.calcularDistancia(this);
	  return d;
	//  return this.calcularDistancia(new Punto(0,0));
	}
double calcularDistanciaAlOrigenDelMasCercano(Punto p) {
  Punto origen = new Punto(0, 0);

  double distanciaP1 = p.distanciaAlOrigenv2();
  double distanciaP2 = this.distanciaAlOrigenv2();
  return (distanciaP1 < distanciaP2) ? distanciaP1:distanciaP2 ;
}
Punto darElPuntoMasCercano (Punto p) {
	double distp1 = this.distanciaAlOrigenv2();
	double distp2 = p.distanciaAlOrigenv2();
	return (distp1 < distp2) ? this:p ;
}


}
