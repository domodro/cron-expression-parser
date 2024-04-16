package pl.domodro.cron.model.expression;

import pl.domodro.cron.model.Type;

public record Expression(Type type, InternalExpression expression) {
}
