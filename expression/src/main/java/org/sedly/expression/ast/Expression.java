package org.sedly.expression.ast;

import org.sedly.expression.lexer.token.TokenType;


public interface Expression<R> {

    R evaluate();

    TokenType getType();

}
