# 🎓 DAM – Ejercicios y prácticas

Selección de ejercicios y prácticas que he hecho en el ciclo de **Desarrollo de Aplicaciones Multiplataforma (DAM)** en el IES Luis Vives (Leganés), organizados por asignatura.

## 📚 Asignaturas

### ☕ Programación (Java) – `Programacion/`

| Proyecto | Qué hace | Conceptos |
|----------|----------|-----------|
| [01-Biblioteca](Programacion/01-Biblioteca) | Gestión de una biblioteca: alta y baja de usuarios y libros, préstamos y devoluciones, con menú por consola | POO, arrays de objetos, ficheros, validaciones |
| [02-Supermercado-Herencia](Programacion/02-Supermercado-Herencia) | Supermercado con productos normales y caducables, clientes, clientes preferentes, carrito y ofertas con fecha de fin | Herencia, polimorfismo, `instanceof`, `LocalDateTime`, `ArrayList` |
| [03-Gestion-Empleados](Programacion/03-Gestion-Empleados) | CRUD de empleados con menú: añadir, eliminar, modificar, listar y ordenar por edad | `Vector`, ordenación burbuja, `switch` |
| [04-Streams-Productos](Programacion/04-Streams-Productos) | Lee productos de un fichero y hace consultas: filtrados, ordenaciones, subidas de precio... | Streams, lambdas, `Files.readAllLines` |
| [05-Ficheros](Programacion/05-Ficheros) | Listar un directorio, crear directorios y ficheros, y calcular medias de notas leyendo un CSV | `File`, `BufferedReader`, try-with-resources |
| [06-Arrays-y-Colecciones](Programacion/06-Arrays-y-Colecciones) | Notas de una clase en una matriz y ejercicios con listas | Arrays multidimensionales, `List` |

### 🗄️ Bases de Datos (Oracle PL/SQL) – `BasesDeDatos/PLSQL/`

| Carpeta | Contenido |
|---------|-----------|
| [Cursores](BasesDeDatos/PLSQL/Cursores) | Búsqueda de empleados por apellido y actualización de comisiones con `FOR UPDATE` / `WHERE CURRENT OF` |
| [Disparadores](BasesDeDatos/PLSQL/Disparadores) | Triggers de auditoría: registran subidas/bajadas de salario y altas, modificaciones y bajas de empleados |
| [Funciones](BasesDeDatos/PLSQL/Funciones) | Función `MAYOR` de tres números |
| [Procedimientos](BasesDeDatos/PLSQL/Procedimientos) | Bloques PL/SQL con actualizaciones masivas y estadísticas de empleados por oficio |

Los ejercicios usan principalmente la tabla de ejemplo `EMPLE`.

### 🏷️ Lenguaje de Marcas – `LenguajeDeMarcas/`

| Carpeta | Contenido |
|---------|-----------|
| [DTD](LenguajeDeMarcas/DTD) | DTD de un instituto (alumnos y grupos) con un XML de ejemplo |
| [XSD](LenguajeDeMarcas/XSD) | El mismo modelo como XML Schema, con patrones, enumeraciones y atributos |

## ▶️ Cómo ejecutar los proyectos Java

```bash
cd Programacion/02-Supermercado-Herencia
javac *.java
java Programa
```

## 🛠️ Tecnologías

Java · Oracle SQL / PL-SQL · XML · DTD · XSD · IntelliJ IDEA · Git

---

👤 **Samuel Cleto Malle** · [GitHub](https://github.com/SamuelCletoMalle)
