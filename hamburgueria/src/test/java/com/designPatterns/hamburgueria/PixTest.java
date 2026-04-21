package com.designPatterns.hamburgueria;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PixTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    @DisplayName("Deve processar pagamento com pix")
    void deveRetornarPix() {
        IFormaPagamento pix = FormaPagamentoFactory.obterFormaPagamento("Pix");
        assertInstanceOf(Pix.class, pix);
        assertTrue(pix.processarPagamento());
    }
}