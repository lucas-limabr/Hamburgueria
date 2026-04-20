package com.designPatterns.hamburgueria;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
public class ItemPedido {

    private Double quantidade;
    private BigDecimal subTotal;
    private String observacao;
    private Pedido pedido;
    private Produto produto;

    public ItemPedido(String observacao, Pedido pedido, Produto produto, Double quantidade) {
        this.observacao = observacao;
        this.pedido = pedido;
        this.produto = produto;
        this.quantidade = quantidade;
    }
}
