package com.designPatterns.hamburgueria;

public class ComboFridayFactory implements AbstractFactoryCombo{
    @Override
    public Ingrediente definirCarne() {
        return new Carne();
    }

    @Override
    public Ingrediente definirQueijo() {
        return new Queijo();
    }

    @Override
    public Ingrediente definirPao() {
        return new Pao();
    }

    @Override
    public Ingrediente definirSalada() {
        return new Salada();
    }

    @Override
    public Adicional definirAdicional() {
        return new Bacon();
    }
}
