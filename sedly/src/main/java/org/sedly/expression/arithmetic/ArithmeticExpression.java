package org.sedly.expression.arithmetic;

import org.sedly.expression.AbstractExpression;
import org.sedly.expression.Expression;

public abstract class ArithmeticExpression extends AbstractExpression<Double, Double> {

    protected ArithmeticExpression(Expression<Double> firstExpression, Expression<Double> secondExpression) {
        super(firstExpression, secondExpression);
    }

    @Override
    protected Double evaluateLeftValue() {
        return (Double) getLeftExpression().evaluate();
    }

    @Override
    protected Double evaluateRightValue() {
        return (Double) getRightExpression().evaluate();
    }

}
