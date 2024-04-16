package pl.domodro.cron.interpreter;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pl.domodro.cron.CronException;
import pl.domodro.cron.model.expression.Expression;
import pl.domodro.cron.model.expression.ValueExpression;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static pl.domodro.cron.fixtures.ValueExpressionFixtures.*;

public class ValueStrategyTest {
    private final ValueStrategy objectUnderTest = new ValueStrategy();

    @ParameterizedTest
    @MethodSource("validExpressions")
    void shouldParseValidValue(Expression input, int expected) {
        // when
        var result = objectUnderTest.interpret(input.type(), (ValueExpression) input.expression());

        // then
        assertThat(result.type()).isEqualTo(input.type());
        assertThat(result.value().getFirst()).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("invalidExpressions")
    void shouldThrowOnInvalidValue(Expression input) {
        // when
        ThrowableAssert.ThrowingCallable functionUnderTest =
                () -> objectUnderTest.interpret(input.type(), (ValueExpression) input.expression());

        // then
        assertThatThrownBy(functionUnderTest)
                .isInstanceOf(CronException.class);
    }

    private static Stream<Arguments> validExpressions() {
        return Stream.of(
                Arguments.of(VALUE_EXPRESSION_MINUTE_MIN, 0),
                Arguments.of(VALUE_EXPRESSION_MINUTE_IN, 20),
                Arguments.of(VALUE_EXPRESSION_MINUTE_MAX, 59),
                Arguments.of(VALUE_EXPRESSION_HOUR_MIN, 0),
                Arguments.of(VALUE_EXPRESSION_HOUR_IN, 20),
                Arguments.of(VALUE_EXPRESSION_HOUR_MAX, 23),
                Arguments.of(VALUE_EXPRESSION_DAY_OF_MONTH_MIN, 1),
                Arguments.of(VALUE_EXPRESSION_DAY_OF_MONTH_IN, 20),
                Arguments.of(VALUE_EXPRESSION_DAY_OF_MONTH_MAX, 31),
                Arguments.of(VALUE_EXPRESSION_MONTH_MIN, 1),
                Arguments.of(VALUE_EXPRESSION_MONTH_IN, 10),
                Arguments.of(VALUE_EXPRESSION_MONTH_MAX, 12),
                Arguments.of(VALUE_EXPRESSION_MONTH_TEXT_LOWER, 1),
                Arguments.of(VALUE_EXPRESSION_MONTH_TEXT_UPPER, 2),
                Arguments.of(VALUE_EXPRESSION_MONTH_TEXT_MIXED, 3),
                Arguments.of(VALUE_EXPRESSION_DAY_OF_WEEK_MIN, 0),
                Arguments.of(VALUE_EXPRESSION_DAY_OF_WEEK_IN, 5),
                Arguments.of(VALUE_EXPRESSION_DAY_OF_WEEK_MAX, 7),
                Arguments.of(VALUE_EXPRESSION_DAY_OF_WEEK_TEXT_LOWER, 2),
                Arguments.of(VALUE_EXPRESSION_DAY_OF_WEEK_TEXT_UPPER, 3),
                Arguments.of(VALUE_EXPRESSION_DAY_OF_WEEK_TEXT_MIXED, 4)
        );
    }

    private static Stream<Arguments> invalidExpressions() {
        return Stream.of(
                Arguments.of(VALUE_EXPRESSION_MINUTE_EMPTY),
                Arguments.of(VALUE_EXPRESSION_MINUTE_ABOVE),
                Arguments.of(VALUE_EXPRESSION_MINUTE_MONTH),
                Arguments.of(VALUE_EXPRESSION_MINUTE_WEEK),
                Arguments.of(VALUE_EXPRESSION_HOUR_EMPTY),
                Arguments.of(VALUE_EXPRESSION_HOUR_ABOVE),
                Arguments.of(VALUE_EXPRESSION_HOUR_MONTH),
                Arguments.of(VALUE_EXPRESSION_HOUR_WEEK),
                Arguments.of(VALUE_EXPRESSION_DAY_OF_MONTH_EMPTY),
                Arguments.of(VALUE_EXPRESSION_DAY_OF_MONTH_BELOW),
                Arguments.of(VALUE_EXPRESSION_DAY_OF_MONTH_ABOVE),
                Arguments.of(VALUE_EXPRESSION_DAY_OF_MONTH_MONTH),
                Arguments.of(VALUE_EXPRESSION_DAY_OF_MONTH_WEEK),
                Arguments.of(VALUE_EXPRESSION_MONTH_EMPTY),
                Arguments.of(VALUE_EXPRESSION_MONTH_BELOW),
                Arguments.of(VALUE_EXPRESSION_MONTH_ABOVE),
                Arguments.of(VALUE_EXPRESSION_MONTH_INCORRECT),
                Arguments.of(VALUE_EXPRESSION_MONTH_WEEK),
                Arguments.of(VALUE_EXPRESSION_DAY_OF_WEEK_EMPTY),
                Arguments.of(VALUE_EXPRESSION_DAY_OF_WEEK_ABOVE),
                Arguments.of(VALUE_EXPRESSION_DAY_OF_WEEK_MONTH),
                Arguments.of(VALUE_EXPRESSION_DAY_OF_WEEK_INCORRECT)
        );
    }
}
