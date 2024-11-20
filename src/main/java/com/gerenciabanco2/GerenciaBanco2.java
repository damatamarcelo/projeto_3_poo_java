package com.gerenciabanco2;

import java.util.Scanner;

public class GerenciaBanco2 {
    static Scanner input = new Scanner(System.in);

    public void MenuOpcoes() {
        try (Scanner input = new Scanner(System.in)) {
            int opcao;

            do {
                System.out.println("----------Seja Bem Vindo!----------");
                System.out.println("-----Selecione a opção desejada----");
                System.out.println("|----1 - Transações comuns--------|");
                System.out.println("|----2 - Investimentos------------|");
                System.out.println("|----3 - Sair---------------------|");

                opcao = input.nextInt();

                switch (opcao) {
                    case 1:
                        System.out.println("Informe o nome do Cliente: ");
                        String nomeCliente = input.nextLine();

                        System.out.println("Informe o sobrenome do Cliente: ");
                        String sobrenomeCliente = input.nextLine();

                        System.out.println("Informe o CPF do Cliente: ");
                        String cpfCliente = input.nextLine();

                        Cliente cliente = new Cliente(nomeCliente, sobrenomeCliente, cpfCliente);
                        ContaBanco conta = new ContaBanco(cliente);

                        System.out.println(conta.toString());
                        conta.opcoes();
                        break;
                    case 2:

                        break;
                    case 3:

                        break;
                    default:
                        break;
                }

            } while (opcao != 3);
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        
    }
}
