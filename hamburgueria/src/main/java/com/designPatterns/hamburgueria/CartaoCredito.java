package com.designPatterns.hamburgueria;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
public class CartaoCredito implements IFormaPagamento{

    private String numeroCartao;
    private String nomeTitular;
    private String validade;
    private String cvc;
    private BigDecimal taxa;

    @Override
    public boolean processarPagamento() {
        return true;
    }
}
