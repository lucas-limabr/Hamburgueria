package com.designPatterns.hamburgueria;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@NoArgsConstructor
public class ComboFridayFactory implements AbstractFactoryCombo {

    private boolean ativo;
    private LocalDateTime dataLimiteUso;

    public ComboFridayFactory(boolean ativo, int validade) {
        this.ativo = ativo;
        this.definirDataLimiteUso(validade);
    }

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

    public void definirDataLimiteUso(int validade) {
        this.dataLimiteUso = LocalDateTime.now().plusDays(validade);
    }
}
