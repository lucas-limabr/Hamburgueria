package com.designPatterns.hamburgueria;

import lombok.Getter;

public class PedidoRecusado extends EstadoPedido{
    private PedidoRecusado() {};
    @Getter
    private static PedidoRecusado instance = new PedidoRecusado();

    public String getEstado() {
        return "Pedido recusado";
    }
}
