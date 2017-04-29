package GUI.Customer.PayScreen;
//****************************
//Created by Zamir on 10/04/2015.  
//****************************


import Database.Operations.Operations;
import GUI.Special.VALHALA;
import org.jdesktop.swingx.prompt.PromptSupport;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

public class FinishAndPayScreenGUI extends JPanel implements VALHALA {
    Operations o;
    String validCustomer = "";
    String cVal = "";
    ResultSet rset;
    public FinishAndPayScreenGUI(Operations oIn) {
        o = oIn;
        initComponents();
        initNumPad();
        initLoginPad();
    }
    public void setCurVal(String currVal){
        this.cVal = currVal;
        fillTable();
    }
    public void refresh() {
        textField5.setText("You can log in to earn points and view Customer history.");
        passwordField.setText("");
        username.setText("");
        button6.setText("Login here");
        button2.setEnabled(false);
        passwordField.setEnabled(true);
        username.setEnabled(true);
    }
    private void initComponents() {
        setLayout(null);
        setSize(1400,930);
        setVisible(true);

        mainPanel.setBackground(new Color(68, 164, 209));
        mainPanel.setLayout(null);
        mainPanel.setVisible(true);
        mainPanel.setLocation(0, 0);
        mainPanel.setSize(1400, 930);

        panel1.setBackground(new Color(82, 130, 174));
        panel1.setLayout(null);
        panel1.setVisible(true);
        panel1.setLocation(20,20);
        panel1.setSize(1355, 680);

        panel3.setBackground(new Color(68, 164, 209));
        panel3.setLayout(null);
        panel3.setLocation(0, 715);
        panel3.setSize(1400, 220);

        p1.setSize(400,200);
        p2.setSize(400,200);
        p3.setSize(400,220);
        p4.setSize(400,220);
        p5.setSize(400,220);
        p6.setSize(400,220);
        p7.setSize(460,640);
        p7.add(scrollPane1);
        p7.setLayout(null);
        p8.setSize(460, 640);
        p8.setLayout(null);
        p9.setSize(460, 640);
        p9.setLayout(null);

        p1.setLocation(20,20);
        p2.setLocation(20,240);
        p3.setLocation(20,440);
        p4.setLocation(440,0);
        p5.setLocation(440,220);
        p6.setLocation(440,440);
        p7.setLocation(870,20);
        p8.setLocation(870,20);
        p9.setLocation(870,20);

        p4.setOpaque(false);
        p5.setOpaque(false);
        p6.setOpaque(false);
        p3.setOpaque(false);
        p1.setBackground(new Color(145, 178, 239));
        p2.setBackground(new Color(145, 178, 239));

        p3.add(button5);
        p4.add(button2);
        p5.add(button3);
        p6.add(button4);

        p1.setLayout(null);
        p2.setLayout(null);
        p1.add(passwordField);
        p1.add(username);
        p1.add(textField);
        p1.add(button6);
        p2.add(textField2);
        p2.add(label1);
        p2.add(button7);

        //======== scrollPane1 ========
        table1.setPreferredScrollableViewportSize(new Dimension(700, 800));
        table1.setFillsViewportHeight(true);
        table1.setRowHeight(30);
        table1.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        table1.setBackground(new Color(222, 222, 222));
        table1.setAutoCreateRowSorter(true);
        table1.setOpaque(false);
        table1.setBorder(null);
        table1.setGridColor(Color.lightGray);
        table1.setGridColor(new Color(52, 157, 176));
        scrollPane1.setOpaque(false);
        scrollPane1.getViewport().setBackground(new Color(232, 234, 239));
        scrollPane1.setViewportView(table1);
        scrollPane1.setSize(460,640);
        scrollPane1.setLocation(0,0);
        scrollPane1.setBorder(BorderFactory.createEmptyBorder());

        textField1.setSize(400, 30);
        textField1.setLocation(900, 0);
        textField1.setText("Subtotal: " + o.getTotalPrice(cVal) + "€");
        textField1.setFont(new Font("Tahoma", Font.PLAIN, 20));

        textField3.setSize(400, 30);
        textField3.setLocation(900, 20);
        textField3.setText("Discount: 0.00€");
        textField3.setFont(new Font("Tahoma", Font.PLAIN, 20));

        textField4.setSize(400, 30);
        textField4.setLocation(900, 40);
        textField4.setText("Total Price: "+o.getTotalPrice(cVal) + "€");
        textField4.setFont(new Font("Tahoma", Font.PLAIN, 20));

        textField5.setSize(400, 30);
        textField5.setLocation(400, 0);
        textField5.setText("");
        textField5.setFont(new Font("Tahoma", Font.PLAIN, 20));

        textField2.setSize(300, 30);
        textField2.setLocation(20,80);
        textField2.setFont(new Font("Tahoma", Font.PLAIN, 20));

        label1.setSize(400, 30);
        label1.setLocation(20, 25);
        label1.setText("Do you have a coupon?");
        label1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        label1.setForeground(Color.WHITE);

        textField.setSize(400, 30);
        textField.setLocation(20, 25);
        textField.setText("Scan Clubcard or Login here");
        textField.setFont(new Font("Tahoma", Font.PLAIN, 20));
        textField.setForeground(Color.WHITE);

        passwordField.setSize(300, 30);
        passwordField.setLocation(20, 100);
        passwordField.setFont(new Font("Tahoma", Font.PLAIN, 20));

        username.setSize(300, 30);
        username.setLocation(20,60);
        username.setFont(new Font("Tahoma", Font.PLAIN, 20));

        PromptSupport.setPrompt("Enter Password", passwordField);
        PromptSupport.setPrompt("Enter Username", username);
        PromptSupport.setPrompt("Enter Coupon Code", textField2);

        button6.setLocation(130,130);
        button7.setLocation(130,120);
        panel1.add(p1);
        panel1.add(p2);
        panel1.add(p3);
        panel1.add(p4);
        panel1.add(p5);
        panel1.add(p6);
        panel1.add(p7);
        panel1.add(p8);
        panel1.add(p9);

        add(mainPanel);
        mainPanel.add(panel1);
        mainPanel.add(panel3);
        panel3.add(button1);
        panel3.add(textField1);
        panel3.add(textField3);
        panel3.add(textField4);
        panel3.add(textField5);
        p2.add(button8);
        p1.add(button9);

        BufferedImage img;
        try {
            img = ImageIO.read(getClass().getResourceAsStream("/Button.png"));
            Image newimg1 = img.getScaledInstance(425, 240, java.awt.Image.SCALE_SMOOTH );
            button2.setIcon(new ImageIcon(newimg1));
            button3.setIcon(new ImageIcon(newimg1));
            button4.setIcon(new ImageIcon(newimg1));
            button5.setIcon(new ImageIcon(newimg1));
            Image smallnewimg1 = img.getScaledInstance(160, 80, java.awt.Image.SCALE_SMOOTH );
            button6.setIcon(new ImageIcon(smallnewimg1));
            button7.setIcon(new ImageIcon(smallnewimg1));

            img = ImageIO.read(getClass().getResourceAsStream("/Pressed.png"));
            Image newimg2 = img.getScaledInstance(425, 240, java.awt.Image.SCALE_SMOOTH );
            button2.setPressedIcon(new ImageIcon(newimg2));
            button3.setPressedIcon(new ImageIcon(newimg2));
            button4.setPressedIcon(new ImageIcon(newimg2));
            button5.setPressedIcon(new ImageIcon(newimg2));
            Image smallnewimg2 = img.getScaledInstance(160, 80, java.awt.Image.SCALE_SMOOTH );
            button6.setPressedIcon(new ImageIcon(smallnewimg2));
            button7.setPressedIcon(new ImageIcon(smallnewimg2));

            img = ImageIO.read(getClass().getResourceAsStream("/Rollover.png"));
            Image newimg3 = img.getScaledInstance(425, 240, java.awt.Image.SCALE_SMOOTH );
            button2.setRolloverIcon(new ImageIcon(newimg3));
            button3.setRolloverIcon(new ImageIcon(newimg3));
            button4.setRolloverIcon(new ImageIcon(newimg3));
            button5.setRolloverIcon(new ImageIcon(newimg3));
            Image smallnewimg3 = img.getScaledInstance(160, 80, java.awt.Image.SCALE_SMOOTH );
            button6.setRolloverIcon(new ImageIcon(smallnewimg3));
            button7.setRolloverIcon(new ImageIcon(smallnewimg3));
        } catch (IOException e) {
            System.out.println("Could not find forum icon.");
        }

        button2.setText("View Customer History");
        button2.setEnabled(false);
        button3.setText("Pay by Credit Card");
        button4.setText("Pay by Cash");
        button5.setText("Cancel Order");
        button6.setText("Login here");
        button7.setText("Apply Coupon");

        button2.setHorizontalTextPosition(SwingConstants.CENTER);
        button3.setHorizontalTextPosition(SwingConstants.CENTER);
        button4.setHorizontalTextPosition(SwingConstants.CENTER);
        button5.setHorizontalTextPosition(SwingConstants.CENTER);
        button6.setHorizontalTextPosition(SwingConstants.CENTER);
        button7.setHorizontalTextPosition(SwingConstants.CENTER);

        button2.setFont(new Font("Tahoma", Font.PLAIN, 35));
        button3.setFont(new Font("Tahoma", Font.PLAIN, 35));
        button4.setFont(new Font("Tahoma", Font.PLAIN, 35));
        button5.setFont(new Font("Tahoma", Font.PLAIN, 35));
        button6.setFont(new Font("Tahoma", Font.PLAIN, 20));
        button7.setFont(new Font("Tahoma", Font.PLAIN, 20));

        button2.setBorder(null);
        button2.setBorderPainted(false);
        button2.setForeground(Color.white);
        button2.setOpaque(false);
        button2.setContentAreaFilled(false);
        button2.setSize(button2.getPreferredSize());

        button3.setBorder(null);
        button3.setBorderPainted(false);
        button3.setForeground(Color.white);
        button3.setOpaque(false);
        button3.setContentAreaFilled(false);
        button3.setSize(button2.getPreferredSize());

        button4.setBorder(null);
        button4.setBorderPainted(false);
        button4.setForeground(Color.white);
        button4.setOpaque(false);
        button4.setContentAreaFilled(false);
        button4.setSize(button2.getPreferredSize());

        button5.setBorder(null);
        button5.setBorderPainted(false);
        button5.setForeground(Color.white);
        button5.setOpaque(false);
        button5.setContentAreaFilled(false);
        button5.setSize(button2.getPreferredSize());

        button6.setBorder(null);
        button6.setBorderPainted(false);
        button6.setForeground(Color.white);
        button6.setOpaque(false);
        button6.setContentAreaFilled(false);
        button6.setSize(150,70);

        button7.setBorder(null);
        button7.setBorderPainted(false);
        button7.setForeground(Color.white);
        button7.setOpaque(false);
        button7.setContentAreaFilled(false);
        button7.setSize(150,70);


        //---- button1 ----
        button1.setIcon(new ImageIcon("Assets/Back.png"));
        button1.setAlignmentY(0.0F);
        button1.setContentAreaFilled(false);
        button1.setBorderPainted(false);
        button1.setRolloverIcon(new ImageIcon("Assets/Hover/Back.png"));
        button1.setPressedIcon(new ImageIcon("Assets/Press/Back.png"));
        button1.setSize(250, 150);
        button1.setLocation(150, 0);
        button1.setFocusable(false);
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                animatedFrame.t28go();
            }
        });

        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                animatedFrame.t39go(validCustomer);
            }
        });

        button4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                animatedFrame.t38go();
                animatedFrame.transferCvalToFeedback(cVal,((Double.parseDouble(o.getTotalPrice(cVal))-(Double.parseDouble(o.getTotalPrice(cVal)) * o.getDiscount("COUPON"+textField2.getText())))),validCustomer);

                double amountSpent = (Double.parseDouble(o.getTotalPrice(cVal)) - (Double.parseDouble(o.getTotalPrice(cVal)) * o.getDiscount(textField2.getText())));
                //o.updateOrderHistory(validCustomer,cVal,amountSpent);

                System.out.print(amountSpent);
                System.out.println(validCustomer);
                System.out.println(cVal);
            }
        });

        button6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                validateCustomer();
            }
        });

        button7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                   textField3.setText("Discount:" + (Double.parseDouble(o.getTotalPrice(cVal)) * o.getDiscount("COUPON"+textField2.getText()))+"€");
                   textField4.setText("Total Price:"+((Double.parseDouble(o.getTotalPrice(cVal))-(Double.parseDouble(o.getTotalPrice(cVal)) * o.getDiscount("COUPON"+textField2.getText()))))+"€");


            }
        });
        button8.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                p7.setVisible(false);
                p9.setVisible(false);
                p8.setVisible(true);
            }
        });
        button8.setLocation(0,140);
        button8.setSize(60,60);
        button8.setText("Num");
        button8.setForeground(Color.WHITE);
        button8.setBackground(new Color(82, 130, 174));
        button8.setFocusable(false);

        button9.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                p7.setVisible(false);
                p8.setVisible(false);
                p9.setVisible(true);
            }
        });
        button9.setLocation(0,140);
        button9.setSize(60,60);
        button9.setText("Num");
        button9.setForeground(Color.WHITE);
        button9.setBackground(new Color(82, 130, 174));
        button9.setFocusable(false);

        button3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                animatedFrame.transferCvalToFeedback(cVal,((Double.parseDouble(o.getTotalPrice(cVal))-(Double.parseDouble(o.getTotalPrice(cVal)) * o.getDiscount("COUPON"+textField2.getText())))),validCustomer);
                animatedFrame.t30go();
            }
        });
        button5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int n= JOptionPane.showConfirmDialog(
                        null,
                        "Are you sure you want to cancel your order?",
                        "Confirmation",
                        JOptionPane.YES_NO_OPTION);
                if (n == JOptionPane.YES_OPTION){
                    o.cancelOrder(cVal);
                    o.newOrder();
                   animatedFrame.t29go();
                }

            }
        });
    }
    public void setPrice(){
        textField1.setText("Subtotal: " + o.getTotalPrice(cVal) + "€");
        textField4.setText("Total Price: "+o.getTotalPrice(cVal) + "€");
    }
    public void validateCustomer(){
        if(button6.getText().equals("Login here")) {
            if (o.validateCustomer("CUST" + username.getText(), passwordField.getText()) == true) {
                validCustomer = "CUST" + username.getText();
                textField5.setText(username.getText() + " successfully logged in.");
                username.setText("Logged in as " + username.getText());
                button6.setText("Log Out");
                button2.setEnabled(true);
                passwordField.setEnabled(false);
                username.setEnabled(false);
            } else {
                textField5.setText("Error, invalid username or password.");
            }
        }else if(button6.getText().equals("Log Out")){
            textField5.setText("Successfully logged out.");
            passwordField.setText("");
            username.setText("");
            button6.setText("Login here");
            button2.setEnabled(false);
            passwordField.setEnabled(true);
            username.setEnabled(true);
        }
    }
    public void fillTable() {
        try {
            rset = o.getPayBasket(cVal);
            ResultSetMetaData rsetMetaData = rset.getMetaData();
            int columnAmount = rsetMetaData.getColumnCount();
            Vector<Vector<Object>> data = new Vector<Vector<Object>>();
            Vector<String> columns = new Vector<String>();
            columns.add("Name");
            columns.add("Price");
            columns.add("Quantity");

            //Data
            while (rset.next()) {
                Vector<Object> information = new Vector<Object>();
                for (int currentColumn = 1; currentColumn <= columnAmount; currentColumn++) {
                    information.add(rset.getObject(currentColumn));
                }
                data.add(information);
            }
            table1.setModel(new DefaultTableModel(data, columns));
            table1.getColumnModel().getColumn(0).setPreferredWidth(200);

        } catch (SQLException Z) {
            System.out.println(Z.getMessage());
        }
    }
    public void initNumPad(){
        p8.setVisible(false);
        p8.add(num0);
        p8.add(num1);
        p8.add(num2);
        p8.add(num3);
        p8.add(num4);
        p8.add(num5);
        p8.add(num6);
        p8.add(num7);
        p8.add(num8);
        p8.add(num9);
        p8.add(button10);
        p8.add(clear);

        clear.setText("<--");
        num0.setText("0");
        num1.setText("1");
        num2.setText("2");
        num3.setText("3");
        num4.setText("4");
        num5.setText("5");
        num6.setText("6");
        num7.setText("7");
        num8.setText("8");
        num9.setText("9");
        button10.setText("Exit");
        button10.setFocusable(false);

        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        num0.setBackground(Color.BLACK);
        num0.setForeground(Color.WHITE);
        num1.setBackground(Color.BLACK);
        num1.setForeground(Color.WHITE);
        num2.setBackground(Color.BLACK);
        num2.setForeground(Color.WHITE);
        num3.setBackground(Color.BLACK);
        num3.setForeground(Color.WHITE);
        num4.setBackground(Color.BLACK);
        num4.setForeground(Color.WHITE);
        num5.setBackground(Color.BLACK);
        num5.setForeground(Color.WHITE);
        num6.setBackground(Color.BLACK);
        num6.setForeground(Color.WHITE);
        num7.setBackground(Color.BLACK);
        num7.setForeground(Color.WHITE);
        num8.setBackground(Color.BLACK);
        num8.setForeground(Color.WHITE);
        num9.setBackground(Color.BLACK);
        num9.setForeground(Color.WHITE);
        button10.setForeground(Color.WHITE);
        button10.setBackground(Color.gray);

        num0.setFocusable(false);
        num1.setFocusable(false);
        num2.setFocusable(false);
        num3.setFocusable(false);
        num4.setFocusable(false);
        num5.setFocusable(false);
        num6.setFocusable(false);
        num7.setFocusable(false);
        num8.setFocusable(false);
        num9.setFocusable(false);
        clear.setFocusable(false);

        num0.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        num1.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        num2.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        num3.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        num4.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        num5.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        num6.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        num7.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        num8.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        num9.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        clear.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        button10.setFont(new Font("TimesRoman", Font.PLAIN, 20));

        num0.setSize(100,100);
        num1.setSize(100,100);
        num2.setSize(100,100);
        num3.setSize(100,100);
        num4.setSize(100,100);
        num5.setSize(100,100);
        num6.setSize(100,100);
        num7.setSize(100,100);
        num8.setSize(100,100);
        num9.setSize(100,100);
        clear.setSize(100, 100);
        button10.setSize(100,100);

        num1.setLocation(100,60);
        num2.setLocation(200,60);
        num3.setLocation(300,60);
        clear.setLocation(200,360);
        num4.setLocation(100,160);
        num5.setLocation(200,160);
        num6.setLocation(300,160);
        num7.setLocation(100,260);
        num8.setLocation(200,260);
        num9.setLocation(300,260);
        num0.setLocation(100,360);
        button10.setLocation(300,460);

        num0.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                textField2.setText(textField2.getText() + "0");
                animatedFrame.playSound();
            }
        });
        num1.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                textField2.setText(textField2.getText() + "1");
                animatedFrame.playSound();
            }
        });
        num2.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                textField2.setText(textField2.getText() + "2");
                animatedFrame.playSound();
            }
        });
        num3.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                textField2.setText(textField2.getText() + "3");
                animatedFrame.playSound();
            }
        });
        num4.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                textField2.setText(textField2.getText() + "4");
                animatedFrame.playSound();
            }
        });
        num5.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                textField2.setText(textField2.getText() + "5");
                animatedFrame.playSound();
            }
        });
        num6.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                textField2.setText(textField2.getText() + "6");
                animatedFrame.playSound();
            }
        });
        num7.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                textField2.setText(textField2.getText() + "7");
                animatedFrame.playSound();
            }
        });
        num8.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                textField2.setText(textField2.getText() + "8");
                animatedFrame.playSound();
            }
        });
        num9.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                textField2.setText(textField2.getText() + "9");
                animatedFrame.playSound();
            }
        });
        button10.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                p9.setVisible(false);
                p8.setVisible(false);
                p7.setVisible(true);
                animatedFrame.playSound();
            }
        });

        clear.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if(textField2.getDocument().getLength()!=0) {
                    textField2.setText(textField2.getText().substring(0, textField2.getDocument().getLength() - 1));
                    animatedFrame.playSound();
                }
            }
        });
    }
    public void initLoginPad(){
        p9.setVisible(false);
        p9.add(lnum0);
        p9.add(lnum1);
        p9.add(lnum2);
        p9.add(lnum3);
        p9.add(lnum4);
        p9.add(lnum5);
        p9.add(lnum6);
        p9.add(lnum7);
        p9.add(lnum8);
        p9.add(lnum9);
        p9.add(button11);
        p9.add(pclear);
        p9.add(lclear);

        p9.add(pnum0);
        p9.add(pnum1);
        p9.add(pnum2);
        p9.add(pnum3);
        p9.add(pnum4);
        p9.add(pnum5);
        p9.add(pnum6);
        p9.add(pnum7);
        p9.add(pnum8);
        p9.add(pnum9);
        p9.add(pclear);
        p9.add(lclear);

        lnum0.setText("0");
        lnum1.setText("1");
        lnum2.setText("2");
        lnum3.setText("3");
        lnum4.setText("4");
        lnum5.setText("5");
        lnum6.setText("6");
        lnum7.setText("7");
        lnum8.setText("8");
        lnum9.setText("9");
        pclear.setText("<---");
        lclear.setText("<---");
        button11.setText("exit");
        button11.setFocusable(false);
        pclear.setFocusable(false);
        lclear.setFocusable(false);

        lnum0.setFocusable(false);
        lnum1.setFocusable(false);
        lnum2.setFocusable(false);
        lnum3.setFocusable(false);
        lnum4.setFocusable(false);
        lnum5.setFocusable(false);
        lnum6.setFocusable(false);
        lnum7.setFocusable(false);
        lnum8.setFocusable(false);
        lnum9.setFocusable(false);

        pnum0.setText("0");
        pnum1.setText("1");
        pnum2.setText("2");
        pnum3.setText("3");
        pnum4.setText("4");
        pnum5.setText("5");
        pnum6.setText("6");
        pnum7.setText("7");
        pnum8.setText("8");
        pnum9.setText("9");

        lnum0.setBackground(Color.BLACK);
        lnum0.setForeground(Color.WHITE);
        lnum1.setBackground(Color.BLACK);
        lnum1.setForeground(Color.WHITE);
        lnum2.setBackground(Color.BLACK);
        lnum2.setForeground(Color.WHITE);
        lnum3.setBackground(Color.BLACK);
        lnum3.setForeground(Color.WHITE);
        lnum4.setBackground(Color.BLACK);
        lnum4.setForeground(Color.WHITE);
        lnum5.setBackground(Color.BLACK);
        lnum5.setForeground(Color.WHITE);
        lnum6.setBackground(Color.BLACK);
        lnum6.setForeground(Color.WHITE);
        lnum7.setBackground(Color.BLACK);
        lnum7.setForeground(Color.WHITE);
        lnum8.setBackground(Color.BLACK);
        lnum8.setForeground(Color.WHITE);
        lnum9.setBackground(Color.BLACK);
        lnum9.setForeground(Color.WHITE);
        pclear.setBackground(Color.BLACK);
        pclear.setForeground(Color.WHITE);
        lclear.setBackground(Color.BLACK);
        lclear.setForeground(Color.WHITE);
        button11.setForeground(Color.WHITE);
        button11.setBackground(Color.gray);

        pnum0.setBackground(Color.BLACK);
        pnum0.setForeground(Color.WHITE);
        pnum1.setBackground(Color.BLACK);
        pnum1.setForeground(Color.WHITE);
        pnum2.setBackground(Color.BLACK);
        pnum2.setForeground(Color.WHITE);
        pnum3.setBackground(Color.BLACK);
        pnum3.setForeground(Color.WHITE);
        pnum4.setBackground(Color.BLACK);
        pnum4.setForeground(Color.WHITE);
        pnum5.setBackground(Color.BLACK);
        pnum5.setForeground(Color.WHITE);
        pnum6.setBackground(Color.BLACK);
        pnum6.setForeground(Color.WHITE);
        pnum7.setBackground(Color.BLACK);
        pnum7.setForeground(Color.WHITE);
        pnum8.setBackground(Color.BLACK);
        pnum8.setForeground(Color.WHITE);
        pnum9.setBackground(Color.BLACK);
        pnum9.setForeground(Color.WHITE);

        lnum0.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        lnum1.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        lnum2.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        lnum3.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        lnum4.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        lnum5.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        lnum6.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        lnum7.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        lnum8.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        lnum9.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        pclear.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        lclear.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        button11.setFont(new Font("TimesRoman", Font.PLAIN, 20));

        pnum0.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        pnum1.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        pnum2.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        pnum3.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        pnum4.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        pnum5.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        pnum6.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        pnum7.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        pnum8.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        pnum9.setFont(new Font("TimesRoman", Font.PLAIN, 20));

        pnum0.setFocusable(false);
        pnum1.setFocusable(false);
        pnum2.setFocusable(false);
        pnum3.setFocusable(false);
        pnum4.setFocusable(false);
        pnum5.setFocusable(false);
        pnum6.setFocusable(false);
        pnum7.setFocusable(false);
        pnum8.setFocusable(false);
        pnum9.setFocusable(false);

        lnum0.setSize(80,80);
        lnum1.setSize(80,80);
        lnum2.setSize(80,80);
        lnum3.setSize(80,80);
        lnum4.setSize(80,80);
        lnum5.setSize(80,80);
        lnum6.setSize(80,80);
        lnum7.setSize(80,80);
        lnum8.setSize(80,80);
        lnum9.setSize(80,80);
        pclear.setSize(80,80);
        lclear.setSize(80,80);
        button11.setSize(80,80);

        pnum0.setSize(80,80);
        pnum1.setSize(80,80);
        pnum2.setSize(80,80);
        pnum3.setSize(80,80);
        pnum4.setSize(80,80);
        pnum5.setSize(80,80);
        pnum6.setSize(80,80);
        pnum7.setSize(80,80);
        pnum8.setSize(80,80);
        pnum9.setSize(80,80);
        pclear.setSize(80,80);

        lnum1.setLocation(100,60);
        lnum2.setLocation(180,60);
        lnum3.setLocation(260,60);
        lclear.setLocation(340,60);
        lnum4.setLocation(100,140);
        lnum5.setLocation(180,140);
        lnum6.setLocation(260,140);
        lnum7.setLocation(100,220);
        lnum8.setLocation(180,220);
        lnum9.setLocation(260,220);
        lnum0.setLocation(340,140);
        button11.setLocation(360,560);

        pnum1.setLocation(100,360);
        pnum2.setLocation(180,360);
        pnum3.setLocation(260,360);
        pclear.setLocation(340,360);
        pnum4.setLocation(100,440);
        pnum5.setLocation(180,440);
        pnum6.setLocation(260,440);
        pnum7.setLocation(100,520);
        pnum8.setLocation(180,520);
        pnum9.setLocation(260,520);
        pnum0.setLocation(340,440);

        lnum0.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                username.setText(username.getText() + "0");
                animatedFrame.playSound();
            }
        });
        lnum1.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                username.setText(username.getText() + "1");
                animatedFrame.playSound();
            }
        });
        lnum2.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                username.setText(username.getText() + "2");
                animatedFrame.playSound();
            }
        });
        lnum3.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                username.setText(username.getText() + "3");
                animatedFrame.playSound();
            }
        });
        lnum4.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                username.setText(username.getText() + "4");
                animatedFrame.playSound();
            }
        });
        lnum5.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                username.setText(username.getText() + "5");
                animatedFrame.playSound();
            }
        });
        lnum6.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                username.setText(username.getText() + "6");
                animatedFrame.playSound();
            }
        });
        lnum7.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                username.setText(username.getText() + "7");
                animatedFrame.playSound();
            }
        });
        lnum8.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                username.setText(username.getText() + "8");
                animatedFrame.playSound();
            }
        });
        lnum9.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                username.setText(username.getText() + "9");
                animatedFrame.playSound();
            }
        });
        button11.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                p8.setVisible(false);
                p9.setVisible(false);
                p7.setVisible(true);
                animatedFrame.playSound();
            }
        });
        pnum0.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                passwordField.setText(passwordField.getText() + "0");
                animatedFrame.playSound();
            }
        });
        pnum1.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                passwordField.setText(passwordField.getText() + "1");
                animatedFrame.playSound();
            }
        });
        pnum2.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                passwordField.setText(passwordField.getText() + "2");
                animatedFrame.playSound();
            }
        });
        pnum3.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                passwordField.setText(passwordField.getText() + "3");
                animatedFrame.playSound();
            }
        });
        pnum4.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                passwordField.setText(passwordField.getText() + "4");
                animatedFrame.playSound();
            }
        });
        pnum5.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                passwordField.setText(passwordField.getText() + "5");
                animatedFrame.playSound();
            }
        });
        pnum6.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                passwordField.setText(passwordField.getText() + "6");
                animatedFrame.playSound();
            }
        });
        pnum7.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                passwordField.setText(passwordField.getText() + "7");
                animatedFrame.playSound();
            }
        });
        pnum8.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                passwordField.setText(passwordField.getText() + "8");
                animatedFrame.playSound();
            }
        });
        pnum9.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                passwordField.setText(passwordField.getText() + "9");
                animatedFrame.playSound();
            }
        });

        lclear.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if(username.getDocument().getLength()!=0) {
                    username.setText(username.getText().substring(0, username.getDocument().getLength() - 1));
                    animatedFrame.playSound();
                }
            }
        });

        pclear.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if(passwordField.getDocument().getLength()!=0) {
                    passwordField.setText(passwordField.getText().substring(0, passwordField.getDocument().getLength() - 1));
                    animatedFrame.playSound();
                }
            }
        });
    }

    JPanel mainPanel = new JPanel();
    JPanel panel1 = new JPanel();
    JPanel panel3 = new JPanel();
    JPanel p1 = new JPanel();
    JPanel p2 = new JPanel();
    JPanel p3 = new JPanel();
    JPanel p4 = new JPanel();
    JPanel p5 = new JPanel();
    JPanel p6 = new JPanel();
    JPanel p7 = new JPanel();
    JPanel p8 = new JPanel();
    JPanel p9 = new JPanel();

    JButton button1 = new JButton();
    JButton button3 = new JButton();
    JButton button4 = new JButton();
    JButton button2 = new JButton();
    JButton button5 = new JButton();
    JButton button6 = new JButton();
    JButton button7 = new JButton();
    JButton button8 = new JButton();
    JButton button9 = new JButton();
    JButton button10 = new JButton();

    JPasswordField passwordField = new JPasswordField();
    JTextField username = new JTextField();
    JLabel textField = new JLabel();
    JLabel label1 = new JLabel();
    JLabel textField1 = new JLabel();
    JLabel textField3 = new JLabel();
    JLabel textField4 = new JLabel();
    JLabel textField5 = new JLabel();
    JTextField textField2 = new JTextField();
    JTable table1 = new JTable();
    JScrollPane scrollPane1 = new JScrollPane();

    JButton num0 = new JButton();
    JButton num1 = new JButton();
    JButton num2 = new JButton();
    JButton num3 = new JButton();
    JButton num4 = new JButton();
    JButton num5 = new JButton();
    JButton num6 = new JButton();
    JButton num7 = new JButton();
    JButton num8 = new JButton();
    JButton num9 = new JButton();
    JButton clear = new JButton();
    JButton lclear = new JButton();
    JButton lnum0 = new JButton();
    JButton lnum1 = new JButton();
    JButton lnum2 = new JButton();
    JButton lnum3 = new JButton();
    JButton lnum4 = new JButton();
    JButton lnum5 = new JButton();
    JButton lnum6 = new JButton();
    JButton lnum7 = new JButton();
    JButton lnum8 = new JButton();
    JButton lnum9 = new JButton();

    JButton pnum0 = new JButton();
    JButton pnum1 = new JButton();
    JButton pnum2 = new JButton();
    JButton pnum3 = new JButton();
    JButton pnum4 = new JButton();
    JButton pnum5 = new JButton();
    JButton pnum6 = new JButton();
    JButton pnum7 = new JButton();
    JButton pnum8 = new JButton();
    JButton pnum9 = new JButton();
    JButton pclear = new JButton();
    JButton button11 = new JButton();
}




