package pl.domodro.cron.fixtures;

public class ExpressionFixtures {
    public static final String ASTERISK_EXPRESSION = "*";
    public static final String COMMAND_EXPRESSION = "/usr/bin/find -1";
    public static final String VALUE_EXPRESSION_NUMBER = "1";
    public static final String VALUE_EXPRESSION_STRING = "jan";
    public static final String RANGE_EXPRESSION_NUMBER = "1-5";
    public static final String RANGE_EXPRESSION_STRING = "mon-fri";
    public static final String RANGE_EXPRESSION_STRING_MIXED = "mon-5";
    public static final String RANGE_EXPRESSION_FROM = "1-";
    public static final String RANGE_EXPRESSION_SIGN = "-";
    public static final String RANGE_EXPRESSION_TO = "-5";
    public static final String DIVISION_EXPRESSION_ASTERISK = "*/2";
    public static final String DIVISION_EXPRESSION_VALUE = "2/2";
    public static final String DIVISION_EXPRESSION_RANGE = "0-23/2";
    public static final String DIVISION_EXPRESSION_DIVIDEND = "*/";
    public static final String DIVISION_EXPRESSION_SIGN = "/";
    public static final String DIVISION_EXPRESSION_DIVIDER = "/2";
    public static final String INCORRECT_EXPRESSION_DOUBLE_RANGE = "2-2-2";
    public static final String INCORRECT_EXPRESSION_DOUBLE_DIVIDE = "*/2/2";
}

