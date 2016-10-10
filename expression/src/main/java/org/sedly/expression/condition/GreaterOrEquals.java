package org.sedly.expression.condition;

import org.sedly.expression.Expression;
import org.sedly.expression.name.DefaultExpressionType;
import org.sedly.expression.TwoOperandsExpression;
import org.sedly.expression.name.ExpressionType;


public class GreaterOrEquals extends TwoOperandsExpression<Boolean, Double> {

    public GreaterOrEquals(Expression<Double> firstExpression, Expression<Double> secondExpression) {
        super(firstExpression, secondExpression);
    }

    public GreaterOrEquals(Double firstValue, Double secondValue) {
        super(firstValue, secondValue);
    }

    @Override
    public Boolean evaluate() {
        return evaluateFirstValue() >= evaluateSecondValue();
    }

    @Override
    public ExpressionType getType() {
        return DefaultExpressionType.GREATER_OR_EQUALS;
    }

    @Override
    public String toString() {
        return getFirstOperand() + getType().getName() + getSecondOperand();
    }
}
