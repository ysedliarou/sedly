package org.sedly.expression.logic;

import org.sedly.expression.Expression;

public class Not extends LogicExpression {

    public Not(Expression<Boolean> firstExpression) {
        this(firstExpression, null);
    }

    protected Not(Expression<Boolean> firstExpression, Expression<Boolean> secondExpression) {
        super(firstExpression, secondExpression);
    }

    @Override
    public Boolean evaluate() {
        return !evaluateLeftValue();
    }

}
