package org.sedly.expression.ast.string;

import org.sedly.expression.ast.TwoOperandsExpression;
import org.sedly.expression.ast.Expression;
import org.sedly.expression.lexer.token.impl.ConditionTokenType;
import org.sedly.expression.lexer.token.TokenType;


public class Equals extends TwoOperandsExpression<Boolean, String> {

    public Equals(Expression<String> firstExpression, Expression<String> secondExpression) {
        super(firstExpression, secondExpression);
    }

    public Equals(String firstValue, String secondValue) {
        super(firstValue, secondValue);
    }

    @Override
    public Boolean evaluate() {
        return evaluateFirstValue().equals(evaluateSecondValue());
    }

    @Override
    public TokenType getType() {
        return ConditionTokenType.EQUALS;
    }

    @Override
    public String toString() {
        return getFirstOperand() + getType().toString() + getSecondOperand();
    }
}
