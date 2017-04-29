package GUI.Customer.StartScreen;
//****************************
//Created by Zamir on 23/04/2015.  
//****************************


import GUI.Special.VALHALA;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonGUI extends JPanel implements VALHALA {
    public ButtonGUI() {
        initComponents();
    }

    private void initComponents() {
        setLayout(null);
        setSize(330,500);
        setVisible(true);
        add(button1);

        button1.setText("Start");
        button1.setIcon(new ImageIcon("Assets/Button.png"));
        button1.setBackground(Color.green);
        button1.setPressedIcon(new ImageIcon("Assets/Pressed.png"));
        button1.setHorizontalTextPosition(SwingConstants.CENTER);
        button1.setRolloverIcon(new ImageIcon("Assets/Rollover.png"));
        button1.setFont(new Font("Tahoma", Font.PLAIN, 200));
        button1.setBorder(null);
        button1.setBorderPainted(false);
        button1.setForeground(Color.white);
        button1.setOpaque(false);
        button1.setAlignmentY(0.0F);
        button1.setIconTextGap(0);
        button1.setContentAreaFilled(false);
        button1.setLocation(300, 0);
        button1.setSize(800, 500);
        setOpaque(false);
        button1.setFocusPainted(false);
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                //myFrame.fireMenuScreen(newOrder);
                animatedFrame.t1go();
            }
        });
    }
    JPanel mainPanel = new JPanel();
    JPanel panel1 = new JPanel();
    JLabel label2 = new JLabel();
    JLabel label3 = new JLabel();
    JLabel label4 = new JLabel();
    JButton button1 = new JButton();
}
