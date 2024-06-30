package com.coursemanagement;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.awt.event.ActionEvent;

public class AddTutors extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddTutors frame = new AddTutors();
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
	public AddTutors() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 598, 406);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Full Name");
		lblNewLabel.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 13));
		lblNewLabel.setBounds(30, 37, 120, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 13));
		lblEmail.setBounds(30, 103, 120, 16);
		contentPane.add(lblEmail);
		
		textField = new JTextField();
		textField.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 13));
		textField.setBounds(30, 65, 203, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 13));
		textField_1.setBounds(30, 131, 210, 26);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblSetPassowrd = new JLabel("Set Passowrd");
		lblSetPassowrd.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 13));
		lblSetPassowrd.setBounds(30, 169, 120, 16);
		contentPane.add(lblSetPassowrd);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 13));
		textField_2.setBounds(30, 197, 203, 26);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblContactNo = new JLabel("Contact No.");
		lblContactNo.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 13));
		lblContactNo.setBounds(277, 37, 120, 16);
		contentPane.add(lblContactNo);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 13));
		textField_3.setBounds(277, 65, 161, 26);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblCourse = new JLabel("Course");
		lblCourse.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 13));
		lblCourse.setBounds(277, 103, 120, 16);
		contentPane.add(lblCourse);
		
		Vector<String> courseData = CourseFunction.getCourseNames();
		JComboBox<String> comboBox = new JComboBox<>(courseData);
		comboBox.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 13));
		comboBox.setBounds(275, 122, 308, 27);
		contentPane.add(comboBox);
		
		ManageTutors manage = new ManageTutors();
		
		JButton btnNewButton = new JButton("Register Teacher");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = textField.getText();
				String email = textField_1.getText();
				String password = textField_2.getText();
				String contact = textField_3.getText();
				String course = comboBox.getSelectedItem().toString();
				
				
				manage.addTutor(name, email, password, contact, course);
				System.out.println("Teacher Registered");
				Tutorsmanage tutors = new Tutorsmanage();
				tutors.setVisible(true);
				dispose();
				 
			}
		});
		btnNewButton.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 13));
		btnNewButton.setBounds(287, 319, 263, 29);
		contentPane.add(btnNewButton);
		setLocationRelativeTo(null); 
		


	}
}
