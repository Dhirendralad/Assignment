package org.example;

import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserValidator {

    public static void validate(String data, Predicate<String> validator, String errorMessage) throws InvalidUserDetailsException {
        if (!validator.test(data)) {
            throw new InvalidUserDetailsException(errorMessage);
        }
    }

    public static void validateFirstName(String firstName) throws InvalidUserDetailsException {
        String firstNameRegex = "^[A-Z][a-zA-Z]{2,}$";
        validate(firstName, str -> str.matches(firstNameRegex), "Invalid first name: " + firstName);
    }

    public static void validateLastName(String lastName) throws InvalidUserDetailsException {
        String lastNameRegex = "^[A-Z][a-zA-Z]{2,}$";
        validate(lastName, str -> str.matches(lastNameRegex), "Invalid last name: " + lastName);
    }

    public static void validateEmail(String email) throws InvalidUserDetailsException {
        String emailRegex = "^[a-zA-Z0-9]+([._+-][a-zA-Z0-9]+)*@[a-zA-Z0-9]+\\.[a-zA-Z]{2,4}(\\.[a-zA-Z]{2})*$";
        validate(email, str -> str.matches(emailRegex), "Invalid email: " + email);
    }

    public static void validateMobileNumber(String mobileNumber) throws InvalidUserDetailsException {
        String mobileNumberRegex = "^[0-9]{2}\\s[0-9]{10}$";
        validate(mobileNumber, str -> str.matches(mobileNumberRegex), "Invalid mobile number: " + mobileNumber);
    }

    public static void validatePassword(String password) throws InvalidUserDetailsException {
        String passwordRegex = "^(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=])(?!.*\\s).{8,}$";
        validate(password, str -> str.matches(passwordRegex), "Invalid password");
    }
}
