package org.sedly.expression.ast.math.math;

import org.sedly.expression.ast.EvaluationContext;
import org.sedly.expression.ast.Expression;
import org.sedly.expression.ast.OneOperandExpression;

public class Sin extends OneOperandExpression<Double, Double> {
    public Sin(Expression<Double> expression) {
        super(expression);
    }

    public Sin(Double value) {
        super(value);
    }

    @Override
    public Double evaluate(EvaluationContext context) {
        return Math.sin(getFirstOperand().evaluate(context));
    }

}
