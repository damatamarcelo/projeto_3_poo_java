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
    
        public static void MenuOpcoes() {
            try (Scanner input = new Scanner(System.in)) {
                int opcao;
    
                do {
                    System.out.println("----------Seja Bem Vindo!----------");
                    System.out.println("-----Selecione a opção desejada----");
                    System.out.println("|----1 - Transações comuns--------|");
                    System.out.println("|----2 - Investimentos------------|");
    
                    opcao = input.nextInt();
                    input.nextLine();
    
                    Cliente cliente = ObterDadosClientes();

                switch (opcao) {
                    case 1:
                        ContaBanco conta = new ContaBanco(cliente);
                        System.out.println(conta.toString());
                        conta.opcoes();
                        break;
                    case 2:
                        AplicaBanco investimento = new AplicaBanco(cliente);
                        System.out.println(cliente.toString());
                        investimento.opcoesInvest();
                        break;
                    default:
                        System.out.println("Opção inválida! Tente novamente");
                        MenuOpcoes();
                }
            } while (opcao != 2);
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        MenuOpcoes();
    }
}
