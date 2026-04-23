package com.designPatterns.hamburgueria;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HamburguerTest {

    @Test
    @DisplayName("O combo big retorna um objeto concreto Presunto do tipo Adicional, portanto, a descrição deve ser Presunto")
    void deveRetornarDescricaoAdicionalDePresunto() {
        AbstractFactoryCombo factory = new ComboBigFactory();
        Hamburguer hamburguer = new Hamburguer(factory);
        assertEquals("Presunto", hamburguer.getDescricaoAdicional());
    }

    @Test
    @DisplayName("O combo friday retorna um objeto concreto Bacon do tipo Adicional, portanto, a descrição deve ser Bacon")
    void deveRetornarDescricaoAdicionalDeBacon() {
        AbstractFactoryCombo factory = new ComboFridayFactory();
        Hamburguer hamburguer = new Hamburguer(factory);
        assertEquals("Bacon", hamburguer.getDescricaoAdicional());
    }
}