package com.coursemanagement;

import java.sql.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterStudent {
	
  private static final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";
  private static final Pattern pattern = Pattern.compile(PASSWORD_PATTERN);
    
	private static final String JDBC_URL = "jdbc:mysql://localhost:3306/CourseManagement";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "";

    public static boolean registerUser(String name, String password, String email, String course) {
        boolean success = false;
        
        // Check if any text fields are blank
        if (name.isBlank() || password.isBlank() || email.isBlank() || course.isBlank()) {
            System.out.println("Please fill out all fields.");
            return false;
        }
        
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
            if (connection != null) {
                System.out.println("Database connection is successful!");

                // Use a prepared statement for user registration
                String insertQuery = "INSERT INTO Student (Name, Email, Password, Course) VALUES (?, ?, ?, ?)";
                try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                    preparedStatement.setString(1, name);
                    preparedStatement.setString(2, email);
                    preparedStatement.setString(3, password);
                    preparedStatement.setString(4, course);
                    // Execute the insert query
                    int rowsAffected = preparedStatement.executeUpdate();

                    if (rowsAffected > 0) {
                        System.out.println("Registration successful!");
                        success = true;
                    } else {
                        System.out.println("Registration failed. Please check your inputs.");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Database connection failed!");
        }
        return success;
    }
    
    public static boolean validate(final String password) {
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }
}
