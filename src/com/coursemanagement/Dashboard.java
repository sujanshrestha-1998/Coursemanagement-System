package com.coursemanagement;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JToolBar;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.geom.RoundRectangle2D;
import java.util.List;

import javax.swing.JTextArea;
import javax.swing.Icon;

public class Dashboard extends JFrame {
	JTextArea noticeTextArea;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dashboard frame = new Dashboard();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private void loadNotices() {
	    NoticeService noticeService = new NoticeService();
	    List<String> notices = noticeService.retrieveNotices();
	    noticeTextArea.setText("");
	    for (String notice : notices) {
	        noticeTextArea.append(notice + "\n");
	    }
	}


	/**
	 * Create the frame.
	 */
	public Dashboard() {
		
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
		
		JLabel lblNewLabel_1 = new JLabel("Dashboard");
		lblNewLabel_1.setForeground(new Color(25, 25, 112));
		lblNewLabel_1.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 28));
		lblNewLabel_1.setBounds(325, 55, 185, 26);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Dashboard");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 17));
		btnNewButton.setBounds(84, 239, 129, 46);
		contentPane.add(btnNewButton);
		
		JButton btnCourses = new JButton("Course");
		btnCourses.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Courses course = new Courses();
				course.setVisible(true);
				dispose();
				
			}
		});
		btnCourses.setForeground(new Color(0, 0, 0));
		btnCourses.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 17));
		btnCourses.setBounds(84, 297, 129, 46);
		contentPane.add(btnCourses);
		
		JButton btnTutors = new JButton("Tutors");
		btnTutors.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tutor tutor = new Tutor();
				tutor.setVisible(true);
				dispose();
				
			}
		});
		
		
		setLocationRelativeTo(null);
		btnNewButton.setFocusPainted(false);
		btnTutors.setFocusPainted(false);
		btnCourses.setFocusPainted(false);
		
		
		RoundedPanel panel = new RoundedPanel(20);
		panel.setBounds(325, 110, 629, 303);
		panel.setBackground(new Color(245, 245, 245)); // Set background color as needed
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Notice!");
		lblNewLabel_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_2.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 18));
		lblNewLabel_2.setBounds(16, 17, 121, 16);
		panel.add(lblNewLabel_2);
		
		NoticeService disNotice = new NoticeService();
		
		noticeTextArea = new JTextArea();
		noticeTextArea.setWrapStyleWord(true);
		noticeTextArea.setLineWrap(true);
		noticeTextArea.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 13));
		noticeTextArea.setEditable(false);
		noticeTextArea.setBackground(new Color(245, 245, 245));
		noticeTextArea.setBounds(26, 45, 570, 232);
		panel.add(noticeTextArea);
		loadNotices();
	
		
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
		btnStudents.setBounds(84, 413, 129, 46);
		contentPane.add(btnStudents);
		btnStudents.setFocusPainted(false);
		btnStudents.setVisible(false);
		
		JButton btnNewButton_1 = new JButton("Add a Notice");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Notice notice = new Notice();
				notice.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 13));
		btnNewButton_1.setBounds(837, 69, 117, 29);
		contentPane.add(btnNewButton_1);
		btnNewButton_1.setFocusPainted(false);
		
		SharedData share = new SharedData();
		String displayName = share.getName();
		
		JLabel lblNewLabel = new JLabel("Welcome " + displayName+".");
		lblNewLabel.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 15));
		lblNewLabel.setBounds(325, 17, 352, 16);
		contentPane.add(lblNewLabel);
		
		btnNewButton_1.setVisible(false);

		ImageIcon originalIcon = new ImageIcon("/Users/sujanshrestha/Desktop/College/Second Year/Semester I/Object Oriented Programming/CourseManagementSystem/Images/profile.jpg");

		
		int maxWidth = 50;
		int maxHeight = 50;

		// Get the original image dimensions
		int originalWidth = originalIcon.getIconWidth();
		int originalHeight = originalIcon.getIconHeight();

		// Calculate the aspect ratio
		double aspectRatio = (double) originalWidth / originalHeight;

		int newWidth = Math.min(maxWidth, (int) (maxHeight * aspectRatio));
		int newHeight = Math.min(maxHeight, (int) (maxWidth / aspectRatio));

		Image scaledImage = originalIcon.getImage().getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);

		ImageIcon scaledIcon = new ImageIcon(scaledImage);
		JLabel lblNewLabel_3 = new JLabel(scaledIcon);
		lblNewLabel_3.setBounds(914, 4, 58, 54);
		contentPane.add(lblNewLabel_3);
		
		
		lblNewLabel_3.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		        Profile profile = new Profile();
		        profile.setVisible(true);
		    }
		});
		
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
                	share.setName(null);
                	LoginPage login = new LoginPage();
                    login.setVisible(true);
                    dispose();
                }
                
            }
        });
        btnLogout.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 17));
        btnLogout.setBounds(84, 471, 129, 46);
        contentPane.add(btnLogout);
        btnLogout.setFocusPainted(false);
		
		
		String userRole = share.getUserRole();
		
		
		if("Admin".equals(userRole) || "Teacher".equals(userRole)) {
			btnNewButton_1.setVisible(true);
			btnStudents.setVisible(true);
		}
		

		
	}
}


