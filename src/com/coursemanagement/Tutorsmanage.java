package com.coursemanagement;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;

public class Tutorsmanage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private JTextPane textPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tutorsmanage frame = new Tutorsmanage();
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
	public Tutorsmanage() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 525, 520);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		RetrieveData retrieveData = new RetrieveData();
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Add Teacher +");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddTutors addtutor = new AddTutors();
				addtutor.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 13));
		btnNewButton.setBounds(17, 45, 143, 29);
		contentPane.add(btnNewButton);
		
		JButton btnDeleteTutors = new JButton("Delete Teacher -");
		btnDeleteTutors.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteTutors del = new DeleteTutors();
				del.setVisible(true);
				dispose();
			}
		});
		btnDeleteTutors.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 13));
		btnDeleteTutors.setBounds(158, 45, 143, 29);
		contentPane.add(btnDeleteTutors);
                JScrollPane scrollPane = new JScrollPane();
                scrollPane.setBounds(27, 86, 468, 393);
                contentPane.add(scrollPane);
                scrollPane.setBorder(null);
                
                RoundedPanel dataPanel = new RoundedPanel(20);
                scrollPane.setColumnHeaderView(dataPanel);
                dataPanel.setLayout(new BorderLayout());
                dataPanel.setBackground(new Color(245, 245, 245));
                
                        textPane = new JTextPane();
                        scrollPane.setViewportView(textPane);
                        textPane.setEditable(false);
                        textPane.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 13));
                        textPane.setBackground(new Color(245, 245, 245));
                        textPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
                        textPane.setMargin(new Insets(10, 10, 10, 10));
                        textPane.setText(generateAllTeacherData());

		
		setLocationRelativeTo(null);
	}
	
	private String generateAllTeacherData() {
	    List<String> allCourses = CourseFunction.getCourseNames();
	    StringBuilder allTeacherData = new StringBuilder();
	    
	    for (String course : allCourses) {
	        allTeacherData.append("Course: ").append(course).append("\n\n");
	        
	        List<Teacher> teachers = ManageTutors.getTeachersByCourse(course);
	        
	        for (Teacher tutor : teachers) {
	            allTeacherData.append("Name: ").append(tutor.getName()).append("\n")
	                    .append("Module: ").append(tutor.getModule()).append("\n")
	                    .append("Email: ").append(tutor.getEmail()).append("\n\n");
	        }
	        
	        allTeacherData.append("\n");
	    }

	    return allTeacherData.toString();
	}

}
