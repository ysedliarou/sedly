package org.sedly.expression.function.math;

import org.sedly.expression.Expression;
import org.sedly.expression.name.DefaultExpressionType;
import org.sedly.expression.OneOperandExpression;
import org.sedly.expression.name.ExpressionType;


public class Abs extends OneOperandExpression<Double, Double> {
    public Abs(Expression<Double> expression) {
        super(expression);
    }

    public Abs(Double value) {
        super(value);
    }

    @Override
    public Double evaluate() {
        return Math.abs(getFirstOperand().evaluate());
    }

    @Override
    public ExpressionType getType() {
        return DefaultExpressionType.ABS;
    }

    @Override
    public String toString() {
        return getType().getName() + "(" + getFirstOperand() + ")";
    }
}
