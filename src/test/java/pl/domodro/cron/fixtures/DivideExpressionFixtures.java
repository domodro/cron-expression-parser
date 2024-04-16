package pl.domodro.cron.fixtures;

import pl.domodro.cron.model.Type;
import pl.domodro.cron.model.expression.AsteriskExpression;
import pl.domodro.cron.model.expression.DivideExpression;
import pl.domodro.cron.model.expression.Expression;
import pl.domodro.cron.model.expression.RangeExpression;
import pl.domodro.cron.model.expression.ValueExpression;

public class DivideExpressionFixtures {
    public static final Expression DIVIDE_EXPRESSION_VALUE
            = new Expression(Type.HOUR, new DivideExpression(new ValueExpression("1"), new ValueExpression("3")));
    public static final Expression DIVIDE_EXPRESSION_RANGE = new Expression(Type.HOUR, new DivideExpression(
                    new RangeExpression(new ValueExpression("1"), new ValueExpression("3")), new ValueExpression("3")));
    public static final Expression DIVIDE_EXPRESSION_ASTERISK
            = new Expression(Type.DAY_OF_WEEK, new DivideExpression(new AsteriskExpression(), new ValueExpression("2")));
    public static final Expression DIVIDE_EXPRESSION_BY_ZERO
            = new Expression(Type.HOUR, new DivideExpression(new ValueExpression("3"), new ValueExpression("0")));
}
