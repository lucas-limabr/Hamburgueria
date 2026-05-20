package com.designPatterns.hamburgueria;

import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
public class LinhaChicken extends Hamburguer{

    public LinhaChicken(String descricao, String titulo, BigDecimal precoBase, Double quantidade) {
        super(descricao, titulo, precoBase, quantidade);
    }

    public LinhaChicken(AbstractFactoryCombo factoryCombo, String pontoCarne, String descricao, String titulo, BigDecimal precoBase, Double quantidade) {
        super(factoryCombo, pontoCarne, descricao, titulo, precoBase, quantidade);
    }

    @Override
    public BigDecimal calculaPrecoNaPromocao() {
        if(this.getPromocaoLinha() == null)
        {
            return this.getPrecoBase();
        }

        return this.getPromocaoLinha().calculaDesconto(this.getPrecoBase());
    }
}
