package org.sedly.expression.ast.math.condition;

import org.sedly.expression.ast.EvaluationContext;
import org.sedly.expression.ast.Expression;
import org.sedly.expression.ast.TwoOperandsExpression;

public class NotEquals extends TwoOperandsExpression<Boolean, Double> {

    public NotEquals(Expression<Double> firstOperand, Expression<Double> secondOperand) {
        super(firstOperand, secondOperand);
    }

    public NotEquals(Double firstValue, Double secondValue) {
        super(firstValue, secondValue);
    }

    @Override
    public Boolean evaluate(EvaluationContext context) {
        return !evaluateFirstValue(context).equals(evaluateSecondValue(context));
    }

}
