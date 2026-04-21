package com.designPatterns.hamburgueria;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
public class Pix implements IFormaPagamento{

    private BigDecimal taxa;

    @Override
    public boolean processarPagamento() {
        return true;
    }
}
