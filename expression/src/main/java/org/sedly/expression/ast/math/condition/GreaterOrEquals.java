package org.sedly.expression.ast.math.condition;

import org.sedly.expression.ast.Expression;
import org.sedly.expression.ast.TwoOperandsExpression;
import org.sedly.expression.lexer.token.impl.ConditionTokenType;
import org.sedly.expression.lexer.token.TokenType;


public class GreaterOrEquals extends TwoOperandsExpression<Boolean, Double> {

    public GreaterOrEquals(Expression<Double> firstExpression, Expression<Double> secondExpression) {
        super(firstExpression, secondExpression);
    }

    public GreaterOrEquals(Double firstValue, Double secondValue) {
        super(firstValue, secondValue);
    }

    @Override
    public Boolean evaluate() {
        return evaluateFirstValue() >= evaluateSecondValue();
    }

    @Override
    public TokenType getType() {
        return ConditionTokenType.GREATER_OR_EQUALS;
    }

    @Override
    public String toString() {
        return getFirstOperand() + getType().getName() + getSecondOperand();
    }
}
