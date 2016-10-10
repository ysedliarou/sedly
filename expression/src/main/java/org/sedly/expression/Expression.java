package org.sedly.expression;

import org.sedly.expression.name.ExpressionType;


public interface Expression<R> {

    R evaluate();

    ExpressionType getType();

}
