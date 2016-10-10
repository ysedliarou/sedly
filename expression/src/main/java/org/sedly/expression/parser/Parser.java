package org.sedly.expression.parser;

import org.sedly.expression.Expression;

public interface Parser {

    Expression<?> parse(String expression);

}
