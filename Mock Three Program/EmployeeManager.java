package com.JAVAIO.mock;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


/* Write a Java program to create a class called "EmployeeManager" with instance variables "employees" (a list of Employee objects) and "numEmployees"
(the number of employees in the list). Include the following methods:
    A method to add an employee to the list
    A method to remove an employee from the list
    A method to search for an employee by their ID
    A method to sort the employees in the list by their salary (ascending or descending order)
    A method to calculate the average salary of all employees
    A method to print the details of all employees in the list */
public class EmployeeManager {

    private List<Employee> employees;
    private int numEmployees;

    // JDBC property declaration
    private static final String URL = "jdbc:mysql://localhost:3306/employee";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Lucario@1995";

    public EmployeeManager() throws SQLException {
        employees = new ArrayList<>();
        numEmployees = 0;
        fetchEmployeesFromDatabase();
    }

    // Employee class
    private class Employee {

        int id;
        String name;
        double salary;

        Employee (int id, String name, double salary) {
            this.id = id;
            this.name = name;
            this.salary = salary;
        }

        @Override
        public String toString() {
            return "ID: " + id + ", Name: " + name + ", Salary: " + salary;
            }
        }

    // fetch employees method
    private void fetchEmployeesFromDatabase() {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement statement = connection.createStatement()) {

            String query = "SELECT Emp_id, Name, Salary FROM empinfo";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int id = resultSet.getInt("Emp_id");
                String name = resultSet.getString("Name");
                double salary = resultSet.getDouble("Salary");
                employees.add(new Employee(id, name, salary));
            }

            numEmployees = employees.size();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addEmployee(int id, String name, double salary) {
        Employee newEmployee = new Employee(id, name, salary);
        employees.add(newEmployee);
        numEmployees++;

        // Update the database with the new employee
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(
                     "INSERT INTO empinfo (Emp_id, Name, Salary) VALUES (?, ?, ?)")) {

            statement.setInt(1, id);
            statement.setString(2, name);
            statement.setDouble(3, salary);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeEmployee(int id) {
        employees.removeIf(employee -> employee.id == id);
        numEmployees--;

        // Remove the employee from the database
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(
                     "DELETE FROM empinfo WHERE Emp_id = ?")) {

            statement.setInt(1, id);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Employee searchEmployeeById(int id) {
        for (Employee employee : employees) {
            if (employee.id == id) {
                return employee;
            }
        }
        return null; // Employee not found
    }

    public void sortEmployeesBySalary(boolean ascending) {
        employees.sort((e1, e2) -> ascending ? Double.compare(e1.salary, e2.salary) : Double.compare(e2.salary, e1.salary));
    }

    public double calculateAverageSalary() {
        double totalSalary = employees.stream().mapToDouble(employee -> employee.salary).sum();
        return totalSalary / numEmployees;
    }

    public void printAllEmployees() {

        employees.forEach(System.out::println);
    }

    public static void main(String[] args) throws SQLException {
        EmployeeManager employeeManager = new EmployeeManager();

        employeeManager.addEmployee(444, "John Doe", 40000.0);

        employeeManager.removeEmployee(222);

        Employee employee = employeeManager.searchEmployeeById(111);
        if (employee != null) {
            System.out.println("Employee found: " + employee.toString());
        } else {
            System.out.println("Employee not found");
        }

        employeeManager.sortEmployeesBySalary(true);
        employeeManager.printAllEmployees();

        double averageSalary = employeeManager.calculateAverageSalary();
        System.out.println("Average Salary: " + averageSalary);
    }
}