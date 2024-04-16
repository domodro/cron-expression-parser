package pl.domodro.cron.validator;

import java.util.function.BiFunction;

public class BiValidator<T, U> extends AbstractValidator<BiFunction<T, U, Boolean>> {

    @SafeVarargs
    public BiValidator(Validation<BiFunction<T, U, Boolean>>... validations) {
        super(validations);
    }

    public void validate(T value, U other) {
        validate(validation -> validation.function().apply(value, other));
    }
}
