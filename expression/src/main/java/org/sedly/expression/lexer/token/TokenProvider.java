package org.sedly.expression.lexer.token;

import java.util.Set;


public interface TokenProvider {

    Set<TokenType> provide();

}
