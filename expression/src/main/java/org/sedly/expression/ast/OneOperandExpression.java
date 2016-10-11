package org.sedly.expression.ast;

import org.sedly.expression.ast.Expression;
import org.sedly.expression.ast.Value;


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

    protected V evaluateFirstValue() {
        return getFirstOperand().evaluate();
    }

}
