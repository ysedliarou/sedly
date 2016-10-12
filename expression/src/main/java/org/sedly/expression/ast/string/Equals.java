package org.sedly.expression.ast.string;

import org.sedly.expression.ast.EvaluationContext;
import org.sedly.expression.ast.TwoOperandsExpression;
import org.sedly.expression.ast.Expression;

public class Equals extends TwoOperandsExpression<Boolean, String> {

    public Equals(Expression<String> firstExpression, Expression<String> secondExpression) {
        super(firstExpression, secondExpression);
    }

    public Equals(String firstValue, String secondValue) {
        super(firstValue, secondValue);
    }

    @Override
    public Boolean evaluate(EvaluationContext context) {
        return evaluateFirstValue(context).equals(evaluateSecondValue(context));
    }

}
