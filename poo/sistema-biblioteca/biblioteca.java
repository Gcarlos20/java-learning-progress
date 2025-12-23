import java.util.ArrayList;

public class biblioteca {

    private ArrayList<libro> libros; // ArrayList de libros

    public biblioteca() {
        libros = new ArrayList<>();
    }

    // Métodos de la clase biblioteca
    public void agregarLibro(libro libro) {
        libros.add(libro);
        System.out.println("El libro ha sido agregado");
    }

    public void eliminarLibro(libro libro) {
        libros.remove(libro);
        System.out.println("El libro ha sido eliminado");
    }

    public void mostrarLibros() {
        for (libro libro : libros) {
            libro.mostrarInfo();
        }
    }

    public libro buscarLibroPorId(int id) {
        for (libro libro : libros) {
            if (libro.getId() == id) {
                return libro;
            }
        }
        return null;
    }

    
    public void prestarLibro(int id) {
        libro libro = buscarLibroPorId(id);

        if (libro == null) {
            System.out.println("No existe un libro con ese ID");
        } else if (!libro.getdisponible()) {
            System.out.println("El libro ya está prestado");
        } else {
            libro.setDisponible(false);
            System.out.println("Libro prestado correctamente");
        }
    }

    public void devolverLibro(int id) {
        libro libro = buscarLibroPorId(id);

        if (libro == null) {
            System.out.println("No existe un libro con ese ID");
        } else {
            libro.setDisponible(true);
            System.out.println("Libro devuelto correctamente");
        }
    }
}
