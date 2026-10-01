
public abstract class Figura implements ItfFigura {
	ColorRGB color;
	int grosor;

  public Figura(ColorRGB color, int grosor) {
    this.color = color;
    this.grosor = grosor;
  }
  public Figura(){}

//  abstract public double calcularPerimetro() ;

	
    public void setGrosor(int grosor) {
        this.grosor = grosor;
    }

    public int getGrosor() {
        return grosor;
    }
    public void incrementarGrosor(int aumento){
      grosor+=aumento;
    }
}
