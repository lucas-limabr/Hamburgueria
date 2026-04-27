package com.designPatterns.hamburgueria;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class LinhaPremiumTest {

    LinhaPremium linhaPremium;
    DescontoPercentual descontoPercentual;
    DescontoFixo descontoFixo;

    @BeforeEach
    void setUp() {
        linhaPremium = new LinhaPremium("Hambúrguer delicioso de carne bovina", "Linha Premium - Afrodite", new BigDecimal("50.00"), 1.0);

        descontoPercentual = new DescontoPercentual(new BigDecimal("0.15"));
        descontoFixo = new DescontoFixo(new BigDecimal("5.00"));
    }

    @Test
    @DisplayName("Deve retornar o preço do hambúrguer com desconto fixo (default 5.00) aplicado para linha premium")
    void deveRetornarDescontoFixoParaLinhaPremium() {
        linhaPremium.setPromocaoAdicional(descontoFixo);
        assertEquals(new BigDecimal("45.00"), linhaPremium.calculaPrecoNaPromocao());
    }

    @Test
    @DisplayName("Deve retornar o preço do hambúrguer com desconto percentual aplicado para linha premium (15%), porém, este desconto não deve ultrapassar o limite definido na linha Premium, que por default é de 10% sobre seu valor, assim, os 15% não será aplicado")
    void deveRetornarDescontoPercentualParaLinhaPremiumComLimiteDesconto() {
        linhaPremium.setPromocaoAdicional(descontoPercentual);
        assertEquals(new BigDecimal("45.00"), linhaPremium.calculaPrecoNaPromocao());
    }

    @Test
    @DisplayName("Deve retornar o preço do hambúrguer com desconto percentual de 5% aplicado para linha premium")
    void deveRetornarDescontoPercentualParaLinhaPremium() {
        descontoPercentual.setPercentualDesconto(new BigDecimal("0.05"));
        linhaPremium.setPromocaoAdicional(descontoPercentual);
        assertEquals(new BigDecimal("47.50"), linhaPremium.calculaPrecoNaPromocao());
    }
}