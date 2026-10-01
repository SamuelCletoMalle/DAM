public class Punto {
	double x ;
	double y;
	Punto(double d, double e){
		x=d;
		y=e;
	}
	
	void mostrarCoordenadas () {
		System.out.println("X:"+x+" Y:"+y);
	}
	void setX(int valor) {
		x=valor;
	}
	void setY(int valor) {
		y=valor;
	}
	double getX () {
		return x;
	}
	double getY () {
		return y;
	}
	double calcularDistancia(Punto pto) {
		double distancia=0;
		double dy=this.y-pto.y;
		double dx=this.x-pto.x;
		dy=dy*dy;
		dx=dx*dx;
		distancia=Math.sqrt(dx+dy);
		return distancia;
	}
	void aumentarX(int valor) {
		x=x+valor;
	}
	double distancia0x0y(){
		Punto pO = new Punto(0,0);
		double d=this.calcularDistancia(pO);
		return d;
	}
	double distanciaPMasCercano(Punto A) {
		double d1=A.distancia0x0y();
		double d2=this.distancia0x0y();
		double menor= (d1<d2)? d1:d2;
		return menor;
	}
	Punto puntoMasCercano(Punto A) {
		double dB = this.distancia0x0y();
		double dA = A.distancia0x0y();
		return ((dB>dA)? A:this);
		}
	@Override
	public String toString() {
		return "punto [x=" + x + ", y=" + y + "]";
	}
		
		
		
	}