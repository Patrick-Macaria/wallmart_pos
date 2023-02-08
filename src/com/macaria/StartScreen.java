package com.macaria;

import com.formdev.flatlaf.FlatLightLaf;

import javax.swing.*;
import java.awt.*;

public class StartScreen extends JWindow {
    JProgressBar jbp;
    JLabel label, label1;


    public StartScreen() {
        createUI();
        addLabel();
        barCreate();
        loadBar();

    }

    public  void createUI() {
        setSize(500, 200);
        setLocationRelativeTo(null);
        setLayout(null);
        setContentPane(new JLabel(new ImageIcon("images/top-background.jpg")));

        setVisible(true);

    }

    public void barCreate() {
        jbp = new JProgressBar();
        jbp.setBounds(5, 180, 490, 5);
        jbp.setValue(0);
        jbp.setBorderPainted(false);
        jbp.setStringPainted(true);
        jbp.setForeground(Color.orange);

        add(jbp);

    }
    public void addLabel() {

        label = new JLabel("Wallmart");
        label.setFont(new Font("Times New Roman", Font.ITALIC, 60));
        label.setBounds(120,50,300,100);
        add(label);
        label1 = new JLabel("wait a moment...");
        label1.setFont(new Font("Times New Roman",Font.ITALIC, 15));
        //label1.setForeground(Color.yellow);
        label1.setBounds(20, 160, 200, 10);
        add(label1);

    }


    public void loadBar() {
        int counter = 0;

        while(counter <= 100) {

            try {
                Thread.sleep(100);
                jbp.setValue(counter);
                counter++;

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(counter == 100) {
                dispose();
                new LogInPage();
            }
        }
    }

    public static void main(String[] args)  {
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (UnsupportedLookAndFeelException e) {
            throw new RuntimeException(e);
        }
        new StartScreen();



    }

}
