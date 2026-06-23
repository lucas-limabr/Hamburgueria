package com.designPatterns.hamburgueria;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

class MementoPedidoTest {

    private Pedido pedido;
    private HistoricoPedido historico;

    @BeforeEach
    void setUp() {
        pedido = new Pedido(new BigDecimal("50.00"), LocalDateTime.now(), BigDecimal.ZERO, null, null, null);
        historico = new HistoricoPedido();
    }

    @Test
    void deveSalvarEstadoInicialComSucesso() {
        PedidoMemento memento = pedido.salvar();

        assertNotNull(memento);
    }

    @Test
    void deveRestaurarValorOriginalAposAlteracao() {
        historico.salvarEstado(pedido.salvar());
        pedido.setValorTotal(new BigDecimal("75.00"));

        pedido.restaurar(historico.restaurarEstado());

        assertEquals(new BigDecimal("50.00"), pedido.getValorTotal());
    }

    @Test
    void deveDesfazerMultiplasAlteracoesNaOrdemCorretaDaPilha() {
        historico.salvarEstado(pedido.salvar());

        pedido.setValorTotal(new BigDecimal("60.00"));
        pedido.setCupomDesconto(new BigDecimal("5.00"));
        historico.salvarEstado(pedido.salvar());

        pedido.setValorTotal(new BigDecimal("80.00"));

        pedido.restaurar(historico.restaurarEstado());
        assertEquals(new BigDecimal("60.00"), pedido.getValorTotal());
    }

    @Test
    void deveRecuperarEstadoMaisAntigoAoDesfazerDuasVezes() {
        historico.salvarEstado(pedido.salvar());

        pedido.setValorTotal(new BigDecimal("60.00"));
        historico.salvarEstado(pedido.salvar());

        pedido.setValorTotal(new BigDecimal("80.00"));

        historico.restaurarEstado();
        pedido.restaurar(historico.restaurarEstado());

        assertEquals(new BigDecimal("50.00"), pedido.getValorTotal());
    }

    @Test
    void deveRetornarNuloAoTentarRestaurarComHistoricoVazio() {
        PedidoMemento mementoVazio = historico.restaurarEstado();

        assertNull(mementoVazio);
    }
}