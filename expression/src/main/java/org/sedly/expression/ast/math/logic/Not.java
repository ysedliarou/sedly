package org.sedly.expression.ast.math.logic;

import org.sedly.expression.ast.Expression;
import org.sedly.expression.ast.OneOperandExpression;
import org.sedly.expression.lexer.token.impl.LogicTokenType;
import org.sedly.expression.lexer.token.TokenType;


public class Not extends OneOperandExpression<Boolean, Boolean> {

    public Not(Expression<Boolean> expression) {
        super(expression);
    }

    public Not(Boolean value) {
        super(value);
    }

    @Override
    public Boolean evaluate() {
        return !evaluateFirstValue();
    }

    @Override
    public TokenType getType() {
        return LogicTokenType.NOT;
    }

    @Override
    public String toString() {
        return getType().getName() + getFirstOperand();
    }
}
