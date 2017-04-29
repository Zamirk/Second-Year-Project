package GUI.Manager;
//****************************
//Created by Zamir on 16/03/2015.  
//****************************

import Database.Operations.Operations;
import GUI.Special.CellToButton;
import GUI.Special.GreyedOutButtons;
import Model.Books.Employee;
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
public class EmployeeManagementGUI extends JPanel implements CellToButton, GreyedOutButtons, VALHALA {
    Employee eModel;
    public EmployeeManagementGUI(Operations o) {
        eModel = new Employee(o);
        initComponents();
        eModel.rsetGetAll();
        setModelData();
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
        panel1.setSize(1400, 640);
        panel1.add(label1);

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
        panel2.add(textField4);
        panel2.add(textField5);
        panel2.add(textField6);
        panel2.add(textField3);
        panel2.add(comboBox1);
        panel2.add(comboBox2);

        panel3.add(scrollPane2);
        panel3.add(button1);

        //---- label1 ----
        label1.setText("Employee Management");
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
        textField2.setFont(textField2.getFont().deriveFont(textField2.getFont().getSize() + 6f));
        textField2.setEditable(false);
        textField2.setText("Customer ID");
        textField2.setBounds(115, 8, 146, 22);

        //---- button4 ----
        button4.setText("Search");
        button4.setBorder(new CompoundBorder(LineBorder.createBlackLineBorder(), null));
        button4.setOpaque(false);
        button4.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        button4.setBounds(978, 40, 281, 25);

        //---- textField6 ----
        textField6.setBorder(new MatteBorder(1, 1, 1, 1, Color.black));
        PromptSupport.setPrompt("Enter Search", textField6);
        textField6.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        textField6.setBounds(398, 40, 285, 22);

        //---- textField3 ----
        textField3.setBorder(new MatteBorder(1, 1, 1, 1, Color.black));
        textField3.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        PromptSupport.setPrompt("Enter Firstname", textField3);
        textField3.setBounds(262, 8, 135, 22);

        //---- textField4 ----
        textField4.setBorder(new MatteBorder(1, 1, 1, 1, Color.black));
        textField4.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        PromptSupport.setPrompt("Enter Lastname", textField4);
        textField4.setBounds(400, 8, 137, 22);

        //---- textField5 ----
        textField5.setBorder(new MatteBorder(1, 1, 1, 1, Color.black));
        textField5.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        PromptSupport.setPrompt("Enter Password", textField5);
        textField5.setBounds(541, 8, 140, 22);

        //---- button3 ----
        button3.setText("Add");
        button3.setBorder(new CompoundBorder(LineBorder.createBlackLineBorder(), null));
        button3.setOpaque(false);
        button3.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        button3.setBounds(842, 8, 150, 22);

        //---- button3 ----
        button5.setText("Display All");
        button5.setBorder(new CompoundBorder(LineBorder.createBlackLineBorder(), null));
        button5.setOpaque(false);
        button5.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        button5.setBounds(992, 8, 285, 22);

        //---- comboBox1 ----
        comboBox1.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        comboBox1.setModel(new DefaultComboBoxModel(new String[]{
                "Employee Id","First Name","Last Name","Password","Position"
        }));
        comboBox1.setBounds(688, 40, 285, 22);

        comboBox2.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        comboBox2.setModel(new DefaultComboBoxModel(new String[]{
                "Manager",
                "Employee"
        }));
        comboBox2.setBounds(688, 8, 285, 22);

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
                animatedFrame.t22go();
            }
        });
        button3.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e)
            {
                String position = comboBox2.getSelectedItem().toString();
                eModel.insertEmployee(
                        textField3.getText(),
                        textField4.getText(),
                        textField5.getText(),
                        position);
                setModelData();
                textField3.setText("");
                textField4.setText("");
                textField5.setText("");
            }
        });
        button4.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e)
            {
                String column = "";
                if (comboBox1.getSelectedItem().toString().equals("Employee Id")) {
                    column = "StaffID";
                } else if (comboBox1.getSelectedItem().toString().equals("First Name")) {
                    column = "FName";
                } else if (comboBox1.getSelectedItem().toString().equals("Last Name")) {
                    column = "LName";
                } else if (comboBox1.getSelectedItem().toString().equals("Password")) {
                    column = "Password";
                } else if (comboBox1.getSelectedItem().toString().equals("Position")) {
                    column = "Position";
                }
                eModel.searchEmployees(column, textField6.getText());
                setModelData();
            }
        });
        button5.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e)
            {
                eModel.rsetGetAll();
                setModelData();
            }
        });
    }
    private void setModelData() {
        table1.setModel(eModel.getTableModel());
        //Rendering as buttons
        table1.getColumn("Click to Delete").setCellRenderer(new ButtonRenderer());
        table1.getColumn("Click to Delete").setCellEditor(new ButtonEditor(new JCheckBox()));
        //Columns Sized
        //Centring
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        table1.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        table1.getColumnModel().getColumn(1).setCellRenderer( centerRenderer );
        table1.getColumnModel().getColumn(2).setCellRenderer( centerRenderer );
        table1.getColumnModel().getColumn(3).setCellRenderer( centerRenderer );
        table1.getColumnModel().getColumn(4).setCellRenderer( centerRenderer );
    }
    public void refresh(){
        eModel.rsetGetAll();
        setModelData();
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
                    if (label.equals("Delete")) {
                        stopCellEditing();
                        String name = ((DefaultTableModel) table1.getModel()).getValueAt(selectedRow, 1).toString();
                        String position = ((DefaultTableModel) table1.getModel()).getValueAt(selectedRow, 4).toString();
                        int n = JOptionPane.showConfirmDialog(
                                null,
                                "Are you sure you want to delete the "+position+" "+ name +" from the system?\n" +
                                        "Warning. They will no longer be able to login.",
                                "Confirmation",
                                JOptionPane.YES_NO_OPTION);
                        if (n == JOptionPane.YES_OPTION) {
                            fireDeleteAction();
                        }
                    }
                }
            });
        }
        private void fireDeleteAction() {
            eModel.deleteEmployee(((DefaultTableModel) table1.getModel()).getValueAt(selectedRow, 0).toString());
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
    JTextField textField2 = new JTextField();
    JTextField textField3 = new JTextField();
    JTextField textField4 = new JTextField();
    JTextField textField5 = new JTextField();
    JTextField textField6 = new JTextField();
    JComboBox comboBox1 = new JComboBox();
    JComboBox comboBox2 = new JComboBox();
}

