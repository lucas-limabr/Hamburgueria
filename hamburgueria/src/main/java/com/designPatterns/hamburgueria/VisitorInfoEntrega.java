package com.designPatterns.hamburgueria;

public class VisitorInfoEntrega implements IVisitor {

    public String exibirInfoEntrega(Entrega entrega) {
        return entrega.exibirInfoEntrega(this);
    }

    @Override
    public String visit(Delivery tipoEntrega) {
        return "Entrega via delivery de código " + tipoEntrega.getCodigo() + " no endereço: \n" + tipoEntrega.getEndereco().toString();
    }

    @Override
    public String visit(InLoco tipoEntrega) {
        return "Entrega local na mesa " + tipoEntrega.getNumeroMesa();
    }
}
