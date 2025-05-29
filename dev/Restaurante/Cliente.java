package dev.Restaurante;

import java.util.List;
import java.util.Scanner;

public class Cliente {
    private String nome;
    private Cardapio cardapio;
    private List<Pedido> pedidos;
    private Scanner scanner;

    public Cliente(String nome, Cardapio cardapio, List<Pedido> pedidos) {
        this.nome = nome;
        this.cardapio = cardapio;
        this.pedidos = pedidos;
        this.scanner = new Scanner(System.in);
    }

    public void iniciarAtendimento() {
        System.out.println("\nBem-vindo, " + nome + "!");

        int opcao;
        do {
            exibirMenu();
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    consultarCardapio();
                    break;
                case 2:
                    consultarStatusPedido();
                    break;
                case 0:
                    System.out.println("Retornando ao menu principal...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }

    private void exibirMenu() {
        System.out.println("\nMenu do Cliente:");
        System.out.println("1. Consultar cardápio");
        System.out.println("2. Consultar status do pedido");
        System.out.println("0. Voltar");
        System.out.print("Escolha uma opção: ");
    }

    private void consultarCardapio() {
        List<Prato> pratos = cardapio.getPratos();

        if (pratos.isEmpty()) {
            System.out.println("\nCardápio vazio no momento.");
            return;
        }

        System.out.println("\n=== CARDÁPIO ===");
        System.out.println("----------------------------------");
        System.out.printf("%-25s | %-15s%n", "PRATO", "CATEGORIA");
        System.out.println("----------------------------------");

        for (Prato prato : pratos) {
            System.out.printf("%-25s | %-15s%n",
                    prato.getNome(),
                    prato.getCategoria());
        }
        System.out.println("----------------------------------");
    }

    private void consultarStatusPedido() {
        if (pedidos.isEmpty()) {
            System.out.println("\nNão há pedidos registrados.");
            return;
        }

        System.out.print("\nDigite o ID do pedido: ");
        int idPedido = scanner.nextInt();
        scanner.nextLine();

        Pedido pedidoEncontrado = null;
        for (Pedido pedido : pedidos) {
            if (pedido.getId() == idPedido) {
                pedidoEncontrado = pedido;
                break;
            }
        }

        if (pedidoEncontrado != null) {
            exibirStatusPedido(pedidoEncontrado);
        } else {
            System.out.println("Pedido não encontrado.");
        }
    }

    private void exibirStatusPedido(Pedido pedido) {
        System.out.println("\n=== DETALHES DO PEDIDO ===");
        System.out.println("ID: #" + pedido.getId());
        System.out.println("Cliente: " + pedido.getCliente().getNome());
        System.out.println("Status: " + pedido.getStatus());

        System.out.println("\nItens:");
        System.out.println("-----------------------------");
        for (Prato prato : pedido.getPratos()) {
            System.out.println("- " + prato.getNome() + " (" + prato.getCategoria() + ")");
        }
        System.out.println("-----------------------------");
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public String toString() {
        return nome;
    }
}