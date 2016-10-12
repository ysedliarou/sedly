package org.sedly.expression.ast.math.logic;

import org.sedly.expression.ast.EvaluationContext;
import org.sedly.expression.ast.Expression;
import org.sedly.expression.ast.TwoOperandsExpression;

public class Or extends TwoOperandsExpression<Boolean, Boolean> {

    public Or(Expression<Boolean> firstExpression, Expression<Boolean> secondExpression) {
        super(firstExpression, secondExpression);
    }

    public Or(Boolean firstValue, Boolean secondValue) {
        super(firstValue, secondValue);
    }

    @Override
    public Boolean evaluate(EvaluationContext context) {
        return evaluateFirstValue(context) || evaluateSecondValue(context);
    }

}
