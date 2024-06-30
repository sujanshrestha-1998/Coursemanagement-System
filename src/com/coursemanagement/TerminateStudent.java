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
import java.awt.event.ActionEvent;

public class TerminateStudent extends JFrame {

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
					TerminateStudent frame = new TerminateStudent();
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
	public TerminateStudent() {
		setTitle("Terminate Student");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 307, 184);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Student Name");
		lblNewLabel.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 13));
		lblNewLabel.setBounds(94, 6, 149, 16);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 13));
		textField.setBounds(18, 34, 259, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Terminate");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = textField.getText();
				StudentAccess stud = new StudentAccess();
				stud.deleteStudentByName(name);
				dispose();
			}
		});
		btnNewButton.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 13));
		btnNewButton.setBounds(88, 85, 117, 29);
		contentPane.add(btnNewButton);
		setLocationRelativeTo(null);
	}
}
