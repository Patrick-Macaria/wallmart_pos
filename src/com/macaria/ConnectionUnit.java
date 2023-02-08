package com.macaria;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUnit {

    String password = "macaria254";
    Connection conn;
    String username = "root";
    String url = "jdbc:mysql://localhost:3306/wallmart";

    //It's a boolean method and is also aimed at just returning  as simple connection object
    public boolean makeConnection2() {
        boolean connected;
        try {
            conn = DriverManager.getConnection(url, username, password);
            connected = true;
        } catch (SQLException e) {
            e.printStackTrace();
            connected = false;
        }
        return connected;
    }



}

