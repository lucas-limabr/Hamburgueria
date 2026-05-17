package com.designPatterns.hamburgueria;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Cliente {

    private String nome;
    private String cpf;
    private String telefone;
    private Endereco endereco;
    private IFormaPagamento formaPagamento;

    public EstadoPedido realizarPedido(Sacola sacola) {
        return sacola.realizarPedido();
    }
}
