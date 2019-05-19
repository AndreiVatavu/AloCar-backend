package com.alocar.backend.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Andrei Vatavu on 5/15/2019
 */
public class PhoneNumberValidator implements ConstraintValidator<ValidPhoneNumber, String> {
    private Pattern pattern;
    private Matcher matcher;
    private static final String PHONE_NUMBER_PATTERN = "^\\s?((\\+[1-9]{1,4}[ \\-]*)|(\\([0-9]{2,3}\\)[ \\-]*)|([0-9]{2,4})[ \\-]*)*?[0-9]{3,4}?[ \\-]*[0-9]{3,4}?\\s?";

    @Override
    public void initialize(final ValidPhoneNumber constraintAnnotation) {
    }

    @Override
    public boolean isValid(final String phoneNumber, final ConstraintValidatorContext context) {
        return (validatePhoneNumber(phoneNumber));
    }

    private boolean validatePhoneNumber(final String phoneNumber) {
        pattern = Pattern.compile(PHONE_NUMBER_PATTERN);
        matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }
}
