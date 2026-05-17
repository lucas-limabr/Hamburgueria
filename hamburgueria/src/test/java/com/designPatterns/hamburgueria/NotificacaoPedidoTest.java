package com.designPatterns.hamburgueria;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NotificacaoPedidoTest {

    private Pedido pedido;
    private Cliente cliente;

    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));

        cliente = new Cliente("João Silva", "123...", "329...", null, null);
        pedido = new Pedido(new BigDecimal("50.00"), LocalDateTime.now(), BigDecimal.ZERO, null, cliente, null);
        pedido.addObserver(cliente);
    }

    @AfterEach
    public void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    void deveExibirMensagemNoConsoleQuandoPagamentoForProcessado() {
        pedido.setEstadoPedido(PedidoRealizado.getInstance());
        outputStreamCaptor.reset();

        pedido.processarPagamento();

        String consoleOutput = outputStreamCaptor.toString().trim();
        assertEquals("O status do seu pedido mudou para: Pagamento processado", consoleOutput);
    }

    @Test
    void deveExibirMensagemNoConsoleQuandoAguardarConfirmacao() {
        pedido.setEstadoPedido(PagamentoPedidoProcessado.getInstance());
        outputStreamCaptor.reset();

        pedido.aguardarConfirmacao();

        String consoleOutput = outputStreamCaptor.toString().trim();
        assertEquals("O status do seu pedido mudou para: Aguardando confirmação da hamburgueria", consoleOutput);
    }

    @Test
    void deveExibirMensagemNoConsoleQuandoPedidoIrParaPreparo() {
        pedido.setEstadoPedido(PedidoAguardandoConfirmacao.getInstance());
        outputStreamCaptor.reset();

        pedido.aceitar();

        String consoleOutput = outputStreamCaptor.toString().trim();
        assertEquals("O status do seu pedido mudou para: Pedido em preparo", consoleOutput);
    }

    @Test
    void deveExibirMensagemNoConsoleQuandoPedidoForDespachado() {
        pedido.setEstadoPedido(PedidoEmPreparo.getInstance());
        outputStreamCaptor.reset();

        pedido.despachar();

        String consoleOutput = outputStreamCaptor.toString().trim();
        assertEquals("O status do seu pedido mudou para: Pedido saiu para entrega", consoleOutput);
    }

    @Test
    void deveExibirMensagemNoConsoleQuandoPedidoForConcluido() {
        pedido.setEstadoPedido(PedidoDespachado.getInstance());
        outputStreamCaptor.reset();

        pedido.concluir();

        String consoleOutput = outputStreamCaptor.toString().trim();
        assertEquals("O status do seu pedido mudou para: Pedido concluído", consoleOutput);
    }

    @Test
    void deveExibirMensagemNoConsoleQuandoPedidoForRecusado() {
        pedido.setEstadoPedido(PedidoAguardandoConfirmacao.getInstance());
        outputStreamCaptor.reset();

        pedido.recusar();

        String consoleOutput = outputStreamCaptor.toString().trim();
        assertEquals("O status do seu pedido mudou para: Pedido recusado", consoleOutput);
    }

    @Test
    void deveExibirMensagemNoConsoleQuandoPedidoForCanceladoApartirDeAguardandoConfirmacao() {
        pedido.setEstadoPedido(PedidoAguardandoConfirmacao.getInstance());
        outputStreamCaptor.reset();

        pedido.cancelar();

        String consoleOutput = outputStreamCaptor.toString().trim();
        assertEquals("O status do seu pedido mudou para: Pedido cancelado", consoleOutput);
    }

    @Test
    void deveExibirMensagemNoConsoleQuandoPedidoForCanceladoApartirDePedidoEmPreparo() {
        pedido.setEstadoPedido(PedidoEmPreparo.getInstance());
        outputStreamCaptor.reset();

        pedido.cancelar();

        String consoleOutput = outputStreamCaptor.toString().trim();
        assertEquals("O status do seu pedido mudou para: Pedido cancelado", consoleOutput);
    }

    @Test
    void deveExibirMensagemNoConsoleQuandoPedidoForCanceladoApartirDePedidoDespachado() {
        pedido.setEstadoPedido(PedidoDespachado.getInstance());
        outputStreamCaptor.reset();

        pedido.cancelar();

        String consoleOutput = outputStreamCaptor.toString().trim();
        assertEquals("O status do seu pedido mudou para: Pedido cancelado", consoleOutput);
    }
}