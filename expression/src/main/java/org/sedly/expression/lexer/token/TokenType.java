package org.sedly.expression.lexer.token;

import java.util.Objects;

public class TokenType {

    private String name;

    public TokenType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    @Override
    public boolean equals(Object obj) {
        return obj == this || obj instanceof TokenType
                && Objects.equals(name, ((TokenType) obj).name);
    }

    @Override
    public String toString() {
        return name;
    }
}
