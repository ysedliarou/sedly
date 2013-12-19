package org.sedly.expression.logic;

import org.sedly.expression.Expression;
import org.sedly.expression.TwoOperandsExpression;

public class Or extends TwoOperandsExpression<Boolean, Boolean> {

    public Or(Expression<Boolean> firstExpression, Expression<Boolean> secondExpression) {
        super(firstExpression, secondExpression);
    }

    @Override
    public Boolean evaluate() {
        return evaluateFirstValue() || evaluateSecondValue();
    }

}
