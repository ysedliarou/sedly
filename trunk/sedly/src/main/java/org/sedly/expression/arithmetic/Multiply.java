package org.sedly.expression.arithmetic;

import org.sedly.expression.Expression;

public class Multiply extends ArithmeticExpression {

    public Multiply(Expression<Double> firstExpression, Expression<Double> secondExpression) {
        super(firstExpression, secondExpression);
    }

    @Override
    public Double evaluate() {
        return evaluateLeftValue() * evaluateRightValue();
    }

}
