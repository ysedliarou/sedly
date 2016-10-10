package org.sedly.expression.condition;

import org.sedly.expression.Expression;
import org.sedly.expression.name.DefaultExpressionType;
import org.sedly.expression.TwoOperandsExpression;
import org.sedly.expression.name.ExpressionType;

public class Less extends TwoOperandsExpression<Boolean, Double> {

    public Less(Expression<Double> firstExpression, Expression<Double> secondExpression) {
        super(firstExpression, secondExpression);
    }

    public Less(Double firstValue, Double secondValue) {
        super(firstValue, secondValue);
    }

    @Override
    public Boolean evaluate() {
        return evaluateFirstValue() < evaluateSecondValue();
    }

    @Override
    public ExpressionType getType() {
        return DefaultExpressionType.LESS;
    }

    @Override
    public String toString() {
        return getFirstOperand() + getType().getName() + getSecondOperand();
    }
}
