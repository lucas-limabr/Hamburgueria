package com.designPatterns.hamburgueria;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class GerenteTest {

    Gerente gerente;
    boolean ativo;
    int validade;
    String tituloCombo;
    String descricao;
    BigDecimal precoBase;
    Double quantidade;
    String pontoCarne;
    String promocao;
    BigDecimal valorDesconto;

    @BeforeEach
    void setUp() {
        gerente = new Gerente();
        ativo = true;
        validade = 30;
        tituloCombo = "Combo Big";
        descricao = "Combo saboroso de carne Angus";
        precoBase = new BigDecimal("40.00");
        quantidade = 1.0;
        pontoCarne = "ao ponto";
        promocao = null;
        valorDesconto = null;
    }

    @Test
    @DisplayName("Deve retornar um hamburguer cadastrado pelo gerente com a descrição correta de um hambúrguer do Combo Big")
    void deveRetornarOHamburguerDoComboBigCadastradoPeloGerente() {
        Hamburguer hamburguer = gerente.cadastrarComboHamburguer(ativo, validade, tituloCombo, descricao, precoBase, quantidade, pontoCarne, promocao, valorDesconto);

        assertInstanceOf(Hamburguer.class, hamburguer);
        assertEquals("Hamburguer(descricao=Combo saboroso de carne Angus, titulo=Combo Big, precoBase=40.00, quantidade=1.0, promocaoLinha=null, adicional=Adicional(preco=4.00, descricaoAdicional=Presunto), carne=Carne(tipo=Angus, ponto=ao ponto), pao=Pao(tipo=Brioche))", hamburguer.toString());
    }

    @Test
    @DisplayName("Deve retornar um hamburguer cadastrado pelo gerente com a descrição correta de um hambúrguer do Combo Friday")
    void deveRetornarOHamburguerDoComboFridayCadastradoPeloGerente() {
        tituloCombo = "Combo Friday";
        descricao = "Combo irresistível de carne Picanha";
        precoBase = new BigDecimal("50.00");

        Hamburguer hamburguer = gerente.cadastrarComboHamburguer(ativo, validade, tituloCombo, descricao, precoBase, quantidade, pontoCarne, promocao, valorDesconto);

        assertInstanceOf(Hamburguer.class, hamburguer);
        assertEquals("Hamburguer(descricao=Combo irresistível de carne Picanha, titulo=Combo Friday, precoBase=50.00, quantidade=1.0, promocaoLinha=null, adicional=Adicional(preco=5.00, descricaoAdicional=Bacon), carne=Carne(tipo=Picanha, ponto=ao ponto), pao=Pao(tipo=Australiano))", hamburguer.toString());
    }

    @Test
    @DisplayName("Deve lançar exceção de opção de combo indisponível para cadastro")
    void deveLancarExcecaoOpcaoComboIndisponivel() {
        tituloCombo = "Classe de combo inexistente";

        Exception e = assertThrows(RuntimeException.class, () -> gerente.cadastrarComboHamburguer(ativo, validade, tituloCombo, descricao, precoBase, quantidade, pontoCarne, promocao, valorDesconto));

        assertEquals("Opção de combo não disponível", e.getMessage());
    }

    @Test
    @DisplayName("Deve retornar um hambúrguer cadastrado pelo gerente com a descrição do hambúrguer informando que foi aplicado um desconto fixo sobre ele")
    void deveRetornarOHamburguerCadastradoPeloGerenteComDescontoFixo() {
        promocao = "fixo";
        valorDesconto = new BigDecimal("10.00");

        Hamburguer hamburguer = gerente.cadastrarComboHamburguer(ativo, validade, tituloCombo, descricao, precoBase, quantidade, pontoCarne, promocao, valorDesconto);

        assertEquals("Hamburguer(descricao=Combo saboroso de carne Angus, titulo=Combo Big, precoBase=40.00, quantidade=1.0, promocaoLinha=DescontoFixo(valorDesconto=10.00), adicional=Adicional(preco=4.00, descricaoAdicional=Presunto), carne=Carne(tipo=Angus, ponto=ao ponto), pao=Pao(tipo=Brioche))", hamburguer.toString());
    }

    @Test
    @DisplayName("Deve retornar um hambúrguer cadastrado pelo gerente com a descrição do hambúrguer informando que foi aplicado um desconto desconto percentual sobre ele")
    void deveRetornarOHamburguerCadastradoPeloGerenteComDescontoPercentual() {
        promocao = "percentual";
        valorDesconto = new BigDecimal("0.10");

        Hamburguer hamburguer = gerente.cadastrarComboHamburguer(ativo, validade, tituloCombo, descricao, precoBase, quantidade, pontoCarne, promocao, valorDesconto);

        assertEquals("Hamburguer(descricao=Combo saboroso de carne Angus, titulo=Combo Big, precoBase=40.00, quantidade=1.0, promocaoLinha=DescontoPercentual(percentualDesconto=0.10), adicional=Adicional(preco=4.00, descricaoAdicional=Presunto), carne=Carne(tipo=Angus, ponto=ao ponto), pao=Pao(tipo=Brioche))", hamburguer.toString());
    }


}