public class NotasClase {
    int  notas[][];  //valor -1 es que no tiene nota
    NotasClase(int numAlumnos, int numNotas){
        notas=new int [numAlumnos][numNotas];
        for (int i=0; i<notas.length; i++)
            for (int j=0; j<notas[i].length; j++)
                notas[i][j]=-1;
    }
    void mostrar(){
        for (int i=0; i<notas.length; i++) {
            System.out.print("Alumno "+i+":\t");
            for (int j = 0; j < notas[i].length; j++)
                System.out.print(notas[i][j] + ",");
            System.out.println();
        }
    }
    void ponerNotaAlumno(int numAlumno, int numAsignatura, int nota){
        notas[numAlumno][numAsignatura]=nota;
    }
    void ponerTodasNotasAlumno (int numAlumno, int nota){
        for (int i=0; i< notas[numAlumno].length  ;i++)
            notas[numAlumno][i]= nota;
    }
    void ponerTodasNotasAsignatura (int numAsig, int nota){
        for (int i=0; i< notas.length  ;i++)
            notas[i][numAsig]= nota;
    }
    double notaMedia(int numAlumno){
        int sumaNotas=0;
        int contNotas=0;
        for (int i=0; i< notas[numAlumno].length  ;i++)
            if (notas[numAlumno][i]!= -1) {
                sumaNotas += notas[numAlumno][i];
                contNotas++;
            }
        return (double)sumaNotas/contNotas;
    }
    //sumar todas las notas y dividir entre el número de ellas distintas de -1
    double notaMediaClase(){
      int sumaNotas=0;
      int contNotas=0;
      for (int i=0;  i<notas.length  ; i++)
          for (int j=0; j<notas[i].length  ; j++) {
              if(notas[i][j]!=-1) {
                  sumaNotas += notas[i][j];
                  contNotas++;
              }
          }
      if (contNotas !=0)
        return  (double)sumaNotas/contNotas;
      else
          return -1;
    }
    int alumnoMejorMedia(){
       double mejorMedia=-1;
       int numnAlumnoMejorMedia=-1;
       double notaMediaAux=0;
       for ( int i=0; i<notas.length; i++) {
           notaMediaAux = notaMedia(i);
           if (notaMediaAux > mejorMedia) {
               mejorMedia = notaMediaAux;
               numnAlumnoMejorMedia = i;
           }
       }
       return numnAlumnoMejorMedia;
    }
    /**
     * Posición (alumno y asignatura) en la que la nota es la mayor de toda la clase
     */
    Posicion mejorNota() {
        return new Posicion();
    }
    public static void main(String[] args) {
        NotasClase dam1= new NotasClase(5,3);

        dam1.ponerNotaAlumno(3,2,7);
        dam1.ponerTodasNotasAlumno (1,0);
        dam1.ponerTodasNotasAsignatura(2, 5);
        dam1.mostrar();
        double media= dam1.notaMedia(2);
        System.out.println("La media del alumno es "+media);
        double mediaClase=dam1.notaMediaClase();
        if (mediaClase<0)
            System.out.println("No han notas válidas");
        else
          System.out.println("La media de la clase es "+mediaClase);
    }

}
