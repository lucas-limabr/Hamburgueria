package com.designPatterns.hamburgueria;

import java.math.BigDecimal;

public class MercadoPagoAdapter implements IFormaPagamento {

    private final MercadoPagoSDK sdk;
    private final String tokenAcesso;
    private final BigDecimal valorPedido;

    public MercadoPagoAdapter(MercadoPagoSDK sdk, String tokenAcesso, BigDecimal valorPedido) {
        this.sdk = sdk;
        this.tokenAcesso = tokenAcesso;
        this.valorPedido = valorPedido;
    }

    @Override
    public String processarPagamento() {
        if (!isValido()) {
            return "Falha no pagamento: Gateway não configurado.";
        }
        sdk.registrarToken(tokenAcesso);
        String resultado = sdk.realizarCobrança(valorPedido.doubleValue());
        if ("ERRO_AUTH".equals(resultado)) {
            return "Falha na autenticação com o gateway externo.";
        }
        return "Pagamento feito via MercadoPago com sucesso";
    }

    @Override
    public boolean isValido() {
        return tokenAcesso != null && !tokenAcesso.trim().isEmpty() && valorPedido != null;
    }
}