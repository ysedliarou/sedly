package org.sedly.expression.ast.math.arithmetic;

import org.sedly.expression.ast.EvaluationContext;
import org.sedly.expression.ast.Expression;
import org.sedly.expression.ast.TwoOperandsExpression;

public class Multiply extends TwoOperandsExpression<Double, Double> {

    public Multiply(Expression<Double> firstExpression, Expression<Double> secondExpression) {
        super(firstExpression, secondExpression);
    }

    public Multiply(Double firstValue, Double secondValue) {
        super(firstValue, secondValue);
    }

    @Override
    public Double evaluate(EvaluationContext context) {
        return evaluateFirstValue(context) * evaluateSecondValue(context);
    }

}
