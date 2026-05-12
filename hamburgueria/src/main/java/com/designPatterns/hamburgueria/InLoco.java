package com.designPatterns.hamburgueria;

public class InLoco extends Entrega {

    public String numeroMesa;

    public InLoco(String numeroMesa, Pedido pedido) {
        this.numeroMesa = numeroMesa;
        super(pedido);
    }

    public InLoco(Setor responsavelEtapaSeguinte) {
        super(responsavelEtapaSeguinte);
    }

    @Override
    public String getDescricaoSetor() {
        return "Setor responsável: Entrega in loco via garçom";
    }
}
