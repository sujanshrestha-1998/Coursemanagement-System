package com.coursemanagement;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UpgradeStudent extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextArea textAreaPassed;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UpgradeStudent frame = new UpgradeStudent();
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
    public UpgradeStudent() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Create a JScrollPane and add the JTextArea to it
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 45, 414, 206);
        // Remove the border from the scroll pane
        scrollPane.setBorder(null);
        contentPane.add(scrollPane);

        textAreaPassed = new JTextArea();
        textAreaPassed.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 13));
        scrollPane.setViewportView(textAreaPassed);
        
        JLabel lblNewLabel = new JLabel("Passed Students Names");
        lblNewLabel.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 15));
        lblNewLabel.setBounds(28, 16, 209, 16);
        contentPane.add(lblNewLabel);
        
        JButton btnNewButton = new JButton("Upgrade");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Upgrade upgrade = new Upgrade();
        		upgrade.setVisible(true);
        	}
        });
        btnNewButton.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 13));
        btnNewButton.setBounds(275, 12, 117, 29);
        contentPane.add(btnNewButton);

        // Display the names of passed students
        displayPassedStudents();
        setLocationRelativeTo(null);
    }

    /**
     * Display the names of passed students in the text area.
     */
    private void displayPassedStudents() {
        ArrayList<String> passedStudents = MarksFunction.getPassedStudents();
        StringBuilder passedStudentsText = new StringBuilder();

        for (String student : passedStudents) {
            passedStudentsText.append(student).append("\n");
        }

        textAreaPassed.setText(passedStudentsText.toString());
    }
}
