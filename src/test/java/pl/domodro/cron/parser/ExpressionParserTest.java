package pl.domodro.cron.parser;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import pl.domodro.cron.CronException;
import pl.domodro.cron.model.Type;
import pl.domodro.cron.model.expression.InternalExpression;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static pl.domodro.cron.fixtures.ExpressionFixtures.*;
import static pl.domodro.cron.fixtures.InternalExpressionFixtures.*;

public class ExpressionParserTest {
    private final ExpressionParser objectUnderTest = new ExpressionParser();

    @Test
    void shouldParseCommandExpression() {
        // given
        var type = Type.COMMAND;

        // when
        var result = objectUnderTest.parse(type, COMMAND_EXPRESSION);

        // then
        assertThat(result.type()).isEqualTo(type);
        assertThat(result.expression()).isEqualTo(PARSED_COMMAND_EXPRESSION);
    }

    @ParameterizedTest
    @MethodSource("validExpressions")
    void shouldParseExpression(String input, InternalExpression expected) {
        // given
        var type = Type.DAY_OF_WEEK;

        // when
        var result = objectUnderTest.parse(type, input);

        // then
        assertThat(result.type()).isEqualTo(type);
        assertThat(result.expression()).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {INCORRECT_EXPRESSION_DOUBLE_RANGE, INCORRECT_EXPRESSION_DOUBLE_DIVIDE})
    void shouldThrowOnIncorrectExpression(String input) {
        // when
        ThrowableAssert.ThrowingCallable functionUnderTest = () -> objectUnderTest.parse(Type.DAY_OF_WEEK, input);

        // then
        assertThatThrownBy(functionUnderTest)
                .isInstanceOf(CronException.class);
    }

    private static Stream<Arguments> validExpressions() {
        return Stream.of(
                Arguments.of(ASTERISK_EXPRESSION, PARSED_ASTERISK_EXPRESSION),
                Arguments.of(VALUE_EXPRESSION_NUMBER, PARSED_VALUE_EXPRESSION_NUMBER),
                Arguments.of(VALUE_EXPRESSION_STRING, PARSED_VALUE_EXPRESSION_STRING),
                Arguments.of(RANGE_EXPRESSION_NUMBER, PARSED_RANGE_EXPRESSION_NUMBER),
                Arguments.of(RANGE_EXPRESSION_STRING, PARSED_RANGE_EXPRESSION_STRING),
                Arguments.of(RANGE_EXPRESSION_STRING_MIXED, PARSED_RANGE_EXPRESSION_STRING_MIXED),
                Arguments.of(RANGE_EXPRESSION_FROM, PARSED_RANGE_EXPRESSION_FROM),
                Arguments.of(RANGE_EXPRESSION_SIGN, PARSED_RANGE_EXPRESSION_SIGN),
                Arguments.of(RANGE_EXPRESSION_TO, PARSED_RANGE_EXPRESSION_TO),
                Arguments.of(DIVISION_EXPRESSION_ASTERISK, PARSED_DIVISION_EXPRESSION_ASTERISK),
                Arguments.of(DIVISION_EXPRESSION_VALUE, PARSED_DIVISION_EXPRESSION_VALUE),
                Arguments.of(DIVISION_EXPRESSION_RANGE, PARSED_DIVISION_EXPRESSION_RANGE),
                Arguments.of(DIVISION_EXPRESSION_DIVIDEND, PARSED_DIVISION_EXPRESSION_DIVIDEND),
                Arguments.of(DIVISION_EXPRESSION_SIGN, PARSED_DIVISION_EXPRESSION_SIGN),
                Arguments.of(DIVISION_EXPRESSION_DIVIDER, PARSED_DIVISION_EXPRESSION_DIVIDER)
        );
    }
}
