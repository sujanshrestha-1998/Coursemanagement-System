package com.coursemanagement;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Upgrade extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Upgrade frame = new Upgrade();
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
    public Upgrade() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 283, 245);
        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JComboBox<String> comboBox = new JComboBox<>();
        comboBox.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 13));
        comboBox.setBounds(42, 36, 191, 27);
        contentPane.add(comboBox);
        
        JLabel lblNewLabel = new JLabel("Student");
        lblNewLabel.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 13));
        lblNewLabel.setBounds(42, 8, 61, 16);
        contentPane.add(lblNewLabel);
        
        JComboBox<String> comboBox_1 = new JComboBox<>();
        comboBox_1.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 13));
        comboBox_1.setModel(new DefaultComboBoxModel<String>(new String[] {"FirstSem", "SecondSem", "ThridSem", "FourthSem", "FifthSem", "SixthSem"}));
        comboBox_1.setBounds(42, 96, 191, 27);
        contentPane.add(comboBox_1);
        
        JLabel lblNewLabel_1 = new JLabel("Semester");
        lblNewLabel_1.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 13));
        lblNewLabel_1.setBounds(42, 75, 117, 16);
        contentPane.add(lblNewLabel_1);
        
        JButton btnNewButton = new JButton("Upgrade");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String name = comboBox.getSelectedItem().toString();
        		String sem = comboBox_1.getSelectedItem().toString();
        		
        		MarksFunction upgrade = new MarksFunction();
        		upgrade.Upgradestud(name, sem);
        		dispose();
        		
        		
        	}
        });
        btnNewButton.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 13));
        btnNewButton.setBounds(79, 163, 117, 29);
        contentPane.add(btnNewButton);
        
        
        
        // Populate the JComboBox with passed student names
        populateComboBox(comboBox);
        
        setLocationRelativeTo(null);
    }
    
    /**
     * Populate the JComboBox with passed student names.
     */
    private void populateComboBox(JComboBox<String> comboBox) {
        // Retrieve the list of passed students from MarksFunction
        ArrayList<String> passedStudents = MarksFunction.getPassedStudents();
        
        // Add passed student names to the JComboBox model
        for (String student : passedStudents) {
            comboBox.addItem(student);
        }
    }
}
