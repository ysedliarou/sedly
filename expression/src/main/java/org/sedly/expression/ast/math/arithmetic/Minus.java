package org.sedly.expression.ast.math.arithmetic;

import org.sedly.expression.ast.EvaluationContext;
import org.sedly.expression.ast.Expression;
import org.sedly.expression.ast.TwoOperandsExpression;

public class Minus extends TwoOperandsExpression<Double, Double> {

    public Minus(Expression<Double> firstExpression, Expression<Double> secondExpression) {
        super(firstExpression, secondExpression);
    }

    public Minus(Double firstValue, Double secondValue) {
        super(firstValue, secondValue);
    }

    @Override
    public Double evaluate(EvaluationContext context) {
        return evaluateFirstValue(context) - evaluateSecondValue(context);
    }

}
