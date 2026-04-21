package com.designPatterns.hamburgueria;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DinheiroTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    @DisplayName("Deve processar pagamento com dinheiro")
    void deveRetornarDinheiro() {
        IFormaPagamento dinheiro = FormaPagamentoFactory.obterFormaPagamento("Dinheiro");
        assertInstanceOf(Dinheiro.class, dinheiro);
        assertTrue(dinheiro.processarPagamento());
    }
}