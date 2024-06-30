package com.coursemanagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JLabel;

public class CourseFunction {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/CourseManagement";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    
    // Constants for SQL queries
    private static final String INSERT_COURSE_QUERY = "INSERT INTO Course (CourseName, Duration) VALUES (?, ?)";
    private static final String DELETE_COURSE_QUERY = "DELETE FROM Course WHERE CourseName = ?";
    private static final String SELECT_COURSE_NAMES_QUERY = "SELECT CourseName FROM Course";
    
    public static boolean addCourse(String courseName, String duration) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
            if (connection != null) {
                System.out.println("Database connection is successful!");

                try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_COURSE_QUERY)) {
                    preparedStatement.setString(1, courseName);
                    preparedStatement.setString(2, duration);

                    int rowsAffected = preparedStatement.executeUpdate();

                    return rowsAffected > 0;
                }
            }
        } catch (SQLException e) {
            System.err.println("Failed to add course: " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

    public static boolean deleteCourse(String name, boolean dropTable) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
            if (connection != null) {
                System.out.println("Database connection is successful!");

                if (dropTable) {
                    try (PreparedStatement dropTableStatement = connection.prepareStatement("DROP TABLE `" +name+"`")) {
                        dropTableStatement.executeUpdate();
                    } catch (SQLException ex) {
                        System.err.println("Failed to drop table: " + ex.getMessage());
                        ex.printStackTrace();
                        return false;
                    }
                }

                try (PreparedStatement deleteCourseStatement = connection.prepareStatement(DELETE_COURSE_QUERY)) {
                    deleteCourseStatement.setString(1, name);

                    int rowsAffected = deleteCourseStatement.executeUpdate();

                    return rowsAffected > 0;
                }
            }
        } catch (SQLException e) {
            System.err.println("Failed to delete course: " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

    
    public static Vector<String> getCourseNames() {
        Vector<String> courseNames = new Vector<>();

        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_COURSE_NAMES_QUERY);
                 ResultSet resultSet = preparedStatement.executeQuery()) {

                while (resultSet.next()) {
                    String courseName = resultSet.getString("CourseName");
                    courseNames.add(courseName);
                }
            }
        } catch (SQLException e) {
            System.err.println("Failed to fetch course names: " + e.getMessage());
            e.printStackTrace();
        }

        return courseNames;
    }

    
    public static boolean addModuleThree(String moduleName) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
            if (connection != null) {
                System.out.println("Database connection is successful!");

                String createTableQuery = "CREATE TABLE `" + moduleName +
                        "` (Id INT PRIMARY KEY AUTO_INCREMENT, Semesters VARCHAR(50), Module1 VARCHAR(50), Module2 VARCHAR(50), Module3 VARCHAR(50), Optional1 VARCHAR(50), Optional2 VARCHAR(50))";
                
                String insertRowQuery = "INSERT INTO `" + moduleName +
                        "` (Semesters) VALUES ('FirstSem'), ('SecondSem'), ('ThirdSem'), ('FourthSem'), ('FifthSem'), ('SixthSem')";

                try (PreparedStatement createTableStatement = connection.prepareStatement(createTableQuery);
                     PreparedStatement insertRowStatement = connection.prepareStatement(insertRowQuery)) {

                    int createTableRowsAffected = createTableStatement.executeUpdate();
                    int insertRowRowsAffected = insertRowStatement.executeUpdate();

                    return createTableRowsAffected > 0 && insertRowRowsAffected > 0;
                }
            }
        } catch (SQLException e) {
            System.err.println("Failed to add module: " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }


    public static boolean addModuleFour(String moduleName) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
            if (connection != null) {
                System.out.println("Database connection is successful!");

                String createTableQuery = "CREATE TABLE `" + moduleName +
                        "` (Id INT PRIMARY KEY AUTO_INCREMENT, Semesters VARCHAR(50), Module1 VARCHAR(50), Module2 VARCHAR(50), Module3 VARCHAR(50), Optional1 VARCHAR(50), Optional2 VARCHAR(50))";
                
                String insertRowQuery = "INSERT INTO `" + moduleName +
                        "` (Semesters) VALUES ('FirstSem'), ('SecondSem'), ('ThirdSem'), ('FourthSem'), ('FifthSem'), ('SixthSem'), ('SeventhSem'), ('EightSem')";

                try (PreparedStatement createTableStatement = connection.prepareStatement(createTableQuery);
                     PreparedStatement insertRowStatement = connection.prepareStatement(insertRowQuery)) {

                    int createTableRowsAffected = createTableStatement.executeUpdate();
                    int insertRowRowsAffected = insertRowStatement.executeUpdate();

                    return createTableRowsAffected > 0 && insertRowRowsAffected > 0;
                }
            }
        } catch (SQLException e) {
            System.err.println("Failed to add module: " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

    
    public static boolean updateModuleValues(String tableName, String columnName, String columnValue, String moduleCode) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
            if (connection != null) {
                System.out.println("Database connection is successful!");

                String updateValuesQuery = "UPDATE `" + tableName + "` SET " + moduleCode + " = ? WHERE Semesters = ?";

                try (PreparedStatement preparedStatement = connection.prepareStatement(updateValuesQuery)) {
                    preparedStatement.setString(1, columnValue);
                    preparedStatement.setString(2, columnName);

                    int rowsAffected = preparedStatement.executeUpdate();

                    return rowsAffected > 0;
                }
            }
        } catch (SQLException e) {
            System.err.println("Failed to update module values: " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }
    
    public static boolean removeModuleValue(String tableName, String columnName, String moduleCode) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
            if (connection != null) {
                System.out.println("Database connection is successful!");

                String updateValuesQuery = "UPDATE `" + tableName + "` SET " + columnName + " = NULL WHERE Semesters = ?";

                try (PreparedStatement preparedStatement = connection.prepareStatement(updateValuesQuery)) {
                    preparedStatement.setString(1, moduleCode);

                    int rowsAffected = preparedStatement.executeUpdate();

                    return rowsAffected > 0;
                }
            }
        } catch (SQLException e) {
            System.err.println("Failed to remove module value: " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

    public static void displayCourseInformation(JLabel courseInfoLabel, String course) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
            if (connection != null) {
                System.out.println("Database connection is successful!");

                try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM `" + course + "`")) {
                    try (ResultSet resultSet = preparedStatement.executeQuery()) {
                        StringBuilder courseInfoBuilder = new StringBuilder();
                        // Display course information
                        while (resultSet.next()) {
                            String semester = resultSet.getString("Semesters");
                            String module1 = resultSet.getString("Module1");
                            String module2 = resultSet.getString("Module2");
                            String module3 = resultSet.getString("Module3");
                            String optional1 = resultSet.getString("Optional1");
                            String optional2 = resultSet.getString("Optional2");

                            // Append the retrieved information to the StringBuilder if it's not null
                            courseInfoBuilder.append("Semester: ").append(semester).append("<br>");
                            if (module1 != null) {
                                courseInfoBuilder.append("   Module 1: ").append(module1).append("<br>");
                            }
                            if (module2 != null) {
                                courseInfoBuilder.append("   Module 2: ").append(module2).append("<br>");
                            }
                            if (module3 != null) {
                                courseInfoBuilder.append("   Module 3: ").append(module3).append("<br>");
                            }
                            if (optional1 != null) {
                                courseInfoBuilder.append("   Optional 1: ").append(optional1).append("<br>");
                            }
                            if (optional2 != null) {
                                courseInfoBuilder.append("   Optional 2: ").append(optional2).append("<br>");
                            }
                            courseInfoBuilder.append("<br>");
                        }
                        // Set the text of the JLabel with the retrieved information
                        courseInfoLabel.setText("<html>" + courseInfoBuilder.toString() + "</html>");
                    }
                }
            }
        } catch (SQLException e) {
            System.err.println("Failed to retrieve course information: " + e.getMessage());
            e.printStackTrace();
        }
    }




}

