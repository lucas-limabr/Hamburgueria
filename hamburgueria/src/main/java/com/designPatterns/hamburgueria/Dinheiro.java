package com.designPatterns.hamburgueria;

public class Dinheiro implements IFormaPagamento{
    @Override
    public String processarPagamento() {
        return "Pagamento feito com dinheiro";
    }

    @Override
    public boolean isValido() {
        return true;
    }
}
