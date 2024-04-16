package pl.domodro.cron.model.expression;

public sealed interface GenerationExpression extends InternalExpression
        permits AsteriskExpression, RangeExpression, ValueExpression{
}
