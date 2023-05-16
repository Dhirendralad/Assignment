package day7_assignment;

import java.util.Scanner;

public class LeapYear {
    public static void main(String[] args) {
        // Get the year from the user
        System.out.println("Enter a year: ");
        try (Scanner scanner = new Scanner(System.in)) {
            int year = scanner.nextInt();

            // Check if the year is >= 1582
            if (year < 1582) {
                System.out.println("The year is not in the Gregorian calendar.");
                return;
            }

            // Check if the year is divisible by 4
            if (year % 4 == 0) {

                // Check if the year is divisible by 100
                if (year % 100 == 0) {

                    // Check if the year is divisible by 400
                    if (year % 400 == 0) {
                        System.out.println("The year is a leap year.");
                    } else {
                        System.out.println("The year is not a leap year.");
                    }
                } else {
                    System.out.println("The year is a leap year.");
                }
            } else {
                System.out.println("The year is not a leap year.");
            }
        }
    }
}
