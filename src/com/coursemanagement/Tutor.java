package com.coursemanagement;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import java.awt.TextArea;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JToggleButton;

public class Tutor extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextPane textPane;
    private JLabel lblTotalStudents;
    String course;

	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tutor frame = new Tutor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Tutor() {
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
		
		
		JLabel lblNewLabel_1 = new JLabel("Tutors");
		lblNewLabel_1.setForeground(new Color(25, 25, 112));
		lblNewLabel_1.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 28));
		lblNewLabel_1.setBounds(325, 55, 185, 26);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Dashboard");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Dashboard dashboard = new Dashboard();
				dashboard.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 17));
		btnNewButton.setBounds(84, 235, 129, 46);
		contentPane.add(btnNewButton);
		
		JButton btnCourses = new JButton("Course");
		btnCourses.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Courses course = new Courses();
				course.setVisible(true);
				dispose();
			}
		});
		btnCourses.setForeground(new Color(0, 0, 0));
		btnCourses.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 17));
		btnCourses.setBounds(84, 292, 129, 46);
		contentPane.add(btnCourses);
		
		JButton btnTutors = new JButton("Tutors");
		btnTutors.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 17));
		btnTutors.setBounds(84, 350, 129, 46);
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
		
		setLocationRelativeTo(null);
		btnNewButton.setFocusPainted(false);
		btnTutors.setFocusPainted(false);
		btnCourses.setFocusPainted(false);
		btnLogout.setFocusPainted(false);
		
		
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
		btnStudents.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Student stud = new Student();
				stud.setVisible(true);
				dispose();
			}
		});
		btnStudents.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 17));
		btnStudents.setFocusPainted(false);
		btnStudents.setBounds(84, 408, 129, 46);
		contentPane.add(btnStudents);
		btnStudents.setVisible(false);


        RetrieveData retrieveData = new RetrieveData();
		
		
		
		SharedData share = new SharedData();
		String userRole = share.getUserRole();
		
		if("Admin".equals(userRole) || "Teacher".equals(userRole)) {
			btnStudents.setVisible(true);
		}
		
		JButton btnNewButton_1 = new JButton("ManageTutors");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tutorsmanage tutor = new Tutorsmanage();
				tutor.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 13));
		btnNewButton_1.setBounds(716, 120, 149, 29);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Assign Tutors");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AssignTutors assign = new AssignTutors();
				assign.setVisible(true);
			}
		});
		btnNewButton_2.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 13));
		btnNewButton_2.setBounds(865, 120, 117, 29);
		contentPane.add(btnNewButton_2);
		
		btnNewButton_1.setVisible(false);
		btnNewButton_2.setVisible(false);
		
		if("Admin".equals(userRole)) {
			btnNewButton_1.setVisible(true);
			btnNewButton_2.setVisible(true);
			
			
		}
		
		Vector<String> courseData = CourseFunction.getCourseNames();
		JComboBox<String> comboBox = new JComboBox<>(courseData);
		comboBox.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 13));
		comboBox.setBounds(311, 121, 348, 27);
		comboBox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    String selectedCourse = comboBox.getSelectedItem().toString();
                    textPane.setText(generateTeacherData(selectedCourse));
                }
            }
        });
        contentPane.add(comboBox);

        course = comboBox.getSelectedItem().toString();

        RoundedPanel dataPanel = new RoundedPanel(20);
        dataPanel.setLayout(new BorderLayout());
        dataPanel.setBackground(new Color(245, 245, 245));
        dataPanel.setBounds(317, 179, 382, 393);
        contentPane.add(dataPanel);
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBorder(null);
        dataPanel.add(scrollPane, BorderLayout.CENTER);

        textPane = new JTextPane();
        scrollPane.setViewportView(textPane);
        textPane.setEditable(false);
        textPane.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 13));
        textPane.setBackground(new Color(245, 245, 245));
        textPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        textPane.setMargin(new Insets(10, 10, 10, 10));
        textPane.setText(generateTeacherData(course));
		
	

	}
	
	
	private String generateTeacherData(String course) {
        List<Teacher> teachers = ManageTutors.getTeachersByCourse(course);

        StringBuilder teacherData = new StringBuilder();
        for (Teacher tutor : teachers) {
            teacherData.append("Name: ").append(tutor.getName()).append("\n")
                    .append("Course: ").append(tutor.getCourse()).append("\n")
                    .append("Module: ").append(tutor.getModule()).append("\n")
                    .append("Email: ").append(tutor.getEmail()).append("\n\n");
        }

        return teacherData.toString();
    }

	
	
	


	
}
