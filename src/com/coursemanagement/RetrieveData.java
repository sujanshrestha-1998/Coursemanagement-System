package com.coursemanagement;

import javax.swing.*;
import java.sql.*;

public class RetrieveData {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/CourseManagement";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    String retrievedData;
    String retrievedData1;

  
    
    public static String retrieveEmail(String userId) {
        String email = null;

        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
            // SQL query to retrieve email based on user ID
        	SharedData shared = new SharedData();
        	String role = shared.getUserRole();
            String sql = "SELECT Email FROM "+role+" WHERE Name = ?";
            
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, userId);
                

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        // Assuming that the 'email' column is present in the 'users' table
                        email = resultSet.getString("Email");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception appropriately in a real-world scenario
        }

        return email;
    }
    
    public static String retrievePassword(String userId) {
        String password = null;

        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
            // SQL query to retrieve email based on user ID
        	SharedData shared = new SharedData();
        	String role = shared.getUserRole();
            String sql = "SELECT Password FROM "+role+" WHERE Name = ?";
            
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, userId);
                

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        // Assuming that the 'email' column is present in the 'users' table
                        password = resultSet.getString("Password");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception appropriately in a real-world scenario
        }

        return password;
    }
    
    public static void changePassword(String chpassword) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
            SharedData shared = new SharedData();
            String role = shared.getUserRole();
            String name = shared.getName();

            String sql = "UPDATE " + role + " SET Password = ? WHERE Name = ?";

            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, chpassword);
                preparedStatement.setString(2, name);

                int affectedRows = preparedStatement.executeUpdate();

                if (affectedRows > 0) {
                    System.out.println("Password updated successfully.");
                } else {
                    System.out.println("No rows were updated. User not found.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception appropriately in a real-world scenario
        }
    }

    
}
