package org.sedly.expression.lexer.token;

import java.util.HashSet;
import java.util.Set;

import org.sedly.expression.lexer.token.impl.ArithmeticTokenType;
import org.sedly.expression.lexer.token.impl.ConditionTokenType;
import org.sedly.expression.lexer.token.impl.LogicTokenType;
import org.sedly.expression.lexer.token.impl.FunctionTokenType;

import com.google.common.collect.ImmutableSet;

public class DefaultTokenProvider implements TokenProvider {

    private static Set<TokenType> ALL = ImmutableSet.<TokenType>builder()
            .addAll(ArithmeticTokenType.ALL).addAll(LogicTokenType.ALL)
            .addAll(ConditionTokenType.ALL).addAll(FunctionTokenType.ALL).build();

    @Override
    public Set<TokenType> provide() {
        Set<TokenType> tokenTypes = new HashSet<>();
        tokenTypes.addAll(ALL);
        return tokenTypes;
    }
}
