
import javax.swing.*;
import java.io.*;
import java.util.Scanner;

public class E4_Biblioteca {
    final static int LIBROS_MAXIMOS = 2000;
    final static int USUARIOS_MAXIMOS = 100;

    private Libro[] libros;

    private Usuario[] usuarios;
    E4_Biblioteca () throws IOException {
     libros= new Libro[LIBROS_MAXIMOS];
     usuarios= new Usuario[USUARIOS_MAXIMOS];
    }
    private int posicionLibreUsuarios() {
        int posicion = -1;
        for (int i = 0; i < usuarios.length && posicion == -1; i++) {
            if (usuarios[i] == null) posicion = i;
        }
        return posicion;
    }
    private void altaLibros() { // PRINCIPAL
        Scanner sc = new Scanner(System.in);
        System.out.println("---------------------");
        System.out.println("ALTA DE LIBRO");
        System.out.println("---------------------");

        if (Libro.librosMetidos < libros.length) {
            System.out.println("Introduce el título del libro");
            String titulo = sc.nextLine();
            libros[Libro.librosMetidos] = new Libro( titulo);
        } else {
            System.out.println("Se ha alcanzado el limite maximo de libros en esta biblioteca.");
        }
    }

    private void altaUsuario() { // PRINCIPAL
        Scanner sc = new Scanner(System.in);
        System.out.println("---------------------");
        System.out.println("ALTA DE USUARIO");
        System.out.println("---------------------");
        System.out.println("APORTA SU NOMBRE.");
        String nombre = sc.nextLine();
        int posicionLibre = posicionLibreUsuarios();
        if (posicionLibre != -1) {
            usuarios[posicionLibre] = new Usuario(nombre, posicionLibre);
        } else {
            System.out.println("Usuarios maximos alcanzados.");
        }
    }
    private void bajaUsuario() {
        Scanner sc = new Scanner(System.in);
        System.out.println("---------------------");
        System.out.println("BAJA DE USUARIO");
        System.out.println("---------------------");
        System.out.println("APORTA SU IDENTIFICADOR.");
        int id = sc.nextInt();
        if (id < usuarios.length && id >= 0) {
            if (usuarios[id] != null) {
                boolean estaVacio = true;
                for (int i = 0; i < usuarios[id].librosEnSuHaber.length && estaVacio; i++) {
                    if (usuarios[id].librosEnSuHaber[i] != null) estaVacio = false;
                }
                if (estaVacio) {
                    usuarios[id] = null;
                } else {
                    System.out.println("El usuario tiene libros de prestamo, no se le puede dar de baja.");
                }
            } else {
                System.out.println("Ese usuario no existe.");
            }
        } else {
            System.out.println("Id invalido.");
        }
    }
    private void listadoDeUsuarios(){
        boolean hayUsuarios=false;
        for (int i =0; i < usuarios.length; i++) {
            if (usuarios[i] != null) {
                System.out.print("Usuario " + i+ " " );
                usuarios[i].mostrar();
                hayUsuarios=true;
            }
        }
        if (!hayUsuarios)
            System.out.println("No hay usuarios");
    }

    void prestarLibro() throws IOException {
        Teclado teclado= new Teclado();
        System.out.print("ID usuario: ");
        int id = teclado.leerInt();
        System.out.print("Código libro: ");
        int codigo = teclado.leerInt();
        if ( existeLibro(codigo) && existeUsuario(id)) {
            Usuario u = buscarUsuario(id);
            Libro l = buscarLibro(codigo);
            if ( u.numLibrosEnPrestamo() == 5) {
                System.out.println("No se puede realizar el préstamo.");
            }
            else {
                l.portador = u;
                if (u.prestarLibro(l) )
                  System.out.println("Préstamo realizado.");
            }
        }
        else
            System.out.println("NO existe el libro o el usuario");
    }
    void devolverLibro() throws IOException {
        Teclado teclado= new Teclado();
        System.out.print("ID usuario: ");
        int id = teclado.leerInt();
        System.out.print("Código libro: ");
        int codigo = teclado.leerInt();
        Usuario u = buscarUsuario(id);
        Libro l = buscarLibro(codigo);
        boolean devuelto=false;
        if (u!=null && l!=null)
            if (l.portador==u )
                if (u.devolverLibro(l) )
                    devuelto=true;
        if (devuelto )
            System.out.println("Libro devuelto ");
        else
            System.out.println( ("Libro no devuelto"));

    }
    boolean existeUsuario(int idUsuario){
        Usuario usu= buscarUsuario(idUsuario);
        return usu!=null;
    }
    private Usuario buscarUsuario(int idUsuario) {
        Usuario usu=null;
        if ( !(idUsuario < 0 || idUsuario >= USUARIOS_MAXIMOS ) )
          for (int i =0; i < usuarios.length && usu==null; i++)
            if (usuarios[i] != null && usuarios[i].identificador== idUsuario)
                usu=usuarios[i];
        return usu;
    }
    Libro buscarLibro(int codLibro){
        Libro l= null;
         if ( ! ( codLibro < 0 || codLibro >= LIBROS_MAXIMOS || libros[codLibro] == null) )
             l=libros[codLibro];
         return l;
    }
    boolean existeLibro(int codLibro){
       return  !( codLibro < 0 || codLibro >= LIBROS_MAXIMOS || libros[codLibro] == null) ;
    }

    void consultaLibro() throws IOException {
        Teclado teclado= new Teclado();
        System.out.print("Código libro: ");
        int codigo = teclado.leerInt();
        Libro l= buscarLibro(codigo);
        if (l!=null )
            if (l.estaPrestado()) {
                System.out.println("Está prestado");
                l.mostrar();
            }
        else
                System.out.println("No está prestado");
        else
            System.out.println("EL libro no existe");




    }

    public void menuPrincipal() throws IOException {
        Scanner sc = new Scanner(System.in);
        int respuesta;
        do {
            System.out.println("---------------------");
            System.out.println("Elija una opcion:");
            System.out.println("---------------------");
            System.out.println("1.- Alta de libros.");
            System.out.println("2.- Alta de usuarios.");
            System.out.println("3.- Baja de usuarios.");
            System.out.println("4.- Préstamo de libros.");
            System.out.println("5.- Devolución de libro.");
            System.out.println("6.- Consulta de libro.");
            System.out.println("7.- Listado de usuarios.");
            System.out.println("8.- Listado de libros no prestados.");
            System.out.println("0.- Fin de la aplicación.");
            System.out.println("---------------------");
            respuesta = sc.nextInt();
            switch (respuesta) {
                case 1 -> altaLibros();
                case 2 -> altaUsuario();
                case 3 -> bajaUsuario();
                case 4 -> prestarLibro();
                case 5 -> devolverLibro();
                case 6 -> consultaLibro();
                case 7 -> listadoDeUsuarios();
                case 8 -> System.out.println(respuesta);
            }
        } while (respuesta != 0);
        System.out.println("Cerrando aplicacion.");
    }

    public static void main(String[] args) throws IOException {
        E4_Biblioteca biblioteca = new E4_Biblioteca();

        try (BufferedReader br = new BufferedReader(new FileReader("libros.txt"))){
            int codigo;
            String titulo;
            String autor;
            String linea;
            while ((linea = br.readLine()) !=null){
                String[] partes = linea.split(";");
                codigo= Integer.parseInt(partes[0]);
                titulo = partes[1];
                autor = partes [2];
                Libro l1 = new Libro(titulo);
                l1.setAutor(autor);

                System.out.println(codigo + titulo + autor);
            }

        }catch (IOException e){
            e.printStackTrace();
        }
        biblioteca.menuPrincipal();

    }
}
