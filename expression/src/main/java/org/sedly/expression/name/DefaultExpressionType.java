package org.sedly.expression.name;

public enum DefaultExpressionType implements ExpressionType {

    PLUS("+"), MINUS("-"), MULTIPLY("*"), DIVIDE("/"),

    EQUALS("=="), NOT_EQUALS("!="), GRATER(">"), GREATER_OR_EQUALS(">="), LESS("<"), LESS_OR_EQUALS(
            "<="),

    AND("&&"), OR("||"), NOT("!"), XOR("^"),

    ABS("abs"), SIN("sin"), COS("cos");

    private String name;

    private int priority;

    DefaultExpressionType(String name) {
        this.name = name;
        this.priority = DEFAULT_PRIORITY;
    }

    DefaultExpressionType(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getPriority() {
        return priority;
    }

}
