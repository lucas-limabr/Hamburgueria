package com.designPatterns.hamburgueria;

import java.math.BigDecimal;

public class Bacon extends Adicional{

    public Bacon(Produto produto, String descricao, BigDecimal preco) {
        super(produto, descricao, preco);
    }
}
