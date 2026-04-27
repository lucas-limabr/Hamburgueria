package com.designPatterns.hamburgueria;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
@Data
public abstract class Hamburguer implements Produto {

    private String descricao;
    private String titulo;
    private BigDecimal precoBase;
    private Double quantidade;
    private PromocaoLinha promocaoAdicional;
    private Adicional adicional;
    private Carne carne;
    private Pao pao;

    public Hamburguer(String descricao, String titulo, BigDecimal precoBase, Double quantidade) {
        this.descricao = descricao;
        this.titulo = titulo;
        this.precoBase = precoBase;
        this.quantidade = quantidade;
    }

    public Hamburguer(AbstractFactoryCombo factoryCombo, String pontoCarne) {
        this.adicional = factoryCombo.definirAdicional(this);
        this.carne = factoryCombo.definirCarne(pontoCarne);
        this.pao = factoryCombo.definirPao();
    }

    public String getDescricaoAdicional() {
        return adicional.getDescricaoAdicional();
    }

    public String getTipoCarne() {
        return carne.getTipo();
    }

    public String getTipoPao() {
        return pao.getTipo();
    }

    public abstract BigDecimal calculaPrecoNaPromocao();

    @Override
    public BigDecimal getPrecoBase() {
        return precoBase;
    }

    @Override
    public String getDescricao() {
        return descricao;
    }
}
