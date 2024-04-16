package pl.domodro.cron.model.expression;

public sealed interface InternalExpression
        permits GenerationExpression, CommandExpression, DivideExpression, EmptyExpression {
}
