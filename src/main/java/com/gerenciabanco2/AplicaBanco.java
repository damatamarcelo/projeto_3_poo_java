package com.gerenciabanco2;

import java.util.Scanner;

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

    public void aplicarCdb(double valor, int prazoAplicacao) {
        double taxaAplicAno = 1.1; // 10% aa
        double taxaAplicPeriodo = taxaAplicAno / prazoAplicacao;
        double totalAplic = valor * taxaAplicPeriodo;
        setcdb(totalAplic);
        double rendAplic = totalAplic - valor;

        System.out.println("\nValor a ser applicado R$ " + String.format("%.2f", valor));
        System.out.println("\nPeríodo da aplicação: " + prazoAplicacao + "meses");
        System.out.println(
                "\nValor bruto dos rendimentos (Impostos não aplicados R$ )" + String.format("%.2f", rendAplic));
        System.out.println("\nSua aplicação foi realizada com sucesso");

    }

    public void aplicarLci(double valor, int prazoAplicacao) {
        double taxaAplicAno = 0.08; // 8% aa
        double valorAplicado = ((taxaAplicAno / prazoAplicacao) * valor);
        setlci(valorAplicado);
    }

    public void opcoesInvest() {
        try (Scanner input = new Scanner(System.in)) {
            int opcao;

            do {
                System.out.println("----------Seja Bem Vindo!----------");
                System.out.println("-----Selecione a opção desejada----");
                System.out.println("|----1 - Investir em CDB----------|");
                System.out.println("|----2 - Investir em LCI----------|");
                System.out.println("|----3 - Sair---------------------|");

                opcao = input.nextInt();

                switch (opcao) {
                    case 1:
                        System.out.println("Informe o valor que deseja aplicar R$ ");
                        double valorAplic = input.nextDouble();
                        System.out.println("Informe o período que deseja investir em meses: ");
                        int prazoAplic = input.nextInt();
                        aplicarCdb(valorAplic, prazoAplic);
                        break;

                    default:
                        break;
                }

            } while (opcao != 3);
        }
    }
}
