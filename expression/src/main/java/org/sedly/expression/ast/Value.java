package org.sedly.expression.ast;

import org.sedly.expression.lexer.token.TokenType;

public class Value<R> implements Expression<R> {

    private R value;

    public R getValue() {
        return value;
    }

    public void setValue(R value) {
        this.value = value;
    }

    public Value(R value) {
        this.value = value;
    }

    @Override
    public R evaluate() {
        return getValue();
    }

    @Override
    public TokenType getType() {
        return Value.this::toString;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
