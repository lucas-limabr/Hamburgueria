package com.designPatterns.hamburgueria;

public class MercadoPagoSDK {

    private boolean autorizado = false;

    public void registrarToken(String token) {
        if (token != null && !token.isEmpty()) {
            this.autorizado = true;
        }
    }

    public String realizarCobrança(double valor) {
        if (!autorizado) {
            return "ERRO_AUTH";
        }
        return "SUCCESS_MP_" + valor;
    }
}