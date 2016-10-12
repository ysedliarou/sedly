package org.sedly.expression.lexer;

import java.util.ArrayDeque;
import java.util.Deque;

import org.sedly.expression.lexer.token.Token;
import org.sedly.expression.lexer.token.TokenProvider;


public class RpnLexer implements Lexer {

    private TokenProvider tokenProvider;

    private String expression;

    public RpnLexer(TokenProvider tokenProvider, String expression) {
        this.tokenProvider = tokenProvider;
        this.expression = expression;
    }

    @Override
    public Deque<Token> lex() {
        final Deque<Token> queue = new ArrayDeque<>();

        return queue;
    }
}
