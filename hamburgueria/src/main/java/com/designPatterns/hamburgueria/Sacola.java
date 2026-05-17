package com.designPatterns.hamburgueria;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
public class Sacola {

    private Pedido pedido;
    private Cliente cliente;

    public EstadoPedido realizarPedido()
    {
        return pedido.realizarPedido();
    }
}
