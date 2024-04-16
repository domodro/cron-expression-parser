package pl.domodro.cron.interpreter;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import pl.domodro.cron.model.Type;
import pl.domodro.cron.model.expression.AsteriskExpression;

import static org.assertj.core.api.Assertions.assertThat;

public class AsteriskStrategyTest {
    private final AsteriskStrategy objectUnderTest = new AsteriskStrategy();

    @ParameterizedTest
    @EnumSource(value = Type.class, names = "COMMAND", mode = EnumSource.Mode.EXCLUDE)
    void shouldReturnWholeRangeForGivenType(Type type) {
        // given
        var input = new AsteriskExpression();

        // when
        var result = objectUnderTest.interpret(type, input);

        // then
        assertThat(result.value()).hasSizeBetween(type.maxValue(), type.maxValue() + 1);
        assertThat(result.value()).allSatisfy(value ->
                assertThat(value).isBetween(type.minValue(), type.maxValue()));
    }
}
