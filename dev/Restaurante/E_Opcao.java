package dev.Restaurante;

public class E_Opcao {
    public E_Opcao(int o) throws RuntimeException{
        if (o < 0 || o > 3) {
            throw new RuntimeException("\nOpção inválida.");
        }
    }
}