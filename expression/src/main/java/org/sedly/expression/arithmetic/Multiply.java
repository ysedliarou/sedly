package org.sedly.expression.arithmetic;

import org.sedly.expression.Expression;
import org.sedly.expression.TwoOperandsExpression;
import org.sedly.expression.Value;
import org.sedly.expression.name.DefaultExpressionType;
import org.sedly.expression.name.ExpressionType;


public class Multiply extends TwoOperandsExpression<Double, Double> {

    public Multiply(Expression<Double> firstExpression, Expression<Double> secondExpression) {
        super(firstExpression, secondExpression);
    }

    public Multiply(Double firstValue, Double secondValue) {
        super(firstValue, secondValue);
    }

    @Override
    public Double evaluate() {
        return evaluateFirstValue() * evaluateSecondValue();
    }

    @Override
    public ExpressionType getType() {
        return DefaultExpressionType.MULTIPLY;
    }

    @Override
    public String toString() {
        return (getFirstOperand() instanceof Value ? getFirstOperand() : "(" + getFirstOperand()
                + ")")
                + getType().getName()
                + (getSecondOperand() instanceof Value ? getSecondOperand() : "("
                        + getSecondOperand() + ")");
    }
}
