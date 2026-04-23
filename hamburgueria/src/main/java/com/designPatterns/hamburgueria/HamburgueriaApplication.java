package com.designPatterns.hamburgueria;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@SpringBootApplication
public class HamburgueriaApplication {

    public static void main(String[] args) {
        SpringApplication.run(HamburgueriaApplication.class, args);

        BigDecimal valorMonetario = new BigDecimal("50.00");

        Endereco e1 = new Endereco("Rua A", "80", "Paineiras", "JF", "MG", "APT 305");


        Cliente c1 = new Cliente("João", "12345678900", "11999999999", e1, null);

        Pix pix = new Pix(valorMonetario);

        Pedido p1 = new Pedido(valorMonetario, LocalDateTime.now(), new BigDecimal("5.00"), null, c1, pix);

        Hamburguer burguer = new Hamburguer("Hamburguer muito bom", "Divino", valorMonetario, 2.0);

        Ingrediente pao = new Pao("Brioche", "Pão");
        Ingrediente queijo = new Queijo("Muçarela", "Queijo");
        Ingrediente salada = new Salada("Salada");
        Ingrediente carne = new Carne("Angus", "ao ponto", "Carne");

        ProdutoTemIngrediente addPao = new ProdutoTemIngrediente(pao, burguer);
        ProdutoTemIngrediente addCarne = new ProdutoTemIngrediente(carne, burguer);

        ItemPedido itemPedido = new ItemPedido(null, p1, burguer, 1.0);

        Bacon bacon = new Bacon(burguer, "Bacon", valorMonetario);
        Ovo ovo = new Ovo(bacon, "Ovo", valorMonetario);
        Bebida bebida = new Bebida(ovo, "Coca", valorMonetario, 600.0);
        Bebida bebida2 = new Bebida(bebida, "Guaraná Antártica", valorMonetario, 600.0);

        ComboBigFactory combo = new ComboBigFactory(true, null);
        Hamburguer burguerCombo = new Hamburguer("Hamburguer top", "Combo Big", valorMonetario, 1.0);
        Carne carneCombo = combo.definirCarne("ao ponto");
        Pao paoCombo = combo.definirPao();

        ProdutoTemIngrediente comboItem1 = new ProdutoTemIngrediente(carneCombo, burguerCombo);
        ProdutoTemIngrediente comboItem2 = new ProdutoTemIngrediente(paoCombo, burguerCombo);
        Adicional presuntoCombo = combo.definirAdicional(burguerCombo);

        Delivery delivery = new Delivery("010", e1, p1);

        Pedido p2 = new Pedido(valorMonetario, LocalDateTime.now(), new BigDecimal("5.00"), null, c1, pix);
        Bebida bebida3 = new Bebida(valorMonetario, "Fanta", 600.0);
        Bebida bebida4 = new Bebida(valorMonetario, "H20", 250.0);
        ItemPedido itemPedido2 = new ItemPedido(null, p2, bebida3, 1.0);
        ItemPedido itemPedido3 = new ItemPedido(null, p2, bebida4, 1.0);

    }
}


