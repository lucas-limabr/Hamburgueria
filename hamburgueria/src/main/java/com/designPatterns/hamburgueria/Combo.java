package com.designPatterns.hamburgueria;

import java.time.LocalDateTime;

public abstract class Combo implements AbstractFactoryCombo {

    private boolean ativo;
    private PromocaoCombo promocaoCombo;

    public Double definirDataLimiteUso()
    {
    return 1.0;
    }
}
