package com.designPatterns.hamburgueria;

import lombok.Data;

public class EnderecoFlyWeight {
    private String uf;
    private String cidade;

    public EnderecoFlyWeight(String uf, String cidade) {
        this.uf = uf;
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public String getCidade() {
        return cidade;
    }

    @Override
    public String toString() {
        return "EnderecoFlyWeight{" +
                "uf='" + uf + '\'' +
                ", cidade='" + cidade + '\'' +
                '}';
    }
}
