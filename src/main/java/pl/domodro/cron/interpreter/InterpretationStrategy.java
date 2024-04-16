package pl.domodro.cron.interpreter;

import pl.domodro.cron.model.CronResult;
import pl.domodro.cron.model.Type;
import pl.domodro.cron.model.expression.InternalExpression;

public interface InterpretationStrategy<S extends InternalExpression, T extends CronResult<?>> {
    T interpret(Type type, S expression);
}
