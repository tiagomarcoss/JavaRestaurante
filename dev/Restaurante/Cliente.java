package dev.Restaurante;

import java.util.List;
import java.util.Scanner;

public abstract class Cliente implements ICliente {
    protected String nome;
    protected Cardapio cardapio;
    protected List<Pedido> pedidos;
    protected Scanner scanner;

    public Cliente(String nome, Cardapio cardapio, List<Pedido> pedidos) {
        this.nome = nome;
        this.cardapio = cardapio;
        this.pedidos = pedidos;
        this.scanner = new Scanner(System.in);
    }

    public abstract String getNome();

    public abstract void setNome(String nome);

    public abstract String toString();
}
