package pl.domodro.cron;

import pl.domodro.cron.interpreter.ExpressionInterpreter;
import pl.domodro.cron.model.NumericResult;
import pl.domodro.cron.model.CronResult;
import pl.domodro.cron.parser.CronLineParser;

import java.util.Collection;
import java.util.EnumMap;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CronParser {
    private final CronLineParser parser = new CronLineParser();
    private final ExpressionInterpreter interpreter = new ExpressionInterpreter();

    public Collection<CronResult<?>> parse(String cronLine) {
        var expressions = parser.parse(cronLine);
        var result = expressions.stream()
                .map(interpreter::interpret)
                .collect(Collectors.toMap(CronResult::type, Function.identity(), this::merge));
        return new EnumMap<>(result).values();
    }

    private CronResult<?> merge(CronResult<?> first, CronResult<?> other) {
        if (first instanceof NumericResult firstNumeric && other instanceof NumericResult otherNumeric) {
            return new NumericResult(firstNumeric.type(), mergeValues(firstNumeric.value(), otherNumeric.value()));
        }
        throw new CronException("Unsupported merge");
    }

    private List<Integer> mergeValues(List<Integer> first, List<Integer> other) {
        return Stream.concat(first.stream(), other.stream())
                .distinct()
                .sorted()
                .toList();
    }
}
