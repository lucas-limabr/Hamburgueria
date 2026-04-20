package com.designPatterns.hamburgueria;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class ProdutoTemIngrediente {

    private Ingrediente ingrediente;
    private Produto produto;
}
