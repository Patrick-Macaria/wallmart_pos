package com.macaria;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class FormAddProduct extends JInternalFrame implements ActionListener {

    JLabel lblCode, lblName,lblPhoto, lblPrice,lblQuan;
    JTextField txtCode, txtName, txtPrice, txtPhoto,txtQuan;
    JButton btnSave;
    GridBagLayout gbl;
    GridBagConstraints c;
    Statement st;
    Connection conn;

    public FormAddProduct(Connection conn) {

        super("Add a product", true, true, true, true);
        this.conn = conn;

        setBounds(10, 10, 500, 500);

        gbl = new GridBagLayout();
        setLayout(gbl);
        c = new GridBagConstraints();

        lblPhoto = new JLabel("Product Photo");
        lblPhoto.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        c.anchor = GridBagConstraints.WEST;
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(10, 10, 10, 10);
        add(lblPhoto, c);

        txtPhoto = new JTextField();
        txtPhoto.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        c.anchor = GridBagConstraints.WEST;
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 1;
        c.gridy = 0;
        c.weightx = 1.0;
        c.insets = new Insets(10, 10, 10, 10);
        add(txtPhoto, c);

        lblCode = new JLabel("Product Code");
        lblCode.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        c.anchor = GridBagConstraints.WEST;
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 1;
        c.insets = new Insets(10, 10, 10, 10);
        add(lblCode, c);

        txtCode = new JTextField();
        txtCode.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        c.anchor = GridBagConstraints.WEST;
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 1;
        c.gridy = 1;
        c.insets = new Insets(10, 10, 10, 10);
        add(txtCode, c);

        lblName = new JLabel("Product Name");
        lblName.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        c.anchor = GridBagConstraints.WEST;
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 2;
        c.insets = new Insets(10, 10, 10, 10);
        add(lblName, c);

        txtName = new JTextField();
        txtName.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        c.anchor = GridBagConstraints.WEST;
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 1;
        c.gridy = 2;
        c.insets = new Insets(10, 10, 10, 10);
        add(txtName, c);


        lblQuan = new JLabel("Quantity in stock");
        lblQuan.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        c.anchor = GridBagConstraints.WEST;
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 4;
        c.insets = new Insets(10, 10, 10, 10);
        add(lblQuan, c);

        txtQuan = new JTextField();
        txtQuan.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        c.anchor = GridBagConstraints.WEST;
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 1;
        c.gridy = 4;
        c.insets = new Insets(10, 10, 10, 10);
        add(txtQuan, c);

        lblPrice = new JLabel("price");
        lblPrice.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        c.anchor = GridBagConstraints.WEST;
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 5;
        c.insets = new Insets(10, 10, 10, 10);
        add(lblPrice, c);

        txtPrice = new JTextField();
        txtPrice.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        c.anchor = GridBagConstraints.WEST;
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 1;
        c.gridy = 5;
        c.insets = new Insets(10, 10, 10, 10);
        add(txtPrice, c);

        btnSave = new JButton("Save");
        btnSave.addActionListener(this);
        btnSave.setFont(new Font("Times New Roman", Font.BOLD, 30));
        c.anchor = GridBagConstraints.WEST;
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 8;
        c.insets = new Insets(10, 10, 10, 10);
        add(btnSave, c);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String photo = txtPhoto.getText() ;
        String code = txtCode.getText();
        String name = txtName.getText();
        String quan = txtQuan.getText();
        String price = txtPrice.getText();

        Object src = e.getSource();
        if(src == btnSave) {
            try {
                st = this.conn.createStatement();

                String insertSt = "insert into products values('"+photo+"','"+code+"', '"+name+"', '"+quan+"','"+price+"' )";

                int rowAffected = st.executeUpdate(insertSt);

                JOptionPane.showMessageDialog(null, rowAffected + "record successfully added");

                txtPhoto.setText("") ;
                txtCode.setText("");
                txtName.setText("");
                txtQuan.setText("");
                txtPrice.setText("");

            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }

    }

}

