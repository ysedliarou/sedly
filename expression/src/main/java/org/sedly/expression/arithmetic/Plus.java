package org.sedly.expression.arithmetic;

import org.sedly.expression.Expression;
import org.sedly.expression.name.DefaultExpressionType;
import org.sedly.expression.TwoOperandsExpression;
import org.sedly.expression.name.ExpressionType;


public class Plus extends TwoOperandsExpression<Double, Double> {

    public Plus(Expression<Double> firstExpression, Expression<Double> secondExpression) {
        super(firstExpression, secondExpression);
    }

    public Plus(Double firstValue, Double secondValue) {
        super(firstValue, secondValue);
    }

    @Override
    public Double evaluate() {
        return evaluateFirstValue() + evaluateSecondValue();
    }

    @Override
    public ExpressionType getType() {
        return DefaultExpressionType.PLUS;
    }

    @Override
    public String toString() {
        return getFirstOperand() + getType().getName() + getSecondOperand();
    }
}
