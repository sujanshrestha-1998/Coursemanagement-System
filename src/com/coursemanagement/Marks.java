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

public class Marks extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lblNewLabel_2;
	private JTextField textField_2;
	private JLabel lblNewLabel_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Marks frame = new Marks();
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
	public Marks() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 309, 303);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Student Name");
		lblNewLabel.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 13));
		lblNewLabel.setBounds(40, 22, 133, 16);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 11));
		textField.setBounds(32, 46, 234, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Enter Marks");
		lblNewLabel_1.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(40, 84, 121, 16);
		contentPane.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 11));
		textField_1.setBounds(33, 113, 231, 26);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		lblNewLabel_2 = new JLabel("Module Name");
		lblNewLabel_2.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(40, 151, 150, 16);
		contentPane.add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 13));
		textField_2.setBounds(40, 179, 224, 26);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		lblNewLabel_2.setVisible(false);
		textField_2.setVisible(false);
		
		lblNewLabel_3 = new JLabel("Module Not Found");
		lblNewLabel_3.setForeground(Color.RED);
		lblNewLabel_3.setBackground(Color.WHITE);
		lblNewLabel_3.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 11));
		lblNewLabel_3.setBounds(40, 203, 133, 16);
		contentPane.add(lblNewLabel_3);
		
		lblNewLabel_3.setVisible(false);
		
		SharedData share = new SharedData();
		
		if("Admin".equals(share.getUserRole())) {
			lblNewLabel_2.setVisible(true);
			textField_2.setVisible(true);
		}
		
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = textField.getText();
				String mark = textField_1.getText();
				String module = textField_2.getText();
				MarksFunction marks = new MarksFunction();
				
				if("Admin".equals(share.getUserRole())) {
					marks.addResultAdmin(username, mark, module);
				}else {
					marks.addResultTeacher(username, mark);
				}
				
				dispose();
			}
		});
		btnNewButton.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 13));
		btnNewButton.setBounds(90, 240, 117, 29);
		contentPane.add(btnNewButton);
		

		
		
		
		setLocationRelativeTo(null);
		
		
	}

}
