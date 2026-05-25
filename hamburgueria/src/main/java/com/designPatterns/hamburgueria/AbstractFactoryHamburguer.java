package com.designPatterns.hamburgueria;

public interface AbstractFactoryHamburguer {

    Carne definirCarne();
    Pao definirPao();
    Adicional definirAdicional(Produto produto);
}
