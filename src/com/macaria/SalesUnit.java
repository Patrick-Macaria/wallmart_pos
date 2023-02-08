package com.macaria;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class SalesUnit extends JFrame implements ActionListener {
    JMenuBar mb;
    JMenu products, sales, reports;
    JMenuItem search, addproduct, allProducts, upProducts, employees, orders, users;
    JToolBar tb;
    JButton newsp, next, previous, Refactor, tools, search1;
    JDesktopPane pane;
    Connection conn;

    public SalesUnit(Connection con) {

        super("wallmart stores");

        this.conn = con;


        createFrameSales();

    }
    public void createFrameSales() {

        setExtendedState(MAXIMIZED_BOTH);
        setUndecorated(false);

        // creating and adding menus to a JMenuBar
        mb = new JMenuBar();
        products =  new JMenu("Products");
        sales = new JMenu("Sales");
        reports = new JMenu("Reports");

        //adding JMenuItems to the menus
        search =  new JMenuItem("Search for Product");
        search.addActionListener(this);
        products.add(search);
        addproduct = new JMenuItem("Add a product");
        addproduct.addActionListener(this);
        products.add(addproduct);
        allProducts = new JMenuItem("All products");
        allProducts.addActionListener(this);
        products.add(allProducts);
        upProducts = new JMenuItem("updates");
        upProducts.addActionListener(this);
        products.add(upProducts);
        orders = new JMenuItem("Orders");
        orders.addActionListener(this);
        reports.add(orders);
        employees = new JMenuItem("Employees");
        employees.addActionListener(this);
        reports.add(employees);
        users = new JMenuItem("users");
        users.addActionListener(this);
        reports.add(users);

        tb = new JToolBar();
        newsp = new JButton("new sales panel");
        newsp.addActionListener(this);
        newsp.setBorderPainted(false);
        tb.add(newsp);
        tb.addSeparator();

        Refactor =  new JButton("Refactor");
        Refactor.setBorderPainted(false);
        tb.add(Refactor);
        tb.addSeparator();

        previous = new JButton("Previous");
        previous.setBorderPainted(false);
        tb.add(previous);
        tb.addSeparator();

        next = new JButton("previous");
        next.setBorderPainted(false);
        tb.add(next);
        tb.addSeparator();

        search1 = new JButton("Search");
        search1.setBorderPainted(false);
        tb.add(search1);
        tb.addSeparator();

        tools = new JButton(new ImageIcon("Images/refresh.png"));
        tools.setBorderPainted(false);
        tb.add(tools);
        tb.addSeparator();
///////adding menu items
        mb.add(products);
        mb.add(sales);
        mb.add(reports);


        pane = new JDesktopPane();
        pane.add(new TallyPoint(this.conn));

        getContentPane().add(pane);
        add(tb, BorderLayout.NORTH);
        setJMenuBar(mb);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == newsp) {
            pane.add(new TallyPoint(this.conn));
        }
        else if(e.getSource() == addproduct) {
            pane.add(new FormAddProduct(this.conn));
        }else if(e.getSource() == search) {
            pane.add(new FormSearchProduct(this.conn));
        }else if(e.getSource() == allProducts){
            pane.add(new AllProducts(this.conn));
        }else if(e.getSource() == upProducts) {
            pane.add(new UpdateProduct(this.conn));
        }else if(e. getSource() == users){
            pane.add(new UsersReports(this.conn));
        }
    }
}
