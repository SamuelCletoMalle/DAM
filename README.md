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

## 🗂️ Más material del ciclo

### ☕ Programación (más ejercicios)
| Carpeta | Contenido |
|---|---|
| `Programacion/07-Agenda-Contactos` | Agenda por consola con altas, bajas, búsqueda por nombre o prefijo, orden alfabético y guardado en fichero (`ArrayList`, `Comparable`, excepciones, `try-with-resources`) |
| `Programacion/1EV-Ejercicios-2025-26` | Series de ejercicios A–N del curso 25/26: clases y objetos (CuentaCorriente, Fracción, Punto, Triángulo, Fútbol, Reloj, Seguro), bucles, arrays, **Hundir la Flota**, Pizzería, ficheros y herencia |
| `Programacion/2024-25/1EV-Arrays-y-Clases` | Arrays y clases del curso 24/25: almacén, alquiler de vehículos, hotel, buscaminas, Snake, la flota, rotación y ordenación de arrays |
| `Programacion/2024-25/2EV-Ficheros-Cadenas-Recursividad` | Ficheros (mover, buscar palabras, tamaños), cadenas, expresiones regulares, cifrado César, Fibonacci recursivo |
| `Programacion/2024-25/3EV-Herencia-Colecciones-Graficos` | Calculadora binaria gráfica, herencia de figuras, prioridades de pacientes y radar con colecciones |

### 🗄️ Bases de Datos (más ejercicios)
| Carpeta | Contenido |
|---|---|
| `BasesDeDatos/SQL-Consultas-y-Vistas` | Prácticas 6.x: Personas, Multinacional, Universidad, Instituto, creación de vistas, Red de Metro, Universidad Popular, Vendedores |
| `BasesDeDatos/PLSQL-Practicas` | Bucles, cursores, disparadores, funciones y procedimientos, más 15 ejercicios básicos de bloques y procedimientos |
| `BasesDeDatos/Liga-Futbol` | Mini proyecto: modelo de una liga con tablas, claves, vista de resultados, función de puntos, procedimiento de clasificación y trigger de validación |

### 🏷️ Lenguaje de Marcas
`LenguajeDeMarcas/Practicas` reúne las prácticas de HTML, CSS, formularios, JavaScript (validaciones y expresiones regulares), canvas y XML de los tres trimestres.

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
