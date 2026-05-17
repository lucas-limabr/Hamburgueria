package com.designPatterns.hamburgueria;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Observable;
import java.util.Observer;

@AllArgsConstructor
@NoArgsConstructor
public class Cliente implements Observer {

    private String nome;
    private String cpf;
    private String telefone;
    private Endereco endereco;
    private IFormaPagamento formaPagamento;

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof Pedido) {
            EstadoPedido novoEstado = (EstadoPedido) arg;
            System.out.println("O status do seu pedido mudou para: " + novoEstado.getEstado());
        }
    }
}
