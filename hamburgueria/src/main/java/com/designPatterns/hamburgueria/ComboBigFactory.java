package com.designPatterns.hamburgueria;

import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
public class ComboBigFactory extends Combo {

    public ComboBigFactory(boolean ativo) {
        super(ativo);
    }

    @Override
    public Angus definirCarne(String ponto) {
        return new Angus("Angus", ponto, "Carne");
    }

    @Override
    public Brioche definirPao() {
        return new Brioche("Brioche", "Pão");
    }

    @Override
    public Presunto definirAdicional(Produto produto) {
        return new Presunto(produto, "Presunto", new BigDecimal("4.00"));
    }
}
