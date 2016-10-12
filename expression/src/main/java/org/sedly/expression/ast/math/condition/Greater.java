package org.sedly.expression.ast.math.condition;

import org.sedly.expression.ast.EvaluationContext;
import org.sedly.expression.ast.Expression;
import org.sedly.expression.ast.TwoOperandsExpression;

public class Greater extends TwoOperandsExpression<Boolean, Double> {

    public Greater(Expression<Double> firstExpression, Expression<Double> secondExpression) {
        super(firstExpression, secondExpression);
    }

    public Greater(Double firstValue, Double secondValue) {
        super(firstValue, secondValue);
    }

    @Override
    public Boolean evaluate(EvaluationContext context) {
        return evaluateFirstValue(context) > evaluateSecondValue(context);
    }

}
