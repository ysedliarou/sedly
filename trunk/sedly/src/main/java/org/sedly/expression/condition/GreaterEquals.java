package org.sedly.expression.condition;

import org.sedly.expression.Expression;

public class GreaterEquals extends ConditionExpression {

    public GreaterEquals(Expression<Double> firstExpression, Expression<Double> secondExpression) {
        super(firstExpression, secondExpression);
    }

    @Override
    public Boolean evaluate() {
        return evaluateLeftValue() >= evaluateRightValue();
    }

}
