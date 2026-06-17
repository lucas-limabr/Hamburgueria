package com.designPatterns.hamburgueria;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class LinhaChickenTest {

    Hamburguer linhaChicken;
    DescontoPercentual descontoPercentual;
    DescontoFixo descontoFixo;

    @BeforeEach
    void setUp() {
        linhaChicken = new LinhaChicken("Hambúrguer delicioso de frango", "Linha Chicken - Zeus", new BigDecimal("40.00"), 1.0);

        descontoPercentual = new DescontoPercentual(new BigDecimal("0.15"));
        descontoFixo = new DescontoFixo(new BigDecimal("5.00"));
    }

    @Test
    @DisplayName("Deve retornar o preço do hambúrguer com desconto fixo (default 5.00) aplicado para linha chicken")
    void deveRetornarDescontoFixoParaLinhaChicken() {
        linhaChicken.setPromocaoLinha(descontoFixo);
        assertEquals(new BigDecimal("35.00"), linhaChicken.calculaPrecoNaPromocao());
    }

    @Test
    @DisplayName("Deve retornar o preço do hambúrguer com desconto percentual (default 15%) aplicado para linha chicken")
    void deveRetornarDescontoPercentualParaLinhaChicken() {
        linhaChicken.setPromocaoLinha(descontoPercentual);
        assertEquals(new BigDecimal("34.00"), linhaChicken.calculaPrecoNaPromocao());
    }

    @Test
    @DisplayName("Apesar de um clone compartilhar do mesmo conteúdo do objeto original, ele ainda é outro objeto, ou seja, tem uma referência diferente na memória")
    void deveRetornarObjetosDiferentesComBaseEnderecoMemoria()
    {
        Hamburguer linhaChickenClonada = linhaChicken.clone();
        assertNotSame(linhaChicken, linhaChickenClonada);
    }

    @Test
    @DisplayName("Um clone tem os mesmos valores de atributos em comparação ao objeto original. O método equals() sobrescrito da classe será executado e com base nos atributos de comparação retornará true se todos forem iguais, que é o caso")
    void deveRetornarObjetosIguaisComBaseConteudo()
    {
        Hamburguer linhaChickenClonada = linhaChicken.clone();
        assertEquals(linhaChicken, linhaChickenClonada);
    }
}