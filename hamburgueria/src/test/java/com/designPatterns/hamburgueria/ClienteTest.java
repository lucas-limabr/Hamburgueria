package com.designPatterns.hamburgueria;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class ClienteTest {

    Cliente cliente;
    Pedido pedido;
    Sacola sacola;

    @BeforeEach
    void setUp() {
        cliente = new Cliente();
        Pedido pedido = new Pedido();
        sacola = new Sacola(pedido, cliente);
    }

    @Test
    @DisplayName("Não deve realizar pedido na ausência de um método de pagamento")
    void naoDeveRealizarPedidoNaAusenciaPagamento() {
        assertInstanceOf(PedidoRecusado.class, cliente.realizarPedido(sacola));
    }

    @Test
    @DisplayName("Deve realizar pedido quando é passado algum método de pagamento")
    void deveRealizarPedidoQuandoHaPagamento() {
        Pix pix = new Pix();
        pedido = new Pedido(new BigDecimal("40.0"), LocalDateTime.now(), BigDecimal.ZERO, null, cliente, pix);
        sacola = new Sacola(pedido, cliente);
        assertInstanceOf(PedidoRealizado.class, cliente.realizarPedido(sacola));
    }

    @Test
    @DisplayName("Deve criar cliente com builder")
    void deveCriarClienteComBuilder() {
        Endereco endereco = new Endereco("Rua A", "80", "Paineiras", "3567", "JF", "MG", "APT 305");

        Cliente cliente = Cliente.builder().cpf("123").nome("Thaís").telefone("329984567").endereco(endereco).build();
        assertNotNull(cliente);

        assertEquals("Cliente(nome=Thaís, cpf=123, telefone=329984567, endereco=Logradouro: Rua A, 80\n" +
                "Cep: 3567 Paineiras, JF - MG, \n" +
                "Complemento: APT 305, formaPagamento=null)", cliente.toString());
    }
}