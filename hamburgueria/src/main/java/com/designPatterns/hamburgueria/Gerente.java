package com.designPatterns.hamburgueria;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Gerente extends Setor {
    @Override
    public String getDescricaoSetor() {
        return "Setor responsável: Gerente";
    }

    public Hamburguer cadastrarComboHamburguer(boolean ativo, int validade, String tituloCombo, String descricao, BigDecimal precoBase, Double quantidade, String pontoCarne, String promocao, BigDecimal valorDesconto) {

        AbstractFactoryCombo comboFactory = this.defineComboFactory(tituloCombo, ativo, validade);
        PromocaoLinha desconto = this.definePromocao(promocao, valorDesconto);
        Hamburguer hamburguer = new Combo(comboFactory, pontoCarne, descricao, tituloCombo, precoBase, quantidade);
        hamburguer.setPromocaoLinha(desconto);

        //persistiu no BD
        return hamburguer;
    }

    private PromocaoLinha definePromocao(String promocao, BigDecimal valorDesconto) {
        PromocaoLinha desconto = null;
        if (promocao == null) {
            return null;
        }
        if (promocao.equalsIgnoreCase("percentual")) {
            desconto = new DescontoPercentual(valorDesconto);
        } else if (promocao.equalsIgnoreCase("fixo")) {
            desconto = new DescontoFixo(valorDesconto);
        }
        return desconto;
    }

    private AbstractFactoryCombo defineComboFactory(String tituloCombo, boolean ativo, int validade) {
        AbstractFactoryCombo comboFactory;
        if (tituloCombo.trim().equalsIgnoreCase("Combo Big")) {
            comboFactory = new ComboBigFactory(ativo, validade);
        } else if (tituloCombo.trim().equalsIgnoreCase("Combo Friday")) {
            comboFactory = new ComboFridayFactory(ativo, validade);
        } else {
            throw new RuntimeException("Opção de combo não disponível");
        }
        return comboFactory;
    }
}
