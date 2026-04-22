package com.designPatterns.hamburgueria;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class EstadoPedidoTest {

    Pedido pedido;

    @BeforeEach
    public void setUp() {
        pedido = new Pedido();
        pedido.setEstadoPedido(PedidoRealizado.getInstance());
    }

    @Test
    void deveProcessarPagamentoPedidoRealizado() {
        pedido.setEstadoPedido(PedidoRealizado.getInstance());
        assertTrue(pedido.processarPagamento());
        assertEquals(PagamentoPedidoProcessado.getInstance(), pedido.getEstado());
    }

    @Test
    void naoDeveAceitarPedidoRealizado() {
        pedido.setEstadoPedido(PedidoRealizado.getInstance());
        assertFalse(pedido.aceitar());
    }

    @Test
    void deveAguardarConfirmacaoAposPagamento() {
        pedido.setEstadoPedido(PagamentoPedidoProcessado.getInstance());
        assertTrue(pedido.aguardarConfirmacao());
        assertEquals(PedidoAguardandoConfirmacao.getInstance(), pedido.getEstado());
    }


    @Test
    void deveAceitarPedidoAguardandoConfirmacao() {
        pedido.setEstadoPedido(PedidoAguardandoConfirmacao.getInstance());
        assertTrue(pedido.aceitar());
        assertEquals(PedidoEmPreparo.getInstance(), pedido.getEstado());
    }

    @Test
    void deveRecusarPedidoAguardandoConfirmacao() {
        pedido.setEstadoPedido(PedidoAguardandoConfirmacao.getInstance());
        assertTrue(pedido.recusar());
        assertEquals(PedidoRecusado.getInstance(), pedido.getEstado());
    }

    @Test
    void deveCancelarPedidoAguardandoConfirmacao() {
        pedido.setEstadoPedido(PedidoAguardandoConfirmacao.getInstance());
        assertTrue(pedido.cancelar());
        assertEquals(PedidoCancelado.getInstance(), pedido.getEstado());
    }

    @Test
    void deveDespacharPedidoEmPreparo() {
        pedido.setEstadoPedido(PedidoEmPreparo.getInstance());
        assertTrue(pedido.despachar());
        assertEquals(PedidoDespachado.getInstance(), pedido.getEstado());
    }

    @Test
    void deveCancelarPedidoEmPreparo() {
        pedido.setEstadoPedido(PedidoEmPreparo.getInstance());
        assertTrue(pedido.cancelar());
        assertEquals(PedidoCancelado.getInstance(), pedido.getEstado());
    }

    @Test
    void deveConcluirPedidoDespachado() {
        pedido.setEstadoPedido(PedidoDespachado.getInstance());
        assertTrue(pedido.concluir());
        assertEquals(PedidoConcluido.getInstance(), pedido.getEstado());
    }

    @Test
    void deveCancelarPedidoDespachado() {
        pedido.setEstadoPedido(PedidoDespachado.getInstance());
        assertTrue(pedido.cancelar());
        assertEquals(PedidoCancelado.getInstance(), pedido.getEstado());
    }

    @Test
    void naoDeveAlterarEstadoPedidoCancelado() {
        pedido.setEstadoPedido(PedidoCancelado.getInstance());
        assertFalse(pedido.preparar());
        assertFalse(pedido.concluir());
        assertEquals(PedidoCancelado.getInstance(), pedido.getEstado());
    }

    @Test
    void naoDeveAlterarEstadoPedidoRecusado() {
        pedido.setEstadoPedido(PedidoRecusado.getInstance());
        assertFalse(pedido.aceitar());
        assertEquals(PedidoRecusado.getInstance(), pedido.getEstado());
    }

    @Test
    void naoDeveAlterarEstadoPedidoConcluido() {
        pedido.setEstadoPedido(PedidoConcluido.getInstance());
        assertFalse(pedido.cancelar());
        assertEquals(PedidoConcluido.getInstance(), pedido.getEstado());
    }
}
