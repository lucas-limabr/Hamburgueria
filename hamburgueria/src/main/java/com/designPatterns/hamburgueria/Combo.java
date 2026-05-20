package com.designPatterns.hamburgueria;

import java.math.BigDecimal;

public class Combo extends Hamburguer {

    public Combo(AbstractFactoryCombo factoryCombo, String pontoCarne, String descricao, String titulo, BigDecimal precoBase, Double quantidade) {
        super(factoryCombo, pontoCarne, descricao, titulo, precoBase, quantidade);
    }

    @Override
    public BigDecimal calculaPrecoNaPromocao() {
        if (this.getPromocaoLinha() == null) {
            return this.getPrecoBase();
        }

        return this.getPromocaoLinha().calculaDesconto(this.getPrecoBase());
    }
}
