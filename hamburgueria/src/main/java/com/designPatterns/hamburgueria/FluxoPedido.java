package com.designPatterns.hamburgueria;

public class FluxoPedido {

    public boolean executeCommand(Command command) {
        return command.execute();
    }
}
