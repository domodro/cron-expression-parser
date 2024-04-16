package pl.domodro.cron.parser;

import pl.domodro.cron.CronException;
import pl.domodro.cron.model.Type;
import pl.domodro.cron.model.expression.AsteriskExpression;
import pl.domodro.cron.model.expression.CommandExpression;
import pl.domodro.cron.model.expression.DivideExpression;
import pl.domodro.cron.model.expression.EmptyExpression;
import pl.domodro.cron.model.expression.Expression;
import pl.domodro.cron.model.expression.GenerationExpression;
import pl.domodro.cron.model.expression.InternalExpression;
import pl.domodro.cron.model.expression.RangeExpression;
import pl.domodro.cron.model.expression.ValueExpression;

import java.util.Arrays;
import java.util.Objects;
import java.util.regex.Pattern;
import java.util.stream.Stream;

class ExpressionParser {
    private static final Pattern CRON_EXPRESSION_DELIMITER_PATTERN = Pattern.compile("[-/]");
    private static final String ASTERISK = "*";
    private static final String RANGE = "-";
    private static final String DIVISION = "/";

    Expression parse(Type type, String expression) {
        var expressionStream = Type.COMMAND.equals(type)
                ? Stream.of(expression)
                : Arrays.stream(CRON_EXPRESSION_DELIMITER_PATTERN.splitWithDelimiters(expression, -1));
        var parsedExpression = expressionStream
                .reduce(new InternalParser(type), InternalParser::parse, InternalParser::combine)
                .parsedExpression();
        return new Expression(type, parsedExpression);
    }

    private record InternalParser(Type type, InternalExpression parsedExpression) {
        private InternalParser(Type type) {
            this(type, new EmptyExpression());
        }

        private InternalParser parse(String expression) {
            var result = switch (parsedExpression) {
                case EmptyExpression ignored when ASTERISK.equals(expression) -> new AsteriskExpression();
                case EmptyExpression ignored when Type.COMMAND.equals(type) -> new CommandExpression(expression);
                case EmptyExpression ignored -> new ValueExpression(expression);
                case ValueExpression value when RANGE.equals(expression) -> new RangeExpression(value);
                case GenerationExpression generator when DIVISION.equals(expression) ->
                        new DivideExpression(generator);
                case RangeExpression(var from, var to) when Objects.isNull(to) ->
                        new RangeExpression(from, new ValueExpression(expression));
                case DivideExpression(var dividend, var divisor) when Objects.isNull(divisor) ->
                        new DivideExpression(dividend, new ValueExpression(expression));
                default -> throw new CronException("Unknown expression");
            };
            return new InternalParser(type, result);
        }

        private InternalParser combine(InternalParser ignored) {
            throw new UnsupportedOperationException();
        }
    }
}
