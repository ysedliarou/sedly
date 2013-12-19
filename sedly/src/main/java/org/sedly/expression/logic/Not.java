package org.sedly.expression.logic;

import org.sedly.expression.Expression;
import org.sedly.expression.OneOperandExpression;

public class Not extends OneOperandExpression<Boolean, Boolean> {

    public Not(Expression<Boolean> firstExpression) {
        super(firstExpression);
    }

    @Override
    public Boolean evaluate() {
        return !evaluateFirstValue();
    }

}
