import java.util.Random;

public class EmployeeWageComputation {
    private static final int WAGE_PER_HOUR = 20;
    private static final int FULL_DAY_HOURS = 8;
    private static final int PART_TIME_HOURS = 4;
    private static final int WORKING_DAYS_PER_MONTH = 20;
    private static final int MAX_WORKING_HOURS = 100;

    public static void main(String[] args) {
        System.out.println("Welcome to Employee Wage Computation Program on Master Branch");

        // Calculate total wage
        int totalWage = computeEmployeeWage();

        // Displaying the result
        System.out.println("Total Wage for the Month: $" + totalWage);
    }

    public static int computeEmployeeWage() {
        int totalHoursWorked = 0;
        int totalWage = 0;
        String employeeType = "full-time"; // "full-time" or "part-time"

        // Create an instance of Random class
        Random random = new Random();

        // Generate a random number (0 or 1)
        int attendance = random.nextInt(2);

        // Check the attendance
        if (attendance == 1) {
            System.out.println("Employee is Present");
        } else {
            System.out.println("Employee is Absent");
        }

        // Calculate wages until the condition is reached
        int day = 1;
        while (day <= WORKING_DAYS_PER_MONTH && totalHoursWorked < MAX_WORKING_HOURS) {
            int hoursWorked = 0;

            // Switch case to determine employee type
            switch (employeeType) {
                case "full-time":
                    hoursWorked = FULL_DAY_HOURS;
                    break;
                case "part-time":
                    hoursWorked = PART_TIME_HOURS;
                    break;
                default:
                    System.out.println("Invalid employee type");
                    return 0;
            }

            totalHoursWorked += hoursWorked;
            day++;
        }

        // Calculate total wage
        totalWage = WAGE_PER_HOUR * totalHoursWorked;
        return totalWage;
    }
}
