package com.macaria;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class LogInPage extends JFrame implements KeyListener {

    JPasswordField pass;
    JButton btnOk;
    JLabel label;
    GridBagConstraints c;
    GridBagLayout gbl;
    Statement st;
    ResultSet rs;

    // ////creating the class constructor
    public LogInPage() {
        createFrame();

    }
    public void createFrame() {
        setExtendedState(MAXIMIZED_BOTH);
        setUndecorated(true);
        setContentPane(new JLabel(new ImageIcon("Images/background.jpg")));

        gbl = new GridBagLayout();
        c = new GridBagConstraints();

// //// setting the layout for the JFrame

        setLayout(gbl);

        label = new JLabel(new ImageIcon("Images/icons8_users_50px.png"));
        c.anchor = GridBagConstraints.WEST;
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 5;
        c.weightx = 1.0;
        c.insets = new Insets(10, 550, 20, 550);
        add(label, c);

        pass = new JPasswordField();
        pass.setFont(new Font("Times New Roman", Font.BOLD, 20));
        pass.setText("PIN");
        pass.setHorizontalAlignment(pass.CENTER);
        pass.addActionListener(e -> handleLogin());
        pass.addKeyListener(this);
        pass.addFocusListener(new FocusAdapter() {
            @Deprecated
            public void focusGained(FocusEvent fv) {
                if(pass.getText().equals("PIN")){
                    pass.setText("");
                    pass.setEchoChar('*');
                }
            }
            @Deprecated
            public void focusLost(FocusEvent fv) {
                if(pass.getText().isEmpty()) {
                    pass.setText("PIN");
                    pass.setEchoChar((char)0);
                }
            }
        });
        c.anchor = GridBagConstraints.EAST;
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 1;
        c.insets = new Insets(0,500,5,500);
        c.gridwidth = 5;
        add(pass, c);

        btnOk = new JButton("OK");
        btnOk.addActionListener(e -> handleLogin());
        c.anchor = GridBagConstraints.WEST;
        c.fill = GridBagConstraints.BOTH;
        btnOk.setBackground(Color.cyan);
        btnOk.setForeground(Color.white);
        c.gridx =0;
        c.gridy = 2;
        c.weightx = 1.0;
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.insets = new Insets(0, 650,5,650);

        add(btnOk, c);

        setVisible(true);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {

        if(e.getKeyCode()==KeyEvent.VK_ENTER) {

            handleLogin();

        }

    }

    public void handleLogin() {

        ConnectionUnit cu =  new ConnectionUnit();

        if(cu.makeConnection2()) {

            try {

                st = cu.conn.createStatement();

                String authPass = String.valueOf(pass.getPassword());
                String query = "select * from users where empPin = '"+authPass+"' " ;
                //String cashier = "cashier";

                rs = st.executeQuery(query);

                while(rs.next()) {

                    JOptionPane.showMessageDialog(null, "hey " +rs.getString(3)+" welcome please");

                    dispose();
                    new SalesUnit(cu.conn);
                }

            }

            catch(SQLException e2) {
                e2.printStackTrace();
            }
        }

    }
}

