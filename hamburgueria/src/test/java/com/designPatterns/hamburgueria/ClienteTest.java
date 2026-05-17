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
        Pix pix = new Pix(new BigDecimal("0.05"));
        pedido = new Pedido(new BigDecimal("40.0"), LocalDateTime.now(), BigDecimal.ZERO, null, cliente, pix);
        sacola = new Sacola(pedido, cliente);
        assertInstanceOf(PedidoRealizado.class, cliente.realizarPedido(sacola));
    }
}