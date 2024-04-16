package pl.domodro.cron.interpreter;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pl.domodro.cron.CronException;
import pl.domodro.cron.model.expression.Expression;
import pl.domodro.cron.model.expression.RangeExpression;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static pl.domodro.cron.fixtures.RangeExpressionFixtures.*;

public class RangeStrategyTest {
    private final ExpressionInterpreter mockInterpreter = mock(ExpressionInterpreter.class);
    private final RangeStrategy objectUnderTest = new RangeStrategy(mockInterpreter);

    @ParameterizedTest
    @MethodSource("validExpressions")
    void shouldReturnValidRange(Expression expression, int from, int to, List<Integer> expected) {
        // given
        RangeExpression rangeExpression = (RangeExpression) expression.expression();
        when(mockInterpreter.interpretValue(expression.type(), rangeExpression.from())).thenReturn(from);
        when(mockInterpreter.interpretValue(expression.type(), rangeExpression.to())).thenReturn(to);

        // when
        var result = objectUnderTest.interpret(expression.type(), rangeExpression);

        // then
        assertThat(result.type()).isEqualTo(expression.type());
        assertThat(result.value()).isEqualTo(expected);
    }

    @Test
    void shouldThrowOnInvalidRange() {
        // given
        RangeExpression rangeExpression = (RangeExpression) RANGE_EXPRESSION_INVALID.expression();
        when(mockInterpreter.interpretValue(RANGE_EXPRESSION_INVALID.type(), rangeExpression.from())).thenReturn(3);
        when(mockInterpreter.interpretValue(RANGE_EXPRESSION_INVALID.type(), rangeExpression.to())).thenReturn(1);

        // when
        ThrowableAssert.ThrowingCallable functionUnderTest =
                () -> objectUnderTest.interpret(RANGE_EXPRESSION_INVALID.type(), rangeExpression);

        // then
        assertThatThrownBy(functionUnderTest)
                .isInstanceOf(CronException.class);
    }

    private static Stream<Arguments> validExpressions() {
        return Stream.of(
                Arguments.of(RANGE_EXPRESSION_VALID, 1, 3, List.of(1, 2, 3)),
                Arguments.of(RANGE_EXPRESSION_SAME_VALUE, 2, 2, List.of(2))
        );
    }
}
