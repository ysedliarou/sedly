package org.sedly.expression;

public abstract class AbstractExpression<R, V> implements Expression<R> {

    private Expression<V> leftExpression;

    private Expression<V> rightExpression;

    public Expression<V> getLeftExpression() {
        return leftExpression;
    }

    public Expression<V> getRightExpression() {
        return rightExpression;
    }

    protected AbstractExpression(Expression<V> leftExpression, Expression<V> rightExpression) {
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
    }

    protected abstract V evaluateLeftValue();

    protected abstract V evaluateRightValue();

    @Override
    public abstract R evaluate();

}
