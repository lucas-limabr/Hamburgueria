package com.designPatterns.hamburgueria;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SetorTest {

    Entrega entregador;
    Cozinha cozinha;
    Financeiro financeiro;
    Pedido pagamentoProcessado;
    Pedido emPreparo;
    Pedido despachado;

    @BeforeEach
    void setUp() {
        entregador = new Delivery(null);
        cozinha = new Cozinha(entregador);
        financeiro = new Financeiro(cozinha);

        pagamentoProcessado = new Pedido();
        pagamentoProcessado.setEstadoPedido(PagamentoPedidoProcessado.getInstance());

        emPreparo = new Pedido();
        emPreparo.setEstadoPedido(PedidoEmPreparo.getInstance());

        despachado = new Pedido();
        despachado.setEstadoPedido(PedidoDespachado.getInstance());
    }

    @Test
    @DisplayName("Deve retornar setor financeiro na etapa de processamento de pagamento")
    void deveRetornarSetorFinanceiroNaEtapaPedidoPagamentoProcessado() {
        assertEquals("Setor responsável: Financeiro", financeiro.processarPedido(pagamentoProcessado));
    }

    @Test
    @DisplayName("Deve retornar setor cozinha na etapa de preparo")
    void deveRetornarSetorCozinhaNaEtapaPedidoEmPreparo() {
        assertEquals("Setor responsável: Cozinha", financeiro.processarPedido(emPreparo));
    }

    @Test
    @DisplayName("Deve retornar setor entrega delivery na etapa de despacho")
    void deveRetornarSetorEntregaDeliveryNaEtapaPedidoDespachado() {
        assertEquals("Setor responsável: Entrega via delivery", financeiro.processarPedido(despachado));
    }

    @Test
    @DisplayName("Deve retornar setor entrega in loco por garçom na etapa de despacho")
    void deveRetornarSetorEntregaInLocoNaEtapaPedidoDespachado() {
        Entrega garcom;
        garcom = new InLoco(null);
        cozinha.setResponsavelEtapaSeguinte(garcom);
        assertEquals("Setor responsável: Entrega in loco via garçom", financeiro.processarPedido(despachado));
    }
}