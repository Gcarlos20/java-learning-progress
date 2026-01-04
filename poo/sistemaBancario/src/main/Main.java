package main;

import service.BancoServicio;
import models.CuentaBancaria;
import utils.Menu;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        BancoServicio banco = new BancoServicio();
        int opcion;

        do {
            Menu.mostrarMenu();
            opcion = sc.nextInt();

            switch (opcion) {

                case 1 -> {
                    int id = Menu.leerInt(sc, "ID de la cuenta: ");
                    String numero = Menu.leerString(sc, "Número de cuenta: ");
                    String titular = Menu.leerString(sc, "Titular: ");
                    String tipo = Menu.leerString(sc, "Tipo de cuenta: ");
                    double saldo = Menu.leerDouble(sc, "Saldo inicial: ");

                    CuentaBancaria cuenta = new CuentaBancaria(
                            id, numero, titular, tipo, saldo
                    );

                    banco.agregarCuenta(cuenta);
                }

                case 2 -> {
                    int id = Menu.leerInt(sc, "ID de la cuenta: ");
                    double monto = Menu.leerDouble(sc, "Monto a depositar: ");
                    banco.depositar(id, monto);
                }

                case 3 -> {
                    int id = Menu.leerInt(sc, "ID de la cuenta: ");
                    double monto = Menu.leerDouble(sc, "Monto a retirar: ");
                    banco.retirar(id, monto);
                }

                case 4 -> {
                    int id = Menu.leerInt(sc, "ID de la cuenta: ");
                    banco.activarCuenta(id);
                }

                case 5 -> {
                    int id = Menu.leerInt(sc, "ID de la cuenta: ");
                    banco.desactivarCuenta(id);
                }

                case 6 -> banco.mostrarTodasLasCuentas();

                case 7 -> banco.mostrarCuentasActivas();

                case 8 -> banco.mostrarCuentasInactivas();

                case 9 -> System.out.println("Saliendo del sistema...");

                default -> System.out.println("Opción inválida.");
            }

        } while (opcion != 9);

        sc.close();
    }
}
         