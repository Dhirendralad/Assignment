package org.example;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserValidatorSimple {
    public static boolean validFirstName(String firstName) {
        String firstNameRegex = "^[A-Z][a-zA-Z]{2,}$";
        Pattern pattern = Pattern.compile(firstNameRegex);
        Matcher matcher = pattern.matcher(firstName);
        return matcher.matches();
    }

    public static boolean validLastName(String lastName) {
        String lastNameRegex = "^[A-Z][a-zA-Z]{2,}$";
        Pattern pattern = Pattern.compile(lastNameRegex);
        Matcher matcher = pattern.matcher(lastName);
        return matcher.matches();
    }

    public static boolean validEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9]+([._+-][a-zA-Z0-9]+)*@[a-zA-Z0-9]+\\.[a-zA-Z]{2,4}(\\.[a-zA-Z]{2})*$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static boolean validMobileNumber(String mobileNumber) {
        String mobileNumberRegex = "^[0-9]{2}\\s[0-9]{10}$";
        Pattern pattern = Pattern.compile(mobileNumberRegex);
        Matcher matcher = pattern.matcher(mobileNumber);
        return matcher.matches();
    }

    public static boolean validPassword(String password) {
        String passwordRegex = "^(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=])(?!.*\\s).{8,}$";
        Pattern pattern = Pattern.compile(passwordRegex);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter first name: ");
        String firstName = scanner.nextLine();
        System.out.println("First Name: " + validFirstName(firstName));

        System.out.print("Enter last name: ");
        String lastName = scanner.nextLine();
        System.out.println("Last Name: " + validLastName(lastName));

        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        System.out.println("Email: " + validEmail(email));

        System.out.print("Enter mobile number: ");
        String mobileNumber = scanner.nextLine();
        System.out.println("Mobile Number: " + validMobileNumber(mobileNumber));

        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        System.out.println("Password: " + validPassword(password));

        scanner.close();
    }
}

