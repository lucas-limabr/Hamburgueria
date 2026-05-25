package com.designPatterns.hamburgueria;

import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
public class LinhaChicken extends Hamburguer{

    public LinhaChicken(String descricao, String titulo, BigDecimal precoBase, Double quantidade) {
        super(descricao, titulo, precoBase, quantidade);
    }

    public LinhaChicken(AbstractFactoryHamburguer factoryCombo, String descricao, String titulo, BigDecimal precoBase, Double quantidade) {
        super(factoryCombo, descricao, titulo, precoBase, quantidade);
    }

    @Override
    public BigDecimal calculaPrecoNaPromocao() {
        if(this.getPromocaoLinha() == null)
        {
            return this.getPrecoBase();
        }

        return this.getPromocaoLinha().calculaDesconto(this.getPrecoBase());
    }

    @Override
    public String toString() {
        return "LinhaChicken{ " + super.toString() + "}";
    }
}
