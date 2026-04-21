package com.designPatterns.hamburgueria;

import lombok.Getter;

public class PedidoDespachado extends EstadoPedido{
    private PedidoDespachado() {};
    @Getter
    private static PedidoDespachado instance = new PedidoDespachado();

    public String getEstado() {
        return "Pedido saiu para entrega";
    }

    public boolean concluir(Pedido pedido) {
        pedido.setEstadoPedido(PedidoConcluido.getInstance());
        return true;
    }

    public boolean cancelar(Pedido pedido) {
        pedido.setEstadoPedido(PedidoCancelado.getInstance());
        return true;
    }
}
