package org.sedly.expression.string;

import org.sedly.expression.name.DefaultExpressionType;
import org.sedly.expression.TwoOperandsExpression;
import org.sedly.expression.Expression;
import org.sedly.expression.name.ExpressionType;


public class Equals extends TwoOperandsExpression<Boolean, String> {

    public Equals(Expression<String> firstExpression, Expression<String> secondExpression) {
        super(firstExpression, secondExpression);
    }

    public Equals(String firstValue, String secondValue) {
        super(firstValue, secondValue);
    }

    @Override
    public Boolean evaluate() {
        return evaluateFirstValue().equals(evaluateSecondValue());
    }

    @Override
    public ExpressionType getType() {
        return DefaultExpressionType.EQUALS;
    }

    @Override
    public String toString() {
        return getFirstOperand() + getType().toString() + getSecondOperand();
    }
}
