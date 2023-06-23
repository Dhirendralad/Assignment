public class EmployeeWageComputations {
    public static void main(String[] args) {
        System.out.println("Welcome to Employee Wage Computation Program on Master Branch");

        // Compute wages for multiple companies
        int wageCompanyA = computeEmployeeWage("Company A", 20, 8, 20, 100);
        int wageCompanyB = computeEmployeeWage("Company B", 25, 7, 22, 120);

        // Displaying the results
        System.out.println("Total Wage for Company A: $" + wageCompanyA);
        System.out.println("Total Wage for Company B: $" + wageCompanyB);
    }

    public static int computeEmployeeWage(String companyName, int wagePerHour, int fullDayHours, int workingDaysPerMonth, int maxWorkingHours) {
        int totalHoursWorked = 0;
        int totalWage = 0;
        String employeeType = "full-time"; // "full-time" or "part-time"

        // Calculate wages until the condition is reached
        int day = 1;
        while (day <= workingDaysPerMonth && totalHoursWorked < maxWorkingHours) {
            int hoursWorked = 0;

            // Switch case to determine employee type
            switch (employeeType) {
                case "full-time":
                    hoursWorked = fullDayHours;
                    break;
                case "part-time":
                    hoursWorked = fullDayHours / 2;
                    break;
                default:
                    System.out.println("Invalid employee type");
                    return 0;
            }

            totalHoursWorked += hoursWorked;
            day++;
        }

        // Calculate total wage
        totalWage = wagePerHour * totalHoursWorked;

        System.out.println("Company: " + companyName);
        System.out.println("Wage per Hour: $" + wagePerHour);
        System.out.println("Working Days per Month: " + workingDaysPerMonth);
        System.out.println("Max Working Hours: " + maxWorkingHours);
        System.out.println("Total Hours Worked: " + totalHoursWorked);
        System.out.println("Total Wage: $" + totalWage);
        System.out.println();

        return totalWage;
    }
}

