package com.designPatterns.hamburgueria;

public class AceitaPedidoCommand implements Command {

    Pedido pedido;

    public AceitaPedidoCommand(Pedido pedido) {
        this.pedido = pedido;
    }

    @Override
    public boolean execute() {
        return pedido.aceitar();
    }
}
