package com.designPatterns.hamburgueria;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@NoArgsConstructor
public class ComboBigFactory implements AbstractFactoryCombo {

    private boolean ativo;
    private LocalDateTime dataLimiteUso;

    public ComboBigFactory(boolean ativo, int validade) {
        this.ativo = ativo;
        this.definirDataLimiteUso(validade);
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

    public void definirDataLimiteUso(int validade) {
        this.dataLimiteUso = LocalDateTime.now().plusDays(validade);
    }
}
