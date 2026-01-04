package service;

import models.CuentaBancaria;
import java.util.ArrayList;

public class BancoServicio {

    private ArrayList<CuentaBancaria> cuentas = new ArrayList<>();

    public void agregarCuenta(CuentaBancaria cuenta) {
        cuentas.add(cuenta);
        System.out.println("Cuenta agregada correctamente.");
    }

    private CuentaBancaria buscarPorId(int idCuenta) {
        for (CuentaBancaria c : cuentas) {
            if (c.getIdCuenta() == idCuenta) {
                return c;
            }
        }
        return null;
    }

    public void depositar(int idCuenta, double monto) {
        CuentaBancaria cuenta = buscarPorId(idCuenta);
        if (cuenta == null) {
            System.out.println("Cuenta no encontrada.");
            return;
        }

        if (cuenta.depositar(monto)) {
            System.out.println("Depósito exitoso.");
        } else {
            System.out.println("No se pudo realizar el depósito.");
        }
    }

    public void retirar(int idCuenta, double monto) {
        CuentaBancaria cuenta = buscarPorId(idCuenta);
        if (cuenta == null) {
            System.out.println("Cuenta no encontrada.");
            return;
        }

        if (cuenta.retirar(monto)) {
            System.out.println("Retiro exitoso.");
        } else {
            System.out.println("No se pudo realizar el retiro.");
        }
    }

    public void activarCuenta(int idCuenta) {
        CuentaBancaria cuenta = buscarPorId(idCuenta);
        if (cuenta != null) {
            cuenta.activar();
            System.out.println("Cuenta activada.");
        }
    }

    public void desactivarCuenta(int idCuenta) {
        CuentaBancaria cuenta = buscarPorId(idCuenta);
        if (cuenta != null) {
            cuenta.desactivar();
            System.out.println("Cuenta desactivada.");
        }
    }

    public void mostrarTodasLasCuentas() {
        if (cuentas.isEmpty()) {
            System.out.println("No hay cuentas registradas.");
            return;
        }

        for (CuentaBancaria c : cuentas) {
            mostrarCuenta(c);
        }
    }

    public void mostrarCuentasActivas() {
        for (CuentaBancaria c : cuentas) {
            if (c.isActiva()) {
                mostrarCuenta(c);
            }
        }
        System.out.println("No hay cuentas activas.");
    }

    public void mostrarCuentasInactivas() {
        for (CuentaBancaria c : cuentas) {
            if (!c.isActiva()) {
                mostrarCuenta(c);
            }
            System.out.println("No hay cuentas inactivas.");
        }
    }

    private void mostrarCuenta(CuentaBancaria c) {
        System.out.println("----------------------------");
        System.out.println("ID: " + c.getIdCuenta());
        System.out.println("Número: " + c.getNumeroCuenta());
        System.out.println("Titular: " + c.getTitular());
        System.out.println("Tipo: " + c.getTipoCuenta());
        System.out.println("Saldo: $" + c.getSaldo());
        System.out.println("Estado: " + (c.isActiva() ? "ACTIVA" : "INACTIVA"));
    }
}

    











 