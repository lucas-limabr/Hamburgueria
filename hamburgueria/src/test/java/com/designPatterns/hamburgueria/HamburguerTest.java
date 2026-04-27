package com.designPatterns.hamburgueria;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HamburguerTest {

    @Test
    @DisplayName("O combo big instancia um objeto concreto Presunto do tipo Adicional, portanto, a descrição deve ser Presunto")
    void deveRetornarDescricaoAdicionalDePresuntoParaComboBig() {
        AbstractFactoryCombo factory = new ComboBigFactory();
        Hamburguer hamburguer = new LinhaPremium(factory, "ao ponto");
        assertEquals("Presunto", hamburguer.getDescricaoAdicional());
    }

    @Test
    @DisplayName("O combo friday instancia um objeto concreto Bacon do tipo Adicional, portanto, a descrição deve ser Bacon")
    void deveRetornarDescricaoAdicionalDeBaconParaComboFriday() {
        AbstractFactoryCombo factory = new ComboFridayFactory();
        Hamburguer hamburguer = new LinhaChicken(factory, "mal passada");
        assertEquals("Bacon", hamburguer.getDescricaoAdicional());
    }

    @Test
    @DisplayName("O combo friday instancia um objeto concreto Picanha do tipo Carne, portanto, o tipo da carne deve ser Picanha")
    void deveRetornarTipoCarneAngusParaComboFriday() {
        AbstractFactoryCombo factory = new ComboFridayFactory();
        Hamburguer hamburguer = new LinhaPremium(factory, "mal passada");
        assertEquals("Picanha", hamburguer.getTipoCarne());
    }

    @Test
    @DisplayName("O combo big instancia um objeto concreto Angus do tipo Carne, portanto, o tipo da carne deve ser Angus")
    void deveRetornarTipoCarneAngusParaComboBig() {
        AbstractFactoryCombo factory = new ComboBigFactory();
        Hamburguer hamburguer = new LinhaPremium(factory, "mal passada");
        assertEquals("Angus", hamburguer.getTipoCarne());
    }
}