package com.coursemanagement;

import java.sql.*;

//import java.sql.*;

public class LoginUser {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/CourseManagement";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";


    public static boolean authenticateAdmin(String username, String password) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
            if (connection != null) {
                System.out.println("Database connection is successful!");

                // Use a prepared statement for admin authentication
                String selectQuery = "SELECT * FROM Admin WHERE Name = ? AND Password = ?";
                try (PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {
                    preparedStatement.setString(1, username);
                    preparedStatement.setString(2, password);

                    ResultSet resultSet = preparedStatement.executeQuery();

                    
                    return resultSet.next(); 
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Database connection failed!");
        }
        return false; 
    }
    
    public static boolean authenticateStudent(String username, String password) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
            if (connection != null) {
                System.out.println("Database connection is successful!");

                // Use a prepared statement for admin authentication
                String selectQuery = "SELECT * FROM Student WHERE Name = ? AND Password = ?";
                try (PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {
                    preparedStatement.setString(1, username);
                    preparedStatement.setString(2, password);

                    ResultSet resultSet = preparedStatement.executeQuery();

                    
                    return resultSet.next(); 
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Database connection failed!");
        }
        return false; 
    }
    
    public static boolean authenticateTeacher(String username, String password) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
            if (connection != null) {
                System.out.println("Database connection is successful!");

                // Use a prepared statement for admin authentication
                String selectQuery = "SELECT * FROM Teacher WHERE Name = ? AND Password = ?";
                try (PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {
                    preparedStatement.setString(1, username);
                    preparedStatement.setString(2, password);

                    ResultSet resultSet = preparedStatement.executeQuery();

                    
                    return resultSet.next(); 
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Database connection failed!");
        }
        return false; 
    }
}

