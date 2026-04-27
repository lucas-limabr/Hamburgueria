package com.designPatterns.hamburgueria;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DescontoFixo implements PromocaoLinha {

    private BigDecimal valorDesconto;

    @Override
    public BigDecimal calculaDesconto(BigDecimal precoBase) {
        return precoBase.subtract(valorDesconto);
    }
}
