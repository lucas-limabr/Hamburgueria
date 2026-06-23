package com.designPatterns.hamburgueria;

import java.util.HashMap;

public class EnderecoFactory {

    private static final HashMap<String, EnderecoFlyWeight> enderecoFlyWeight = new HashMap<>();

    public static EnderecoFlyWeight getEndereco(String uf, String cidade) {
        String key = uf + cidade;
        if (enderecoFlyWeight.containsKey(key)) {
            return enderecoFlyWeight.get(key);
        }
        EnderecoFlyWeight endereco = new EnderecoFlyWeight(uf, cidade);
        enderecoFlyWeight.put(key, endereco);
        return endereco;
    }

    public static int getSize() {
        return enderecoFlyWeight.size();
    }
}
