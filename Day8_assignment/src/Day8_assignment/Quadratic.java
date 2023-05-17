package Day8_assignment;

import java.util.Scanner;

public class Quadratic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Create a Scanner object to read input from the user
        try(Scanner scanner = new Scanner(System.in)){;

        // Prompt the user to enter the values of a, b, and c
        System.out.println("Enter the values of a, b, and c: ");
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();

        // Calculate the discriminant
        double discriminant = (b * b) - (4 * a * c);

        // Check if the discriminant is negative
        if (discriminant < 0) {
            System.out.println("The equation has no real roots");
        } else {
            // Find the roots of the equation
            double root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            double root2 = (-b - Math.sqrt(discriminant)) / (2 * a);

        // Print the roots
        System.out.println("The roots of the equation are " + root1 + " and " + root2);
       }
        }  
	}
}

