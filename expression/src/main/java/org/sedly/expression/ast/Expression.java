package org.sedly.expression.ast;


public interface Expression<R> {

    R evaluate(EvaluationContext context);

}
