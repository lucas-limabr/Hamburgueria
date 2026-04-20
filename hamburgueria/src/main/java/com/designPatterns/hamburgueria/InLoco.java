package com.designPatterns.hamburgueria;

public class InLoco extends Entrega {

    public InLoco(String numeroMesa, Pedido pedido) {
        this.numeroMesa = numeroMesa;
        super(pedido);
    }

    public String numeroMesa;
}
