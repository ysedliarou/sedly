package org.sedly.expression.lexer.token.impl;

import org.sedly.expression.lexer.token.TokenType;


public enum LogicTokenType implements TokenType {


    AND("&&"), OR("||"), NOT("!"), XOR("^");

    private String name;

    LogicTokenType(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }


}
