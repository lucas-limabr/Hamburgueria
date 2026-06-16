package com.designPatterns.hamburgueria;

public interface IVisitor {
    String visit(Delivery tipoEntrega);
    String visit(InLoco tipoEntrega);
}
