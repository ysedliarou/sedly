package org.sedly.expression.function.math;

import org.sedly.expression.Expression;
import org.sedly.expression.name.DefaultExpressionType;
import org.sedly.expression.OneOperandExpression;
import org.sedly.expression.name.ExpressionType;


public class Sin extends OneOperandExpression<Double, Double> {
    public Sin(Expression<Double> expression) {
        super(expression);
    }

    public Sin(Double value) {
        super(value);
    }

    @Override
    public Double evaluate() {
        return Math.sin(getFirstOperand().evaluate());
    }

    @Override
    public ExpressionType getType() {
        return DefaultExpressionType.SIN;
    }

    @Override
    public String toString() {
        return getType().getName() + "(" + getFirstOperand() + ")";
    }

}
