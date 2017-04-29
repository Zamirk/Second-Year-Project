package GUI.Customer;
//****************************
//Created by Zamir on 04/04/2015.  
//****************************


import GUI.Special.CellToButton;
import GUI.Special.VALHALA;

import Database.Operations.Operations;
import Script.TheFrame;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

public class FoodInfo extends JPanel implements VALHALA {
    ResultSet rset;
    String bCode = "";
    Operations o = new Operations();
    public FoodInfo() {
        initComponents();
        fillTable();
    }

    public void setCurBarcode(String barcode){
        bCode = barcode;
    }

    private void initComponents() {
        JPanel mainPanel = new JPanel();
        JPanel panel1 = new JPanel();
        setLayout(null);
        setSize(1400, 930);
        setVisible(true);
        add(mainPanel);

        mainPanel.setBackground(new Color(68, 164, 209));
        mainPanel.setLayout(null);
        mainPanel.setVisible(true);
        mainPanel.setLocation(0, 0);
        mainPanel.setSize(1400, 930);
        mainPanel.setLocation(0, 0);

        mainPanel.add(panel1);
        mainPanel.add(panel3);

        panel3.setBackground(new Color(68, 164, 209));
        panel3.setLayout(null);
        panel3.setLocation(0, 715);
        panel3.setSize(1400, 220);
        panel3.add(button5);

        mainPanel.add(panel2);
        panel2.add(scrollPane1);
        panel2.setBackground(new Color(82, 130, 174));
        panel2.setLayout(null);
        panel2.setVisible(true);
        panel2.setLocation(20, 20);
        panel2.setSize(1120, 680);

        panel3.add(button4);
        panel1.add(label1);

        panel1.add(button1);

        //---- button4 ----
        button2.setText("Previous");
        button2.setBorder(new CompoundBorder(LineBorder.createBlackLineBorder(), null));
        button2.setOpaque(false);
        button2.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        button2.setBounds(200, 625, 190, 50);
        button2.setFocusable(false);

        //---- button4 ----
        button3.setText("Next");
        button3.setBorder(new CompoundBorder(LineBorder.createBlackLineBorder(), null));
        button3.setOpaque(false);
        button3.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        button3.setBounds(400, 625, 190, 50);
        button3.setFocusable(false);

        //---- label1 ----
        label1.setText("Item Information");
        label1.setFont(new Font("TimesRoman", Font.PLAIN, 48));
        label1.setLocation(470, 40);
        label1.setSize(label1.getPreferredSize());

        //======== scrollPane1 ========
        table1.setPreferredScrollableViewportSize(new Dimension(700, 800));
        table1.setFillsViewportHeight(true);
        table1.setRowHeight(50);
        table1.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        table1.setBackground(new Color(222, 222, 222));
        table1.setAutoCreateRowSorter(true);
        table1.setOpaque(false);
        table1.setBorder(null);
        table1.setGridColor(Color.lightGray);
        table1.setGridColor(new Color(176, 176, 176));
        scrollPane1.setOpaque(false);
        scrollPane1.getViewport().setBackground(new Color(82, 130, 174));
        scrollPane1.setViewportView(table1);
        scrollPane1.setSize(1000, 515);
        scrollPane1.setLocation(96, 98);
        scrollPane1.setBorder(BorderFactory.createEmptyBorder());

        button5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                animatedFrame.t35go();
            }
        });

        button5.setSize(250, 150);
        button5.setLocation(150, 0);
        button5.setIcon(new ImageIcon("Assets/Back.png"));
        button5.setRolloverIcon(new ImageIcon("Assets/Hover/Back.png"));
        button5.setPressedIcon(new ImageIcon("Assets/Press/Back.png"));
        button5.setBorder(null);
        button5.setBorderPainted(false);
        button5.setOpaque(false);
        button5.setContentAreaFilled(false);
        button5.setFocusable(false);
    }
    public void fillTable() {
        try {
            rset = o.getItemRating(bCode);
            ResultSetMetaData rsetMetaData = rset.getMetaData();
            int columnAmount = rsetMetaData.getColumnCount();
            Vector<Vector<Object>> data = new Vector<Vector<Object>>();
            Vector<String> columns = new Vector<String>();
            columns.add("Name");
            columns.add("Price");
            columns.add("Average Rating");


            //Data
            while (rset.next()) {
                Vector<Object> information = new Vector<Object>();
                for (int currentColumn = 1; currentColumn <= columnAmount; currentColumn++) {
                    information.add(rset.getObject(currentColumn));
                }
                data.add(information);
            }
            table1.setModel(new DefaultTableModel(data, columns));
            table1.getColumnModel().getColumn(1).setPreferredWidth(100);

        } catch (SQLException Z) {
            System.out.println(Z.getMessage());
        }
    }
    JButton button1 = new JButton();
    JButton button2 = new JButton();
    JButton button3 = new JButton();
    JButton button4 = new JButton();
    JButton button5 = new JButton();
    JButton button6 = new JButton();
    JButton button7 = new JButton();

    JLabel label1 = new JLabel();
    JLabel label2 = new JLabel();
    JPanel panel3 = new JPanel();
    JPanel panel2 = new JPanel();
    JTable table1 = new JTable();
    JTable table2 = new JTable();
    JScrollPane scrollPane1 = new JScrollPane();
    JScrollPane scrollPane2 = new JScrollPane();
    JScrollPane scrollPane3 = new JScrollPane();
}
