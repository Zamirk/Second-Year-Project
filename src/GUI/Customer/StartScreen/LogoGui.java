package GUI.Customer.StartScreen;
//****************************
//Created by Zamir on 23/04/2015.  
//****************************


import GUI.Special.VALHALA;

import javax.swing.*;

public class LogoGui extends JPanel implements VALHALA {
    public LogoGui() {
        initComponents();
    }

    private void initComponents() {
        setLayout(null);
        setSize(1400,200);
        setVisible(true);

        add(label4);
        label4.setIcon(new ImageIcon("Assets/LogoLarge.png"));
        label4.setSize(1400,200);
        label4.setLocation(200,0);
        label4.setBorder(null);
        label4.setOpaque(false);
        label4.setAlignmentY(0.0F);
        setOpaque(false);
    }
    JPanel mainPanel = new JPanel();
    JPanel panel1 = new JPanel();
    JLabel label2 = new JLabel();
    JLabel label3 = new JLabel();
    JLabel label4 = new JLabel();
    JButton button1 = new JButton();
}
