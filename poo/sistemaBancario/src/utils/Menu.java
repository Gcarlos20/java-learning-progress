package utils;

import java.util.Scanner;

public class Menu {

    public static void mostrarMenu() {
        System.out.println("\n===== SISTEMA BANCARIO =====");
        System.out.println("1. Crear cuenta");
        System.out.println("2. Depositar");
        System.out.println("3. Retirar");
        System.out.println("4. Activar cuenta");
        System.out.println("5. Desactivar cuenta");
        System.out.println("6. Mostrar todas las cuentas");
        System.out.println("7. Mostrar cuentas activas");
        System.out.println("8. Mostrar cuentas inactivas");
        System.out.println("9. Salir");
        System.out.print("Seleccione una opción: ");
    }

    public static int leerInt(Scanner sc, String mensaje) {
        System.out.print(mensaje);
        return sc.nextInt();
    }

    public static double leerDouble(Scanner sc, String mensaje) {
        System.out.print(mensaje);
        return sc.nextDouble();
    }

    public static String leerString(Scanner sc, String mensaje) {
        System.out.print(mensaje);
        sc.nextLine(); // limpiar buffer
        return sc.nextLine();
    }
}
