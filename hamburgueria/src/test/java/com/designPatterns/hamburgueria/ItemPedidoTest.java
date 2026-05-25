package com.designPatterns.hamburgueria;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class ItemPedidoTest {

    Hamburguer hamburguer1;
    Hamburguer hamburguer2;
    Adicional bacon;
    Bebida bebida;
    Pedido pedido;
    ItemPedido itemPedido;
    Cliente cliente;
    Combo combo1;
    Combo combo2;

    @BeforeEach
    void setUp() {
        hamburguer1 = new LinhaPremium("Delicioso hambúrguer da linha premium", "Hambúrguer Linha Premium", new BigDecimal("45.00"), 1.0);
        hamburguer2 = new LinhaChicken("Irresistível hambúrguer da linha chicken", "Hambúrguer Linha Chicken", new BigDecimal("25.00"), 1.0);

        Cliente cliente = new Cliente();
        Pedido pedido = new Pedido();
        itemPedido = new ItemPedido();
    }

    @Test
    @DisplayName("Deve calcular o preço total do item pedido com um combo de 2 hambúrgueres")
    void deveCalcularPrecoTotalItemPedidoComComboDe2Hamburgueres() {
        combo1 = new Combo("Combo Família");
        combo1.addProduto(hamburguer1);
        combo1.addProduto(hamburguer2);

        itemPedido.setPedido(pedido);
        itemPedido.setProduto(combo1);

        assertEquals(new BigDecimal("70.00"), itemPedido.getValorTotalPedido());
    }

    @Test
    @DisplayName("Deve informar a descrição correta do item pedido com um combo de 2 hambúrgueres")
    void deveRetornarDescricaoItemPedidoComComboDe2Hamburgueres() {
        combo1 = new Combo("Combo Família");
        combo1.addProduto(hamburguer1);
        combo1.addProduto(hamburguer2);

        itemPedido.setPedido(pedido);
        itemPedido.setProduto(combo1);

        assertEquals("Combo Família\n" +
                "\tDelicioso hambúrguer da linha premium\n" +
                "\tIrresistível hambúrguer da linha chicken", itemPedido.getDescricaoItemPedido());
    }

    @Test
    @DisplayName("Deve calcular o preço total do item pedido com um combo de 1 hambúrguer, 1 adicional e 1 acompanhamento")
    void deveCalcularPrecoTotalItemPedidoComComboDe1Hamburguer1AdicionalE1Acompanhamento() {
        bacon = new Bacon(hamburguer1, "Bacon", new BigDecimal("5.00"));
        bebida = new Bebida(bacon, "Coca-Cola Lata", new BigDecimal("10.00"), 600.0);

        combo2 = new Combo("Combo Divino");
        combo2.addProduto(bebida);

        itemPedido.setPedido(pedido);
        itemPedido.setProduto(combo2);

        assertEquals(new BigDecimal("60.00"), itemPedido.getValorTotalPedido());
    }

    @Test
    @DisplayName("Deve retornar a descrição do item pedido com um combo de 1 hambúrguer, 1 adicional e 1 acompanhamento")
    void deveRetornarDescricaoItemPedidoComComboDe1Hamburguer1AdicionalE1Acompanhamento() {
        bacon = new Bacon(hamburguer1, "Bacon", new BigDecimal("5.00"));
        bebida = new Bebida(bacon, "Coca-Cola Lata", new BigDecimal("10.00"), 600.0);

        combo2 = new Combo("Combo Divino");
        combo2.addProduto(bebida);

        itemPedido.setPedido(pedido);
        itemPedido.setProduto(combo2);

        assertEquals("Combo Divino\n" +
                "\tDelicioso hambúrguer da linha premium + Bacon + Coca-Cola Lata", itemPedido.getDescricaoItemPedido());
    }

    @Test
    @DisplayName("Deve calcular o preço total do item pedido com um combo dentro de combo")
    void deveCalcularPrecoTotalItemPedidoComComboDentroDeCombo() {

        Acompanhamento bebida2;
        combo1 = new Combo("Combo Quarta");
        combo2 = new Combo("Combo de bebidas");
        bebida = new Bebida(new BigDecimal("8.0"), "Coca-Cola Lata", 600.0);
        bebida2 = new Bebida(bebida, "Guaraná Lata", new BigDecimal("7.0"), 600.0);

        combo1.addProduto(hamburguer1);
        combo1.addProduto(hamburguer2);

        combo2.addProduto(bebida2);
        combo1.addProduto(combo2);

        itemPedido.setPedido(pedido);
        itemPedido.setProduto(combo1);

        assertEquals(new BigDecimal("85.00"), itemPedido.getValorTotalPedido());
    }

    @Test
    @DisplayName("Deve retornar descrição do item pedido com um combo dentro de combo")
    void deveRetornarDescricaoItemPedidoComComboDentroDeCombo() {

        Acompanhamento bebida2;
        combo1 = new Combo("Combo Quarta");
        combo2 = new Combo("Combo de bebidas");
        bebida = new Bebida(new BigDecimal("8.0"), "Coca-Cola Lata", 600.0);
        bebida2 = new Bebida(bebida, "Guaraná Lata", new BigDecimal("7.0"), 600.0);

        combo1.addProduto(hamburguer1);
        combo1.addProduto(hamburguer2);

        combo2.addProduto(bebida2);
        combo1.addProduto(combo2);

        itemPedido.setPedido(pedido);
        itemPedido.setProduto(combo1);

        assertEquals("Combo Quarta\n" +
                "\tDelicioso hambúrguer da linha premium\n" +
                "\tIrresistível hambúrguer da linha chicken\n" +
                "\tCombo de bebidas\n" +
                "\tCoca-Cola Lata + Guaraná Lata", itemPedido.getDescricaoItemPedido());
    }
}