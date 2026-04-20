package com.designPatterns.hamburgueria;

public class Queijo extends Ingrediente {

    private String tipo;

    public Queijo(String tipo, String descricao) {
        super(descricao);
        this.tipo = tipo;
    }
}
