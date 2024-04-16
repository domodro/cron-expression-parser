package pl.domodro.cron.model;

import java.util.List;

public record NumericResult(Type type, List<Integer> value) implements CronResult<List<Integer>> {
}
