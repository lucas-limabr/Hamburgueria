package com.designPatterns.hamburgueria;

import lombok.Data;

import java.math.BigDecimal;

public interface PromocaoLinha {

    BigDecimal calculaDesconto(BigDecimal precoBase);
}
