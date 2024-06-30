// NoticeService.java
package com.coursemanagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class NoticeService {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/CourseManagement";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    

    public static boolean addNotice(String noticeText) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
            String insertQuery = "INSERT INTO Notice (Noticetxt) VALUES (?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                preparedStatement.setString(1, noticeText);

                int rowsAffected = preparedStatement.executeUpdate();
                return rowsAffected > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    
    public static List<String> retrieveNotices() {
        List<String> notices = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
            String selectQuery = "SELECT Noticetxt FROM Notice";
            try (PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {
                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    String noticeText = resultSet.getString("Noticetxt");
                    notices.add(noticeText);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return notices;
    }
}
