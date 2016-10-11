package org.sedly.expression.ast.math.arithmetic;

import org.sedly.expression.ast.Expression;
import org.sedly.expression.ast.TwoOperandsExpression;
import org.sedly.expression.ast.Value;
import org.sedly.expression.lexer.token.impl.ArithmeticTokenType;
import org.sedly.expression.lexer.token.TokenType;


public class Multiply extends TwoOperandsExpression<Double, Double> {

    public Multiply(Expression<Double> firstExpression, Expression<Double> secondExpression) {
        super(firstExpression, secondExpression);
    }

    public Multiply(Double firstValue, Double secondValue) {
        super(firstValue, secondValue);
    }

    @Override
    public Double evaluate() {
        return evaluateFirstValue() * evaluateSecondValue();
    }

    @Override
    public TokenType getType() {
        return ArithmeticTokenType.MULTIPLY;
    }

    @Override
    public String toString() {
        return (getFirstOperand() instanceof Value ? getFirstOperand() : "(" + getFirstOperand()
                + ")")
                + getType().getName()
                + (getSecondOperand() instanceof Value ? getSecondOperand() : "("
                        + getSecondOperand() + ")");
    }
}
