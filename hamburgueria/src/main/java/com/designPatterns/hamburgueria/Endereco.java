package com.designPatterns.hamburgueria;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Endereco {

    private String logradouro;
    private String numero;
    private String bairro;
    private String cep;
    private String cidade;
    private String uf;
    private String complemento;

    @Override
    public String toString() {
        return "Logradouro: " +
                logradouro + ", " +
                numero + "\nCep: " +
                cep + " " +
                bairro + ", " +
                cidade + " - " +
                uf + ", \nComplemento: " +
                complemento;
    }
}
