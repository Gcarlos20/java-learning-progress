import java.util.Scanner;

                                            // nombre del codigo OSIRIS
public class main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        biblioteca biblioteca = new biblioteca();
        int opcion;

        do {
            System.out.println("\n===== GESTIÓN DE BIBLIOTECA =====");
            System.out.println("                                    ");
            System.out.println("1. Agregar libro");
            System.out.println("2. Mostrar libros");
            System.out.println("3. Buscar libro por ID");
            System.out.println("4. Prestar libro");
            System.out.println("5. Devolver libro");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = sc.nextInt();
            sc.nextLine(); // 

            switch (opcion) {

                case 1:
                    System.out.print("ID del libro: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Título: ");
                    String titulo = sc.nextLine();

                    System.out.print("Autor: ");
                    String autor = sc.nextLine();
                    
                    // Si el autor no es el mismo que el editorial, entonces se agrega el editorial
                    System.out.print("Editorial: ");
                    String editorial = sc.nextLine();

                    libro libro = new libro(id, titulo, autor, editorial);
                    biblioteca.agregarLibro(libro);
                    break;

                case 2:
                    biblioteca.mostrarLibros();
                    break;

                case 3:
                    System.out.print("Ingrese el ID a buscar: ");
                    int idBuscar = sc.nextInt();
                    libro encontrado = biblioteca.buscarLibroPorId(idBuscar);

                    if (encontrado != null) {
                        encontrado.mostrarInfo();
                    } else {
                        System.out.println("Libro no encontrado.");
                    }
                    break;

                case 4:
                    System.out.print("Ingrese el ID del libro a prestar: ");
                    int idPrestar = sc.nextInt();
                    biblioteca.prestarLibro(idPrestar);
                    break;

                case 5:
                    System.out.print("Ingrese el ID del libro a devolver: ");
                    int idDevolver = sc.nextInt();
                    biblioteca.devolverLibro(idDevolver);
                    break;

                case 6:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }

        } while (opcion != 6);

        sc.close();
    }
}
