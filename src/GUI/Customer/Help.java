package GUI.Customer;
//****************************
//Created by Zamir on 19/04/2015.  
//****************************

import GUI.Special.VALHALA;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Help extends JPanel implements VALHALA {
    public Help() {
        initComponents();
    }

    private void initComponents() {
        setLayout(null);
        setSize(1400, 930);
        setVisible(true);

        mainPanel.setBackground(Color.green);
        mainPanel.setLayout(null);
        mainPanel.setVisible(true);
        mainPanel.setLocation(0, 0);
        mainPanel.setSize(1400, 930);

        panel1.setBackground(new Color(6, 239, 0));
        panel1.setLayout(null);
        panel1.setVisible(true);
        panel1.setLocation(20, 20);
        panel1.setSize(1355, 680);

        panel3.setBackground(new Color(58, 174, 9));
        panel3.setLayout(null);
        panel3.setLocation(0, 715);
        panel3.setSize(1400, 220);

        add(mainPanel);
        mainPanel.add(panel1);
        mainPanel.add(panel3);
        panel3.add(button1);
        scrollPane1.setBounds(10, 10, 1335, 680);
        panel1.add(scrollPane1);
        //---- button1 ----
        button1.setIcon(new ImageIcon("Assets/Back.png"));
        button1.setAlignmentY(0.0F);
        button1.setContentAreaFilled(false);
        button1.setBorderPainted(false);
        button1.setRolloverIcon(new ImageIcon("Assets/Hover/Back.png"));
        button1.setPressedIcon(new ImageIcon("Assets/Press/Back.png"));
        button1.setSize(250, 150);
        button1.setLocation(150, 0);
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                animatedFrame.t37go();
            }
        });
        try {
            BufferedImage myPicture = ImageIO.read(getClass().getResourceAsStream("/help.png"));
            JLabel picLabel = new JLabel(new ImageIcon(myPicture));
            scrollPane1.setViewportView(picLabel);

            scrollPane1.getVerticalScrollBar().setPreferredSize(

            new Dimension(50, Integer.MAX_VALUE));

            scrollPane1.getHorizontalScrollBar().setPreferredSize(

            new Dimension(Integer.MAX_VALUE, 50));

            picLabel.setSize(800,600);
        }catch (IOException z){
            System.out.print(z.getMessage());
        }
    }
    JScrollPane scrollPane1 = new JScrollPane();
    JButton button1 = new JButton();
    JPanel mainPanel = new JPanel();
    JPanel panel1 = new JPanel();
    JPanel panel3 = new JPanel();




}




