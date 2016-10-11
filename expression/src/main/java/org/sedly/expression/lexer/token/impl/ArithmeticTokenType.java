package org.sedly.expression.lexer.token.impl;

import org.sedly.expression.lexer.token.TokenType;


public enum ArithmeticTokenType implements TokenType {

    PLUS("+"), MINUS("-"), MULTIPLY("*"), DIVIDE("/");

    private String name;

    ArithmeticTokenType(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

}
