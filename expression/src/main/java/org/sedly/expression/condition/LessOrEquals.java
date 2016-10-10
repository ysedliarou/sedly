package org.sedly.expression.condition;

import org.sedly.expression.Expression;
import org.sedly.expression.TwoOperandsExpression;

public class LessOrEquals extends TwoOperandsExpression<Boolean, Double> {

    public LessOrEquals(Expression<Double> firstExpression, Expression<Double> secondExpression) {
        super(firstExpression, secondExpression);
    }

    @Override
    public Boolean evaluate() {
        return evaluateFirstValue() <= evaluateSecondValue();
    }

}
