package pl.domodro.cron.model.expression;

public record DivideExpression(GenerationExpression dividend, ValueExpression divider) implements InternalExpression {
    public DivideExpression(GenerationExpression dividend) {
        this(dividend, null);
    }
}
