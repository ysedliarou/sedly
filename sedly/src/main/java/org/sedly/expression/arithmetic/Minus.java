package org.sedly.expression.arithmetic;

import org.sedly.expression.Expression;

public class Minus extends ArithmeticExpression {

    public Minus(Expression<Double> firstExpression, Expression<Double> secondExpression) {
        super(firstExpression, secondExpression);
    }

    @Override
    public Double evaluate() {
        return evaluateLeftValue() - evaluateRightValue();
    }

}
