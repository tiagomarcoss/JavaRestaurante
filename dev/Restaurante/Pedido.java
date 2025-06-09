package dev.Restaurante;

import java.util.ArrayList;

public class Pedido {
    private static int contadorId = 1;

    private int id;
    private Cliente cliente;
    private ArrayList<Prato> pratos;
    private String status;

    public Pedido(Cliente cliente) {
        this.id = contadorId++;
        this.cliente = cliente;
        this.pratos = new ArrayList<>();
        this.status = "Em preparação";
    }

    public void adicionarPrato(Prato prato) {
        pratos.add(prato);
    }

    public void removerPrato(Prato prato) {
        pratos.remove(prato);
    }

    public int getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public ArrayList<Prato> getPratos() {
        return pratos;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double calcularTotal() {
        double total = 0;
        for (Prato p : pratos) {
            total += p.getPreco();
        }
        return total;
    }

    @Override
    public String toString() {
        String nomesPratos = "";
        for (Prato p : pratos) {
            nomesPratos += p.getNome() + ", ";
        }
        return "Pedido #" + id +
                " | Cliente: " + cliente.getNome() +
                " | Pratos: " + nomesPratos +
                " | Status: " + status +
                " | Total: R$" + String.format("%.2f", calcularTotal());
    }
}
