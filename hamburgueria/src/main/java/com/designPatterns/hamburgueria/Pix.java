package com.designPatterns.hamburgueria;

public class Pix implements IFormaPagamento {
    @Override
    public String processarPagamento() {

        return "Pagamento feito com pix";
    }
}
