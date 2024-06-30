package com.coursemanagement;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Deletecourse extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Deletecourse frame = new Deletecourse();
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
	public Deletecourse() {
		setTitle("Remove Course");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 324, 176);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Course Name");
		lblNewLabel.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 13));
		lblNewLabel.setBounds(49, 25, 121, 16);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 13));
		textField.setBounds(31, 53, 247, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Remove");
		btnNewButton.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 13));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = textField.getText();
				CourseFunction function = new CourseFunction();
				if(function.deleteCourse(name, true)) {
					dispose();
				}
			}
		});
		btnNewButton.setBounds(98, 93, 117, 29);
		contentPane.add(btnNewButton);
		setLocationRelativeTo(null);
	}
	

}
