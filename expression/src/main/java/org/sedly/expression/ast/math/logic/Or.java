package org.sedly.expression.ast.math.logic;

import org.sedly.expression.ast.Expression;
import org.sedly.expression.ast.TwoOperandsExpression;
import org.sedly.expression.lexer.token.impl.LogicTokenType;
import org.sedly.expression.lexer.token.TokenType;


public class Or extends TwoOperandsExpression<Boolean, Boolean> {

    public Or(Expression<Boolean> firstExpression, Expression<Boolean> secondExpression) {
        super(firstExpression, secondExpression);
    }

    public Or(Boolean firstValue, Boolean secondValue) {
        super(firstValue, secondValue);
    }

    @Override
    public Boolean evaluate() {
        return evaluateFirstValue() || evaluateSecondValue();
    }

    @Override
    public TokenType getType() {
        return LogicTokenType.OR;
    }

    @Override
    public String toString() {
        return getFirstOperand() + getType().getName() + getSecondOperand();
    }

}
