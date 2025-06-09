package dev.Restaurante;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private static int contadorId = 1;

    private int id;
    private Cliente cliente;
    private List<ItemPedido> itens;
    private String status;

    public Pedido(Cliente cliente) {
        this.id = contadorId++;
        this.cliente = cliente;
        this.itens = new ArrayList<>();
        this.status = "Em preparação";
    }

    public void adicionarItem(Prato prato, int quantidade) {
        for (ItemPedido item : itens) {
            if (item.getPrato().equals(prato)) {
                item.setQuantidade(item.getQuantidade() + quantidade);
                return;
            }
        }
        itens.add(new ItemPedido(prato, quantidade));
    }

    public void removerItem(Prato prato) {
        itens.removeIf(item -> item.getPrato().equals(prato));
    }

    public int getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double calcularTotal() {
        double total = 0;
        for (ItemPedido item : itens) {
            total += item.getSubtotal();
        }
        return total;
    }

    @Override
    public String toString() {
        StringBuilder nomesPratos = new StringBuilder();
        for (ItemPedido item : itens) {
            nomesPratos.append(item.getQuantidade()).append("x ")
                    .append(item.getPrato().getNome()).append(", ");
        }
        return "Pedido #" + id +
                " | Cliente: " + cliente.getNome() +
                " | Pratos: " + nomesPratos +
                " | Status: " + status +
                " | Total: R$" + String.format("%.2f", calcularTotal());
    }
}
