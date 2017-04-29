package GUI.Customer.PayScreen;

import Database.Operations.Operations;
import GUI.Special.VALHALA;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

/**
 * Created by Matqo on 26. 4. 2015.
 */
public class ReceiptGUI extends JFrame implements VALHALA {
    Operations o;
    ResultSet rset;
    String orderID;
    public ReceiptGUI(Operations oIn, String oID) {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        orderID = oID;
        o = oIn;
        initComponents();
        fillTable();
    }

    private void initComponents() {
        setLayout(null);
        setSize(460,800);
        setVisible(true);

        add(mainPanel);
        mainPanel.setBackground(new Color(68, 164, 209));
        mainPanel.setLayout(null);
        mainPanel.setVisible(true);
        mainPanel.setLocation(0, 0);
        mainPanel.setSize(600, 800);
        mainPanel.add(rOn);
        mainPanel.add(textField1);
        mainPanel.add(textField3);
        mainPanel.add(textField4);
        mainPanel.add(scrollPane1);

        rOn.setSize(400, 30);
        rOn.setLocation(0, 10);
        rOn.setFont(new Font("Tahoma", Font.PLAIN, 20));
        rOn.setText("Receipt for: "+orderID);

        textField1.setSize(400, 30);
        textField1.setLocation(0, 680);
        textField1.setText("Subtotal: " + o.getTotalPrice(orderID) + "€");
        textField1.setFont(new Font("Tahoma", Font.PLAIN, 20));

        textField3.setSize(400, 30);
        textField3.setLocation(0, 700);
        textField3.setText("Discount: "+(Double.parseDouble(o.getTotalPrice(orderID))-Double.parseDouble(o.getHistoryTotalPrice(orderID)))+"€");
        textField3.setFont(new Font("Tahoma", Font.PLAIN, 20));

        textField4.setSize(400, 30);
        textField4.setLocation(0, 720);
        textField4.setText("Total Price: "+ (o.getHistoryTotalPrice(orderID) + "€"));
        textField4.setFont(new Font("Tahoma", Font.PLAIN, 20));

        //======== scrollPane1 ========
        table1.setPreferredScrollableViewportSize(new Dimension(700, 800));
        table1.setFillsViewportHeight(true);
        table1.setRowHeight(30);
        table1.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        table1.setBackground(new Color(222, 222, 222));
        table1.setAutoCreateRowSorter(true);
        table1.setOpaque(false);
        table1.setBorder(null);
        table1.setGridColor(Color.lightGray);
        table1.setGridColor(new Color(52, 157, 176));
        scrollPane1.setOpaque(false);
        scrollPane1.getViewport().setBackground(new Color(232, 234, 239));
        scrollPane1.setViewportView(table1);
        scrollPane1.setSize(460,640);
        scrollPane1.setLocation(0,40);
        scrollPane1.setBorder(BorderFactory.createEmptyBorder());
    }

    public void fillTable() {
        try {
            rset = o.getPayBasket(orderID);
            ResultSetMetaData rsetMetaData = rset.getMetaData();
            int columnAmount = rsetMetaData.getColumnCount();
            Vector<Vector<Object>> data = new Vector<Vector<Object>>();
            Vector<String> columns = new Vector<String>();
            columns.add("Name");
            columns.add("Price");
            columns.add("Quantity");

            //Data
            while (rset.next()) {
                Vector<Object> information = new Vector<Object>();
                for (int currentColumn = 1; currentColumn <= columnAmount; currentColumn++) {
                    information.add(rset.getObject(currentColumn));
                }
                data.add(information);
            }
            table1.setModel(new DefaultTableModel(data, columns));
            table1.getColumnModel().getColumn(0).setPreferredWidth(200);

        } catch (SQLException Z) {
            System.out.println(Z.getMessage());
        }
    }
    JTable table1 = new JTable();
    JScrollPane scrollPane1 = new JScrollPane();
    JPanel mainPanel = new JPanel();
    JLabel rOn = new JLabel();
    JLabel textField1 = new JLabel();
    JLabel textField3 = new JLabel();
    JLabel textField4 = new JLabel();
}