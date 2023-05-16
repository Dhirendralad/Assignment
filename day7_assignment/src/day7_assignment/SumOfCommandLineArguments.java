package day7_assignment;

public class SumOfCommandLineArguments {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
        // Get the number of command-line arguments
        int numArgs = args.length;

        // Declare variables
        int sum = 0;
        int invalidCount = 0;

        // Loop through the command-line arguments
        for (int i = 0; i < numArgs; i++) {
            // Try to parse the argument as an integer
            try {
                int value = Integer.parseInt(args[i]);
                sum += value;
            } catch (NumberFormatException e) {
                // If the argument cannot be parsed as an integer, increment the invalid count
                invalidCount++;
            }
        }

        // Print the sum of the valid integers
        System.out.println("The sum of the valid integers is: " + sum);

        // Print the number of invalid integers
        System.out.println("The number of invalid integers is: " + invalidCount);
	}

}
