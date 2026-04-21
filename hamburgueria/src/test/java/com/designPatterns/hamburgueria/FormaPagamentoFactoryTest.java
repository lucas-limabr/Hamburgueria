package com.designPatterns.hamburgueria;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FormaPagamentoFactoryTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    @DisplayName("Deve lançar uma exceção e ter a mensagem de exceção correspondente")
    void deveLancarExcecao() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> {
            FormaPagamentoFactory.obterFormaPagamento("PayPal");
        });

        assertEquals("Forma de pagamento inexistente", e.getMessage());
    }
}