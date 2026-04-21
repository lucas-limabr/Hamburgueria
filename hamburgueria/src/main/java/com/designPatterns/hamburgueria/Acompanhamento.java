package com.designPatterns.hamburgueria;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@Data
public abstract class Acompanhamento extends HamburguerDecorator {

    private BigDecimal preco;
    private String descricaoAcompanhamento;
    private Double tamanho;

    public Acompanhamento(){}

    public Acompanhamento(Produto produto, String descricaoAcompanhamento, BigDecimal preco, Double tamanho)
    {
        super(produto);
        this.descricaoAcompanhamento = descricaoAcompanhamento;
        this.preco = preco;
        this.tamanho = tamanho;
    }

    public abstract BigDecimal getValorAcrescido();
    public abstract String getDescricaoDecorador();
}
