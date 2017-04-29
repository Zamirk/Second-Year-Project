package GUI.Customer.StartScreen;
//****************************
//Created by Zamir on 07/03/2015.
//****************************

import GUI.Special.VALHALA;

import javax.swing.*;
import java.awt.*;


public class Welcome extends JPanel implements VALHALA{
    public Welcome() {
        initComponents();
    }

     private void initComponents() {
        setLayout(null);
        setSize(1400,100);
        setVisible(true);
         setOpaque(false);

        add(label2);
         label2.setText("Welcome to");
         label2.setFont(new Font("Tahoma", Font.PLAIN, 120));
         label2.setSize(1400,100);
         label2.setLocation(400,0);
    }
    JPanel mainPanel = new JPanel();
    JPanel panel1 = new JPanel();
    JLabel label2 = new JLabel();
    JLabel label3 = new JLabel();
    JLabel label4 = new JLabel();
    JButton button1 = new JButton();
}
