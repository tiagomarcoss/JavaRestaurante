package dev.Restaurante;

public interface ICliente {
    void iniciarAtendimento();

    void exibirMenu();

    void consultarCardapio();

    void consultarStatusPedido();

    void exibirStatusPedido(Pedido pedido);
}
