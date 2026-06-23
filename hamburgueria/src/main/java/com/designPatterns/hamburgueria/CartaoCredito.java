package com.designPatterns.hamburgueria;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Setter
public class CartaoCredito implements IFormaPagamento{

    private String numeroCartao;
    private String nomeTitular;
    private String validade;
    private String cvc;
    private BigDecimal taxa;

    @Override
    public String processarPagamento() {
        if (!isValido()) {
            return "Pagamento feito com cartão de crédito (Dados não preenchidos)";
        }
        return "Pagamento feito com cartão de crédito final " +
                numeroCartao.substring(Math.max(0, numeroCartao.length() - 4));
    }

    @Override
    public boolean isValido() {
        if (numeroCartao == null || numeroCartao.trim().isEmpty()) return false;
        if (nomeTitular == null || nomeTitular.trim().isEmpty()) return false;
        if (validade == null || validade.trim().isEmpty()) return false;
        if (cvc == null || cvc.trim().isEmpty()) return false;
        else {
            return true;
        }
    }
}
