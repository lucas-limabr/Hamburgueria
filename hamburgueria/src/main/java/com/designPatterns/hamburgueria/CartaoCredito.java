package com.designPatterns.hamburgueria;

import lombok.AllArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
public class CartaoCredito implements IFormaPagamento{

    private String numeroCartao;
    private String nomeTitular;
    private String validade;
    private String cvc;
    private BigDecimal taxa;

    @Override
    public boolean processarPagamento() {
        return false;
    }
}
