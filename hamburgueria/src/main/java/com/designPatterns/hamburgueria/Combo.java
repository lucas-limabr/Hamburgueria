package com.designPatterns.hamburgueria;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.time.LocalDateTime;


@AllArgsConstructor
@NoArgsConstructor
@Data
public abstract class Combo implements AbstractFactoryCombo {

    private boolean ativo;

    public LocalDateTime definirDataLimiteUso()
    {
    return LocalDateTime.now().plusDays(15);
    }
}
