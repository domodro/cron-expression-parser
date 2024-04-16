package pl.domodro.cron.validator;

public record Validation<T>(T function, String errorMessage) {

    public static <U> Validation<U> of(U function, String errorMessage) {
        return new Validation<>(function, errorMessage);
    }
}
