package org.sedly.expression.condition;

import org.sedly.expression.Expression;
import org.sedly.expression.name.DefaultExpressionType;
import org.sedly.expression.TwoOperandsExpression;
import org.sedly.expression.name.ExpressionType;


public class Greater extends TwoOperandsExpression<Boolean, Double> {

    public Greater(Expression<Double> firstExpression, Expression<Double> secondExpression) {
        super(firstExpression, secondExpression);
    }

    public Greater(Double firstValue, Double secondValue) {
        super(firstValue, secondValue);
    }

    @Override
    public Boolean evaluate() {
        return evaluateFirstValue() > evaluateSecondValue();
    }

    @Override
    public ExpressionType getType() {
        return DefaultExpressionType.GRATER;
    }

    @Override
    public String toString() {
        return getFirstOperand() + getType().getName() + getSecondOperand();
    }
}
