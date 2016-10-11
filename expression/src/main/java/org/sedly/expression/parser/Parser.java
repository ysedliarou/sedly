package org.sedly.expression.parser;

import org.sedly.expression.ast.Expression;

public interface Parser {

    Expression<?> parse();

}
