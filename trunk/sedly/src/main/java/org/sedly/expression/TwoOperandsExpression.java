package org.sedly.expression;

public abstract class TwoOperandsExpression<R, V> extends OneOperandExpression<R, V> {

    private Expression<V> secondOperand;

    public Expression<V> getSecondOperand() {
        return secondOperand;
    }

    protected TwoOperandsExpression(Expression<V> firstOperand, Expression<V> secondOperand) {
        super(firstOperand);
        this.secondOperand = secondOperand;
    }

    protected V evaluateSecondValue() {
        return getSecondOperand().evaluate();
    }

    @Override
    public abstract R evaluate();

}
