package org.sedly.expression.ast;

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
    public R evaluate(EvaluationContext context) {
        return getValue();
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
