package org.sedly.expression.arithmetic;

import org.sedly.expression.Expression;

public class Divide extends ArithmeticExpression {

    public Divide(Expression<Double> firstExpression, Expression<Double> secondExpression) {
        super(firstExpression, secondExpression);
    }

    @Override
    public Double evaluate() {
        return evaluateLeftValue() / evaluateRightValue();
    }

}
