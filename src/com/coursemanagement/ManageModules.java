package com.coursemanagement;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class ManageModules extends JFrame {

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
					ManageModules frame = new ManageModules();
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
	public ManageModules() {
		setTitle("Manage Courses");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 430);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"FirstSem", "SecondSem", "ThirdSem", "FourthSem", "FifthSem", "SixthSem", "SeventhSem", "EightSem"}));
		comboBox.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 13));
		comboBox.setBounds(23, 152, 149, 27);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel_1 = new JLabel("Module Name");
		lblNewLabel_1.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(23, 282, 109, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Select Semester");
		lblNewLabel_2.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(30, 124, 120, 16);
		contentPane.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 13));
		textField.setBounds(22, 305, 268, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Course");
		lblNewLabel_3.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(26, 50, 141, 16);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_5 = new JLabel("SuccessFully Removed");
		lblNewLabel_5.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 11));
		lblNewLabel_5.setBounds(156, 26, 134, 16);
		contentPane.add(lblNewLabel_5);
		
		lblNewLabel_5.setVisible(false);
		
		Vector<String> courseData = CourseFunction.getCourseNames();
		JComboBox<String> comboBox1 = new JComboBox<>(courseData);
		comboBox1.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 13));
		comboBox1.setBounds(22, 76, 342, 27);
		contentPane.add(comboBox1);

		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Module1", "Module2", "Module3", "Optional1", "Optional2"}));
		comboBox_1.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 13));
		comboBox_1.setBounds(211, 152, 149, 27);
		contentPane.add(comboBox_1);
		
		JButton btnRemoveModule = new JButton("Remove Module");
		btnRemoveModule.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String dbModule = comboBox1.getSelectedItem().toString();
				String sem = comboBox.getSelectedItem().toString();
				String modulecode = comboBox_1.getSelectedItem().toString();
				CourseFunction function = new CourseFunction();
				if(function.removeModuleValue(dbModule, modulecode, sem)) {
					lblNewLabel_5.setVisible(true);
				}
			}
		});
		btnRemoveModule.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 13));
		btnRemoveModule.setBounds(293, 201, 134, 29);
		contentPane.add(btnRemoveModule);
		
		JLabel lblNewLabel_2_1 = new JLabel("Select Module Code");
		lblNewLabel_2_1.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 13));
		lblNewLabel_2_1.setBounds(211, 124, 161, 16);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel = new JLabel("Added");
		lblNewLabel.setForeground(new Color(154, 205, 50));
		lblNewLabel.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 11));
		lblNewLabel.setBounds(23, 333, 61, 16);
		contentPane.add(lblNewLabel);
		lblNewLabel.setVisible(false);
		
		
		JButton btnNewButton = new JButton("Add Module");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblNewLabel_5.setVisible(false);
				String dbModule = comboBox1.getSelectedItem().toString();
				String module = textField.getText();
				String sem = comboBox.getSelectedItem().toString();
				String modulecode = comboBox_1.getSelectedItem().toString();
				CourseFunction function = new CourseFunction();
				if(function.updateModuleValues(dbModule, sem, module, modulecode)) {
					lblNewLabel.setVisible(true);
				}
				
			}
		});
		btnNewButton.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 13));
		btnNewButton.setBounds(295, 351, 134, 29);
		contentPane.add(btnNewButton);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(23, 258, 372, 12);
		contentPane.add(separator);
		
		
		
		
		
		
		
		
		
		
		
		
		setLocationRelativeTo(null);
	}
}
