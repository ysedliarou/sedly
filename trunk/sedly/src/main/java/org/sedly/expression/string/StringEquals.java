package org.sedly.expression.string;


import org.sedly.expression.AbstractExpression;
import org.sedly.expression.Expression;

public class StringEquals extends AbstractExpression<Boolean, String> {

    public StringEquals(Expression<String> firstExpression, Expression<String> secondExpression) {
        super(firstExpression, secondExpression);
    }

    @Override
    protected String evaluateLeftValue() {
        return (String) getLeftExpression().evaluate();
    }

    @Override
    protected String evaluateRightValue() {
        return (String) getRightExpression().evaluate();
    }

    @Override
    public Boolean evaluate() {
        return evaluateLeftValue().equals(evaluateRightValue());
    }
}
