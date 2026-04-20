package com.designPatterns.hamburgueria;

import java.math.BigDecimal;

public abstract class HamburguerDecorator implements Produto {
    public Produto produto;

    public HamburguerDecorator(){}

    public HamburguerDecorator(Produto produto){
        this.produto = produto;
    }

    public BigDecimal getValorAcrescido()
    {
        return null;
    }
}
