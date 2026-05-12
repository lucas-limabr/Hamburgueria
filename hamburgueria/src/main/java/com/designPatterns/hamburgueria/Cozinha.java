package com.designPatterns.hamburgueria;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Cozinha extends Setor {

    public Cozinha(Setor responsavelEtapaSeguinte) {
        super(responsavelEtapaSeguinte);
        this.responsabilidadeFuncional.add(PedidoEmPreparo.getInstance());
    }

    @Override
    public String getDescricaoSetor() {
        return "Setor responsável: Cozinha";
    }
}
