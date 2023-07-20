package org.bridgelabz.junit;

import java.sql.*;

public class AddressBookService {

    // JDBC URL, username, and password of the MySQL database
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/";
    private static final String DATABASE_NAME = "AddressBookDB";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Lucario@1995";

    // Database table and columns
    private static final String TABLE_NAME = "AddressBook";
    private static final String[] COLUMNS = {
            "id", "first_name", "last_name", "address", "city", "state", "zip", "phone_number", "email"
    };

    public static void main(String[] args) {
        // Create the database
        createDatabase();

        // Use the database
        useDatabase();

        // Create the Address Book table if it doesn't exist
        createAddressBookTable();

        // Insert new contacts
        insertNewContact("John", "Doe", "123 Main St", "New York", "NY", "10001", "123-456-7890", "john@example.com");
        insertNewContact("Jane", "Smith", "456 Elm St", "Los Angeles", "CA", "90001", "987-654-3210", "jane@example.com");

        // Edit an existing contact
        editContact("Jane", "Smith", "456 Elm St", "Los Angeles", "CA", "90001", "999-888-7777", "jane_updated@example.com");

        // Delete a contact
        deleteContact("John", "Doe");

        // Retrieve persons by city or state
        retrievePersonsByCity("New York");
        retrievePersonsByState("CA");

        // Get Address Book size by city and state
        getAddressBookSizeByCityAndState();

        // Retrieve entries sorted alphabetically
        retrieveEntriesSortedByPersonName("Los Angeles");

        // Identify Address Book with name and type
        alterAddressBookTable();

        // Get number of contact persons by type
        getContactPersonCountByType("Family");

        // Add person to both Friend and Family
        addPersonToBothFriendAndFamily("John", "Doe", "4567 Oak St", "Chicago", "IL", "60601", "777-777-7777", "john@example.com");

        // Close the connection
        closeConnection();
    }

    private static void createDatabase() {
        try (Connection conn = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
             Statement stmt = conn.createStatement()) {

            String createDatabaseQuery = "CREATE DATABASE IF NOT EXISTS " + DATABASE_NAME;

            stmt.executeUpdate(createDatabaseQuery);
            System.out.println("Database created successfully: " + DATABASE_NAME);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void useDatabase() {
        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Establish the connection to the database
            Connection conn = DriverManager.getConnection(JDBC_URL + DATABASE_NAME, USERNAME, PASSWORD);
            System.out.println("Connected to the database: " + DATABASE_NAME);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void closeConnection() {
        try (Connection conn = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
             Statement stmt = conn.createStatement()) {
            if (conn != null) {
                conn.close();
                System.out.println("Connection to the database closed.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void createAddressBookTable() {
        try (Connection conn = DriverManager.getConnection(JDBC_URL + DATABASE_NAME, USERNAME, PASSWORD);
             Statement stmt = conn.createStatement()) {

            String createTableQuery = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " ("
                    + "id INT AUTO_INCREMENT PRIMARY KEY,"
                    + "first_name VARCHAR(50),"
                    + "last_name VARCHAR(50),"
                    + "address VARCHAR(100),"
                    + "city VARCHAR(50),"
                    + "state VARCHAR(50),"
                    + "zip VARCHAR(10),"
                    + "phone_number VARCHAR(15),"
                    + "email VARCHAR(100)"
                    + ");";

            stmt.executeUpdate(createTableQuery);
            System.out.println("Address Book table created successfully.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void insertNewContact(String firstName, String lastName, String address, String city, String state,
                                         String zip, String phoneNumber, String email) {
        try (Connection conn = DriverManager.getConnection(JDBC_URL + DATABASE_NAME, USERNAME, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(
                     "INSERT INTO " + TABLE_NAME + " (first_name, last_name, address, city, state, zip, phone_number, email) VALUES (?, ?, ?, ?, ?, ?, ?, ?)")) {

            pstmt.setString(1, firstName);
            pstmt.setString(2, lastName);
            pstmt.setString(3, address);
            pstmt.setString(4, city);
            pstmt.setString(5, state);
            pstmt.setString(6, zip);
            pstmt.setString(7, phoneNumber);
            pstmt.setString(8, email);

            pstmt.executeUpdate();
            System.out.println("Contact inserted successfully: " + firstName + " " + lastName);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void editContact(String firstName, String lastName, String address, String city, String state,
                                    String zip, String phoneNumber, String email) {
        try (Connection conn = DriverManager.getConnection(JDBC_URL + DATABASE_NAME, USERNAME, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(
                     "UPDATE " + TABLE_NAME + " SET address = ?, city = ?, state = ?, zip = ?, phone_number = ?, email = ? " +
                             "WHERE first_name = ? AND last_name = ?")) {

            pstmt.setString(1, address);
            pstmt.setString(2, city);
            pstmt.setString(3, state);
            pstmt.setString(4, zip);
            pstmt.setString(5, phoneNumber);
            pstmt.setString(6, email);
            pstmt.setString(7, firstName);
            pstmt.setString(8, lastName);

            pstmt.executeUpdate();
            System.out.println("Contact updated successfully: " + firstName + " " + lastName);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void deleteContact(String firstName, String lastName) {
        try (Connection conn = DriverManager.getConnection(JDBC_URL + DATABASE_NAME, USERNAME, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement("DELETE FROM " + TABLE_NAME + " WHERE first_name = ? AND last_name = ?")) {

            pstmt.setString(1, firstName);
            pstmt.setString(2, lastName);

            pstmt.executeUpdate();
            System.out.println("Contact deleted successfully: " + firstName + " " + lastName);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void retrievePersonsByCity(String city) {
        try (Connection conn = DriverManager.getConnection(JDBC_URL + DATABASE_NAME, USERNAME, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM " + TABLE_NAME + " WHERE city = ?")) {

            pstmt.setString(1, city);
            ResultSet resultSet = pstmt.executeQuery();

            System.out.println("Persons in " + city + ":");
            while (resultSet.next()) {
                System.out.println(resultSet.getString("first_name") + " " + resultSet.getString("last_name"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void retrievePersonsByState(String state) {
        try (Connection conn = DriverManager.getConnection(JDBC_URL + DATABASE_NAME, USERNAME, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM " + TABLE_NAME + " WHERE state = ?")) {

            pstmt.setString(1, state);
            ResultSet resultSet = pstmt.executeQuery();

            System.out.println("Persons in " + state + ":");
            while (resultSet.next()) {
                System.out.println(resultSet.getString("first_name") + " " + resultSet.getString("last_name"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void getAddressBookSizeByCityAndState() {
        try (Connection conn = DriverManager.getConnection(JDBC_URL + DATABASE_NAME, USERNAME, PASSWORD);
             Statement stmt = conn.createStatement()) {

            ResultSet resultSet = stmt.executeQuery("SELECT city, state, COUNT(*) AS size FROM " + TABLE_NAME + " GROUP BY city, state");

            System.out.println("Address Book size by City and State:");
            while (resultSet.next()) {
                String city = resultSet.getString("city");
                String state = resultSet.getString("state");
                int size = resultSet.getInt("size");
                System.out.println(city + ", " + state + ": " + size);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void retrieveEntriesSortedByPersonName(String city) {
        try (Connection conn = DriverManager.getConnection(JDBC_URL + DATABASE_NAME, USERNAME, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM " + TABLE_NAME + " WHERE city = ? ORDER BY first_name, last_name")) {

            pstmt.setString(1, city);
            ResultSet resultSet = pstmt.executeQuery();

            System.out.println("Persons in " + city + " (sorted alphabetically by name):");
            while (resultSet.next()) {
                System.out.println(resultSet.getString("first_name") + " " + resultSet.getString("last_name"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void alterAddressBookTable() {
        try (Connection conn = DriverManager.getConnection(JDBC_URL + DATABASE_NAME, USERNAME, PASSWORD);
             Statement stmt = conn.createStatement()) {

            String alterTableQuery = "ALTER TABLE " + TABLE_NAME + " ADD COLUMN name VARCHAR(100), ADD COLUMN type VARCHAR(50)";

            stmt.executeUpdate(alterTableQuery);
            System.out.println("Address Book table altered successfully.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void getContactPersonCountByType(String type) {
        try (Connection conn = DriverManager.getConnection(JDBC_URL + DATABASE_NAME, USERNAME, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement("SELECT COUNT(*) AS count FROM " + TABLE_NAME + " WHERE type = ?")) {

            pstmt.setString(1, type);
            ResultSet resultSet = pstmt.executeQuery();

            if (resultSet.next()) {
                int count = resultSet.getInt("count");
                System.out.println("Number of contact persons with type '" + type + "': " + count);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void addPersonToBothFriendAndFamily(String firstName, String lastName, String address, String city,
                                                       String state, String zip, String phoneNumber, String email) {
        try (Connection conn = DriverManager.getConnection(JDBC_URL + DATABASE_NAME, USERNAME, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(
                     "INSERT INTO " + TABLE_NAME + " (first_name, last_name, address, city, state, zip, phone_number, email, type) " +
                             "VALUES (?, ?, ?, ?, ?, ?, ?, ?, 'Friend'), (?, ?, ?, ?, ?, ?, ?, ?, 'Family')")) {

            pstmt.setString(1, firstName);
            pstmt.setString(2, lastName);
            pstmt.setString(3, address);
            pstmt.setString(4, city);
            pstmt.setString(5, state);
            pstmt.setString(6, zip);
            pstmt.setString(7, phoneNumber);
            pstmt.setString(8, email);

            // Repeat the parameters for the second insert
            pstmt.setString(9, firstName);
            pstmt.setString(10, lastName);
            pstmt.setString(11, address);
            pstmt.setString(12, city);
            pstmt.setString(13, state);
            pstmt.setString(14, zip);
            pstmt.setString(15, phoneNumber);
            pstmt.setString(16, email);

            pstmt.executeUpdate();
            System.out.println("Contact inserted as both Friend and Family: " + firstName + " " + lastName);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}