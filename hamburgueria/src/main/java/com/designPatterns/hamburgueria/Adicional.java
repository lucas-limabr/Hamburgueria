package com.designPatterns.hamburgueria;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
public abstract class Adicional extends HamburguerDecorator {

    public Adicional(Produto produto, String descricao, BigDecimal preco){
        super(produto);
        this.descricao = descricao;
        this.preco = preco;
    }

    public Adicional(String descricao, BigDecimal preco){
        this.descricao = descricao;
        this.preco = preco;
    }

    private BigDecimal preco;
    private String descricao;

    @Override
    public BigDecimal getPrecoBase() {
        return null;
    }

    @Override
    public String getDescricao() {
        return "";
    }
}
