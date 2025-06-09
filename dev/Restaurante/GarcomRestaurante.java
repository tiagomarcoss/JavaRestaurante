package dev.Restaurante;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GarcomRestaurante extends Garcom {

    public GarcomRestaurante(ArrayList<Cliente> clientes, Cardapio cardapio, ArrayList<Pedido> pedidos) {
        super(pedidos, clientes, cardapio);
    }

    @Override
    public void registrarPedido(Scanner sc) {
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
            return;
        }

        System.out.println("Selecione o cliente:");
        for (int i = 0; i < clientes.size(); i++) {
            System.out.println(i + " - " + clientes.get(i));
        }
        int idxCliente = sc.nextInt();
        sc.nextLine();

        if (idxCliente < 0 || idxCliente >= clientes.size()) {
            System.out.println("Índice inválido.");
            return;
        }

        Pedido pedido = new Pedido(clientes.get(idxCliente));

        boolean adicionando = true;
        while (adicionando) {
            System.out.println("Adicionar prato ao pedido:");
            ArrayList<Prato> pratos = cardapio.getPratos();
            for (int i = 0; i < pratos.size(); i++) {
                System.out.println(i + " - " + pratos.get(i));
            }

            System.out.print("Índice do prato (ou -1 para terminar): ");
            int idxPrato = sc.nextInt();
            sc.nextLine();

            if (idxPrato == -1) {
                adicionando = false;
            } else if (idxPrato >= 0 && idxPrato < pratos.size()) {
                Prato pratoSelecionado = pratos.get(idxPrato);
                System.out.print("Quantidade: ");
                int quantidade = sc.nextInt();
                sc.nextLine();

                pedido.adicionarItem(pratoSelecionado, quantidade);
            } else {
                System.out.println("Índice inválido.");
            }
        }

        pedidos.add(pedido);
        System.out.println("Pedido registrado com sucesso.");
    }

    @Override
    public void listarPedidos() {
        if (pedidos.isEmpty()) {
            System.out.println("Nenhum pedido registrado.");
            return;
        }

        for (Pedido p : pedidos) {
            System.out.println(p);
        }
    }

    @Override
    public void alterarPedido(Scanner sc) {
        listarPedidos();
        System.out.print("ID do pedido para alterar: ");
        int id = sc.nextInt();
        sc.nextLine();

        Pedido pedido = buscarPedidoPorId(id);
        if (pedido == null) {
            System.out.println("Pedido não encontrado.");
            return;
        }

        System.out.println("1 - Alterar status");
        System.out.println("2 - Adicionar prato");
        System.out.println("3 - Remover prato");
        int opcao = sc.nextInt();
        sc.nextLine();

        switch (opcao) {
            case 1:
                System.out.print("Novo status: ");
                String status = sc.nextLine();
                pedido.setStatus(status);
                System.out.println("Status atualizado.");
                break;
            case 2:
                ArrayList<Prato> pratos = cardapio.getPratos();
                for (int i = 0; i < pratos.size(); i++) {
                    System.out.println(i + " - " + pratos.get(i));
                }
                System.out.print("Índice do prato para adicionar: ");
                int idxAdicionar = sc.nextInt();
                sc.nextLine();

                if (idxAdicionar >= 0 && idxAdicionar < pratos.size()) {
                    System.out.print("Quantidade: ");
                    int qtdAdicionar = sc.nextInt();
                    sc.nextLine();
                    pedido.adicionarItem(pratos.get(idxAdicionar), qtdAdicionar);
                    System.out.println("Prato adicionado.");
                } else {
                    System.out.println("Índice inválido.");
                }
                break;
            case 3:
                List<ItemPedido> itens = pedido.getItens();
                for (int i = 0; i < itens.size(); i++) {
                    ItemPedido item = itens.get(i);
                    System.out.printf("%d - %s (x%d)%n", i, item.getPrato().getNome(), item.getQuantidade());
                }
                System.out.print("Índice do item para remover: ");
                int idxRemover = sc.nextInt();
                sc.nextLine();
                if (idxRemover >= 0 && idxRemover < itens.size()) {
                    pedido.removerItem(itens.get(idxRemover).getPrato());
                    System.out.println("Item removido.");
                } else {
                    System.out.println("Índice inválido.");
                }
                break;
            default:
                System.out.println("Opção inválida.");
        }
    }

    @Override
    public void removerPedido(Scanner sc) {
        listarPedidos();
        System.out.print("ID do pedido para remover: ");
        int id = sc.nextInt();
        sc.nextLine();

        Pedido pedido = buscarPedidoPorId(id);
        if (pedido != null) {
            pedidos.remove(pedido);
            System.out.println("Pedido removido.");
        } else {
            System.out.println("Pedido não encontrado.");
        }
    }

    @Override
    public Pedido buscarPedidoPorId(int id) {
        for (Pedido p : pedidos) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }
}
