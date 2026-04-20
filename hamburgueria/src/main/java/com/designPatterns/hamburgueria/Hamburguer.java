package com.designPatterns.hamburgueria;

import java.math.BigDecimal;

public class Hamburguer implements Produto{

    private String descricao;
    private String titulo;
    private BigDecimal precoBase;
    private Double quantidade;

    @Override
    public BigDecimal getPrecoBase() {
        return precoBase;
    }

    @Override
    public String getDescricao() {
        return descricao;
    }
}
