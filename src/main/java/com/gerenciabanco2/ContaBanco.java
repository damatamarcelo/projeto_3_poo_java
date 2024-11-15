package com.gerenciabanco2;

public class ContaBanco {
    private Cliente cliente;
    private double saldo = 0.0;

    public ContaBanco(Cliente cliente) {
        this.cliente = cliente;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void depositar(double valor) {
        if (valor > 0) {
            setSaldo(getSaldo() + valor);
            System.out.println(
                    "Seu depósito no valor de R$ " + String.format("%.2f", valor) + " foi realizado com sucesso!");
        } else {
            System.out.println("Operação não realizada! Tente novamente.");
        }
    }

    public void sacar(double valor) {
        if (valor > 0 && getSaldo() >= valor) {
            setSaldo(getSaldo() - valor);
            System.out
                    .println("Seu saque no valor de R$ " + String.format("%.2f", valor) + " foi realizado com sucesso!");
        } else {
            System.out.println("Operação não realizada. Saldo insuficiente.");
        }
    }

    public double consutarSaldo() {
        return saldo;
    }
}
