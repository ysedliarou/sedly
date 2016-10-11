package org.sedly.expression.ast.math.math;

import org.sedly.expression.ast.Expression;
import org.sedly.expression.ast.OneOperandExpression;
import org.sedly.expression.lexer.token.TokenType;
import org.sedly.expression.lexer.token.impl.TokenTypes;


public class Abs extends OneOperandExpression<Double, Double> {
    public Abs(Expression<Double> expression) {
        super(expression);
    }

    public Abs(Double value) {
        super(value);
    }

    @Override
    public Double evaluate() {
        return Math.abs(getFirstOperand().evaluate());
    }

    @Override
    public TokenType getType() {
        return TokenTypes.abs();
    }

    @Override
    public String toString() {
        return getType().getName() + "(" + getFirstOperand() + ")";
    }
}
