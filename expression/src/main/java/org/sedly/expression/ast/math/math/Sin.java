package org.sedly.expression.ast.math.math;

import org.sedly.expression.ast.Expression;
import org.sedly.expression.ast.OneOperandExpression;
import org.sedly.expression.lexer.token.TokenType;
import org.sedly.expression.lexer.token.impl.TokenTypes;


public class Sin extends OneOperandExpression<Double, Double> {
    public Sin(Expression<Double> expression) {
        super(expression);
    }

    public Sin(Double value) {
        super(value);
    }

    @Override
    public Double evaluate() {
        return Math.sin(getFirstOperand().evaluate());
    }

    @Override
    public TokenType getType() {
        return TokenTypes.sin();
    }

    @Override
    public String toString() {
        return getType().getName() + "(" + getFirstOperand() + ")";
    }

}
