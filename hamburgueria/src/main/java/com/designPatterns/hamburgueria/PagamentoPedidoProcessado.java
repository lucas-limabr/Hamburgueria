package com.designPatterns.hamburgueria;

import lombok.Getter;

public class PagamentoPedidoProcessado extends EstadoPedido{

    private PagamentoPedidoProcessado() {};
    @Getter
    private static PagamentoPedidoProcessado instance = new PagamentoPedidoProcessado();

    public String getEstado() {
        return "Pagamento processado";
    }

    public boolean aguardarConfirmacao(Pedido pedido) {
        pedido.setEstadoPedido(PedidoAguardandoConfirmacao.getInstance());
        return true;
    }
}
