package pl.domodro.cron.interpreter;

import pl.domodro.cron.CronException;
import pl.domodro.cron.model.NumericResult;
import pl.domodro.cron.model.Type;
import pl.domodro.cron.model.expression.ValueExpression;
import pl.domodro.cron.validator.BiValidator;
import pl.domodro.cron.validator.Validation;

import java.time.DayOfWeek;
import java.time.Month;
import java.time.temporal.TemporalAccessor;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

class ValueStrategy implements InterpretationStrategy<ValueExpression, NumericResult> {
    private final BiValidator<Type, Integer> validator = new BiValidator<>(
            Validation.of((type, value) -> Objects.isNull(value), "Invalid value specified"),
            Validation.of((type, value) -> value < type.minValue(), "Value below range"),
            Validation.of((type, value) -> !type.isOverlapping() && value > type.maxValue(), "Value above range"),
            Validation.of((type, value) -> type.isOverlapping() && value > type.maxValue() + 1, "Value above range")
    );
    private final Map<String, Integer> monthMap = Arrays.stream(Month.values())
            .collect(Collectors.toMap(this::toCronName, Month::getValue));
    private final Map<String, Integer> weekdayMap = Arrays.stream(DayOfWeek.values())
            .collect(Collectors.toMap(this::toCronName, DayOfWeek::getValue));

    @Override
    public NumericResult interpret(Type type, ValueExpression expression) {
        Integer resolvedValue = switch (expression.value()) {
            case String number when allCharsMatch(number, Character::isDigit) -> Integer.parseInt(number);
            case String month when Type.MONTH.equals(type) && allCharsMatch(month, Character::isAlphabetic) ->
                    monthMap.get(expression.value().toLowerCase());
            case String weekday when Type.DAY_OF_WEEK.equals(type) && allCharsMatch(weekday, Character::isAlphabetic) ->
                    weekdayMap.get(expression.value().toLowerCase());
            default -> throw new CronException("Invalid value specified");
        };
        validator.validate(type, resolvedValue);
        return new NumericResult(type, List.of(resolvedValue));
    }

    private String toCronName(Enum<? extends TemporalAccessor> value) {
        return value.name().toLowerCase().substring(0, 3);
    }

    private boolean allCharsMatch(String value, Function<Integer, Boolean> matcher) {
        return !value.isEmpty() && value.chars().allMatch(matcher::apply);
    }
}
