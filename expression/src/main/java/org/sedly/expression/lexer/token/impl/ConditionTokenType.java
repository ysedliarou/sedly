package org.sedly.expression.lexer.token.impl;

import java.util.Set;

import org.sedly.expression.lexer.token.TokenType;

import com.google.common.collect.ImmutableSet;

public final class ConditionTokenType {

    public static TokenType EQUALS = new TokenType("==");

    public static TokenType NOT_EQUALS = new TokenType("!=");

    public static TokenType GRATER = new TokenType(">");

    public static TokenType GREATER_OR_EQUALS = new TokenType(">=");

    public static TokenType LESS = new TokenType("<");

    public static TokenType LESS_OR_EQUALS = new TokenType("<=");

    public final static Set<TokenType> ALL = ImmutableSet.<TokenType>builder().add(EQUALS)
            .add(NOT_EQUALS).add(GRATER).add(GREATER_OR_EQUALS).add(LESS).add(LESS_OR_EQUALS)
            .build();

    private ConditionTokenType() {
        super();
    }

}
