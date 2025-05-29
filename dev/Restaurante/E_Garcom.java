package dev.Restaurante;

public class E_Garcom {
    public E_Garcom(int g) throws RuntimeException{
        if (g < 1 || g > 4) {
            throw new RuntimeException("\nFunção inválida.");
        }
    }
}
