package pl.domodro.cron.fixtures;

import pl.domodro.cron.model.expression.AsteriskExpression;
import pl.domodro.cron.model.expression.CommandExpression;
import pl.domodro.cron.model.expression.DivideExpression;
import pl.domodro.cron.model.expression.RangeExpression;
import pl.domodro.cron.model.expression.ValueExpression;

import static pl.domodro.cron.fixtures.ExpressionFixtures.*;

public class InternalExpressionFixtures {
    public static final AsteriskExpression PARSED_ASTERISK_EXPRESSION = new AsteriskExpression();

    public static final CommandExpression PARSED_COMMAND_EXPRESSION = new CommandExpression(COMMAND_EXPRESSION);

    public static final ValueExpression PARSED_VALUE_EXPRESSION_NUMBER = new ValueExpression(VALUE_EXPRESSION_NUMBER);
    public static final ValueExpression PARSED_VALUE_EXPRESSION_STRING = new ValueExpression(VALUE_EXPRESSION_STRING);

    public static final RangeExpression PARSED_RANGE_EXPRESSION_NUMBER =
            new RangeExpression(new ValueExpression("1"), new ValueExpression("5"));
    public static final RangeExpression PARSED_RANGE_EXPRESSION_STRING =
            new RangeExpression(new ValueExpression("mon"), new ValueExpression("fri"));
    public static final RangeExpression PARSED_RANGE_EXPRESSION_STRING_MIXED =
            new RangeExpression(new ValueExpression("mon"), new ValueExpression("5"));
    public static final RangeExpression PARSED_RANGE_EXPRESSION_FROM =
            new RangeExpression(new ValueExpression("1"), new ValueExpression(""));
    public static final RangeExpression PARSED_RANGE_EXPRESSION_SIGN =
            new RangeExpression(new ValueExpression(""), new ValueExpression(""));
    public static final RangeExpression PARSED_RANGE_EXPRESSION_TO =
            new RangeExpression(new ValueExpression(""), new ValueExpression("5"));

    public static final DivideExpression PARSED_DIVISION_EXPRESSION_ASTERISK =
            new DivideExpression(new AsteriskExpression(), new ValueExpression("2"));
    public static final DivideExpression PARSED_DIVISION_EXPRESSION_VALUE =
            new DivideExpression(new ValueExpression("2"), new ValueExpression("2"));
    public static final DivideExpression PARSED_DIVISION_EXPRESSION_RANGE =
            new DivideExpression(
                    new RangeExpression(new ValueExpression("0"), new ValueExpression("23")),
                    new ValueExpression("2"));
    public static final DivideExpression PARSED_DIVISION_EXPRESSION_DIVIDEND =
            new DivideExpression(new AsteriskExpression(), new ValueExpression(""));
    public static final DivideExpression PARSED_DIVISION_EXPRESSION_SIGN =
            new DivideExpression(new ValueExpression(""), new ValueExpression(""));
    public static final DivideExpression PARSED_DIVISION_EXPRESSION_DIVIDER =
            new DivideExpression(new ValueExpression(""), new ValueExpression("2"));
}
