package com.planittesting.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RemoveConsultantDialog extends JDialog implements ActionListener {
    // -----------------------------------------------------------------
    // Constants
    // -----------------------------------------------------------------

    public final static String DIALOG_TITLE = "Remove Consultant";
    public final static String LBL_CONSULTANT_NAME = "Name: ";
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

    public RemoveConsultantDialog(GUIBenchManager manager) {
        this.guiBenchManager = manager;
        setTitle(DIALOG_TITLE);
        setSize(400, 200);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(4, 2));

        lblConsultantName = new JLabel(LBL_CONSULTANT_NAME);
        txtConsultantName = new JTextField();
        add(lblConsultantName);
        add(txtConsultantName);


        btnAdd = new JButton(REMOVE);
        btnAdd.addActionListener(this);
        btnAdd.setActionCommand(REMOVE);
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
        if (cmd.equalsIgnoreCase(REMOVE)) {
            guiBenchManager.removeConsultant(txtConsultantName.getText());
            dispose();
        } else {
            dispose();
        }
    }

}
