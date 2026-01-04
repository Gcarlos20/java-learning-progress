package models;

public class CuentaBancaria {

    private int idCuenta;
    private String numeroCuenta;
    private String titular;
    private String tipoCuenta;
    private double saldo;
    private boolean activa;

    public CuentaBancaria(int idCuenta, String numeroCuenta, String titular, String tipoCuenta, double saldoInicial) {
        this.idCuenta = idCuenta;
        this.numeroCuenta = numeroCuenta;
        this.titular = titular;
        this.tipoCuenta = tipoCuenta;
        this.saldo = saldoInicial;
        this.activa = true;
    }

    // Getters
    public int getIdCuenta() {
        return idCuenta;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public String getTitular() {
        return titular;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public boolean isActiva() {
        return activa;
    }

    // bloque de operaciones de la cuenta bancaria
     public void eleminar() {
        this.activa = false;
        this.saldo = 0;
    }
    public boolean depositar(double monto) {
        if (!activa || monto <= 0) return false;
        saldo += monto;
        return true;
    }

    public boolean retirar(double monto) {
        if (!activa || monto <= 0 || saldo < monto) return false;
        saldo -= monto;
        return true;
    }

    public void activar() {
        activa = true;
    }

    public void desactivar() {
        activa = false;
    }
}

