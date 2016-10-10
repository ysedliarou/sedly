package org.sedly.expression.name;

public interface ExpressionType {

    int DEFAULT_PRIORITY = 0;

    String getName();

    int getPriority();

}
