package com.designPatterns.hamburgueria;

import java.math.BigDecimal;

public class Ovo extends Adicional{

    public Ovo(Produto produto, String descricao, BigDecimal preco) {
        super(produto, descricao, preco);
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
