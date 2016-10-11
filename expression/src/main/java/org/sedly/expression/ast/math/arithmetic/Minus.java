package org.sedly.expression.ast.math.arithmetic;

import org.sedly.expression.ast.Expression;
import org.sedly.expression.ast.TwoOperandsExpression;
import org.sedly.expression.lexer.token.impl.ArithmeticTokenType;
import org.sedly.expression.lexer.token.TokenType;


public class Minus extends TwoOperandsExpression<Double, Double> {

    public Minus(Expression<Double> firstExpression, Expression<Double> secondExpression) {
        super(firstExpression, secondExpression);
    }

    public Minus(Double firstValue, Double secondValue) {
        super(firstValue, secondValue);
    }

    @Override
    public Double evaluate() {
        return evaluateFirstValue() - evaluateSecondValue();
    }

    @Override
    public TokenType getType() {
        return ArithmeticTokenType.MINUS;
    }

    @Override
    public String toString() {
        return getFirstOperand() + getType().getName() + getSecondOperand();
    }
}
