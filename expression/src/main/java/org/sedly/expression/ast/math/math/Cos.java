package org.sedly.expression.ast.math.math;

import org.sedly.expression.ast.Expression;
import org.sedly.expression.ast.OneOperandExpression;
import org.sedly.expression.lexer.token.TokenType;
import org.sedly.expression.lexer.token.impl.TokenTypes;


public class Cos extends OneOperandExpression<Double, Double> {
    public Cos(Expression<Double> expression) {
        super(expression);
    }

    public Cos(Double value) {
        super(value);
    }

    @Override
    public Double evaluate() {
        return Math.cos(getFirstOperand().evaluate());
    }

    @Override
    public TokenType getType() {
        return TokenTypes.cos();
    }

    @Override
    public String toString() {
        return getType().getName() + "(" + getFirstOperand() + ")";
    }

}
