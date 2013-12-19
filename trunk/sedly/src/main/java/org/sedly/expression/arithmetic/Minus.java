package org.sedly.expression.arithmetic;

import org.sedly.expression.Expression;
import org.sedly.expression.TwoOperandsExpression;

public class Minus extends TwoOperandsExpression<Double, Double> {

    public Minus(Expression<Double> firstExpression, Expression<Double> secondExpression) {
        super(firstExpression, secondExpression);
    }

    @Override
    public Double evaluate() {
        return evaluateFirstValue() - evaluateSecondValue();
    }

}
