package com.designPatterns.hamburgueria;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

class PedidoStrategyFactoryTest {

    private Pedido pedido;

    @BeforeEach
    void setUp() {
        pedido = new Pedido();
        pedido.setValorTotal(new BigDecimal("50.00"));
        pedido.setDataPedido(LocalDateTime.now());
    }

    @Test
    void deveInstanciarEstrategiaPix() {
        pedido.definirFormaPagamento("Pix");
        assertInstanceOf(Pix.class, pedido.getFormaPagamento());
    }

    @Test
    void deveProcessarMensagemPix() {
        pedido.definirFormaPagamento("Pix");
        assertEquals("Pagamento feito com pix", pedido.getFormaPagamento().processarPagamento());
    }

    @Test
    void deveInstanciarEstrategiaDinheiro() {
        pedido.definirFormaPagamento("Dinheiro");
        assertInstanceOf(Dinheiro.class, pedido.getFormaPagamento());
    }

    @Test
    void deveProcessarMensagemDinheiro() {
        pedido.definirFormaPagamento("Dinheiro");
        assertEquals("Pagamento feito com dinheiro", pedido.getFormaPagamento().processarPagamento());
    }

    @Test
    void deveInstanciarEstrategiaCartao() {
        pedido.definirFormaPagamento("CartaoCredito");
        assertInstanceOf(CartaoCredito.class, pedido.getFormaPagamento());
    }

    @Test
    void deveProcessarMensagemCartaoComDados() {
        pedido.definirFormaPagamento("CartaoCredito");
        CartaoCredito cartao = (CartaoCredito) pedido.getFormaPagamento();
        cartao.setNumeroCartao("1234567890124321");
        cartao.setNomeTitular("Jose Souza");
        cartao.setValidade("12/32");
        cartao.setCvc("123");
        assertEquals("Pagamento feito com cartão de crédito final 4321", cartao.processarPagamento());
    }

    @Test
    void deveLancarExcecaoParaFormaInexistente() {
        assertThrows(IllegalArgumentException.class, () -> pedido.definirFormaPagamento("Bitcoin"));
    }

    @Test
    void deveRecusarPedidoSemEstrategia() {
        pedido.setFormaPagamento(null);
        assertEquals(PedidoRecusado.getInstance(), pedido.realizarPedido());
    }

    @Test
    void deveRealizarPedidoComEstrategiaValida() {
        pedido.definirFormaPagamento("Pix");
        assertEquals(PedidoRealizado.getInstance(), pedido.realizarPedido());
    }

    @Test
    void deveRecusarPedidoComCartaoTotalmenteVazio() {
        pedido.definirFormaPagamento("CartaoCredito");
        assertEquals(PedidoRecusado.getInstance(), pedido.realizarPedido());
    }

    @Test
    void deveRecusarPedidoComCartaoIncompleto() {
        pedido.definirFormaPagamento("CartaoCredito");
        CartaoCredito cartao = (CartaoCredito) pedido.getFormaPagamento();
        cartao.setNumeroCartao("1234567890124321");
        cartao.setCvc("123");

        assertEquals(PedidoRecusado.getInstance(), pedido.realizarPedido());
    }

    @Test
    void deveRealizarPedidoComCartaoTotalmentePreenchido() {
        pedido.definirFormaPagamento("CartaoCredito");
        CartaoCredito cartao = (CartaoCredito) pedido.getFormaPagamento();
        cartao.setNumeroCartao("1234567890124321");
        cartao.setNomeTitular("Jose Souza");
        cartao.setValidade("12/32");
        cartao.setCvc("123");

        assertEquals(PedidoRealizado.getInstance(), pedido.realizarPedido());
    }

    @Test
    void deveRecusarPedidoComCartaoSemNome() {
        pedido.definirFormaPagamento("CartaoCredito");
        CartaoCredito cartao = (CartaoCredito) pedido.getFormaPagamento();
        cartao.setNumeroCartao("1234567890124321");
        cartao.setValidade("12/32");
        cartao.setCvc("123");

        assertEquals(PedidoRecusado.getInstance(), pedido.realizarPedido());
    }

    @Test
    void deveRecusarPedidoComCartaoSemValidade() {
        pedido.definirFormaPagamento("CartaoCredito");
        CartaoCredito cartao = (CartaoCredito) pedido.getFormaPagamento();
        cartao.setNumeroCartao("1234567890124321");
        cartao.setNomeTitular("Jose Souza");
        cartao.setCvc("123");

        assertEquals(PedidoRecusado.getInstance(), pedido.realizarPedido());
    }
}