package com.coursemanagement;

import java.awt.EventQueue;
import java.awt.Font;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AssignTutors extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AssignTutors frame = new AssignTutors();
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
	public AssignTutors() {
		setTitle("Assign Tutors");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 310, 285);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblNewLabel = new JLabel("Select Course");
		lblNewLabel.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 13));
		lblNewLabel.setBounds(33, 25, 120, 16);
		contentPane.add(lblNewLabel);
		
		Vector<String> courseData = CourseFunction.getCourseNames();
		JComboBox<String> comboBox = new JComboBox<>(courseData);
		comboBox.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 13));
		comboBox.setBounds(22, 53, 250, 27);
		contentPane.add(comboBox);

		
		JLabel lblNewLabel_1 = new JLabel("Teacher Name");
		lblNewLabel_1.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(33, 93, 176, 16);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 13));
		textField.setBounds(29, 112, 225, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Module Name");
		lblNewLabel_2.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(33, 143, 176, 16);
		contentPane.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 13));
		textField_1.setBounds(33, 166, 225, 26);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("Assign");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = textField.getText();
				String modulename = textField_1.getText();
				ManageTutors manage = new ManageTutors();
				manage.assignTutor(username, modulename);
				dispose();
			}
		});
		btnNewButton.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 13));
		btnNewButton.setBounds(95, 206, 117, 29);
		contentPane.add(btnNewButton);
		setLocationRelativeTo(null);
	}

}
