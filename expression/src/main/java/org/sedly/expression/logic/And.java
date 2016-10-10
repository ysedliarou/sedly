package org.sedly.expression.logic;

import org.sedly.expression.Expression;
import org.sedly.expression.TwoOperandsExpression;
import org.sedly.expression.name.DefaultExpressionType;
import org.sedly.expression.name.ExpressionType;


public class And extends TwoOperandsExpression<Boolean, Boolean> {

    public And(Expression<Boolean> firstExpression, Expression<Boolean> secondExpression) {
        super(firstExpression, secondExpression);
    }

    public And(Boolean firstValue, Boolean secondValue) {
        super(firstValue, secondValue);
    }

    @Override
    public Boolean evaluate() {
        return evaluateFirstValue() && evaluateSecondValue();
    }


    @Override
    public ExpressionType getType() {
        return DefaultExpressionType.AND;
    }

    @Override
    public String toString() {
        return getFirstOperand() + getType().getName() + getSecondOperand();
    }

}
