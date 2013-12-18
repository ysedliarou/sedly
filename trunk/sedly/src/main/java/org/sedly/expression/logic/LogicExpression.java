package org.sedly.expression.logic;

import org.sedly.expression.AbstractExpression;
import org.sedly.expression.Expression;

public abstract class LogicExpression extends AbstractExpression<Boolean, Boolean> {

    protected LogicExpression(Expression<Boolean> firstExpression, Expression<Boolean> secondExpression) {
        super(firstExpression, secondExpression);
    }

    @Override
    protected Boolean evaluateLeftValue() {
        return (Boolean) getLeftExpression().evaluate();
    }

    @Override
    protected Boolean evaluateRightValue() {
        return (Boolean) getRightExpression().evaluate();
    }

}
