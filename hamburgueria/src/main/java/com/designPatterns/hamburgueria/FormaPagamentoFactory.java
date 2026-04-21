package com.designPatterns.hamburgueria;

public abstract class FormaPagamentoFactory {

    public static IFormaPagamento obterFormaPagamento(String formaPagamento) {
        Object object = null;

        try {
            Class<?> classe = Class.forName("com.designPatterns.hamburgueria." + formaPagamento);

            object = classe.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new IllegalArgumentException("Forma de pagamento inexistente");
        }

        if (!(object instanceof IFormaPagamento)) {
            throw new IllegalArgumentException("Forma de pagamento inválida");
        }

        return (IFormaPagamento) object;
    }
}
