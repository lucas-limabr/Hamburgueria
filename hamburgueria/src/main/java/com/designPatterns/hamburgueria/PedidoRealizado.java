package com.designPatterns.hamburgueria;

import lombok.Getter;

public class PedidoRealizado extends EstadoPedido {

    private PedidoRealizado() {};
    @Getter
    private static PedidoRealizado instance = new PedidoRealizado();

    public String getEstado() {
        return "Realizado";
    }

    public boolean processarPagamento(Pedido pedido) {
        pedido.setEstadoPedido(PagamentoPedidoProcessado.getInstance());
        return true;
    }
}
