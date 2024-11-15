package com.gerenciabanco2;

public class AplicaBanco {
    private Cliente cliente;
    private double aplicarCdb = 0.0;
    private double aplicarLci = 0.0;

    public AplicaBanco(Cliente cliente) {
        this.cliente = cliente;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getAplicarCdb() {
        return aplicarCdb;
    }

    public void setAplicarCdb(double aplicarCdb) {
        this.aplicarCdb = aplicarCdb;
    }

    public double getAplicarLci() {
        return aplicarLci;
    }

    public void setAplicarLci(double aplicarLci) {
        this.aplicarLci = aplicarLci;
    }
}
