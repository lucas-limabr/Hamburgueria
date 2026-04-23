package com.designPatterns.hamburgueria;

import java.math.BigDecimal;

public interface AbstractFactoryCombo {

    Carne definirCarne(String ponto);
    Pao definirPao();
    Adicional definirAdicional(Produto produto);
}
