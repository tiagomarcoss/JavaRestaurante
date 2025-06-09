package dev.Restaurante;

public class Prato {
    private String nome;
    private String categoria;
    private double preco;

    public Prato(String nome, String categoria, double preco) {
        this.nome = nome;
        this.categoria = categoria;
        this.preco = preco;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getNome() {
        return nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return nome + " | Categoria: " + categoria + " | Preço: R$" + String.format("%.2f", preco);
    }

}
