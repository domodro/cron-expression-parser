package pl.domodro.cron.it.fixtures;

public class SystemOutFixtures {
    public static final String SYSTEM_OUT_CRON_LINE_EXAMPLE = """
            minute        0 15 30 45
            hour          0
            day of month  1 15
            month         1 2 3 4 5 6 7 8 9 10 11 12
            day of week   1 2 3 4 5
            command       /usr/bin/find
            """;
    public static final String SYSTEM_OUT_CRON_LINE_ASTERISKS = """
            minute        0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59
            hour          0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23
            day of month  1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31
            month         1 2 3 4 5 6 7 8 9 10 11 12
            day of week   0 1 2 3 4 5 6
            command       /usr/bin/find
            """;
    public static final String SYSTEM_OUT_CRON_LINE_VALUES = """
            minute        0
            hour          0
            day of month  1
            month         1
            day of week   0
            command       /usr/bin/find
            """;
    public static final String SYSTEM_OUT_CRON_LINE_MULTIPLE_VALUES = """
            minute        0 1
            hour          0 1
            day of month  1 2
            month         1 2
            day of week   0 1
            command       /usr/bin/find
            """;
    public static final String SYSTEM_OUT_CRON_LINE_RANGES = """
            minute        0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59
            hour          0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23
            day of month  1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31
            month         1 2 3 4 5 6 7 8 9 10 11 12
            day of week   0 1 2 3 4 5 6
            command       /usr/bin/find
            """;
    public static final String SYSTEM_OUT_CRON_LINE_MULTIPLE_RANGES_OVERLAPPING = """
            minute        0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59
            hour          0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23
            day of month  1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31
            month         1 2 3 4 5 6 7 8 9 10 11 12
            day of week   0 1 2 3 4 5 6
            command       /usr/bin/find
            """;
    public static final String SYSTEM_OUT_CRON_LINE_ASTERISKS_DIVIDED = """
            minute        0 2 4 6 8 10 12 14 16 18 20 22 24 26 28 30 32 34 36 38 40 42 44 46 48 50 52 54 56 58
            hour          0 2 4 6 8 10 12 14 16 18 20 22
            day of month  2 4 6 8 10 12 14 16 18 20 22 24 26 28 30
            month         2 4 6 8 10 12
            day of week   0 2 4 6
            command       /usr/bin/find
            """;
    public static final String SYSTEM_OUT_CRON_LINE_RANGES_DIVIDED = """
            minute        0 2 4
            hour          0 2 4
            day of month  2 4
            month         2 4
            day of week   0 2 4
            command       /usr/bin/find
            """;
    public static final String SYSTEM_OUT_CRON_LINE_VALUES_DIVIDED = """
            minute       \s
            hour          2
            day of month \s
            month         4
            day of week  \s
            command       /usr/bin/find
            """;
    public static final String SYSTEM_OUT_CRON_LINE_OVERLAPPING_DAYS_RANGE = """
            minute        0 15 30 45
            hour          0
            day of month  1 15
            month         1 2 3 4 5 6 7 8 9 10 11 12
            day of week   0 1 2 3 4 5 6
            command       /usr/bin/find
            """;
    public static final String SYSTEM_OUT_CRON_LINE_OVERLAPPING_DAYS_VALUES = """
            minute        0 15 30 45
            hour          0
            day of month  1 15
            month         1 2 3 4 5 6 7 8 9 10 11 12
            day of week   0 7
            command       /usr/bin/find
            """;
    public static final String SYSTEM_OUT_CRON_LINE_OVERLAPPING_DAYS_RANGES = """
            minute        0 15 30 45
            hour          0
            day of month  1 15
            month         1 2 3 4 5 6 7 8 9 10 11 12
            day of week   0 1 2 3 4 5 6
            command       /usr/bin/find
            """;
    public static final String SYSTEM_OUT_CRON_LINE_NAMED_VALUES = """
            minute        0 15 30 45
            hour          0
            day of month  1 15
            month         1 3
            day of week   1 5
            command       /usr/bin/find
            """;
    public static final String SYSTEM_OUT_CRON_LINE_NAMED_RANGES = """
            minute        0 15 30 45
            hour          0
            day of month  1 15
            month         1 2 3 5 6 7 8 9 10
            day of week   1 2 3 5 6
            command       /usr/bin/find
            """;
    public static final String SYSTEM_OUT_CRON_LINE_NAMED_OVERLAPPING = """
            minute        0 15 30 45
            hour          0
            day of month  1 15
            month         1 2 3 4 5 6 7 8 9 10 11 12
            day of week   0 1 2 3 5 6
            command       /usr/bin/find
            """;
    public static final String SYSTEM_OUT_CRON_LINE_MULTIPLE_VALUES_RANGES = """
            minute        0 1 2 3 4 5
            hour          0 1 2 3 4 5
            day of month  1 2 3 4 5 6
            month         1 2 3 4 5 6
            day of week   0 1 2 3 4 5
            command       /usr/bin/find
            """;
    public static final String SYSTEM_OUT_CRON_LINE_COMMAND_AND = """
            minute        0 15 30 45
            hour          0
            day of month  1 15
            month         1 2 3 4 5 6 7 8 9 10 11 12
            day of week   1 2 3 4 5
            command       /usr/bin/find && sleep 1
            """;
    public static final String SYSTEM_OUT_CRON_LINE_COMMAND_OR = """
            minute        0 15 30 45
            hour          0
            day of month  1 15
            month         1 2 3 4 5 6 7 8 9 10 11 12
            day of week   1 2 3 4 5
            command       /usr/bin/find || sleep 1
            """;
}
