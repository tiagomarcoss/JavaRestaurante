package dev.Restaurante;

import java.util.ArrayList;
import java.util.Arrays;

public class Cardapio {

    private ArrayList<Prato> pratos = new ArrayList<>();

    public Cardapio(Prato prato) {
        this.pratos.add(prato);
    }

    public Cardapio(Prato[] prato){
        this.pratos.addAll(Arrays.asList(prato));
    }

    public void AddPrato(Prato prato){
        this.pratos.add(prato);
    }

    public ArrayList<Prato> getPratos() {
        return pratos;
    }

}
