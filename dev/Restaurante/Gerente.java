package dev.Restaurante;

import java.util.ArrayList;

public class Gerente {
    private Cardapio cardapio;
    private ArrayList<Cliente> clientes;

    public Gerente(Cardapio cardapio) {
        this.cardapio = cardapio;
        this.clientes = new ArrayList<>();
    }

    // Pratos
    public void cadastrarPrato(String nome, String categoria) {
        Prato prato = new Prato(nome, categoria);
        cardapio.adicionarPrato(prato);
        System.out.println("Prato cadastrado.");
    }

    public void listarPratos() {
        ArrayList<Prato> pratos = cardapio.getPratos();
        for (int i = 0; i < pratos.size(); i++) {
            System.out.println(i + " - " + pratos.get(i));
        }
    }

    public void editarPrato(int index, String novoNome, String novaCategoria) {
        if (index >= 0 && index < cardapio.getPratos().size()) {
            Prato prato = cardapio.getPratos().get(index);
            prato.setNome(novoNome);
            prato.setCategoria(novaCategoria);
            System.out.println("Prato atualizado.");
        } else {
            System.out.println("Índice inválido.");
        }
    }

    public void removerPrato(int index) {
        if (index >= 0 && index < cardapio.getPratos().size()) {
            cardapio.getPratos().remove(index);
            System.out.println("Prato removido.");
        } else {
            System.out.println("Índice inválido.");
        }
    }

    // Clientes
    public void cadastrarCliente(String nome) {
        Cliente cliente = new Cliente(nome, cardapio, new ArrayList<Pedido>());
        clientes.add(cliente);
        System.out.println("Cliente cadastrado.");
    }

    public void listarClientes() {
        for (int i = 0; i < clientes.size(); i++) {
            System.out.println(i + " - " + clientes.get(i));
        }
    }

    public void editarCliente(int index, String novoNome) {
        if (index >= 0 && index < clientes.size()) {
            clientes.get(index).setNome(novoNome);
            System.out.println("Cliente atualizado.");
        } else {
            System.out.println("Índice inválido.");
        }
    }

    public void removerCliente(int index) {
        if (index >= 0 && index < clientes.size()) {
            clientes.remove(index);
            System.out.println("Cliente removido.");
        } else {
            System.out.println("Índice inválido.");
        }
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }
}
