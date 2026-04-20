package com.designPatterns.hamburgueria;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Pedido {

    private BigDecimal valorTotal;
    private LocalDateTime dataPedido;
    private BigDecimal cupomDesconto;
    private EstadoPedido estadoPedido;
    private Cliente cliente;
    private IFormaPagamento formaPagamento;

    public EstadoPedido setEstadoPedido(EstadoPedido estadoPedido) {
        return this.estadoPedido = estadoPedido;
    }
}
