package com.gerenciabanco2;

import java.util.Scanner;

public class GerenciaBanco2 {
    static Scanner input = new Scanner(System.in);

    public static Cliente ObterDadosClientes() {
        System.out.println("Informe o nome do Cliente: ");
        String nomeCliente = input.nextLine();

        System.out.println("Informe o sobrenome do Cliente: ");
        String sobrenomeCliente = input.nextLine();

        System.out.println("Informe o CPF do Cliente: ");
        String cpfCliente = input.nextLine();

        return new Cliente(nomeCliente, sobrenomeCliente, cpfCliente);
    }

    public static void mostrarMenu() {
        System.out.println("----------Seja Bem Vindo!----------");
        System.out.println("-----Selecione a opção desejada----");
        System.out.println("|----1 - Transações comuns--------|");
        System.out.println("|----2 - Investimentos------------|");
        System.out.println("|----3 - Sair---------------------|");
    }

    public static void MenuOpcoes() {
        int opcao;

        do {
            while (!input.hasNextInt()) {
                System.out.println("Opção inválida. Por favor, digite um número inteiro.");
                input.next();
            }

            mostrarMenu();

            opcao = input.nextInt();

            Cliente cliente = ObterDadosClientes();

            switch (opcao) {
                case 1:
                    ContaBanco conta = new ContaBanco(cliente);
                    System.out.println(conta.toString());
                    conta.opcoes();
                    mostrarMenu();
                case 2:
                    AplicaBanco investimento = new AplicaBanco(cliente);
                    System.out.println(cliente.toString());
                    investimento.opcoesInvest();
                    mostrarMenu();
                case 3:
                    System.out.println("Obrigado por utilizar nossos serviços!");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente");
                    mostrarMenu();
            }
        } while (opcao != 3);
        System.exit(0);
    }

    public static void main(String[] args) {
        MenuOpcoes();
    }
}
