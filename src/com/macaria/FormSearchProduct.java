package com.macaria;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FormSearchProduct extends JInternalFrame implements ActionListener {
    JLabel lblPhoto, lblCode, lblName, lblQuan,lblPrice;
    JTextField txtPhoto, txtCode, txtName, txtQuan, txtPrice;
    JButton btnSave;
    GridBagLayout gbl;
    GridBagConstraints c;
    Connection conn;
    Statement st;
    ResultSet rs;

    public FormSearchProduct(Connection con) {
        super("search for a product", true, true, true, true);
        this.conn = con;
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
        c.gridy = 3;
        c.insets = new Insets(10, 10, 10, 10);
        add(lblQuan, c);

        txtQuan = new JTextField();
        txtQuan.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        c.anchor = GridBagConstraints.WEST;
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 1;
        c.gridy = 3;
        c.insets = new Insets(10, 10, 10, 10);
        add(txtQuan, c);

        lblPrice = new JLabel("Price");
        lblPrice.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        c.anchor = GridBagConstraints.WEST;
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 4;
        c.insets = new Insets(10, 10, 10, 10);
        add(lblPrice, c);

        txtPrice = new JTextField();
        txtPrice.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        c.anchor = GridBagConstraints.WEST;
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 1;
        c.gridy = 4;
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
        if(e.getSource() == btnSave) {

            try {
                st = conn.createStatement();
                String productCode = txtCode.getText() ;
                String query = "select * from products where product_code = '"+productCode+"' ";

                rs =  st.executeQuery(query);
                while(rs.next()) {
                    txtName.setText(rs.getString(3));
                    txtQuan.setText(rs.getString(4));
                    txtPrice.setText(rs.getString(5));

                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            }


        }

    }
}

