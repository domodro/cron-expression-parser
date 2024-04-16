package pl.domodro.cron.fixtures;

import pl.domodro.cron.model.Type;
import pl.domodro.cron.model.expression.Expression;
import pl.domodro.cron.model.expression.RangeExpression;
import pl.domodro.cron.model.expression.ValueExpression;

public class RangeExpressionFixtures {
    public static final Expression RANGE_EXPRESSION_VALID
            = new Expression(Type.HOUR, new RangeExpression(new ValueExpression("1"), new ValueExpression("3")));
    public static final Expression RANGE_EXPRESSION_SAME_VALUE
            = new Expression(Type.HOUR, new RangeExpression(new ValueExpression("2"), new ValueExpression("2")));
    public static final Expression RANGE_EXPRESSION_INVALID
            = new Expression(Type.HOUR, new RangeExpression(new ValueExpression("3"), new ValueExpression("1")));
}
