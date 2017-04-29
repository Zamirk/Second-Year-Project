package GUI.Employee;

import Database.Operations.Operations;
import GUI.Special.CellToButton;
import GUI.Special.GreyedOutButtons;
import Model.Books.Feedback;
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

public class FeedbackManagementGUI extends JPanel implements CellToButton, GreyedOutButtons, VALHALA{
    Feedback fModel;
    boolean admin = true;
    public FeedbackManagementGUI(Operations o) {
        fModel = new Feedback(o);
        initComponents();
        fModel.rsetGetAll();
        setModelData();
    }
    public void refresh(){
        fModel.rsetGetAll();
        setModelData();
    }
    private void setModelData() {
        table1.setModel(fModel.getTableModel());
        //Rendering as buttons
        table1.getColumn("Delete").setCellRenderer(new ButtonRenderer());
        table1.getColumn("Delete").setCellEditor(new ButtonEditor(new JCheckBox()));
        table1.getColumn("View").setCellRenderer(new ButtonRenderer());
        table1.getColumn("View").setCellEditor(new ButtonEditor(new JCheckBox()));
        //Columns Sized
        table1.getColumnModel().getColumn(4).setMaxWidth(100);
        table1.getColumnModel().getColumn(3).setMaxWidth(100);
        //Centring text
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        table1.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        table1.getColumnModel().getColumn(1).setCellRenderer( centerRenderer );
        table1.getColumnModel().getColumn(2).setCellRenderer( centerRenderer );
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
        panel1.add(feedback);

        panel2.add(button3);
        panel2.add(button4);
        panel2.add(button5);
        panel2.add(textField2);
        panel2.add(textField4);
        panel2.add(textField5);
        panel2.add(textField6);
        panel2.add(comboBox1);

        panel3.add(scrollPane2);
        panel3.add(button1);

        label1.setText("Customer Feedback");
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
        scrollPane1.setBounds(116, 116, 800, 520);
        scrollPane1.setBorder(BorderFactory.createEmptyBorder());

        feedback.setLocation(920,116);
        feedback.setSize(380, 300);
        feedback.setEditable(false);
        feedback.setText("Feedback");
        feedback.setFont(new Font("TimesRoman", Font.PLAIN, 30));
        feedback.setCaretPosition(feedback.getDocument().getLength());
        feedback.setWrapStyleWord(true);
        feedback.setCaretPosition(feedback.getDocument().getLength());
        feedback.setLineWrap(true);
        feedback.setWrapStyleWord(true);
        //---- button4 ----
        button4.setText("Search");
        button4.setBorder(new CompoundBorder(LineBorder.createBlackLineBorder(), null));
        button4.setOpaque(false);
        button4.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        button4.setBounds(878, 8, 185, 22);

        //---- comboBox1 ----
        comboBox1.setModel(new DefaultComboBoxModel(new String[] {
                "Barcode",
        }));
        comboBox1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        comboBox1.setBounds(687, 8, 185, 22);

        //---- textField6 ----
        textField6.setBorder(new MatteBorder(1, 1, 1, 1, Color.black));
        PromptSupport.setPrompt("Enter Search", textField6);
        textField6.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        textField6.setBounds(495, 8, 185, 22);

        //---- button5 ----
        button5.setText("Display All");
        button5.setBorder(new CompoundBorder(LineBorder.createBlackLineBorder(), null));
        button5.setOpaque(false);
        button5.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        button5.setBounds(1071, 8, 185, 22);

        //---- button1 ----
        button1.setIcon(new ImageIcon("Assets/Back.png"));
        button1.setAlignmentY(0.0F);
        button1.setContentAreaFilled(false);
        button1.setBorderPainted(false);
        button1.setRolloverIcon(new ImageIcon("Assets/Hover/Back.png"));
        button1.setPressedIcon(new ImageIcon("Assets/Press/Back.png"));
        button1.setSize(250,150);
        button1.setLocation(150,0);

        button1.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e)
            {
                {   if(admin==true){
                    animatedFrame.t23go();
                }else{
                    animatedFrame.t42go();
                }
                }
            }
        });
        button5.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e)
            {
                fModel.rsetGetAll();
                setModelData();
            }
        });
    }
    public void setAsEmployee(){
        admin = false;
    }
    public void setAsAdmin(){
        admin = true;
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
                    String orderId = ((DefaultTableModel) table1.getModel()).getValueAt(selectedRow, 0).toString();
                    if (label.equals("Delete")) {
                        stopCellEditing();
                        int n = JOptionPane.showConfirmDialog(
                                null,
                                "Are you sure you want to delete the feedback for order " + orderId + "?",
                                "Confirmation",
                                JOptionPane.YES_NO_OPTION);
                        if (n == JOptionPane.YES_OPTION) {
                            fModel.deleteFeedback(((DefaultTableModel) table1.getModel()).getValueAt(selectedRow, 0).toString());
                            ((DefaultTableModel)table1.getModel()).removeRow(selectedRow);
                        }
                    }else if (label.equals("View")) {
                        String feedbackText = "Feedback for "+orderId+"\n"+((DefaultTableModel) table1.getModel()).getValueAt(selectedRow, 2).toString();
                        feedback.setText(feedbackText);
                    }
                }
            });
        }
    }
    JPanel mainPanel = new JPanel();
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    JPanel panel3 = new JPanel();
    JTable table1 = new JTable();
    JLabel label1 = new JLabel();
    JScrollPane scrollPane1 = new JScrollPane();
    JScrollPane scrollPane2 = new JScrollPane();
    JButton button1 = new JButton();
    JButton button3 = new JButton();
    JButton button4 = new JButton();
    JButton button5 = new JButton();
    JTextField textField2 = new JTextField();
    JTextField textField6 = new JTextField();
    JTextField textField4 = new JTextField();
    JTextField textField5 = new JTextField();
    JComboBox comboBox1 = new JComboBox();
    JTextArea feedback = new JTextArea();
}
