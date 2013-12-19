package org.sedly.expression;

public abstract class OneOperandExpression<R, V> implements Expression<R> {

    private Expression<V> firstOperand;

    public Expression<V> getFirstOperand() {
        return firstOperand;
    }

    protected OneOperandExpression(Expression<V> firstOperand) {
        this.firstOperand = firstOperand;
    }

    protected V evaluateFirstValue() {
        return getFirstOperand().evaluate();
    }

}
