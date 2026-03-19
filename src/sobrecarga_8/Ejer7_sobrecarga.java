package src.sobrecarga_8;
import java.util.Scanner;

public class Ejer7_sobrecarga{
    public static void main(String[] args) {
        // entradad de datos 
        Scanner sc = new Scanner(System.in);
        System.out.println("ingrese el precio del pedido");
        double precio = sc.nextDouble();
        System.out.println("ingrese la cantidad");
        int cantidad = sc.nextInt();
        System.out.println("ingrese el precio del envio");
        double precioEnvio = sc.nextDouble();

        // calculo del total a pagar 
        double totalPagar = calcularTotal(precio, cantidad, precioEnvio);

        // resultado
        System.out.println("Total a pagar: " + totalPagar);

    }
private static double calcularTotal(double precio, int cantidad, double precioEnvio) {
    double total = (precio * cantidad) + precioEnvio;
    return total;
}
private static double calcularTotal(double precio, int cantidad) {
    double total = precio * cantidad;
    return total;
}
}



