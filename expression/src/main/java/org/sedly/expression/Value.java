package org.sedly.expression;

import org.sedly.expression.name.ExpressionType;

public class Value<R> implements Expression<R> {

    private final ExpressionType NAME = new ExpressionType() {

        @Override
        public String getName() {
            return Value.this.toString();
        }

        @Override
        public int getPriority() {
            return ExpressionType.DEFAULT_PRIORITY;
        }

    };

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
    public ExpressionType getType() {
        return NAME;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
