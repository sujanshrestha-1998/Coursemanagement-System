package com.coursemanagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class MarksFunction {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/CourseManagement";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    
    private static final String SELECT_STUDENT_QUERY = "SELECT Semester FROM Student WHERE Name = ?";
//    private static final String SELECT_MODULE_QUERY = "SELECT Module1, Module2, Module3, Module4 FROM %s WHERE Semesters = ?";
    private static final String INSERT_RESULT_QUERY = "INSERT INTO Result (Module, StudentName, Marks) VALUES (?, ?, ?)";

    public static boolean addResultTeacher(String studentname, String marks) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
            SharedData share = new SharedData();
            String teacherName = share.getName();

            if (connection != null) {
                // Retrieve the teacher's assigned module
                String teacherModuleQuery = "SELECT Module FROM Teacher WHERE Name = ?";
                try (PreparedStatement teacherModuleStatement = connection.prepareStatement(teacherModuleQuery)) {
                    teacherModuleStatement.setString(1, teacherName);
                    ResultSet teacherModuleResultSet = teacherModuleStatement.executeQuery();

                    if (teacherModuleResultSet.next()) {
                        String teacherAssignedModule = teacherModuleResultSet.getString("Module");

                        // Check if student exists and retrieve the semester
                        String SELECT_STUDENT_QUERY = "SELECT Semester FROM Student WHERE Name = ?";
                        try (PreparedStatement studentStatement = connection.prepareStatement(SELECT_STUDENT_QUERY)) {
                            studentStatement.setString(1, studentname);
                            ResultSet studentResultSet = studentStatement.executeQuery();

                            if (studentResultSet.next()) {
                                String semester = studentResultSet.getString("Semester");

                                EnrollFunction enroll = new EnrollFunction();
                                String course = enroll.selectCourse(studentname);

                                // Retrieve the modules and optional module for the semester
                                String moduleQuery = "SELECT Module1, Module2, Module3 FROM `" + course + "` WHERE Semesters = ?";
                                String optionalModuleQuery = "SELECT OptionalModule FROM Student WHERE Name = ?";
                                try (PreparedStatement moduleStatement = connection.prepareStatement(moduleQuery);
                                     PreparedStatement optionalModuleStatement = connection.prepareStatement(optionalModuleQuery)) {
                                    moduleStatement.setString(1, semester);
                                    optionalModuleStatement.setString(1, studentname);
                                    ResultSet moduleResultSet = moduleStatement.executeQuery();
                                    ResultSet optionalModuleResultSet = optionalModuleStatement.executeQuery();

                                    // Iterate through modules and check for a match with teacher's assigned module
                                    while (moduleResultSet.next()) {
                                        String module1 = moduleResultSet.getString("Module1");
                                        String module2 = moduleResultSet.getString("Module2");
                                        String module3 = moduleResultSet.getString("Module3");

                                        // Check if the teacher's assigned module matches any of the retrieved modules
                                        if (teacherAssignedModule.equals(module1) || teacherAssignedModule.equals(module2) || teacherAssignedModule.equals(module3)) {
                                            // Insert marks for the matched module
                                            if (insertResult(connection, INSERT_RESULT_QUERY, teacherAssignedModule, studentname, marks)) {
                                                return true;
                                            }
                                        }
                                    }

                                    // Iterate through optional modules and check for a match with teacher's assigned module
                                    while (optionalModuleResultSet.next()) {
                                        String optionalModule = optionalModuleResultSet.getString("OptionalModule");

                                        // Check if the teacher's assigned module matches the optional module
                                        if (teacherAssignedModule.equals(optionalModule)) {
                                            // Insert marks for the optional module
                                            if (insertResult(connection, INSERT_RESULT_QUERY, optionalModule, studentname, marks)) {
                                                return true;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } catch (SQLException e) {
            System.err.println("Failed to add result: " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }




    private static boolean insertResult(Connection connection, String query, String module, String studentname, String marks) throws SQLException {
        try (PreparedStatement insertStatement = connection.prepareStatement(query)) {
            insertStatement.setString(1, module);
            insertStatement.setString(2, studentname);
            insertStatement.setString(3, marks);

            int rowsAffected = insertStatement.executeUpdate();
            return rowsAffected > 0;
        }
    }


    
    public static boolean addResultAdmin(String studentName, String marks, String moduleName) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
            if (connection != null) {
                // Use a prepared statement for better security and performance
                String insertResultQuery = "INSERT INTO Result (Module, StudentName, Marks) VALUES (?, ?, ?)";
                
                try (PreparedStatement insertStatement = connection.prepareStatement(insertResultQuery)) {
                    // Set parameters for the prepared statement
                    insertStatement.setString(1, moduleName);
                    insertStatement.setString(2, studentName);
                    insertStatement.setString(3, marks);

                    // Execute the update
                    int rowsAffected = insertStatement.executeUpdate();

                    // Check if any rows were affected
                    return rowsAffected > 0;
                }
            }
        } catch (SQLException e) {
            // Log the error and print the stack trace for debugging purposes
            System.err.println("Failed to add result: " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

    
    public static void printResult(JLabel resultLabel, String studentName) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
            if (connection != null) {
                // Retrieve the semester of the student
                String selectsemesterQuery = "SELECT Semester FROM Student WHERE Name = ?";
                try (PreparedStatement semesterStatement = connection.prepareStatement(selectsemesterQuery)) {
                    semesterStatement.setString(1, studentName);
                    ResultSet semesterResultSet = semesterStatement.executeQuery();

                    String semester = null;
                    if (semesterResultSet.next()) {
                        semester = semesterResultSet.getString("Semester");
                    }

                    if (semester != null) {
                        // Retrieve the course for the student
                        EnrollFunction enroll = new EnrollFunction();
                        String course = enroll.selectCourse(studentName);

                        // Retrieve the modules for the semester and course
                        String selectCourseModuleQuery = "SELECT Module1, Module2, Module3 FROM `" + course + "` WHERE Semesters = ?";
                        try (PreparedStatement moduleStatement = connection.prepareStatement(selectCourseModuleQuery)) {
                            moduleStatement.setString(1, semester);
                            ResultSet moduleResultSet = moduleStatement.executeQuery();

                            // StringBuilder to accumulate result text
                            StringBuilder resultText = new StringBuilder("<html>");

                            // Flag to track if all marks are above 40
                            boolean allPassed = true;

                            while (moduleResultSet.next()) {
                                String moduleName1 = moduleResultSet.getString("Module1");
                                String moduleName2 = moduleResultSet.getString("Module2");
                                String moduleName3 = moduleResultSet.getString("Module3");

                                int marks1 = getMarksForModule(connection, studentName, moduleName1);
                                int marks2 = getMarksForModule(connection, studentName, moduleName2);
                                int marks3 = getMarksForModule(connection, studentName, moduleName3);

                                // Append information to the StringBuilder with newline characters
                                resultText.append("Module: ").append(moduleName1).append("<br/>")
                                        .append("Marks: ").append(marks1).append("<br/><br/>");
                                resultText.append("Module: ").append(moduleName2).append("<br/>")
                                        .append("Marks: ").append(marks2).append("<br/><br/>");
                                resultText.append("Module: ").append(moduleName3).append("<br/>")
                                        .append("Marks: ").append(marks3).append("<br/><br/>");

                                // Check if marks are below 40
                                if (marks1 < 40 || marks2 < 40 || marks3 < 40) {
                                    allPassed = false;
                                }
                            }

                            // Check if all marks are above 40
                            String passOrFail = allPassed ? "Passed" : "Failed";

                            // Append pass/fail status to the result text
                            resultText.append("Result: ").append(passOrFail).append("<br/><br/>");

                            // Set the accumulated text to the JLabel
                            resultLabel.setText(resultText.append("</html>").toString());
                            resultLabel.setVerticalAlignment(SwingConstants.TOP); // Align text to the top
                            resultLabel.setHorizontalAlignment(SwingConstants.LEFT); // Align text to the left
                        }
                    }
                }
            }
        } catch (SQLException ex) {
            System.err.println("Failed to display student information: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    private static int getMarksForModule(Connection connection, String studentName, String moduleName) throws SQLException {
        String selectMarksQuery = "SELECT Marks FROM Result WHERE StudentName = ? AND Module = ?";
        try (PreparedStatement marksStatement = connection.prepareStatement(selectMarksQuery)) {
            marksStatement.setString(1, studentName);
            marksStatement.setString(2, moduleName);
            ResultSet marksResultSet = marksStatement.executeQuery();

            if (marksResultSet.next()) {
                return marksResultSet.getInt("Marks");
            } else {
                return 0; // If marks for the module are not found, return 0
            }
        }
    }
    
    public static ArrayList<String> getPassedStudents() {
        ArrayList<String> passedStudents = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
            if (connection != null) {
                // Retrieve all student names
                String selectStudentsQuery = "SELECT Name FROM Student";
                try (PreparedStatement studentStatement = connection.prepareStatement(selectStudentsQuery)) {
                    ResultSet studentResultSet = studentStatement.executeQuery();

                    // Loop through each student
                    while (studentResultSet.next()) {
                        String studentName = studentResultSet.getString("Name");

                        // Check if the student has passed
                        if (hasPassed(connection, studentName)) {
                            passedStudents.add(studentName);
                        }
                    }
                }
            }
        } catch (SQLException ex) {
            System.err.println("Failed to retrieve student information: " + ex.getMessage());
            ex.printStackTrace();
        }

        return passedStudents;
    }

    private static boolean hasPassed(Connection connection, String studentName) throws SQLException {
        String selectsemesterQuery = "SELECT Semester FROM Student WHERE Name = ?";
        try (PreparedStatement semesterStatement = connection.prepareStatement(selectsemesterQuery)) {
            semesterStatement.setString(1, studentName);
            ResultSet semesterResultSet = semesterStatement.executeQuery();

            String semester = null;
            if (semesterResultSet.next()) {
                semester = semesterResultSet.getString("Semester");
            }

            if (semester != null) {
                // Retrieve the course for the student
                EnrollFunction enroll = new EnrollFunction();
                String course = enroll.selectCourse(studentName);

                // Retrieve the modules for the semester and course
                String selectCourseModuleQuery = "SELECT Module1, Module2, Module3 FROM `" + course + "` WHERE Semesters = ?";
                try (PreparedStatement moduleStatement = connection.prepareStatement(selectCourseModuleQuery)) {
                    moduleStatement.setString(1, semester);
                    ResultSet moduleResultSet = moduleStatement.executeQuery();

                    // Flag to track if all marks are above 40
                    boolean allPassed = true;

                    while (moduleResultSet.next()) {
                        String moduleName1 = moduleResultSet.getString("Module1");
                        String moduleName2 = moduleResultSet.getString("Module2");
                        String moduleName3 = moduleResultSet.getString("Module3");

                        int marks1 = getMarksForModule(connection, studentName, moduleName1);
                        int marks2 = getMarksForModule(connection, studentName, moduleName2);
                        int marks3 = getMarksForModule(connection, studentName, moduleName3);

                        // Check if marks are below 40
                        if (marks1 < 40 || marks2 < 40 || marks3 < 40) {
                            allPassed = false;
                            break; // No need to check further if one module fails
                        }
                    }

                    return allPassed;
                }
            }
        }
        return false;
    }
    
    
    public static boolean Upgradestud(String studentName, String sem) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
            if (connection != null) {
                // Use a prepared statement for better security and performance
                String updateQuery = "UPDATE Student SET Semester = ? WHERE Name = ?";
                
                try (PreparedStatement updateStatement = connection.prepareStatement(updateQuery)) {
                    // Set parameters for the prepared statement                
                    updateStatement.setString(1, sem);
                    updateStatement.setString(2, studentName);

                    // Execute the update
                    int rowsAffected = updateStatement.executeUpdate();

                    // Check if any rows were affected
                    return rowsAffected > 0;
                }
            }
        } catch (SQLException e) {
            // Log the error and print the stack trace for debugging purposes
            System.err.println("Failed to upgrade student: " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }



    
  





}
