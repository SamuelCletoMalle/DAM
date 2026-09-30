
class Libro {
    int codigo;
    String titulo;
    Usuario portador;
    static int librosMetidos = 0;
    String autor;
    Libro( String titulo) {
        this.titulo = titulo;
        codigo=librosMetidos;
        librosMetidos++;
        portador=null;
        this.autor = autor;
    }
    void mostrar(){
        System.out.print(codigo+" "+ titulo+" ");
        if (portador==null)
          System.out.println("No prestado");
        else
          System.out.println("prestado a "+portador.getNombre());

    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    void devolverPrestamo(){
        portador=null;
    }
    boolean estaPrestado(){
        return portador!=null;
    }
}
