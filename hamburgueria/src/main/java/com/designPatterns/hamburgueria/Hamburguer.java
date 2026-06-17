package com.designPatterns.hamburgueria;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Objects;

@NoArgsConstructor
@Data
public abstract class Hamburguer implements Produto, Prototype {

    private String descricao;
    private String titulo;
    private BigDecimal precoBase;
    private Double quantidade;
    private PromocaoLinha promocaoLinha;
    private Adicional adicional;
    private Carne carne;
    private Pao pao;

    public static Hamburguer defineLinha(String nomeLinha, AbstractFactoryHamburguer factoryCombo, String descricao, String titulo, BigDecimal precoBase, Double quantidade) {
        Map<String, Hamburguer> linha = Map.of(
                "Linha Premium", new LinhaPremium(factoryCombo, descricao, titulo, precoBase, quantidade),
                "Linha Chicken", new LinhaChicken(factoryCombo, descricao, titulo, precoBase, quantidade)
        );

        return linha.get(nomeLinha);
    }

    public Hamburguer(String descricao, String titulo, BigDecimal precoBase, Double quantidade) {
        this.descricao = descricao;
        this.titulo = titulo;
        this.precoBase = precoBase;
        this.quantidade = quantidade;
    }

    public Hamburguer(AbstractFactoryHamburguer factoryCombo, String descricao, String titulo, BigDecimal precoBase, Double quantidade) {
        this(descricao, titulo, precoBase, quantidade);
        this.adicional = factoryCombo.definirAdicional(this);
        this.carne = factoryCombo.definirCarne();
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

    @Override
    public PromocaoLinha getPromocao() {
        return this.getPromocaoLinha();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Hamburguer that = (Hamburguer) o;
        return Objects.equals(descricao, that.descricao) && Objects.equals(titulo, that.titulo) && Objects.equals(precoBase, that.precoBase) && Objects.equals(quantidade, that.quantidade);
    }

    @Override
    public int hashCode() {
        return Objects.hash(descricao, titulo, precoBase, quantidade);
    }

    public abstract Hamburguer clone();
}
