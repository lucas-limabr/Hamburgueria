package com.designPatterns.hamburgueria;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
public class Carne extends Ingrediente{

    private String tipo;
    private String ponto;

    public Carne(String tipo, String ponto, String descricao) {
        super(descricao);
        this.tipo = tipo;
        this.ponto = ponto;
    }
}
