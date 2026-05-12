package com.designPatterns.hamburgueria;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@NoArgsConstructor
@Data
public abstract class Setor {

    protected ArrayList<EstadoPedido> responsabilidadeFuncional = new ArrayList<>();
    private Setor responsavelEtapaSeguinte;

    public Setor(Setor responsavelEtapaSeguinte) {
        this.responsavelEtapaSeguinte = responsavelEtapaSeguinte;
    }

    public abstract String getDescricaoSetor();

    public String processarPedido(Pedido pedido) {
        if (responsabilidadeFuncional.contains(pedido.getEstado())) {
            return getDescricaoSetor();
        } else {
            if (responsavelEtapaSeguinte != null) {
                return responsavelEtapaSeguinte.processarPedido(pedido);
            } else {
                return "Não foi possível processar o pedido";
            }
        }
    }
}
