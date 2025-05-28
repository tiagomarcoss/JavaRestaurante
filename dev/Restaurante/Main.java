package dev.Restaurante;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Cardapio cardapio = new Cardapio();
        Gerente gerente = new Gerente(cardapio);
        Garcom garcom = new Garcom(gerente.getClientes(), cardapio);

        System.out.println("Você é:\n1 - Gerente\n2 - Garçom\n3 - Cliente");
        int opcao = sc.nextInt();
        sc.nextLine();

        switch (opcao) {
            case 1:
                menuGerente(gerente, sc);
                break;
            case 2:
                menuGarcom(garcom, sc);
                break;
            case 3:
                System.out.println("Cliente ainda não implementado.");
                break;
            default:
                System.out.println("Opção inválida.");
        }

        sc.close();
    }

    public static void menuGerente(Gerente gerente, Scanner sc) {
        int opcao = -1;

        while (opcao != 9) {
            System.out.println("\nMenu do Gerente:");
            System.out.println("1 - Cadastrar prato");
            System.out.println("2 - Ver pratos");
            System.out.println("3 - Editar prato");
            System.out.println("4 - Remover prato");
            System.out.println("5 - Cadastrar cliente");
            System.out.println("6 - Ver clientes");
            System.out.println("7 - Editar cliente");
            System.out.println("8 - Remover cliente");
            System.out.println("9 - Sair");

            opcao = sc.nextInt();
            sc.nextLine(); // limpar buffer

            switch (opcao) {
                case 1:
                    System.out.print("Nome do prato: ");
                    String nomePrato = sc.nextLine();
                    System.out.print("Categoria: ");
                    String categoria = sc.nextLine();
                    gerente.cadastrarPrato(nomePrato, categoria);
                    break;
                case 2:
                    gerente.listarPratos();
                    break;
                case 3:
                    gerente.listarPratos();
                    System.out.print("Índice do prato para editar: ");
                    int idxPrato = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Novo nome: ");
                    String novoNome = sc.nextLine();
                    System.out.print("Nova categoria: ");
                    String novaCat = sc.nextLine();
                    gerente.editarPrato(idxPrato, novoNome, novaCat);
                    break;
                case 4:
                    gerente.listarPratos();
                    System.out.print("Índice do prato para remover: ");
                    int idxRemoverPrato = sc.nextInt();
                    gerente.removerPrato(idxRemoverPrato);
                    break;
                case 5:
                    System.out.print("Nome do cliente: ");
                    String nomeCliente = sc.nextLine();
                    gerente.cadastrarCliente(nomeCliente);
                    break;
                case 6:
                    gerente.listarClientes();
                    break;
                case 7:
                    gerente.listarClientes();
                    System.out.print("Índice do cliente para editar: ");
                    int idxCliente = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Novo nome: ");
                    String novoNomeCliente = sc.nextLine();
                    gerente.editarCliente(idxCliente, novoNomeCliente);
                    break;
                case 8:
                    gerente.listarClientes();
                    System.out.print("Índice do cliente para remover: ");
                    int idxRemoverCliente = sc.nextInt();
                    gerente.removerCliente(idxRemoverCliente);
                    break;
                case 9:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    public static void menuGarcom(Garcom garcom, Scanner sc) {
        int opcao = -1;

        while (opcao != 4) {
            System.out.println("\nMenu do Garçom:");
            System.out.println("1 - Registrar pedido");
            System.out.println("2 - Alterar pedido");
            System.out.println("3 - Remover pedido");
            System.out.println("4 - Voltar");

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    garcom.registrarPedido(sc);
                    break;
                case 2:
                    garcom.alterarPedido(sc);
                    break;
                case 3:
                    garcom.removerPedido(sc);
                    break;
                case 4:
                    System.out.println("Voltando ao menu principal...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}
