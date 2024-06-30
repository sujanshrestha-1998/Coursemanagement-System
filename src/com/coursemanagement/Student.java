package com.coursemanagement;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Student extends JFrame {

    private JPanel contentPane;
    private JTextPane textPane;
    private JLabel lblTotalStudents;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Student frame = new Student();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public Student() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1010, 682);
        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JSeparator separator = new JSeparator();
        separator.setOrientation(SwingConstants.VERTICAL);
        separator.setBounds(286, 97, 19, 494);
        contentPane.add(separator);

        JLabel lblNewLabel_1 = new JLabel("Students");
        lblNewLabel_1.setForeground(new Color(25, 25, 112));
        lblNewLabel_1.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 28));
        lblNewLabel_1.setBounds(325, 55, 185, 26);
        contentPane.add(lblNewLabel_1);

        JButton btnNewButton = new JButton("Dashboard");
        btnNewButton.addActionListener(e -> {
            Dashboard dashboard = new Dashboard();
            dashboard.setVisible(true);
            dispose();
        });
        btnNewButton.setForeground(new Color(0, 0, 0));
        btnNewButton.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 17));
        btnNewButton.setBounds(84, 240, 129, 46);
        contentPane.add(btnNewButton);

        JButton btnCourses = new JButton("Course");
        btnCourses.addActionListener(e -> {
            Courses course = new Courses();
            course.setVisible(true);
            dispose();
        });
        btnCourses.setForeground(new Color(0, 0, 0));
        btnCourses.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 17));
        btnCourses.setBounds(84, 298, 129, 46);
        contentPane.add(btnCourses);

        JButton btnTutors = new JButton("Tutors");
        btnTutors.addActionListener(e -> {
            Tutor tutor = new Tutor();
            tutor.setVisible(true);
            dispose();
        });
        btnTutors.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 17));
        btnTutors.setBounds(84, 356, 129, 46);
        contentPane.add(btnTutors);

		ImageIcon originalIcon1 = new ImageIcon("/Users/sujanshrestha/Desktop/College/Second Year/Semester I/Object Oriented Programming/CourseManagementSystem/Images/logout.jpg");
		
		int maxWidth1 = 30;
		int maxHeight1 = 30;


		int originalWidth1 = originalIcon1.getIconWidth();
		int originalHeight1 = originalIcon1.getIconHeight();
		double aspectRatio1 = (double) originalWidth1 / originalHeight1;

		int newWidth1 = Math.min(maxWidth1, (int) (maxHeight1 * aspectRatio1));
		int newHeight1 = Math.min(maxHeight1, (int) (maxWidth1 / aspectRatio1));

		Image scaledImage1 = originalIcon1.getImage().getScaledInstance(newWidth1, newHeight1, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon1 = new ImageIcon(scaledImage1);

		btnTutors.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 17));
		btnTutors.setBounds(84, 355, 129, 46);
		contentPane.add(btnTutors);
		
		
		JButton btnLogout = new JButton(scaledIcon1);
		btnLogout.setText("Logout");
		btnLogout.setHorizontalAlignment(SwingConstants.LEFT);
		btnLogout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int choice = JOptionPane.showConfirmDialog(contentPane, "Are you sure you want to logout?", "Logout Confirmation", JOptionPane.YES_NO_OPTION);
                if (choice == JOptionPane.YES_OPTION) {
                	SharedData share = new SharedData();
                	share.setName(null);
                	LoginPage login = new LoginPage();
                    login.setVisible(true);
                    dispose();
                }
                
            }
        });
        btnLogout.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 17));
        btnLogout.setBounds(84, 471, 129, 46);
        contentPane.add(btnLogout);
        btnLogout.setFocusPainted(false);
        btnLogout.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 17));
        btnLogout.setBounds(84, 469, 129, 46);
        contentPane.add(btnLogout);

        ImageIcon originalIcon_ = new ImageIcon("/Users/sujanshrestha/Desktop/College/Second Year/Semester I/Object Oriented Programming/CourseManagementSystem/Images/trinity.jpg");
		
		int maxWidth_ = 150;
		int maxHeight_ = 150;


		int originalWidth_ = originalIcon_.getIconWidth();
		int originalHeight_ = originalIcon_.getIconHeight();
		double aspectRatio_ = (double) originalWidth_ / originalHeight_;

		int newWidth_ = Math.min(maxWidth_, (int) (maxHeight_ * aspectRatio_));
		int newHeight_ = Math.min(maxHeight_, (int) (maxWidth_ / aspectRatio_));

		Image scaledImage_ = originalIcon_.getImage().getScaledInstance(newWidth_, newHeight_, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon_ = new ImageIcon(scaledImage_);
		
		JLabel lblNewLabel_7 = new JLabel(scaledIcon_);
		lblNewLabel_7.setBounds(55, 19, 189, 200);
		contentPane.add(lblNewLabel_7);

        JButton btnStudents = new JButton("Students");
        btnStudents.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 17));
        btnStudents.setFocusPainted(false);
        btnStudents.setBounds(84, 414, 129, 46);
        contentPane.add(btnStudents);

        // Original rounded panel for total students
        RoundedPanel panel_1 = new RoundedPanel(20);
        panel_1.setLayout(null);
        panel_1.setBackground(new Color(245, 245, 245));
        panel_1.setBounds(317, 97, 207, 147);
        contentPane.add(panel_1);

        JLabel lblNewLabel = new JLabel("Total Students");
        lblNewLabel.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 15));
        lblNewLabel.setBounds(16, 18, 116, 16);
        panel_1.add(lblNewLabel);

        StudentAccess stud = new StudentAccess();
        int totalStudents = stud.getTotalStudents();

        lblTotalStudents = new JLabel(String.valueOf(totalStudents));
        lblTotalStudents.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 40));
        lblTotalStudents.setBounds(26, 46, 98, 57);
        panel_1.add(lblTotalStudents);

        // New rounded panel for student data
        RoundedPanel dataPanel = new RoundedPanel(20);
        dataPanel.setLayout(new BorderLayout());
        dataPanel.setBackground(new Color(245, 245, 245));
        dataPanel.setBounds(317, 254, 382, 318);
        contentPane.add(dataPanel);

        JLabel lblStudentData = new JLabel("Student Data");
        lblStudentData.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 15));
        lblStudentData.setHorizontalAlignment(SwingConstants.CENTER);
        dataPanel.add(lblStudentData, BorderLayout.NORTH);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBorder(null);
        dataPanel.add(scrollPane, BorderLayout.CENTER);
                
        textPane = new JTextPane();
        scrollPane.setViewportView(textPane);
        textPane.setEditable(false);
        textPane.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 13));
        textPane.setBackground(new Color(245, 245, 245)); // Set background color
        textPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add padding
        textPane.setMargin(new Insets(10, 10, 10, 10)); // Set margin
        textPane.setText(generateStudentData());
        
        JButton btnNewButton_1 = new JButton("Register Student");
        btnNewButton_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		RegisterPage register = new RegisterPage();
        		register.setVisible(true);
        		dispose();
        		
        	}
        });
        btnNewButton_1.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 13));
        btnNewButton_1.setBounds(536, 105, 163, 29);
        contentPane.add(btnNewButton_1);
        btnNewButton_1.setFocusPainted(false);
        
        JButton btnNewButton_1_1 = new JButton("Terminate Student");
        btnNewButton_1_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		TerminateStudent terminate = new TerminateStudent();
        		terminate.setVisible(true);
        	}
        });
        btnNewButton_1_1.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 13));
        btnNewButton_1_1.setBounds(536, 146, 163, 29);
        contentPane.add(btnNewButton_1_1);
        btnNewButton_1_1.setFocusPainted(false);
        
        JButton btnNewButton_1_1_1 = new JButton("Upgrade Student");
        btnNewButton_1_1_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		UpgradeStudent upgrade = new UpgradeStudent();
        		upgrade.setVisible(true);
        	}
        });
        btnNewButton_1_1_1.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 13));
        btnNewButton_1_1_1.setFocusPainted(false);
        btnNewButton_1_1_1.setBounds(536, 187, 163, 29);
        contentPane.add(btnNewButton_1_1_1);
        
        btnNewButton_1.setVisible(false);
        btnNewButton_1_1.setVisible(false);
        btnNewButton_1_1_1.setVisible(false);
        
        SharedData share = new SharedData();
        String role = share.getUserRole();
        
        if("Admin".equals(role)) {
        	 btnNewButton_1.setVisible(true);
             btnNewButton_1_1.setVisible(true);
             btnNewButton_1_1_1.setVisible(true);
        }
        


        setLocationRelativeTo(null);
    }

    private String generateStudentData() {
        List<StudentData> students = StudentAccess.getAllStudents();

        StringBuilder studentData = new StringBuilder();
        for (StudentData student : students) {
            studentData.append("Student Name: ").append(student.getStudentName()).append("\n")
                    .append("Student Course: ").append(student.getStudentCourse()).append("\n")
                    .append("Email: ").append(student.getStudentMail()).append("\n\n");
            // Append other fields if needed
        }

        return studentData.toString();
    }
}
