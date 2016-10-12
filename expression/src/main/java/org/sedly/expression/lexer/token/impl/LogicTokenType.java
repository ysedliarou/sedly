package org.sedly.expression.lexer.token.impl;

import java.util.Set;

import org.sedly.expression.lexer.token.TokenType;

import com.google.common.collect.ImmutableSet;


public final class LogicTokenType {

    public static TokenType AND = new TokenType("&&");

    public static TokenType OR = new TokenType("||");

    public static TokenType XOR = new TokenType("^");

    public static TokenType NOT = new TokenType("!");

    public final static Set<TokenType> ALL = ImmutableSet.<TokenType>builder().add(AND).add(OR)
            .add(XOR).add(NOT).build();

    private LogicTokenType() {
        super();
    }

}
