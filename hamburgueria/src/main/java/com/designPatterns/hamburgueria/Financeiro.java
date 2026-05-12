package com.designPatterns.hamburgueria;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Financeiro extends Setor {
    public Financeiro(Setor responsavelEtapaSeguinte) {
        super(responsavelEtapaSeguinte);
        this.responsabilidadeFuncional.add(PagamentoPedidoProcessado.getInstance());
    }

    @Override
    public String getDescricaoSetor() {
        return "Setor responsável: Financeiro";
    }
}
