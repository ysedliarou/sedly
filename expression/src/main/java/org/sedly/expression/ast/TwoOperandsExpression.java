package org.sedly.expression.ast;


public abstract class TwoOperandsExpression<R, V> extends OneOperandExpression<R, V> {

    private Expression<V> secondOperand;

    public Expression<V> getSecondOperand() {
        return secondOperand;
    }

    protected TwoOperandsExpression(Expression<V> firstOperand, Expression<V> secondOperand) {
        super(firstOperand);
        this.secondOperand = secondOperand;
    }

    protected TwoOperandsExpression(V firstOperand, V secondOperand) {
        super(firstOperand);
        this.secondOperand = new Value<>(secondOperand);
    }

    protected V evaluateSecondValue(EvaluationContext context) {
        return getSecondOperand().evaluate(context);
    }

}
