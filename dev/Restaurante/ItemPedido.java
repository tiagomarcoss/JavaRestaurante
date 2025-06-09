package dev.Restaurante;

public class ItemPedido {
    private Prato prato;
    private int quantidade;

    public ItemPedido(Prato prato, int quantidade) {
        this.prato = prato;
        this.quantidade = quantidade;
    }

    public Prato getPrato() {
        return prato;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getSubtotal() {
        return prato.getPreco() * quantidade;
    }

    @Override
    public String toString() {
        return quantidade + "x " + prato.getNome() + " (" + prato.getCategoria() + ") - R$" + String.format("%.2f", getSubtotal());
    }
}
