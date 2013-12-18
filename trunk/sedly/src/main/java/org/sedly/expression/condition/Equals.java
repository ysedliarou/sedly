package org.sedly.expression.condition;

import org.sedly.expression.Expression;

public class Equals extends ConditionExpression {

    public Equals(Expression<Double> firstExpression, Expression<Double> secondExpression) {
        super(firstExpression, secondExpression);
    }

    @Override
    public Boolean evaluate() {
        return evaluateLeftValue().equals(evaluateRightValue());
    }

}
