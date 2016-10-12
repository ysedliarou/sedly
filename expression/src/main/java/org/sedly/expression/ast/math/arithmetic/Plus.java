package org.sedly.expression.ast.math.arithmetic;

import org.sedly.expression.ast.EvaluationContext;
import org.sedly.expression.ast.Expression;
import org.sedly.expression.ast.TwoOperandsExpression;

public class Plus extends TwoOperandsExpression<Double, Double> {

    public Plus(Expression<Double> firstExpression, Expression<Double> secondExpression) {
        super(firstExpression, secondExpression);
    }

    public Plus(Double firstValue, Double secondValue) {
        super(firstValue, secondValue);
    }

    @Override
    public Double evaluate(EvaluationContext context) {
        return evaluateFirstValue(context) + evaluateSecondValue(context);
    }

}
