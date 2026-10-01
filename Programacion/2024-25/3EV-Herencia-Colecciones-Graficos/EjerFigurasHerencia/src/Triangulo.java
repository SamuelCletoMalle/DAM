public class Triangulo extends Figura {
	Punto p1,p2,p3;
	Triangulo (Punto p1, Punto p2, Punto p3){
		this.p1=p1;
		this.p2=p2;
		this.p3=p3;
	}
	Triangulo ( int grosor, Punto p1, Punto p2, Punto p3){
		this.grosor=grosor;
		this.p1=p1;
		this.p2=p2;
		this.p3=p3;
	}
	Triangulo (Punto p1, Punto p2, Punto p3, int grosor, ColorRGB color){
		super (color, grosor);
		this.p1=p1;
		this.p2=p2;
		this.p3=p3;
	}

	public Punto getP1() {
		return p1;
	}
	public void setP1(Punto p1) {
		this.p1 = p1;
	}
	public Punto getP2() {
		return p2;
	}
	public void setP2(Punto p2) {
		this.p2 = p2;
	}
	public Punto getP3() {
		return p3;
	}
	public void setP3(Punto p3) {
		this.p3 = p3;
	}
	@Override
	public String toString() {
        return "Triángulo - Puntos: " + p1 + ", " + p2 + ", " + p3 + ", Grosor: " + grosor;
    }
	@Override
	public double calcularPerimetro() {
        double lado1 = p1.calcularDistancia(p2);
        double lado2 = p2.calcularDistancia(p3);
        double lado3 = p3.calcularDistancia(p1);
        return lado1 + lado2 + lado3;
    }
	
}