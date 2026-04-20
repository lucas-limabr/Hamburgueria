package com.designPatterns.hamburgueria;

import lombok.AllArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
public abstract class Acompanhamento extends HamburguerDecorator {

    private BigDecimal preco;
    private String descricao;
    private Double tamanho;

    public Acompanhamento(){}

    public Acompanhamento(Produto produto, String descricao, BigDecimal preco, Double tamanho)
    {
        super(produto);
        this.descricao = descricao;
        this.preco = preco;
        this.tamanho = tamanho;
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
