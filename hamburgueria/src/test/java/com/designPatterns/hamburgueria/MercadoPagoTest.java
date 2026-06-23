package com.designPatterns.hamburgueria;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.*;

class MercadoPagoTest {

    @Test
    void deveProcessarPagamentoViaAdapterComSucesso() {
        MercadoPagoSDK sdkReal = new MercadoPagoSDK();
        IFormaPagamento adapter = new MercadoPagoAdapter(sdkReal, "TEST-TOKEN-123", new BigDecimal("50.00"));

        String resultado = adapter.processarPagamento();

        assertEquals("Pagamento feito via MercadoPago com sucesso", resultado);
    }

    @Test
    void deveBarrarPagamentoSeTokenEstiverVazio() {
        MercadoPagoSDK sdkReal = new MercadoPagoSDK();
        IFormaPagamento adapter = new MercadoPagoAdapter(sdkReal, "", new BigDecimal("50.00"));

        String resultado = adapter.processarPagamento();

        assertEquals("Falha no pagamento: Gateway não configurado.", resultado);
    }

    @Test
    void deveBarrarPagamentoSeTokenForNulo() {
        MercadoPagoSDK sdkReal = new MercadoPagoSDK();
        IFormaPagamento adapter = new MercadoPagoAdapter(sdkReal, null, new BigDecimal("50.00"));

        String resultado = adapter.processarPagamento();

        assertEquals("Falha no pagamento: Gateway não configurado.", resultado);
    }

    @Test
    void deveRetornarInvalidoSeFaltarValorDoPedido() {
        MercadoPagoSDK sdkReal = new MercadoPagoSDK();
        IFormaPagamento adapter = new MercadoPagoAdapter(sdkReal, "TEST-TOKEN-123", null);

        boolean valido = adapter.isValido();

        assertFalse(valido);
    }

    @Test
    void deveRetornarValidoComDadosCompletos() {
        MercadoPagoSDK sdkReal = new MercadoPagoSDK();
        IFormaPagamento adapter = new MercadoPagoAdapter(sdkReal, "TEST-TOKEN-123", new BigDecimal("50.00"));

        boolean valido = adapter.isValido();

        assertTrue(valido);
    }
}