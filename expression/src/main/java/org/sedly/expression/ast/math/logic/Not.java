package org.sedly.expression.ast.math.logic;

import org.sedly.expression.ast.EvaluationContext;
import org.sedly.expression.ast.Expression;
import org.sedly.expression.ast.OneOperandExpression;

public class Not extends OneOperandExpression<Boolean, Boolean> {

    public Not(Expression<Boolean> expression) {
        super(expression);
    }

    public Not(Boolean value) {
        super(value);
    }

    @Override
    public Boolean evaluate(EvaluationContext context) {
        return !evaluateFirstValue(context);
    }

}
