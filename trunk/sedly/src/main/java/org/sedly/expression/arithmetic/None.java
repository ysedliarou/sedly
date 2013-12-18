package org.sedly.expression.arithmetic;

import org.sedly.expression.Expression;

public class None extends ArithmeticExpression {

    public None(Expression<Double> firstExpression) {
        this(firstExpression, null);
    }

    protected None(Expression<Double> firstExpression, Expression<Double> secondExpression) {
        super(firstExpression, secondExpression);
    }

    @Override
    public Double evaluate() {
        return evaluateLeftValue();
    }

}
