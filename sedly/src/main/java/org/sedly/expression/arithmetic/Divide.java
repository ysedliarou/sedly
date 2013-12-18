package org.sedly.expression.arithmetic;

import org.sedly.expression.EvaluationException;
import org.sedly.expression.Expression;

public class Divide extends ArithmeticExpression {

    public Divide(Expression<Double> firstExpression, Expression<Double> secondExpression) {
        super(firstExpression, secondExpression);
    }

    @Override
    public Double evaluate() {
        Double right = evaluateRightValue();
        if (right == 0) {
            throw new EvaluationException("Division by zero;");
        }
        return evaluateLeftValue() / right;
    }

}
