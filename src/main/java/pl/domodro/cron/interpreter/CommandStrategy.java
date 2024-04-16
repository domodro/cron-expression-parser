package pl.domodro.cron.interpreter;

import pl.domodro.cron.model.TextResult;
import pl.domodro.cron.model.Type;
import pl.domodro.cron.model.expression.CommandExpression;

class CommandStrategy implements InterpretationStrategy<CommandExpression, TextResult> {
    @Override
    public TextResult interpret(Type type, CommandExpression expression) {
        return new TextResult(type, expression.value());
    }
}
