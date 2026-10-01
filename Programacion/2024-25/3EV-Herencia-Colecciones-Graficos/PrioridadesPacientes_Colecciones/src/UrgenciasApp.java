import java.util.Scanner;

public class UrgenciasApp {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            System.out.print("Introduce el número de niveles de gravedad (1 = más grave): ");
            int niveles = sc.nextInt();
            sc.nextLine();

            ColaPrioridad<Paciente> colaUrgencias = new ColaPrioridad<>();

            boolean salir = false;
            while (!salir) {
                System.out.println("\nMenú:");
                System.out.println("1 - Ingreso");
                System.out.println("2 - Atención");
                System.out.println("0 - Salir");
                System.out.print("Opción: ");
                int opcion = sc.nextInt();
                sc.nextLine(); // limpia buffer

                switch (opcion) {
                    case 1:
                        System.out.print("Nombre del paciente: ");
                        String nombre = sc.nextLine();
                        System.out.print("Gravedad (1 a " + niveles + "): ");
                        int gravedad = sc.nextInt();
                        sc.nextLine();
                        if (gravedad < 1 || gravedad > niveles) {
                            System.out.println("⚠️ Gravedad inválida.");
                        } else {
                            colaUrgencias.ingresar(new Paciente(nombre, gravedad));
                            System.out.println("✅ Paciente ingresado.");
                        }
                        break;
                    case 2:
                        if (!colaUrgencias.estaVacia()) {
                            Paciente atendido = colaUrgencias.atender();
                            System.out.println("👨‍⚕️ Se atiende a: " + atendido);
                        } else {
                            System.out.println("🚨 No hay pacientes en espera.");
                        }
                        break;
                    case 0:
                        salir = true;
                        break;
                    default:
                        System.out.println("❌ Opción no válida.");
                }
            }

            System.out.println("🏥 Fin del programa.");
        }
    }


