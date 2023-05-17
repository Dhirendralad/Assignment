package Day8_assignment;

import java.util.Scanner;

public class ArithmeticOperations {

    public static void main(String[] args) {

        // Create a Scanner object to read input from the user
        try(Scanner scanner = new Scanner(System.in)){

        // Prompt the user to enter three numbers
        System.out.println("Enter three numbers: ");
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        // Calculate the maximum and minimum of the three numbers
        int max = Math.max(a, Math.max(b, c));
        int min = Math.min(a, Math.min(b, c));

        // Do the following arithmetic operations
        int aPlusBTimesC = a + b * c;
        float cPlusAOverB = c + a / b;
        int aModuloBPlusC = a % b + c;
        int aTimesBPlusC = a * b + c;

        // Print the results
        System.out.println("The maximum of the two numbers is " + max);
        System.out.println("The minimum of the two numbers is " + min);
        System.out.println("a+b*c = " + aPlusBTimesC);
        System.out.println("c+a/b = " + cPlusAOverB);
        System.out.println("a%b+c = " + aModuloBPlusC);
        System.out.println("a*b+c = " + aTimesBPlusC);
        }
    }
}


