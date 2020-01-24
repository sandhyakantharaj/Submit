package com.planittesting.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AssignConsultantDialog extends JDialog implements ActionListener {
    // -----------------------------------------------------------------
    // Constants
    // -----------------------------------------------------------------

    public final static String DIALOG_TITLE = "Assign Consultant to Client";
    public final static String LBL_CONSULTANT_NAME = "Name: ";
    public final static String ADD = "Assign";
    public final static String ASSIGN = "Assign: ";
    public final static String REMOVE = "Remove";
    public final static String CANCEL = "Cancel";

    // -----------------------------------------------------------------
    // Attributes
    // -----------------------------------------------------------------

    private GUIBenchManager guiBenchManager;

    private JLabel lblConsultantName;

    private JLabel lblConsultantAssigned;
    private JLabel lblConsultantJoinDate;

    private JTextField txtConsultantName;
    private JCheckBox txtConsultantAssigned;
    private JTextField txtConsultantJoinDate;

    private JButton btnAdd;
    private JButton btnCancel;


    // -----------------------------------------------------------------
    // Constructors
    // -----------------------------------------------------------------

    public AssignConsultantDialog(GUIBenchManager manager) {
        this.guiBenchManager = manager;
        setTitle(DIALOG_TITLE);
        setSize(400, 200);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(6, 2));

        lblConsultantName = new JLabel(LBL_CONSULTANT_NAME);
        txtConsultantName = new JTextField();
        add(lblConsultantName);
        add(txtConsultantName);


        lblConsultantAssigned = new JLabel(ASSIGN);
        txtConsultantAssigned = new JCheckBox();
        add(lblConsultantAssigned);
        add(txtConsultantAssigned);


        btnAdd = new JButton(ADD);
        btnAdd.addActionListener(this);
        btnAdd.setActionCommand(ADD);
        add(btnAdd);

        btnCancel = new JButton(CANCEL);
        btnCancel.addActionListener(this);
        btnCancel.setActionCommand(CANCEL);
        add(btnCancel);

        setModal(true);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    // -----------------------------------------------------------------
    // Methods
    // -----------------------------------------------------------------

    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        if (cmd.equalsIgnoreCase(ADD)) {
            guiBenchManager.assignConsultant(txtConsultantName.getText(), txtConsultantAssigned.isSelected());
            dispose();
        } else {
            dispose();
        }
    }

}
