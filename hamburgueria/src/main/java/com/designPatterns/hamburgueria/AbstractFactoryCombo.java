package com.designPatterns.hamburgueria;

import java.math.BigDecimal;

public interface AbstractFactoryCombo {

    Ingrediente definirCarne(String tipo, String ponto, String descricao);
    Ingrediente definirQueijo(String tipo, String descricao);
    Ingrediente definirPao(String tipo, String descricao);
    Ingrediente definirSalada(String descricao);
    Adicional definirAdicional(Produto produto);
}
