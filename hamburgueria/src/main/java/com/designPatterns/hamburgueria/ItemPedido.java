package com.designPatterns.hamburgueria;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
@Data
public class ItemPedido {

    private Double quantidade;
    private BigDecimal subTotal;
    private String observacao;
    private Pedido pedido;
    private Produto produto;
    private String pontoCarne;

    public ItemPedido(String observacao, Pedido pedido, Produto produto, Double quantidade) {
        this.observacao = observacao;
        this.pedido = pedido;
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public BigDecimal getValorTotalPedido() {
        return produto.getPrecoBase();
    }

    public String getDescricaoItemPedido() {
        return produto.getDescricao();

    }
}
