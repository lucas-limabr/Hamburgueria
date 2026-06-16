package com.designPatterns.hamburgueria;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class Delivery extends Entrega {

    private String codigo;
    private Endereco endereco;

    public Delivery(String codigo, Endereco endereco, Pedido pedido) {
        this.codigo = codigo;
        this.endereco = endereco;
        super(pedido);
    }

    public Delivery(Setor responsavelEtapaSeguinte) {
        super(responsavelEtapaSeguinte);
    }

    @Override
    public String getDescricaoSetor() {
        return "Setor responsável: Entrega via delivery";
    }

    @Override
    public String exibirInfoEntrega(IVisitor visitorInfoEntrega) {
        return visitorInfoEntrega.visit(this);
    }
}
