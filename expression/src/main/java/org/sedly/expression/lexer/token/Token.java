package org.sedly.expression.lexer.token;


public class Token {

    private TokenType tokenType;

    private String data;

    public TokenType getTokenType() {
        return tokenType;
    }

    public String getData() {
        return data;
    }

    public Token(TokenType tokenType, String data) {
        this.tokenType = tokenType;
        this.data = data;
    }
}
