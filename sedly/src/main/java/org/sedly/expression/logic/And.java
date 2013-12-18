package org.sedly.expression.logic;

import org.sedly.expression.Expression;

public class And extends LogicExpression {

    public And(Expression<Boolean> firstExpression, Expression<Boolean> secondExpression) {
        super(firstExpression, secondExpression);
    }

    @Override
    public Boolean evaluate() {
        return evaluateLeftValue() && evaluateRightValue();
    }

}
