package org.sedly.expression.lexer.token.impl;

import org.sedly.expression.lexer.token.CustomTokenType;
import org.sedly.expression.lexer.token.TokenType;


public class TokenTypes {

    public static TokenType abs() {
        return new CustomTokenType("abs");
    }

    public static TokenType sin() {
        return new CustomTokenType("sin");
    }

    public static TokenType cos() {
        return new CustomTokenType("cos");
    }

}
