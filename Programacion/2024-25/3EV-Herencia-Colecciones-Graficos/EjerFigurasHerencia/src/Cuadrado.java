
public class Cuadrado  extends Figura {
	Punto p1,p2,p3, p4;
	Cuadrado (Punto p1, Punto p2, Punto p3, Punto p4){

		this.p1=p1;
		this.p2=p2;
		this.p3=p3;
		this.p4=p4;
	}
	Cuadrado (Punto p1, Punto p2, Punto p3, Punto p4, int grosor, ColorRGB color){
    super(color, grosor);
		this.p1=p1;
		this.p2=p2;
		this.p3=p3;
		this.p4=p4;
	}
	public Cuadrado(int grosor, Punto esquina1, Punto esquina2) {
		// TODO Auto-generated constructor stub
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
	public Punto getP4() {
		return p4;
	}
	public void setP4(Punto p4) {
		this.p4 = p4;
	}
	@Override
	public String toString() {
        return "Cuadrado - puntos: " + p1 + ", " + p2 + ", "+ p3 +", "+ p4 +", Grosor: " + grosor;
    }
	@Override
	public double calcularPerimetro() {
        double lados = p1.calcularDistancia(p2);
        lados += p1.calcularDistancia(p4);
        lados += p3.calcularDistancia(p4);
        return lados;
    }
}
