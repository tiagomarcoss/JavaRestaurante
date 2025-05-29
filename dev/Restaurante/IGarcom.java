package dev.Restaurante;

import java.util.Scanner;

public interface IGarcom {
    void registrarPedido(Scanner sc);

    void listarPedidos();

    void alterarPedido(Scanner sc);

    void removerPedido(Scanner sc);

    Pedido buscarPedidoPorId(int id);
}
