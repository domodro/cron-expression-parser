package pl.domodro.cron.it.fixtures;

public class CronLineFixtures {
    public static final String CRON_LINE_EXAMPLE = "*/15 0 1,15 * 1-5 /usr/bin/find";
    public static final String CRON_LINE_ASTERISKS = "* * * * * /usr/bin/find";
    public static final String CRON_LINE_VALUES = "0 0 1 1 0 /usr/bin/find";
    public static final String CRON_LINE_MULTIPLE_VALUES = "0,1 0,1 1,2 1,2 0,1 /usr/bin/find";
    public static final String CRON_LINE_RANGES = "0-59 0-23 1-31 1-12 0-6 /usr/bin/find";
    public static final String CRON_LINE_MULTIPLE_RANGES_OVERLAPPING = "0-50,10-59 0-18,12-23 1-30,2-31 1-8,8-12 0-4,2-7 /usr/bin/find";
    public static final String CRON_LINE_ASTERISKS_DIVIDED = "*/2 */2 */2 */2 */2 /usr/bin/find";
    public static final String CRON_LINE_RANGES_DIVIDED = "0-4/2 0-4/2 1-5/2 1-5/2 0-4/2 /usr/bin/find";
    public static final String CRON_LINE_VALUES_DIVIDED = "1/2 2/2 3/2 4/2 5/2 /usr/bin/find";
    public static final String CRON_LINE_OVERLAPPING_DAYS_RANGE = "*/15 0 1,15 * 0-7 /usr/bin/find";
    public static final String CRON_LINE_OVERLAPPING_DAYS_VALUES = "*/15 0 1,15 * 0,7 /usr/bin/find";
    public static final String CRON_LINE_OVERLAPPING_DAYS_RANGES = "*/15 0 1,15 * 0-4,4-7 /usr/bin/find";
    public static final String CRON_LINE_NAMED_VALUES = "*/15 0 1,15 jan,mar mon,fri /usr/bin/find";
    public static final String CRON_LINE_NAMED_RANGES = "*/15 0 1,15 jan-mar,may-oct mon-wed,fri-sat /usr/bin/find";
    public static final String CRON_LINE_NAMED_OVERLAPPING = "*/15 0 1,15 jan-oct,may-dec sun-wed,fri-sun /usr/bin/find";
    public static final String CRON_LINE_MULTIPLE_VALUES_RANGES = "0,1-5 0,1-5 1,2-6 1,2-6 0,1-5 /usr/bin/find";
    public static final String CRON_LINE_COMMAND_AND = "*/15 0 1,15 * 1-5 /usr/bin/find && sleep 1";
    public static final String CRON_LINE_COMMAND_OR = "*/15 0 1,15 * 1-5 /usr/bin/find || sleep 1";

    public static final String CRON_LINE_INVALID_TOO_SHORT = "*/15";
}
