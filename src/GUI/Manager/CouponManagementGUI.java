package GUI.Manager;
import Database.Operations.Operations;
import GUI.Special.CellToButton;
import GUI.Special.GreyedOutButtons;
import Model.Books.Coupon;
import GUI.Special.VALHALA;
import org.jdesktop.swingx.JXDatePicker;
import org.jdesktop.swingx.prompt.PromptSupport;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CouponManagementGUI extends JPanel implements CellToButton, GreyedOutButtons, VALHALA {
    Coupon cModel;
    public CouponManagementGUI(Operations o) {
        cModel = new Coupon(o);
        initComponents();
        cModel.rsetGetCoupons();
        setModelData();
    }
    private void initComponents() {
            setLayout(null);
            setSize(1400,930);
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
            panel1.setSize(1400, 640);

            panel2.setBackground(new Color(145, 178, 239));
            panel2.setLayout(null);
            panel2.setLocation(-5, 640);
            panel2.setSize(1400, 70);

            panel3.setBackground(new Color(68,164,209));
            panel3.setLayout(null);
            panel3.setLocation(0, 715);
            panel3.setSize(1400, 200);

            add(mainPanel);
            mainPanel.add(panel1);
            mainPanel.add(panel2);
            mainPanel.add(panel3);

            panel1.add(label1);
            panel1.add(scrollPane1);

            panel2.add(button3);
            panel2.add(button4);
            panel2.add(button5);
            panel2.add(textField2);
            panel2.add(textField4);
            panel2.add(textField5);
            panel2.add(textField6);
            panel2.add(comboBox1);
            panel2.add(picker);

            panel3.add(button1);

            //---- label1 ----
            label1.setText("Coupon Management");
            label1.setFont(new Font("TimesRoman", Font.PLAIN, 48));
            label1.setLocation(470, 40);
            label1.setSize(label1.getPreferredSize());

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
        table1.setGridColor(new Color(176, 176, 176));
        scrollPane1.setOpaque(false);
        scrollPane1.getViewport().setBackground(new Color(145, 178, 239));
        scrollPane1.setViewportView(table1);
        scrollPane1.setBounds(116, 116, 1180, 520);
        scrollPane1.setBorder(BorderFactory.createEmptyBorder());


            //---- textField2 ----
            textField2.setBorder(new MatteBorder(1, 1, 1, 1, Color.black));
            textField2.setFont(new Font("TimesRoman", Font.PLAIN, 20));
            PromptSupport.setPrompt("Enter Name", textField2);
            textField2.setBounds(123, 8, 183, 22);

            //---- button4 ----
            button4.setText("Search");
            button4.setBorder(new CompoundBorder(LineBorder.createBlackLineBorder(), null));
            button4.setOpaque(false);
            button4.setFont(new Font("TimesRoman", Font.PLAIN, 20));
            button4.setBounds(1071, 40, 185, 25);

            //---- textField3 ----
            picker.setBorder(new MatteBorder(1, 1, 1, 1, Color.black));
            picker.setFont(new Font("TimesRoman", Font.PLAIN, 20));
            picker.setDate(Calendar.getInstance().getTime());
            picker.setFormats(new SimpleDateFormat("dd.MM.yy"));
            picker.setBounds(311, 8, 185, 22);

            //---- textField4 ----
            textField4.setBorder(new MatteBorder(1, 1, 1, 1, Color.black));
            textField4.setFont(new Font("TimesRoman", Font.PLAIN, 20));
            textField4.setText("Code");
            textField4.setEditable(false);
            textField4.setBounds(501, 8, 185, 22);

            //---- textField5 ----
            textField5.setBorder(new MatteBorder(1, 1, 1, 1, Color.black));
            textField5.setFont(new Font("TimesRoman", Font.PLAIN, 20));
            PromptSupport.setPrompt("Enter Discount", textField5);
            textField5.setBounds(691, 8, 185, 22);

            //---- textField6 ----
            textField6.setBorder(new MatteBorder(1, 1, 1, 1, Color.black));
            PromptSupport.setPrompt("Enter Search", textField6);
            textField6.setFont(new Font("TimesRoman", Font.PLAIN, 20));
            textField6.setBounds(501, 40, 375, 22);

            //---- button3 ----
            button3.setText("Add");
            button3.setBorder(new CompoundBorder(
                    LineBorder.createBlackLineBorder(), null));
            button3.setOpaque(false);
            button3.setFont(new Font("TimesRoman", Font.PLAIN, 20));
            button3.setBounds(881, 8, 185, 22);

            //---- button5 ----
            button5.setText("Display All");
            button5.setBorder(new CompoundBorder(
                    LineBorder.createBlackLineBorder(), null));
            button5.setOpaque(false);
            button5.setFont(new Font("TimesRoman", Font.PLAIN, 20));
            button5.setBounds(1071, 8, 185, 22);

            //---- comboBox1 ----
            comboBox1.setModel(new DefaultComboBoxModel(new String[]{
                    "Coupon Name",
                    "Expire Date",
                    "Code",
                    "Discount"
            }));
            comboBox1.setFont(new Font("TimesRoman", Font.PLAIN, 20));
            comboBox1.setBounds(881, 40, 185, 22);

            //---- button1 ----
            button1.setSize(250,150);
            button1.setLocation(150,0);
            button1.setIcon(new ImageIcon("Assets/Back.png"));
            button1.setRolloverIcon(new ImageIcon("Assets/Hover/Back.png"));
            button1.setPressedIcon(new ImageIcon("Assets/Press/Back.png"));
            button1.setBorder(null);
            button1.setBorderPainted(false);
            button1.setOpaque(false);
            button1.setContentAreaFilled(false);

            button3.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent e)
                {
                    if (button3.getText().equals("Update")) {
                        cModel.updateCoupon(
                                textField4.getText(),
                                textField2.getText(),
                                picker.getDate(),
                                Double.parseDouble(textField5.getText()));
                        setModelData();
                        button3.setText("Add");
                        button3.setForeground(Color.black);
                        button4.setEnabled(true);
                        button5.setEnabled(true);
                        defaultValues();
                    } else if (button3.getText().equals("Add")) {
                        cModel.insertCoupon(
                                textField2.getText(),
                                picker.getDate(),
                                Double.parseDouble(textField5.getText()));
                        setModelData();
                        defaultValues();
                    }
                }
            });
            button4.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent e)
                {
                    String column = "";
                    if (comboBox1.getSelectedItem().toString().equals("Expiry Date")) {
                        column = "Date";
                    } else if (comboBox1.getSelectedItem().toString().equals("Coupon Name")) {
                        column = "NAME";
                    } else if (comboBox1.getSelectedItem().toString().equals("Discount")) {
                        column = "Discount";
                    } else if (comboBox1.getSelectedItem().toString().equals("Code")) {
                        column = "CouponID";
                    }
                    cModel.rsetSearchCoupons(column, textField6.getText());
                    setModelData();
                }
            });
            button5.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent e)
                {
                    cModel.rsetGetCoupons();
                    setModelData();
                }
            });
            button1.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e)
            {
                animatedFrame.t18go();
            }
        });
    }
    private void setModelData(){
        table1.setModel(cModel.getTableModel());
        //Rendering as buttons
        table1.getColumnModel().getColumn(1).setPreferredWidth(180);
        table1.getColumn("Click to Edit").setCellRenderer(new ButtonRenderer());
        table1.getColumn("Click to Edit").setCellEditor(new ButtonEditor(new JCheckBox()));
        table1.getColumn("Click to delete").setCellRenderer(new ButtonRenderer());
        table1.getColumn("Click to delete").setCellEditor(new ButtonEditor(new JCheckBox()));
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
    public void defaultValues() {
        textField2.setText("");
        textField5.setText("");
        textField4.setText("Code");
    }
    public void refresh(){
        cModel.rsetGetCoupons();
        setModelData();
    };
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
                    if(label.equals("Edit")) {
                        int rows_count = table1.getRowCount();
                        for(int i = 0; i < rows_count; i++){
                            table1.setValueAt("Edit", i, 4);
                        }
                        button3.setText("Update");
                        button3.setForeground(Color.RED);
                        label = "Stop Editing";
                        fireEditAction();
                        stopCellEditing();
                        table1.getColumn("Click to delete").setCellEditor(table1.getColumn("Coupon Name").getCellEditor());
                        table1.getColumn("Click to delete").setCellRenderer(new GreyButtonRenderer());
                        button4.setEnabled(false);
                        button5.setEnabled(false);
                        table1.repaint();
                    }
                    else if(label.equals("Stop Editing")){
                        button3.setText("Add");
                        button3.setForeground(Color.black);
                        defaultValues();
                        label = "Edit";
                        stopCellEditing();
                        table1.getColumn("Click to delete").setCellEditor(new ButtonEditor(new JCheckBox()));
                        table1.getColumn("Click to delete").setCellRenderer(new ButtonRenderer());
                        button4.setEnabled(true);
                        button5.setEnabled(true);
                        table1.repaint();
                    }
                    else if(label.equals("Delete")) {
                        stopCellEditing();
                        String name = (table1.getModel()).getValueAt(selectedRow, 0).toString();
                        int n= JOptionPane.showConfirmDialog(
                                null,
                                "Are you sure you want to delete the coupon "+name+"?",
                                "Confirmation",
                                JOptionPane.YES_NO_OPTION);
                        if (n == JOptionPane.YES_OPTION){
                            fireDeleteAction();
                        }
                    }
                    }
            });
        }
        private void fireDeleteAction() {
            cModel.deleteCoupon(( table1.getModel()).getValueAt(selectedRow, 2).toString());
            ((DefaultTableModel)table1.getModel()).removeRow(selectedRow);
        }
        private void fireEditAction(){
            textField2.setText(( table1.getModel()).getValueAt(selectedRow, 0).toString());
            textField4.setText(( table1.getModel()).getValueAt(selectedRow, 2).toString());
            textField5.setText(( table1.getModel()).getValueAt(selectedRow,3).toString());

            String date=( table1.getModel()).getValueAt(selectedRow, 1).toString();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date d8 = new Date();
            try {
                d8 = formatter.parse(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            picker.setDate(d8);
        }
    }
    JPanel mainPanel = new JPanel();
    JPanel panel1 = new JPanel();
    JTable table1 = new JTable();
    JPanel panel2 = new JPanel();
    JPanel panel3 = new JPanel();
    JLabel label1 = new JLabel();
    JScrollPane scrollPane1 = new JScrollPane();

    JButton button1 = new JButton();
    JButton button3 = new JButton();
    JButton button4 = new JButton();
    JButton button5 = new JButton();

    JTextField textField2 = new JTextField();
    JTextField textField6 = new JTextField();
    JTextField textField4 = new JTextField();
    JTextField textField5 = new JTextField();

    JComboBox comboBox1 = new JComboBox();
    JXDatePicker picker = new JXDatePicker();
}


