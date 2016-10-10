package org.sedly.expression.condition;

import org.sedly.expression.Expression;
import org.sedly.expression.TwoOperandsExpression;

public class NotEquals extends TwoOperandsExpression<Boolean, Double> {

    public NotEquals(Expression<Double> firstOperand, Expression<Double> secondOperand) {
        super(firstOperand, secondOperand);
    }

    @Override
    public Boolean evaluate() {
        return !evaluateFirstValue().equals(evaluateSecondValue());
    }
}
