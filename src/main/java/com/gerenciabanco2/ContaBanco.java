package com.gerenciabanco2;

import java.util.Scanner;

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
                    .println(
                            "Seu saque no valor de R$ " + String.format("%.2f", valor) + " foi realizado com sucesso!");
        } else {
            System.out.println("Operação não realizada. Saldo insuficiente.");
        }
    }

    public double consutarSaldo() {
        return saldo;
    }

    public static void mostrarMenu() {
        System.out.println("-----Selecione a opção desejada----");
        System.out.println("|----1 - Realizar Depósito--------|");
        System.out.println("|----2 - Realizar Saque-----------|");
        System.out.println("|----3 - Consultar Saldo----------|");
        System.out.println("|----4 - Sair---------------------|");
    }

    public void opcoes() {
        try (Scanner input = new Scanner(System.in)) {
            int opcao;

            do {
                ContaBanco.mostrarMenu();

                opcao = input.nextInt();

                switch (opcao) {
                    case 1:
                        System.out.println("Informe o valor do Depósito R$: ");
                        double valorDeposito = input.nextDouble();
                        depositar(valorDeposito);
                        break;
                    case 2:
                        System.out.println("Informe o valor do Saque R$: ");
                        double valorSaque = input.nextDouble();
                        sacar(valorSaque);
                        break;
                    case 3:
                        System.out.println("Seu saldo é de R$ " + String.format("%.2f", consutarSaldo()));
                        break;
                    case 4:
                        System.out.println("Obrigadi oir utilizar nossos serviços");
                        break;
                    default:
                        System.out.println("Opção inválida! Tente novamente");
                        mostrarMenu();
                }
            } while (opcao != 4);
            System.exit(0);
        }
    }
}
