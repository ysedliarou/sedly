package org.sedly.expression;

public abstract class AbstractExpression<R, V> implements Expression<R> {

    private Expression<?> leftExpression;

    private Expression<?> rightExpression;

    public Expression<?> getLeftExpression() {
        return leftExpression;
    }

    public Expression<?> getRightExpression() {
        return rightExpression;
    }

    protected AbstractExpression(Expression<?> leftExpression, Expression<?> rightExpression) {
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
    }

    protected abstract V evaluateLeftValue();

    protected abstract V evaluateRightValue();

}
