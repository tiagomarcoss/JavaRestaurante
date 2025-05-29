package dev.Restaurante;

import java.util.ArrayList;

public abstract class Garcom implements IGarcom {
    protected ArrayList<Pedido> pedidos;
    protected ArrayList<Cliente> clientes;
    protected Cardapio cardapio;

    public Garcom(ArrayList<Pedido> pedidos, ArrayList<Cliente> clientes, Cardapio cardapio) {
        this.pedidos = pedidos;
        this.clientes = clientes;
        this.cardapio = cardapio;
    }

}
