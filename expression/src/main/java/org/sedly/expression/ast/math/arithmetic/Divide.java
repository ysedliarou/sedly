package org.sedly.expression.ast.math.arithmetic;

import org.sedly.expression.ast.EvaluationException;
import org.sedly.expression.ast.Expression;
import org.sedly.expression.ast.TwoOperandsExpression;
import org.sedly.expression.ast.Value;
import org.sedly.expression.lexer.token.impl.ArithmeticTokenType;
import org.sedly.expression.lexer.token.TokenType;


public class Divide extends TwoOperandsExpression<Double, Double> {

    public Divide(Expression<Double> firstExpression, Expression<Double> secondExpression) {
        super(firstExpression, secondExpression);
    }

    public Divide(Double firstValue, Double secondValue) {
        super(firstValue, secondValue);
    }

    @Override
    public Double evaluate() {
        final Double secondValue = evaluateSecondValue();
        if (secondValue == 0) {
            throw new EvaluationException("Division by zero.");
        }
        return evaluateFirstValue() / secondValue;
    }

    @Override
    public TokenType getType() {
        return ArithmeticTokenType.DIVIDE;
    }

    public String toString() {
        return (getFirstOperand() instanceof Value ? getFirstOperand() : "(" + getFirstOperand()
                + ")")
                + getType().getName()
                + (getSecondOperand() instanceof Value ? getSecondOperand() : "("
                        + getSecondOperand() + ")");
    }
}
