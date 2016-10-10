package org.sedly.expression.condition;

import org.sedly.expression.Expression;
import org.sedly.expression.TwoOperandsExpression;
import org.sedly.expression.name.DefaultExpressionType;
import org.sedly.expression.name.ExpressionType;

public class NotEquals extends TwoOperandsExpression<Boolean, Double> {

    public NotEquals(Expression<Double> firstOperand, Expression<Double> secondOperand) {
        super(firstOperand, secondOperand);
    }

    public NotEquals(Double firstValue, Double secondValue) {
        super(firstValue, secondValue);
    }

    @Override
    public Boolean evaluate() {
        return !evaluateFirstValue().equals(evaluateSecondValue());
    }

    @Override
    public ExpressionType getType() {
        return DefaultExpressionType.NOT_EQUALS;
    }

    @Override
    public String toString() {
        return getFirstOperand() + getType().getName() + getSecondOperand();
    }
}
