package com.designPatterns.hamburgueria;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class HamburguerTest {

    String tituloComboBig;
    String descricaoComboBig;
    BigDecimal precoBaseComboBig;
    Double quantidadeComboBig;

    String tituloComboFriday;
    String descricaoComboFriday;
    BigDecimal precoBaseComboFriday;
    Double quantidadeComboFriday;

    @BeforeEach
    void setUp() {
        tituloComboBig = "Combo Big";
        descricaoComboBig = "Combo saboroso de carne Angus";
        precoBaseComboBig = new BigDecimal("40.00");
        quantidadeComboBig = 1.0;

        tituloComboFriday = "Combo Friday";
        descricaoComboFriday = "Combo irresistível de carne Picanha";
        precoBaseComboFriday = new BigDecimal("50.00");
        quantidadeComboFriday = 1.0;
    }

    @Test
    @DisplayName("O combo big instancia um objeto concreto Presunto do tipo Adicional, portanto, a descrição deve ser Presunto")
    void deveRetornarDescricaoAdicionalDePresuntoParaComboBig() {
        AbstractFactoryHamburguer factory = new HamburguerBigFactory();
        Hamburguer hamburguer = new LinhaPremium(factory, tituloComboBig, descricaoComboBig, precoBaseComboBig, quantidadeComboBig);
        assertEquals("Presunto", hamburguer.getDescricaoAdicional());
    }

    @Test
    @DisplayName("O combo friday instancia um objeto concreto Bacon do tipo Adicional, portanto, a descrição deve ser Bacon")
    void deveRetornarDescricaoAdicionalDeBaconParaComboFriday() {
        AbstractFactoryHamburguer factory = new HamburguerFridayFactory();
        Hamburguer hamburguer = new LinhaChicken(factory, tituloComboFriday, descricaoComboFriday, precoBaseComboFriday, quantidadeComboFriday);
        assertEquals("Bacon", hamburguer.getDescricaoAdicional());
    }

    @Test
    @DisplayName("O combo friday instancia um objeto concreto Picanha do tipo Carne, portanto, o tipo da carne deve ser Picanha")
    void deveRetornarTipoCarneAngusParaComboFriday() {
        AbstractFactoryHamburguer factory = new HamburguerFridayFactory();
        Hamburguer hamburguer = new LinhaPremium(factory, tituloComboFriday, descricaoComboFriday, precoBaseComboFriday, quantidadeComboFriday);
        assertEquals("Picanha", hamburguer.getTipoCarne());
    }

    @Test
    @DisplayName("O combo big instancia um objeto concreto Angus do tipo Carne, portanto, o tipo da carne deve ser Angus")
    void deveRetornarTipoCarneAngusParaComboBig() {
        AbstractFactoryHamburguer factory = new HamburguerBigFactory();
        Hamburguer hamburguer = new LinhaPremium(factory, tituloComboBig, descricaoComboBig, precoBaseComboBig, quantidadeComboBig);
        assertEquals("Angus", hamburguer.getTipoCarne());
    }
}