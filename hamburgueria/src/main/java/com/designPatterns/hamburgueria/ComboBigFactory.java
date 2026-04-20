package com.designPatterns.hamburgueria;

import java.math.BigDecimal;

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
    public Presunto definirAdicional(Produto produto, String descricao, BigDecimal preco) {
        return new Presunto(produto, descricao, preco);
    }
}
