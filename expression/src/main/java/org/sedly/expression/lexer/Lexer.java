package org.sedly.expression.lexer;

import java.util.Deque;

import org.sedly.expression.lexer.token.Token;


public interface Lexer {

    Deque<Token> lex();

}
