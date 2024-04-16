package pl.domodro.cron.interpreter;

import pl.domodro.cron.model.NumericResult;
import pl.domodro.cron.model.Type;
import pl.domodro.cron.model.expression.DivideExpression;
import pl.domodro.cron.validator.BiValidator;
import pl.domodro.cron.validator.Validation;

class DivideStrategy implements InterpretationStrategy<DivideExpression, NumericResult> {
    private final BiValidator<Type, Integer> validator = new BiValidator<>(
            Validation.of((type, divider) -> divider == 0, "Division by zero")
    );
    private final ExpressionInterpreter interpreter;

    DivideStrategy(ExpressionInterpreter interpreter) {
        this.interpreter = interpreter;
    }

    @Override
    public NumericResult interpret(Type type, DivideExpression expression) {
        var divider = interpreter.interpretValue(type, expression.divider());
        validator.validate(type, divider);

        var result = interpreter.context(type, expression.dividend()).interpret()
                .value()
                .stream()
                .filter(value -> value % divider == 0)
                .toList();
        return new NumericResult(type, result);
    }
}
