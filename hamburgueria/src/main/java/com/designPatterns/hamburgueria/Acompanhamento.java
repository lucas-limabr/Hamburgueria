package com.designPatterns.hamburgueria;

import java.math.BigDecimal;

public abstract class Acompanhamento extends HamburguerDecorator {

    private BigDecimal preco;
    private String descricao;
    private Double tamanho;

    public Acompanhamento(){}

    public Acompanhamento(Produto produto)
    {
        super(produto);
    }

    @Override
    public BigDecimal getPrecoBase() {
        return preco;
    }

    @Override
    public String getDescricao() {
        return descricao;
    }
}
