package com.designPatterns.hamburgueria;

public class ProcessaPgtCommand implements Command {

    Pedido pedido;

    public ProcessaPgtCommand(Pedido pedido) {
        this.pedido = pedido;
    }

    @Override
    public boolean execute() {
        return pedido.processarPagamento();

    }
}
