package dev.Restaurante;

public class Prato {
    private String nome;
    private String categoria;

    public Prato(String nome, String categoria) {
        this.nome = nome;
        this.categoria = categoria;
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

    @Override
    public String toString() {
        return nome + " | Categoria: " + categoria;
    }
}
