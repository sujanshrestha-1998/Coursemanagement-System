package com.coursemanagement;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;

public class EnrollFunction {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/CourseManagement";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    private static String course = null; // Declared as static

    public static String selectCourse(String studentName) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
            if (connection != null) {
                System.out.println("Database connection is successful!");

                try (PreparedStatement courseStatement = connection.prepareStatement("SELECT course FROM Student WHERE name = ?")) {
                    courseStatement.setString(1, studentName);
                    try (ResultSet courseResult = courseStatement.executeQuery()) {
                        if (courseResult.next()) {
                            course = courseResult.getString("course");
                            return course; // Update the course field and return the retrieved course
                        }
                    }
                }
            }
        } catch (SQLException e) {
            System.err.println("Failed to execute query: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
    
    public static String selectSemester(String studentName) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
            if (connection != null) {
                System.out.println("Database connection is successful!");

                try (PreparedStatement courseStatement = connection.prepareStatement("SELECT Semester FROM Student WHERE name = ?")) {
                    courseStatement.setString(1, studentName);
                    try (ResultSet courseResult = courseStatement.executeQuery()) {
                        if (courseResult.next()) {
                            course = courseResult.getString("Semester");
                            return course; // Update the course field and return the retrieved course
                        }
                    }
                }
            }
        } catch (SQLException e) {
            System.err.println("Failed to execute query: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
    
    public static String selectCourseTeacher(String teacherName) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
            if (connection != null) {
                System.out.println("Database connection is successful!");
          

                try (PreparedStatement courseStatement = connection.prepareStatement("SELECT Course FROM Teacher WHERE name = ?")) {
                    courseStatement.setString(1, teacherName);
                    try (ResultSet courseResult = courseStatement.executeQuery()) {
                        if (courseResult.next()) {
                            course = courseResult.getString("course");
                            return course; 
                        }
                    }
                }
            }
        } catch (SQLException e) {
            System.err.println("Failed to execute query: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }


    public static boolean selectSemesters(String sem) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
            if (connection != null) {
                System.out.println("Database connection is successful!");

                // Proceed only if the course value is obtained successfully
                if (course != null) {
                    try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM `" + course + "` WHERE Semesters = ?")) {
                        preparedStatement.setString(1, sem);

                        try (ResultSet resultSet = preparedStatement.executeQuery()) {
                            // Process the ResultSet here if needed
                            while (resultSet.next()) {
                                // Retrieve data from the current row
                                // Example: String columnName = resultSet.getString("column_name");
                            }
                        }

                        // Since this is a SELECT statement, there's no need to check rowsAffected
                        return true;
                    }
                } else {
                    System.err.println("Course value is not set. Please call selectCourse method first.");
                }
            }
        } catch (SQLException e) {
            System.err.println("Failed to execute query: " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }
    
    public static String fetchModuleInfo(String sem) {
        StringBuilder moduleInfo = new StringBuilder();
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
            if (connection != null) {
                System.out.println("Database connection is successful!");

                // Proceed only if the course value is obtained successfully
                if (course != null) {
                    try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM `" + course + "` WHERE Semesters = ?")) {
                        preparedStatement.setString(1, sem);

                        try (ResultSet resultSet = preparedStatement.executeQuery()) {
                            // Process the ResultSet here if needed
                            while (resultSet.next()) {
                                // Retrieve module information from the current row
                                String module1 = resultSet.getString("Module1");
                                String module2 = resultSet.getString("Module2");
                                String module3 = resultSet.getString("Module3");
                                

                                // Append module information to the StringBuilder if not null
                                if (module1 != null) {
                                    moduleInfo.append("Module 1: ").append(module1).append("\n");
                                }
                                if (module2 != null) {
                                    moduleInfo.append("Module 2: ").append(module2).append("\n");
                                }
                                if (module3 != null) {
                                    moduleInfo.append("Module 3: ").append(module3).append("\n");
                                }
                                
                            }
                        }
                    }
                } else {
                    System.err.println("Course value is not set. Please call selectCourse method first.");
                }
            }
        } catch (SQLException e) {
            System.err.println("Failed to execute query: " + e.getMessage());
            e.printStackTrace();
        }
        return moduleInfo.toString();
    }
    
    public static void updateEnrolledStatus(String studentName, String semester) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
            if (connection != null) {
                System.out.println("Database connection is successful!");

                // Update the Enrolled_Status and Semester for the selected student
                try (PreparedStatement preparedStatement = connection.prepareStatement("UPDATE Student SET Enrolled_Status = ?, Semester = ? WHERE Name = ?")) {
                    preparedStatement.setString(1, "Enrolled");
                    preparedStatement.setString(2, semester);
                    preparedStatement.setString(3, studentName);

                    int rowsAffected = preparedStatement.executeUpdate();
                    if (rowsAffected > 0) {
                        System.out.println("Enrollment status and semester updated successfully.");
                    } else {
                        System.err.println("No rows updated. Student not found.");
                    }
                }
            }
        } catch (SQLException ex) {
            System.err.println("Failed to update enrollment status and semester: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    
    public static boolean enrollStatus() {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
            if (connection != null) {
                System.out.println("Database connection is successful!");
                SharedData share = new SharedData();
                String name = share.getName();

                // Proceed only if the course value is obtained successfully
                if (course != null) {
                    try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT Enrolled_Status FROM Student WHERE Name = ?")) {
                        preparedStatement.setString(1, name);

                        try (ResultSet resultSet = preparedStatement.executeQuery()) {
                            // Check if the result set contains any data
                            if (resultSet.next()) {
                                // Retrieve the enrolled status from the result set
                                String enrolledStatus = resultSet.getString("Enrolled_Status");

                                // Check if the enrolled status is "Enrolled"
                                if ("Enrolled".equals(enrolledStatus)) {
                                    return true;
                                }
                            }
                        }
                    }
                } else {
                    System.err.println("Course value is not set. Please call selectCourse method first.");
                }
            }
        } catch (SQLException e) {
            System.err.println("Failed to execute query: " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }
    
    public static boolean isEnrolled(String studentName) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
            if (connection != null) {
                System.out.println("Database connection is successful!");

                try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT Enrolled_Status FROM Student WHERE Name = ?")) {
                    preparedStatement.setString(1, studentName);

                    try (ResultSet resultSet = preparedStatement.executeQuery()) {
                        if (resultSet.next()) {
                            String enrolledStatus = resultSet.getString("Enrolled_Status");
                            return "Enrolled".equals(enrolledStatus);
                        }
                    }
                }
            }
        } catch (SQLException e) {
            System.err.println("Failed to execute query: " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

    public static void enrollStudent(String studentName, String semester) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
            if (connection != null) {
                System.out.println("Database connection is successful!");

                try (PreparedStatement preparedStatement = connection.prepareStatement("UPDATE Student SET Enrolled_Status = ?, Semester = ? WHERE Name = ?")) {
                    preparedStatement.setString(1, "Enrolled");
                    preparedStatement.setString(2, semester);
                    preparedStatement.setString(3, studentName);

                    int rowsAffected = preparedStatement.executeUpdate();
                    if (rowsAffected > 0) {
                        System.out.println("Student enrolled successfully.");
                    } else {
                        System.err.println("No rows updated. Student not found.");
                    }
                }
            }
        } catch (SQLException ex) {
            System.err.println("Failed to enroll student: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
  
    
    public static ArrayList<String> getModules(String semester) {
        ArrayList<String> modules = new ArrayList<>();
        String query = "SELECT Module1, Module2, Module3 FROM `"+course+"` WHERE Semesters = ?";
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, semester);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    modules.add(resultSet.getString("Module1"));
                    modules.add(resultSet.getString("Module2"));
                    modules.add(resultSet.getString("Module3"));
                }
            }
        } catch (SQLException e) {
            System.err.println("Failed to fetch modules: " + e.getMessage());
            e.printStackTrace();
        }
        return modules;
    }

    public static ArrayList<String> getOptionalModules(String semester) {
        ArrayList<String> optionalModules = new ArrayList<>();
        String query = "SELECT Optional1, Optional2 FROM `"+course+"` WHERE Semesters = ?";
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, semester);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    optionalModules.add(resultSet.getString("Optional1"));
                    optionalModules.add(resultSet.getString("Optional2"));
                }
            }
        } catch (SQLException e) {
            System.err.println("Failed to fetch optional modules: " + e.getMessage());
            e.printStackTrace();
        }
        return optionalModules;
    }
    
    public static void optionalModule(String modulename) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
            if (connection != null) {
                System.out.println("Database connection is successful!");
                SharedData share = new SharedData();
                String name = share.getName();

                try (PreparedStatement preparedStatement = connection.prepareStatement("UPDATE STUDENT SET OptionalModule = ? WHERE name = ?")) {
                    preparedStatement.setString(1, modulename);
                    preparedStatement.setString(2, name);
                    
                    int rowsAffected = preparedStatement.executeUpdate();
                    if (rowsAffected > 0) {
                        System.out.println("Optional module updated successfully.");
                    } else {
                        System.err.println("No rows updated. Student not found.");
                    }
                }
            }
        } catch (SQLException e) {
            System.err.println("Failed to execute query: " + e.getMessage());
            e.printStackTrace();
        }
    }



}
