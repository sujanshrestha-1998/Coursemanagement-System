package com.coursemanagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ManageTutors {
	 private static final String JDBC_URL = "jdbc:mysql://localhost:3306/CourseManagement";
	    private static final String USERNAME = "root";
	    private static final String PASSWORD = "";


	    public static boolean addTutor( String name, String email, String password, String contact, String course) {
	        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
	            if (connection != null) {
	                System.out.println("Database connection is successful!");

	                // Use a prepared statement for adding a new tutor
	                String insertQuery = "INSERT INTO Teacher (Name, Email, `Password`, ContactNo, Course) VALUES (?, ?, ?, ?, ?)";
	                try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
	                    preparedStatement.setString(1, name);
	                    preparedStatement.setString(2, email);
	                    preparedStatement.setString(3, password);
	                    preparedStatement.setString(4, contact);
	                    preparedStatement.setString(5, course);

	                    int rowsAffected = preparedStatement.executeUpdate();

	                    return rowsAffected > 0;
	                }
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	            System.out.println("Database connection failed!");
	        }
	        return false;
	    }
	    
	    public static boolean deleteTutor(String username, String password) {
	        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
	            if (connection != null) {
	                System.out.println("Database connection is successful!");

	                // Use a prepared statement for deleting a tutor
	                String deleteQuery = "DELETE FROM Teacher WHERE Name = ? AND Password = ?";
	                try (PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {
	                    preparedStatement.setString(1, username);
	                    preparedStatement.setString(2, password);

	                    int rowsAffected = preparedStatement.executeUpdate();

	                    return rowsAffected > 0;
	                }
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	            System.out.println("Database operation failed: " + e.getMessage());
	        }
	        return false;
	    }
	    
	    public static boolean assignTutor(String username, String modulename) {
	        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
	            if (connection != null) {
	                System.out.println("Database connection is successful!");

	                String deleteQuery = "Update Teacher SET Module = ? WHERE Name = ?";
	                try (PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {
	                    preparedStatement.setString(1, modulename);
	                    preparedStatement.setString(2, username);

	                    int rowsAffected = preparedStatement.executeUpdate();

	                    return rowsAffected > 0;
	                }
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	            System.out.println("Database operation failed: " + e.getMessage());
	        }
	        return false;
	    }
	    
	    public static List<Teacher> getTeachersByCourse(String course) {
	        List<Teacher> teachers = new ArrayList<>();
	        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
	            if (connection != null) {
	                String query = "SELECT * FROM Teacher WHERE Course = ?";
	                try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
	                    preparedStatement.setString(1, course);
	                    try (ResultSet resultSet = preparedStatement.executeQuery()) {
	                        while (resultSet.next()) {
	                            String name = resultSet.getString("Name");
	                            String email = resultSet.getString("Email");
	                            String password = resultSet.getString("Password");
	                            String contact = resultSet.getString("ContactNo");
	                            String module = resultSet.getString("Module");
	                            Teacher teacher = new Teacher(name, email, password, contact, course, module);
	                            teachers.add(teacher);
	                        }
	                    }
	                }
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	            System.out.println("Database operation failed: " + e.getMessage());
	        }
	        return teachers;
	    }

	    


}
