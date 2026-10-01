//public class Circulo {
  // int centro;
   //int radio;
   //public Circulo (int centro, int radio){
       //centro c1 = new centro (7,14);
     //  radio c1 = new radio ()
   //}
   //double calcularArea(double){
       //double pi = 3,1419;
     //  return pi * radio * radio;
   //}

   //double seTocanCirculos(int){

  // }

//}
public class Circulo {
    Punto centro ;

    Double radio;
    public Circulo(Punto centro, Double radio) {
        Punto centroX = this.centro;
        Punto centroY = this.centro;
        Double radio1 = this.radio;
    }

    public double calcularArea() {

        double pi = 3.1416;
        return pi * radio * radio; /
    }

    public boolean seTocan(otro centro);


        int distanciaX = this.centro - otro.centro;


        int distanciaY = this.centro - otro.centro;


        int distanciaCuadrada = distanciaX * distanciaX + distanciaY * distanciaY;


        int sumaRadios = this.radio + otro.radio;

        // Verificar si la distancia entre los centros es menor o igual a la suma de los radios
        return distanciaCuadrada <= sumaRadios * sumaRadios;
    }

   // public static void main(String[] args) {
        // Crear dos círculos
       // Circulo c1 = new Circulo(0, 0, 5); // Círculo con centro en (0,0) y radio 5
       // Circulo c2 = new Circulo(8, 0, 3); // Círculo con centro en (8,0) y radio 3

        // Calcular y mostrar el área de cada círculo
       // System.out.println("Área del círculo 1: " + c1.calcularArea());
      //  System.out.println("Área del círculo 2: " + c2.calcularArea());

        // Verificar si los dos círculos se tocan
       // if (c1.seTocan(c2)) {
         //  System.out.println("Los círculos se tocan.");
       // } else {
       //     System.out.println("Los círculos NO se tocan.");
        }
    }
}
