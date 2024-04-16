package pl.domodro.cron;

import pl.domodro.cron.validator.Validation;
import pl.domodro.cron.validator.Validator;

public class Main {
    private final Validator<String[]> validator = new Validator<>(
            Validation.of(args -> args.length != 1, "Invalid amount of program arguments, expected 1")
    );
    private final CronParser parser = new CronParser();
    private final CronPrinter printer = new CronPrinter();

    public static void main(String[] args) {
        new Main().run(args);
    }

    private void run(String[] args) {
        try {
            validator.validate(args);
            var result = parser.parse(args[0]);
            printer.print(result);
        } catch (CronException e) {
            System.out.printf("ERROR: %s%n", e.getMessage());
        }
    }
}
