package org.sedly.expression.ast.math.math;

import org.sedly.expression.ast.EvaluationContext;
import org.sedly.expression.ast.Expression;
import org.sedly.expression.ast.OneOperandExpression;

public class Cos extends OneOperandExpression<Double, Double> {
    public Cos(Expression<Double> expression) {
        super(expression);
    }

    public Cos(Double value) {
        super(value);
    }

    @Override
    public Double evaluate(EvaluationContext context) {
        return Math.cos(getFirstOperand().evaluate(context));
    }

}
