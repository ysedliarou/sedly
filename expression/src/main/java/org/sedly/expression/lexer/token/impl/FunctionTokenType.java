package org.sedly.expression.lexer.token.impl;

import java.util.Set;

import org.sedly.expression.lexer.token.TokenType;

import com.google.common.collect.ImmutableSet;


public class FunctionTokenType {

    public static TokenType ABS = new TokenType("abs");

    public static TokenType SIN = new TokenType("sin");

    public static TokenType COS = new TokenType("cos");

    public final static Set<TokenType> ALL = ImmutableSet.<TokenType>builder().add(ABS).add(SIN)
            .add(COS).build();

    private FunctionTokenType() {
        super();
    }

}
