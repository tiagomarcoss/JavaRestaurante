package dev.Restaurante;

import java.util.ArrayList;

public class Cliente {

    private Cardapio consultaCardapio;
    //private ArrayList<Prato> pedidos;

    public Cliente(Cardapio cardapio) {
        this.consultaCardapio = cardapio;
    }

    public void GetPratoIndex(int i){
        System.out.println(this.consultaCardapio.getPratos().get(i));
    }
}
