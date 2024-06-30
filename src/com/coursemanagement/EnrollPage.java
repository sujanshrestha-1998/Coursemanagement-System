package com.coursemanagement;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class EnrollPage extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                EnrollPage frame = new EnrollPage();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public EnrollPage() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 488, 430);
        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        SharedData shared = new SharedData();
        String name = shared.getName();

        EnrollFunction func = new EnrollFunction();
        String course = func.selectCourse(name);

        JLabel lblNewLabel = new JLabel("Name: " + name);
        lblNewLabel.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 13));
        lblNewLabel.setBounds(32, 34, 256, 16);
        contentPane.add(lblNewLabel);

        JSeparator separator = new JSeparator();
        separator.setBounds(42, 62, 397, 12);
        contentPane.add(separator);

        JLabel lblSelectSemester = new JLabel("Select Semester:");
        lblSelectSemester.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 13));
        lblSelectSemester.setBounds(32, 120, 113, 16);
        contentPane.add(lblSelectSemester);
        
        JLabel lblOptionalModule = new JLabel("Optional Module");
        lblOptionalModule.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 13));
        lblOptionalModule.setBounds(236, 120, 113, 16);
        contentPane.add(lblOptionalModule);
        setLocationRelativeTo(null);
        lblOptionalModule.setVisible(false);
        
     // Add another JComboBox for optional modules
        JComboBox<String> optionalComboBox = new JComboBox<>();
        optionalComboBox.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 13));
        optionalComboBox.setBounds(225, 148, 135, 27);
        contentPane.add(optionalComboBox);
        optionalComboBox.setVisible(false); 


        JComboBox<String> comboBox = new JComboBox<>();
        comboBox.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 13));
        comboBox.setModel(new DefaultComboBoxModel<>(new String[] {"FirstSem", "SecondSem", "ThirdSem", "FourthSem", "FifthSem", "SixthSem"}));
        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox<?> comboBox = (JComboBox<?>) e.getSource();
                String selectedSemester = (String) comboBox.getSelectedItem();
                func.selectSemesters(selectedSemester);
                if ("FifthSem".equals(selectedSemester) || "SixthSem".equals(selectedSemester)) {
                    // Show the optional comboBox and populate it with optional modules
                    optionalComboBox.setVisible(true);
                    lblOptionalModule.setVisible(true);
                    populateOptionalModules(selectedSemester, optionalComboBox);
                } else {
                    // Hide the optional comboBox if the selected semester is not "FifthSem" or "SixthSem"
                    optionalComboBox.setVisible(false);
                    lblOptionalModule.setVisible(false);
                }
                

                // Display modules for the selected semester
                displayModules(selectedSemester);
            }
        });
        comboBox.setBounds(32, 148, 135, 27);
        contentPane.add(comboBox);

        JLabel lblNewLabel_1 = new JLabel("Modules");
        lblNewLabel_1.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 13));
        lblNewLabel_1.setBounds(32, 187, 61, 16);
        contentPane.add(lblNewLabel_1);

        JButton btnNewButton = new JButton("Enroll");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedSemester = (String) comboBox.getSelectedItem();
                if (selectedSemester != null) {
                    String optionalModule = null; // Initialize optional module variable

                    // Get the selected optional module if available
                    Object optionalModuleObject = optionalComboBox.getSelectedItem();
                    if (optionalModuleObject != null) {
                        optionalModule = optionalModuleObject.toString();
                    }

                    // Enroll the student and optionally set the optional module
                    EnrollFunction.enrollStudent(name, selectedSemester);
                    if (optionalModule != null) {
                        func.optionalModule(optionalModule);
                    }

                    dispose();
                } else {
                    System.err.println("No semester selected.");
                }
            }
        });
        btnNewButton.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 13));
        btnNewButton.setBounds(353, 351, 117, 29);
        contentPane.add(btnNewButton);


        JLabel lblCourse = new JLabel("Course: " + course);
        lblCourse.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 13));
        lblCourse.setBounds(32, 92, 256, 16);
        contentPane.add(lblCourse);
        
//        JComboBox comboBox_1 = new JComboBox();
//        comboBox_1.setBounds(225, 148, 135, 27);
//        contentPane.add(comboBox_1);
        
        
    }

 // Method to display modules for the selected semester
    private void displayModules(String semester) {
        // Remove existing JTextArea if present
        Component[] components = contentPane.getComponents();
        for (Component component : components) {
            if (component instanceof JTextArea) {
                contentPane.remove(component);
            }
        }

        JTextArea textArea = new JTextArea();
        textArea.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 13));
        textArea.setBounds(32, 220, 400, 100); // Adjust the bounds as needed
        textArea.setEditable(false); // Make the text area read-only

        // Clear JTextArea content before populating it with module information
        textArea.setText("");

        // Fetch and display module information based on the selected semester
        EnrollFunction func = new EnrollFunction();
        String moduleInfo = func.fetchModuleInfo(semester);
        textArea.setText(moduleInfo);

        // Add the JTextArea to the content pane
        contentPane.add(textArea);

        // Revalidate and repaint the content pane to reflect the changes
        contentPane.revalidate();
        contentPane.repaint();
    }
    
    
    private void populateModules(String semester, JComboBox<String> comboBox) {
        comboBox.removeAllItems(); // Clear existing items

        // Fetch modules for the selected semester
        ArrayList<String> modules = EnrollFunction.getModules(semester);

        // Populate comboBox_1 with modules
        for (String module : modules) {
            comboBox.addItem(module);
        }
    }

    // Method to populate optional modules in the optionalComboBox based on the selected semester
    private void populateOptionalModules(String semester, JComboBox<String> comboBox) {
        comboBox.removeAllItems(); // Clear existing items

        // Fetch optional modules for the selected semester
        ArrayList<String> optionalModules = EnrollFunction.getOptionalModules(semester);

        // Populate optionalComboBox with optional modules
        for (String module : optionalModules) {
            comboBox.addItem(module);
        }
    }

}
