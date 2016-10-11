package org.sedly.expression.ast.math.condition;

import org.sedly.expression.ast.Expression;
import org.sedly.expression.ast.TwoOperandsExpression;
import org.sedly.expression.lexer.token.impl.ConditionTokenType;
import org.sedly.expression.lexer.token.TokenType;

public class NotEquals extends TwoOperandsExpression<Boolean, Double> {

    public NotEquals(Expression<Double> firstOperand, Expression<Double> secondOperand) {
        super(firstOperand, secondOperand);
    }

    public NotEquals(Double firstValue, Double secondValue) {
        super(firstValue, secondValue);
    }

    @Override
    public Boolean evaluate() {
        return !evaluateFirstValue().equals(evaluateSecondValue());
    }

    @Override
    public TokenType getType() {
        return ConditionTokenType.NOT_EQUALS;
    }

    @Override
    public String toString() {
        return getFirstOperand() + getType().getName() + getSecondOperand();
    }
}
