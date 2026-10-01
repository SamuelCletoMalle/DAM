package ALMACEN_ARRAYS;

import java.util.ArrayList;
import java.util.Scanner;

class Producto {
    private int codigo;
    private double precio;
    private int cantidad;
    private int tipo;

    public Producto(int codigo, double precio, int cantidad, int tipo) {
        this.codigo = codigo;
        this.precio = precio;
        this.cantidad = cantidad;
        this.tipo = tipo;
    }

    public int getCodigo() {
        return codigo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getTipo() {
        return tipo;
    }
}

public class Almacen {
    private static final int MAX_PRODUCTOS = 100;
    private ArrayList<Producto> productos;

    public Almacen() {
        productos = new ArrayList<>();
    }

    public void darDeAltaProducto(int codigo, double precio, int cantidad, int tipo) {
        if (productos.size() < MAX_PRODUCTOS) {
            productos.add(new Producto(codigo, precio, cantidad, tipo));
        } else {
            System.out.println("No se pueden agregar más productos, almacén lleno.");
        }
    }

    public double venderProducto(int codigo, int cantidadVendida) {
        for (Producto producto : productos) {
            if (producto.getCodigo() == codigo) {
                int cantidadDisponible = producto.getCantidad();
                int cantidadVendidaReal = Math.min(cantidadDisponible, cantidadVendida);
                producto.setCantidad(cantidadDisponible - cantidadVendidaReal);
                return cantidadVendidaReal * producto.getPrecio();
            }
        }
        System.out.println("Producto no encontrado.");
        return 0;
    }

    public void ventaPorTipo(int tipo, int cantidadSolicitada) {
        double precioTotal = 0;
        int cantidadTotalVendida = 0;

        for (Producto producto : productos) {
            if (producto.getTipo() == tipo && cantidadSolicitada > 0) {
                int cantidadDisponible = producto.getCantidad();
                int cantidadVendida = Math.min(cantidadDisponible, cantidadSolicitada);
                producto.setCantidad(cantidadDisponible - cantidadVendida);

                System.out.println("Vendido: [codigo=" + producto.getCodigo() + ", cantidad=" + cantidadVendida + ", precio=" + (cantidadVendida * producto.getPrecio()) + "]");
                precioTotal += cantidadVendida * producto.getPrecio();
                cantidadTotalVendida += cantidadVendida;
                cantidadSolicitada -= cantidadVendida;
            }
        }

        System.out.println("Cantidad total vendida: " + cantidadTotalVendida);
        System.out.println("Precio total de la venta: " + precioTotal);
    }

    public void fusionarProductos(int codigo1, int codigo2) {
        Producto producto1 = null;
        Producto producto2 = null;

        for (Producto producto : productos) {
            if (producto.getCodigo() == codigo1) {
                producto1 = producto;
            } else if (producto.getCodigo() == codigo2) {
                producto2 = producto;
            }
        }

        if (producto1 != null && producto2 != null) {
            if (producto1.getTipo() == producto2.getTipo()) {
                int nuevaCantidad = producto1.getCantidad() + producto2.getCantidad();
                double nuevoPrecio = (producto1.getPrecio() + producto2.getPrecio()) / 2;

                producto1.setCantidad(nuevaCantidad);
                producto1.setPrecio(nuevoPrecio);
                productos.remove(producto2);

                System.out.println("Fusión realizada. Producto resultante: [codigo=" + producto1.getCodigo() + ", cantidad=" + producto1.getCantidad() + ", precio=" + producto1.getPrecio() + ", tipo=" + producto1.getTipo() + "]");
            } else {
                System.out.println("No se pueden fusionar productos de diferente tipo.");
            }
        } else {
            System.out.println("Uno o ambos productos no existen.");
        }
    }

    public void listarProductosPorTipo(int tipo) {
        double sumaPrecios = 0;
        int sumaCantidades = 0;
        int contador = 0;

        for (Producto producto : productos) {
            if (producto.getTipo() == tipo) {
                System.out.println("Producto [codigo=" + producto.getCodigo() + ", precio=" + producto.getPrecio() + ", cantidad=" + producto.getCantidad() + ", tipo=" + producto.getTipo() + "]");
                sumaPrecios += producto.getPrecio();
                sumaCantidades += producto.getCantidad();
                contador++;
            }
        }

        if (contador > 0) {
            System.out.println("Media de precios: " + (sumaPrecios / contador));
            System.out.println("Suma de cantidades: " + sumaCantidades);
        } else {
            System.out.println("No hay productos de este tipo.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Almacen almacen = new Almacen();
        int opcion;

        do {
            System.out.println("Menú de opciones:");
            System.out.println("1. Dar de alta un producto");
            System.out.println("2. Vender producto");
            System.out.println("3. Venta por tipo");
            System.out.println("4. Fusionar productos");
            System.out.println("5. Listar productos por tipo");
            System.out.println("0. Finalizar");
            System.out.print("Elige una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Introduce el código del producto: ");
                    int codigo = scanner.nextInt();
                    System.out.print("Introduce el precio del producto: ");
                    double precio = scanner.nextDouble();
                    System.out.print("Introduce la cantidad del producto: ");
                    int cantidad = scanner.nextInt();
                    System.out.print("Introduce el tipo del producto (1-10): ");
                    int tipo = scanner.nextInt();
                    almacen.darDeAltaProducto(codigo, precio, cantidad, tipo);
                    break;

                case 2:
                    System.out.print("Introduce el código del producto: ");
                    codigo = scanner.nextInt();
                    System.out.print("Introduce la cantidad a vender: ");
                    cantidad = scanner.nextInt();
                    double precioVenta = almacen.venderProducto(codigo, cantidad);
                    System.out.println("Precio de la venta: " + precioVenta);
                    break;

                case 3:
                    System.out.print("Introduce el tipo de producto: ");
                    tipo = scanner.nextInt();
                    System.out.print("Introduce la cantidad a vender: ");
                    cantidad = scanner.nextInt();
                    almacen.ventaPorTipo(tipo, cantidad);
                    break;

                case 4:
                    System.out.print("Introduce el código del primer producto: ");
                    int codigo1 = scanner.nextInt();
                    System.out.print("Introduce el código del segundo producto: ");
                    int codigo2 = scanner.nextInt();
                    almacen.fusionarProductos(codigo1, codigo2);
                    break;

                case 5:
                    System.out.print("Introduce el tipo de producto: ");
                    tipo = scanner.nextInt();
                    almacen.listarProductosPorTipo(tipo);
                    break;

                case 0:
                    System.out.println("Finalizando programa.");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 0);

        scanner.close();
    }
}
