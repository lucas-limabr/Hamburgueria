package com.designPatterns.hamburgueria;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
public abstract class Combo implements AbstractFactoryCombo {

    private boolean ativo;
    private PromocaoCombo promocaoCombo;

    public Double definirDataLimiteUso()
    {
    return 1.0;
    }
}
