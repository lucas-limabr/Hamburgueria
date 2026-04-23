package com.designPatterns.hamburgueria;

import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
public class ComboBigFactory extends Combo {

    public ComboBigFactory(boolean ativo, PromocaoCombo promocaoCombo)
    {
        super(ativo, promocaoCombo);
    }

    @Override
    public Carne definirCarne(String tipo, String ponto, String descricao) {
        return new Carne(tipo, ponto, descricao);
    }

    @Override
    public Queijo definirQueijo(String tipo, String descricao) {
        return new Queijo(tipo, descricao);
    }

    @Override
    public Pao definirPao(String tipo, String descricao) {
        return new Pao(tipo, descricao);
    }

    @Override
    public Salada definirSalada(String descricao) {
        return new Salada(descricao);
    }

    @Override
    public Presunto definirAdicional(Produto produto) {
        return new Presunto(produto, "Presunto", new BigDecimal("4.00"));
    }
}
