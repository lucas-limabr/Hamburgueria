package com.designPatterns.hamburgueria;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CartaoCreditoTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    @DisplayName("Deve processar pagamento com cartão de crédito")
    void deveRetornarCartaoCredito() {
        IFormaPagamento cartaoCredito = FormaPagamentoFactory.obterFormaPagamento("CartaoCredito");
        assertInstanceOf(CartaoCredito.class, cartaoCredito);
        assertTrue(cartaoCredito.processarPagamento());
    }
}