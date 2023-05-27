public class Employee {
    private String name;
    private double salary;
    private String ID;

    // Constructor
    public Employee(String name, double salary, String ID) {
        this.name = name;
        this.salary = salary;
        this.ID = ID;
    }

    // Method to calculate yearly salary
    public double calculateYearlySalary() {
        return salary * 12;
    }

    // Method to print name and salary
    public void printNameAndSalary() {
        System.out.println("Name: " + name);
        System.out.println("Salary: $" + salary);
        System.out.println("Employee ID " + ID);
    }

    // Main method to test the Employee class
    public static void main(String[] args) {
        // Create an Employee object
        Employee employee = new Employee("John Doe", 5000.0, "E12345");

        // Call the method to print name and salary
        employee.printNameAndSalary();

        // Calculate and print yearly salary
        double yearlySalary = employee.calculateYearlySalary();
        System.out.println("Yearly Salary: $" + yearlySalary);
    }
}
