package com.designPatterns.hamburgueria;

import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;

@Data
public class Combo implements Produto {

    private ArrayList<Produto> produtos = new ArrayList<>();
    private String nome;

    public Combo(String nome) {
        this.nome = nome;
    }

    public boolean addProduto(Produto produto) {
        return this.produtos.add(produto);
    }

    public boolean removeProduto(Produto produto) {
        return this.produtos.remove(produto);
    }

    @Override
    public BigDecimal getPrecoBase() {
        BigDecimal precoTotal = BigDecimal.ZERO;
        for (Produto item : produtos) {
            precoTotal = item.getPrecoBase().add(precoTotal);
        }
        return precoTotal;
    }

    @Override
    public String getDescricao() {
        StringBuilder descricao = new StringBuilder();
        descricao.append(nome);
        for (Produto item : produtos) {
            descricao.append("\n\t");
            descricao.append(item.getDescricao());
        }
        return descricao.toString();
    }

    @Override
    public PromocaoLinha getPromocao() {
        return null;
    }

    public Iterator<Produto> getIteratorHamburguerNaPromocao() {
        return new IteratorHamburguerNaPromocao(produtos);
    }
}
