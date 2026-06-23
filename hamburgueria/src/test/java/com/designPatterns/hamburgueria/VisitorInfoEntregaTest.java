package com.designPatterns.hamburgueria;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VisitorInfoEntregaTest {

    VisitorInfoEntrega visitorInfoEntrega;
    Entrega inloco;
    Entrega delivery;
    Endereco endereco;
    Pedido pedido;

    @Test
    @DisplayName("Deve exibir informações pertinentes ao tipo de entrega in loco")
    void deveExibirInfoEntregaInLoco() {
        inloco = new InLoco("10", pedido);
        visitorInfoEntrega = new VisitorInfoEntrega();
        assertEquals("Entrega local na mesa 10", visitorInfoEntrega.exibirInfoEntrega(inloco));
    }

    @Test
    @DisplayName("Deve exibir informações pertinentes ao tipo de entrega via delivery")
    void deveExibirInfoEntregaViaDelivery() {
        endereco = new Endereco("Rua A", "80", "Paineiras", "3567", "APT 305", "MG", "JF");
        delivery = new Delivery("123", endereco, pedido);
        visitorInfoEntrega = new VisitorInfoEntrega();
        assertEquals("""
                Entrega via delivery de código 123 no endereço:\s
                Logradouro: Rua A, 80
                Cep: 3567 Paineiras, JF - MG,\s
                Complemento: APT 305""", visitorInfoEntrega.exibirInfoEntrega(delivery));
    }
}