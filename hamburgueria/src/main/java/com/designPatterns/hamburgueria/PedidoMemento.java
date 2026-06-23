package com.designPatterns.hamburgueria;

import java.math.BigDecimal;

public class PedidoMemento {

    private final BigDecimal valorTotal;
    private final BigDecimal cupomDesconto;

    public PedidoMemento(BigDecimal valorTotal, BigDecimal cupomDesconto) {
        this.valorTotal = valorTotal;
        this.cupomDesconto = cupomDesconto;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public BigDecimal getCupomDesconto() {
        return cupomDesconto;
    }
}