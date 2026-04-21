package com.designPatterns.hamburgueria;

import lombok.Getter;

public class PedidoConcluido extends EstadoPedido{
    private PedidoConcluido() {};
    @Getter
    private static PedidoConcluido instance = new PedidoConcluido();

    public String getEstado() {
        return "Pedido concluído";
    }
}
