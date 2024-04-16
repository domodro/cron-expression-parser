package pl.domodro.cron;

import pl.domodro.cron.model.NumericResult;
import pl.domodro.cron.model.CronResult;
import pl.domodro.cron.model.TextResult;
import pl.domodro.cron.model.Type;

import java.util.Arrays;
import java.util.Collection;
import java.util.EnumMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

class CronPrinter {
    private static final String EMPTY = "";
    private static final String UNDERSCORE = "_";
    private static final String SPACE = " ";

    private final Map<Type, String> labels = new EnumMap<>(Arrays.stream(Type.values())
            .collect(Collectors.toMap(Function.identity(),
                    type -> type.name().toLowerCase().replace(UNDERSCORE, SPACE)))
    );

    void print(Collection<CronResult<?>> cronResult) {
        cronResult.forEach(this::print);
    }

    private void print(CronResult<?> result) {
        var valueText = switch (result) {
            case NumericResult(var ignored, var list) -> list.stream()
                    .reduce(EMPTY, (text, value) -> String.format("%s %s", text, value), (first, other) -> first)
                    .trim();
            case TextResult textResult -> textResult.value();
        };
        System.out.printf("%-14s%s\n", labels.get(result.type()), valueText);
    }
}
