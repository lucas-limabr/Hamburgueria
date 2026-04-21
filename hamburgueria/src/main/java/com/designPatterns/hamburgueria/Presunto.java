package com.designPatterns.hamburgueria;

import java.math.BigDecimal;

public class Presunto extends Adicional {

    public Presunto(Produto produto, String descricaoAdicional, BigDecimal preco) {
        super(produto, descricaoAdicional, preco);
    }

    public BigDecimal getValorAcrescido()
    {
        return super.getPreco();
    }
    public String getDescricaoDecorador()
    {
        return super.getDescricaoAdicional();
    }
}
