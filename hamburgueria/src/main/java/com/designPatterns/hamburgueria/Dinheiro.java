package com.designPatterns.hamburgueria;

import java.math.BigDecimal;

public class Dinheiro implements IFormaPagamento{

    private BigDecimal taxa;

    @Override
    public boolean processarPagamento() {
        return false;
    }
}
