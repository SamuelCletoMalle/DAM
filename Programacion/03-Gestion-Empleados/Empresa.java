import java.util.Scanner;
import java.util.Vector;

public class Empresa {
    Vector<Persona> empleados;
    Empresa () {
        empleados= new Vector<Persona>(30);
    }
    boolean anadir(String nombre, int edad){

        for (Persona p : empleados) {
            if (nombre.equals(p.getNombre())) {
                return false;
            }
        }

        Persona nuevaPersona = new Persona(nombre, edad);
        empleados.add(nuevaPersona);
        return true;
    }


    boolean eliminar(String nombre){
        for (int i = 0; i < empleados.size(); i++) {
            if (nombre.equals(empleados.elementAt(i).getNombre())) {
                empleados.remove(i);
                return true;
            }
        }
        return false;
    }



    void listar(){
   /*     for(int i=0; i<empleados.size(); i++)
            System.out.println(empleados.elementAt(i));*/
        for (Persona miPers: empleados)
            System.out.println(miPers);
    }

    void modificarEdad(String nombre, int edad){
        for (int i = 0; i < empleados.size(); i++){
            if(nombre.equals(empleados.elementAt(i).getNombre())){
                empleados.elementAt(i).setEdad(edad);

            }
        }
    }

    void modificarNombre(String nombre, String nombreSustituto){
        for (int i = 0; i < empleados.size(); i++){
            if(nombre.equals(empleados.elementAt(i).getNombre())){
                empleados.elementAt(i).setNombre(nombreSustituto);

            }
        }
    }

    void ordenarPorEdad() {
        int n = empleados.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (empleados.elementAt(j).getEdad() > empleados.elementAt(j + 1).getEdad()) {
                    Persona temp = empleados.elementAt(j);
                    empleados.setElementAt(empleados.elementAt(j + 1), j);
                    empleados.setElementAt(temp, j + 1);
                }
            }
        }
    }



    void menu(){
        System.out.println("======= MENU =======");
        Scanner sc= new Scanner(System.in);
        int opc=0;
        System.out.println ("1-Añadir empleado");
        System.out.println("2-Eliminar empleado");
        System.out.println("3-Modificar edad");
        System.out.println("4-Modificar Nombre"); //Crear una nueva persona que sustituya a la anterior
        System.out.println("5-Listar empleados");
        System.out.println("6-listar ordenado por edad");
        do  {
            System.out.println("Dar opc ");
            opc= Integer.parseInt(sc.nextLine());
            switch (opc) {
                case 1 -> {
                    System.out.println("Introducir nombre");
                    String nombre = sc.nextLine();
                    System.out.println("Introducir edad");
                    int edad = Integer.parseInt(sc.nextLine());
                    anadir(nombre, edad);
                    break;
                 }

                 case 2 ->{
                     System.out.println("Introduce el nombre del empleado que quieres borrar");
                     String nombre = sc.nextLine();
                     System.out.println("¿Seguro que lo quieres borrar? (Si o No)");
                     String respuesta = sc.nextLine();
                      if(respuesta.equals("Si")){
                          eliminar(nombre);
                      }
                 }

                 case 3 ->{
                    listar();
                    break;
                 }

                 case 4 ->{
                     System.out.println("Introduce el nombre al que deseas modificar edad");
                     String nombre = sc.nextLine();
                     System.out.println("Introducir edad modificada");
                     int edad = Integer.parseInt(sc.nextLine());

                    modificarEdad(nombre, edad);
                 }

                 case 5 ->{
                     System.out.println("Indica el nombre al cual vas a realizar el cambio");
                     String nombre = sc.nextLine();
                     System.out.println("Indica el nombre sustituto");
                     String nombreSustituto = sc.nextLine();

                     modificarNombre(nombre, nombreSustituto);
                 }

                 case 6 -> {
                    ordenarPorEdad();
                 }

            }
        }while (opc !=0);

    }
    public static void main(String[] args) {
        Empresa e= new Empresa();

        e.menu();
        Persona p1=new Persona("Juan", 25);
        Persona p2=new Persona("Pedro", 26);
        if (p1.equals(p2)) System.out.println("Son iguales");
    }
}
