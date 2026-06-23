package com.designPatterns.hamburgueria;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Observable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Pedido extends Observable {

    private BigDecimal valorTotal;
    private LocalDateTime dataPedido;
    private BigDecimal cupomDesconto;
    private EstadoPedido estadoPedido = PedidoRealizado.getInstance();
    private Cliente cliente;
    private IFormaPagamento formaPagamento;

    public PedidoMemento salvar() {
        return new PedidoMemento(this.valorTotal, this.cupomDesconto);
    }

    public void restaurar(PedidoMemento memento) {
        if (memento != null) {
            this.valorTotal = memento.getValorTotal();
            this.cupomDesconto = memento.getCupomDesconto();
        }
    }

    public void definirFormaPagamento(String formaPagamento) {
        this.formaPagamento = FormaPagamentoFactory.obterFormaPagamento(formaPagamento);
    }

    public EstadoPedido setEstadoPedido(EstadoPedido estadoPedido) {
        this.estadoPedido = estadoPedido;
        setChanged();
        notifyObservers(this.estadoPedido);
        return this.estadoPedido = estadoPedido;
    }

    public EstadoPedido getEstado() {
        return estadoPedido;
    }

    public EstadoPedido realizarPedido() {
        return (formaPagamento != null && formaPagamento.isValido())? PedidoRealizado.getInstance() : PedidoRecusado.getInstance();
    }

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
