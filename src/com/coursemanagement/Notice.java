package com.coursemanagement;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JMenuBar;
import java.awt.TextField;
import java.awt.TextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Notice extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Notice frame = new Notice();
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
	public Notice() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 515, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Add Notice:");
		lblNewLabel.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 16));
		lblNewLabel.setBounds(48, 22, 142, 16);
		contentPane.add(lblNewLabel);
		
		TextArea textArea = new TextArea();
		textArea.setBackground(new Color(255, 255, 255));
		textArea.setForeground(new Color(0, 0, 0));
		textArea.setBounds(10, 44, 499, 179);
		contentPane.add(textArea);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String noticearea = textArea.getText();
				NoticeService service = new NoticeService();
				service.addNotice(noticearea);
				dispose();
			}
		});
		btnNewButton.setBounds(392, 229, 117, 29);
		contentPane.add(btnNewButton);
		
		
		
		
		setLocationRelativeTo(null);
	}
}
