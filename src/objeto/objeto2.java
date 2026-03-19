package src.objeto;
import java.util.Scanner;

public class objeto2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("¿Cuántos estudiantes desea registrar? ");
        int cantidad = sc.nextInt();
        sc.nextLine(); // limpiar buffer

        for (int i = 1; i <= cantidad; i++) {

            System.out.println("\nEstudiante " + i);

            System.out.print("Nombre: ");
            String nombre = sc.nextLine();

            System.out.print("Nota final (0 a 5): ");
            double nota = sc.nextDouble();
            sc.nextLine(); // limpiar buffer

            // Mostrar datos
            System.out.println("Nombre: " + nombre);
            System.out.println("Nota: " + nota);

            // Condición
            if (nota >= 3.0) {
                System.out.println("Estado: Aprobó el curso");
            } else {
                System.out.println("Estado: Reprobó el curso");
            }
        }

        sc.close();
    }
}