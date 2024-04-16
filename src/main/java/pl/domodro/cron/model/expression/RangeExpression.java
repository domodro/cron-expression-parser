package pl.domodro.cron.model.expression;

public record RangeExpression(ValueExpression from, ValueExpression to) implements GenerationExpression {
    public RangeExpression(ValueExpression from) {
        this(from, null);
    }
}
