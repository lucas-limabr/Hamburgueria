package com.designPatterns.hamburgueria;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
public abstract class Entrega extends Setor {

    private Pedido pedido;

    public Entrega(Setor responsavelEtapaSeguinte) {
        super(responsavelEtapaSeguinte);
        super.responsabilidadeFuncional.add(PedidoDespachado.getInstance());
    }

    public BigDecimal calculaTaxaEntrega() {
        return null;
    }

    public abstract String exibirInfoEntrega(IVisitor visitorInfoEntrega);
}
