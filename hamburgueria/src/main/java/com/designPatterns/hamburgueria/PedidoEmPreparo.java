package com.designPatterns.hamburgueria;

import lombok.Getter;

public class PedidoEmPreparo extends EstadoPedido{
    private PedidoEmPreparo() {};
    @Getter
    private static PedidoEmPreparo instance = new PedidoEmPreparo();

    public String getEstado() {
        return "Pedido em preparo";
    }

    public boolean despachar(Pedido pedido) {
        pedido.setEstadoPedido(PedidoDespachado.getInstance());
        return true;
    }

    public boolean cancelar(Pedido pedido) {
        pedido.setEstadoPedido(PedidoCancelado.getInstance());
        return true;
    }
}
