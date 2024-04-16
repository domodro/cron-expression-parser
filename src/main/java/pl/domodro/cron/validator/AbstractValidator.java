package pl.domodro.cron.validator;

import pl.domodro.cron.CronException;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

abstract class AbstractValidator<T> {
    private final List<Validation<T>> validations;

    @SafeVarargs
    AbstractValidator(Validation<T>... validations) {
        this.validations = Arrays.asList(validations);
    }

    void validate(Function<Validation<T>, Boolean> valueSupplier) {
        validations.stream()
                .filter(valueSupplier::apply)
                .findFirst()
                .ifPresent(validation -> {
                    throw new CronException(validation.errorMessage());
                });
    }
}
