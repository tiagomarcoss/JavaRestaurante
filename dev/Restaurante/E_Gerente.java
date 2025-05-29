package dev.Restaurante;

public class E_Gerente {
    public E_Gerente(int g) throws RuntimeException{
        if (g < 1 || g > 11) {
            throw new RuntimeException("\nFunção inválida.");
        }
    }
}