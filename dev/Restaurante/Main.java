package dev.Restaurante;

public class Main {
    public static void main(String[] args) {
        Cardapio cardapioRestaurante = new Cardapio(new Prato("Sushi"));
        Cliente daniel = new Cliente(cardapioRestaurante);

        daniel.GetPratoIndex(0);
    }
}
