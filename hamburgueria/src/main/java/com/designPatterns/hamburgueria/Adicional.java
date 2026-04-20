package com.designPatterns.hamburgueria;

import java.math.BigDecimal;

public abstract class Adicional extends HamburguerDecorator {

    public Adicional(){}

    public Adicional(Produto produto){
        super(produto);
    }

    private BigDecimal preco;

    @Override
    public BigDecimal getPrecoBase() {
        return null;
    }

    @Override
    public String getDescricao() {
        return "";
    }
}
