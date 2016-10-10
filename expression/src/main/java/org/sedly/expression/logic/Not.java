package org.sedly.expression.logic;

import org.sedly.expression.Expression;
import org.sedly.expression.name.DefaultExpressionType;
import org.sedly.expression.OneOperandExpression;
import org.sedly.expression.name.ExpressionType;


public class Not extends OneOperandExpression<Boolean, Boolean> {

    public Not(Expression<Boolean> expression) {
        super(expression);
    }

    public Not(Boolean value) {
        super(value);
    }

    @Override
    public Boolean evaluate() {
        return !evaluateFirstValue();
    }

    @Override
    public ExpressionType getType() {
        return DefaultExpressionType.NOT;
    }

    @Override
    public String toString() {
        return getType().getName() + getFirstOperand();
    }
}
