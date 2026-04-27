package com.designPatterns.hamburgueria;

import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
public class LinhaChicken extends Hamburguer{

    public LinhaChicken(String descricao, String titulo, BigDecimal precoBase, Double quantidade) {
        super(descricao, titulo, precoBase, quantidade);
    }

    public LinhaChicken(AbstractFactoryCombo factoryCombo, String pontoCarne) {
        super(factoryCombo, pontoCarne);
    }

    @Override
    public BigDecimal calculaPrecoNaPromocao() {
        return this.getPromocaoAdicional().calculaDesconto(this.getPrecoBase());
    }
}
