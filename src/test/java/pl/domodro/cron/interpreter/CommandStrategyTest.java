package pl.domodro.cron.interpreter;

import org.junit.jupiter.api.Test;
import pl.domodro.cron.model.Type;

import static org.assertj.core.api.Assertions.assertThat;
import static pl.domodro.cron.fixtures.ExpressionFixtures.COMMAND_EXPRESSION;
import static pl.domodro.cron.fixtures.InternalExpressionFixtures.PARSED_COMMAND_EXPRESSION;

public class CommandStrategyTest {
    private final CommandStrategy objectUnderTest = new CommandStrategy();

    @Test
    void shouldReturnTextResult() {
        // given
        var type = Type.COMMAND;

        // when
        var result = objectUnderTest.interpret(type, PARSED_COMMAND_EXPRESSION);

        // then
        assertThat(result.type()).isEqualTo(type);
        assertThat(result.value()).isEqualTo(COMMAND_EXPRESSION);
    }
}
