package org.bridgelabz.junit;

import java.sql.*;

public class PayrollService {
    // Database connection parameters
    private static final String URL = "jdbc:mysql://localhost:3306";
    private static final String DATABASE = "payroll_service";
    private static final String USER = "root";
    private static final String PASSWORD = "Lucario@1995";

    // Create the payroll_service database
    public static void createDatabase() {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement statement = connection.createStatement()) {

            String createDatabaseQuery = "CREATE DATABASE " + DATABASE;
            statement.executeUpdate(createDatabaseQuery);

            System.out.println("payroll_service database created.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Use the payroll_service database
    public static void useDatabase() {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement statement = connection.createStatement()) {

            String useDatabaseQuery = "USE " + DATABASE;
            statement.executeUpdate(useDatabaseQuery);

            System.out.println("Using payroll_service database.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Create the employee_payroll table
    public static void createEmployeePayrollTable() {
        try (Connection connection = DriverManager.getConnection(URL + "/" + DATABASE, USER, PASSWORD);
             Statement statement = connection.createStatement()) {

            String createTableQuery = "CREATE TABLE employee_payroll (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY," +
                    "name VARCHAR(100) NOT NULL," +
                    "salary DOUBLE NOT NULL," +
                    "start_date DATE NOT NULL," +
                    "gender CHAR(1)" +
                    "phone VARCHAR(20)," +
                    "address VARCHAR(200) DEFAULT 'N/A'," +
                    "department VARCHAR(50) NOT NULL," +
                    "basic_pay DOUBLE," +
                    "deductions DOUBLE," +
                    "taxable_pay DOUBLE," +
                    "income_tax DOUBLE," +
                    "net_pay DOUBLE" +
                    ")";
            statement.executeUpdate(createTableQuery);

            System.out.println("employee_payroll table created.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Insert employee payroll data
    public static void insertEmployeePayrollData() {
        try (Connection connection = DriverManager.getConnection(URL + "/" + DATABASE, USER, PASSWORD);
             Statement statement = connection.createStatement()) {

            String insertQuery = "INSERT INTO employee_payroll (name, salary, start_date, gender, department) VALUES" +
                    "('John', 5000, '2022-01-01', 'M', 'IT')," +
                    "('Jane', 6000, '2022-02-01', 'F', 'Finance')," +
                    "('Bill', 7000, '2022-03-01', 'M', 'Sales')," +
                    "('Charlie', 8000, '2022-04-01', 'M', 'Marketing')";
            statement.executeUpdate(insertQuery);

            System.out.println("Employee payroll data inserted.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Retrieve all employee payroll data
    public static void retrieveAllEmployeePayrollData() {
        try (Connection connection = DriverManager.getConnection(URL + "/" + DATABASE, USER, PASSWORD);
             Statement statement = connection.createStatement()) {

            String selectQuery = "SELECT * FROM employee_payroll";
            ResultSet resultSet = statement.executeQuery(selectQuery);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double salary = resultSet.getDouble("salary");
                Date startDate = resultSet.getDate("start_date");
                String gender = resultSet.getString("gender");
                String department = resultSet.getString("department");

                System.out.println("ID: " + id);
                System.out.println("Name: " + name);
                System.out.println("Salary: " + salary);
                System.out.println("Start Date: " + startDate);
                System.out.println("Gender: " + gender);
                System.out.println("Department: " + department);
                System.out.println("--------------------");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Retrieve salary data for a particular employee or within a date range
    public static void retrieveSalaryData(String employeeName, Date startDate, Date endDate) {
        try (Connection connection = DriverManager.getConnection(URL + "/" + DATABASE, USER, PASSWORD);
             Statement statement = connection.createStatement()) {

            String selectQuery;

            if (employeeName != null) {
                selectQuery = "SELECT salary FROM employee_payroll WHERE name = '" + employeeName + "'";
            } else if (startDate != null && endDate != null) {
                selectQuery = "SELECT salary FROM employee_payroll WHERE start_date BETWEEN '" + startDate + "' AND '" + endDate + "'";
            } else {
                System.out.println("Invalid arguments provided.");
                return;
            }

            ResultSet resultSet = statement.executeQuery(selectQuery);

            while (resultSet.next()) {
                double salary = resultSet.getDouble("salary");
                System.out.println("Salary: " + salary);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Add gender to employee_payroll table and update rows
    public static void addGenderToEmployeePayrollTable() {
        try (Connection connection = DriverManager.getConnection(URL + "/" + DATABASE, USER, PASSWORD);
             Statement statement = connection.createStatement()) {

            String alterTableQuery = "ALTER TABLE employee_payroll ADD COLUMN gender CHAR(1) AFTER name";
            statement.executeUpdate(alterTableQuery);

            String updateQuery = "UPDATE employee_payroll SET gender = 'M' WHERE name = 'Bill' OR name = 'Charlie'";
            statement.executeUpdate(updateQuery);

            System.out.println("Gender added to employee_payroll table and rows updated.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Perform analysis on male and female employees
    public static void performGenderAnalysis() {
        try (Connection connection = DriverManager.getConnection(URL + "/" + DATABASE, USER, PASSWORD);
             Statement statement = connection.createStatement()) {

            String sumQuery = "SELECT SUM(salary) FROM employee_payroll WHERE gender = 'M' GROUP BY gender";
            ResultSet sumResultSet = statement.executeQuery(sumQuery);

            if (sumResultSet.next()) {
                double maleSalarySum = sumResultSet.getDouble(1);
                System.out.println("Male Salary Sum: " + maleSalarySum);
            }

            String avgQuery = "SELECT AVG(salary) FROM employee_payroll WHERE gender = 'F' GROUP BY gender";
            ResultSet avgResultSet = statement.executeQuery(avgQuery);

            if (avgResultSet.next()) {
                double femaleSalaryAvg = avgResultSet.getDouble(1);
                System.out.println("Female Salary Average: " + femaleSalaryAvg);
            }

            String minQuery = "SELECT MIN(salary) FROM employee_payroll WHERE gender = 'M' GROUP BY gender";
            ResultSet minResultSet = statement.executeQuery(minQuery);

            if (minResultSet.next()) {
                double maleSalaryMin = minResultSet.getDouble(1);
                System.out.println("Male Salary Minimum: " + maleSalaryMin);
            }

            String maxQuery = "SELECT MAX(salary) FROM employee_payroll WHERE gender = 'F' GROUP BY gender";
            ResultSet maxResultSet = statement.executeQuery(maxQuery);

            if (maxResultSet.next()) {
                double femaleSalaryMax = maxResultSet.getDouble(1);
                System.out.println("Female Salary Maximum: " + femaleSalaryMax);
            }

            String countQuery = "SELECT COUNT(*) FROM employee_payroll GROUP BY gender";
            ResultSet countResultSet = statement.executeQuery(countQuery);

            while (countResultSet.next()) {
                int count = countResultSet.getInt(1);
                System.out.println("Employee Count: " + count);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Create the department table
    public static void createDepartmentTable() {
        try (Connection connection = DriverManager.getConnection(URL + "/" + DATABASE, USER, PASSWORD);
             Statement statement = connection.createStatement()) {

            String createTableQuery = "CREATE TABLE department (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY," +
                    "name VARCHAR(50) NOT NULL" +
                    ")";
            statement.executeUpdate(createTableQuery);

            System.out.println("department table created.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Create the employee_department table for many-to-many relationship
    public static void createEmployeeDepartmentTable() {
        try (Connection connection = DriverManager.getConnection(URL + "/" + DATABASE, USER, PASSWORD);
             Statement statement = connection.createStatement()) {

            String createTableQuery = "CREATE TABLE employee_department (" +
                    "employee_id INT," +
                    "department_id INT," +
                    "FOREIGN KEY (employee_id) REFERENCES employee_payroll(id)," +
                    "FOREIGN KEY (department_id) REFERENCES department(id)" +
                    ")";
            statement.executeUpdate(createTableQuery);

            System.out.println("employee_department table created.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Retrieve employee and department data using the employee_department table
    public static void retrieveEmployeeDepartmentData() {
        try (Connection connection = DriverManager.getConnection(URL + "/" + DATABASE, USER, PASSWORD);
             Statement statement = connection.createStatement()) {

            String selectQuery = "SELECT employee_payroll.name, department.name " +
                    "FROM employee_department " +
                    "JOIN employee_payroll ON employee_department.employee_id = employee_payroll.id " +
                    "JOIN department ON employee_department.department_id = department.id";
            ResultSet resultSet = statement.executeQuery(selectQuery);

            while (resultSet.next()) {
                String employeeName = resultSet.getString(1);
                String departmentName = resultSet.getString(2);

                System.out.println("Employee: " + employeeName);
                System.out.println("Department: " + departmentName);
                System.out.println("--------------------");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        createDatabase();
        useDatabase();
        createEmployeePayrollTable();
        insertEmployeePayrollData();
        retrieveAllEmployeePayrollData();
        retrieveSalaryData("Bill", null, null);
        addGenderToEmployeePayrollTable();
        performGenderAnalysis();
        createDepartmentTable();
        createEmployeeDepartmentTable();
        retrieveEmployeeDepartmentData();
    }
}

