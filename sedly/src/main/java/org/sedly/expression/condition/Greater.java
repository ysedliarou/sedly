package org.sedly.expression.condition;

import org.sedly.expression.Expression;
import org.sedly.expression.TwoOperandsExpression;

public class Greater extends TwoOperandsExpression<Boolean, Double> {

    public Greater(Expression<Double> firstExpression, Expression<Double> secondExpression) {
        super(firstExpression, secondExpression);
    }

    @Override
    public Boolean evaluate() {
        return evaluateFirstValue() > evaluateSecondValue();
    }

}
