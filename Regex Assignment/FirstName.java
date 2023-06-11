import java.util.Scanner;

public class FirstName {
    
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {

            System.out.print("Enter your first name: ");
            String firstName = scanner.nextLine();

            System.out.println("Enter your last name: ");
            String lastName = scanner.nextLine();

            System.out.println("Enter your email address: ");
            String email = scanner.nextLine();

            System.out.println("Enter your Mobile Number: ");
            String mobileNumber = scanner.nextLine();

            System.out.print("Enter your password: ");
            String password = scanner.nextLine();

            if (isValidFirstName(firstName)) {
                System.out.println("Valid entry!");
            } else {
                System.out.println("Invalid entry!");
            }

            if (isValidLastName(lastName)) {
                System.out.println("Valid entry!");
            } else {
                System.out.println("Invalid entry!");
            }

            if (isValidEmail(email)) {
                System.out.println("Valid email address!");
            } else {
                System.out.println("Invalid email address!");
            }

            if (isValidMobileNumber(mobileNumber)) {
                System.out.println("Valid mobile number!");
            } else {
                System.out.println("Invalid mobile number!");
            }
            
            if (isValidPassword(password)) {
                System.out.println("Valid password!");
            } else {
                System.out.println("Invalid password!");
            }
        }
    }

    public static boolean isValidFirstName(String firstName) {
        String nameRegex1 = "^[A-Z][a-zA-Z]{0,19}$";
        return firstName.matches(nameRegex1);
    }

    public static boolean isValidLastName(String lastName) {
        String nameRegex2 = "^[A-Z][a-zA-Z]{0,19}$";
        return lastName.matches(nameRegex2);
    }

    public static boolean isValidEmail(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@[a-z0-9]+.[a-z]+.[a-z]+$";
        return email.matches(emailRegex);
    }

    public static boolean isValidMobileNumber(String mobileNumber) {
        String mobileNumberRegex = "^91\\s\\d{10}$";
        return mobileNumber.matches(mobileNumberRegex);
    }

    public static boolean isValidPassword(String password) {
        // Rule 1 - Minimum 8 characters
        if (password.length() < 8) {
            return false;
        }

        // Rule 2 - Should have at least 1 uppercase letter
        if (!password.matches(".*[A-Z].*")) {
            return false;
        }

        // Rule 3 - Should have at least 1 numeric number
        if (!password.matches(".*\\d.*")) {
            return false;
        }

        // Rule 4 - Has exactly 1 special character
        if (!password.matches(".*[^a-zA-Z0-9].*")) {
            return false;
        }

        return true;
    }

}
