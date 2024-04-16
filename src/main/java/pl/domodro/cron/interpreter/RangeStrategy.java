package pl.domodro.cron.interpreter;

import pl.domodro.cron.model.NumericResult;
import pl.domodro.cron.model.Type;
import pl.domodro.cron.model.expression.RangeExpression;
import pl.domodro.cron.validator.BiValidator;
import pl.domodro.cron.validator.Validation;

import java.util.stream.IntStream;

class RangeStrategy implements InterpretationStrategy<RangeExpression, NumericResult> {
    private final BiValidator<Integer, Integer> validator = new BiValidator<>(
            Validation.of((from, to) -> from > to, "Invalid range")
    );
    private final ExpressionInterpreter interpreter;

    RangeStrategy(ExpressionInterpreter interpreter) {
        this.interpreter = interpreter;
    }

    @Override
    public NumericResult interpret(Type type, RangeExpression expression) {
        var from = normalize(type, interpreter.interpretValue(type, expression.from()));
        var to = interpreter.interpretValue(type, expression.to());
        validator.validate(from, to);
        var result = IntStream.rangeClosed(from, to)
                .map(value -> normalize(type, value))
                .distinct()
                .sorted()
                .boxed()
                .toList();
        return new NumericResult(type, result);
    }

    private Integer normalize(Type type, Integer value) {
        return value % (type.maxValue() + 1);
    }
}
