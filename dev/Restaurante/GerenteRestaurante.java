package dev.Restaurante;

import java.util.ArrayList;

public class GerenteRestaurante extends Gerente {

    public GerenteRestaurante(Cardapio cardapio, ArrayList<Pedido> pedidos) {
        super(cardapio, pedidos);
    }

    // Pratos
    @Override
    public void cadastrarPrato(String nome, String categoria, double preco) {
        Prato novoPrato = new Prato(nome, categoria, preco);
        cardapio.adicionarPrato(novoPrato);
        System.out.println("Prato cadastrado com sucesso.");
    }

    @Override
    public void listarPratos() {
        ArrayList<Prato> pratos = cardapio.getPratos();
        for (int i = 0; i < pratos.size(); i++) {
            System.out.println(i + " - " + pratos.get(i));
        }
    }

    @Override
    public void editarPrato(int indice, String novoNome, String novaCategoria, double novoPreco) {
        ArrayList<Prato> pratos = cardapio.getPratos();
        if (indice >= 0 && indice < pratos.size()) {
            Prato prato = pratos.get(indice);
            prato.setNome(novoNome);
            prato.setCategoria(novaCategoria);
            prato.setPreco(novoPreco);
            System.out.println("Prato editado com sucesso.");
        } else {
            System.out.println("Índice inválido.");
        }
    }

    @Override
    public void removerPrato(int index) {
        if (index >= 0 && index < cardapio.getPratos().size()) {
            cardapio.getPratos().remove(index);
            System.out.println("Prato removido.");
        } else {
            System.out.println("Índice inválido.");
        }
    }

    // Clientes
    @Override
    public void cadastrarCliente(String nome) {
        Cliente cliente = new ClienteRestaurante(nome, cardapio, pedidos); // agora é a mesma lista!
        clientes.add(cliente);
        System.out.println("Cliente cadastrado.");
    }

    @Override
    public void listarClientes() {
        for (int i = 0; i < clientes.size(); i++) {
            System.out.println(i + " - " + clientes.get(i));
        }
    }

    @Override
    public void editarCliente(int index, String novoNome) {
        if (index >= 0 && index < clientes.size()) {
            clientes.get(index).setNome(novoNome);
            System.out.println("Cliente atualizado.");
        } else {
            System.out.println("Índice inválido.");
        }
    }

    @Override
    public void removerCliente(int index) {
        if (index >= 0 && index < clientes.size()) {
            clientes.remove(index);
            System.out.println("Cliente removido.");
        } else {
            System.out.println("Índice inválido.");
        }
    }

    @Override
    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    // Filtros
    @Override
    public void listarPratosPorCategoria(String categoria) {
        boolean encontrado = false;
        for (Prato prato : cardapio.getPratos()) {
            if (prato.getCategoria().equalsIgnoreCase(categoria)) {
                System.out.println(prato);
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("Nenhum prato encontrado para a categoria: " + categoria);
        }
    }

    @Override
    public void listarPedidosPorStatus(String status) {
        boolean encontrado = false;
        for (Pedido pedido : pedidos) {
            if (pedido.getStatus().equalsIgnoreCase(status)) {
                System.out.println(pedido);
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("Nenhum pedido encontrado com status: " + status);
        }
    }

    @Override
    public void listarPedidosPorCliente(String nomeCliente) {
        boolean encontrado = false;
        for (Pedido pedido : pedidos) {
            if (pedido.getCliente().getNome().equalsIgnoreCase(nomeCliente)) {
                System.out.println(pedido);
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("Nenhum pedido encontrado para o cliente: " + nomeCliente);
        }
    }
}
