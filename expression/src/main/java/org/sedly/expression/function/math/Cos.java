package org.sedly.expression.function.math;

import org.sedly.expression.Expression;
import org.sedly.expression.name.DefaultExpressionType;
import org.sedly.expression.OneOperandExpression;
import org.sedly.expression.name.ExpressionType;


public class Cos extends OneOperandExpression<Double, Double> {
    public Cos(Expression<Double> expression) {
        super(expression);
    }

    public Cos(Double value) {
        super(value);
    }

    @Override
    public Double evaluate() {
        return Math.cos(getFirstOperand().evaluate());
    }

    @Override
    public ExpressionType getType() {
        return DefaultExpressionType.COS;
    }

    @Override
    public String toString() {
        return getType().getName() + "(" + getFirstOperand() + ")";
    }

}
