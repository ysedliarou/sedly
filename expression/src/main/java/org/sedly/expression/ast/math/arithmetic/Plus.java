package org.sedly.expression.ast.math.arithmetic;

import org.sedly.expression.ast.Expression;
import org.sedly.expression.ast.TwoOperandsExpression;
import org.sedly.expression.lexer.token.impl.ArithmeticTokenType;
import org.sedly.expression.lexer.token.TokenType;


public class Plus extends TwoOperandsExpression<Double, Double> {

    public Plus(Expression<Double> firstExpression, Expression<Double> secondExpression) {
        super(firstExpression, secondExpression);
    }

    public Plus(Double firstValue, Double secondValue) {
        super(firstValue, secondValue);
    }

    @Override
    public Double evaluate() {
        return evaluateFirstValue() + evaluateSecondValue();
    }

    @Override
    public TokenType getType() {
        return ArithmeticTokenType.PLUS;
    }

    @Override
    public String toString() {
        return getFirstOperand() + getType().getName() + getSecondOperand();
    }
}
