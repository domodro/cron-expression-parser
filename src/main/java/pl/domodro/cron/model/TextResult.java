package pl.domodro.cron.model;

public record TextResult(Type type, String value) implements CronResult<String> {
}
