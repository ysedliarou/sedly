package org.sedly.expression.arithmetic;

import org.sedly.expression.Expression;
import org.sedly.expression.TwoOperandsExpression;

public class Plus extends TwoOperandsExpression<Double, Double> {

    public Plus(Expression<Double> firstExpression, Expression<Double> secondExpression) {
        super(firstExpression, secondExpression);
    }

    @Override
    public Double evaluate() {
        return evaluateFirstValue() + evaluateSecondValue();
    }

}
