package org.sedly.expression.ast.math.arithmetic;

import org.sedly.expression.ast.EvaluationContext;
import org.sedly.expression.ast.EvaluationException;
import org.sedly.expression.ast.Expression;
import org.sedly.expression.ast.TwoOperandsExpression;

public class Divide extends TwoOperandsExpression<Double, Double> {

    public Divide(Expression<Double> firstExpression, Expression<Double> secondExpression) {
        super(firstExpression, secondExpression);
    }

    public Divide(Double firstValue, Double secondValue) {
        super(firstValue, secondValue);
    }

    @Override
    public Double evaluate(EvaluationContext context) {
        final Double secondValue = evaluateSecondValue(context);
        if (secondValue == 0) {
            throw new EvaluationException("Division by zero.");
        }
        return evaluateFirstValue(context) / secondValue;
    }

}
