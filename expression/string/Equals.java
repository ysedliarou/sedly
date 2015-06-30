package org.sedly.expression.string;

import org.sedly.expression.TwoOperandsExpression;
import org.sedly.expression.Expression;

public class Equals extends TwoOperandsExpression<Boolean, String> {

    public Equals(Expression<String> firstExpression, Expression<String> secondExpression) {
        super(firstExpression, secondExpression);
    }

    @Override
    public Boolean evaluate() {
        return evaluateFirstValue().equals(evaluateSecondValue());
    }

}
