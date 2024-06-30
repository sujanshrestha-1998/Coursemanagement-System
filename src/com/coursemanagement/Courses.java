package com.coursemanagement;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;
import java.awt.SystemColor;




public class Courses extends JFrame {
	
	

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel resultLabel;
	private JScrollPane scrollPane; // Declare JScrollPane for scrolling the JLabel
    private JLabel courseInfoLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Courses frame = new Courses();
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
	public Courses() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1010, 682);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(286, 97, 19, 494);
		contentPane.add(separator);
		
		JLabel lblNewLabel_1 = new JLabel("Course");
		lblNewLabel_1.setForeground(new Color(25, 25, 112));
		lblNewLabel_1.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 28));
		lblNewLabel_1.setBounds(325, 55, 119, 26);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Dashboard");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Dashboard dashboard = new Dashboard();
				dashboard.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 17));
		btnNewButton.setBounds(84, 240, 129, 46);
		contentPane.add(btnNewButton);
		
		JButton btnCourses = new JButton("Course");
		btnCourses.setForeground(new Color(0, 0, 0));
		btnCourses.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 17));
		btnCourses.setBounds(84, 298, 129, 46);
		contentPane.add(btnCourses);
		
		JButton btnTutors = new JButton("Tutors");
		btnTutors.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tutor tutor = new Tutor();
				tutor.setVisible(true);
				dispose();
			}
		});
		btnTutors.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 17));
		btnTutors.setBounds(84, 356, 129, 46);
		contentPane.add(btnTutors);
		
		ImageIcon originalIcon1 = new ImageIcon("/Users/sujanshrestha/Desktop/College/Second Year/Semester I/Object Oriented Programming/CourseManagementSystem/Images/logout.jpg");
		
		int maxWidth1 = 30;
		int maxHeight1 = 30;


		int originalWidth1 = originalIcon1.getIconWidth();
		int originalHeight1 = originalIcon1.getIconHeight();
		double aspectRatio1 = (double) originalWidth1 / originalHeight1;

		int newWidth1 = Math.min(maxWidth1, (int) (maxHeight1 * aspectRatio1));
		int newHeight1 = Math.min(maxHeight1, (int) (maxWidth1 / aspectRatio1));

		Image scaledImage1 = originalIcon1.getImage().getScaledInstance(newWidth1, newHeight1, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon1 = new ImageIcon(scaledImage1);

		btnTutors.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 17));
		btnTutors.setBounds(84, 355, 129, 46);
		contentPane.add(btnTutors);
		
		
		JButton btnLogout = new JButton(scaledIcon1);
		btnLogout.setText("Logout");
		btnLogout.setHorizontalAlignment(SwingConstants.LEFT);
		btnLogout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int choice = JOptionPane.showConfirmDialog(contentPane, "Are you sure you want to logout?", "Logout Confirmation", JOptionPane.YES_NO_OPTION);
                if (choice == JOptionPane.YES_OPTION) {
                	SharedData share = new SharedData();
                	share.setName(null);
                	LoginPage login = new LoginPage();
                    login.setVisible(true);
                    dispose();
                }
                
            }
        });
        btnLogout.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 17));
        btnLogout.setBounds(84, 471, 129, 46);
        contentPane.add(btnLogout);
        btnLogout.setFocusPainted(false);
        btnLogout.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 17));
        btnLogout.setBounds(84, 469, 129, 46);
        contentPane.add(btnLogout);
		
		setLocationRelativeTo(null);
		btnNewButton.setFocusPainted(false);
		btnTutors.setFocusPainted(false);
		btnCourses.setFocusPainted(false);
		btnLogout.setFocusPainted(false);
		
		
		ImageIcon originalIcon_ = new ImageIcon("/Users/sujanshrestha/Desktop/College/Second Year/Semester I/Object Oriented Programming/CourseManagementSystem/Images/trinity.jpg");
		
		int maxWidth_ = 150;
		int maxHeight_ = 150;


		int originalWidth_ = originalIcon_.getIconWidth();
		int originalHeight_ = originalIcon_.getIconHeight();
		double aspectRatio_ = (double) originalWidth_ / originalHeight_;

		int newWidth_ = Math.min(maxWidth_, (int) (maxHeight_ * aspectRatio_));
		int newHeight_ = Math.min(maxHeight_, (int) (maxWidth_ / aspectRatio_));

		Image scaledImage_ = originalIcon_.getImage().getScaledInstance(newWidth_, newHeight_, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon_ = new ImageIcon(scaledImage_);
		
		JLabel lblNewLabel_7 = new JLabel(scaledIcon_);
		lblNewLabel_7.setBounds(55, 19, 189, 200);
		contentPane.add(lblNewLabel_7);
		
		JButton btnStudents = new JButton("Students");
		btnStudents.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Student stud = new Student();
				stud.setVisible(true);
				dispose();
			}
		});
		btnStudents.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 17));
		btnStudents.setFocusPainted(false);
		btnStudents.setBounds(84, 414, 129, 46);
		contentPane.add(btnStudents);

		
		ImageIcon originalIcon2 = new ImageIcon("/Users/sujanshrestha/Desktop/College/Second Year/Semester I/Object Oriented Programming/CourseManagementSystem/Images/books.jpg");
		
		int maxWidth2 = 60;
		int maxHeight2 = 60;


		int originalWidth2 = originalIcon2.getIconWidth();
		int originalHeight2 = originalIcon2.getIconHeight();
		double aspectRatio2 = (double) originalWidth2 / originalHeight2;

		int newWidth2 = Math.min(maxWidth2, (int) (maxHeight2 * aspectRatio2));
		int newHeight2 = Math.min(maxHeight2, (int) (maxWidth2 / aspectRatio2));

		Image scaledImage2 = originalIcon2.getImage().getScaledInstance(newWidth2, newHeight2, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon2 = new ImageIcon(scaledImage2);
		
		JLabel lblNewLabel = new JLabel(scaledIcon2);
		lblNewLabel.setBounds(442, 44, 61, 43);
		contentPane.add(lblNewLabel);
		
		
		btnStudents.setVisible(false);
		
		JButton btnNewButton_1 = new JButton("Add Course");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Addcourse add =  new Addcourse();
				add.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 13));
		btnNewButton_1.setBounds(722, 97, 129, 29);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Remove Course");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					Deletecourse delete = new Deletecourse();
					delete.setVisible(true);
			}
		});
		btnNewButton_1_1.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 13));
		btnNewButton_1_1.setBounds(851, 97, 129, 29);
		contentPane.add(btnNewButton_1_1);
		
		

		
		JButton btnNewButton_2 = new JButton("Manage Modules");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManageModules module = new ManageModules();
				module.setVisible(true);
			}
		});
		btnNewButton_2.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 13));
		btnNewButton_2.setBounds(722, 126, 258, 29);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_4 = new JButton("Add Marks");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Marks marks = new Marks();
				marks.setVisible(true);
			}
		});
        btnNewButton_4.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 13));
        btnNewButton_4.setBounds(752, 29, 117, 29);
        contentPane.add(btnNewButton_4);
        
        RoundedPanel panel_1_1 = new RoundedPanel(20);
        panel_1_1.setLayout(null);
        panel_1_1.setBackground(new Color(245, 245, 245));
        panel_1_1.setBounds(706, 188, 278, 391);
        contentPane.add(panel_1_1);
        panel_1_1.setVisible(false);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 25, 258, 327);  // Adjust the bounds accordingly
        scrollPane.setBorder(null);
        panel_1_1.add(scrollPane);
        
        resultLabel = new JLabel();
        scrollPane.setViewportView(resultLabel);
        resultLabel.setBackground(new Color(245, 245, 245));
        resultLabel.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 11));
        resultLabel.setOpaque(true);  // Make JLabel opaque to set background color
        

		btnNewButton_1.setVisible(false);
		btnNewButton_1_1.setVisible(false);
		btnNewButton_2.setVisible(false);
		btnNewButton_4.setVisible(false);
		
        JLabel lblNewLabel_3 = new JLabel("New label");
        lblNewLabel_3.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 14));
        lblNewLabel_3.setBounds(325, 155, 369, 16);
        contentPane.add(lblNewLabel_3);
        lblNewLabel_3.setVisible(false);
		
		
		

		SharedData share = new SharedData();
		String userRole = share.getUserRole();
		String username = share.getName();
        
		if ("Admin".equals(userRole) || "Teacher".equals(userRole)) {
		    btnStudents.setVisible(true);
		   
		    
		}
		
		if("Teacher".equals(userRole)) {
			 btnNewButton_4.setVisible(true);
		}
		
		if ("Admin".equals(userRole)) {
		    btnNewButton_1.setVisible(true);
		    btnNewButton_1_1.setVisible(true);
		    btnNewButton_2.setVisible(true);
		}
		
		RoundedPanel panel_1 = new RoundedPanel(20);
        panel_1.setLayout(null);
        panel_1.setBackground(new Color(245, 245, 245));
        panel_1.setBounds(317, 189, 377, 391);
        contentPane.add(panel_1);
        
        RoundedPanel panel_1_2 = new RoundedPanel(20);
        panel_1_2.setLayout(null);
        panel_1_2.setBackground(new Color(245, 245, 245));
        panel_1_2.setBounds(317, 189, 377, 391);
        contentPane.add(panel_1_2);
        
        Vector<String> courseData = CourseFunction.getCourseNames(); // For Admin
        JComboBox<String> comboBox = new JComboBox<>(courseData);
        comboBox.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 13));
        comboBox.setBounds(317, 116, 375, 27);

        String selectedCourse = (String) comboBox.getSelectedItem();
        panel_1.removeAll();
        panel_1.revalidate();
        panel_1.repaint();
        JLabel courseInfoLabel = new JLabel();
        courseInfoLabel.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 13));
        JScrollPane scrollPane1 = new JScrollPane(courseInfoLabel);
        scrollPane1.setBounds(10, 25, 358, 327);
        scrollPane1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane1.setBackground(panel_1.getBackground());
        scrollPane1.setBorder(null);
        scrollPane1.getViewport().setBackground(panel_1.getBackground());
        panel_1.add(scrollPane1);
        CourseFunction.displayCourseInformation(courseInfoLabel, selectedCourse);

        comboBox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    String selectedCourse = (String) comboBox.getSelectedItem();
                    panel_1.removeAll();
                    panel_1.revalidate();
                    panel_1.repaint();
                    JLabel courseInfoLabel = new JLabel();
                    courseInfoLabel.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 13));
                    JScrollPane scrollPane = new JScrollPane(courseInfoLabel);
                    scrollPane.setBounds(10, 25, 358, 327);
                    scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
                    scrollPane.setBackground(panel_1.getBackground());
                    scrollPane.setBorder(null);
                    scrollPane.getViewport().setBackground(panel_1.getBackground());
                    panel_1.add(scrollPane);
                    CourseFunction.displayCourseInformation(courseInfoLabel, selectedCourse);
                }
            }
        });
        contentPane.add(comboBox);
		comboBox.setVisible(false); // End
		
		if("Teacher".equals(userRole)) {
			
		EnrollFunction enroll = new EnrollFunction();
		String teacherCourse = enroll.selectCourseTeacher(username);
		lblNewLabel_3.setText(teacherCourse);
		JLabel courseInfoLabel1 = new JLabel();
        courseInfoLabel1.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 13));
        JScrollPane scrollPane2 = new JScrollPane(courseInfoLabel1);
        scrollPane2.setBounds(10, 25, 358, 327);
        scrollPane2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane2.setBackground(panel_1.getBackground());
        scrollPane2.setBorder(null);
        scrollPane2.getViewport().setBackground(panel_1_2.getBackground());
        panel_1_2.add(scrollPane2);
        CourseFunction.displayCourseInformation(courseInfoLabel1, teacherCourse); // Corrected variable name courseInfoLabel1
		}
		
		if("Student".equals(userRole)) {
			EnrollFunction enroll = new EnrollFunction();
			String studentcourse = enroll.selectCourse(username);
			lblNewLabel_3.setText(studentcourse);
			JLabel courseInfoLabel1 = new JLabel();
	        courseInfoLabel1.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 13));
	        JScrollPane scrollPane2 = new JScrollPane(courseInfoLabel1);
	        scrollPane2.setBounds(10, 25, 358, 327);
	        scrollPane2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	        scrollPane2.setBackground(panel_1.getBackground());
	        scrollPane2.setBorder(null);
	        scrollPane2.getViewport().setBackground(panel_1_2.getBackground());
	        panel_1_2.add(scrollPane2);
	        CourseFunction.displayCourseInformation(courseInfoLabel1, studentcourse); // Corrected variable name courseInfoLabel1
			}
  
        panel_1.setVisible(false);
        panel_1_2.setVisible(false);
        
       
        
        if("Admin".equals(userRole)) {
        	panel_1.setVisible(true);
            panel_1_2.setVisible(false);
            lblNewLabel_3.setVisible(false);

           
            comboBox.setVisible(true);
        } 
        if("Teacher".equals(userRole) || "Student".equals(userRole)) {
        	panel_1.setVisible(false);
            panel_1_2.setVisible(true);
            lblNewLabel_3.setVisible(true);

            
        }


        
        
        JLabel lblResult = new JLabel("Result");
        lblResult.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 14));
        lblResult.setBounds(812, 160, 119, 16);
        contentPane.add(lblResult);
        lblResult.setVisible(false);
        
        JLabel lblNewLabel_2 = new JLabel("Name: " + username);
        lblNewLabel_2.setBounds(10, 6, 258, 16);
        panel_1_1.add(lblNewLabel_2);
        lblNewLabel_2.setBackground(new Color(245, 245, 245));
        lblNewLabel_2.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 13));
        lblNewLabel_2.setVisible(false);
        
       

        
       
        
        JButton btnNewButton_3 = new JButton("Print Result");
        btnNewButton_3.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		panel_1_1.setVisible(true);
        		lblResult.setVisible(true);
        		lblNewLabel_2.setVisible(true);
        		MarksFunction marks = new MarksFunction();
        		marks.printResult(resultLabel,username);
        	}
        });
        btnNewButton_3.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 13));
        btnNewButton_3.setBounds(863, 29, 117, 29);
        contentPane.add(btnNewButton_3);
        
        btnNewButton_3.setVisible(false);
        
        String userrole = share.getUserRole();
        if ("Student".equals(userrole)) {
        	btnNewButton_3.setVisible(true);
        }
        
        
        

        
        
        
        
		
			
		}
	}

