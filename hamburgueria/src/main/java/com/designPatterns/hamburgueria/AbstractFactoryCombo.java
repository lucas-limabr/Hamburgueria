package com.designPatterns.hamburgueria;

public interface AbstractFactoryCombo {

    Ingrediente definirCarne();
    Ingrediente definirQueijo();
    Ingrediente definirPao();
    Ingrediente definirSalada();
    Adicional definirAdicional();
}
