package pl.domodro.cron.interpreter;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pl.domodro.cron.CronException;
import pl.domodro.cron.model.NumericResult;
import pl.domodro.cron.model.expression.DivideExpression;
import pl.domodro.cron.model.expression.Expression;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static pl.domodro.cron.fixtures.DivideExpressionFixtures.*;
import static pl.domodro.cron.fixtures.RangeExpressionFixtures.RANGE_EXPRESSION_INVALID;

public class DivideStrategyTest {
    private final ExpressionInterpreter mockInterpreter = mock(ExpressionInterpreter.class);
    private final ExpressionContext mockDividendExpression = mock(ExpressionContext.class);
    private final DivideStrategy objectUnderTest = new DivideStrategy(mockInterpreter);

    @ParameterizedTest
    @MethodSource("validExpressions")
    void shouldReturnValidDivision(Expression expression, List<Integer> dividend, int divider, List<Integer> expected) {
        // given
        DivideExpression divideExpression = (DivideExpression) expression.expression();
        when(mockDividendExpression.interpret()).thenReturn(new NumericResult(expression.type(), dividend));
        when(mockInterpreter.context(expression.type(), divideExpression.dividend()))
                .thenReturn(mockDividendExpression);
        when(mockInterpreter.interpretValue(expression.type(), divideExpression.divider())).thenReturn(divider);

        // when
        var result = objectUnderTest.interpret(expression.type(), divideExpression);

        // then
        assertThat(result.type()).isEqualTo(expression.type());
        assertThat(result.value()).isEqualTo(expected);
    }

    @Test
    void shouldThrowOnDivisionByZero() {
        // given
        DivideExpression divideExpression = (DivideExpression) DIVIDE_EXPRESSION_BY_ZERO.expression();
        when(mockDividendExpression.interpret()).thenReturn(
                new NumericResult(DIVIDE_EXPRESSION_BY_ZERO.type(), List.of(1)));
        when(mockInterpreter.context(DIVIDE_EXPRESSION_BY_ZERO.type(), divideExpression.dividend()))
                .thenReturn(mockDividendExpression);
        when(mockInterpreter.interpretValue(DIVIDE_EXPRESSION_BY_ZERO.type(), divideExpression.divider()))
                .thenReturn(0);

        // when
        ThrowableAssert.ThrowingCallable functionUnderTest =
                () -> objectUnderTest.interpret(RANGE_EXPRESSION_INVALID.type(), divideExpression);

        // then
        assertThatThrownBy(functionUnderTest)
                .isInstanceOf(CronException.class);
    }

    private static Stream<Arguments> validExpressions() {
        return Stream.of(
                Arguments.of(DIVIDE_EXPRESSION_VALUE, List.of(1), 3, List.of()),
                Arguments.of(DIVIDE_EXPRESSION_RANGE, List.of(1, 2, 3), 3, List.of(3)),
                Arguments.of(DIVIDE_EXPRESSION_ASTERISK, List.of(0, 1, 2, 3, 4, 5, 6), 2, List.of(0, 2, 4, 6))
        );
    }
}
