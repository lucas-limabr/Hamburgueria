package com.designPatterns.hamburgueria;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FluxoPedidoTest {

    Pedido pedido;
    FluxoPedido fluxoPedido;
    Command processarPagamento;
    Command aguardaConfirmacaoPedido;
    Command aceitaPedidoCommand;

    @BeforeEach
    void setUp() {
        pedido = new Pedido();
    }

    @Test
    void deveExecutarCommandProcessaPagamentoPedido() {
        fluxoPedido = new FluxoPedido();
        processarPagamento = new ProcessaPgtCommand(pedido);
        assertTrue(fluxoPedido.executeCommand(processarPagamento));
        assertInstanceOf(PagamentoPedidoProcessado.class, pedido.getEstadoPedido());
    }

    @Test
    void deveExecutarCommandAguardaConfirmacaoPedido() {
        pedido.setEstadoPedido(PagamentoPedidoProcessado.getInstance());
        fluxoPedido = new FluxoPedido();
        aguardaConfirmacaoPedido = new AguardaConfirmacaoCommand(pedido);
        assertTrue(fluxoPedido.executeCommand(aguardaConfirmacaoPedido));
        assertInstanceOf(PedidoAguardandoConfirmacao.class, pedido.getEstadoPedido());
    }

    @Test
    void deveExecutarCommandAceitaPedidoPedido() {
        pedido.setEstadoPedido(PedidoAguardandoConfirmacao.getInstance());
        fluxoPedido = new FluxoPedido();
        aceitaPedidoCommand = new AceitaPedidoCommand(pedido);
        assertTrue(fluxoPedido.executeCommand(aceitaPedidoCommand));
        assertInstanceOf(PedidoEmPreparo.class, pedido.getEstadoPedido());
    }
}