package com.designPatterns.hamburgueria;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class RelatorioTemplateTest {

    private List<Pedido> listaDePedidos;

    @BeforeEach
    void setUp() {
        listaDePedidos = new ArrayList<>();

        Pedido p1 = new Pedido(new BigDecimal("55.00"), LocalDateTime.now().minusHours(3), BigDecimal.ZERO, null, null, null);
        p1.setFormaPagamento(new Pix());
        p1.setEstadoPedido(PedidoDespachado.getInstance());

        Pedido p2 = new Pedido(new BigDecimal("35.50"), LocalDateTime.now().minusHours(2), BigDecimal.ZERO, null, null, null);
        p2.setFormaPagamento(new Dinheiro());
        p2.setEstadoPedido(PedidoDespachado.getInstance());

        Pedido p3 = new Pedido(new BigDecimal("22.00"), LocalDateTime.now().minusHours(1), BigDecimal.ZERO, null, null, null);
        p3.setFormaPagamento(new CartaoCredito());
        p3.setEstadoPedido(PedidoRecusado.getInstance());

        listaDePedidos.add(p1);
        listaDePedidos.add(p2);
        listaDePedidos.add(p3);
    }

    @Test
    void deveExportarRelatorioFaturamentoNoConsoleComSucesso() {
        ExportadorRelatorioTemplate exportador = new RelatorioFaturamentoConsole();
        String destino = exportador.exportar(listaDePedidos);
        assertEquals("Console", destino);
    }

    @Test
    void deveContabilizarQuantidadeTotalDePedidosNaAuditoria() {
        ExportadorRelatorioTemplate exportador = new RelatorioAuditoriaTexto();
        String resultado = exportador.exportar(listaDePedidos);
        assertTrue(resultado.contains("Total de pedidos processados no período: 3"));
    }

    @Test
    void deveContabilizarAlertasDeCancelamentoNaAuditoria() {
        ExportadorRelatorioTemplate exportador = new RelatorioAuditoriaTexto();
        String resultado = exportador.exportar(listaDePedidos);
        assertTrue(resultado.contains("Alertas de Cancelamento: 1"));
    }

    @Test
    void deveRetornarMensagemTratadaQuandoListaDePedidosForVazia() {
        ExportadorRelatorioTemplate exportador = new RelatorioAuditoriaTexto();
        String resultado = exportador.exportar(new ArrayList<>());
        assertEquals("Sem dados para exportar.", resultado);
    }
}