package com.designPatterns.hamburgueria;

import lombok.Getter;

public class PedidoAguardandoConfirmacao {

    private PedidoAguardandoConfirmacao() {};
    @Getter
    private static PedidoAguardandoConfirmacao instance = new PedidoAguardandoConfirmacao();

    public String getEstado() {
        return "Aguardando confirmação da hamburgueria";
    }

    public boolean aceitar(Pedido pedido) {
        pedido.setEstadoPedido(PedidoEmPreparo.getInstance());
        return true;
    }

    public boolean recusar(Pedido pedido) {
        pedido.setEstadoPedido(PedidoRecusado.getInstance());
        return true;
    }
}
