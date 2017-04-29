package GUI.Manager;
//****************************
//Created by Zamir on 14/03/2015.  
//****************************


import Database.Operations.Operations;
import GUI.Special.CellToButton;
import GUI.Special.GreyedOutButtons;
import Model.Books.Item;
import GUI.Special.VALHALA;
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

public class MenuManagementGUI extends JPanel implements CellToButton, GreyedOutButtons, VALHALA {
    Item iModel;
    public MenuManagementGUI(Operations o) {
        iModel = new Item(o);
        initComponents();
        iModel.rsetGetAll();
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
        panel3.setSize(1400, 220);

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
        panel2.add(textField3);
        panel2.add(textField4);
        panel2.add(textField5);
        panel2.add(textField6);
        panel2.add(comboBox1);
        panel2.add(textField7);
        panel2.add(textField8);
        panel2.add(button2);

        panel3.add(scrollPane2);
        panel3.add(button1);

        label1.setText("Menu Management");
        label1.setBackground(new Color(255, 255, 102));
        label1.setFont(new Font("TimesRoman", Font.PLAIN, 48));
        label1.setLocation(470, 40);
        label1.setSize(label1.getPreferredSize());

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
        textField2.setBounds(115, 5, 180, 22);

        //---- textField3 ----
        textField3.setBorder(new MatteBorder(1, 1, 1, 1, Color.black));
        textField3.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        PromptSupport.setPrompt("Price", textField3);
        textField3.setBounds(297, 5, 100, 22);

        //---- textField4 ----
        textField4.setBorder(new MatteBorder(1, 1, 1, 1, Color.black));
        textField4.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        PromptSupport.setPrompt("Enter Category", textField4);
        textField4.setBounds(399, 5, 180, 22);

        //---- textField5 ----
        textField5.setBorder(new MatteBorder(1, 1, 1, 1, Color.black));
        textField5.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        textField5.setText("Barcode");
        textField5.setBounds(581, 5, 180, 22);
        textField5.setEditable(false);

        //---- textField3 ----
        textField7.setBorder(new MatteBorder(1, 1, 1, 1, Color.black));
        textField7.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        textField7.setText("0");
        textField7.setBounds(763, 5, 100, 22);
        textField7.setEditable(false);

        //---- textField3 ----
        textField8.setBorder(new MatteBorder(1, 1, 1, 1, Color.black));
        textField8.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        textField8.setText("0");
        textField8.setBounds(865, 5, 100, 22);
        textField8.setEditable(false);

        //---- button4 ----
        button4.setText("Search");
        button4.setBorder(new CompoundBorder(LineBorder.createBlackLineBorder(), null));
        button4.setOpaque(false);
        button4.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        button4.setBounds(1070, 35, 190, 25);

        //---- button3 ----
        button3.setText("Add");
        button3.setBorder(new CompoundBorder(LineBorder.createBlackLineBorder(), null));
        button3.setOpaque(false);
        button3.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        button3.setBounds(967, 05, 165, 22);

        //---- button3 ----
        button2.setText("Display All");
        button2.setBorder(new CompoundBorder(LineBorder.createBlackLineBorder(), null));
        button2.setOpaque(false);
        button2.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        button2.setBounds(1134, 05, 162, 22);

        //---- comboBox1 ----
        comboBox1.setModel(new DefaultComboBoxModel(new String[] {
                "Name",
                "Price",
                "Category",
                "Barcode"
        }));
        comboBox1.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        comboBox1.setBounds(880, 35, 185, 25);

        //---- textField6 ----
        textField6.setBorder(new MatteBorder(1, 1, 1, 1, Color.black));
        PromptSupport.setPrompt("Enter Search", textField6);
        textField6.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        textField6.setBounds(495, 35, 382, 25);

        //---- button1 ----
        button1.setIcon(new ImageIcon("Assets/Back.png"));
        button1.setAlignmentY(0.0F);
        button1.setMargin(new Insets(0, 0, 0, 0));
        button1.setRolloverIcon(new ImageIcon("Assets/Hover/Back.png"));
        button1.setPressedIcon(new ImageIcon("Assets/Press/Back.png"));
        button1.setBorder(null);
        button1.setBorderPainted(false);
        button1.setOpaque(false);
        button1.setContentAreaFilled(false);
        button1.setSize(250,150);
        button1.setLocation(150,0);

        button1.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e)
            {
                animatedFrame.t17go();
            }
        });
        button3.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e)
            {
                if (button3.getText().equals("Update")) {
                    iModel.editItem(
                            textField2.getText(),
                            Double.parseDouble(textField3.getText()),
                            textField4.getText(),
                            textField5.getText());
                    setModelData();
                    button3.setText("Add");
                    button3.setForeground(Color.black);
                    button4.setEnabled(true);
                    button5.setEnabled(true);
                    button2.setEnabled(true);
                    defaultValues();
                } else if (button3.getText().equals("Add")) {
                    iModel.insertItem(
                            textField2.getText(),
                            Double.parseDouble(textField3.getText()),
                            textField4.getText());
                    iModel.rsetGetAll();
                    setModelData();
                    defaultValues();
                }
            }
        });
        button4.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e)
            {
                iModel.searchMenu(comboBox1.getSelectedItem().toString(), textField6.getText());
                setModelData();
            }
        });
        button2.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e)
            {
                iModel.rsetGetAll();
                setModelData();
            }
        });
    }
    private void setModelData() {
        table1.setModel(iModel.getTableModel());
        //Rendering as buttons
        table1.getColumnModel().getColumn(5).setCellRenderer(new ButtonRenderer());
        table1.getColumnModel().getColumn(5).setCellEditor(new ButtonEditor(new JCheckBox()));
        table1.getColumnModel().getColumn(6).setCellRenderer(new ButtonRenderer());
        table1.getColumnModel().getColumn(6).setCellEditor(new ButtonEditor(new JCheckBox()));
        table1.getColumnModel().getColumn(7).setCellRenderer(new ButtonRenderer());
        table1.getColumnModel().getColumn(7).setCellEditor(new ButtonEditor(new JCheckBox()));
        table1.getColumnModel().getColumn(8).setCellRenderer(new ButtonRenderer());
        table1.getColumnModel().getColumn(8).setCellEditor(new ButtonEditor(new JCheckBox()));
        //Columns Sized
        table1.getColumnModel().getColumn(0).setPreferredWidth(140);
        table1.getColumnModel().getColumn(1).setPreferredWidth(70);
        table1.getColumnModel().getColumn(2).setPreferredWidth(140);
        table1.getColumnModel().getColumn(3).setPreferredWidth(140);
        table1.getColumnModel().getColumn(4).setPreferredWidth(70);
        //Centring text
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( SwingConstants.CENTER );
        table1.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        table1.getColumnModel().getColumn(1).setCellRenderer( centerRenderer );
        table1.getColumnModel().getColumn(2).setCellRenderer( centerRenderer );
        table1.getColumnModel().getColumn(3).setCellRenderer( centerRenderer );
        table1.getColumnModel().getColumn(4).setCellRenderer( centerRenderer );
    }
    public void defaultValues() {
        textField2.setText("");
        textField3.setText("");
        textField4.setText("");
        textField5.setText("Barcode");
        textField7.setText("0");
        textField8.setText("0");
    }
    public void refresh(){
        iModel.rsetGetAll();
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
                            table1.setValueAt("Edit", i, 7);
                        }
                        button.setForeground(Color.black);
                        button3.setText("Update");
                        button3.setForeground(Color.RED);
                        label = "Stop Editing";
                        fireEditAction();
                        stopCellEditing();
                        table1.getColumn("Click to delete").setCellEditor(table1.getColumn("Item Name").getCellEditor());
                        table1.getColumn("Click to delete").setCellRenderer(new GreyButtonRenderer());
                        table1.getColumn("View Description").setCellEditor(table1.getColumn("Item Name").getCellEditor());
                        table1.getColumn("View Description").setCellRenderer(new GreyButtonRenderer());
                        table1.getColumn("View Stock").setCellEditor(table1.getColumn("Item Name").getCellEditor());
                        table1.getColumn("View Stock").setCellRenderer(new GreyButtonRenderer());
                        button4.setEnabled(false);
                        button5.setEnabled(false);
                        button2.setEnabled(false);
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
                        table1.getColumn("View Description").setCellEditor(new ButtonEditor(new JCheckBox()));
                        table1.getColumn("View Description").setCellRenderer(new ButtonRenderer());
                        table1.getColumn("View Stock").setCellEditor(new ButtonEditor(new JCheckBox()));
                        table1.getColumn("View Stock").setCellRenderer(new ButtonRenderer());
                        button4.setEnabled(true);
                        button5.setEnabled(true);
                        button2.setEnabled(true);
                        table1.repaint();
                    }
                    else if(label.equals("Delete")) {
                        stopCellEditing();
                        String name = ((DefaultTableModel) table1.getModel()).getValueAt(selectedRow, 0).toString();
                        int n= JOptionPane.showConfirmDialog(
                                null,
                                "Are you sure you want to delete the menu item "+name+"?",
                                "Confirmation",
                                JOptionPane.YES_NO_OPTION);
                        if (n == JOptionPane.YES_OPTION){
                            fireDeleteAction();
                        }
                    } else if(label.equals("View/Edit")) {
                        System.out.print("meh myFrame.fireMenuScreen();");
                    } else {
                        //myFrame.fireStockScreen();
                    }
                }
            });
        }
        public void fireEditAction(){
            textField2.setText(((DefaultTableModel) table1.getModel()).getValueAt(selectedRow, 0).toString());
            textField3.setText(((DefaultTableModel) table1.getModel()).getValueAt(selectedRow, 1).toString());
            textField4.setText(((DefaultTableModel) table1.getModel()).getValueAt(selectedRow, 2).toString());
            textField5.setText(((DefaultTableModel) table1.getModel()).getValueAt(selectedRow,3).toString());
            textField7.setText(((DefaultTableModel) table1.getModel()).getValueAt(selectedRow,4).toString());
            textField8.setText(((DefaultTableModel) table1.getModel()).getValueAt(selectedRow,5).toString());
        }
        public void fireDeleteAction(){
            iModel.deleteItem(((DefaultTableModel) table1.getModel()).getValueAt(selectedRow, 3).toString());
            ((DefaultTableModel)table1.getModel()).removeRow(selectedRow);
        }
    }
    JPanel mainPanel = new JPanel();
    JPanel panel1 = new JPanel();
    JTable table1 = new JTable();
    JPanel panel2 = new JPanel();
    JPanel panel3 = new JPanel();
    JLabel label1 = new JLabel();
    JScrollPane scrollPane1 = new JScrollPane();
    JScrollPane scrollPane2 = new JScrollPane();
    JButton button1 = new JButton();
    JButton button3 = new JButton();
    JButton button4 = new JButton();
    JButton button5 = new JButton();
    JButton button2 = new JButton();
    JTextField textField3 = new JTextField();
    JTextField textField2 = new JTextField();
    JTextField textField6 = new JTextField();
    JTextField textField4 = new JTextField();
    JTextField textField5 = new JTextField();
    JTextField textField7 = new JTextField();
    JTextField textField8 = new JTextField();
    JComboBox comboBox1 = new JComboBox();
}
