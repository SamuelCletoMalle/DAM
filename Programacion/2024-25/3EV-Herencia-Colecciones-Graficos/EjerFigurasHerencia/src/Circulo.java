public class Circulo extends Figura {
	Punto centro;
	double radio;
	// puedes poner el PI tambien con: final static double PI = 3.1416;
	Circulo(Punto centro, double radio, int grosor, ColorRGB color){
		super(color, grosor);
		this.centro=centro;
		this.radio=radio;
	}
	Circulo(Punto centro, double radio){
		this.centro=centro;
		this.radio=radio;
	}

	double calcularArea() {
		double a = Math.PI*(radio*radio);
		return a;
	}
	@Override
	public double calcularPerimetro() {
        return 2 * Math.PI * radio;
    }
	@Override
	public String toString() {
        return "Círculo - Centro: " + centro + ", Radio: " + radio + ", Grosor: " + grosor;
    }
	
}