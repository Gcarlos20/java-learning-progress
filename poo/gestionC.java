package gestion;

import java.util.ArrayList;
import java.util.Scanner;

public class gestionC {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Agenda agenda = new Agenda();
        int opcion;

        do {
            System.out.println("\n=== SISTEMA DE GESTIÓN DE CONTACTOS ===");
            System.out.println("1. Agregar contacto");
            System.out.println("2. Mostrar contactos");
            System.out.println("3. Buscar contacto");
            System.out.println("4. Eliminar contacto");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Teléfono: ");
                    String telefono = sc.nextLine();
                    System.out.print("Email: ");
                    String email = sc.nextLine();

                    agenda.agregarContacto(
                        new Contacto(nombre, telefono, email)
                    );
                    break;

                case 2:
                    agenda.mostrarContactos();
                    break;

                case 3:
                    System.out.print("Nombre a buscar: ");
                    String buscar = sc.nextLine();
                    Contacto encontrado = agenda.buscarContacto(buscar);

                    if (encontrado != null) { 
                        System.out.println(encontrado);
                    } else {
                        System.out.println("Contacto no encontrado.");
                    }
                    break;

                case 4:
                    System.out.print("Nombre a eliminar: ");
                    String eliminar = sc.nextLine();

                    if (agenda.eliminarContacto(eliminar)) {
                        System.out.println("Contacto eliminado.");
                    } else {
                        System.out.println("Contacto no encontrado.");
                    }
                    break;

                case 5:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }

        } while (opcion != 5);

        sc.close();
    }
}

/* ===== CLASE CONTACTO ===== */
class Contacto {

    private String nombre;
    private String telefono;
    private String email;

    public Contacto(String nombre, String telefono, String email) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    @Override 
    public String toString() {
        return "Nombre: " + nombre +
               " | Teléfono: " + telefono +
               " | Email: " + email;
    }
}

/* ===== CLASE AGENDA ===== */
class Agenda {

    private ArrayList<Contacto> contactos;

    public Agenda() {
        contactos = new ArrayList<>();
    }

    public void agregarContacto(Contacto c) {
        contactos.add(c);
        System.out.println("Contacto agregado correctamente.");
    }

    public void mostrarContactos() {
        if (contactos.isEmpty()) {
            System.out.println("No hay contactos registrados.");
            return;
        }

        for (Contacto c : contactos) {
            System.out.println(c);
        }
    }

    public Contacto buscarContacto(String nombre) {
        for (Contacto c : contactos) {
            if (c.getNombre().equalsIgnoreCase(nombre)) {
                return c;
            }
        }
        return null;
    }

    public boolean eliminarContacto(String nombre) {
        Contacto c = buscarContacto(nombre);
        if (c != null) {
            contactos.remove(c);
            return true;
        }
        return false;
    }
}

// Nombre: de programa DOUMA