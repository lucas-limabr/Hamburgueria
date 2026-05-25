package com.designPatterns.hamburgueria;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
public abstract class Carne extends Ingrediente{

    private String tipo;

    public Carne(String tipo, String descricao) {
        super(descricao);
        this.tipo = tipo;
    }
}
