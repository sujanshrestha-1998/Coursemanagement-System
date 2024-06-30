package com.coursemanagement;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JSplitPane;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JSpinner;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class RegisterPage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterPage frame = new RegisterPage();
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
	public RegisterPage() {
		setTitle("Register");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 868, 624);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
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
		lblNewLabel_7.setBounds(6, 19, 322, 200);
		contentPane.add(lblNewLabel_7);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(340, 75, 1, 484);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBounds(340, 36, 12, 553);
		contentPane.add(separator_1);
		
		JLabel lblNewLabel_1 = new JLabel("Register Student");
		lblNewLabel_1.setForeground(new Color(25, 25, 112));
		lblNewLabel_1.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 25));
		lblNewLabel_1.setBounds(374, 36, 326, 55);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Full Name");
		lblNewLabel_2.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(373, 119, 98, 16);
		contentPane.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 13));
		textField.setBounds(374, 140, 235, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Email Address");
		lblNewLabel_3.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(374, 174, 180, 16);
		contentPane.add(lblNewLabel_3);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 13));
		textField_1.setBounds(374, 195, 235, 26);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Password");
		lblNewLabel_4.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(374, 232, 97, 16);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_6 = new JLabel("Password didn't match");
		lblNewLabel_6.setForeground(Color.RED);
		lblNewLabel_6.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 11));
		lblNewLabel_6.setBounds(621, 328, 179, 16);
		contentPane.add(lblNewLabel_6);
		
		lblNewLabel_6.setVisible(false);
		
		Vector<String> courseData = CourseFunction.getCourseNames();
		JComboBox<String> comboBox = new JComboBox<>(courseData);
		comboBox.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 13));
		comboBox.setBounds(625, 141, 213, 27);
		contentPane.add(comboBox);
		
        JPasswordField passwordField = new JPasswordField();
        passwordField.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 13));
        passwordField.setBounds(376, 259, 237, 26);
        contentPane.add(passwordField);

		
		JLabel lblNewLabel_5 = new JLabel("Confirm Password");
		lblNewLabel_5.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 14));
		lblNewLabel_5.setBounds(379, 294, 146, 16);
		contentPane.add(lblNewLabel_5);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 13));
		passwordField_1.setBounds(374, 322, 235, 26);
		contentPane.add(passwordField_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("Course");
		lblNewLabel_2_1.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 14));
		lblNewLabel_2_1.setBounds(635, 119, 98, 16);
		contentPane.add(lblNewLabel_2_1);
		
		String username = textField.getText();
        String email = textField_1.getText();
        String password = passwordField.getText();
        String confirmPassword = passwordField_1.getText();
        String course = comboBox.getSelectedItem().toString();
		
        SharedData share = new SharedData();
        String name = share.getName();
        System.out.println(name);
        
		 JButton btnNewButton = new JButton("Register");
	        btnNewButton.addActionListener(new ActionListener() {
	        	// Inside the actionPerformed method of RegisterPage class
	        	public void actionPerformed(ActionEvent e) {
	        	    String username = textField.getText();
	        	    String email = textField_1.getText();
	        	    String password = new String(passwordField.getPassword());
	        	    String confirmPassword = new String(passwordField_1.getPassword());
	        	    String course = comboBox.getSelectedItem().toString();

	        	    if (!RegisterStudent.validate(password)) {
	        	        JOptionPane.showMessageDialog(contentPane, "Password must contain at least one uppercase letter, one symbol, one number, and be at least 8 characters long.", "Password Error",
	        	                JOptionPane.ERROR_MESSAGE);
	        	        return;
	        	    }
	        	    if (confirmPassword.equals(password)) {
	        	        boolean success = RegisterStudent.registerUser(username, password, email, course);
	        	        if (success) {
	        	            // Show success message
	        	            JOptionPane.showMessageDialog(contentPane, "Student registered successfully!", "Success",
	        	                    JOptionPane.INFORMATION_MESSAGE);
	        	            if (name == null) {	        	            	
	    	                    // If the name is null, redirect to the login page
	    	                    LoginPage login = new LoginPage();
	    	                    login.setVisible(true);
	    	                    dispose();
	    	                } else {
	    	                    // If the name is not null, redirect to the student page	    	                	
	    	                    Student stud = new Student();
	    	                    stud.setVisible(true);
	    	                    dispose();
	    	                }
	        	        } else {
	        	            // Show error message
	        	            JOptionPane.showMessageDialog(contentPane, "Error occurred during registration!", "Error",
	        	                    JOptionPane.ERROR_MESSAGE);
	        	        }
	        	    } else {
	        	        // Show password mismatch error
	        	        lblNewLabel_6.setVisible(true);
	        	    }             
	        	}

	        });
	        btnNewButton.setBackground(Color.LIGHT_GRAY);
	        btnNewButton.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 15));
	        btnNewButton.setBounds(681, 495, 119, 42);
	        contentPane.add(btnNewButton);
	        
	        

	        JButton btnCancel = new JButton("Cancel");
	        btnCancel.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                if (name == null) {
	                    // If the name is null, redirect to the login page
	                    LoginPage login = new LoginPage();
	                    login.setVisible(true);
	                    dispose();
	                } else {
	                    // If the name is not null, redirect to the student page
	                    Student stud = new Student();
	                    stud.setVisible(true);
	                    dispose();
	                }
	            }
	        });
	        btnCancel.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 15));
	        btnCancel.setBackground(Color.LIGHT_GRAY);
	        btnCancel.setBounds(550, 495, 119, 42);
	        contentPane.add(btnCancel);

		
		
		
		
		
		
		setLocationRelativeTo(null);
		
		
		
	}
}
