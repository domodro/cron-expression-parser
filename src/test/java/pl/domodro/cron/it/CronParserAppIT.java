package pl.domodro.cron.it;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pl.domodro.cron.Main;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static pl.domodro.cron.it.fixtures.CronLineFixtures.*;
import static pl.domodro.cron.it.fixtures.SystemOutFixtures.*;

public class CronParserAppIT {
    @ParameterizedTest
    @MethodSource("validCronLines")
    void shouldPrintValues(String cronLine, String expectedOut) {
        // given
        var captor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captor));

        // when
        Main.main(new String[]{cronLine});

        // then
        assertThat(captor.toString()).isEqualTo(expectedOut);
    }

    @ParameterizedTest
    @MethodSource("invalidArguments")
    void shouldPrintErrorOnInvalidArguments(String[] arguments) {
        // given
        var captor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captor));

        // when
        Main.main(arguments);

        // then
        assertThat(captor.toString()).startsWith("ERROR");
    }

    @AfterAll
    static void tearDown() {
        System.setOut(System.out);
    }

    private static Stream<Arguments> validCronLines() {
        return Stream.of(
                Arguments.of(CRON_LINE_EXAMPLE, SYSTEM_OUT_CRON_LINE_EXAMPLE),
                Arguments.of(CRON_LINE_ASTERISKS, SYSTEM_OUT_CRON_LINE_ASTERISKS),
                Arguments.of(CRON_LINE_VALUES, SYSTEM_OUT_CRON_LINE_VALUES),
                Arguments.of(CRON_LINE_MULTIPLE_VALUES, SYSTEM_OUT_CRON_LINE_MULTIPLE_VALUES),
                Arguments.of(CRON_LINE_RANGES, SYSTEM_OUT_CRON_LINE_RANGES),
                Arguments.of(CRON_LINE_MULTIPLE_RANGES_OVERLAPPING, SYSTEM_OUT_CRON_LINE_MULTIPLE_RANGES_OVERLAPPING),
                Arguments.of(CRON_LINE_ASTERISKS_DIVIDED, SYSTEM_OUT_CRON_LINE_ASTERISKS_DIVIDED),
                Arguments.of(CRON_LINE_RANGES_DIVIDED, SYSTEM_OUT_CRON_LINE_RANGES_DIVIDED),
                Arguments.of(CRON_LINE_VALUES_DIVIDED, SYSTEM_OUT_CRON_LINE_VALUES_DIVIDED),
                Arguments.of(CRON_LINE_OVERLAPPING_DAYS_RANGE, SYSTEM_OUT_CRON_LINE_OVERLAPPING_DAYS_RANGE),
                Arguments.of(CRON_LINE_OVERLAPPING_DAYS_VALUES, SYSTEM_OUT_CRON_LINE_OVERLAPPING_DAYS_VALUES),
                Arguments.of(CRON_LINE_OVERLAPPING_DAYS_RANGES, SYSTEM_OUT_CRON_LINE_OVERLAPPING_DAYS_RANGES),
                Arguments.of(CRON_LINE_NAMED_VALUES, SYSTEM_OUT_CRON_LINE_NAMED_VALUES),
                Arguments.of(CRON_LINE_NAMED_RANGES, SYSTEM_OUT_CRON_LINE_NAMED_RANGES),
                Arguments.of(CRON_LINE_NAMED_OVERLAPPING, SYSTEM_OUT_CRON_LINE_NAMED_OVERLAPPING),
                Arguments.of(CRON_LINE_MULTIPLE_VALUES_RANGES, SYSTEM_OUT_CRON_LINE_MULTIPLE_VALUES_RANGES),
                Arguments.of(CRON_LINE_COMMAND_AND, SYSTEM_OUT_CRON_LINE_COMMAND_AND),
                Arguments.of(CRON_LINE_COMMAND_OR, SYSTEM_OUT_CRON_LINE_COMMAND_OR)
        );
    }

    private static Stream<Arguments> invalidArguments() {
        return Stream.of(
                Arguments.of((Object) new String[]{}),
                Arguments.of((Object) new String[]{CRON_LINE_EXAMPLE, CRON_LINE_EXAMPLE}),
                Arguments.of((Object) new String[]{CRON_LINE_EXAMPLE, CRON_LINE_EXAMPLE, CRON_LINE_EXAMPLE}),
                Arguments.of((Object) new String[]{CRON_LINE_INVALID_TOO_SHORT})
        );
    }
}
