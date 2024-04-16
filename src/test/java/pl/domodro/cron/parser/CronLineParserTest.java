package pl.domodro.cron.parser;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.ArgumentCaptor;
import pl.domodro.cron.CronException;
import pl.domodro.cron.model.Type;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.*;
import static pl.domodro.cron.fixtures.CronLineFixtures.*;

public class CronLineParserTest {
    private final ExpressionParser mockExpressionParser = mock(ExpressionParser.class);
    private final CronLineParser objectUnderTest = new CronLineParser(mockExpressionParser);

    @Test
    void shouldParseCorrectCronLine() {
        // when
        objectUnderTest.parse(DUMMY_CRON_LINE);

        // then
        var typeCaptor = ArgumentCaptor.forClass(Type.class);
        var expressionCaptor = ArgumentCaptor.forClass(String.class);
        verify(mockExpressionParser, times(6)).parse(typeCaptor.capture(), expressionCaptor.capture());
        assertThat(typeCaptor.getAllValues())
                .containsExactly(Type.MINUTE, Type.HOUR, Type.DAY_OF_MONTH, Type.MONTH, Type.DAY_OF_WEEK, Type.COMMAND);
        assertThat(expressionCaptor.getAllValues())
                .containsExactly("*/1", "*/2", "*/3", "*/4", "*/5", "*/6 */7 */8");
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {BLANK_CRON_LINE, TOO_SHORT_CRON_LINE})
    void shouldThrowOnIncorrectCronLine(String input) {
        // when
        ThrowableAssert.ThrowingCallable functionUnderTest = () -> objectUnderTest.parse(input);

        // then
        assertThatThrownBy(functionUnderTest)
                .isInstanceOf(CronException.class);
    }
}
