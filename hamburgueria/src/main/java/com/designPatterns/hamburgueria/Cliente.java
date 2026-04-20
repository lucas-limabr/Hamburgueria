package com.designPatterns.hamburgueria;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class Cliente {

    private String nome;
    private String cpf;
    private String telefone;
    private Endereco endereco;
    private IFormaPagamento formaPagamento;
}
