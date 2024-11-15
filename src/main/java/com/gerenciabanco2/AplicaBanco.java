package com.gerenciabanco2;

public class AplicaBanco {
    private Cliente cliente;
    private double cdb = 0.0;
    private double lci = 0.0;

    public AplicaBanco(Cliente cliente) {
        this.cliente = cliente;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getcdb() {
        return cdb;
    }

    public void setcdb(double cdb) {
        this.cdb = cdb;
    }

    public double getlci() {
        return lci;
    }

    public void setlci(double lci) {
        this.lci = lci;
    }
}
