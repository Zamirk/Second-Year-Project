package GUI.Employee;

import Database.Operations.Operations;
import GUI.Special.CellToButton;
import GUI.Special.GreyedOutButtons;
import Model.Books.Stock;
import GUI.Special.VALHALA;
import org.jdesktop.swingx.prompt.PromptSupport;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StockControlGUI extends JPanel implements CellToButton, GreyedOutButtons, VALHALA {
    Stock sModel;
    boolean admin = true;
    public StockControlGUI(Operations o) {
        sModel = new Stock(o);
        initComponents();
        sModel.rsetMenuAndRatings();
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
        panel1.add(label1);

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

        label1.setText("Stock Control");
        label1.setBackground(new Color(255, 255, 102));
        label1.setFont(new Font("TimesRoman", Font.PLAIN, 20));

        table1.setPreferredScrollableViewportSize(new Dimension(700, 800));
        table1.setFillsViewportHeight(true);
        table1.setRowHeight(30);
        table1.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        table1.setBackground(new Color(222, 222, 222));
        table1.setOpaque(false);
        table1.setBorder(null);
        table1.setGridColor(Color.lightGray);
        table1.setGridColor(new Color(176, 176, 176));
        scrollPane1.setOpaque(false);
        scrollPane1.getViewport().setBackground(new Color(145, 178, 239));
        scrollPane1.setViewportView(table1);
        scrollPane1.setBounds(116, 116, 1180, 520);
        scrollPane1.setBorder(BorderFactory.createEmptyBorder());

        label1.setText("Stock Management");
        label1.setFont(new Font("TimesRoman", Font.PLAIN, 48));
        label1.setLocation(470, 40);
        label1.setSize(label1.getPreferredSize());

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
                if(admin==true){
                    animatedFrame.t19go();
                }else{
                    animatedFrame.t42go();
                }
            }
        });
        button4.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e)
            {
                sModel.searchStock(comboBox1.getSelectedItem().toString(),textField6.getText());
                setModelData();
            }
        });
        button5.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e)
            {
                sModel.rsetMenuAndRatings();
                setModelData();
            }
        });
    }
    private void setModelData() {
        table1.setModel(sModel.getTableModel());
        //Rendering as buttons
        table1.getColumn("Add Stock").setCellRenderer(new ButtonRenderer());
        table1.getColumn("Add Stock").setCellEditor(new ButtonEditor(new JCheckBox()));
        table1.getColumn("Remove Stock").setCellRenderer(new ButtonRenderer());
        table1.getColumn("Remove Stock").setCellEditor(new ButtonEditor(new JCheckBox()));
        table1.getColumn("Update Stock").setCellRenderer(new ButtonRenderer());
        table1.getColumn("Update Stock").setCellEditor(new ButtonEditor(new JCheckBox()));
        //Columns Sized
        //Centring text
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        table1.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        table1.getColumnModel().getColumn(1).setCellRenderer( centerRenderer );
        table1.getColumnModel().getColumn(2).setCellRenderer( centerRenderer );
        table1.getColumnModel().getColumn(3).setCellRenderer( centerRenderer );
        table1.getColumnModel().getColumn(7).setCellRenderer( centerRenderer );
    }
    public void setAsEmployee(){
        admin = false;
    }
    public void setAsAdmin(){
        admin = true;
    }
    public void refresh(){
        sModel.rsetMenuAndRatings();
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
                    if(label.equals("Add Stock")) {
                        stopCellEditing();
                        int currentStock = Integer.parseInt((table1.getValueAt(selectedRow, 3).toString()));
                        int addition = Integer.parseInt((table1.getValueAt(selectedRow, 7).toString()));
                        String barcode = table1.getValueAt(selectedRow, 1).toString();
                        sModel.addStock(currentStock,addition,barcode);
                        sModel.rsetMenuAndRatings();
                        setModelData();
                    }
                    else if(label.equals("Remove Stock")){
                        stopCellEditing();
                        int currentStock = Integer.parseInt((table1.getValueAt(selectedRow, 3).toString()));
                        int addition = Integer.parseInt((table1.getValueAt(selectedRow, 7).toString()));
                        String barcode = table1.getValueAt(selectedRow, 1).toString();
                        sModel.removeStock(currentStock, addition, barcode);
                        sModel.rsetMenuAndRatings();
                        setModelData();
                    } else if(label.equals("Update Stock")){
                        stopCellEditing();
                        int newStock = Integer.parseInt((table1.getValueAt(selectedRow, 7).toString()));
                        String barcode = table1.getValueAt(selectedRow, 1).toString();
                        sModel.updateStock(newStock, barcode);
                        sModel.rsetMenuAndRatings();
                        setModelData();
                    } else if(label.equals("Add All Stock")){
                        stopCellEditing();
                        int rows_count = table1.getRowCount();
                        for(int i = 0; i < rows_count-1; i++){
                            int currentStock = Integer.parseInt((table1.getValueAt(i, 3).toString()));
                            int addition = Integer.parseInt((table1.getValueAt(i, 7).toString()));
                            String barcode = table1.getValueAt(i, 1).toString();
                            sModel.addStock(currentStock,addition, barcode);
                        }
                        sModel.rsetMenuAndRatings();
                        setModelData();
                    } else if(label.equals("Remove All Stock")){
                        stopCellEditing();
                        int rows_count = table1.getRowCount();
                        for(int i = 0; i < rows_count-1; i++){
                            int currentStock = Integer.parseInt((table1.getValueAt(i, 3).toString()));
                            int addition = Integer.parseInt((table1.getValueAt(i, 7).toString()));
                            String barcode = table1.getValueAt(i, 1).toString();
                            sModel.removeStock(currentStock, addition, barcode);
                        }
                        sModel.rsetMenuAndRatings();
                        setModelData();
                    } else if(label.equals("Update All Stock")){
                        stopCellEditing();
                        int rows_count = table1.getRowCount();
                        for(int i = 0; i < rows_count-1; i++){
                            int newStock = Integer.parseInt((table1.getValueAt(i, 7).toString()));
                            String barcode = table1.getValueAt(i, 1).toString();
                            sModel.updateStock(newStock, barcode);
                        }
                        sModel.rsetMenuAndRatings();
                        setModelData();
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
}
