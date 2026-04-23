package com.designPatterns.hamburgueria;

import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
public class ComboFridayFactory extends Combo{

    @Override
    public Picanha definirCarne(String ponto) {
        return new Picanha("Picanha", ponto, "Picanha");
    }

    @Override
    public Australiano definirPao() {
        return new Australiano("Australiano", "Pão");
    }

    @Override
    public Adicional definirAdicional(Produto produto) {
        return new Bacon(produto, "Bacon", new BigDecimal("5.00"));
    }
}
