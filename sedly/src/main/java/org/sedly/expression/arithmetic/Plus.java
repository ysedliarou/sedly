package org.sedly.expression.arithmetic;

import org.sedly.expression.Expression;

public class Plus extends ArithmeticExpression {

    public Plus(Expression<Double> firstExpression, Expression<Double> secondExpression) {
        super(firstExpression, secondExpression);
    }

    @Override
    public Double evaluate() {
        return evaluateLeftValue() + evaluateRightValue();
    }

}
