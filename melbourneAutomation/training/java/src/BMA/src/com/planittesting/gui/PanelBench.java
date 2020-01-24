package com.planittesting.gui;

import com.planittesting.bma.Employee;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class PanelBench extends JPanel implements ActionListener, ListSelectionListener {
    // -----------------------------------------------------------------
    // Constants
    // -----------------------------------------------------------------

    public final static String BENCH_TITLE = "Planit Testing Bench";
    public final static String ADD = "Add Time";
    public final static String REMOVE = "Assign";
    public final static String OPT1 = "Total Salary";
    public final static String OPT2 = "Get BM Salary";
    public final static String Available = "Unassigned Consultants: ";
    public final static String RemoveConsultant = "Remove";
    public final static String RemoveLbl = "Remove Consultant";
    public final static String AddConsultant = "Add";


    // -----------------------------------------------------------------
    // Attributes
    // -----------------------------------------------------------------

    private GUIBenchManager guiManager;

    private JScrollPane consultanScroll;
    private JScrollPane skillScroll;
    private JList consultants;
    private JList consultantSkills;

    private JLabel lblConsultantName;
    private JLabel lblConsultantHours;
    private JLabel lblUnassignedConsultants;

    private JLabel lblConsultantJoinDate;

    private JTextField txtConsultantName;
    private JTextField txtConsultantHours;
    private JTextField txtUnassignedConsultants;
    private JTextField txtConsultantJoinDate;

    private JButton btnAdd;
    private JButton btnRemove;
    private JButton btnOpt1;
    private JButton btnOpt2;
    private JButton btnAddConsultant;
    private JButton btnRemoveConsultant;

    // -----------------------------------------------------------------
    // Constructors
    // -----------------------------------------------------------------

    public PanelBench(GUIBenchManager manager) {
        this.guiManager = manager;
        setLayout(new BorderLayout());

        JPanel consultant = new JPanel();
        consultant.setLayout(new GridLayout(5, 1));
        consultant.setBorder(new EmptyBorder(10, 10, 10, 10));

        lblConsultantName = new JLabel("Consultant Name: ");
        consultant.add(lblConsultantName);
        txtConsultantName = new JTextField();
        txtConsultantName.setEditable(false);
        consultant.add(txtConsultantName);

        lblConsultantHours = new JLabel("Hours: ");
        consultant.add(lblConsultantHours);
        txtConsultantHours = new JTextField();
        txtConsultantHours.setEditable(false);
        consultant.add(txtConsultantHours);

        lblUnassignedConsultants = new JLabel(Available);
        consultant.add(lblUnassignedConsultants);


//        lblConsultantJoinDate = new JLabel( "Since: " );
//        consultant.add(lblConsultantJoinDate);
//        txtConsultantJoinDate = new JTextField( );
//        txtConsultantJoinDate.setEditable( false );
//        consultant.add(txtConsultantJoinDate);

        JPanel buttons = new JPanel();
        buttons.setBorder(new EmptyBorder(10, 10, 10, 10));
        buttons.setLayout(new GridLayout(2, 1));


        btnAddConsultant = new JButton(AddConsultant);
        btnAddConsultant.addActionListener(this);
        btnAddConsultant.setActionCommand(AddConsultant);
        buttons.add(btnAddConsultant);

        btnRemoveConsultant = new JButton(RemoveConsultant);
        btnRemoveConsultant.addActionListener(this);
        btnRemoveConsultant.setActionCommand(RemoveConsultant);
        buttons.add(btnRemoveConsultant);

        btnOpt2 = new JButton(OPT2);
        btnOpt2.addActionListener(this);
        btnOpt2.setActionCommand(OPT2);
        buttons.add(btnOpt2);

        btnRemove = new JButton(REMOVE);
        btnRemove.addActionListener(this);
        btnRemove.setActionCommand(REMOVE);
        buttons.add(btnRemove);

        btnAdd = new JButton(ADD);
        btnAdd.addActionListener(this);
        btnAdd.setActionCommand(ADD);
        buttons.add(btnAdd);

        btnOpt1 = new JButton(OPT1);
        btnOpt1.addActionListener(this);
        btnOpt1.setActionCommand(OPT1);
        buttons.add(btnOpt1);


        JPanel wrapper = new JPanel();
        wrapper.setLayout(new BorderLayout());
        wrapper.setBorder(new TitledBorder("Consultant Information Summary"));
        wrapper.add(consultant, BorderLayout.NORTH);
        wrapper.add(buttons, BorderLayout.SOUTH);

        JPanel scrollWrapper = new JPanel();
        scrollWrapper.setLayout(new GridLayout(2, 1));
        consultants = new JList();
        consultants.addListSelectionListener(this);
        consultants.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        consultants.setLayoutOrientation(JList.VERTICAL);
        consultants.setVisibleRowCount(-1);

        consultanScroll = new JScrollPane(consultants);
        setBorder(new TitledBorder(BENCH_TITLE));
        consultanScroll.setViewportView(consultants);
        consultanScroll.setVerticalScrollBarPolicy(javax.swing.JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        consultanScroll.setHorizontalScrollBarPolicy(javax.swing.JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollWrapper.add(consultanScroll);



        consultantSkills = new JList();
        consultantSkills.addListSelectionListener(this);
        consultantSkills.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        consultantSkills.setLayoutOrientation(JList.VERTICAL);
        consultantSkills.setVisibleRowCount(-1);

        skillScroll = new JScrollPane(consultantSkills);
        setBorder(new TitledBorder("Skills"));
        skillScroll.setViewportView(consultantSkills);
        skillScroll.setVerticalScrollBarPolicy(javax.swing.JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        skillScroll.setHorizontalScrollBarPolicy(javax.swing.JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollWrapper.add(skillScroll);

        wrapper.add(scrollWrapper, BorderLayout.CENTER);
        add(wrapper, BorderLayout.CENTER);
    }

    // -----------------------------------------------------------------
    // Methods
    // -----------------------------------------------------------------
	/*
	 * public <Skill> void refresh_SkillSet(ArrayList<Skill> skills) {
	 * this.consultantSkills.setListData(skills.toArray()); }
	 */

    
    public void refresh_consultants(ArrayList<Employee> employees, int consultantsAvailable) {
        this.consultants.setListData(employees.toArray());
        this.lblUnassignedConsultants.setText(Available + consultantsAvailable);
      //  refresh_SkillSet(new ArrayList<>());
    }

   
    public void changeConsultantSelected(Employee emp) {
        this.consultants.setSelectedValue(emp, true);
    }

    public void valueChanged(ListSelectionEvent e) {
        if (consultants.getSelectedValue() != null) {
            Employee employee = (Employee) consultants.getSelectedValue();
            txtConsultantName.setText(employee.getFullName());
            txtConsultantHours.setText(employee.getHours() + "");
          // refresh_SkillSet(employee.getSkillArrayList());

        } else {
            txtConsultantName.setText("");
            txtConsultantHours.setText("");
        }
    }

    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        if (cmd.equalsIgnoreCase(ADD)) {
            guiManager.addConsultantHoursDialog();
        } else if (cmd.equalsIgnoreCase(REMOVE)) {
            guiManager.addConsultantAssignDialog();
        } else if (cmd.equalsIgnoreCase(RemoveConsultant)) {
            guiManager.removeConsultantDialog();
        } else if (cmd.equalsIgnoreCase(AddConsultant)) {
            guiManager.addConsultantDialog();
        } else if (cmd.equalsIgnoreCase(OPT1)) {

            JOptionPane.showMessageDialog(this, guiManager.getTotalSalary(), "Average Time Worked", JOptionPane.INFORMATION_MESSAGE);

        } else if (cmd.equalsIgnoreCase(OPT2)) {
            JOptionPane.showMessageDialog(this, guiManager.getBMSalary(), "Busiest Consultant", JOptionPane.INFORMATION_MESSAGE);
        }
    }

}
