package com.designPatterns.hamburgueria;

import java.util.Stack;

public class HistoricoPedido {

    private final Stack<PedidoMemento> historico = new Stack<>();

    public void salvarEstado(PedidoMemento memento) {
        historico.push(memento);
    }

    public PedidoMemento restaurarEstado() {
        if (historico.isEmpty()) {
            return null;
        }
        return historico.pop();
    }
}