

class Usuario {
    int identificador;
    String nombre;
    /**
     * Los libros están en cualquier posición, hay casillas a null entre los libros prestados
     */
    Libro[] librosEnSuHaber;

    public String getNombre() {
        return nombre;
    }

    //static int identificadorCreciente = 0;
    final static int LIBROSMAXIMOSPORUSUARIO = 5;

    Usuario(String nombre, int identificador) {
        this.nombre = nombre;
        this.identificador = identificador;
        librosEnSuHaber = new Libro[LIBROSMAXIMOSPORUSUARIO];
        //identificador = identificadorCreciente++;
    }
    void mostrar(){
        System.out.println("-----------------------------------------");
        System.out.print("Identificador: " + identificador);
        System.out.print(" Nombre: " + nombre);
        System.out.print(" Libros en su posición: ");
        for (int j = 0; j < librosEnSuHaber.length; j++) {
            if (librosEnSuHaber[j]!=null)
              librosEnSuHaber[j].mostrar();
        }
        System.out.println();
    }
    int numLibrosEnPrestamo(){
        int cont=0;
        for (int i=0; i<librosEnSuHaber.length; i++)
            if (librosEnSuHaber[i]!=null)
                cont++;
        return cont;
    }

    public boolean prestarLibro(Libro l) {
        boolean prestado=false;
        for (int i=0; i<librosEnSuHaber.length && !prestado ; i++)
            if (librosEnSuHaber[i]==null) {
                librosEnSuHaber[i] = l;
                prestado = true;
            }
        return prestado;
    }

    public boolean devolverLibro(Libro l) {
        boolean devuelto=false;
        for (int i=0; i<librosEnSuHaber.length; i++)
            if (librosEnSuHaber[i]==l) {
                librosEnSuHaber[i] = null;
                l.devolverPrestamo();
                devuelto=true;
            }
        return devuelto;
    }
}
