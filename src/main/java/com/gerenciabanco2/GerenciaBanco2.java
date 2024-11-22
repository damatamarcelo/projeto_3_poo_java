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
    }

    public static void MenuOpcoes() {
        try (Scanner input = new Scanner(System.in)) {
            int opcao = -1;

            do {
                mostrarMenu();
                System.out.println("Escolha uma opção: ");

                if (input.hasNextInt()) {
                    opcao = input.nextInt();
                    input.nextLine();
                } else {
                    System.out.println("Entrada inválida! Digite um número.");
                    input.nextLine();
                    continue;
                }

                switch (opcao) {
                    case 1:
                        Cliente clienteConta = ObterDadosClientes();
                        ContaBanco conta = new ContaBanco(clienteConta);
                        System.out.println(conta.toString());
                        conta.opcoes();
                        break;
                    case 2:
                        Cliente clienteInv = ObterDadosClientes();
                        AplicaBanco investimento = new AplicaBanco(clienteInv);
                        System.out.println(clienteInv.toString());
                        investimento.opcoesInvest();
                        break;
                    case 0:
                        System.out.println("Saindo do sistema...");
                        break;
                    default:
                        System.out.println("Opção inválida! Tente novamente");
                }
            } while (opcao != 0);
        }
        System.exit(0);
    }

    public static void main(String[] args) {
        MenuOpcoes();
    }
}
