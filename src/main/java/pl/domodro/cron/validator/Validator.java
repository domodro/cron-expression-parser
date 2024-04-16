package pl.domodro.cron.validator;

import java.util.function.Function;

public class Validator<T> extends AbstractValidator<Function<T, Boolean>> {

    @SafeVarargs
    public Validator(Validation<Function<T, Boolean>>... validations) {
        super(validations);
    }

    public void validate(T value) {
        validate(validation -> validation.function().apply(value));
    }
}
