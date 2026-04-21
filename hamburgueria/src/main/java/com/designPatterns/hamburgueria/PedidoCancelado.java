package com.designPatterns.hamburgueria;

import lombok.Getter;

public class PedidoCancelado extends EstadoPedido{
    private PedidoCancelado() {};
    @Getter
    private static PedidoCancelado instance = new PedidoCancelado();

    public String getEstado() {
        return "Pedido cancelado";
    }
}
