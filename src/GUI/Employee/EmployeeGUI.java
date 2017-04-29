package GUI.Employee;
//****************************
//Created by Zamir on 08/04/2015.  
//****************************
import GUI.Special.VALHALA;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class EmployeeGUI extends JPanel implements VALHALA {
    boolean admin = true;
    public EmployeeGUI() {
        initComponents();
    }
    private void initComponents() {
        JPanel mainPanel = new JPanel();
        JPanel panel1 = new JPanel();
        setLayout(null);
        setSize(1400,930);
        setVisible(true);

        mainPanel.setBackground(new Color(68,164,209));
        mainPanel.setLayout(null);
        mainPanel.setVisible(true);
        mainPanel.setLocation(0, 0);
        mainPanel.setSize(1400, 930);
        add(mainPanel);
        panel1.setLayout(null);
        panel1.setBounds(116, 116, 1180, 520);
        panel1.setBackground(new Color(145, 178, 239));
        mainPanel.add(panel1);
        mainPanel.add(panel3);
        panel3.add(button1);
        mainPanel.add(panel2);

        panel2.setBackground(new Color(145, 178, 239));
        panel2.setLayout(null);
        panel2.setLocation(-5, 640);
        panel2.setSize(1400, 70);

        panel3.setBackground(new Color(68,164,209));
        panel3.setLayout(null);
        panel3.setLocation(0, 715);
        panel3.setSize(1400, 220);
        panel3.add(button5);

        panel1.add(button1);
        panel1.add(button2);
        panel1.add(button3);
        panel1.add(button4);
        panel1.add(button6);
        panel1.add(button7);
        panel1.add(button8);
        panel1.add(button9);
        panel1.add(button10);

        //---- button3 ----
        button3.setText("Stock");
        button3.setFont(new Font("TimesRoman", Font.PLAIN, 30));
        button3.setBounds(760, 60, 330, 150);

        //---- button6 ----
        button6.setText("Customers");
        button6.setFont(new Font("TimesRoman", Font.PLAIN, 30));
        button6.setBounds(60, 210, 330, 150);

        //---- button7 ----
        button7.setText("Order History");
        button7.setFont(new Font("TimesRoman", Font.PLAIN, 30));
        button7.setBounds(410, 210, 330, 150);

        //---- button9 ----
        button9.setText("Feedback");
        button9.setFont(new Font("TimesRoman", Font.PLAIN, 30));
        button9.setBounds(60, 360, 330, 150);

        //---- button10 ----
        button10.setText("Food Profiles");
        button10.setFont(new Font("TimesRoman", Font.PLAIN, 30));
        button10.setBounds(410, 360, 330, 150);
        button10.setEnabled(false);
        button5.setSize(250,150);
        button5.setLocation(150,0);
        button5.setIcon(new ImageIcon("Assets/Back.png"));
        button5.setRolloverIcon(new ImageIcon("Assets/Hover/Back.png"));
        button5.setPressedIcon(new ImageIcon("Assets/Press/Back.png"));
        button5.setBorder(null);
        button5.setBorderPainted(false);
        button5.setOpaque(false);
        button5.setContentAreaFilled(false);

        button1.setBorder(null);
        button1.setBorderPainted(false);
        button1.setForeground(Color.white);
        button1.setOpaque(false);
        button1.setContentAreaFilled(false);
        button1.setHorizontalTextPosition(SwingConstants.CENTER);

        button2.setBorder(null);
        button2.setBorderPainted(false);
        button2.setForeground(Color.white);
        button2.setOpaque(false);
        button2.setContentAreaFilled(false);
        button2.setHorizontalTextPosition(SwingConstants.CENTER);

        button3.setBorder(null);
        button3.setBorderPainted(false);
        button3.setForeground(Color.white);
        button3.setOpaque(false);
        button3.setContentAreaFilled(false);
        button3.setHorizontalTextPosition(SwingConstants.CENTER);

        button4.setBorder(null);
        button4.setBorderPainted(false);
        button4.setForeground(Color.white);
        button4.setOpaque(false);
        button4.setContentAreaFilled(false);
        button4.setHorizontalTextPosition(SwingConstants.CENTER);

        button6.setBorder(null);
        button6.setBorderPainted(false);
        button6.setForeground(Color.white);
        button6.setOpaque(false);
        button6.setContentAreaFilled(false);
        button6.setHorizontalTextPosition(SwingConstants.CENTER);

        button7.setBorder(null);
        button7.setBorderPainted(false);
        button7.setForeground(Color.white);
        button7.setOpaque(false);
        button7.setContentAreaFilled(false);
        button7.setHorizontalTextPosition(SwingConstants.CENTER);

        button8.setBorder(null);
        button8.setBorderPainted(false);
        button8.setForeground(Color.white);
        button8.setOpaque(false);
        button8.setContentAreaFilled(false);
        button8.setHorizontalTextPosition(SwingConstants.CENTER);

        button9.setBorder(null);
        button9.setBorderPainted(false);
        button9.setForeground(Color.white);
        button9.setOpaque(false);
        button9.setContentAreaFilled(false);
        button9.setHorizontalTextPosition(SwingConstants.CENTER);

        button10.setBorder(null);
        button10.setBorderPainted(false);
        button10.setForeground(Color.white);
        button10.setOpaque(false);
        button10.setContentAreaFilled(false);
        button10.setHorizontalTextPosition(SwingConstants.CENTER);
        BufferedImage img;
        try {
            img = ImageIO.read(getClass().getResourceAsStream("/Button.png"));
            Image newimg1 = img.getScaledInstance(360, 200, java.awt.Image.SCALE_SMOOTH );
            button1.setIcon(new ImageIcon(newimg1));
            button2.setIcon(new ImageIcon(newimg1));
            button3.setIcon(new ImageIcon(newimg1));
            button4.setIcon(new ImageIcon(newimg1));
            button6.setIcon(new ImageIcon(newimg1));
            button7.setIcon(new ImageIcon(newimg1));
            button8.setIcon(new ImageIcon(newimg1));
            button9.setIcon(new ImageIcon(newimg1));
            button10.setIcon(new ImageIcon(newimg1));

            img = ImageIO.read(getClass().getResourceAsStream("/Pressed.png"));
            Image newimg2 = img.getScaledInstance(360, 200, java.awt.Image.SCALE_SMOOTH );
            button1.setPressedIcon(new ImageIcon(newimg2));
            button2.setPressedIcon(new ImageIcon(newimg2));
            button3.setPressedIcon(new ImageIcon(newimg2));
            button4.setPressedIcon(new ImageIcon(newimg2));
            button6.setPressedIcon(new ImageIcon(newimg2));
            button7.setPressedIcon(new ImageIcon(newimg2));
            button8.setPressedIcon(new ImageIcon(newimg2));
            button9.setPressedIcon(new ImageIcon(newimg2));
            button10.setPressedIcon(new ImageIcon(newimg2));

            img = ImageIO.read(getClass().getResourceAsStream("/Rollover.png"));
            Image newimg3 = img.getScaledInstance(360, 200, java.awt.Image.SCALE_SMOOTH );
            button1.setRolloverIcon(new ImageIcon(newimg3));
            button2.setRolloverIcon(new ImageIcon(newimg3));
            button3.setRolloverIcon(new ImageIcon(newimg3));
            button4.setRolloverIcon(new ImageIcon(newimg3));
            button6.setRolloverIcon(new ImageIcon(newimg3));
            button7.setRolloverIcon(new ImageIcon(newimg3));
            button8.setRolloverIcon(new ImageIcon(newimg3));
            button9.setRolloverIcon(new ImageIcon(newimg3));
            button10.setRolloverIcon(new ImageIcon(newimg3));
        } catch (IOException e) {
            System.out.println("Could not find forum icon.");
        }

        button3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                animatedFrame.setAsEmployee();
                animatedFrame.t41go();
            }
        });
        button5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                animatedFrame.t8go();
            }
        });
        button6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                animatedFrame.setAsEmployee();
                animatedFrame.t45go();
            }
        });
        button7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                animatedFrame.setAsEmployee();
                animatedFrame.t44go();
            }
        });

        button9.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                animatedFrame.setAsEmployee();
                animatedFrame.t43go();
            }
        });
    }
    JPanel panel2 = new JPanel();
    JButton button1 = new JButton();
    JButton button2 = new JButton();
    JButton button3 = new JButton();
    JButton button4 = new JButton();
    JButton button5 = new JButton();
    JButton button6 = new JButton();
    JButton button7 = new JButton();
    JButton button8 = new JButton();
    JButton button9 = new JButton();
    JButton button10 = new JButton();
    JLabel label1 = new JLabel();
    JPanel panel3 = new JPanel();
}