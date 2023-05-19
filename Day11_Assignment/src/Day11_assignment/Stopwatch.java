package Day11_assignment;

import java.util.Scanner;

public class Stopwatch {	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Create a Scanner object to read user input
		try (Scanner sc = new Scanner(System.in)) {
			// Get the start time
			System.out.println("Press Enter to start the stopwatch"
					);
			sc.nextLine();
			long startTime = System.currentTimeMillis();

			// Get the end time
			System.out.println("Press Enter to stop the stopwatch");
			sc.nextLine();
			long endTime = System.currentTimeMillis();

			// Calculate the elapsed time
			long elapsedTime = (endTime - startTime) / 1000;

			// Print the elapsed time
			System.out.println("The elapsed time is " + elapsedTime + " seconds");
		}
	}

}
