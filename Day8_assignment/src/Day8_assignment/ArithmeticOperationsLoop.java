package Day8_assignment;

import java.util.Scanner;

public class ArithmeticOperationsLoop {

    public static void main(String[] args) {

        // Create a Scanner object to read input from the user
        try (Scanner scanner = new Scanner(System.in)) {
            // Prompt the user to enter the number of numbers
            System.out.println("Enter the number of numbers: ");
            int numberOfNumbers = scanner.nextInt();

            // Create an array to store the numbers
            int[] numbers = new int[numberOfNumbers];

            // Get input from the user for each number
            for (int i = 0; i < numberOfNumbers; i++) {
                System.out.println("Enter number " + (i + 1) + ": ");
                numbers[i] = scanner.nextInt();
            }

            // Calculate the maximum and minimum of the numbers
            int max = numbers[0];
            int min = numbers[0];
            for (int i = 1; i < numberOfNumbers; i++) {
                if (numbers[i] > max) {
                    max = numbers[i];
                }
                if (numbers[i] < min) {
                    min = numbers[i];
                }
            }

            // Do the following arithmetic operations
            int aPlusBTimesC = numbers[0] + numbers[1] * numbers[2];
            float cPlusAOverB = numbers[2] + numbers[0] / numbers[1];
            int aModuloBPlusC = numbers[0] % numbers[1] + numbers[2];
            int aTimesBPlusC = numbers[0] * numbers[1] + numbers[2];

            // Print the results
            System.out.println("The maximum of the numbers is " + max);
            System.out.println("The minimum of the numbers is " + min);
            System.out.println("a+b*c = " + aPlusBTimesC);
            System.out.println("c+a/b = " + cPlusAOverB);
            System.out.println("a%b+c = " + aModuloBPlusC);
            System.out.println("a*b+c = " + aTimesBPlusC);
        }
    }
}


