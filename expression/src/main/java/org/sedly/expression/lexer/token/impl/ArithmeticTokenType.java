package org.sedly.expression.lexer.token.impl;

import java.util.Set;

import org.sedly.expression.lexer.token.TokenType;

import com.google.common.collect.ImmutableSet;


public final class ArithmeticTokenType {

    public static TokenType PLUS = new TokenType("+");

    public static TokenType MINUS = new TokenType("-");

    public static TokenType MULTIPLY = new TokenType("*");

    public static TokenType DIVIDE = new TokenType("/");

    public final static Set<TokenType> ALL = ImmutableSet.<TokenType>builder().add(PLUS).add(MINUS)
            .add(MULTIPLY).add(DIVIDE).build();

    private ArithmeticTokenType() {
        super();
    }
}
