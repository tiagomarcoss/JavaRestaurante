package dev.Restaurante;

import java.util.ArrayList;
import java.util.List;

public class ClienteRestaurante extends Cliente {

    public ClienteRestaurante(String nome, Cardapio cardapio, List<Pedido> pedidos) {
        super(nome, cardapio, pedidos);
    }

    @Override
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

    @Override
    public void exibirMenu() {
        System.out.println("\nMenu do Cliente:");
        System.out.println("1. Consultar cardápio");
        System.out.println("2. Consultar status do pedido");
        System.out.println("0. Voltar");
        System.out.print("Escolha uma opção: ");
    }

    @Override
    public void consultarCardapio() {
        List<Prato> pratos = cardapio.getPratos();

        if (pratos.isEmpty()) {
            System.out.println("\nCardápio vazio no momento.");
            return;
        }

        System.out.println("\n=== CARDÁPIO ===");
        System.out.println("-----------------------------------------------------------");
        System.out.printf("%-25s | %-15s | %-8s%n", "PRATO", "CATEGORIA", "PREÇO");
        System.out.println("-----------------------------------------------------------");

        for (Prato prato : pratos) {
            System.out.printf("%-25s | %-15s | R$ %-6.2f%n",
                    prato.getNome(),
                    prato.getCategoria(),
                    prato.getPreco());
        }
        System.out.println("-----------------------------------------------------------");
    }

    @Override
    public void consultarStatusPedido() {
        List<Pedido> pedidosCliente = new ArrayList<>();
        for (Pedido pedido : pedidos) {
            if (pedido.getCliente().equals(this)) {
                pedidosCliente.add(pedido);
            }
        }

        if (pedidosCliente.isEmpty()) {
            System.out.println("\nVocê ainda não fez nenhum pedido.");
            return;
        }

        System.out.println("\n=== SEUS PEDIDOS ===");
        for (Pedido pedido : pedidosCliente) {
            System.out.println("Pedido ID: #" + pedido.getId() + " | Status: " + pedido.getStatus());
        }

        System.out.print("\nDigite o ID do pedido que deseja visualizar: ");
        int idSelecionado = scanner.nextInt();
        scanner.nextLine();

        Pedido pedidoSelecionado = null;
        for (Pedido pedido : pedidosCliente) {
            if (pedido.getId() == idSelecionado) {
                pedidoSelecionado = pedido;
                break;
            }
        }

        if (pedidoSelecionado != null) {
            exibirStatusPedido(pedidoSelecionado);
        } else {
            System.out.println("Pedido não encontrado.");
        }
    }

    @Override
    public void exibirStatusPedido(Pedido pedido) {
        System.out.println("\n=== DETALHES DO PEDIDO ===");
        System.out.println("ID: #" + pedido.getId());
        System.out.println("Cliente: " + pedido.getCliente().getNome());
        System.out.println("Status: " + pedido.getStatus());

        System.out.println("\nItens:");
        System.out.println("---------------------------------------------");
        double total = 0.0;
        for (ItemPedido item : pedido.getItens()) {
            double subtotal = item.getSubtotal();
            System.out.printf("- %-25s x%d | R$ %.2f%n",
                    item.getPrato().getNome(),
                    item.getQuantidade(),
                    subtotal);
            total += subtotal;
        }
        System.out.println("---------------------------------------------");
        System.out.printf("Total: R$ %.2f%n", total);
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return nome;
    }
}
