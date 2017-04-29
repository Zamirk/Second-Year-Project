package GUI.Customer;
//****************************
//Created by Zamir on 04/04/2015.  
//****************************


import Database.Operations.Operations;
import GUI.Special.CellToButton;
import GUI.Special.GreyedOutButtons;
import GUI.Special.VALHALA;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
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

public class MenuScreenGUI extends JPanel implements CellToButton, GreyedOutButtons, VALHALA {
    Operations o;
    ResultSet rset;
    ResultSet rset1;

    public MenuScreenGUI (Operations oIn){
        o=oIn;
        initComponents();
    }
    public void beginNewOrder(){
            o.newOrder();
            fillTableNew();
            fillBasket();
    }
    private void initComponents() {
        JPanel mainPanel = new JPanel();
        JPanel panel1 = new JPanel();
        setLayout(null);
        setSize(1400,930);
        setVisible(true);
        add(mainPanel);

        mainPanel.setBackground(new Color(68,164,209));
        mainPanel.setLayout(null);
        mainPanel.setVisible(true);
        mainPanel.setLocation(0, 0);
        mainPanel.setSize(1400, 930);
        mainPanel.setLocation(0,0);

        panel1.setLayout(null);
        panel1.setSize(440, 680);
        panel1.setLocation(1150, 0);
        panel1.setBackground(new Color(82,130,174));
        panel2.add(button2);
        panel2.add(button3);
        panel2.add(button6);
        panel2.add(button7);

        mainPanel.add(panel1);
        mainPanel.add(panel3);

        panel3.setBackground(new Color(68,164,209));
        panel3.setLayout(null);
        panel3.setLocation(0, 715);
        panel3.setSize(1400, 220);
        panel3.add(button5);

        mainPanel.add(panel2);
        panel2.add(scrollPane1);
        panel2.setBackground(new Color(82, 130, 174));
        panel2.setLayout(null);
        panel2.setVisible(true);
        panel2.setLocation(20,20);
        panel2.setSize(1120, 680);

        panel3.add(button4);
        panel1.add(label1);

        panel1.add(scrollPane3);
        panel1.add(button1);

        //---- button4 ----
        button2.setText("Burgers");
        button2.setBorder(new CompoundBorder(LineBorder.createBlackLineBorder(), null));
        button2.setOpaque(false);
        button2.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        button2.setBounds(200, 625, 190, 50);
        button2.setFocusable(false);

        //---- button4 ----
        button3.setText("Chips");
        button3.setBorder(new CompoundBorder(LineBorder.createBlackLineBorder(), null));
        button3.setOpaque(false);
        button3.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        button3.setBounds(400, 625, 190, 50);
        button3.setFocusable(false);

        //---- button4 ----
        button6.setText("Pizzas");
        button6.setBorder(new CompoundBorder(LineBorder.createBlackLineBorder(), null));
        button6.setOpaque(false);
        button6.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        button6.setBounds(600, 625, 190, 50);
        button6.setFocusable(false);

        //---- button4 ----
        button7.setText("Drinks");
        button7.setBorder(new CompoundBorder(LineBorder.createBlackLineBorder(), null));
        button7.setOpaque(false);
        button7.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        button7.setBounds(800, 625, 190, 50);
        button7.setFocusable(false);

        //---- label1 ----
        label1.setText("Menu");
        label1.setFont(new Font("TimesRoman", Font.PLAIN, 48));
        label1.setLocation(470, 40);
        label1.setSize(label1.getPreferredSize());

        //---- label2 ----
        label2.setText("Basket");
        label2.setFont(new Font("TimesRoman", Font.PLAIN, 48));
        label2.setLocation(470, 40);
        label2.setSize(label2.getPreferredSize());

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
        scrollPane1.getViewport().setBackground(new Color(82,130,174));
        scrollPane1.setViewportView(table1);
        scrollPane1.setSize(1000,515);
        scrollPane1.setLocation(96,98);
        scrollPane1.setBorder(BorderFactory.createEmptyBorder());

        //======== scrollPane2 ========
        table2.setPreferredScrollableViewportSize(new Dimension(700, 800));
        table2.setFillsViewportHeight(true);
        table2.setRowHeight(30);
        table2.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        table2.setBackground(new Color(68,164,209));
        table2.setAutoCreateRowSorter(true);
        table2.setOpaque(false);
        table2.setBorder(null);
        table2.setGridColor(Color.lightGray);
        table2.setGridColor(new Color(176, 176, 176));
        scrollPane3.setOpaque(false);
        scrollPane3.getViewport().setBackground(new Color(82,130,174));
        scrollPane3.setViewportView(table2);
        scrollPane3.setSize(200, 515);
        scrollPane3.setLocation(0, 118);
        scrollPane3.setBorder(BorderFactory.createEmptyBorder());

        button4.setText("Pay");
        button4.setFont(new Font("TimesRoman", Font.PLAIN, 50));
        button4.setForeground(Color.WHITE);
        button4.setSize(300, 150);
        button4.setLocation(1000, 0);
        button4.setBorder(null);
        button4.setBorderPainted(false);
        button4.setOpaque(false);
        button4.setContentAreaFilled(false);
        button4.setHorizontalTextPosition(SwingConstants.CENTER);
        button4.setEnabled(false);
        button4.setFocusable(false);

        BufferedImage img;
        try {
            img = ImageIO.read(getClass().getResourceAsStream("/Button.png"));
            Image newimg1 = img.getScaledInstance(250, 150, java.awt.Image.SCALE_SMOOTH );
            button4.setIcon(new ImageIcon(newimg1));

            img = ImageIO.read(getClass().getResourceAsStream("/Pressed.png"));
            Image newimg2 = img.getScaledInstance(250, 150, java.awt.Image.SCALE_SMOOTH );
            button4.setPressedIcon(new ImageIcon(newimg2));

            img = ImageIO.read(getClass().getResourceAsStream("/Rollover.png"));
            Image newimg3 = img.getScaledInstance(250, 150, java.awt.Image.SCALE_SMOOTH );
            button4.setRolloverIcon(new ImageIcon(newimg3));
        } catch (IOException e) {
            System.out.println("Could not find forum icon.");
        }

        button4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                animatedFrame.t27go(animatedFrame.getCVal());
            }
        });
        button5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                animatedFrame.t2go();
            }
        });

        button5.setSize(250,150);
        button5.setLocation(150,0);
        button5.setIcon(new ImageIcon("Assets/Back.png"));
        button5.setRolloverIcon(new ImageIcon("Assets/Hover/Back.png"));
        button5.setPressedIcon(new ImageIcon("Assets/Press/Back.png"));
        button5.setBorder(null);
        button5.setBorderPainted(false);
        button5.setOpaque(false);
        button5.setContentAreaFilled(false);
        button5.setFocusable(false);
    }
    public void fillTableNew() {
        try {
            rset = o.getFirstMenu();
            ResultSetMetaData rsetMetaData = rset.getMetaData();
            int columnAmount = rsetMetaData.getColumnCount();
            Vector<Vector<Object>> data = new Vector<Vector<Object>>();
            Vector<String> columns = new Vector<String>();
            columns.add("Barcode");
            columns.add("Name");
            columns.add("Price");
            columns.add("View Information");
            columns.add("Click to Add");
            columns.add("Click to Remove");

            //Data
            while (rset.next()) {
                Vector<Object> information = new Vector<Object>();
                for (int currentColumn = 1; currentColumn <= columnAmount; currentColumn++) {
                    information.add(rset.getObject(currentColumn));
                    if(currentColumn==columnAmount) {
                        information.add("View");
                        information.add("Add");
                        information.add("Remove");
                    }
                }
                data.add(information);
            }
            table1.setModel(new DefaultTableModel(data, columns));
            table1.getColumnModel().getColumn(1).setPreferredWidth(180);
            table1.removeColumn(table1.getColumnModel().getColumn(0));
            table1.getColumn("View Information").setCellRenderer(new CellToButton.ButtonRenderer());
            table1.getColumn("View Information").setCellEditor(new ButtonEditor(new JCheckBox()));
            table1.getColumn("Click to Add").setCellRenderer(new CellToButton.ButtonRenderer());
            table1.getColumn("Click to Add").setCellEditor(new ButtonEditor(new JCheckBox()));
            table1.getColumn("Click to Remove").setCellRenderer(new CellToButton.ButtonRenderer());
            table1.getColumn("Click to Remove").setCellEditor(new ButtonEditor(new JCheckBox()));
        } catch (SQLException Z) {
            System.out.println(Z.getMessage());
        }
    }
    public void fillBasket() {
        try {//Barcode Varchar2(255) NOT NULL, Name Varchar2(255), Price FLOAT(20), Category Varchar2(255), Description Varchar2(255),
            rset1 = o.getBasket();
            ResultSetMetaData rsetMetaData = rset1.getMetaData();
            int columnAmount = rsetMetaData.getColumnCount();
            Vector<Vector<Object>> data = new Vector<Vector<Object>>();
            Vector<String> columns = new Vector<String>();
            columns.add("Basket");
            columns.add("Qty");

            //Data
            while (rset1.next()) {
                Vector<Object> information = new Vector<Object>();
                for (int currentColumn = 1; currentColumn <= columnAmount; currentColumn++) {
                    information.add(rset1.getObject(currentColumn));
                }
                data.add(information);
            }
            table2.setModel(new DefaultTableModel(data, columns));
            table2.getColumnModel().getColumn(1).setMaxWidth(35);
        } catch (SQLException Z) {
            System.out.println(Z.getMessage());
        }
    }

    class ButtonEditor extends DefaultCellEditor {
        protected JButton button = new JButton();
        private String label;
        private boolean isPushed;
        private int selectedRow;

        public ButtonEditor(JCheckBox checkBox) {
            super(checkBox);
            implementAction();
        }
        public Component getTableCellEditorComponent(JTable table, Object value,
                                                     boolean isSelected, int row, int column) {
            selectedRow = row;
            label = (value == null) ? "" : value.toString();
            button.setText(label);
            isPushed = true;
            return button;
        }
        public Object getCellEditorValue() {
            isPushed = false;
            return label;
        }
        public void implementAction(){
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(label.equals("Add")) {
                        table1.getColumn("Click to Add").setCellEditor(new ButtonEditor(new JCheckBox()));
                        table1.getColumn("Click to Add").setCellRenderer(new CellToButton.ButtonRenderer());
                        o.addToCart((((DefaultTableModel) table1.getModel()).getValueAt(selectedRow, 0).toString()));
                        fillBasket();
                        fillBasket();
                        if(table2.getRowCount()==0){
                            button4.setEnabled(false);
                        }
                        else{
                            button4.setEnabled(true);
                        }
                    } else if(label.equals("View")) {
                        animatedFrame.setProdID((((DefaultTableModel) table1.getModel()).getValueAt(selectedRow, 0).toString()));
                        animatedFrame.t34go();
                    }else if(label.equals("Remove")){
                        table1.getColumn("Click to Remove").setCellEditor(new ButtonEditor(new JCheckBox()));
                        table1.getColumn("Click to Remove").setCellRenderer(new CellToButton.ButtonRenderer());
                        o.removeFromCart((((DefaultTableModel) table1.getModel()).getValueAt(selectedRow, 0).toString()));


                        fillBasket();
                        if(table2.getRowCount()==0){
                            button4.setEnabled(false);
                        }else{
                            button4.setEnabled(true);
                        }
                    }

                }
            });
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
