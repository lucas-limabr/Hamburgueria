package com.designPatterns.hamburgueria;

import java.math.BigDecimal;
import java.util.List;

public class RelatorioFaturamentoConsole extends ExportadorRelatorioTemplate {

    @Override
    protected String gerarCorpo(List<Pedido> pedidos) {
        StringBuilder sb = new StringBuilder();
        for (Pedido p : pedidos) {
            sb.append("Pedido às ").append(p.getDataPedido().toLocalTime())
                    .append(" | Valor: R$ ").append(p.getValorTotal()).append("\n");
        }
        return sb.toString();
    }

    @Override
    protected String gerarRodape(List<Pedido> pedidos) {
        BigDecimal total = pedidos.stream()
                .map(Pedido::getValorTotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        return "Total Faturado: R$ " + total + "\n=========================================\n";
    }

    @Override
    protected String transmitir(String conteudoRelatorio) {
        // Envia direto para o console
        System.out.print(conteudoRelatorio);
        return "Console";
    }
}