package dev.Restaurante;

import java.util.ArrayList;

public class Cardapio {
    private ArrayList<Prato> pratos = new ArrayList<>();

    public void adicionarPrato(Prato prato) {
        pratos.add(prato);
    }

    public ArrayList<Prato> getPratos() {
        return pratos;
    }
}
