package com.macaria;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
* This class fetches all products at the specific time and displays them in a JTable
* It is useful whenever you want to look for an item all you want an overall overview
* of whichever products that are still in stock
* */

public class AllProducts extends JInternalFrame {
    Connection conn;
    ResultSet rs;
    Statement st;
    JScrollPane jsp;
    JTable tbl;
    Dimension d;

    String [] colHeaders = {"Product Photo", "Product Code", "Product Name", "Quantity in stock", " Price per item"};
    String [][] productData;


    public AllProducts(Connection con) {

        super("", true, true, true,  true);
        this.conn =con;
        d = Toolkit.getDefaultToolkit().getScreenSize();

        setSize(d);

        try {

            st = conn.createStatement();
            String query = "select * from products";
            productData =  new String[getRowCount(query)][colHeaders.length];

            rs = st.executeQuery(query);

            int counter = 0;

            while(rs.next()) {

                productData[counter][0] = rs.getString(1);
                productData[counter][1] = rs.getString(2);
                productData[counter][2] = rs.getString(3);
                productData[counter][3] = rs.getString(4);
                productData[counter][4] = rs.getString(5);

                counter++;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        tbl = new JTable(productData, colHeaders);
        jsp = new JScrollPane(tbl);

        add(jsp);
        setVisible(true);
    }
/*This method makes sure that the rows in the database table are iterated one by one,
* one after the other inorder to collect all the data in the database
 */
    public int getRowCount(String query) throws SQLException {

        st = conn.createStatement();
        rs = st.executeQuery(query);
        int counter = 0;

        while(rs.next()){
            counter++;
        }

        return counter;
    }
}
