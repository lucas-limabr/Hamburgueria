package com.designPatterns.hamburgueria;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class ComboTest {

    Hamburguer hamburguer1;
    Hamburguer hamburguer2;
    DescontoFixo descontoFixo;
    Bebida bebida;

    @BeforeEach
    void setUp() {
        hamburguer1 = new LinhaPremium("Delicioso hambúrguer da linha premium", "Hambúrguer Linha Premium", new BigDecimal("45.00"), 1.0);
        hamburguer2 = new LinhaChicken("Irresistível hambúrguer da linha chicken", "Hambúrguer Linha Chicken", new BigDecimal("25.00"), 1.0);
        descontoFixo = new DescontoFixo(new BigDecimal("5.00"));
    }

    @Test
    @DisplayName("Deve retornar false, pois, nenhum produto que está contido no combo tem alguma promoção associada ")
    void deveRetornarFalsePoisNenhumProdutoEstaNaPromocao() {
        Combo combo = new Combo("Combo de bebidas");
        bebida = new Bebida(hamburguer1, "Coca-Cola Lata", new BigDecimal("10.00"), 600.0);
        combo.addProduto(bebida);
        Iterator<Produto> iterator = combo.getIteratorHamburguerNaPromocao();
        assertFalse(iterator.hasNext());
    }

    @Test
    @DisplayName("Deve retornar true, pois, há um hambúrguer que está contido no combo que possui alguma promoção associada ")
    void deveRetornarTruePoisTemHamburguerNaPromocao() {
        Combo combo = new Combo("Combo de bebidas");
        hamburguer1.setPromocaoLinha(descontoFixo);
        combo.addProduto(hamburguer1);
        combo.addProduto(hamburguer2);
        Iterator<Produto> iterator = combo.getIteratorHamburguerNaPromocao();
        assertTrue(iterator.hasNext());
    }

    @Test
    @DisplayName("Deve retornar true, pois, há um hambúrguer contido no combo que possui alguma promoção associada ")
    void deveRetornarOHamburguerQueEstaNaPromocao() {
        Combo combo = new Combo("Combo de bebidas");
        combo.addProduto(hamburguer1);
        hamburguer2.setPromocaoLinha(descontoFixo);
        combo.addProduto(hamburguer2);
        Iterator<Produto> iterator = combo.getIteratorHamburguerNaPromocao();

        if (iterator.hasNext()) {
            assertEquals(hamburguer2, iterator.next());
        }
    }

    @Test
    @DisplayName("Deve lançar exceção ao chamar método next quando ele não é precedido por hashNext e não tem nenhum produto na promoção")
    void deveLancarExcecaoAoChamarMetodoNextSemHasNextQuandoNaoTemProdutoNaPromocao() {
        Combo combo = new Combo("Combo de bebidas");
        combo.addProduto(hamburguer1);
        combo.addProduto(hamburguer2);
        Iterator<Produto> iterator = combo.getIteratorHamburguerNaPromocao();

        NoSuchElementException e = assertThrows(NoSuchElementException.class, iterator::next);
        assertEquals("Não foi encontrado nenhum hambúrguer na promoção", e.getMessage());
    }
}