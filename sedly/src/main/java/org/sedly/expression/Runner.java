package org.sedly.expression;

import org.sedly.expression.arithmetic.Plus;
import org.sedly.expression.condition.Equals;
import org.sedly.expression.logic.Not;

public class Runner {

    public static void main(String[] args) {

        Value<Double> v1 = new Value<Double>(1.0);
        Value<Double> v2 = new Value<Double>(2.0);
        Expression<Double> plus = new Plus(v1, v2);

        Value<Double> v3 = new Value<Double>(3.0);
        Expression<Boolean> equals = new Equals(plus, v3);

        Expression<Boolean> not = new Not(equals);
        Boolean res = not.evaluate();

        System.out.println(res);

    }


}
