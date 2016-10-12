package org.sedly.expression.ast.math.condition;

import org.sedly.expression.ast.EvaluationContext;
import org.sedly.expression.ast.Expression;
import org.sedly.expression.ast.TwoOperandsExpression;

public class LessOrEquals extends TwoOperandsExpression<Boolean, Double> {

    public LessOrEquals(Expression<Double> firstExpression, Expression<Double> secondExpression) {
        super(firstExpression, secondExpression);
    }

    public LessOrEquals(Double firstValue, Double secondValue) {
        super(firstValue, secondValue);
    }

    @Override
    public Boolean evaluate(EvaluationContext context) {
        return evaluateFirstValue(context) <= evaluateSecondValue(context);
    }

}
