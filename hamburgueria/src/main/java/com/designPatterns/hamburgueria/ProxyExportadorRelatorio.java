package com.designPatterns.hamburgueria;

import java.util.List;

public class ProxyExportadorRelatorio {

    private final ExportadorRelatorioTemplate exportadorReal;
    private final String tokenSecretoSistema;

    public ProxyExportadorRelatorio(ExportadorRelatorioTemplate exportadorReal, String tokenSecretoSistema) {
        this.exportadorReal = exportadorReal;
        this.tokenSecretoSistema = tokenSecretoSistema;
    }

    public String exportar(List<Pedido> pedidos, String tokenAcesso) {
        if (tokenAcesso == null || !tokenAcesso.equals(tokenSecretoSistema)) {
            throw new SecurityException("Acesso negado: Token de exportação inválido ou expirado.");
        }
        return exportadorReal.exportar(pedidos);
    }
}