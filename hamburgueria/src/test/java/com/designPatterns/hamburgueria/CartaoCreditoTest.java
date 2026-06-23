package com.designPatterns.hamburgueria;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CartaoCreditoTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    @DisplayName("Deve processar pagamento com cartão de crédito")
    void deveRetornarCartaoCredito() {
        IFormaPagamento formaPagamento = FormaPagamentoFactory.obterFormaPagamento("CartaoCredito");
        assertInstanceOf(CartaoCredito.class, formaPagamento);

        CartaoCredito cartao = (CartaoCredito) formaPagamento;
        cartao.setNumeroCartao("1234567890124321");
        cartao.setNomeTitular("Jose Souza");
        cartao.setValidade("12/32");
        cartao.setCvc("123");

        assertEquals("Pagamento feito com cartão de crédito final 4321", cartao.processarPagamento());
    }
}