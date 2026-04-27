package com.designPatterns.hamburgueria;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.math.RoundingMode;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DescontoPercentual implements PromocaoLinha {

    private BigDecimal percentualDesconto;

    @Override
    public BigDecimal calculaDesconto(BigDecimal precoBase) {
        return precoBase.subtract(precoBase.multiply(percentualDesconto)).setScale(2, RoundingMode.HALF_UP);
    }
}
