package com.macaria;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.print.PrinterException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class TallyPoint extends JInternalFrame {
    JLabel ttPrice, amountPaid, productCode, productName, Quantity, price, totalPrice;
    JTextField txtPrice, txtAmount, txtBal, txtProductCode, txtProductName, txtP, txtTP;
    JTextArea txtArea;
    JButton printReceipt, delete, btnTotals, balance, btnFetch, btnTableTotals;
    JPanel pan1, pan2, pan3;

    JComboBox<String> cboQty;

    String[] quantities = {"1", "2", "3", "4", "5"};

    Dimension d;
    JTable tbl;
    DefaultTableModel dtm;
    Connection conn;
    ResultSet rs;
    Statement st;
    JScrollPane sp;

    int quantityInStock, qty;


    public TallyPoint(Connection con) {

        super("Tally-point", true, true, true, true);
        this.conn = con;
        d = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(d);
        setLayout(new BorderLayout());

        // creating a panel to be added to the south for total price and balance
        pan1 = new JPanel();
        pan1.setLayout(null);
        pan1.setSize(600, 150);

        ttPrice = new JLabel("Total price");
        ttPrice.setFont(new Font("Times New Roman", Font.BOLD, 20));
        ttPrice.setHorizontalAlignment(ttPrice.CENTER);
        ttPrice.setBounds(100, 0, 100, 30);
        pan1.add(ttPrice);

        txtPrice = new JTextField();
        txtPrice.setHorizontalAlignment(txtPrice.CENTER);
        txtPrice.setBounds(100, 40, 100, 30);
        pan1.add(txtPrice);

        amountPaid = new JLabel("Paid");
        amountPaid.setFont(new Font("Times New Roman", Font.BOLD, 20));
        amountPaid.setHorizontalAlignment(amountPaid.CENTER);
        amountPaid.setBounds(250, 0, 100, 30);
        pan1.add(amountPaid);

        txtAmount = new JTextField();
        txtAmount.setHorizontalAlignment(txtAmount.CENTER);
        txtAmount.setBounds(250, 40, 100, 30);
        pan1.add(txtAmount);

        balance = new JButton("Balance");
        //balance.setFont( new Font("Times New Roman", Font.BOLD, 20));
        balance.setHorizontalAlignment(balance.CENTER);
        balance.addActionListener(e -> getBalance());
        balance.setBounds(420, 0, 100, 30);
        pan1.add(balance);

        txtBal = new JTextField();
        txtBal.setHorizontalAlignment(txtBal.CENTER);
        txtBal.setBounds(420, 40, 100, 30);
        pan1.add(txtBal);


        btnTableTotals = new JButton("Table Total");
        btnTableTotals.setBounds(100, 80, 100, 30);
        btnTableTotals.addActionListener(e -> {
            double totalAmount = getTotal();
            txtPrice.setText(String.valueOf(totalAmount));
        });
        pan1.add(btnTableTotals);

        delete = new JButton("Delete");
        delete.setBounds(250, 80, 100, 30);
        pan1.add(delete);

        printReceipt = new JButton("Receipt");
        printReceipt.setBounds(250, 120, 100, 30);
        printReceipt.addActionListener(e -> printReceiptMethod());
        pan1.add(printReceipt);


        // creating another panel to contain the actual sale tallying
        pan2 = new JPanel();
        pan2.setLayout(new BorderLayout());


        dtm = new DefaultTableModel(0,0);
        dtm.addColumn("Product Code");
        dtm.addColumn("Product Name");
        dtm.addColumn("Price");
        dtm.addColumn("Quantity");
        dtm.addColumn("Total Price");

        tbl = new JTable();
        tbl.setModel(dtm);
        //tbl.setAlignmentY(CENTER_ALIGNMENT);
        sp = new JScrollPane(tbl);
        pan2.add(sp, BorderLayout.CENTER);

        // creating a third panel
        /*This panel contains the part that you fill in the information about products as you tally a customers purchases
         * it is added to the top of the second panel using BorderLayout.North
         *
         */
        pan3 = new JPanel();
        pan3.setLayout(new GridLayout(2, 6, 10, 15));

        productCode = new JLabel("Product code");
        productCode.setHorizontalAlignment(productCode.CENTER);
        productCode.setFont(new Font("Times New Roman", Font.BOLD, 20));

        productName = new JLabel("product Name");
        productName.setHorizontalAlignment(productName.CENTER);
        productName.setFont(new Font("Times New Roman", Font.BOLD, 20));

        price = new JLabel("Price");
        price.setHorizontalAlignment(price.CENTER);
        price.setFont(new Font("Times New Roman", Font.BOLD, 20));

        Quantity = new JLabel("Quantity");
        Quantity.setHorizontalAlignment(Quantity.CENTER);
        Quantity.setFont(new Font("Times New Roman", Font.BOLD, 20));

        totalPrice = new JLabel("Total Price");
        totalPrice.setHorizontalAlignment(totalPrice.CENTER);
        totalPrice.setFont(new Font("Times New Roman", Font.BOLD, 20));

        txtProductName = new JTextField();
        txtProductName.setHorizontalAlignment(txtProductName.CENTER);

        txtProductCode = new JTextField();
        txtProductCode.setHorizontalAlignment(txtProductCode.CENTER);


        cboQty = new JComboBox<>(quantities);
        cboQty.addItemListener(

                e -> {
                    if (e.getStateChange() == ItemEvent.SELECTED) {
                        Object obj = cboQty.getSelectedItem();
                        String str = (String) obj;
                        qty = 0;
                        if (str != null) {
                            qty = Integer.parseInt(str);

                            double price = Double.parseDouble(txtP.getText());

                            double totalPrice = price * qty;
                            String tp = String.valueOf(totalPrice);
                            txtTP.setText(tp);
                        }
                    }
                });

        txtP = new JTextField();
        txtP.setHorizontalAlignment(txtP.CENTER);

        txtTP = new JTextField();
        txtTP.setHorizontalAlignment(txtTP.CENTER);

        btnFetch = new JButton("Fetch");
        btnFetch.setBorderPainted(false);
        btnFetch.setMaximumSize(new Dimension(30, 30));
        btnFetch.setBackground(Color.white);
        btnFetch.addActionListener(e -> fetchData());
        pan3.add(btnFetch);

        btnTotals = new JButton("Add to Table");
        btnTotals.setBorderPainted(false);
        btnTotals.setMaximumSize(new Dimension(30, 30));
        btnTotals.setBackground(Color.white);
        btnTotals.addActionListener(e -> addToTable());
        pan3.add(btnTotals);

        pan3.add(productCode);
        pan3.add(productName);
        pan3.add(price);
        pan3.add(Quantity);
        pan3.add(totalPrice);
        pan3.add(btnFetch);
        pan3.add(txtProductCode);
        pan3.add(txtProductName);
        pan3.add(txtP);
        pan3.add(cboQty);
        pan3.add(txtTP);
        pan3.add(btnTotals);

        pan2.add(pan3, BorderLayout.NORTH);

        add(pan2, BorderLayout.NORTH);
        add(pan1, BorderLayout.CENTER);
        setVisible(true);
    }

    public void fetchData() {
        try {
            st = this.conn.createStatement();
            String query = "select * from products where product_code = '" + txtProductCode.getText() + "'";
            rs = st.executeQuery(query);
            while (rs.next()) {

                txtProductName.setText(rs.getString(3));
                txtP.setText(rs.getString(5));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public double getTotal() {
        double sum = 0;

        for (int i = 0; i < tbl.getRowCount(); i++) {
            sum += Double.parseDouble((String) tbl.getValueAt(i, 4));
        }
        return sum;
    }


    public void getBalance() {
        double bal = Double.parseDouble(txtAmount.getText()) - Double.parseDouble(txtPrice.getText());
        txtBal.setText(String.valueOf(bal));
    }


    public void addToTable() {
        dtm.addRow(new Object[]{txtProductCode.getText(), txtProductName.getText(), txtP.getText(), cboQty.getSelectedItem(), txtTP.getText()});


        //update stock in database
        try {
            st = conn.createStatement();
            String query = "select * from products";
            rs = st.executeQuery(query);
            while (rs.next()) {
                quantityInStock = Integer.parseInt(rs.getString(4));
            }
            ///////////////////////////////////////////////////////////
            int newQuantityInStock = quantityInStock - qty;
            String newQty = String.valueOf(newQuantityInStock);


            String update = "update products set quantity_in_stock = '" + newQty + "' where product_code = '" + txtProductCode.getText() + "'";
            st.executeUpdate(update);


        } catch (SQLException e) {
            e.printStackTrace();

        }

    }

    public void printReceiptMethod() {
        txtArea = new JTextArea();
        txtArea.setFont(new Font("Times New Roman", Font.BOLD, 20));
        txtArea.setText(txtArea.getText() + "Wallmart" + "\n" + new Date() + "\n");
        txtArea.setText(txtArea.getText() + "code" + " \t " + "Name" + " \t " + "Price" + "\t " + "Quantity" + " \t " + "Total Price" + "\n");

        for (int i = 0; i < tbl.getRowCount(); i++) {
            String productCode = (String) tbl.getValueAt(i, 1);
            String productName = (String) tbl.getValueAt(i, 2);
            String onePrice = (String) tbl.getValueAt(i, 3);
            String quan = (String) tbl.getValueAt(i, 4);
            String totalPrice = (String) tbl.getValueAt(i, 5);

            txtArea.setText(txtArea.getText() + productCode + " \t " + productName + " \t  " + onePrice + " \t " + quan + " \t  " + totalPrice + "\n");
        }
        txtArea.setText(txtArea.getText() + txtP.getText() + "\n");
        txtArea.setText(txtArea.getText() + txtTP.getText() + "\n");
        txtArea.setText(txtArea.getText() + txtBal.getText());


        try {
            txtArea.print();
        } catch (PrinterException e) {
            throw new RuntimeException(e);
        }

    }

}
