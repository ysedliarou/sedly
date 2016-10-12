package org.sedly.expression.ast;

public class Variable<R> implements Expression<R> {

    private String name;

    public Variable(String name) {
        this.name = name;
    }

    @Override
    public R evaluate(EvaluationContext context) {
        return null;
    }

}
