package org.sedly.expression.arithmetic;

import org.sedly.expression.Expression;
import org.sedly.expression.name.DefaultExpressionType;
import org.sedly.expression.TwoOperandsExpression;
import org.sedly.expression.name.ExpressionType;


public class Minus extends TwoOperandsExpression<Double, Double> {

    public Minus(Expression<Double> firstExpression, Expression<Double> secondExpression) {
        super(firstExpression, secondExpression);
    }

    public Minus(Double firstValue, Double secondValue) {
        super(firstValue, secondValue);
    }

    @Override
    public Double evaluate() {
        return evaluateFirstValue() - evaluateSecondValue();
    }

    @Override
    public ExpressionType getType() {
        return DefaultExpressionType.MINUS;
    }

    @Override
    public String toString() {
        return getFirstOperand() + getType().getName() + getSecondOperand();
    }
}
