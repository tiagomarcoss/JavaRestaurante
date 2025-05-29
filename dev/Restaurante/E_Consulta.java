package dev.Restaurante;

public class E_Consulta {
    public E_Consulta(int c) throws RuntimeException{
        if (c < 0 || c > 2) {
            throw new RuntimeException("\nOpção inválida.");
        }
    }
}
