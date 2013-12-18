package org.sedly.expression.condition;

import org.sedly.expression.AbstractExpression;
import org.sedly.expression.Expression;

public abstract class ConditionExpression extends AbstractExpression<Boolean, Double> {

    protected ConditionExpression(Expression<Double> firstExpression, Expression<Double> secondExpression) {
        super(firstExpression, secondExpression);
    }

    @Override
    protected Double evaluateLeftValue() {
        return getLeftExpression().evaluate();
    }

    @Override
    protected Double evaluateRightValue() {
        return getRightExpression().evaluate();
    }

}
