package org.sedly.expression.lexer.token.impl;

import org.sedly.expression.lexer.token.TokenType;


public enum ConditionTokenType implements TokenType {

    EQUALS("=="), NOT_EQUALS("!="), GRATER(">"), GREATER_OR_EQUALS(">="), LESS("<"), LESS_OR_EQUALS(
            "<=");

    private String name;

    ConditionTokenType(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}
