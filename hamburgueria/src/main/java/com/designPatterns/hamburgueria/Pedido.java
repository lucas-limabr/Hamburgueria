package com.designPatterns.hamburgueria;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
public class Pedido {

    private BigDecimal valorTotal;
    private LocalDateTime dataPedido;
    private BigDecimal cupomDesconto;
    private EstadoPedido estadoPedido;
    private Cliente cliente;
    private IFormaPagamento formaPagamento;

    public EstadoPedido setEstadoPedido(EstadoPedido estadoPedido) {
        return this.estadoPedido = estadoPedido;
    }

    public EstadoPedido getEstado() {return estadoPedido;};

    public boolean aceitar() {
        return estadoPedido.aceitar(this);
    }

    public boolean processarPagamento() {
        return estadoPedido.processarPagamento(this);
    }

    public boolean preparar() {
        return estadoPedido.preparar(this);
    }

    public boolean despachar() {
        return estadoPedido.despachar(this);
    }

    public boolean recusar() {
        return estadoPedido.recusar(this);
    }

    public boolean cancelar() {
        return estadoPedido.cancelar(this);
    }

    public boolean aguardarConfirmacao() {
        return estadoPedido.aguardarConfirmacao(this);
    }

    public boolean concluir() {
        return estadoPedido.concluir(this);
    }
}
