package pl.domodro.cron;

public class CronException extends RuntimeException {
    public CronException(String message) {
        super(message);
    }
}
