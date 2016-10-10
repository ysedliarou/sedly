package org.sedly.expression.condition;

import org.sedly.expression.Expression;
import org.sedly.expression.TwoOperandsExpression;

public class Equals extends TwoOperandsExpression<Boolean, Double> {

    public Equals(Expression<Double> firstExpression, Expression<Double> secondExpression) {
        super(firstExpression, secondExpression);
    }

    @Override
    public Boolean evaluate() {
        return evaluateFirstValue().equals(evaluateSecondValue());
    }

}
