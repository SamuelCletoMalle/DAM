public class Asteriscos {


    public void dibujoCuadrado(int N) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }


    public void dibujoTriangulo(int N) {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        Asteriscos obj = new  Asteriscos();

        int N = 8;

        System.out.println("Cuadrado:");
        obj.dibujoCuadrado(N);

        System.out.println("\nTriángulo:");
        obj.dibujoTriangulo(N);
    }
}
