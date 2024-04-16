package pl.domodro.cron.parser;

import pl.domodro.cron.model.Type;
import pl.domodro.cron.model.expression.Expression;
import pl.domodro.cron.validator.Validation;
import pl.domodro.cron.validator.Validator;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class CronLineParser {
    private static final Pattern CRON_FIELD_DELIMITER_PATTERN = Pattern.compile(" ");
    private static final Pattern CRON_VALUE_DELIMITER_PATTERN = Pattern.compile(",");

    private final Validator<String> cronLineValidator = new Validator<>(
            Validation.of(Objects::isNull, "Null value provided"),
            Validation.of(String::isBlank, "Empty value provided")
    );
    private final Validator<String[]> arrayValidator = new Validator<>(
            Validation.of(array -> array.length < 6, "Invalid amount of cronLine fields, expected 6")
    );
    private final Type[] types = Type.values();
    private final ExpressionParser parser;

    public CronLineParser() {
        this.parser = new ExpressionParser();
    }

    CronLineParser(ExpressionParser parser) {
        this.parser = parser;
    }

    public List<Expression> parse(String cronLine) {
        cronLineValidator.validate(cronLine);
        var expressions = CRON_FIELD_DELIMITER_PATTERN.split(cronLine, types.length);
        arrayValidator.validate(expressions);
        return IntStream.range(0, types.length)
                .boxed()
                .flatMap(i -> Arrays.stream(CRON_VALUE_DELIMITER_PATTERN.split(expressions[i]))
                        .map(expression -> parser.parse(types[i], expression)))
                .toList();
    }
}
