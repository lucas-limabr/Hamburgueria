package com.designPatterns.hamburgueria;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

public class Pao extends Ingrediente {

    private String tipo;

    public Pao(String tipo, String descricao) {
        this.tipo = tipo;
        super(descricao);
    }
}
