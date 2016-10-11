package org.sedly.expression.lexer.token;

public class CustomTokenType implements TokenType {

    private String name;

    public CustomTokenType(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

}
