package org.sedly.expression;

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
}
