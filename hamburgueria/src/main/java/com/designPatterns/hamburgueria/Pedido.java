package com.designPatterns.hamburgueria;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
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
