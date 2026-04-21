package com.designPatterns.hamburgueria;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
public class Bebida extends Acompanhamento {

    public Bebida(Produto produto, String descricaoAcompanhamento, BigDecimal preco, Double tamanho) {
        super(produto, descricaoAcompanhamento, preco, tamanho);
    }

    public Bebida(BigDecimal preco, String descricao, Double tamanho) {
        super(preco, descricao, tamanho);
    }

    @Override
    public BigDecimal getValorAcrescido() {
        return super.getPreco();
    }

    @Override
    public String getDescricaoDecorador() {
        return super.getDescricaoAcompanhamento();
    }
}
