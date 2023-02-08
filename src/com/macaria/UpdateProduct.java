package com.macaria;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class UpdateProduct extends JInternalFrame implements ActionListener {
    Connection conn;
    Statement st;
    ResultSet rs;
    JLabel lblCode, lblName,lblPhoto, lblPrice,lblQuan;
    JTextField txtCode, txtName, txtPrice, txtPhoto,txtQuan;
    JButton btnUp, btnSearch, btnDelete;
    GridBagLayout gbl;
    GridBagConstraints c;
    public UpdateProduct(Connection con) {
        super("", true, true, true, true);
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

        btnSearch = new JButton("Search");
        btnSearch.addActionListener(this);
        btnSearch.setFont(new Font("Times New Roman", Font.BOLD, 30));
        c.anchor = GridBagConstraints.WEST;
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy =6;
        c.insets = new Insets(10, 10, 10, 10);
        add(btnSearch, c);

        btnUp = new JButton("Update");
        btnUp.addActionListener(this);
        btnUp.setFont(new Font("Times New Roman", Font.BOLD, 30));
        c.anchor = GridBagConstraints.WEST;
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 1;
        c.gridy = 6;
        c.insets = new Insets(10, 10, 10, 10);
        add(btnUp, c);

        btnDelete = new JButton("Delete");
        btnDelete.addActionListener(this);
        btnDelete.setFont(new Font("Times New Roman", Font.BOLD, 30));
        c.anchor = GridBagConstraints.WEST;
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 7;
        c.insets = new Insets(10, 10, 10, 10);
        add(btnDelete, c);

        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == btnSearch) {
            try {

                String query = "select * from products where product_code = '"+txtCode.getText()+"'";
                st = conn.createStatement();
                rs = st.executeQuery(query);

                while(rs.next()) {
                    txtName.setText(rs.getString(3));
                    txtQuan.setText(rs.getString(4));
                    txtPrice.setText(rs.getString(5));
                }

            } catch (SQLException e1) {
                e1.printStackTrace();
            }

        }
        else if(e.getSource() == btnUp) {

            try {
                st = conn.createStatement();

                String updateSt = "update products set product_name = '"+txtName.getText()+"', quantity_in_stock = '"+txtQuan.getText()+"', price = '"+txtPrice.getText()+"'where product_code = '"+txtCode.getText()+"'";

                int rowsAffected = st.executeUpdate(updateSt);
                JOptionPane.showMessageDialog(null, rowsAffected + " Records successfully updated");

            } catch (SQLException e1) {
                e1.printStackTrace();
            }

        }else if(e.getSource() == btnDelete) {
            try {
                st = conn.createStatement();

                String query = "delete from products where product_Code = '"+txtCode.getText()+"'";
                st.executeUpdate(query);

                JOptionPane.showConfirmDialog(null, "continue to delete this record");
                JOptionPane.showMessageDialog(null, "Record successfully deleted");

                txtPhoto.setText("");
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

