package pl.domodro.cron.interpreter;

import pl.domodro.cron.model.CronResult;
import pl.domodro.cron.model.Type;
import pl.domodro.cron.model.expression.InternalExpression;

public record ExpressionContext<E extends InternalExpression, R extends CronResult<?>>
        (Type type, E expression, InterpretationStrategy<E, R> strategy) {

    public R interpret() {
        return strategy.interpret(type, expression);
    }
}
