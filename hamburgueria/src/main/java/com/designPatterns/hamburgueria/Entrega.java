package com.designPatterns.hamburgueria;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
public abstract class Entrega {

    private Pedido pedido;

    public BigDecimal calculaTaxaEntrega()
    {
        return null;
    }
}
