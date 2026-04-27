package com.designPatterns.hamburgueria;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.math.RoundingMode;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Data
public class LinhaPremium extends Hamburguer {

    private final BigDecimal limitePercentualDesconto = new BigDecimal("0.1");

    public LinhaPremium(String descricao, String titulo, BigDecimal precoBase, Double quantidade) {
        super(descricao, titulo, precoBase, quantidade);
    }

    public LinhaPremium(AbstractFactoryCombo factoryCombo, String pontoCarne) {
        super(factoryCombo, pontoCarne);
    }

    @Override
    public BigDecimal calculaPrecoNaPromocao() {
        BigDecimal descontoCalculado = this.getPromocaoAdicional().calculaDesconto(this.getPrecoBase());
        BigDecimal valorMinimo = this.defineValorMinimoParaPromocao();

        if (valorMinimo.compareTo(descontoCalculado) > 0) {
            return valorMinimo;
        }
        return descontoCalculado;
    }

    public BigDecimal defineValorMinimoParaPromocao() {
        return this.getPrecoBase().subtract(this.getPrecoBase().multiply(limitePercentualDesconto)).setScale(2, RoundingMode.HALF_UP);
    }
}
