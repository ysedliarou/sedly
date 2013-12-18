package org.sedly.expression.logic;

import org.sedly.expression.Expression;

public class Or extends LogicExpression {

    public Or(Expression<Boolean> firstExpression, Expression<Boolean> secondExpression) {
        super(firstExpression, secondExpression);
    }

    @Override
    public Boolean evaluate() {
        return evaluateLeftValue() || evaluateRightValue();
    }

}
