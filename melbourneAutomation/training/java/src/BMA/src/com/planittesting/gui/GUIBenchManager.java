package com.planittesting.gui;

import com.planittesting.bma.BenchManagerApplication;
import com.planittesting.bma.Employee;
//import com.planittesting.bma.iBenchManagerApplication;

import javax.swing.*;
import java.awt.*;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;


public class GUIBenchManager extends JFrame {

    // -----------------------------------------------------------------
    // Constants
    // -----------------------------------------------------------------

    public final static String MAIN_TITLE = "Bench Management Operations";
    public final static String ERROR_REMOVE = "Consultant not found.";
    public final static String ERROR_ADD = "Consultant could not be created";
    public final static String CONFIRMATION_REMOVE = "Consultant removed.";
    public final static String CONFIRMATION_ADD = "New Consultant Added.";
    public final static String ERROR_DATE_FORMAT = "Date Format Error";

    // -----------------------------------------------------------------
    // Attributes
    // -----------------------------------------------------------------

    private iBenchManagerApplication benchManager;
    private PanelImage panelImage;
    private PanelBench panelBench;

    // -----------------------------------------------------------------
    // Constructors
    // -----------------------------------------------------------------

    public GUIBenchManager() {
        benchManager = new BenchManagerApplication();

        setTitle(MAIN_TITLE);
        setSize(470, 480);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel centralpanel = new JPanel();
        centralpanel.setLayout(new BorderLayout());

        panelImage = new PanelImage();
        add(panelImage, BorderLayout.NORTH);

        panelBench = new PanelBench(this);
        add(panelBench, BorderLayout.CENTER);

       // updateInformation();
    }

    // -----------------------------------------------------------------
    // Methods
    // -----------------------------------------------------------------

    public void addConsultantHoursDialog() {
        AddConsultantHoursDialog dialog = new AddConsultantHoursDialog(this);
        dialog.setVisible(true);
    }

    public void addConsultantAssignDialog() {
        AssignConsultantDialog dialog = new AssignConsultantDialog(this);
        dialog.setVisible(true);
    }

    public void addConsultantDialog() {
        AddConsultantDialog dialog = new AddConsultantDialog(this);
        dialog.setVisible(true);
    }

    public void removeConsultantDialog() {
        RemoveConsultantDialog dialog = new RemoveConsultantDialog(this);
        dialog.setVisible(true);
    }

    public String getAverageHoursWorked() {
        return "" + benchManager.getHoursAverage();

    }

    public String getBusiestConsultant() {
        return "Bench's Busiest Consultant: " + benchManager.getBusiestEmployee().getFullName();

    }

    public void removeConsultant(String fullName) {

        if (!benchManager.removeEmployee(fullName)) {
            JOptionPane.showMessageDialog(this, ERROR_REMOVE, "Error", JOptionPane.ERROR_MESSAGE);
            updateInformation();
        } else {
            updateInformation();
            JOptionPane.showMessageDialog(this, CONFIRMATION_REMOVE, "Success", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void addConsultant(String fullName, String joinDate) {


        try {
			/*
			 * if (!benchManager.addEmployee(fullName, joinDate)) { //
			 * JOptionPane.showMessageDialog(this, ERROR_ADD, "Error",
			 * JOptionPane.OK_OPTION); JOptionPane.showMessageDialog(this, ERROR_ADD,
			 * "Error", JOptionPane.ERROR_MESSAGE); updateInformation();
			 */
               if (!benchManager.addEmployee(fullName, joinDate)) {
                   JOptionPane.showMessageDialog(this, ERROR_ADD, "Error", JOptionPane.ERROR_MESSAGE);
                   updateInformation();
            } else {
               updateInformation();
                JOptionPane.showMessageDialog(this, CONFIRMATION_ADD, "Success", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (DateTimeParseException e) {
            JOptionPane.showMessageDialog(this, ERROR_DATE_FORMAT, "Format Error", JOptionPane.INFORMATION_MESSAGE);

        }
    }

//modified
    public void updateInformation() {

        ArrayList<Employee> employees = benchManager.getEmployees();


        panelBench.refresh_consultants(employees, benchManager.getNumberOfEmployeeAvailable());
        if (!employees.isEmpty()) {
            panelBench.changeConsultantSelected(employees.get(0));
        }
		/*
		 * else if (employees.isEmpty()){ JOptionPane.showMessageDialog(this, ERROR_ADD,
		 * "Error", JOptionPane.ERROR_MESSAGE); // e.printStackTrace(); }
		 */
    }

    public void addConsultantHours(String name, String hours) {

        try {
            benchManager.addWorkHoursToEmployee(name, Integer.parseInt(hours));
           updateInformation();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "work in progress.", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    public void assignConsultant(String name, boolean assign) {

        try {
            benchManager.assignEmployee(name, assign);
          updateInformation();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "work in progress.", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }


    // -----------------------------------------------------------------
    // Main
    // -----------------------------------------------------------------

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            GUIBenchManager window = new GUIBenchManager();
            window.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getTotalSalary() {
        return "Total Salary: " + benchManager.getTotalSalary();

    }

    public String getBMSalary() {
        return "Bench Manager Salary: " + benchManager.getBMSalary();
    }
}
