package com.designPatterns.hamburgueria;

import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
public class ComboFridayFactory extends Combo{
    @Override
    public Ingrediente definirCarne(String tipo, String ponto, String descricao) {
        return new Carne(tipo, ponto, descricao);
    }

    @Override
    public Ingrediente definirQueijo(String tipo, String descricao) {
        return new Queijo(tipo, descricao);
    }

    @Override
    public Ingrediente definirPao(String tipo, String descricao) {
        return new Pao(tipo, descricao);
    }

    @Override
    public Ingrediente definirSalada(String descricao) {
        return new Salada(descricao);
    }

    @Override
    public Adicional definirAdicional(Produto produto) {
        return new Bacon(produto, "Bacon", new BigDecimal("5.00"));
    }
}
