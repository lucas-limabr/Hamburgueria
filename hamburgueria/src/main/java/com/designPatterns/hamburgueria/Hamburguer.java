package com.designPatterns.hamburgueria;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
public class Hamburguer implements Produto{

    private String descricao;
    private String titulo;
    private BigDecimal precoBase;
    private Double quantidade;

    @Getter
    private Adicional adicional;

    public Hamburguer(String descricao, String titulo, BigDecimal precoBase, Double quantidade) {
        this.descricao = descricao;
        this.titulo = titulo;
        this.precoBase = precoBase;
        this.quantidade = quantidade;
    }

    public Hamburguer(AbstractFactoryCombo factoryCombo)
    {
        this.adicional = factoryCombo.definirAdicional(this);
    }

    public String getDescricaoAdicional()
    {
        return adicional.getDescricaoAdicional();
    }

    public BigDecimal getPrecoAdicional()
    {
        return adicional.getPreco();
    }

    @Override
    public BigDecimal getPrecoBase() {
        return precoBase;
    }

    @Override
    public String getDescricao() {
        return descricao;
    }
}
