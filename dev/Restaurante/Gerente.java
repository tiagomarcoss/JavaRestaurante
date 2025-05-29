package dev.Restaurante;

import java.util.ArrayList;

public abstract class Gerente implements IGerente {
    protected Cardapio cardapio;
    protected ArrayList<Cliente> clientes;
    protected ArrayList<Pedido> pedidos;

    public Gerente(Cardapio cardapio, ArrayList<Pedido> pedidos) {
        this.cardapio = cardapio;
        this.clientes = new ArrayList<>();
        this.pedidos = pedidos;
    }

    public abstract ArrayList<Cliente> getClientes();

    public Cardapio getCardapio() {
        return cardapio;
    }

    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }
}
