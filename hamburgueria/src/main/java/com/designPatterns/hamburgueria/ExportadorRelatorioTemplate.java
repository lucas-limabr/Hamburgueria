package com.designPatterns.hamburgueria;

import java.util.List;

public abstract class ExportadorRelatorioTemplate {

    public final String exportar(List<Pedido> pedidos) {
        if (pedidos == null || pedidos.isEmpty()) {
            return "Sem dados para exportar.";
        }

        StringBuilder documento = new StringBuilder();
        documento.append(gerarCabecalho());
        documento.append(gerarCorpo(pedidos));
        documento.append(gerarRodape(pedidos));

        return transmitir(documento.toString());
    }

    private String gerarCabecalho() {
        return "=== HAMBURGUERIA - RELATÓRIO DE VENDAS ===\n";
    }

    protected abstract String gerarCorpo(List<Pedido> pedidos);
    protected abstract String gerarRodape(List<Pedido> pedidos);
    protected abstract String transmitir(String conteudoRelatorio);
}