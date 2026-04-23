package com.designPatterns.hamburgueria;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
public abstract class Pao extends Ingrediente {

    private String tipo;

    public Pao(String tipo, String descricao) {
        this.tipo = tipo;
        super(descricao);
    }
}
