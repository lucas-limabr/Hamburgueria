package com.designPatterns.hamburgueria;

import java.math.BigDecimal;

public class Bebida extends Acompanhamento {

    public Bebida(Produto produto, String descricao, BigDecimal preco, Double tamanho) {
        super(produto, descricao, preco, tamanho);
    }

    public Bebida(BigDecimal preco, String descricao, Double tamanho) {
        super(preco, descricao, tamanho);
    }
}
