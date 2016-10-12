package org.sedly.expression.ast.math.condition;

import org.sedly.expression.ast.EvaluationContext;
import org.sedly.expression.ast.Expression;
import org.sedly.expression.ast.TwoOperandsExpression;

public class Equals extends TwoOperandsExpression<Boolean, Double> {

    public Equals(Expression<Double> firstExpression, Expression<Double> secondExpression) {
        super(firstExpression, secondExpression);
    }

    public Equals(Double firstValue, Double secondValue) {
        super(firstValue, secondValue);
    }

    @Override
    public Boolean evaluate(EvaluationContext context) {
        return evaluateFirstValue(context).equals(evaluateSecondValue(context));
    }

}
