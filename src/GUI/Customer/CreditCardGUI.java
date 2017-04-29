package GUI.Customer;
//****************************
//Created by Zamir on 12/04/2015.  
//****************************


import GUI.Special.VALHALA;
import org.jdesktop.swingx.prompt.PromptSupport;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class CreditCardGUI extends JPanel implements VALHALA{
    boolean ccvOrCred = false;
    public CreditCardGUI (){
        initComponents();
    }
    private void initComponents() {
        JPanel mainPanel = new JPanel();
        final JPanel panel1 = new JPanel();
        setLayout(null);
        setSize(1400,930);
        setVisible(true);

        mainPanel.setBackground(new Color(68, 164, 209));
        mainPanel.setLayout(null);
        mainPanel.setVisible(true);
        mainPanel.setLocation(0, 0);
        mainPanel.setSize(1400, 930);
        add(mainPanel);
        panel1.setLayout(null);
        panel1.setLocation(20, 20);
        panel1.setSize(1355, 680);
        panel1.setBackground(new Color(82, 130, 174));



        mainPanel.add(panel1);
        mainPanel.add(panel3);
        panel3.add(button1);

        panel1.add(p1);
        panel1.add(p2);
        panel1.add(panel4);
        p2.setBackground(new Color(145, 178, 239));
        p2.setLocation(640, 20);
        p2.setSize(600, 640);
        p2.setLayout(null);
        panel4.setBackground(new Color(145, 178, 239));
        panel4.setLocation(640, 20);
        panel4.setSize(600, 640);
        panel4.setLayout(null);
        panel4.setVisible(false);

        p1.setBackground(new Color(145, 178, 239));
        p1.setLocation(20,20);
        p1.setSize(600,640);
        p1.setLayout(null);

        p1.add(textField3);
        p1.add(textField2);
        p1.add(comboBox7);
        p1.add(comboBox6);
        p1.add(comboBox5);
        p1.add(textField1);
        p1.add(label19);
        p1.add(comboBox4);
        p1.add(label18);
        p1.add(label17);
        p1.add(label16);
        p1.add(label15);
        p1.add(label10);
        p1.add(label11);
        p1.add(button2);

        panel3.setBackground(new Color(68, 164, 209));
        panel3.setLayout(null);
        panel3.setLocation(0, 715);
        panel3.setSize(1400, 220);
        panel3.add(button5);
        panel4.add(keypad);

        label11.setLocation(60, 150);
        label16.setLocation(60, 250);
        label15.setLocation(60, 200);
        label17.setLocation(60, 300);
        label18.setLocation(60, 350);

        comboBox4.setLocation(300, 150);
        comboBox5.setLocation(300, 200);
        comboBox6.setLocation(365, 200);
        comboBox7.setLocation(430, 200);
        textField1.setLocation(300,250);
        textField2.setLocation(300,300);
        textField3.setLocation(300,350);

        //---- label10 ----
        label10.setText("Please enter payment details");
        label10.setFont(new Font("Tahoma", Font.PLAIN, 35));
        label10.setSize(label10.getPreferredSize());
        label10.setLocation(90,30);

        //---- label11 ----
        label11.setText("Card Type");
        label11.setFont(new Font("Tahoma", Font.PLAIN, 30));
        label11.setSize(label11.getPreferredSize());

        //---- comboBox4 ----
        comboBox4.setModel(new DefaultComboBoxModel(new String[]{
                "Select Card Type",
                "Visa ",
                "Mastercard",
                "Maestro"
        }));
        comboBox4.setSize(200, 30);
        comboBox4.setFont(new Font("Tahoma", Font.PLAIN, 20));

        //---- label15 ----
        label15.setText("Expiry Date");
        label15.setFont(new Font("Tahoma", Font.PLAIN, 30));
        label15.setSize(label15.getPreferredSize());

        comboBox5.setFont(new Font("Tahoma", Font.PLAIN, 20));
        comboBox6.setFont(new Font("Tahoma", Font.PLAIN, 20));
        comboBox7.setFont(new Font("Tahoma", Font.PLAIN, 20));
        comboBox5.setSize(65, 30);
        comboBox6.setSize(65,30);
        comboBox7.setSize(65,30);

        //---- label16 ----
        label16.setText("Enter Name");
        label16.setFont(new Font("Tahoma", Font.PLAIN, 30));
        label16.setSize(label16.getPreferredSize());

        //---- textField1 ----
        PromptSupport.setPrompt("Enter Name", textField1);
        textField1.setSize(200, 30);
        textField1.setFont(new Font("Tahoma", Font.PLAIN, 20));

        //---- label17 ----
        label17.setText("CCV");
        label17.setFont(new Font("Tahoma", Font.PLAIN, 30));
        label17.setSize(label17.getPreferredSize());

        //---- textField2 ----
        PromptSupport.setPrompt("CCV", textField2);
        textField2.setSize(60, 30);
        textField2.setFont(new Font("Tahoma", Font.PLAIN, 20));

        //---- label18 ----
        label18.setText("Card Number");
        label18.setFont(new Font("Tahoma", Font.PLAIN, 30));
        label18.setSize(label18.getPreferredSize());

        //---- textField3 ----
        PromptSupport.setPrompt("Enter Card Number", textField3);
        textField3.setFont(new Font("Tahoma", Font.PLAIN, 20));
        textField3.setSize(200, 30);

        //---- comboBox5 ----
        comboBox5.setModel(new DefaultComboBoxModel(new String[]{
                "Day",
                "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15",
                "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28",
                "29", "30", "31"
        }));
        comboBox6.setModel(new DefaultComboBoxModel(new String[]{
                "Month", "Jan", "Feb", "Mar", "Apr", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"
        }));
        comboBox7.setModel(new DefaultComboBoxModel(new String[]{
                "Year", "2015", "2016", "2017", "2018"
        }));

        button5.setSize(250,150);
        button5.setLocation(150,0);
        button5.setIcon(new ImageIcon("Assets/Back.png"));
        button5.setRolloverIcon(new ImageIcon("Assets/Hover/Back.png"));
        button5.setPressedIcon(new ImageIcon("Assets/Press/Back.png"));
        button5.setBorder(null);
        button5.setBorderPainted(false);
        button5.setOpaque(false);
        button5.setContentAreaFilled(false);
        button5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                animatedFrame.t31go();
            }
        });

        button5.setFocusable(false);

        BufferedImage img;
        try {
            img = ImageIO.read(getClass().getResourceAsStream("/Button.png"));
            Image newimg1 = img.getScaledInstance(250, 150, java.awt.Image.SCALE_SMOOTH );
            button2.setIcon(new ImageIcon(newimg1));

            img = ImageIO.read(getClass().getResourceAsStream("/Pressed.png"));
            Image newimg2 = img.getScaledInstance(250, 150, java.awt.Image.SCALE_SMOOTH );
            button2.setPressedIcon(new ImageIcon(newimg2));

            img = ImageIO.read(getClass().getResourceAsStream("/Rollover.png"));
            Image newimg3 = img.getScaledInstance(250, 150, java.awt.Image.SCALE_SMOOTH );
            button2.setRolloverIcon(new ImageIcon(newimg3));
        } catch (IOException e) {
            System.out.println("Could not find forum icon.");
        }
        button2.setForeground(Color.WHITE);
        button2.setSize(300, 150);
        button2.setLocation(80, 460);
        button2.setBorder(null);
        button2.setBorderPainted(false);
        button2.setOpaque(false);
        button2.setContentAreaFilled(false);
        button2.setText("Confirm");
        button2.setFont(new Font("Tahoma", Font.PLAIN, 40));
        button2.addActionListener(new VerifyListener());
        button2.setHorizontalTextPosition(SwingConstants.CENTER);
        button2.setFocusable(false);


        panel1.add(num0);
        panel1.add(num1);
        panel1.add(num2);
        panel1.add(num3);
        panel1.add(num4);
        panel1.add(num5);
        panel1.add(num6);
        panel1.add(num7);
        panel1.add(num8);
        panel1.add(num9);
        panel3.add(button1);
        panel1.add(receipt);

        p2.add(num0);
        p2.add(num1);
        p2.add(num2);
        p2.add(num3);
        p2.add(num4);
        p2.add(num5);
        p2.add(num6);
        p2.add(num7);
        p2.add(num8);
        p2.add(num9);
        p2.add(clear);
        p2.add(ccv);
        p2.add(receipt);

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
        ccv.setFocusable(false);
        receipt.setFocusable(false);
        keypad.setFocusable(false);

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
        clear.setText("<-----");
        ccv.setText("CCV");
        receipt.setText("Receipt");
        keypad.setText("Keypad");

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
        ccv.setBackground(Color.BLACK);
        ccv.setForeground(Color.WHITE);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        receipt.setBackground(Color.BLACK);
        receipt.setForeground(Color.WHITE);
        keypad.setBackground(Color.BLACK);
        keypad.setForeground(Color.WHITE);

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
        ccv.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        receipt.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        keypad.setFont(new Font("TimesRoman", Font.PLAIN, 20));

        num0.setSize(100, 100);
        num1.setSize(100,100);
        num2.setSize(100,100);
        num3.setSize(100,100);
        num4.setSize(100,100);
        num5.setSize(100,100);
        num6.setSize(100,100);
        num7.setSize(100,100);
        num8.setSize(100,100);
        num9.setSize(100,100);
        ccv.setSize(100,100);
        clear.setSize(200,100);
        receipt.setSize(200, 100);
        keypad.setSize(200, 100);

        num1.setLocation(100, 60);
        num2.setLocation(200,60);
        num3.setLocation(300,60);
        ccv.setLocation(450,60);
        num4.setLocation(100,160);
        num5.setLocation(200,160);
        num6.setLocation(300,160);
        num7.setLocation(100,260);
        num8.setLocation(200,260);
        num9.setLocation(300,260);
        num0.setLocation(100,360);
        clear.setLocation(200,360);
        receipt.setLocation(100,510);
        keypad.setLocation(100,510);

        ccv.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if(ccvOrCred==false){
                    ccv.setText("Card");
                    ccvOrCred=true;
                    animatedFrame.playSound();
                }else {
                    ccv.setText("CCV");
                    ccvOrCred = false;
                    animatedFrame.playSound();
                }
            }
        });
        receipt.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                p2.setVisible(false);
                panel4.setVisible(true);
            }
        });
        keypad.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                p2.setVisible(true);
                panel4.setVisible(false);
            }
        });
        num0.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if (ccv.getText() == "Card") {
                    textField3.setText(textField3.getText() + "0");
                    animatedFrame.playSound();
                }else{
                    textField2.setText(textField2.getText() + "0");
                    animatedFrame.playSound();
                }
            }
        });
        num1.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if (ccv.getText() == "Card") {
                    textField3.setText(textField3.getText() + "1");
                    animatedFrame.playSound();
                }else{
                    textField2.setText(textField2.getText() + "1");
                    animatedFrame.playSound();
                }
            }
        });
        num2.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if (ccv.getText() == "Card") {
                    textField3.setText(textField3.getText() + "2");
                    animatedFrame.playSound();
                }else{
                    textField2.setText(textField2.getText() + "2");
                    animatedFrame.playSound();
                }
            }
        });
        num3.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if (ccv.getText() == "Card") {
                    textField3.setText(textField3.getText() + "3");
                    animatedFrame.playSound();
                }else{
                    textField2.setText(textField2.getText() + "3");
                    animatedFrame.playSound();
                }
            }
        });
        num4.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if (ccv.getText() == "Card") {
                    textField3.setText(textField3.getText() + "4");
                    animatedFrame.playSound();
                }else{
                    textField2.setText(textField2.getText() + "4");
                    animatedFrame.playSound();
                }
            }
        });
        num5.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if (ccv.getText() == "Card") {
                    textField3.setText(textField3.getText() + "5");
                    animatedFrame.playSound();
                }else{
                    textField2.setText(textField2.getText() + "5");
                    animatedFrame.playSound();
                }
            }
        });
        num6.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if (ccv.getText() == "Card") {
                    textField3.setText(textField3.getText() + "6");
                    animatedFrame.playSound();
                }else{
                    textField2.setText(textField2.getText() + "6");
                    animatedFrame.playSound();
                }
            }
        });
        num7.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if (ccv.getText() == "Card") {
                    textField3.setText(textField3.getText() + "7");
                    animatedFrame.playSound();
                }else{
                    textField2.setText(textField2.getText() + "7");
                    animatedFrame.playSound();
                }
            }
        });
        num8.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if (ccv.getText() == "Card") {
                    textField3.setText(textField3.getText() + "8");
                    animatedFrame.playSound();
                }else{
                    textField2.setText(textField2.getText() + "8");
                    animatedFrame.playSound();
                }
            }
        });
        num9.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if (ccv.getText() == "Card") {
                    textField3.setText(textField3.getText() + "9");
                    animatedFrame.playSound();
                }else{
                    textField2.setText(textField2.getText() + "9");
                    animatedFrame.playSound();
                }
            }
        });
        clear.addActionListener(new ActionListener() {

                                    public void actionPerformed(ActionEvent e) {
                                        if (ccv.getText() == "Card") {
                                            if (textField3.getDocument().getLength() != 0) {
                                                textField3.setText(textField3.getText().substring(0, textField3.getDocument().getLength() - 1));
                                                animatedFrame.playSound();
                                            }
                                        } else {
                                            if (textField2.getDocument().getLength() != 0) {
                                                textField2.setText(textField2.getText().substring(0, textField2.getDocument().getLength() - 1));
                                                animatedFrame.playSound();
                                            }
                                        }
                                    }
                                }
        );

    }
    public boolean isValidCreditCardNumber(String text) {
        if (!text.startsWith("4")) {
            return false;
        }

        // add all of the digits
        int sum = 0;
        for (int i = 0; i < text.length(); i++) {
            int digit = Integer.valueOf(text.substring(i, i + 1));
            if (i % 2 == 0) {  // double every other number, add digits
                digit *= 2;
                sum += (digit / 10) + (digit % 10);
            } else {
                sum += digit;
            }
        }
        // valid numbers add up to a multiple of 10
        return (sum % 10 == 0);
    }
    public void refresh(){
        textField3.setText("");
        textField2.setText("");
        textField1.setText("");
    }
    class VerifyListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            String text = textField3.getText();
            if (isValidCreditCardNumber(text)) {
                JOptionPane.showMessageDialog(null, "Information has been validated!");
                animatedFrame.t32go();
            } else {
                JOptionPane.showMessageDialog(null, "Invalid Information.");
            }
        }
    }
    JButton button1 = new JButton();
    JButton button2 = new JButton();
    JButton button5 = new JButton();
    JPanel panel3 = new JPanel();
    JPanel panel4 = new JPanel();

    JPanel p2 = new JPanel();
    JPanel p1 = new JPanel();
    JLabel label10 = new JLabel();
    JLabel label11 = new JLabel();
    JLabel label15 = new JLabel();
    JLabel label16 = new JLabel();
    JLabel label17 = new JLabel();
    JLabel label18 = new JLabel();
    JComboBox comboBox4 = new JComboBox();
    JLabel label19 = new JLabel();
    JTextField textField1 = new JTextField();
    JComboBox comboBox5 = new JComboBox();
    JComboBox comboBox6 = new JComboBox();
    JComboBox comboBox7 = new JComboBox();
    JTextField textField2 = new JTextField();
    JTextField textField3 = new JTextField();
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
    JButton ccv = new JButton();
    JButton receipt = new JButton();
    JButton keypad = new JButton();
}