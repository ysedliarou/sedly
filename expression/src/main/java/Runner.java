import org.sedly.expression.ast.Expression;
import org.sedly.expression.ast.Value;
import org.sedly.expression.ast.math.arithmetic.Multiply;
import org.sedly.expression.ast.math.arithmetic.Plus;
import org.sedly.expression.ast.math.math.Cos;
import org.springframework.expression.spel.standard.SpelExpressionParser;

public class Runner {

    public static void main(String[] args) {

        SpelExpressionParser parser = new SpelExpressionParser();
        Integer res = parser.parseRaw("4*(2+2)").getValue(Integer.class);

        System.out.println(res);

        Expression<Double> plus = new Plus(1.0, 1.0);

        Expression<Double> multiply = new Multiply(new Value<>(4d), plus);
        System.out.println(multiply.toString());

        Expression<Double> cos = new Cos(multiply);
        System.out.println(cos.toString() + " = " + cos.evaluate());

    }
}