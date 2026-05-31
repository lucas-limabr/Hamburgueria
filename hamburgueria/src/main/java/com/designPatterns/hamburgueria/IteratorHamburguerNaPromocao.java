package com.designPatterns.hamburgueria;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class IteratorHamburguerNaPromocao implements Iterator<Produto> {
    private int posicao = 0;
    private ArrayList<Produto> produtos = new ArrayList<>();

    public IteratorHamburguerNaPromocao(ArrayList<Produto> produtos) {
        this.produtos = produtos;
    }

    @Override
    public boolean hasNext() {
        while (posicao < produtos.size()) {
            if (produtos.get(posicao).getPromocao() != null) {
                return true;
            }
            posicao++;
        }
        return false;
    }

    @Override
    public Hamburguer next() {
        if (!hasNext()) {
            throw new NoSuchElementException("Não foi encontrado nenhum hambúrguer na promoção");
        }
        Hamburguer hamburguer = (Hamburguer) produtos.get(posicao);
        posicao++;
        return hamburguer;
    }
}
