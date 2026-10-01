public class Triangulo {
    Punto p1,p2,p3;

    public Triangulo2(Punto p1, Punto p2, Punto p3) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
    }
    public Triangulo2(int x1,int y1, int x2, int y2, int x3, int y3) {
        p1= new Punto(x1,y1);
        p2= new Punto(x2,y2);
        p3= new Punto(x3,y3);
    }
    double calcularPerimetro(){
        double b = 0;
        b = b + p1.calcularDistancia(p2);
        b = b + p2.calcularDistancia(p3);
        b = b + p3.calcularDistancia(p1);
        return b;
    }
	 if (p1 == p2 && p2 == p3) {
        return true;
    } else {
        return false;
    }
}
