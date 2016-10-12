package org.sedly.expression.ast;


public abstract class OneOperandExpression<R, V> implements Expression<R> {

    private Expression<V> firstOperand;

    public Expression<V> getFirstOperand() {
        return firstOperand;
    }

    protected OneOperandExpression(Expression<V> expression) {
        this.firstOperand = expression;
    }

    protected OneOperandExpression(V value) {
        this.firstOperand = new Value<>(value);
    }

    protected V evaluateFirstValue(EvaluationContext context) {
        return getFirstOperand().evaluate(context);
    }

}
