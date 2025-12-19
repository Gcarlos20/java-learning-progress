package gestion;
                                                 // nombre del programa: Corintio

import java.util.ArrayList;
import java.util.Scanner;

//  PRODUCTO 
public class Producto { // Atributos

    private String nombre;
    private double precio;
    private int cantidad;
    private String categoria;   
    private int stockMinimo;

    public Producto(String nombre, double precio, int cantidad, String categoria, int stockMinimo) { // Constructor
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
        this.categoria = categoria; 
        this.stockMinimo = stockMinimo;
    }

    public String getNombre() { return nombre; } // Getters 
    public double getPrecio() { return precio; }
    public int getCantidad() { return cantidad; }
    public String getCategoria() { return categoria; }
    public int getStockMinimo() { return stockMinimo; }
                                                         // Setters                                               
    public void setPrecio(double precio) { this.precio = precio; }
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }
}

// ================= CRUD =================
class Crud {

    private ArrayList<Producto> productos = new ArrayList<>();

    public void agregarProducto(Producto p) {
        productos.add(p);
    }

  public void mostrarProductos() {
    System.out.println("\n--- LISTA DE PRODUCTOS ---");
    for (Producto p : productos) {
        System.out.println(
            "Nombre: " + p.getNombre() +
            " | Categoría: " + p.getCategoria() +
            " | Precio: $" + p.getPrecio() +
            " | Cantidad: " + p.getCantidad()
        );
    }
}

    public ArrayList<Producto> buscarPorCategoria(String categoria) {
        ArrayList<Producto> lista = new ArrayList<>();
        for (Producto p : productos) {
            if (p.getCategoria().equalsIgnoreCase(categoria)) {
                lista.add(p);
            }
        }
        return lista;
    }

    public ArrayList<Producto> productosConStockBajo() {
        ArrayList<Producto> bajos = new ArrayList<>();
        for (Producto p : productos) {
            if (p.getCantidad() <= p.getStockMinimo()) {
                bajos.add(p);
            }
        }
        return bajos;
    }
}

// ================= MAIN / MENU =================
class Main {
    public static void main(String[] args) {

        Crud crud = new Crud();
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n=== MENU INVENTARIO MARISCOS ===");
            System.out.println("1. Agregar producto");
            System.out.println("2. Mostrar productos");
            System.out.println("3. Buscar por categoria");
            System.out.println("4. Ver stock bajo");
            System.out.println("0. Salir");
            System.out.print("Opcion: ");

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();

                    System.out.print("Precio: ");
                    double precio = sc.nextDouble();

                    System.out.print("Cantidad: ");
                    int cantidad = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Categoria: ");
                    String categoria = sc.nextLine();

                    System.out.print("Stock minimo: ");
                    int stockMin = sc.nextInt();

                    crud.agregarProducto(
                        new Producto(nombre, precio, cantidad, categoria, stockMin)
                    );
                    break;

                case 2:
                    crud.mostrarProductos();
                    break;

                case 3:
                    System.out.print("Categoria: ");
                    String cat = sc.nextLine();
                    for (Producto p : crud.buscarPorCategoria(cat)) {
                        System.out.println(p.getNombre());
                    }
                    break;

                case 4:
                    for (Producto p : crud.productosConStockBajo()) {
                        System.out.println("STOCK BAJO: " + p.getNombre());
                    }
                    break;
            }

        } while (opcion != 0);
        System.out.println("Sistema cerrado.");
        sc.close();
    }
}



