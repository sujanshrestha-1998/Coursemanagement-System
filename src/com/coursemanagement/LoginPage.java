package com.coursemanagement;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import javax.swing.JList;
import javax.swing.JPasswordField;
import javax.swing.JToggleButton;
import javax.swing.JScrollBar;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.*;
import java.awt.event.ActionEvent;
import javax.swing.AbstractListModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.UIManager;

public class LoginPage extends JFrame {
	
//	Connection conn = null;
//	Statement stmt = null;
//	ResultSet rs = null;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	
	/**
	 * Launch the application.
	 */
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPage frame = new LoginPage();
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
	public LoginPage() {

		
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 398, 540);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 15));
		lblNewLabel.setBounds(70, 254, 145, 16);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 13));
		textField.setBounds(70, 274, 270, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(70, 307, 145, 16);
		contentPane.add(lblNewLabel_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 13));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Select User", "Admin", "Teacher", "Student"}));
		comboBox.setBounds(61, 203, 131, 26);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel_2 = new JLabel("Invalid Credentials!");
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 11));
		lblNewLabel_2.setBounds(70, 357, 166, 16);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_2.setVisible(false);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setBackground(new Color(165, 42, 42));
		btnNewButton.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        String selectedUserRole = comboBox.getSelectedItem().toString();
		        String disName = textField.getText();
		        SharedData share = new SharedData();
		        share.setUserRole(selectedUserRole);
		        share.setName(disName);
		        Dashboard dashboard = new Dashboard();
		        

		        // For Admin
		        if ("Admin".equals(selectedUserRole)) {
		            String adminUsername = textField.getText();
		            String adminPassword = passwordField.getText();
		            

		            if (LoginUser.authenticateAdmin(adminUsername, adminPassword)) {
		                // Authentication successful for admin
		                System.out.println("Admin login successful!");
		                dashboard.setVisible(true);
		                
		                dispose();

		            } else {
		                // Authentication failed
		                lblNewLabel_2.setVisible(true);

		            }
		        }

		        if ("Student".equals(selectedUserRole)) {
		            String studUsername = textField.getText();
		            String studPassword = passwordField.getText();
		           

		            
		            
		            if (LoginUser.authenticateStudent(studUsername, studPassword)) {
		                // Authentication successful for student
		                System.out.println("Student login successful!");
		                dashboard.setVisible(true);
		                dispose();

		            } else {
		                // Authentication failed
		                lblNewLabel_2.setVisible(true);

		            }

		        }

		        if ("Teacher".equals(selectedUserRole)) {
		            String teacherUsername = textField.getText();
		            String teacherPassword = passwordField.getText();
		    

		            if (LoginUser.authenticateTeacher(teacherUsername, teacherPassword)) {
		                // Authentication successful for teacher
		                System.out.println("Teacher login successful!");
		                dashboard.setVisible(true);
		                dispose();

		            } else {
		                // Authentication failed
		                lblNewLabel_2.setVisible(true);

		            }

		        }
		    }
		});

		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 15));
		btnNewButton.setBounds(243, 416, 97, 46);
		contentPane.add(btnNewButton);
		

		
		JButton btnNewButton_1 = new JButton("Register");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
	
				
				RegisterPage register = new RegisterPage();
				register.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 15));
		btnNewButton_1.setBounds(137, 416, 99, 46);
		contentPane.add(btnNewButton_1);
		
		ImageIcon originalIcon_ = new ImageIcon("/Users/sujanshrestha/Desktop/College/Second Year/Semester I/Object Oriented Programming/CourseManagementSystem/Images/Bannerlogo.jpg");
		
		int maxWidth_ = 300;
		int maxHeight_ = 300;


		int originalWidth_ = originalIcon_.getIconWidth();
		int originalHeight_ = originalIcon_.getIconHeight();
		double aspectRatio_ = (double) originalWidth_ / originalHeight_;

		int newWidth_ = Math.min(maxWidth_, (int) (maxHeight_ * aspectRatio_));
		int newHeight_ = Math.min(maxHeight_, (int) (maxWidth_ / aspectRatio_));

		Image scaledImage_ = originalIcon_.getImage().getScaledInstance(newWidth_, newHeight_, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon_ = new ImageIcon(scaledImage_);
		
		JLabel lblNewLabel_7 = new JLabel(scaledIcon_);
		lblNewLabel_7.setBounds(37, 6, 309, 200);
		contentPane.add(lblNewLabel_7);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(69, 332, 270, 26);
		contentPane.add(passwordField);
		setLocationRelativeTo(null);
		
		
	}
}
