package pl.domodro.cron.model;

public sealed interface CronResult<T> permits NumericResult, TextResult {
    Type type();
    T value();
}
