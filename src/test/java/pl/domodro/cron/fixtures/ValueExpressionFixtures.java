package pl.domodro.cron.fixtures;

import pl.domodro.cron.model.Type;
import pl.domodro.cron.model.expression.Expression;
import pl.domodro.cron.model.expression.ValueExpression;

public class ValueExpressionFixtures {
    public static final Expression VALUE_EXPRESSION_MINUTE_MIN = new Expression(Type.MINUTE, new ValueExpression("0"));
    public static final Expression VALUE_EXPRESSION_MINUTE_IN = new Expression(Type.MINUTE, new ValueExpression("20"));
    public static final Expression VALUE_EXPRESSION_MINUTE_MAX = new Expression(Type.MINUTE, new ValueExpression("59"));
    public static final Expression VALUE_EXPRESSION_MINUTE_EMPTY = new Expression(Type.MINUTE, new ValueExpression(""));
    public static final Expression VALUE_EXPRESSION_MINUTE_ABOVE = new Expression(Type.MINUTE, new ValueExpression("60"));
    public static final Expression VALUE_EXPRESSION_MINUTE_MONTH = new Expression(Type.MINUTE, new ValueExpression("jan"));
    public static final Expression VALUE_EXPRESSION_MINUTE_WEEK = new Expression(Type.MINUTE, new ValueExpression("mon"));

    public static final Expression VALUE_EXPRESSION_HOUR_MIN = new Expression(Type.HOUR, new ValueExpression("0"));
    public static final Expression VALUE_EXPRESSION_HOUR_IN = new Expression(Type.HOUR, new ValueExpression("20"));
    public static final Expression VALUE_EXPRESSION_HOUR_MAX = new Expression(Type.HOUR, new ValueExpression("23"));
    public static final Expression VALUE_EXPRESSION_HOUR_EMPTY = new Expression(Type.HOUR, new ValueExpression(""));
    public static final Expression VALUE_EXPRESSION_HOUR_ABOVE = new Expression(Type.HOUR, new ValueExpression("24"));
    public static final Expression VALUE_EXPRESSION_HOUR_MONTH = new Expression(Type.HOUR, new ValueExpression("jan"));
    public static final Expression VALUE_EXPRESSION_HOUR_WEEK = new Expression(Type.HOUR, new ValueExpression("mon"));

    public static final Expression VALUE_EXPRESSION_DAY_OF_MONTH_MIN = new Expression(Type.DAY_OF_MONTH, new ValueExpression("1"));
    public static final Expression VALUE_EXPRESSION_DAY_OF_MONTH_IN = new Expression(Type.DAY_OF_MONTH, new ValueExpression("20"));
    public static final Expression VALUE_EXPRESSION_DAY_OF_MONTH_MAX = new Expression(Type.DAY_OF_MONTH, new ValueExpression("31"));
    public static final Expression VALUE_EXPRESSION_DAY_OF_MONTH_EMPTY = new Expression(Type.DAY_OF_MONTH, new ValueExpression(""));
    public static final Expression VALUE_EXPRESSION_DAY_OF_MONTH_BELOW = new Expression(Type.DAY_OF_MONTH, new ValueExpression("0"));
    public static final Expression VALUE_EXPRESSION_DAY_OF_MONTH_ABOVE = new Expression(Type.DAY_OF_MONTH, new ValueExpression("32"));
    public static final Expression VALUE_EXPRESSION_DAY_OF_MONTH_MONTH = new Expression(Type.DAY_OF_MONTH, new ValueExpression("jan"));
    public static final Expression VALUE_EXPRESSION_DAY_OF_MONTH_WEEK = new Expression(Type.DAY_OF_MONTH, new ValueExpression("mon"));

    public static final Expression VALUE_EXPRESSION_MONTH_MIN = new Expression(Type.MONTH, new ValueExpression("1"));
    public static final Expression VALUE_EXPRESSION_MONTH_IN = new Expression(Type.MONTH, new ValueExpression("10"));
    public static final Expression VALUE_EXPRESSION_MONTH_MAX = new Expression(Type.MONTH, new ValueExpression("12"));
    public static final Expression VALUE_EXPRESSION_MONTH_TEXT_LOWER = new Expression(Type.MONTH, new ValueExpression("jan"));
    public static final Expression VALUE_EXPRESSION_MONTH_TEXT_UPPER = new Expression(Type.MONTH, new ValueExpression("FEB"));
    public static final Expression VALUE_EXPRESSION_MONTH_TEXT_MIXED = new Expression(Type.MONTH, new ValueExpression("Mar"));
    public static final Expression VALUE_EXPRESSION_MONTH_EMPTY = new Expression(Type.MONTH, new ValueExpression(""));
    public static final Expression VALUE_EXPRESSION_MONTH_BELOW = new Expression(Type.MONTH, new ValueExpression("0"));
    public static final Expression VALUE_EXPRESSION_MONTH_ABOVE = new Expression(Type.MONTH, new ValueExpression("13"));
    public static final Expression VALUE_EXPRESSION_MONTH_INCORRECT = new Expression(Type.MONTH, new ValueExpression("february"));
    public static final Expression VALUE_EXPRESSION_MONTH_WEEK = new Expression(Type.MONTH, new ValueExpression("mon"));

    public static final Expression VALUE_EXPRESSION_DAY_OF_WEEK_MIN = new Expression(Type.DAY_OF_WEEK, new ValueExpression("0"));
    public static final Expression VALUE_EXPRESSION_DAY_OF_WEEK_IN = new Expression(Type.DAY_OF_WEEK, new ValueExpression("5"));
    public static final Expression VALUE_EXPRESSION_DAY_OF_WEEK_MAX = new Expression(Type.DAY_OF_WEEK, new ValueExpression("7"));
    public static final Expression VALUE_EXPRESSION_DAY_OF_WEEK_TEXT_LOWER = new Expression(Type.DAY_OF_WEEK, new ValueExpression("tue"));
    public static final Expression VALUE_EXPRESSION_DAY_OF_WEEK_TEXT_UPPER = new Expression(Type.DAY_OF_WEEK, new ValueExpression("WED"));
    public static final Expression VALUE_EXPRESSION_DAY_OF_WEEK_TEXT_MIXED = new Expression(Type.DAY_OF_WEEK, new ValueExpression("Thu"));
    public static final Expression VALUE_EXPRESSION_DAY_OF_WEEK_EMPTY = new Expression(Type.DAY_OF_WEEK, new ValueExpression(""));
    public static final Expression VALUE_EXPRESSION_DAY_OF_WEEK_ABOVE = new Expression(Type.DAY_OF_WEEK, new ValueExpression("8"));
    public static final Expression VALUE_EXPRESSION_DAY_OF_WEEK_MONTH = new Expression(Type.DAY_OF_WEEK, new ValueExpression("jan"));
    public static final Expression VALUE_EXPRESSION_DAY_OF_WEEK_INCORRECT = new Expression(Type.DAY_OF_WEEK, new ValueExpression("monday"));
}
