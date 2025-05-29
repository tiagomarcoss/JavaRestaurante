package dev.Restaurante;

public interface IGerente {
    // Pratos
    void cadastrarPrato(String nome, String categoria);

    void listarPratos();

    void editarPrato(int index, String novoNome, String novaCategoria);

    void removerPrato(int index);

    // Clientes
    void cadastrarCliente(String nome);

    void listarClientes();

    void editarCliente(int index, String novoNome);

    void removerCliente(int index);

    // Filtros
    void listarPratosPorCategoria(String categoria);

    void listarPedidosPorStatus(String status);

    void listarPedidosPorCliente(String nomeCliente);
}
