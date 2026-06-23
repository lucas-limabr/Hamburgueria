package com.designPatterns.hamburgueria;

import lombok.Data;

@Data
public class Endereco {

    private String logradouro;
    private String numero;
    private String bairro;
    private String cep;
    private String complemento;
    private EnderecoFlyWeight enderecoFlyWeight;

    public Endereco(String logradouro, String numero, String bairro, String cep, String complemento, String uf, String cidade) {
        this.logradouro = logradouro;
        this.numero = numero;
        this.bairro = bairro;
        this.cep = cep;
        this.complemento = complemento;
        this.enderecoFlyWeight = EnderecoFactory.getEndereco(uf, cidade);
    }

    @Override
    public String toString() {
        return "Logradouro: " +
                logradouro + ", " +
                numero + "\nCep: " +
                cep + " " +
                bairro + ", " +
                enderecoFlyWeight.getCidade() + " - " +
                enderecoFlyWeight.getUf() + ", \nComplemento: " +
                complemento;
    }

    public String getEstadoIntrinseco() {
        return enderecoFlyWeight.toString();
    }
}
