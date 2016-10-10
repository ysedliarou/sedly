package org.sedly.expression.condition;

import org.sedly.expression.Expression;
import org.sedly.expression.TwoOperandsExpression;
import org.sedly.expression.name.DefaultExpressionType;
import org.sedly.expression.name.ExpressionType;


public class LessOrEquals extends TwoOperandsExpression<Boolean, Double> {

    public LessOrEquals(Expression<Double> firstExpression, Expression<Double> secondExpression) {
        super(firstExpression, secondExpression);
    }

    public LessOrEquals(Double firstValue, Double secondValue) {
        super(firstValue, secondValue);
    }

    @Override
    public Boolean evaluate() {
        return evaluateFirstValue() <= evaluateSecondValue();
    }

    @Override
    public ExpressionType getType() {
        return DefaultExpressionType.LESS_OR_EQUALS;
    }

    @Override
    public String toString() {
        return getFirstOperand() + getType().getName() + getSecondOperand();
    }
}
