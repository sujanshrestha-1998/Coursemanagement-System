package com.coursemanagement;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Profile extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Profile frame = new Profile();
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
	public Profile() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 518, 442);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		SharedData shared = new SharedData();
		String name = shared.getName();
		
		RetrieveData retrieve = new RetrieveData();
		String email = retrieve.retrieveEmail(name);
		
		JLabel lblNewLabel = new JLabel("User Profile");
		lblNewLabel.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 20));
		lblNewLabel.setBounds(25, 19, 150, 34);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name: "+ name);
		lblNewLabel_1.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(35, 65, 222, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Email: ");
		lblNewLabel_2.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(35, 93, 222, 16);
		contentPane.add(lblNewLabel_2);
		
		
		
		JLabel lblNewLabel_2_1 = new JLabel("Old Password");
		lblNewLabel_2_1.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 15));
		lblNewLabel_2_1.setBounds(35, 194, 113, 16);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblChangePassowrd = new JLabel("Change Passowrd");
		lblChangePassowrd.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 15));
		lblChangePassowrd.setBounds(25, 148, 195, 34);
		contentPane.add(lblChangePassowrd);
		
		
		JLabel lblNewLabel_3 = new JLabel("New Passowrd");
		lblNewLabel_3.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(35, 260, 113, 16);
		contentPane.add(lblNewLabel_3);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(45, 222, 175, 26);
		contentPane.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(45, 288, 175, 26);
		contentPane.add(passwordField_1);
		setLocationRelativeTo(null);
		
		
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
		lblNewLabel_7.setBounds(293, 19, 189, 200);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_5 = new JLabel("Invalid");
		lblNewLabel_5.setForeground(new Color(255, 0, 0));
		lblNewLabel_5.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 11));
		lblNewLabel_5.setBounds(55, 326, 142, 16);
		contentPane.add(lblNewLabel_5);
		lblNewLabel_5.setVisible(false);
		
		
		String dbpassword = retrieve.retrievePassword(name);
		
		
		
		JButton btnNewButton = new JButton("Reset");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String enteredPassword = new String(passwordField.getPassword());
                String dbPassword = retrieve.retrievePassword(name); 


                if (enteredPassword.equals(dbPassword)) {
                    String newPassword = new String(passwordField_1.getPassword());

                    if (RegisterStudent.validate(newPassword)) {
                        retrieve.changePassword(newPassword); 
                        dispose(); 
                    } else {
                        lblNewLabel_5.setVisible(true); 
                    }
                } else {
                    lblNewLabel_5.setVisible(true); 
                }
            }
        });
        btnNewButton.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 13));
        btnNewButton.setBounds(129, 354, 117, 29);
        contentPane.add(btnNewButton);

		
		JLabel lblNewLabel_4 = new JLabel(email);
		lblNewLabel_4.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 13));
		lblNewLabel_4.setBounds(35, 115, 246, 16);
		contentPane.add(lblNewLabel_4);
		

		
		JLabel lblNewLabel_6 = new JLabel("Enrolled Status:");
		lblNewLabel_6.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 13));
		lblNewLabel_6.setBounds(328, 210, 123, 16);
		contentPane.add(lblNewLabel_6);
		
		
		JButton btnNewButton_1 = new JButton("Enroll");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EnrollPage enroll = new EnrollPage();
				enroll.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 13));
		btnNewButton_1.setBounds(334, 255, 117, 29);
		contentPane.add(btnNewButton_1);
		
		
		
		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 13));
		lblNewLabel_8.setBounds(328, 231, 154, 16);
		contentPane.add(lblNewLabel_8);
		
		String status = EnrollFunction.isEnrolled(name) ? "Enrolled" : "Not Enrolled";
		lblNewLabel_8.setText(status);
		
		SharedData share = new SharedData();
		String role = share.getUserRole();
		String username = share.getName();
		
		EnrollFunction enroll = new EnrollFunction();
		String sem = enroll.selectSemester(name);
		
		JLabel lblNewLabel_2_2 = new JLabel("Semester: "+sem);
		lblNewLabel_2_2.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 12));
		lblNewLabel_2_2.setBounds(35, 134, 222, 16);
		contentPane.add(lblNewLabel_2_2);
		
		btnNewButton_1.setVisible(false);
		lblNewLabel_6.setVisible(false);
		lblNewLabel_8.setVisible(false);
		
		
		
		if("Student".equals(role)) {
			lblNewLabel_6.setVisible(true);
			lblNewLabel_8.setVisible(true );
			btnNewButton_1.setVisible(true);
			if("Enrolled".equals(status)) {
				btnNewButton_1.setVisible(false);
			}
			if("Not Enrolled".equals(status)) {
				btnNewButton_1.setVisible(true);
			}
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
