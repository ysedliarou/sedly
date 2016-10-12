package org.sedly.expression.ast.math.math;

import org.sedly.expression.ast.EvaluationContext;
import org.sedly.expression.ast.Expression;
import org.sedly.expression.ast.OneOperandExpression;

public class Abs extends OneOperandExpression<Double, Double> {
    public Abs(Expression<Double> expression) {
        super(expression);
    }

    public Abs(Double value) {
        super(value);
    }

    @Override
    public Double evaluate(EvaluationContext context) {
        return Math.abs(getFirstOperand().evaluate(context));
    }

}
