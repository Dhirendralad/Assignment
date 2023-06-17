package org.example;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserValidator {
    public static void validateFirstName(String firstName) throws InvalidUserDetailsException {
        String firstNameRegex = "^[A-Z][a-zA-Z]{2,}$";
        Pattern pattern = Pattern.compile(firstNameRegex);
        Matcher matcher = pattern.matcher(firstName);
        if (!matcher.matches()) {
            throw new InvalidUserDetailsException("Invalid first name: " + firstName);
        }
    }

    public static void validateLastName(String lastName) throws InvalidUserDetailsException {
        String lastNameRegex = "^[A-Z][a-zA-Z]{2,}$";
        Pattern pattern = Pattern.compile(lastNameRegex);
        Matcher matcher = pattern.matcher(lastName);
        if (!matcher.matches()) {
            throw new InvalidUserDetailsException("Invalid last name: " + lastName);
        }
    }

    public static void validateEmail(String email) throws InvalidUserDetailsException {
        String emailRegex = "^[a-zA-Z0-9]+([._+-][a-zA-Z0-9]+)*@[a-zA-Z0-9]+\\.[a-zA-Z]{2,4}(\\.[a-zA-Z]{2})*$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        if (!matcher.matches()) {
            throw new InvalidUserDetailsException("Invalid email: " + email);
        }
    }

    public static void validateMobileNumber(String mobileNumber) throws InvalidUserDetailsException {
        String mobileNumberRegex = "^[0-9]{2}\\s[0-9]{10}$";
        Pattern pattern = Pattern.compile(mobileNumberRegex);
        Matcher matcher = pattern.matcher(mobileNumber);
        if (!matcher.matches()) {
            throw new InvalidUserDetailsException("Invalid mobile number: " + mobileNumber);
        }
    }

    public static void validatePassword(String password) throws InvalidUserDetailsException {
        String passwordRegex = "^(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=])(?!.*\\s).{8,}$";
        Pattern pattern = Pattern.compile(passwordRegex);
        Matcher matcher = pattern.matcher(password);
        if (!matcher.matches()) {
            throw new InvalidUserDetailsException("Invalid password");
        }
    }
}


