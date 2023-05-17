package Day8_assignment;

import java.util.Scanner;

public class SpringSeason {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
				// Create a Scanner object to read input from the user
		try (Scanner scanner = new Scanner(System.in)) {
			// Prompt the user to enter the month and day
			System.out.println("Enter the month and day: ");
			int month = scanner.nextInt();
			int day = scanner.nextInt();

			// Check if the day is between March 20 and June 20
			boolean isSpring = (month == 3 && day >= 20 && day <= 31) || (month == 4 && day >= 1 && day <= 30) || (month == 5 && day >= 1 && day <= 31) || (month == 6 && day >= 1 && day <= 20);

			// Print the result
			System.out.println(isSpring ? "true" : "false");
		}
	}

}
