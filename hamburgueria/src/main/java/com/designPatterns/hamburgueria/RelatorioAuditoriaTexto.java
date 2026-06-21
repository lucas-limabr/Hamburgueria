package com.designPatterns.hamburgueria;

import java.util.List;

public class RelatorioAuditoriaTexto extends ExportadorRelatorioTemplate {

    @Override
    protected String gerarCorpo(List<Pedido> pedidos) {
        return "Total de pedidos processados no período: " + pedidos.size() + "\n";
    }

    @Override
    protected String gerarRodape(List<Pedido> pedidos) {
        long cancelados = pedidos.stream()
                .filter(p -> p.getEstado().getClass().getSimpleName().contains("Cancelado") ||
                        p.getEstado().getClass().getSimpleName().contains("Recusado"))
                .count();
        return "Alertas de Cancelamento: " + cancelados + "\n=========================================\n";
    }

    @Override
    protected String transmitir(String conteudoRelatorio) {
        return conteudoRelatorio;
    }
}