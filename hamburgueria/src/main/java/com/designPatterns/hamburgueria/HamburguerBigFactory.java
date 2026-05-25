package com.designPatterns.hamburgueria;

import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@NoArgsConstructor
public class HamburguerBigFactory implements AbstractFactoryHamburguer {

    private boolean ativo;
    private LocalDateTime dataLimiteUso;

    public HamburguerBigFactory(boolean ativo, int validade) {
        this.ativo = ativo;
        this.definirDataLimiteUso(validade);
    }

    @Override
    public Angus definirCarne() {
        return new Angus("Angus", "Carne");
    }

    @Override
    public Brioche definirPao() {
        return new Brioche("Brioche", "Pão");
    }

    @Override
    public Presunto definirAdicional(Produto produto) {
        return new Presunto(produto, "Presunto", new BigDecimal("4.00"));
    }

    public void definirDataLimiteUso(int validade) {
        this.dataLimiteUso = LocalDateTime.now().plusDays(validade);
    }
}
