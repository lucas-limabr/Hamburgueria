package com.designPatterns.hamburgueria;

public class Delivery extends Entrega{

    private String codigo;
    private Endereco endereco;

    public Delivery(String codigo, Endereco endereco, Pedido pedido){
        this.codigo = codigo;
        this.endereco = endereco;
        super(pedido);
    }
}
