package src;
import java.util.Scanner;


public class Ejer5_SobrecargaMetodos {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Entrada de datos
        System.out.print("Ingrese la nota del examen: ");
        double notaExamen = sc.nextDouble();

        System.out.print("Ingrese la nota del trabajo: ");
        double notaTrabajo = sc.nextDouble();

        System.out.print("¿Cumple con la asistencia? (true/false): ");
        boolean asistencia = sc.nextBoolean();

        // Cálculo
        double nota = calcularNota(notaExamen, notaTrabajo, asistencia);

        // Resultado
        System.out.println("Nota final = " + nota);

        sc.close();
    }

    // Método para calcular la nota final
    private static double calcularNota(double notaExamen, double notaTrabajoGrupo, boolean ratioAsistencia) {
        double notaFinal = notaExamen * 0.6 + notaTrabajoGrupo * 0.4;

        if (notaFinal >= 3.0 && ratioAsistencia) {
            return notaFinal;
        } else {
            return 0.0;
        }
    }
}