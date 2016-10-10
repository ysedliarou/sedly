package org.sedly.expression.arithmetic;

import org.sedly.expression.EvaluationException;
import org.sedly.expression.Expression;
import org.sedly.expression.TwoOperandsExpression;
import org.sedly.expression.Value;
import org.sedly.expression.name.DefaultExpressionType;
import org.sedly.expression.name.ExpressionType;


public class Divide extends TwoOperandsExpression<Double, Double> {

    public Divide(Expression<Double> firstExpression, Expression<Double> secondExpression) {
        super(firstExpression, secondExpression);
    }

    public Divide(Double firstValue, Double secondValue) {
        super(firstValue, secondValue);
    }

    @Override
    public Double evaluate() {
        final Double secondValue = evaluateSecondValue();
        if (secondValue == 0) {
            throw new EvaluationException("Division by zero.");
        }
        return evaluateFirstValue() / secondValue;
    }

    @Override
    public ExpressionType getType() {
        return DefaultExpressionType.DIVIDE;
    }

    public String toString() {
        return (getFirstOperand() instanceof Value ? getFirstOperand() : "(" + getFirstOperand()
                + ")")
                + getType().getName()
                + (getSecondOperand() instanceof Value ? getSecondOperand() : "("
                        + getSecondOperand() + ")");
    }
}
