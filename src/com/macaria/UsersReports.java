package com.macaria;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.swing.JRViewer;

import javax.swing.*;
import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;

public class UsersReports extends JInternalFrame {
    Connection conn;
    Dimension d;
    JRViewer jrViewer;
    InputStream is;

    public UsersReports(Connection con){
        super("users", true, true, true,true);
        this.conn = con;
        d = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(d);

        try {
            is = new FileInputStream("resources\\wallmartusers.jrxml");
            JasperDesign jd = JRXmlLoader.load(is);
            JasperReport jr  = JasperCompileManager.compileReport(jd);
            JasperPrint jp = JasperFillManager.fillReport(jr, null, this.conn);
            jrViewer = new JRViewer(jp);
            add(jrViewer);

        } catch (FileNotFoundException | JRException e) {
            throw new RuntimeException(e);
        }
      setVisible(true);
    }
}
