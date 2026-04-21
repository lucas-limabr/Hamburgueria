package com.designPatterns.hamburgueria;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Data
public abstract class Adicional extends HamburguerDecorator {

    private BigDecimal preco;
    private String descricaoAdicional;

    public Adicional(Produto produto, String descricaoAdicional, BigDecimal preco){
        super(produto);
        this.descricaoAdicional = descricaoAdicional;
        this.preco = preco;
    }

    public Adicional(String descricaoAdicional, BigDecimal preco){
        this.descricaoAdicional = descricaoAdicional;
        this.preco = preco;
    }

    public abstract BigDecimal getValorAcrescido();
    public abstract String getDescricaoDecorador();
}
