package org.sedly.expression.condition;

import org.sedly.expression.Expression;
import org.sedly.expression.TwoOperandsExpression;
import org.sedly.expression.name.DefaultExpressionType;
import org.sedly.expression.name.ExpressionType;


public class Equals extends TwoOperandsExpression<Boolean, Double> {

    public Equals(Expression<Double> firstExpression, Expression<Double> secondExpression) {
        super(firstExpression, secondExpression);
    }

    public Equals(Double firstValue, Double secondValue) {
        super(firstValue, secondValue);
    }

    @Override
    public Boolean evaluate() {
        return evaluateFirstValue().equals(evaluateSecondValue());
    }

    @Override
    public ExpressionType getType() {
        return DefaultExpressionType.EQUALS;
    }

    @Override
    public String toString() {
        return getFirstOperand() + getType().getName() + getSecondOperand();
    }
}
