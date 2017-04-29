package GUI.Customer.StartScreen;
//****************************
//Created by Zamir on 23/04/2015.  
//****************************


import GUI.Special.VALHALA;

import javax.swing.*;
import java.awt.*;

public class SimpleMessage extends JPanel implements VALHALA {
    public SimpleMessage() {
        initComponents();
    }

    private void initComponents() {
        setLayout(null);
        setSize(1400,200);
        setVisible(true);

        add(label3);
        label3.setText("Press the Start button to begin");
        label3.setFont(new Font("Tahoma", Font.PLAIN, 48));
        label3.setBackground(Color.white);
        label3.setSize(1400,200);
        label3.setLocation(350,-50);
        setOpaque(false);

    }
    JPanel mainPanel = new JPanel();
    JPanel panel1 = new JPanel();
    JLabel label2 = new JLabel();
    JLabel label3 = new JLabel();
    JLabel label4 = new JLabel();
    JButton button1 = new JButton();
}
