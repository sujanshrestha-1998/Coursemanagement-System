package com.coursemanagement;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DeleteTutors extends JFrame {

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
					DeleteTutors frame = new DeleteTutors();
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
	public DeleteTutors() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 292, 237);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tutor Name");
		lblNewLabel.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 13));
		lblNewLabel.setBounds(24, 16, 122, 16);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 13));
		textField.setBounds(34, 44, 215, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 13));
		lblPassword.setBounds(24, 82, 122, 16);
		contentPane.add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(34, 110, 215, 26);
		contentPane.add(passwordField);
		
		JButton btnNewButton = new JButton("Remove");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tutorName = textField.getText();
				String tutorPassword = passwordField.getText();
				ManageTutors manageTutor = new ManageTutors();
				if(manageTutor.deleteTutor(tutorName, tutorPassword)) {
					Tutorsmanage tutors = new Tutorsmanage();
					tutors.setVisible(true);
					dispose();
				}
				
			}
		});
		btnNewButton.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 14));
		btnNewButton.setBounds(78, 154, 117, 29);
		contentPane.add(btnNewButton);
		setLocationRelativeTo(null);
	}
}
