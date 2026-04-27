package com.designPatterns.hamburgueria;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.*;

public class HamburguerDecoratorTest {

    Hamburguer burguer;
    BigDecimal precoBase;

    @BeforeEach
    void setUp() {
        precoBase = new BigDecimal("30.00");
        burguer = new LinhaPremium("Hambúrguer irresistível com muito queijo", "Divino", precoBase, 1.0);
    }

    @Test
    @DisplayName("Deve retornar o preço base do hambúrguer")
    void getPrecoBase() {
        assertEquals(precoBase, burguer.getPrecoBase());
    }

    @Test
    @DisplayName("Deve retornar a descrição do hambúrguer")
    void getDescricao() {
        assertEquals("Hambúrguer irresistível com muito queijo", burguer.getDescricao());
    }

    @Test
    @DisplayName("Deve retornar o preço do hambúrguer acrescido com o valor do bacon")
    void deveRetornarPrecoHamburguerAcrescidoComBacon() {
        Produto bacon = new Bacon(burguer, "Bacon", new BigDecimal("5.00"));
        assertEquals(new BigDecimal("35.00"), bacon.getPrecoBase());
    }

    @Test
    @DisplayName("Deve retornar a descrição do hambúrguer acrescida com a descrição do bacon")
    void deveRetornarDescricaoHamburguerAcrescidaComBacon() {
        Bacon bacon = new Bacon(burguer, "Bacon", new BigDecimal("5.00"));
        String expected = "Hambúrguer irresistível com muito queijo + Bacon";
        assertEquals(expected, bacon.getDescricao());
    }

    @Test
    @DisplayName("Deve retornar o preço do hambúrguer acrescido com o valor do presunto")
    void deveRetornarPrecoHamburguerAcrescidoComPresunto() {
        Produto presunto = new Presunto(burguer, "Presunto", new BigDecimal("4.00"));
        assertEquals(new BigDecimal("34.00"), presunto.getPrecoBase());
    }

    @Test
    @DisplayName("Deve retornar o preço do hambúrguer acrescido com o valor do ovo")
    void deveRetornarPrecoHamburguerAcrescidoComOvo() {
        Produto ovo = new Ovo(burguer, "Ovo", new BigDecimal("3.00"));
        assertEquals(new BigDecimal("33.00"), ovo.getPrecoBase());
    }

    @Test
    @DisplayName("Deve retornar o preço do hambúrguer acrescido com o valor de uma bebida")
    void deveRetornarPrecoHamburguerAcrescidoComBebida() {
        Produto bebida = new Bebida(burguer, "Coca-Cola Lata", new BigDecimal("10.00"), 600.0);
        assertEquals(new BigDecimal("40.00"), bebida.getPrecoBase());
    }

    @Test
    @DisplayName("Deve retornar o preço do hambúrguer acrescido com o valor do presunto, mais o do ovo")
    void deveRetornarPrecoHamburguerAcrescidoComPresuntoEOvo() {
        Produto presunto = new Presunto(burguer, "Presunto", new BigDecimal("4.00"));
        Produto ovo = new Ovo(presunto, "Ovo", new BigDecimal("3.00"));
        assertEquals(new BigDecimal("37.00"), ovo.getPrecoBase());
    }

    @Test
    @DisplayName("Deve retornar o preço do hambúrguer acrescido com o valor do presunto, mais o do ovo e mais o do bacon")
    void deveRetornarPrecoHamburguerAcrescidoComPresuntoOvoEBacon() {
        Produto presunto = new Presunto(burguer, "Presunto", new BigDecimal("4.00"));
        Produto ovo = new Ovo(presunto, "Ovo", new BigDecimal("3.00"));
        Bacon bacon = new Bacon(ovo, "Bacon", new BigDecimal("5.00"));
        assertEquals(new BigDecimal("42.00"), bacon.getPrecoBase());
    }

    @Test
    @DisplayName("Deve retornar o preço do hambúrguer acrescido com o preço do presunto, mais o do ovo, mais o do bacon e mais o da bebida")
    void deveRetornarPrecoHamburguerAcrescidoComPresuntoOvoBaconEBebida() {
        Produto presunto = new Bacon(burguer, "Presunto", new BigDecimal("4.00"));
        Produto ovo = new Ovo(presunto, "Ovo", new BigDecimal("3.00"));
        Produto bacon = new Bacon(ovo, "Bacon", new BigDecimal("5.00"));
        Produto bebida = new Bebida(bacon, "Coca-Cola Lata", new BigDecimal("10.00"), 600.0);
        assertEquals(new BigDecimal("52.00"), bebida.getPrecoBase());
    }

    @Test
    @DisplayName("Deve retornar a descrição do hambúrguer acrescido com a descrição do presunto, mais o do ovo, mais o do bacon e mais a da bebida")
    void deveRetornarDescricaoHamburguerAcrescidoComPresuntoOvoBaconEBebida() {
        Presunto presunto = new Presunto(burguer, "Presunto", new BigDecimal("4.00"));
        Ovo ovo = new Ovo(presunto, "Ovo", new BigDecimal("3.00"));
        Bacon bacon = new Bacon(ovo, "Bacon", new BigDecimal("5.00"));
        Bebida bebida = new Bebida(bacon, "Coca-Cola Lata", new BigDecimal("10.00"), 600.0);
        String expected = "Hambúrguer irresistível com muito queijo + Presunto + Ovo + Bacon + Coca-Cola Lata";
        assertEquals(expected, bebida.getDescricao());
    }
}
