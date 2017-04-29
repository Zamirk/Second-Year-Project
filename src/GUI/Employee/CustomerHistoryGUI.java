package GUI.Employee;
//****************************
//Created by Zamir on 14/03/2015.
//****************************

import Database.Operations.Operations;
import GUI.Customer.PayScreen.ReceiptGUI;
import GUI.Special.CellToButton;
import GUI.Special.GreyedOutButtons;
import Model.Books.CustomerHistory;
import GUI.Special.VALHALA;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomerHistoryGUI extends JPanel implements CellToButton, GreyedOutButtons, VALHALA {
    CustomerHistory chModel;
    boolean admin = true;
    boolean cust = false;
    Operations o = new Operations();

    public void setCustTrue() {
        cust=true;
    }

    public CustomerHistoryGUI(Operations o) {
        chModel = new CustomerHistory(o);
        initComponents();
    }
    public void setUniqueCustomer(String a){
        chModel.setCustId(a);
        chModel.rsetGetAll();
        setModelData();
    }
    private void setModelData() {
        table1.setModel(chModel.getTableModel());
        table1.getColumn("Click for Receipt").setCellRenderer(new ButtonRenderer());
        table1.getColumn("Click for Receipt").setCellEditor(new ButtonEditor(new JCheckBox()));
        //Columns Sized
        table1.getColumnModel().getColumn(1).setPreferredWidth(180);
        //Centring text
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        table1.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        table1.getColumnModel().getColumn(1).setCellRenderer( centerRenderer );
        table1.getColumnModel().getColumn(2).setCellRenderer( centerRenderer );
        table1.getColumnModel().getColumn(3).setCellRenderer( centerRenderer );
    }
    private void initComponents() {
        setLayout(null);
        setSize(1400, 930);
        setVisible(true);

        mainPanel.setBackground(new Color(68,164,209));
        mainPanel.setLayout(null);
        mainPanel.setVisible(true);
        mainPanel.setLocation(0, 0);
        mainPanel.setSize(1400, 930);

        panel1.setBackground(new Color(68,164,209));
        panel1.setLayout(null);
        panel1.setVisible(true);
        panel1.setLocation(0, 0);
        panel1.setSize(1400, 635);

        panel2.setBackground(new Color(145, 178, 239));
        panel2.setLayout(null);
        panel2.setLocation(-5, 640);
        panel2.setSize(1400, 70);

        panel3.setBackground(new Color(68,164,209));
        panel3.setLayout(null);
        panel3.setLocation(0, 715);
        panel3.setSize(1400, 220);

        add(mainPanel);
        mainPanel.add(panel1);
        mainPanel.add(panel2);
        mainPanel.add(panel3);
        panel2.add(label2);
        panel1.add(label1);
        panel1.add(scrollPane1);
        panel3.add(button1);

        //---- label1 ----
        label1.setText("Customer History Page");
        label1.setFont(new Font("TimesRoman", Font.PLAIN, 48));
        label1.setLocation(350,50);
        label1.setSize(label1.getPreferredSize());

        //---- label1 ----
        label2.setText("Order History for "+"fname"+" "+"lname"+": "+"custId");
        label2.setFont(new Font("TimesRoman", Font.PLAIN, 48));
        label2.setLocation(150,10);
        label2.setSize(label2.getPreferredSize());

        table1.setPreferredScrollableViewportSize(new Dimension(700, 800));
        table1.setFillsViewportHeight(true);
        table1.setRowHeight(30);
        table1.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        table1.setBackground(new Color(222, 222, 222));
        table1.setAutoCreateRowSorter(true);
        table1.setOpaque(false);
        table1.setBorder(null);
        table1.setGridColor(Color.lightGray);
        table1.setGridColor(new Color(176, 176, 176));
        scrollPane1.setOpaque(false);
        scrollPane1.getViewport().setBackground(new Color(145, 178, 239));
        scrollPane1.setViewportView(table1);
        scrollPane1.setBounds(116, 116, 1180, 520);
        scrollPane1.setBorder(BorderFactory.createEmptyBorder());

        //---- button1 ----
        button1.setIcon(new ImageIcon("Assets/Back.png"));
        button1.setAlignmentY(0.0F);

        button1.setRolloverIcon(new ImageIcon("Assets/Hover/Back.png"));
        button1.setPressedIcon(new ImageIcon("Assets/Press/Back.png"));
        button1.setBorder(null);
        button1.setBorderPainted(false);
        button1.setOpaque(false);
        button1.setContentAreaFilled(false);
        button1.setSize(250, 150);
        button1.setLocation(150, 0);
        button1.setFocusable(false);

        button1.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e)
            {
                {
                    if(cust==false) {
                        animatedFrame.t26go();
                    }else{
                        animatedFrame.t40go();
                        cust=false;
                    }
                }
            }
        });
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
        public void implementAction() {
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(label.equals("View Receipt")) {
                        ReceiptGUI r1 = new ReceiptGUI(o,(table1.getModel()).getValueAt(selectedRow, 0).toString());
                        r1.setVisible(true);
                        System.out.println("OrderID --> Receipt Page --> Database --> Receipt Page");
                    }
                }
            });
        }
    }
    JTable table1 = new JTable();
    JPanel mainPanel = new JPanel();
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    JPanel panel3 = new JPanel();
    JLabel label1 = new JLabel();
    JLabel label2 = new JLabel();
    JScrollPane scrollPane1 = new JScrollPane();
    JButton button1 = new JButton();
}