package com.designPatterns.hamburgueria;

import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
public class Dinheiro implements IFormaPagamento{

    private BigDecimal taxa;

    @Override
    public boolean processarPagamento() {
        return true;
    }
}
