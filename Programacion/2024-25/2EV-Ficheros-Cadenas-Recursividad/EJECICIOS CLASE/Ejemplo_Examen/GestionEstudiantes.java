import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class GestionEstudiantes {
    private static final String NOMBRE_ARCHIVO = "estudiantes.dat";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("1. Agregar Estudiante");
            System.out.println("2. Modificar Estudiante");
            System.out.println("3. Eliminar Estudiante");
            System.out.println("4. Listar Estudiantes");
            System.out.println("5. Calcular Media de Calificaciones");
            System.out.println("6. Buscar Estudiante por Nombre");
            System.out.println("7. Mostrar Estadísticas");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    agregarEstudiante(scanner);
                    break;
                case 2:
                    modificarEstudiante(scanner);
                    break;
                case 3:
                    eliminarEstudiante(scanner);
                    break;
                    case 4:
                        listarEstudiantes();
                        break; case 5:
                                                           calcularMedia(scanner);
                                                           break; case 6:
                                                           buscarEstudiantePorNombre(scanner);
                                                           break;
                                                       case 7:
                                                           mostrarEstadisticas();
                                                           break;
                                                       case 0:
                                                           System.out.println("Saliendo...");
                                                           break;
                                                       default:
                                                           System.out.println("Opción no válida.");
                                                   }
                                               } while (opcion != 0);
                                               scanner.close();
                                           }

                                           private static void agregarEstudiante(Scanner scanner) {
                                               try (RandomAccessFile raf = new RandomAccessFile(NOMBRE_ARCHIVO, "rw")) {
                                                   System.out.print("Ingrese ID: ");
                                                   int id = scanner.nextInt();
                                                   scanner.nextLine(); // Limpiar el buffer
                                                   System.out.print("Ingrese Nombre: ");
                                                   String nombre = scanner.nextLine();
                                                   System.out.print("Ingrese número de calificaciones: ");
                                                   int numCalificaciones = scanner.nextInt();
                                                   int[] calificaciones = new int[numCalificaciones];
                                                   for (int i = 0; i < numCalificaciones; i++) {
                                                       System.out.print("Ingrese calificación " + (i + 1) + ": ");
                                                       calificaciones[i] = scanner.nextInt();
                                                   }
                                                   Estudiante estudiante = new Estudiante(id, nombre, calificaciones);
                                                   raf.seek(raf.length()); // Ir al final del archivo
                                                   estudiante.escribir(raf);
                                                   System.out.println("Estudiante agregado.");
                                               } catch (IOException e) {
                                                   System.out.println("Error al agregar estudiante: " + e.getMessage());
                                               }
                                           }

                                           private static void modificarEstudiante(Scanner scanner) {
                                               try (RandomAccessFile raf = new RandomAccessFile(NOMBRE_ARCHIVO, "rw")) {
                                                   System.out.print("Ingrese ID del estudiante a modificar: ");
                                                   int id = scanner.nextInt();
                                                   boolean encontrado = false;

                                                   while (raf.getFilePointer() < raf.length()) {
                                                       Estudiante estudiante = Estudiante.leer(raf);
                                                       if (estudiante.getId() == id && !estudiante.isEliminado()) {
                                                           encontrado = true;
                                                           scanner.nextLine(); // Limpiar el buffer
                                                           System.out.print("Ingrese nuevo nombre: ");
                                                           String nuevoNombre = scanner.nextLine();
                                                           System.out.print("Ingrese número de calificaciones: ");
                                                           int numCalificaciones = scanner.nextInt();
                                                           int[] nuevasCalificaciones = new int[numCalificaciones];
                                                           for (int i = 0; i < numCalificaciones; i++) {
                                                               System.out.print("Ingrese nueva calificación " + (i + 1) + ": ");
                                                               nuevasCalificaciones[i] = scanner.nextInt();
                                                           }
                                                           // Volver al inicio del registro del estudiante
                                                           raf.seek(raf.getFilePointer() - (4 + estudiante.getNombre().length() * 2 + 4 + 4 * estudiante.getCalificaciones().length + 1));
                                                           Estudiante nuevoEstudiante = new Estudiante(id, nuevoNombre, nuevasCalificaciones);
                                                           nuevoEstudiante.escribir(raf);
                                                           System.out.println("Estudiante modificado.");
                                                           break;
                                                       }
                                                   }
                                                   if (!encontrado) {
                                                       System.out.println("Estudiante no encontrado o eliminado.");
                                                   }
                                               } catch (IOException e) {
                                                   System.out.println("Error al modificar estudiante: " + e.getMessage());
                                               }
                                           }

                                           private static void eliminarEstudiante(Scanner scanner) {
                                               try (RandomAccessFile raf = new RandomAccessFile(NOMBRE_ARCHIVO, "rw")) {
                                                   System.out.print("Ingrese ID del estudiante a eliminar: ");
                                                   int id = scanner.nextInt();
                                                   boolean encontrado = false;

                                                   while (raf.getFilePointer() < raf.length()) {
                                                       Estudiante estudiante = Estudiante.leer(raf);
                                                       if (estudiante.getId() == id) {
                                                           encontrado = true;
                                                           estudiante.setEliminado(true); // Marcar como eliminado
                                                           // Volver al inicio del registro del estudiante
                                                           raf.seek(raf.getFilePointer() - (4 + estudiante.getNombre().length() * 2 + 4 + 4 * estudiante.getCalificaciones().length + 1));
                                                           estudiante.escribir(raf); // Escribir el registro actualizado
                                                           System.out.println("Estudiante eliminado.");
                                                           break;
                                                       }
                                                   }
                                                   if (!encontrado) {
                                                       System.out.println("Estudiante no encontrado.");
                                                   }
                                               } catch (IOException e) {
                                                   System.out.println("Error al eliminar estudiante: " + e.getMessage());
                                               }
                                           }

                                           private static void listarEstudiantes() {
                                               try (RandomAccessFile raf = new RandomAccessFile(NOMBRE_ARCHIVO, "r")) {
                                                   System.out.println             System.out.println("Lista de estudiantes:");
                                                                                  while (raf.getFilePointer() < raf.length()) {
                                                                                      Estudiante estudiante = Estudiante.leer(raf);
                                                                                      if (!estudiante.isEliminado()) {
                                                                                          System.out.println(estudiante);
                                                                                      }
                                                                                  }
                                                                              } catch (IOException e) {
                                                                                  System.out.println("Error al listar estudiantes: " + e.getMessage());
                                                                              }
                                                                          }

                                                                          private static void calcularMedia(Scanner scanner) {
                                                                              try (RandomAccessFile raf = new RandomAccessFile(NOMBRE_ARCHIVO, "r")) {
                                                                                  System.out.print("Ingrese ID del estudiante: ");
                                                                                  int id = scanner.nextInt();
                                                                                  boolean encontrado = false;

                                                                                  while (raf.getFilePointer() < raf.length()) {
                                                                                      Estudiante estudiante = Estudiante.leer(raf);
                                                                                      if (estudiante.getId() == id && !estudiante.isEliminado()) {
                                                                                          encontrado = true;
                                                                                          double media = estudiante.calcularMedia();
                                                                                          System.out.println("La media de calificaciones de " + estudiante.getNombre() + " es: " + media);
                                                                                          break;
                                                                                      }
                                                                                  }
                                                                                  if (!encontrado) {
                                                                                      System.out.println("Estudiante no encontrado o eliminado.");
                                                                                  }
                                                                              } catch (IOException e) {
                                                                                  System.out.println("Error al calcular la media: " + e.getMessage());
                                                                              }
                                                                          }

                                                                          private static void buscarEstudiantePorNombre(Scanner scanner) {
                                                                              try (RandomAccessFile raf = new RandomAccessFile(NOMBRE_ARCHIVO, "r")) {
                                                                                  System.out.print("Ingrese nombre del estudiante: ");
                                                                                  String nombreBuscado = scanner.nextLine();
                                                                                  boolean encontrado = false;

                                                                                  while (raf.getFilePointer() < raf.length()) {
                                                                                      Estudiante estudiante = Estudiante.leer(raf);
                                                                                      if (estudiante.getNombre().equalsIgnoreCase(nombreBuscado) && !estudiante.isEliminado()) {
                                                                                          encontrado = true;
                                                                                          System.out.println(estudiante);
                                                                                      }
                                                                                  }
                                                                                  if (!encontrado) {
                                                                                      System.out.println("No se encontraron estudiantes con ese nombre.");
                                                                                  }
                                                                              } catch (IOException e) {
                                                                                  System.out.println("Error al buscar estudiante: " + e.getMessage());
                                                                              }
                                                                          }

                                                                          private static void mostrarEstadisticas() {
                                                                              try (RandomAccessFile raf = new RandomAccessFile(NOMBRE_ARCHIVO, "r")) {
                                                                                  int totalEstudiantes = 0;
                                                                                  int totalEliminados = 0;
                                                                                  double sumaMedia = 0;
                                                                                  int estudiantesConCalificaciones = 0;

                                                                                  while (raf.getFilePointer() < raf.length()) {
                                                                                      Estudiante estudiante = Estudiante.leer(raf);
                                                                                      totalEstudiantes++;
                                                                                      if (estudiante.isEliminado()) {
                                                                                          totalEliminados++;
                                                                                      } else {
                                                                                          sumaMedia += estudiante.calcularMedia();
                                                                                          estudiantesConCalificaciones++;
                                                                                      }
                                                                                  }

                                                                                  System.out.println("Total de estudiantes: " + totalEstudiantes);
                                                                                  System.out.println("Total de estudiantes eliminados: " + totalEliminados);
                                                                                  if (estudiantesConCalificaciones > 0) {
                                                                                      System.out.println("Media general de calificaciones: " + (sumaMedia / estudiantesConCalificaciones));
                                                                                  } else {
                                                                                      System.out.println("No hay estudiantes con calificaciones.");
                                                                                  }
                                                                              } catch (IOException e) {
                                                                                  System.out.println("Error al mostrar estadísticas: " + e.getMessage());
                                                                              }
                                                                          }
                                                                      }