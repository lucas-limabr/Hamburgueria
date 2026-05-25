package com.designPatterns.hamburgueria;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
public abstract class HamburguerDecorator implements Produto {

    private Produto produto;

    @Override
    public BigDecimal getPrecoBase() {
        if (this.produto == null) {
            return this.getValorAcrescido();
        }
        return this.produto.getPrecoBase().add(this.getValorAcrescido());
    }

    @Override
    public String getDescricao() {
        if (this.produto == null) {
            return this.getDescricaoDecorador();
        }
        return this.produto.getDescricao() + " + " + this.getDescricaoDecorador();
    }

    public abstract BigDecimal getValorAcrescido();

    public abstract String getDescricaoDecorador();
}
