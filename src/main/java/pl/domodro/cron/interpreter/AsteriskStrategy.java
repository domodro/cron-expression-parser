package pl.domodro.cron.interpreter;

import pl.domodro.cron.model.NumericResult;
import pl.domodro.cron.model.Type;
import pl.domodro.cron.model.expression.AsteriskExpression;

import java.util.stream.IntStream;

class AsteriskStrategy implements InterpretationStrategy<AsteriskExpression, NumericResult> {
    @Override
    public NumericResult interpret(Type type, AsteriskExpression expression) {
        var result = IntStream.rangeClosed(type.minValue(), type.maxValue())
                .boxed()
                .toList();
        return new NumericResult(type, result);
    }
}
