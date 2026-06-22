package com.designPatterns.hamburgueria;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class ProxyRelatorioTest {

    @Test
    void devePermitirExportacaoQuandoTokenForCorreto() {
        ProxyExportadorRelatorio proxy = new ProxyExportadorRelatorio(new RelatorioAuditoriaTexto(), "CHAVE-SECRETA-123");

        Pedido p1 = new Pedido(new BigDecimal("10.00"), LocalDateTime.now(), BigDecimal.ZERO, null, null, null);
        p1.setEstadoPedido(PedidoConcluido.getInstance());

        List<Pedido> lista = List.of(p1);

        String resultado = proxy.exportar(lista, "CHAVE-SECRETA-123");

        assertTrue(resultado.contains("=== HAMBURGUERIA"));
    }

    @Test
    void deveLancarExcecaoQuandoTokenForIncorreto() {
        ProxyExportadorRelatorio proxy = new ProxyExportadorRelatorio(new RelatorioAuditoriaTexto(), "CHAVE-SECRETA-123");
        List<Pedido> lista = new ArrayList<>();

        assertThrows(SecurityException.class, () -> proxy.exportar(lista, "TOKEN-ERRADO"));
    }

    @Test
    void deveLancarExcecaoQuandoTokenForNulo() {
        ProxyExportadorRelatorio proxy = new ProxyExportadorRelatorio(new RelatorioAuditoriaTexto(), "CHAVE-SECRETA-123");
        List<Pedido> lista = new ArrayList<>();

        assertThrows(SecurityException.class, () -> proxy.exportar(lista, null));
    }
}