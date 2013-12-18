package org.sedly.expression.condition;

import org.sedly.expression.Expression;

public class Less extends ConditionExpression {

    public Less(Expression<Double> firstExpression, Expression<Double> secondExpression) {
        super(firstExpression, secondExpression);
    }

    @Override
    public Boolean evaluate() {
        return evaluateLeftValue() < evaluateRightValue();
    }

}
