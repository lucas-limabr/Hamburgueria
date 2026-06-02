package com.designPatterns.hamburgueria;

public class AguardaConfirmacaoCommand implements Command{

    Pedido pedido;

    public AguardaConfirmacaoCommand(Pedido pedido) {
        this.pedido = pedido;
    }

    @Override
    public boolean execute() {
        return pedido.aguardarConfirmacao();
    }
}
