package pl.domodro.cron.interpreter;

import pl.domodro.cron.CronException;
import pl.domodro.cron.model.NumericResult;
import pl.domodro.cron.model.CronResult;
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

public class ExpressionInterpreter {
    private final AsteriskStrategy asteriskStrategy = new AsteriskStrategy();
    private final CommandStrategy commandStrategy = new CommandStrategy();
    private final ValueStrategy valueStrategy = new ValueStrategy();
    private final RangeStrategy rangeStrategy = new RangeStrategy(this);
    private final DivideStrategy divideStrategy = new DivideStrategy(this);

    public CronResult<?> interpret(Expression expression) {
        return context(expression.type(), expression.expression()).interpret();
    }

    Integer interpretValue(Type type, ValueExpression value) {
        return new ExpressionContext<>(type, value, valueStrategy).interpret()
                .value()
                .getFirst();
    }

    ExpressionContext<?, ?> context(Type type, InternalExpression expression) {
        return switch (expression) {
            case CommandExpression command -> new ExpressionContext<>(type, command, commandStrategy);
            case DivideExpression division -> new ExpressionContext<>(type, division, divideStrategy);
            case GenerationExpression generation -> context(type, generation);
            case EmptyExpression ignored -> throw new CronException("Empty expression");
        };
    }

    ExpressionContext<?, NumericResult> context(Type type, GenerationExpression expression) {
        return switch (expression) {
            case AsteriskExpression asterisk -> new ExpressionContext<>(type, asterisk, asteriskStrategy);
            case RangeExpression range -> new ExpressionContext<>(type, range, rangeStrategy);
            case ValueExpression value -> new ExpressionContext<>(type, value, valueStrategy);
        };
    }
}
