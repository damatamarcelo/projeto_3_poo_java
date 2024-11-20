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

    public void aplicarCdb(double valorAplic, int prazoAplic) {
        double taxaJurosAno = 0.10; // Taxa de 10% ao ano
        double taxaJurosMes = taxaJurosAno / 12; // Conversão para taxa mensal

        if (valorAplic > 0) {
            double montante = valorAplic * Math.pow(1 + taxaJurosMes, prazoAplic);

            double rendBruto = montante - valorAplic;

            setcdb(montante);

            System.out.println(
                    "Valor apurado no período R$: " + String.format("%.2f", montante) + " | Período investido: "
                            + prazoAplic + "meses");
            System.out.println(
                    "Rendimento bruto obtidos no período (Impostos não aplicados) R$: "
                            + String.format("%.2f", rendBruto));
        } else {
            System.out.println("Valor inválido! Tente novamente.");
        }
    }

    public void aplicarLci(double valorAplic, int prazoAplic) {
        double taxaJurosAno = 0.08; // Taxa de 8% ao ano
        double taxaJurosMes = taxaJurosAno / 12; // Conversão para taxa mensal

        if (valorAplic > 0 && prazoAplic >= 9) {
            double montante = valorAplic * Math.pow(1 + taxaJurosMes, prazoAplic);

            double rendBruto = montante - valorAplic;

            setlci(montante);

            System.out.println(
                    "Valor apurado no período R$: " + String.format("%.2f", montante) + " | Período investido: "
                            + prazoAplic + "meses");
            System.out.println(
                    "Rendimento bruto obtidos no período (Impostos não aplicados) R$: "
                            + String.format("%.2f", rendBruto));
        } else {
            System.out.println("Informe um período igual ou superior a 9 meses.");
        }
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
                        double valorAplicCdb = input.nextDouble();
                        System.out.println("Informe o período que deseja investir em meses: ");
                        int prazoAplicCdb = input.nextInt();
                        aplicarCdb(valorAplicCdb, prazoAplicCdb);
                        break;
                    case 2:
                        System.out.println("Informe o valor que deseja aplicar R$ ");
                        double valorAplicLci = input.nextDouble();
                        System.out
                                .println("Informe o período que deseja investir em meses (Período mínimo - 9 meses): ");
                        int prazoAplicLci = input.nextInt();
                        aplicarLci(valorAplicLci, prazoAplicLci);
                        break;
                    case 3:
                        System.out.println("Obrigado por utilizar nossos serviços!");
                        break;
                    default:
                        System.out.println("Opção inválida! Tente novamente");
                        opcoesInvest();
                }

            } while (opcao != 3);
            System.exit(0);
        }
    }
}
