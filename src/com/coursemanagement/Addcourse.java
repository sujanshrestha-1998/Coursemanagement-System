package com.coursemanagement;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSeparator;
import javax.swing.JTextArea;

public class Addcourse extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextArea textAreaSemesters;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Addcourse frame = new Addcourse();
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
	public Addcourse() {
		setTitle("Add Course");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 404, 217);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Course Name");
		lblNewLabel.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 13));
		lblNewLabel.setBounds(46, 18, 122, 16);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 13));
		textField.setBounds(56, 46, 301, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Duration");
		lblNewLabel_1.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(46, 84, 68, 16);
		contentPane.add(lblNewLabel_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 13));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"3", "4"}));
		comboBox.setBounds(113, 80, 68, 27);
		contentPane.add(comboBox);
		
		String duration = comboBox.getSelectedItem().toString();

		
		JButton btnNewButton = new JButton("Add Course");
		btnNewButton.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 13));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String coursename = textField.getText();
				String duration = comboBox.getSelectedItem().toString();
				
				

				CourseFunction function = new CourseFunction();
				boolean success = function.addCourse(coursename, duration);

				if (success) {
				    System.out.println("Course added successfully.");
				    dispose();
				} else {
				    System.out.println("Failed to add the course.");
				}
				
				if("3".equals(duration)) {
					function.addModuleThree(coursename);
				} else if("4".equals(duration)) {
					function.addModuleFour(coursename);
				}
				

				
			}
		});
		btnNewButton.setBounds(239, 130, 117, 29);
		contentPane.add(btnNewButton);
		
		

		setLocationRelativeTo(null);
	}
}
