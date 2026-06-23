package com.designPatterns.hamburgueria;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EnderecoTest {

    Endereco endereco;
    Endereco endereco2;
    String uf;
    String cidade;
    String numero;

    @BeforeEach
    void setUp() {
        uf = "MG";
        cidade = "Juiz de Fora";

        endereco = new Endereco("Rua A", "100", "Bairro A", "36000-000", "Apto 101", uf, cidade);
        endereco2 = new Endereco("Rua B", "200", "Bairro B", "36000-111", "Apto 301", uf, cidade);
    }

    @Test
    void deveRetornarOEstadoIntrinsecoDoEnderecoFlyWeight() {
        assertEquals("EnderecoFlyWeight{uf='MG', cidade='Juiz de Fora'}", endereco.getEstadoIntrinseco());
        assertEquals(endereco.getEstadoIntrinseco(), endereco2.getEstadoIntrinseco());
    }

    @Test
    void deveRetornarApenasUmEnderecoFlyWeight() {
        assertEquals(1, EnderecoFactory.getSize());
    }
}