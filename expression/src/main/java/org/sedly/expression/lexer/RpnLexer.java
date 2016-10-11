package org.sedly.expression.lexer;

import java.util.ArrayDeque;
import java.util.Deque;

import org.sedly.expression.lexer.token.Token;


public class RpnLexer implements Lexer {

    private String expression;

    public RpnLexer(String expression) {
        this.expression = expression;
    }

    @Override
    public Deque<Token> tokenize() {
        final Deque<Token> queue = new ArrayDeque<>();

        return queue;
    }
}
