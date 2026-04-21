package com.designPatterns.hamburgueria;

public abstract class EstadoPedido {

    public abstract String getEstado();

    public boolean aceitar(Pedido pedido) {
        return false;
    }

    public boolean processarPagamento(Pedido pedido) {
        return false;
    }

    public boolean preparar(Pedido pedido) {
        return false;
    }

    public boolean despachar(Pedido pedido) {
        return false;
    }

    public boolean recusar(Pedido pedido) {
        return false;
    }

    public boolean cancelar(Pedido pedido) {
        return false;
    }

    public boolean aguardarConfirmacao(Pedido pedido) {
        return false;
    }

    public boolean concluir(Pedido pedido) {
        return false;
    }
}
